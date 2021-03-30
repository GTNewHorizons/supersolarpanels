package com.Denfop.tiles.base;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.InvSlot.InvSlotElectricBlock;
import com.Denfop.InvSlot.InvSlotElectricBlockA;
import com.Denfop.InvSlot.InvSlotElectricBlockB;
import com.Denfop.InvSlot.InvSlotQuantumQuarry;
import com.Denfop.api.module.IModulOutput;
import com.Denfop.api.module.IModulStorage;
import com.Denfop.container.ContainerElectricBlock;
import com.Denfop.gui.GuiElectricBlock;
import com.Denfop.item.Modules.ItemWirelessModule;
import com.Denfop.item.Modules.AdditionModule;
import com.Denfop.utils.NBTData;

import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyReceiver;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.energy.EnergyNet;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.energy.tile.IEnergyTile;
import ic2.api.item.ElectricItem;
import ic2.api.network.INetworkClientTileEntityEventListener;
import ic2.api.tile.IEnergyStorage;
import ic2.core.ContainerBase;
import ic2.core.IC2;
import ic2.core.IHasGui;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlot;
import ic2.core.block.invslot.InvSlotCharge;
import ic2.core.block.invslot.InvSlotDischarge;
import ic2.core.init.MainConfig;
import ic2.core.util.ConfigUtil;
import ic2.core.util.Util;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

import cofh.api.energy.IEnergyContainerItem;

