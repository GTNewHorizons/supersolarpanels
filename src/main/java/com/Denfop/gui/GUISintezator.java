
package com.Denfop.gui;

import org.lwjgl.opengl.GL11;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.api.IPanel;
import com.Denfop.container.ContainerSinSolarPanel;
import com.Denfop.integration.Avaritia.ItemAvaritiaSolarPanel;
import com.Denfop.integration.Botania.ItemBotSolarPanel;
import com.Denfop.integration.DE.ItemDESolarPanel;
import com.Denfop.item.Modules.ModuleTypePanel;
import com.Denfop.item.base.ItemSSPSolarPanel;
import com.Denfop.tiles.base.TileSintezator;
import com.Denfop.utils.ModUtils;
import com.Denfop.utils.NBTData;

import ic2.core.util.GuiTooltipHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GUISintezator extends GuiContainer {

	private static ResourceLocation tex;
	private final ContainerSinSolarPanel container;

	public GUISintezator(ContainerSinSolarPanel container) {
		super((Container) container);
		this.container = container;
		this.allowUserInput = false;
		this.xSize = 194;
		this.ySize = 168;
	}

	protected void drawGuiContainerForegroundLayer(final int par1, final int par2) {
		final String formatPanelName = I18n.format(this.container.base.getInventoryName(), new Object[0]);
		final int nmPos = (this.xSize - this.fontRendererObj.getStringWidth(formatPanelName)) / 2;
		this.fontRendererObj.drawString(formatPanelName, nmPos, 7, 7718655);
		final String storageString = I18n.format("gui.SuperSolarPanel.storage", new Object[0]) + ": ";
		final String maxOutputString = I18n.format("gui.SuperSolarPanel.maxOutput", new Object[0]) + ": ";
		final String generatingString = I18n.format("gui.SuperSolarPanel.generating", new Object[0]) + ": ";
		final String energyPerTickString = I18n.format("gui.SuperSolarPanel.energyPerTick", new Object[0]);

		double[] myArray2 = new double[10];
		double[] myArray3 = new double[10];
		for (int i = 0; i < 10; i++) {
			if (this.container.tileentity.chargeSlots[i] != null
					&& this.container.tileentity.chargeSlots[i].getItem() instanceof IPanel) {
				ItemStack itemstack = this.container.tileentity.chargeSlots[i];
				int meta = itemstack.getMaxDamage();
				NBTTagCompound nbt = NBTData.getOrCreateNbtData(itemstack);

				double storage = nbt.getDouble("basestorage");
				double output = nbt.getDouble("output");

				int p = this.container.tileentity.chargeSlots[i].stackSize;
				if (p <= Config.limit) {

					myArray2[i] = storage * p;
					myArray3[i] = output * p;

				} else {

					myArray2[i] = storage * Config.limit;
					myArray3[i] = output * Config.limit;

				}
			}
		}

		double sum2 = 0;
		double sum3 = 0;
		for (int i = 0; i < 9; i++) {
			sum2 = sum2 + myArray2[i];
			sum3 = sum3 + myArray3[i];

		}

		String tierString = I18n.format("gui.ssp.tier", new Object[0]) + ": ";
		String maxstorage_1 = ModUtils.getString(sum2);
		String maxstorage_2 = ModUtils.getString(this.container.tileentity.storage);
		String tooltip = storageString + maxstorage_2 + "/" + maxstorage_1;
		GuiTooltipHelper.drawAreaTooltip(par1 - this.guiLeft, par2 - this.guiTop, tooltip, 18, 24, 43, 38);
		String output = ModUtils.getString(sum3);
		this.fontRendererObj.drawString(maxOutputString + output + (" " + energyPerTickString), 50, 32 - 10, 13487565);
		this.fontRendererObj.drawString(tierString + this.container.tileentity.machineTire, 50, 32, 13487565);
		String generation = ModUtils.getString(this.container.tileentity.generating);

		String tooltip2 = generatingString + generation + " " + energyPerTickString;
		GuiTooltipHelper.drawAreaTooltip(par1 - this.guiLeft, par2 - this.guiTop, tooltip2, 18, 40, 43, 58);
	}

	protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int j) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(GUISintezator.tex);
		final int h = (this.width - this.xSize) / 2;
		final int k = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(h, k, 0, 0, this.xSize, this.ySize);
		if (this.container.tileentity.storage > 0
				|| this.container.tileentity.storage <= this.container.tileentity.maxStorage) {
			final double l = this.container.tileentity.gaugeEnergyScaled(24);

			this.drawTexturedModalRect(h + 19, k + 24, 195, 0, (int) (l + 1), 14);
		}
		if (!this.container.tileentity.rain) {
			if (this.container.tileentity.sunIsUp) {
				drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
			} else if (!this.container.tileentity.sunIsUp) {
				drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
			}
		} else {
			if (this.container.tileentity.sunIsUp) {
				drawTexturedModalRect(h + 24, k + 42, 225, 15, 14, 14);
			} else if (!this.container.tileentity.sunIsUp) {
				drawTexturedModalRect(h + 24, k + 42, 240, 15, 14, 14);
			}
		}

	}

	static {
		GUISintezator.tex = new ResourceLocation("supersolarpanel", "textures/gui/GUI_Sintezator_Slots.png");
	}
}
