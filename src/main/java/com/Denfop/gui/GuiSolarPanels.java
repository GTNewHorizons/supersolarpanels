package com.Denfop.gui;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.api.module.IModulGenDay;
import com.Denfop.api.module.IModulGenNight;
import com.Denfop.api.module.IModulOutput;
import com.Denfop.api.module.IModulPanel;
import com.Denfop.api.module.IModulStorage;
import com.Denfop.api.module.IModuleType;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.container.ContainerSolarPanels;
import com.Denfop.container.ContainerSinSolarPanel;
import com.Denfop.item.Modules.ItemWirelessModule;
import com.Denfop.item.Modules.ModuleType;
import com.Denfop.item.Modules.ModuleTypePanel;
import com.Denfop.item.Modules.AdditionModule;
import com.Denfop.item.Modules.BaseModuleGenDay;
import com.Denfop.item.Modules.BaseModuleGenNight;
import com.Denfop.item.Modules.BaseModuleOutput;
import com.Denfop.item.Modules.BaseModuleStorage;
import com.Denfop.tiles.NeutroniumGenerator.TileneutronGenerator;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.utils.ModUtils;
import com.Denfop.utils.NBTData;

import ic2.core.IC2;
import ic2.core.network.NetworkManager;
import ic2.core.util.GuiTooltipHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

import org.lwjgl.opengl.GL11;

public class GuiSolarPanels extends GuiContainer {
	public TileEntitySolarPanel tileentity;

	public GuiSolarPanels(ContainerSolarPanels container) {
		super((Container) container);
		this.tileentity = container.tileentity;
		this.allowUserInput = false;
		this.xSize = 194;
		this.ySize = 238;
	}

	public static double roundAvoid(double value, int places) {
		double scale = Math.pow(10.0D, places);
		return Math.round(value * scale) / scale;
	}

