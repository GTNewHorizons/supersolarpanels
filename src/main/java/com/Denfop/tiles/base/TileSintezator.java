
package com.Denfop.tiles.base;

import com.Denfop.Config;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.Event;
import ic2.api.energy.event.EnergyTileLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import java.util.Random;

import com.Denfop.IUCore;
import com.Denfop.InvSlot.InvSlotQuantumQuarry;
import com.Denfop.api.IPanel;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.container.ContainerElectricBlock;
import com.Denfop.container.ContainerSinSolarPanel;
import com.Denfop.integration.Avaritia.ItemAvaritiaSolarPanel;
import com.Denfop.integration.Avaritia.blockAvaritiaSolarPanel;
import com.Denfop.integration.Botania.ItemBotSolarPanel;
import com.Denfop.integration.Botania.blockBotSolarPanel;
import com.Denfop.integration.DE.ItemDESolarPanel;
import com.Denfop.integration.DE.blockDESolarPanel;
import com.Denfop.integration.GC.ExtraPlanetsIntegration;
import com.Denfop.integration.GC.GalacticraftIntegration;
import com.Denfop.integration.GC.GalaxySpaceIntegration;
import com.Denfop.integration.GC.MorePlanetsIntegration;
import com.Denfop.item.Modules.ModuleTypePanel;
import com.Denfop.item.base.ItemSSPSolarPanel;
import com.Denfop.utils.NBTData;

import ic2.api.network.INetworkUpdateListener;
import ic2.api.network.INetworkDataProvider;
import net.minecraft.inventory.IInventory;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.tile.IWrenchable;
import ic2.core.ContainerBase;
import ic2.api.energy.tile.IEnergyTile;