public abstract class TileEntityElectricBlock extends TileEntityInventory implements IEnergySink, IEnergySource,
		IHasGui, INetworkClientTileEntityEventListener, IEnergyStorage, IEnergyHandler, IEnergyReceiver {
	public final double tier;

	public double output;

	public double maxStorage;
	public double energy;

	public double maxStorage2;
	public String UUID = null;
	public double energy2;
	public boolean lastenergy_1 = false;
	public boolean lastenergy_2 = false;
	public boolean rf;
	public boolean rfeu = false;
	public boolean needsInvUpdate = false;
	public boolean movementcharge = false;
	public boolean movementchargerf = false;
	public boolean movementchargeitemrf = false;
	public double output_plus;
	public double l;
	public InvSlotElectricBlock inputslotA;
	public InvSlotElectricBlockA inputslotB;
	public InvSlotElectricBlockB inputslotC;

	public TileEntityElectricBlock(double tier1, double output1, double maxStorage1) {
		this.energy = 0.0D;
		this.energy2 = 0.0D;
		this.isEmittingRedstone = false;
		this.redstoneUpdateInhibit = 5;
		this.addedToEnergyNet = false;
		this.tier = tier1;
		this.output = output1;
		this.maxStorage = maxStorage1;
		this.maxStorage2 = maxStorage1;
		this.rf = false;
		this.inputslotA = new InvSlotElectricBlock(this, 1);
		this.inputslotB = new InvSlotElectricBlockA(this, 2);
		this.inputslotC = new InvSlotElectricBlockB(this, 3);
		this.output_plus = 0;
		this.l = output1;
	}

	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		if (nbttagcompound.getString("UUID") != null)
			this.UUID = nbttagcompound.getString("UUID");
		else
			this.UUID = "";
		
		this.movementchargeitemrf=nbttagcompound.getBoolean("movementchargeitemrf");
this.movementchargeitem=nbttagcompound.getBoolean("movementchargeitem");
this.movementcharge=nbttagcompound.getBoolean("movementcharge");
this.movementchargerf=nbttagcompound.getBoolean("movementchargerf");
		this.personality = nbttagcompound.getBoolean("personality");
		this.rfeu = nbttagcompound.getBoolean("rfeu");
		this.rf = nbttagcompound.getBoolean("rf");
		this.energy2 = Util.limit(nbttagcompound.getDouble("energy2"), 0.0D,
				this.maxStorage2);
		this.energy = Util.limit(nbttagcompound.getDouble("energy"), 0.0D,
				this.maxStorage);
	}

	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		nbttagcompound.setDouble("energy", this.energy);
		nbttagcompound.setDouble("energy2", this.energy2);
		nbttagcompound.setBoolean("active", getActive());
		nbttagcompound.setBoolean("movementchargeitemrf", this.movementchargeitemrf);
		nbttagcompound.setBoolean("movementchargeitem",this.movementchargeitem);
		nbttagcompound.setBoolean("movementcharge", this.movementcharge);
		nbttagcompound.setBoolean("movementchargerf", this.movementchargerf);
		
		nbttagcompound.setBoolean("rfeu", this.rfeu);
		nbttagcompound.setBoolean("rf", this.rf);
		if (this.UUID != null)
			nbttagcompound.setString("UUID", this.UUID);
		else
			nbttagcompound.setString("UUID", "");
		nbttagcompound.setBoolean("personality", this.personality);
	}

	public void onLoaded() {
		super.onLoaded();
		if (IC2.platform.isSimulating()) {
			MinecraftForge.EVENT_BUS.post((Event) new EnergyTileLoadEvent((IEnergyTile) this));
			this.addedToEnergyNet = true;
		}
	}

	public void onUnloaded() {
		if (IC2.platform.isSimulating() && this.addedToEnergyNet) {
			MinecraftForge.EVENT_BUS.post((Event) new EnergyTileUnloadEvent((IEnergyTile) this));
			this.addedToEnergyNet = false;
		}
		super.onUnloaded();
	}

	public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
		return !facingMatchesDirection(direction);
	}

	public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
		return facingMatchesDirection(direction);
	}

	public boolean facingMatchesDirection(ForgeDirection direction) {
		return (direction.ordinal() == getFacing());
	}

	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {

		if (this.energy2 >= this.maxStorage2)
			return 0;
		if (this.energy2 + maxReceive > this.maxStorage2) {
			int energyReceived = (int) (this.maxStorage2 - this.energy2);
			if (!simulate) {
				this.energy2 = this.maxStorage2;
			}
			return energyReceived;
		}
		if (!simulate) {

			this.energy2 += maxReceive;
		}
		return maxReceive;
	}

	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		if (this.energy2 > 0) {
			int energyExtracted = (int) Math.min(this.energy2, maxExtract);
			if (!simulate) {
				this.energy2 -= energyExtracted;

			}
			return energyExtracted;
		}
		if (this.rf == true)
			;
		return 0;
	}

	public float getChargeLevel() {

		float ret = (float) ((float) this.energy / (this.maxStorage));

		if (ret > 1.0F)
			ret = 1.0F;
		return ret;
	}

	public float getChargeLevel1() {

		float ret = (float) ((float) this.energy2 / (this.maxStorage2));

		if (ret > 1.0F)
			ret = 1.0F;
		return ret;
	}

	public boolean canConnectEnergy(ForgeDirection arg0) {
		return true;
	}

	public int getEnergyStored(ForgeDirection from) {
		return (int) this.energy2;
	}

	public int getMaxEnergyStored(ForgeDirection from) {
		return (int) this.maxStorage2;
	}

	protected void updateEntityServer() {
		super.updateEntityServer();
		for (ForgeDirection side : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity tile = this.worldObj.getTileEntity(this.xCoord + side.offsetX, this.yCoord + side.offsetY,
					this.zCoord + side.offsetZ);
			if (tile instanceof IEnergyReceiver)
				extractEnergy(side.getOpposite(), ((IEnergyReceiver) tile).receiveEnergy(side.getOpposite(),
						extractEnergy(side.getOpposite(), 8182, true), false), false);
			else if (tile instanceof IEnergyHandler)
				extractEnergy(side.getOpposite(), ((IEnergyHandler) tile).receiveEnergy(side.getOpposite(),
						extractEnergy(side.getOpposite(), 8182, true), false), false);

		}

		personality = this.inputslotC.personality(this.inputslotC);
		this.output_plus = this.inputslotC.output_plus(this.inputslotC, this.l);
		this.inputslotC.wireless(inputslotC, this.xCoord, this.yCoord, this.zCoord, (int)this.tier,
				this.worldObj.provider.dimensionId, this.worldObj.provider.getDimensionName(), this.getInventoryName());
		this.output = this.l + this.output_plus;
		this.movementcharge = this.inputslotC.getstats(this.inputslotC).get(0);
		this.movementchargeitem = this.inputslotC.getstats(this.inputslotC).get(1);
		this.movementchargerf = this.inputslotC.getstats(this.inputslotC).get(2);
		this.movementchargeitemrf = this.inputslotC.getstats(this.inputslotC).get(3);
		this.rf = this.inputslotC.getstats(this.inputslotC).get(4);
		if (this.rf) {
			if (!this.rfeu) {
				if (energy >= 0 && energy2 <= maxStorage2) {

					energy2 += energy * Config.coefficientrf;
					energy -= energy;

				}
				if (energy2 > maxStorage2) {
					double rf = (energy2 - maxStorage2);
					energy += rf / Config.coefficientrf;
					energy2 = maxStorage2;
				}
			} else {

				if (energy2 >= 0 && energy <= maxStorage) {

					energy += (energy2 /  Config.coefficientrf);
					energy2 -= energy2;

				}
				if (energy > maxStorage) {
					double rf = (energy - maxStorage);
					energy2 += rf * Config.coefficientrf;
					energy = maxStorage;
				}
			}
		}
		IEnergyContainerItem item = null;
		if (this.energy2 >= 1.0D && this.inputslotA.get(0) != null
				&& this.inputslotA.get(0).getItem() instanceof IEnergyContainerItem) {
			item = (IEnergyContainerItem) this.inputslotA.get(0).getItem();
			setTransfer((extractEnergy(null, item.receiveEnergy(this.inputslotA.get(0), (int) this.energy2, false),
					false) > 0));
		} else {
			setTransfer(false);
		}

		if (this.energy >= this.maxStorage) {
			this.energy = this.maxStorage;
		}
		if (this.energy2 >= this.maxStorage2) {
			this.energy2 = this.maxStorage2;
		}
		if (this.inputslotA.get(0) != null)
			if (this.inputslotA.charge(this.energy > 1D ? this.energy : 0, this.inputslotA.get(0)) != 0) {
				this.energy -= this.inputslotA.charge(this.energy > 1D ? this.energy : 0, this.inputslotA.get(0));
				needsInvUpdate = ((this.energy > 1D ? this.energy : 0) > 0.0D);
			}
		if (this.inputslotB.get(0) != null)
			if (this.inputslotB.discharge(this.energy > 1D ? this.energy : 0, this.inputslotB.get(0)) != 0) {

				this.energy += this.inputslotB.discharge(this.energy > 1D ? this.energy : 0, this.inputslotB.get(0));
				needsInvUpdate = ((this.energy > 1D ? this.energy : 0) > 0.0D);
			}

		if (needsInvUpdate)
			markDirty();
	}

	public boolean transfer = false;

	public void setTransfer(boolean t) {
		this.transfer = t;
	}

	public double getOfferedEnergy() {
		if (this.energy >= (this.output + this.output_plus))
			return Math.min(this.energy, (this.output + this.output_plus));
		return 0.0D;
	}

	public void drawEnergy(double amount) {
		this.energy -= amount;
	}

	public double getDemandedEnergy() {
		return this.maxStorage - this.energy;
	}

	public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage) {
		if (this.energy >= this.maxStorage)
			return amount;
		this.energy += amount;
		return 0.0D;
	}

	public int getSourceTier() {
		return (int) this.tier;
	}

	public int getSinkTier() {
		return (int) this.tier;
	}

	public ContainerBase<? extends TileEntityElectricBlock> getGuiContainer(EntityPlayer entityPlayer) {
		return (ContainerBase<? extends TileEntityElectricBlock>) new ContainerElectricBlock(entityPlayer, this);
	}

	@SideOnly(Side.CLIENT)
	public GuiScreen getGui(EntityPlayer entityPlayer, boolean isAdmin) {
		return (GuiScreen) new GuiElectricBlock(new ContainerElectricBlock(entityPlayer, this));
	}

	public void onGuiClosed(EntityPlayer entityPlayer) {
	}

	public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
		return (getFacing() != side);
	}

	public void setFacing(short facing) {
		if (this.addedToEnergyNet)
			MinecraftForge.EVENT_BUS.post((Event) new EnergyTileUnloadEvent((IEnergyTile) this));
		super.setFacing(facing);
		if (this.addedToEnergyNet) {
			this.addedToEnergyNet = false;
			MinecraftForge.EVENT_BUS.post((Event) new EnergyTileLoadEvent((IEnergyTile) this));
			this.addedToEnergyNet = true;
		}
	}

	public void onNetworkEvent(EntityPlayer player, int event) {
		this.rfeu = !this.rfeu;

	}

	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		ItemStack ret = super.getWrenchDrop(entityPlayer);
		float energyRetainedInStorageBlockDrops = ConfigUtil.getFloat(MainConfig.get(),
				"balance/energyRetainedInStorageBlockDrops");
		if (energyRetainedInStorageBlockDrops > 0.0F) {

			NBTTagCompound nbttagcompound = NBTData.getOrCreateNbtData(ret);
			nbttagcompound.setDouble("energy", this.energy * energyRetainedInStorageBlockDrops);
			nbttagcompound.setDouble("energy2", this.energy2 * energyRetainedInStorageBlockDrops);
		}
		return ret;
	}

	public int getStored() {
		return (int) this.energy;
	}

	public boolean wrenchCanRemove(final EntityPlayer entityPlayer) {
		if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) instanceof TileEntityElectricBlock) {
			TileEntityElectricBlock tile = (TileEntityElectricBlock) this.worldObj.getTileEntity(this.xCoord,
					this.yCoord, this.zCoord);

			if (tile.personality) {
				if (entityPlayer.getDisplayName() == tile.UUID|| entityPlayer.capabilities.isCreativeMode) {
					return true;
				} else {
					entityPlayer.addChatMessage(
							new ChatComponentTranslation(String.format("ssp.error", new Object[0]), new Object[0]));
					return false;
				}

			} else {
				return true;

			}
		} else {

		}
		return true;
	}

	public int getCapacity() {
		return (int) this.maxStorage;
	}

	public int getOutput() {
		return (int) (this.output + this.output_plus);
	}

	public double getOutputEnergyUnitsPerTick() {
		return this.output + this.output_plus;
	}

	public void setStored(int energy1) {
		this.energy = energy1;
	}

	public int addEnergy(int amount) {
		this.energy += amount;
		return amount;
	}

	public boolean isTeleporterCompatible(ForgeDirection side) {
		return true;
	}

	public static byte redstoneModes = 7;

	private boolean isEmittingRedstone;

	private int redstoneUpdateInhibit;

	public boolean addedToEnergyNet;

	public boolean movementchargeitem = false;

	public boolean personality = false;

}