	public void initGui() {
		super.initGui();
		this.buttonList.add(new GuiButton(0, (this.width - this.xSize) / 2 + 68, (this.height - this.ySize) / 2 + 39,
				58, 20, I18n.format("button.rf")));

	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		String formatPanelName = I18n.format(this.tileentity.panelName, new Object[0]);
		int nmPos = (this.xSize - this.fontRendererObj.getStringWidth(formatPanelName)) / 2;
		this.fontRendererObj.drawString(formatPanelName, nmPos, 4, 7718655);
		String storageString = I18n.format("gui.SuperSolarPanel.storage", new Object[0]) + ": ";
		String maxOutputString = I18n.format("gui.SuperSolarPanel.maxOutput", new Object[0]) + ": ";
		String generatingString = I18n.format("gui.SuperSolarPanel.generating", new Object[0]) + ": ";
		String energyPerTickString = I18n.format("gui.SuperSolarPanel.energyPerTick", new Object[0]);
		String energyPerTickString1 = I18n.format("gui.SuperSolarPanel.energyPerTick1", new Object[0]);
		String tierString = I18n.format("gui.ssp.tier", new Object[0]) + ": ";
		String ModulesString = I18n.format("ssp.genday", new Object[0]);
		String ModulesString1 = I18n.format("ssp.gennight", new Object[0]);
		String ModulesString2 = I18n.format("ssp.storage", new Object[0]);
		String ModulesString3 = I18n.format("ssp.output", new Object[0]);
		String ModulesString4 = I18n.format("ssp.tier1", new Object[0]);
		String ModulesString5 = I18n.format("ssp.tier2", new Object[0]);
		String ModulesString6 = I18n.format("ssp.moduletype1", new Object[0]);
		String ModulesString61 = I18n.format("ssp.moduletype2", new Object[0]);
		String ModulesString62 = I18n.format("ssp.moduletype3", new Object[0]);
		String ModulesString63 = I18n.format("ssp.moduletype4", new Object[0]);
		String ModulesString64 = I18n.format("ssp.moduletype5", new Object[0]);
		String ModulesString65 = I18n.format("ssp.moduletype6", new Object[0]);
		String ModulesString66 = I18n.format("ssp.moduletype7", new Object[0]);
		String ModulesString7 = I18n.format("ssp.rfmodule", new Object[0]);
		String ModulesString71 = I18n.format("ssp.rfmodule1", new Object[0]);
		String rfstorageString = I18n.format("ssp.rfstorage", new Object[0]);
		String ModulesString8 = I18n.format("ssp.modulewirelles", new Object[0]);
		String ModulesString9 = I18n.format("ssp.modulewirelles1", new Object[0]);
		String ModulesString10 = I18n.format("ssp.modulewirelles2", new Object[0]);

		double tierplus = 0;
		double minus = 0;
		for (int i = 0; i < 9; i++) {

			if (this.tileentity.chargeSlots[i] != null
					&& this.tileentity.chargeSlots[i].getItem() instanceof com.Denfop.item.Modules.AdditionModule) {
				int kk = this.tileentity.chargeSlots[i].getItemDamage();
				if (kk == 1) {
					tierplus++;
				} else if (kk == 2) {
					minus++;
				}
			}
		}
		double c[];
		c = new double[9];
		double d[];
		d = new double[9];
		for (int i = 0; i < 9; i++) {
			if (this.tileentity.chargeSlots[i] != null
					&& this.tileentity.chargeSlots[i].getItem() instanceof IModulPanel) {
				int g = this.tileentity.chargeSlots[i].getItemDamage();
				if (this.tileentity.tier + tierplus - minus >= g + 1) {

					List<Double> list = IModulPanel.getData(this.tileentity.chargeSlots[i]);
					c[i] = list.get(2);
					d[i] = list.get(3);

				}
			}
		}
		double sum1 = 0;
		double sum2 = 0;

		for (int i = 0; i < 9; i++) {
			sum1 = sum1 + c[i];
			sum2 = sum2 + d[i];
		}
		double maxstorage1[];
		maxstorage1 = new double[9];
		double maxstorage_dob = 0;
		for (int j = 0; j < 9; j++) {
			if (this.tileentity.chargeSlots[j] != null
					&& this.tileentity.chargeSlots[j].getItem() instanceof BaseModuleStorage) {
				maxstorage1[j] = BaseModuleStorage.getpercent();
				if (maxstorage1[j] != 0) {
					maxstorage_dob = maxstorage_dob + maxstorage1[j];
				}

			}
		}
		double[] a = new double[4];
		a[0] = ((this.tileentity.p + sum1) + (this.tileentity.p + sum1) * (maxstorage_dob / 100));

		String maxstorage_1 = ModUtils.getString(a[0]);
		String maxstorage_2 = ModUtils.getString(this.tileentity.storage);
		// TODO
		
		String rf = ModUtils.getString(this.tileentity.storage2);
		String rf1 = ModUtils.getString(this.tileentity.maxStorage2);
		String tooltip1 = rfstorageString + rf + "/" + rf1;
		
		if (maxstorage_dob != 0)
			this.fontRendererObj.drawString(ModulesString2 + maxstorage_dob + "%", 15, 182 - 2, 13487565);
		double output[];
		output = new double[9];
		double gend[];
		gend = new double[9];
		double genn[];
		genn = new double[9];
		for (int i = 0; i < 9; i++) {

			if (this.tileentity.chargeSlots[i] != null
					&& this.tileentity.chargeSlots[i].getItem() instanceof BaseModuleOutput) {
				output[i] = BaseModuleOutput.getpercent();

			}
			if (this.tileentity.chargeSlots[i] != null
					&& this.tileentity.chargeSlots[i].getItem() instanceof BaseModuleGenDay) {
				gend[i] = BaseModuleGenDay.percentday();

			}
			if (this.tileentity.chargeSlots[i] != null
					&& this.tileentity.chargeSlots[i].getItem() instanceof BaseModuleGenNight) {
				genn[i] = BaseModuleGenNight.percentnight();

			}

		}
		double output_dob = 0;
		double gend_dob = 0;
		double genn_dob = 0;
		for (int i = 0; i < 9; i++) {
			if (output[i] != 0) {
				output_dob = output_dob + output[i];
			}
			if (gend[i] != 0) {
				gend_dob = gend_dob + gend[i];
			}
			if (genn[i] != 0) {
				genn_dob = genn_dob + genn[i];
			}
		}
		a[1] = ((this.tileentity.u + sum2) + (this.tileentity.u + sum2) * (output_dob / 100));

		this.fontRendererObj.drawString(maxOutputString + ModUtils.getString(a[1]) + " " + energyPerTickString, 50,
				26 - 4 - 12 + 8, 13487565);
		if (output_dob != 0)
			this.fontRendererObj.drawString(ModulesString3 + (output_dob) + "%", 15, 175 - 2, 13487565);

		String generation = ModUtils.getString(this.tileentity.generating);
		String generation1 = ModUtils.getString(this.tileentity.generating * 4);

		String tooltip2 = generatingString + generation + " " + energyPerTickString;
		String tooltip3 = generatingString + generation1 + " " + energyPerTickString1;
		if (this.tileentity.getmodulerf) {

			if (!this.tileentity.rf) {
				GuiTooltipHelper.drawAreaTooltip(par1 - this.guiLeft, par2 - this.guiTop, tooltip2, 18, 40, 43, 58);
			} else {
				GuiTooltipHelper.drawAreaTooltip(par1 - this.guiLeft, par2 - this.guiTop, tooltip3, 160, 40, 185, 58);

			}
		} else {
			GuiTooltipHelper.drawAreaTooltip(par1 - this.guiLeft, par2 - this.guiTop, tooltip2, 18, 40, 43, 58);

		}
		String tooltip = storageString + maxstorage_2 + "/" + maxstorage_1;
		GuiTooltipHelper.drawAreaTooltip(par1 - this.guiLeft, par2 - this.guiTop, tooltip, 18, 24, 43, 38);
		GuiTooltipHelper.drawAreaTooltip(par1 - this.guiLeft, par2 - this.guiTop, tooltip1, 155, 24, 180, 38);
		if (this.tileentity.chargeSlots[8] != null && this.tileentity.chargeSlots[8].getItem() instanceof IModuleType) {

			if (this.tileentity.chargeSlots[8].getItemDamage() == 0)
				this.fontRendererObj.drawString(ModulesString6, 15, 196 - 2, 13487565);
			if (this.tileentity.chargeSlots[8].getItemDamage() == 1)
				this.fontRendererObj.drawString(ModulesString61, 15, 196 - 2, 13487565);
			if (this.tileentity.chargeSlots[8].getItemDamage() == 2)
				this.fontRendererObj.drawString(ModulesString62, 15, 196 - 2, 13487565);
			if (this.tileentity.chargeSlots[8].getItemDamage() == 3)
				this.fontRendererObj.drawString(ModulesString63, 15, 196 - 2, 13487565);
			if (this.tileentity.chargeSlots[8].getItemDamage() == 4)
				this.fontRendererObj.drawString(ModulesString64, 15, 196 - 2, 13487565);
			if (this.tileentity.chargeSlots[8].getItemDamage() == 5)
				this.fontRendererObj.drawString(ModulesString65, 15, 196 - 2, 13487565);
			if (this.tileentity.chargeSlots[8].getItemDamage() == 6)
				this.fontRendererObj.drawString(ModulesString66, 15, 196 - 2, 13487565);

		}
		for (int i = 0; i < 9; i++) {
			if (this.tileentity.chargeSlots[i] != null
					&& this.tileentity.chargeSlots[i].getItem() instanceof AdditionModule) {
				if (this.tileentity.rf)
					if (this.tileentity.chargeSlots[i].getItemDamage() == 4)
						this.fontRendererObj.drawString(ModulesString7, 15, 203 - 2, 13487565);
				if (!this.tileentity.rf)
					if (this.tileentity.chargeSlots[i].getItemDamage() == 4)
						this.fontRendererObj.drawString(ModulesString71, 15, 203 - 2, 13487565);

			}

		}
		for (int i = 0; i < 9; i++) {
			if (this.tileentity.chargeSlots[i] != null
					&& this.tileentity.chargeSlots[i].getItem() instanceof ItemWirelessModule) {
				NBTTagCompound nbttagcompound = NBTData.getOrCreateNbtData(this.tileentity.chargeSlots[i]);

				if (this.tileentity.panelx != 0 && this.tileentity.panely != 0 && this.tileentity.panelz != 0) {
					this.fontRendererObj.drawString(ModulesString8, 15, 209 - 2, 13487565);
					this.fontRendererObj.drawString(ModulesString9 + "X:" + this.tileentity.panelx + " Y:"
							+ this.tileentity.panely + " Z:" + this.tileentity.panelz, 15, 215 - 2, 13487565);

				} else if (this.tileentity.panelx == 0 && this.tileentity.panely == 0 && this.tileentity.panelz == 0)
					this.fontRendererObj.drawString(ModulesString10, 15, 209 - 2, 13487565);

			}

		}

		if (gend_dob != 0 && this.tileentity.sunIsUp)
			this.fontRendererObj.drawString(ModulesString + (gend_dob) + "%", 15, 189 - 2, 13487565);
		if (genn_dob != 0 && !this.tileentity.sunIsUp)
			this.fontRendererObj.drawString(ModulesString1 + (genn_dob) + "%", 15, 189 - 2, 13487565);

		if (tierplus != 0 && tierplus - minus > 0 && this.tileentity.o > 0) {
			this.fontRendererObj.drawString(tierString + ModUtils.getString(this.tileentity.o), 50, 46 - 4 - 12 - 8 + 5,
					13487565);
			this.fontRendererObj.drawString(ModulesString4 + (tierplus - minus), 15, 209 - 2 + 6 + 6, 13487565);
		} else if (minus != 0 && tierplus - minus < 0 && this.tileentity.o > 0) {
			this.fontRendererObj.drawString(tierString + ModUtils.getString(this.tileentity.o), 50, 46 - 4 - 12 - 8 + 5,
					13487565);
			this.fontRendererObj.drawString(ModulesString5 + (minus - tierplus), 15, 209 - 2 + 6 + 6, 13487565);
		} else if (this.tileentity.o > 0) {
			this.fontRendererObj.drawString(tierString + ModUtils.getString(this.tileentity.o), 50, 46 - 4 - 12 - 8 + 5,
					13487565);
		} else if (this.tileentity.o == 0) {
			this.fontRendererObj.drawString(tierString + 0, 50, 46 - 4 - 12, 13487565);
		} else {
			this.fontRendererObj.drawString(tierString + 0, 50, 46 - 4 - 12, 13487565);
		}
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		if (this.tileentity.chargeSlots[8] != null
				&& this.tileentity.chargeSlots[8].getItem() instanceof com.Denfop.item.Modules.ModuleType) {
			int g = this.tileentity.chargeSlots[8].getItemDamage();
			if (g == 0) {
				this.tileentity.solarType = 1;
				if (this.tileentity.yCoord >= 130) {
					this.mc.renderEngine.bindTexture(tex4);
				} else {
					this.mc.renderEngine.bindTexture(tex);
				}
			} else if (g == 1) {
				this.tileentity.solarType = 2;
				if (this.tileentity.yCoord <= 40) {
					this.mc.renderEngine.bindTexture(tex3);
				} else {
					this.mc.renderEngine.bindTexture(tex);
				}
			} else if (g == 2) {
				this.tileentity.solarType = 3;
				if ((this.tileentity.getWorldObj()).provider.dimensionId == -1) {
					this.mc.renderEngine.bindTexture(tex1);
				} else {
					this.mc.renderEngine.bindTexture(tex);
				}
			} else if (g == 3) {
				this.tileentity.solarType = 4;
				if ((this.tileentity.getWorldObj()).provider.dimensionId == 1) {
					this.mc.renderEngine.bindTexture(tex2);
				} else {
					this.mc.renderEngine.bindTexture(tex);
				}
			} else if (g == 4) {
				this.tileentity.solarType = 5;
				this.mc.renderEngine.bindTexture(tex);
			} else if (g == 5) {
				this.tileentity.solarType = 6;
				this.mc.renderEngine.bindTexture(tex);
			} else if (g == 6) {
				this.tileentity.solarType = 7;
				if (this.tileentity.rain) {
					this.mc.renderEngine.bindTexture(tex5);
				} else {
					this.mc.renderEngine.bindTexture(tex);
				}
			} else {
				this.tileentity.solarType = 0;
				this.mc.renderEngine.bindTexture(tex);
			}
		} else {
			this.tileentity.solarType = 0;
			this.mc.renderEngine.bindTexture(tex);
		}
		int h = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		drawTexturedModalRect(h, k, 0, 0, this.xSize, this.ySize);
		if (this.tileentity.storage > 0 || this.tileentity.storage <= this.tileentity.maxStorage) {
			float l = this.tileentity.gaugeEnergyScaled(25.0F);
			drawTexturedModalRect(h + 18, k + 24, 194, 0, (int) (l + 1), 14);
		}
		if (this.tileentity.storage2 > 0 || this.tileentity.storage2 <= this.tileentity.maxStorage2) {
			float l = this.tileentity.gaugeEnergyScaled2(25.0F);

			drawTexturedModalRect(h + 19 + 72 + 40 + 23 + 1, k + 24, 219, 0, (int) (l), 14);
		}
		if (this.tileentity.getmodulerf) {

			if (!this.tileentity.rf) {
				drawTexturedModalRect(h + 40, k + 41, 195, 30, 15, 15);
			} else {
				drawTexturedModalRect(h + 142, k + 42, 210, 30, 15, 15);
			}

		}

		if (this.tileentity.skyIsVisible && this.tileentity.solarType != 3 && this.tileentity.solarType != 4) {
			if (this.tileentity.getmodulerf) {
				if (!this.tileentity.rf) {

					if (this.tileentity.rain == false) {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
						}
					} else {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 225, 15, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 240, 15, 14, 14);
						}
					}

				} else {

					if (this.tileentity.rain == false) {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 195, 46, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 210, 46, 14, 14);
						}
					} else {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 225, 46, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 240, 46, 14, 14);
						}
					}
				}

			} else {
				if (this.tileentity.rain == false) {
					if (this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
					} else if (!this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
					}
				} else {
					if (this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 225, 15, 14, 14);
					} else if (!this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 240, 15, 14, 14);
					}
				}

			}
		}
		if (this.tileentity.solarType == 3 && (this.tileentity.getWorldObj()).provider.dimensionId == -1)
			if (this.tileentity.getmodulerf) {
				if (!this.tileentity.rf) {

					if (this.tileentity.rain == false) {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
						}
					} else {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 225, 15, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 240, 15, 14, 14);
						}
					}

				} else {

					if (this.tileentity.rain == false) {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 195, 46, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 210, 46, 14, 14);
						}
					} else {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 225, 46, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 240, 46, 14, 14);
						}
					}
				}

			} else {
				if (this.tileentity.rain == false) {
					if (this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
					} else if (!this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
					}
				} else {
					if (this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 225, 15, 14, 14);
					} else if (!this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 240, 15, 14, 14);
					}
				}

			}

		if (this.tileentity.solarType == 4 && (this.tileentity.getWorldObj()).provider.dimensionId == 1)
			if (this.tileentity.getmodulerf) {
				if (!this.tileentity.rf) {

					if (this.tileentity.rain == false) {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
						}
					} else {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 225, 15, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 24, k + 42, 240, 15, 14, 14);
						}
					}

				} else {

					if (this.tileentity.rain == false) {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 195, 46, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 210, 46, 14, 14);
						}
					} else {
						if (this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 225, 46, 14, 14);
						} else if (!this.tileentity.sunIsUp) {
							drawTexturedModalRect(h + 160, k + 42, 240, 46, 14, 14);
						}
					}
				}

			} else {
				if (this.tileentity.rain == false) {
					if (this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
					} else if (!this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
					}
				} else {
					if (this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 225, 15, 14, 14);
					} else if (!this.tileentity.sunIsUp) {
						drawTexturedModalRect(h + 24, k + 42, 240, 15, 14, 14);
					}
				}

			}

	}

	protected void actionPerformed(GuiButton guibutton) {
		super.actionPerformed(guibutton);
		if (guibutton.id == 0)
			((NetworkManager) IC2.network.get()).initiateClientTileEntityEvent((TileEntity) this.tileentity, 0);
	}

	private static ResourceLocation tex = new ResourceLocation("supersolarpanel",
			"textures/gui/GUIAdvancedSolarPanel.png");

	private static ResourceLocation tex1 = new ResourceLocation("supersolarpanel",
			"textures/gui/GUInetherSolarPanel.png");

	private static ResourceLocation tex2 = new ResourceLocation("supersolarpanel", "textures/gui/GUIendSolarPanel.png");

	private static ResourceLocation tex3 = new ResourceLocation("supersolarpanel",
			"textures/gui/GUIearthSolarPanel.png");

	private static ResourceLocation tex4 = new ResourceLocation("supersolarpanel", "textures/gui/GUIaerSolarPanel.png");

	private static ResourceLocation tex5 = new ResourceLocation("supersolarpanel",
			"textures/gui/GUIrainSolarPanel.png");
}