public class TileSintezator extends TileEntityBase
		implements IEnergyTile, IWrenchable, IEnergySource, IInventory, INetworkDataProvider, INetworkUpdateListener {
	private TileSintezator tileentity;
	public static Random randomizer;
	public int ticker;
	public double generating;
	public double genDay;
	public double genNight;
	public boolean initialized;
	public boolean sunIsUp;
	public boolean skyIsVisible;
	public short facing;
	public boolean noSunWorld;
	public boolean wetBiome;
	public int machineTire;
	public boolean addedToEnergyNet;
	public boolean created;
	public ItemStack[] chargeSlots;
	public int fuel;
	public int lastX;
	public int lastY;
	public int lastZ;
	public double storage;
	public String panelName;
	public double production;
	public double maxStorage;
	public double p;
	public boolean loaded;
	public double k;
	public double m;
	public double u;
	public ModuleTypePanel panel;
	public int tier;
	public double l;
	public boolean modules;
	public boolean rain = false;;
	private static List<String> fields;

	public TileSintezator(final String gName, final int tier) {

		this.loaded = false;
		this.created = false;
		this.facing = 2;

		this.storage = 0;
		this.panelName = gName;
		this.sunIsUp = false;
		this.skyIsVisible = false;

		this.l = 0;
		this.genNight = 0;
		this.genDay = 0;
		this.chargeSlots = new ItemStack[10];
		this.initialized = false;
		this.maxStorage = 0;
		this.ticker = TileSintezator.randomizer.nextInt(this.tickRate());
		this.lastX = this.xCoord;
		this.lastY = this.yCoord;
		this.lastZ = this.zCoord;
		this.machineTire = 0;
		this.tier = tier;
	}

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

	public void intialize() {
		this.wetBiome = (this.worldObj.getWorldChunkManager().getBiomeGenAt(this.xCoord, this.zCoord)
				.getIntRainfall() > 0);
		this.noSunWorld = this.worldObj.provider.hasNoSky;
		this.updateVisibility();
		this.initialized = true;
		if (!this.addedToEnergyNet) {
			this.onLoaded();
		}
	}

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
for(int i =0; i <this.getSizeInventory(); i++) {
	if(this.chargeSlots[i] == null)
		break;
	ItemStack item = this.chargeSlots[i];
	if(item.getItem() instanceof ItemSSPSolarPanel) {
		
		int meta = item.getItemDamage();
		TileEntitySolarPanel tile = (TileEntitySolarPanel) BlockSSPSolarPanel.getBlockEntity(meta);
		IPanel.setData(item, tile);
	}else if(item.getItem() instanceof ItemAvaritiaSolarPanel) {
		int meta = item.getItemDamage();
		TileEntitySolarPanel tile = (TileEntitySolarPanel) blockAvaritiaSolarPanel.getBlockEntity(meta);
		IPanel.setData(item, tile);
	}else if(item.getItem() instanceof ItemBotSolarPanel) {
		int meta = item.getItemDamage();
		TileEntitySolarPanel tile = (TileEntitySolarPanel) blockBotSolarPanel.getBlockEntity(meta);
		IPanel.setData(item, tile);
	}else if(item.getItem() instanceof ItemDESolarPanel) {
		int meta = item.getItemDamage();
		TileEntitySolarPanel tile = (TileEntitySolarPanel) blockDESolarPanel.getBlockEntity(meta);
		IPanel.setData(item, tile);
	}
}
		boolean needInvUpdate = false;
		double sentPacket = 0.0;
		double[] tire_massive = new double[10];
		double[][] myArray = new double[4][10];
		for (int i = 0; i < 10; i++) {
			if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof IPanel) {
				ItemStack itemstack = this.chargeSlots[i];
				List<Double> list = IPanel.getData(itemstack);
				int p = chargeSlots[i].stackSize;
				myArray[0][i] = (list.get(0) * p) * 1D;
				myArray[1][i] = (list.get(1) * p) * 1D;
				myArray[2][i] = (list.get(2) * p) * 1D;
				myArray[3][i] = (list.get(3) * p) * 1D;
				tire_massive[i] = list.get(4).doubleValue();

			}
		}
		if (tire_massive.length > 1) {
			double max = tire_massive[0];
			for (int i = 0; i < tire_massive.length; i++)
				if (tire_massive[i] > max)
					max = tire_massive[i];

			this.machineTire = (int) max;
		} else {
			this.machineTire = 0;
		}
		double sum = 0;
		double sum1 = 0;
		double sum2 = 0;
		double sum3 = 0;
		for (int i = 0; i < 9; i++) {
			sum = sum + myArray[0][i];
			sum1 = sum1 + myArray[1][i];
			sum2 = sum2 + myArray[2][i];
			sum3 = sum3 + myArray[3][i];

		}

		this.genDay = sum;

		this.genNight = sum1;
		this.maxStorage = sum2;

		//

		this.production = sum3;

		this.gainFuel();
		if (this.generating > 0D) {
			if (((this.storage + this.generating) * 1.0D) <= (this.maxStorage) * 1.0D) {
				this.storage += this.generating;
			} else {
				this.storage = (this.maxStorage) * 1D;
			}
		}
		if (this.storage < 0D) {
			this.storage = 0D;
		}
		if (this.maxStorage <= 0D) {
			this.storage = 0D;
		}
		if (needInvUpdate) {
			super.markDirty();
		}
	}

	public double gainFuel() {
		double planet_efficenty = 1D;
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
		double rain_efficenty = 1D;
		if (this.rain == true)
			rain_efficenty = 0.65D;

		if (this.ticker++ % this.tickRate() == 0) {
			this.updateVisibility();
		}

		if (this.sunIsUp && this.skyIsVisible) {
			return this.generating = (0 + this.genDay * rain_efficenty * planet_efficenty) * 1D;
		}
		if (this.skyIsVisible) {
			return this.generating = (0 + this.genNight * rain_efficenty * planet_efficenty) * 1D;
		}

		return this.generating = 0D;

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

	public void readFromNBT(final NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		this.storage = nbttagcompound.getDouble("storage");
		this.lastX = nbttagcompound.getInteger("lastX");
		this.lastY = nbttagcompound.getInteger("lastY");
		this.lastZ = nbttagcompound.getInteger("lastZ");

		this.genDay = nbttagcompound.getDouble("genDay");
		this.genNight = nbttagcompound.getDouble("genNight");
		this.maxStorage = nbttagcompound.getDouble("maxStorage");
		this.production = nbttagcompound.getDouble("production");

		final NBTTagList nbttaglist = nbttagcompound.getTagList("Items", 10);
		this.chargeSlots = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			final NBTTagCompound nbttagcompound2 = nbttaglist.getCompoundTagAt(i);
			final int j = nbttagcompound2.getByte("Slot") & 0xFF;

			if (j >= 0 && j < this.chargeSlots.length) {
				this.chargeSlots[j] = ItemStack.loadItemStackFromNBT(nbttagcompound2);
			}

		}
	}

	public void writeToNBT(final NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		final NBTTagList nbttaglist = new NBTTagList();
		nbttagcompound.setDouble("storage", this.storage);
		nbttagcompound.setInteger("lastX", this.lastX);
		nbttagcompound.setInteger("lastY", this.lastY);
		nbttagcompound.setInteger("lastZ", this.lastZ);
		nbttagcompound.setDouble("genDay", this.genDay);
		nbttagcompound.setDouble("genNight", this.genNight);
		nbttagcompound.setDouble("production", this.production);
		nbttagcompound.setDouble("maxStorage", this.maxStorage);

		for (int i = 0; i < this.chargeSlots.length; ++i) {
			final NBTTagCompound nbttagcompound2 = new NBTTagCompound();
			if (this.chargeSlots[i] != null) {

				nbttagcompound2.setByte("Slot", (byte) i);
				this.chargeSlots[i].writeToNBT(nbttagcompound2);
				nbttaglist.appendTag((NBTBase) nbttagcompound2);
			}
		}
		nbttagcompound.setTag("Items", (NBTBase) nbttaglist);
	}

	public boolean isAddedToEnergyNet() {
		return this.addedToEnergyNet;
	}

	public double getMaxEnergyOutput() {
		return this.production;
	}

	public double gaugeEnergyScaled(final float i) {

		double[] myArray2;
		myArray2 = new double[10];

		for (int j = 0; j < 10; j++) {
			if (this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof IPanel) {
				ItemStack itemstack = this.chargeSlots[j];
				int meta = itemstack.getMaxDamage();
				NBTTagCompound nbt = NBTData.getOrCreateNbtData(itemstack);
				double genday = nbt.getDouble("genday");
				double gennight = nbt.getDouble("gennight");
				double storage = nbt.getDouble("basestorage");
				double output = nbt.getDouble("output");
				int p = chargeSlots[j].stackSize;
				if (p <= Config.limit) {

					myArray2[j] = storage * p;

				} else {

					myArray2[j] = storage * Config.limit;

				}
			}
		}

		double sum2 = 0;
		for (int j = 0; j < 9; j++) {
			sum2 = sum2 + myArray2[j];

		}
		if ((sum2) != 0) {
			if ((this.storage * i / (sum2)) > 24)
				return 24;
			else
				return (double) (this.storage * i / (sum2));

		} else {
			return 0;
		}

	}

	public int gaugeFuelScaled(final int i) {
		return i;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {

		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this
				&& player.getDistance((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
						(double) this.zCoord + 0.5D) <= 64.0D;
	}

	public void openInventory() {
	}

	public void closeInventory() {
	}

	public int tickRate() {
		return 128;
	}

	@Override
	public short getFacing() {
		return this.facing;
	}

	@Override
	public void setFacing(final short facing) {
		this.facing = facing;
	}

	@Override
	public boolean wrenchCanSetFacing(final EntityPlayer entityplayer, final int i) {
		return false;
	}

	@Override
	public boolean wrenchCanRemove(final EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public float getWrenchDropRate() {
		return 1.0f;
	}

	@Override
	public ItemStack getWrenchDrop(final EntityPlayer entityPlayer) {
		return new ItemStack(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord), 1,
				this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord));
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

	public String getInventoryName() {
		return StatCollector.translateToLocal("blockSintezator.name");
	}

	public boolean hasCustomInventoryName() {
		return false;
	}

	public int getInventoryStackLimit() {
		return Config.limit;
	}

	public ContainerBase<? extends TileSintezator> getGuiContainer(EntityPlayer entityPlayer) {
		return (ContainerBase<? extends TileSintezator>) new ContainerSinSolarPanel(entityPlayer, this);
	}

	public String getInvName() {
		return null;
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

	public void onNetworkUpdate(final String field) {
	}

	@Override
	public List<String> getNetworkedFields() {
		return TileSintezator.fields;
	}

	public boolean emitsEnergyTo(final TileEntity receiver, final ForgeDirection direction) {
		return true;
	}

	public double getOfferedEnergy() {
		return Math.min(this.production * 1D, this.storage * 1D);
	}

	public void drawEnergy(final double amount) {
		this.storage -= amount;
	}

	public void onGuiClosed(EntityPlayer entityPlayer) {
	}

	public int getSourceTier() {
		return this.machineTire;
	}

	static {
		TileSintezator.randomizer = new Random();
		TileSintezator.fields = Arrays.asList(new String[0]);
	}

}
