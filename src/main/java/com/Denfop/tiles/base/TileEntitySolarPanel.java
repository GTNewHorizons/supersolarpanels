
package com.Denfop.tiles.base;

import cofh.api.energy.IEnergyReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.nbt.NBTTagCompound;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.Event;
import ic2.api.energy.event.EnergyTileLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import java.util.Random;
import java.util.Vector;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.api.IPanel;
import com.Denfop.api.module.IModulGenDay;
import com.Denfop.api.module.IModulGenNight;
import com.Denfop.api.module.IModulOutput;
import com.Denfop.api.module.IModulPanel;
import com.Denfop.api.module.IModulStorage;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.container.ContainerSolarPanels;
import com.Denfop.container.ContainerSinSolarPanel;
import com.Denfop.integration.GC.ExtraPlanetsIntegration;
import com.Denfop.integration.GC.GalacticraftIntegration;
import com.Denfop.integration.GC.GalaxySpaceIntegration;
import com.Denfop.integration.GC.MorePlanetsIntegration;
import com.Denfop.item.Modules.ItemWirelessModule;
import com.Denfop.item.Modules.ModuleGenerationDay;
import com.Denfop.item.Modules.ModuleGenerationNight;
import com.Denfop.item.Modules.ModuleStorage;
import com.Denfop.item.Modules.ModuleOutput;
import com.Denfop.item.Modules.ModuleType;
import com.Denfop.item.Modules.ModuleTypePanel;
import com.Denfop.item.Modules.AdditionModule;
import com.Denfop.utils.NBTData;
import com.mojang.authlib.GameProfile;

import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.IEnergyHandler;
import ic2.api.network.INetworkUpdateListener;
import ic2.api.network.INetworkClientTileEntityEventListener;
import ic2.api.network.INetworkDataProvider;
import net.minecraft.inventory.IInventory;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.tile.IWrenchable;
import ic2.core.ContainerBase;
import ic2.core.IC2;
import ic2.core.block.personal.IPersonalBlock;
import ic2.core.init.MainConfig;
import ic2.core.network.NetworkManager;
import ic2.core.util.ConfigUtil;
import ic2.core.util.StackUtil;
import ic2.api.energy.tile.IEnergyTile;

public class TileEntitySolarPanel extends TileEntityBase
		implements IEnergyTile, INetworkDataProvider, INetworkUpdateListener, IWrenchable, IEnergySource, IInventory,
		IEnergyHandler, INetworkClientTileEntityEventListener, IEnergyReceiver {
	private TileEntitySolarPanel tileentity;
	public static Random randomizer;
	public int ticker;
	public double generating;
	public double genDay;
	public double genNight;
	public boolean initialized;
	public boolean sunIsUp;
	public boolean skyIsVisible;
	private short facing;
	private boolean noSunWorld;
	public boolean wetBiome;
	private int machineTire;
	public boolean addedToEnergyNet;
	private boolean created;
	public int fuel;
	public boolean personality = false;
	private int lastX;
	private int lastY;
	private int lastZ;
	public double storage;
	public int solarType;
	public String panelName;
	public double production;
	public double maxStorage;
	public double p;
	public boolean loaded;
	public double k;
	public double m;
	public double u;
	private ModuleTypePanel panel;
	public double tier;

	public int convertState = 0;
	public int elapsedTicks;
	public boolean changesolartype = false;

	public int panelx = 0;
	public int panely = 0;
	public int panelz = 0;

	public int outputEnergyBuffer;

	public long lastTimeStamp;

	public boolean getmodulerf = false;

	public int inputEnergyBuffer;
	public String player = null;

	public ItemStack[] chargeSlots;

	public double o;
	public int storage2;
	public boolean rain;
	public int tickRate = 40;

	public int maxStorage2;
	public int tickRateFlush = 5;

	public TileEntitySolarPanel(final String gName, final int tier, final int typeSolar, final double gDay,
			final double gNight, final double gOutput, final double gmaxStorage) {

		this.loaded = false;
		this.created = false;
		this.facing = 2;
		this.solarType = typeSolar;
		this.genDay = gDay;
		this.genNight = gNight;
		this.storage = 0;
		this.panelName = gName;
		this.sunIsUp = false;
		this.skyIsVisible = false;
		this.maxStorage = gmaxStorage;
		this.p = gmaxStorage;
		this.k = gDay;
		this.m = gNight;
		if (this.maxStorage <= 2000000000)
			this.maxStorage2 = (int) this.maxStorage;
		else
			this.maxStorage2 = 2000000000;
		this.initialized = false;
		this.production = gOutput;
		this.u = gOutput;

		this.ticker = TileEntitySolarPanel.randomizer.nextInt(this.tickRate());
		this.lastX = this.xCoord;
		this.lastY = this.yCoord;
		this.lastZ = this.zCoord;
		this.machineTire = (int) this.o;
		this.tier = tier;
		this.rain = false;

		this.chargeSlots = new ItemStack[10];

	}

	private int ticksSinceSync;

	public void validate() {
		super.validate();
		if (this.isInvalid() || !this.worldObj.blockExists(this.xCoord, this.yCoord, this.zCoord)) {
			return;
		}
		this.onLoaded();
	}

	public void invalidate() {
		if (this.loaded) {
			this.onUnloaded();
		}
		super.invalidate();
	}

	public void onLoaded() {
		if (!this.worldObj.isRemote) {
			MinecraftForge.EVENT_BUS.post((Event) new EnergyTileLoadEvent((IEnergyTile) this));
			this.addedToEnergyNet = true;
		}
		this.loaded = true;
	}

	public void onChunkUnload() {
		if (this.loaded) {
			this.onUnloaded();
		}
		super.onChunkUnload();
	}

	public void onUnloaded() {
		if (!this.worldObj.isRemote && this.addedToEnergyNet) {
			MinecraftForge.EVENT_BUS.post((Event) new EnergyTileUnloadEvent((IEnergyTile) this));
			this.addedToEnergyNet = false;
		}
		this.loaded = false;
	}

	private String nameblock;
	private int world1;
	private int blocktier;

	public void intialize() {
		this.wetBiome = (this.worldObj.getWorldChunkManager().getBiomeGenAt(this.xCoord, this.zCoord)
				.getIntRainfall() > 0);
		this.noSunWorld = this.worldObj.provider.hasNoSky;

		this.updateVisibility();
		this.initialized = true;
		if (!this.addedToEnergyNet) {
			this.onLoaded();
		}
		this.lastTimeStamp = System.currentTimeMillis();
	}

	public boolean running = false;

	public void updateEntity() {

		super.updateEntity();
		if (!this.initialized && this.worldObj != null) {
			this.intialize();
		}
		if (this.worldObj.isRemote) {
			return;
		}

		if (this.lastX != this.xCoord || this.lastZ != this.zCoord || this.lastY != this.yCoord) {
			this.lastX = this.xCoord;
			this.lastY = this.yCoord;
			this.lastZ = this.zCoord;
			this.onUnloaded();
			this.intialize();
		}
		this.gainFuel();

		for (int i = 0; i < 9; i++) {
			if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof AdditionModule) {
				if (this.chargeSlots[i].getItemDamage() == 4) {
					getmodulerf = true;
					break;
				} else {
					getmodulerf = false;
				}
			} else {
				getmodulerf = false;
			}

		}
		if (this.generating > 0) {
			if (getmodulerf) {
				if (!rf) {
					if (this.storage + this.generating <= this.maxStorage) {
						this.storage += this.generating;
					} else {
						this.storage = this.maxStorage;
					}
				} else {

					if ((this.storage2 + (this.generating * Config.coefficientrf)) <= this.maxStorage2) {
						this.storage2 += (this.generating* Config.coefficientrf);
					} else {
						this.storage2 = this.maxStorage2;

					}
				}

			} else {
				if (this.storage + this.generating <= this.maxStorage) {
					this.storage += this.generating;
				} else {
					this.storage = this.maxStorage;
				}
			}
		}
		boolean needInvUpdate = false;
		double sentPacket = 0.0;

		int tierplus = 0;
		int minus = 0;
		int output[];
		output = new int[9];
		//
		int maxstorage1[];
		maxstorage1 = new int[9];
		int gend[];
		gend = new int[9];
		int genn[];
		genn = new int[9];
		for (int i = 0; i < 9; i++) {
			if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof IModulGenDay) {

				gend[i] = IModulGenDay.getData(this.chargeSlots[i]).get(0);
			}
			if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof IModulGenNight) {
				genn[i] = IModulGenNight.getData(this.chargeSlots[i]).get(0);
			}
			if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof IModulStorage) {
				maxstorage1[i] = IModulStorage.getData(this.chargeSlots[i]).get(0);

			}
			if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof IModulOutput) {
				output[i] = IModulOutput.getData(this.chargeSlots[i]).get(0);

			}

			if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof AdditionModule) {
				int kk = chargeSlots[i].getItemDamage();
				if (kk == 0) {
					personality = true;
				}
				if (kk == 1) {
					tierplus++;
				} else if (kk == 2) {
					minus++;
				} else if (kk == 3) {
					for (int j = 0; j < 9; j++) {
						if (this.chargeSlots[j] != null
								&& this.chargeSlots[j].getItem() instanceof ic2.api.item.IElectricItem
								&& this.storage > 0.0D) {
							sentPacket = ElectricItem.manager.charge(this.chargeSlots[j], this.storage, 2147483647,
									false, false);
							if (sentPacket > 0.0D)
								needInvUpdate = true;
							this.storage -= (int) sentPacket;
						}
					}
					for (int j = 0; j < 9; j++) {
						if (this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof AdditionModule) {
							int meta = chargeSlots[j].getItemDamage();
							if (meta == 4) {
								for (int jj = 0; jj < 9; jj++) {
									if (this.chargeSlots[jj] != null
											&& this.chargeSlots[jj].getItem() instanceof IEnergyContainerItem
											&& this.storage2 > 0.0D) {
										if (jj == j || jj == i)
											continue;

										IEnergyContainerItem item = (IEnergyContainerItem) this.chargeSlots[jj]
												.getItem();
										setTransfer(
												(extractEnergy(null,
														item.receiveEnergy(this.chargeSlots[jj],
																(int) Math.min(storage2, 2147000000), false),
														false) > 0));
									} else {
										setTransfer(false);
									}

								}

							}
						}
					}
				} else if (kk == 4) {

					for (ForgeDirection side : ForgeDirection.VALID_DIRECTIONS) {
						TileEntity tile = this.worldObj.getTileEntity(this.xCoord + side.offsetX,
								this.yCoord + side.offsetY, this.zCoord + side.offsetZ);
						if (tile instanceof IEnergyReceiver)
							extractEnergy(side.getOpposite(), ((IEnergyReceiver) tile).receiveEnergy(side.getOpposite(),
									extractEnergy(side.getOpposite(),
											(int) (this.production >= 2000000000 ? 2000000000 : this.production), true),
									false), false);
						else if (tile instanceof IEnergyHandler)
							extractEnergy(side.getOpposite(), ((IEnergyHandler) tile).receiveEnergy(side.getOpposite(),
									extractEnergy(side.getOpposite(), 8182, true), false), false);

					}
				}
			} else {

			}

		}
		for (int m = 0; m < 9; m++) {
			if (this.chargeSlots[m] != null && this.chargeSlots[m].getItem() instanceof AdditionModule) {
				int kk = chargeSlots[m].getItemDamage();
				if (kk == 0) {
					personality = true;
					break;
				} else {
					this.personality = false;
				}
			} else {
				this.personality = false;
			}
		}
		if (this.storage2 >= this.maxStorage2) {
			this.storage2 = this.maxStorage2;
		} else if (this.storage2 < 0) {
			this.storage2 = 0;
		}
		if (this.tier + tierplus - minus > 0) {
			this.o = this.tier + tierplus - minus;
		} else {
			this.o = 0;
		}
		double a[];
		a = new double[9];
		double b[];
		b = new double[9];
		double c[];
		c = new double[9];
		double d[];
		d = new double[9];
		Block block = this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);
		NBTTagCompound nbttagcompound1 = NBTData.getOrCreateNbtData(new ItemStack(block));
		nbttagcompound1.setInteger("type", -1);
		if (this.chargeSlots[8] != null && this.chargeSlots[8].getItem() instanceof ModuleType) {
			int g = chargeSlots[8].getItemDamage();

			if (g < 7 && g >= 0) {
				nbttagcompound1.setInteger("type", g + 1);

				this.solarType = g + 1;

			}
		} else {

			nbttagcompound1.setInteger("type", 0);
			this.solarType = 0;
		}
		for (int i = 0; i < 9; i++) {
			if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof IModulPanel) {
				int g = chargeSlots[i].getItemDamage();
				if (o >= g + 1) {
					List<Double> list = IModulPanel.getData(chargeSlots[i]);
					a[i] = list.get(0);
					b[i] = list.get(1);
					c[i] = list.get(2);
					d[i] = list.get(3);

				}

			}
		}
		int wirelees = 0;
		for (int i = 0; i < 9; i++) {
			if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof ItemWirelessModule) {

				wirelees = 1;
				int x = 0;
				int y = 0;
				int z = 0;
				String name = null;
				int tier1 = 0;

				NBTTagCompound nbttagcompound = NBTData.getOrCreateNbtData(this.chargeSlots[i]);

				x = nbttagcompound.getInteger("Xcoord");
				y = nbttagcompound.getInteger("Ycoord");
				z = nbttagcompound.getInteger("Zcoord");
				tier1 = nbttagcompound.getInteger("tier");
				name = nbttagcompound.getString("Name");
				int world = nbttagcompound.getInteger("World1");

				if (nbttagcompound != null && x != 0 && y != 0 && z != 0) {
					this.panelx = x;
					this.panely = y;
					this.panelz = z;
					this.nameblock = name;
					this.world1 = world;
					this.blocktier = tier1;
				}
				break;
			}
		}
		if (this.worldObj.getTileEntity(panelx, panely, panelz) != null
				&& this.worldObj.getTileEntity(panelx, panely, panelz) instanceof TileEntityElectricBlock && panelx != 0
				&& panely != 0 && panelz != 0 && wirelees != 0) {
			TileEntityElectricBlock tile = (TileEntityElectricBlock) this.worldObj.getTileEntity(panelx, panely,
					panelz);
			if (tile.tier == this.blocktier && tile.getWorldObj().provider.dimensionId == this.world1) {
				if (this.storage > 0 && tile.energy < tile.maxStorage) {
					double temp = (tile.maxStorage - tile.energy);
					if (this.storage >= temp) {
						tile.energy += temp;
						this.storage -= temp;
					} else if (temp > this.storage) {

						tile.energy += (this.storage);
						this.storage = 0;
					}

				}
				if (this.storage2 > 0 && tile.energy2 < tile.maxStorage2) {
					double temp = (tile.maxStorage2 - tile.energy2);
					if (this.storage2 >= temp) {
						tile.energy2 += temp;
						this.storage2 -= temp;
					} else if (temp > this.storage2) {

						tile.energy2 += this.storage2;
						this.storage2 = 0;
					}

				}

			}
		} else {
			this.panelx = 0;
			this.panely = 0;
			this.panelz = 0;
		}

		double sum = 0, sum1 = 0, sum2 = 0, sum3 = 0;
		for (int i = 0; i < 9; i++) {
			sum = sum + a[i];
			sum1 = sum1 + b[i];
			sum2 = sum2 + c[i];
			sum3 = sum3 + d[i];
		}
		double gend_dob = 0;

		for (int i = 0; i < 9; i++) {
			if (gend[i] != 0) {
				gend_dob = gend_dob + gend[i];
			}

		}
		double genn_dob = 0;

		for (int i = 0; i < 9; i++) {
			if (genn[i] != 0) {
				genn_dob = genn_dob + genn[i];
			}

		}

		this.genDay = ((this.k + sum) + (this.k + sum) * (gend_dob / 100));

		this.genNight = ((this.m + sum1) + (this.m + sum1) * (genn_dob / 100));
		//

		double maxstorage_dob = 0;

		for (int i = 0; i < 9; i++) {
			if (maxstorage1[i] != 0) {
				maxstorage_dob = maxstorage_dob + maxstorage1[i];
			}

		}

		this.maxStorage = ((this.p + sum2) + (this.p + sum2) * (maxstorage_dob / 100));

		//
		double output_dob = 0;

		for (int i = 0; i < 9; i++) {
			if (output[i] != 0) {
				output_dob = output_dob + output[i];
			}

		}

		this.production = ((this.u + sum3) + (this.u + sum3) * output_dob);

		if (needInvUpdate) {
			super.markDirty();
		}
	}

	public boolean transfer = false;
	public boolean rf = true;

	private void setTransfer(boolean t) {
		this.transfer = t;
	}

	public double gainFuel() {
		double planet_efficenty = 1;
		if (Loader.isModLoaded("GalacticraftCore")) {
			planet_efficenty = GalacticraftIntegration.GetPlanetefficienty(this.worldObj.provider.dimensionId,
					this.worldObj);
		}
		if (Loader.isModLoaded("ExtraPlanets")) {
			planet_efficenty = ExtraPlanetsIntegration.GetPlanetefficienty(this.worldObj.provider.dimensionId,
					this.worldObj);
		}
		if (Loader.isModLoaded("MorePlanet")) {
			planet_efficenty = MorePlanetsIntegration.GetPlanetefficienty(this.worldObj.provider.dimensionId,
					this.worldObj);
		}
		if (Loader.isModLoaded("GalaxySpace")) {
			planet_efficenty = GalaxySpaceIntegration.GetPlanetefficienty(this.worldObj.provider.dimensionId,
					this.worldObj);
		}
		double rain_efficenty = 1;
		if (this.rain == true)
			rain_efficenty = 0.65;

		if (solarType == 0) {
			if (this.ticker++ % this.tickRate() == 0) {
				this.updateVisibility();
			}

			if (this.sunIsUp && this.skyIsVisible) {
				return this.generating = (0 + this.genDay * rain_efficenty * planet_efficenty);
			}
			if (this.skyIsVisible) {
				return this.generating = (0 + this.genNight * rain_efficenty * planet_efficenty);
			}

			return this.generating = 0;
		}
		if (solarType == 1) {
			if (this.yCoord >= 130) {
				if (this.ticker++ % this.tickRate() == 0) {
					this.updateVisibility();
				}
				if (this.sunIsUp && this.skyIsVisible) {
					return this.generating = (0 + 2 * this.genDay * rain_efficenty * planet_efficenty);
				}
				if (this.skyIsVisible) {
					return this.generating = (0 + 2 * this.genNight * rain_efficenty * planet_efficenty);
				}

			} else {
				if (this.ticker++ % this.tickRate() == 0) {
					this.updateVisibility();
				}
				if (this.sunIsUp && this.skyIsVisible) {
					return this.generating = (0 + this.genDay * rain_efficenty * planet_efficenty);
				}
				if (this.skyIsVisible) {
					return this.generating = (0 + this.genNight * rain_efficenty * planet_efficenty);
				}
				return this.generating = 0;
			}
		}

		if (solarType == 2) {
			if (this.yCoord <= 40) {
				if (this.ticker++ % this.tickRate() == 0) {
					this.updateVisibility();
				}
				if (this.sunIsUp && this.skyIsVisible) {
					return this.generating = (0 + 2 * this.genDay * rain_efficenty * planet_efficenty);
				}
				if (this.skyIsVisible) {
					return this.generating = (0 + 2 * this.genNight * rain_efficenty * planet_efficenty);
				}

			} else {
				if (this.ticker++ % this.tickRate() == 0) {
					this.updateVisibility();
				}
				if (this.sunIsUp && this.skyIsVisible) {
					return this.generating = (0 + this.genDay * rain_efficenty * planet_efficenty);
				}
				if (this.skyIsVisible) {
					return this.generating = (0 + this.genNight * rain_efficenty * planet_efficenty);
				}
				return this.generating = 0;
			}
		}
		if (solarType == 3) {
			if (this.worldObj.provider.dimensionId == -1) {
				return this.generating = 0 + 2 * this.genDay;
			} else {
				if (this.ticker++ % this.tickRate() == 0) {
					this.updateVisibility();
				}
				if (this.sunIsUp && this.skyIsVisible) {
					return this.generating = (0 + this.genDay * rain_efficenty * planet_efficenty);
				}
				if (this.skyIsVisible) {
					return this.generating = (0 + this.genNight * rain_efficenty * planet_efficenty);
				}
				return this.generating = 0;
			}
		}
		if (solarType == 4) {
			if (this.worldObj.provider.dimensionId == 1) {
				return this.generating = 0 + 2 * this.genDay;
			} else {
				if (this.ticker++ % this.tickRate() == 0) {
					this.updateVisibility();
				}
				if (this.sunIsUp && this.skyIsVisible) {
					return this.generating = (0 + this.genDay * rain_efficenty * planet_efficenty);
				}
				if (this.skyIsVisible) {
					return this.generating = (0 + this.genNight * rain_efficenty * planet_efficenty);
				}
				return this.generating = 0;
			}
		}

		if (solarType == 5) {

			if (this.ticker++ % this.tickRate() == 0) {
				this.updateVisibility();
			}
			if (this.sunIsUp && this.skyIsVisible) {
				return this.generating = 0 + 0 * this.genDay;
			}
			if (this.skyIsVisible) {
				return this.generating = (2 * this.genNight * rain_efficenty * planet_efficenty);
			}
		}
		if (solarType == 6) {

			if (this.ticker++ % this.tickRate() == 0) {
				this.updateVisibility();
			}
			if (this.sunIsUp && this.skyIsVisible) {
				return this.generating = (0 + 2 * this.genDay * rain_efficenty * planet_efficenty);
			}
			if (this.skyIsVisible) {
				return this.generating = 0 + 0 * this.genNight;
			}
		}
		if (solarType == 7) {
			if ((this.worldObj.isRaining() || this.worldObj.isThundering()) && this.worldObj.provider.dimensionId != 1
					&& this.worldObj.provider.dimensionId != -1) {

				if (this.ticker++ % this.tickRate() == 0) {
					this.updateVisibility();
				}
				if (this.sunIsUp && this.skyIsVisible) {
					return this.generating = (0 + 1.5 * this.genDay * planet_efficenty);
				}
				if (this.skyIsVisible) {
					return this.generating = 0 + (1.5 * this.genNight * planet_efficenty);
				}
			} else {
				if (this.ticker++ % this.tickRate() == 0) {
					this.updateVisibility();
				}

				if (this.sunIsUp && this.skyIsVisible) {
					return this.generating = (0 + this.genDay * planet_efficenty);
				}
				if (this.skyIsVisible) {
					return this.generating = (0 + this.genNight * planet_efficenty);
				}
			}

		}
		return this.generating = 0;
	}

	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		if (this.convertState == 0 && this.storage2 > 0) {
			int energyExtracted = Math.min(this.storage2, maxExtract);
			if (!simulate) {
				this.storage2 -= energyExtracted;
				this.outputEnergyBuffer += energyExtracted;
			}
			return energyExtracted;
		}
		if (this.convertState == 0)
			;
		return 0;
	}

	public void updateVisibility() {

		if ((this.wetBiome && (this.worldObj.isRaining() || this.worldObj.isThundering()))) {
			this.rain = true;
		} else {
			this.rain = false;
		}
		if (!this.worldObj.isDaytime()) {

			this.sunIsUp = false;
		} else {
			this.sunIsUp = true;
		}
		if (!this.worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord + 1, this.zCoord) || this.noSunWorld) {
			this.skyIsVisible = false;
		}

		else {
			this.skyIsVisible = true;
		}

	}

	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		this.storage = nbttagcompound.getInteger("storage");
		this.storage2 = nbttagcompound.getInteger("storage2");
		this.lastX = nbttagcompound.getInteger("lastX");
		this.lastY = nbttagcompound.getInteger("lastY");
		this.lastZ = nbttagcompound.getInteger("lastZ");

		this.production = nbttagcompound.getInteger("production");
		this.generating = nbttagcompound.getInteger("generating");
		this.tier = nbttagcompound.getDouble("tier");
		this.maxStorage = nbttagcompound.getInteger("maxStorage");

		NBTTagList nbttaglist = nbttagcompound.getTagList("Items", 10);

		this.chargeSlots = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 0xFF;
			if (j >= 0 && j < this.chargeSlots.length)
				this.chargeSlots[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);

		}

		this.solarType = nbttagcompound.getInteger("solarType");
		this.getmodulerf = nbttagcompound.getBoolean("getmodulerf");
		this.rf = nbttagcompound.getBoolean("rf");
		this.panelx = nbttagcompound.getInteger("panelx");
		this.panely = nbttagcompound.getInteger("panely");
		this.panelz = nbttagcompound.getInteger("panelz");
		this.nameblock = nbttagcompound.getString("nameblock");
		this.world1 = nbttagcompound.getInteger("worldid");
		this.player = nbttagcompound.getString("player");
		blocktier = nbttagcompound.getInteger("blocktier");

	}

	public NBTTagCompound nbt() {

		NBTTagCompound nbttagcompound = NBTData
				.getOrCreateNbtData(new ItemStack(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord)));

		nbttagcompound.setInteger("solarType", this.solarType);

		return nbttagcompound;

	}

	public boolean getActive() {
		return this.active;
	}

	public void openInventory() {

	}

	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		nbttagcompound.setBoolean("getmodulerf", this.getmodulerf);
		nbttagcompound.setBoolean("rf", this.rf);
		NBTTagList nbttaglist = new NBTTagList();
		nbttagcompound.setInteger("panelx", this.panelx);
		nbttagcompound.setInteger("panely", this.panely);
		nbttagcompound.setInteger("panelz", this.panelz);
		if (nameblock != null)
			nbttagcompound.setString("nameblock", nameblock);

		for (int i = 0; i < this.chargeSlots.length; i++) {
			if (this.chargeSlots[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();

				nbttagcompound1.setByte("Slot", (byte) i);

				this.chargeSlots[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag((NBTBase) nbttagcompound1);
			}
		}
		nbttagcompound.setTag("Items", (NBTBase) nbttaglist);
		nbttagcompound.setInteger("worldid", world1);
		nbttagcompound.setInteger("blocktier", this.blocktier);

		if (player != null) {
			nbttagcompound.setString("player", player);
		}
		nbttagcompound.setDouble("maxStorage", this.maxStorage);
		nbttagcompound.setDouble("tier", this.tier);
		nbttagcompound.setDouble("generating", this.generating);
		nbttagcompound.setDouble("production", this.production);
		nbttagcompound.setInteger("solarType", this.solarType);
		nbttagcompound.setDouble("storage", this.storage);
		nbttagcompound.setDouble("storage2", this.storage2);
		nbttagcompound.setInteger("lastX", this.lastX);
		nbttagcompound.setInteger("lastY", this.lastY);
		nbttagcompound.setInteger("lastZ", this.lastZ);

		nbttagcompound.setDouble("energy", this.storage);
	}

	public boolean isAddedToEnergyNet() {
		return this.addedToEnergyNet;
	}

	public double getMaxEnergyOutput() {
		return this.production;
	}

	public float gaugeEnergyScaled(final float i) {
		int tierplus = 0;
		int minus = 0;
		int gg = 0;
		for (int j = 0; j < 9; j++) {
			if (this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof AdditionModule) {
				int kk = chargeSlots[j].getItemDamage();

				if (kk == 1) {
					tierplus++;
				} else if (kk == 2) {
					minus++;
				}

			}
		}
		this.o = this.tier + tierplus - minus;

		double maxstorage1[];
		maxstorage1 = new double[9];
		double maxstorage_dob = 0;
		for (int j = 0; j < 9; j++) {
			if (this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof IModulStorage) {
				maxstorage1[j] = IModulStorage.getData(this.chargeSlots[j]).get(0);
				if (maxstorage1[j] != 0) {
					maxstorage_dob = maxstorage_dob + maxstorage1[j];
				}

			}
		}

		double c[];
		c = new double[9];
		for (int j = 0; j < 9; j++) {
			if (this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof IModulPanel) {
				int g = chargeSlots[j].getItemDamage();
				if (o >= g + 1) {
					List<Double> list = IModulPanel.getData(chargeSlots[j]);
					c[j] = list.get(2);
				}

			}

		}

		double sum = 0, sum1 = 0, sum2 = 0, sum3 = 0;
		for (int j = 0; j < 9; j++) {

			sum2 = sum2 + c[j];
		}

		if ((float) (this.storage * i / (((this.p + sum2) + (this.p + sum2) * (maxstorage_dob / 100)))) > 24)
			return 24;

		return (float) (this.storage * i / (((this.p + sum2) + (this.p + sum2) * (maxstorage_dob / 100))));

	}
	 @Override
		public boolean isUseableByPlayer(EntityPlayer player)
		{
			
			return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistance((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
		}
	public float gaugeEnergyScaled2(final float i) {
		if ((this.storage2 * i / this.maxStorage2) > 24)
			return 24;

		return (float) (this.storage2 * i / (this.maxStorage2));

	}

	public boolean canConnectEnergy(ForgeDirection arg0) {
		return true;
	}

	public int getEnergyStored(ForgeDirection from) {
		return this.storage2;
	}

	public int getMaxEnergyStored(ForgeDirection from) {
		return this.maxStorage2;
	}

	public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
		if (this.convertState == 0)
			return true;
		return false;
	}

	public int gaugeFuelScaled(final int i) {
		return i;
	}

	public short getFacing() {
		return this.facing;
	}

	public void setFacing(short facing) {
		this.facing = facing;
	}

	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		ItemStack ret = super.getWrenchDrop(entityPlayer);

		NBTTagCompound nbttagcompound = NBTData.getOrCreateNbtData(ret);
		nbttagcompound.setDouble("storage", this.storage);
		nbttagcompound.setDouble("storage2", this.storage2);

		return ret;
	}

	public int tickRate() {
		return 80;
	}

	public ContainerBase<? extends TileEntitySolarPanel> getGuiContainer(EntityPlayer entityPlayer) {
		return (ContainerBase<? extends TileEntitySolarPanel>) new ContainerSolarPanels(entityPlayer, this);
	}

	
	public void onNetworkUpdate(final String field) {
	}

	private static List<String> fields = Arrays.asList(new String[0]);

	@Override
	public List<String> getNetworkedFields() {
		List<String> ret = new Vector<String>(1);
		ret.add("owner");
		return TileEntitySolarPanel.fields;

	}

	public boolean emitsEnergyTo(final TileEntity receiver, final ForgeDirection direction) {
		return true;
	}

	public double getOfferedEnergy() {
		return Math.min(this.production, this.storage);
	}

	public void drawEnergy(final double amount) {
		this.storage -= (int) amount;
	}

	public void onGuiClosed(EntityPlayer entityPlayer) {
	}

	public int getSourceTier() {
		return this.machineTire;
	}

	static {
		TileEntitySolarPanel.randomizer = new Random();
		TileEntitySolarPanel.fields = Arrays.asList(new String[0]);
	}

	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		if (this.convertState == 1) {
			if (this.storage2 >= this.maxStorage2)
				return 0;
			if (this.storage2 + maxReceive > this.maxStorage2) {
				int energyReceived = this.maxStorage2 - this.storage2;
				if (!simulate) {
					this.storage2 = this.maxStorage2;
					this.inputEnergyBuffer += energyReceived;
				}
				return energyReceived;
			}
			if (!simulate) {
				this.inputEnergyBuffer += maxReceive;
				this.storage2 += maxReceive;
			}
			return maxReceive;
		}
		return 0;
	}

	public int getSolarType() {
		int type = this.solarType;
		return type;
	}

	@Override
	public void onNetworkEvent(EntityPlayer player, int event) {
		this.rf = !this.rf;

	}

	public ItemStack getStackInSlotOnClosing(final int var1) {
		if (this.chargeSlots[var1] != null) {
			final ItemStack var2 = this.chargeSlots[var1];
			this.chargeSlots[var1] = null;
			return var2;
		}
		return null;
	}

	public boolean isItemValidForSlot(final int i, final ItemStack itemstack) {
		return true;
	}

	public String getInventoryName() {
		return "Super Solar Panel";
	}

	public boolean hasCustomInventoryName() {
		return false;
	}

	public int getInventoryStackLimit() {
		return 1;
	}

	public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
		return (getFacing() != side);
	}

	public void closeInventory() {

	}
	
	    public String getInvName() {
	        return this.panelName;
	    }
	
	public ItemStack[] getContents() {
		return this.chargeSlots;
	}

	public int getSizeInventory() {
		return 10;
	}

	public ItemStack getStackInSlot(final int i) {
		return this.chargeSlots[i];
	}

	public ItemStack decrStackSize(final int i, final int j) {
		if (this.chargeSlots[i] == null) {
			return null;
		}
		if (this.chargeSlots[i].stackSize <= j) {
			final ItemStack itemstack = this.chargeSlots[i];
			this.chargeSlots[i] = null;
			return itemstack;
		}
		final ItemStack itemstack2 = this.chargeSlots[i].splitStack(j);
		if (this.chargeSlots[i].stackSize == 0) {
			this.chargeSlots[i] = null;
		}
		return itemstack2;
	}

	public void setInventorySlotContents(final int i, final ItemStack itemstack) {
		this.chargeSlots[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

}
