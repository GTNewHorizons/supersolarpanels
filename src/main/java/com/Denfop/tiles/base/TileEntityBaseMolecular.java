package com.Denfop.tiles.base;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergyTile;
import ic2.api.network.INetworkTileEntityEventListener;
import ic2.api.recipe.RecipeOutput;
import ic2.core.ContainerBase;
import ic2.core.IC2;
import ic2.core.IHasGui;
import ic2.core.audio.AudioSource;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlotOutput;
import ic2.core.block.invslot.InvSlotProcessable;
import ic2.core.block.invslot.InvSlotUpgrade;
import ic2.core.network.NetworkManager;
import ic2.core.upgrade.IUpgradableBlock;
import ic2.core.upgrade.IUpgradeItem;
import java.util.List;

import com.Denfop.container.ContainerBaseMolecular;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityBaseMolecular extends TileEntityInventory
		implements IHasGui, INetworkTileEntityEventListener , IEnergySink {



	public final int defaultTier;




	protected double guiProgress;

	public AudioSource audioSource;

	private static final int EventStart = 0;

	private static final int EventInterrupt = 1;

	private static final int EventStop = 2;

	public InvSlotProcessable inputSlot;

	public final InvSlotOutput outputSlot;

	private boolean active;

	public double inputEU;
	public double energy;

	public double maxEnergy;
	protected boolean addedToEnergyNet;

	private int tier;
	public TileEntityBaseMolecular(int energyPerTick, int length, int outputSlots) {
		this(energyPerTick, length, outputSlots, 1);
	}

	public TileEntityBaseMolecular(int energyPerTick, int length, int outputSlots, int aDefaultTier) {
		super();
		
		energy =0;
		maxEnergy =0;
		this.addedToEnergyNet = false;
		this.defaultTier = 11;
		
		this.outputSlot = new InvSlotOutput(this, "output", 2, 1);
		this.active = false;
	}
	public void markDirty() {
	    super.markDirty();
	    if (IC2.platform.isSimulating())
	      setOverclockRates(); 
	  }
	public double getDemandedEnergy() {
		RecipeOutput output = getOutput();
		if(output != null) {
		return this.maxEnergy - this.energy;
		}
		return 0;
	}
	public int getSinkTier() {
		return this.tier;
	}

	public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
		return true;
	}

	public void onNetworkUpdate(String field) {
		super.onNetworkUpdate(field);
		if (field.equals("tier"))
			setTier(this.tier);
		RecipeOutput output = getOutput();
		if (field.equals("maxEnergy"))
			if (output != null) 
			      this.maxEnergy = output.metadata.getDouble("energy");
			else
				 this.maxEnergy = 0;
			
	}
	public void setTier(int tier1) {
		if (this.tier == tier1)
			return;
		boolean addedToENet = this.addedToEnergyNet;
		if (addedToENet) {
			MinecraftForge.EVENT_BUS.post((Event) new EnergyTileUnloadEvent((IEnergyTile) this));
			this.addedToEnergyNet = false;
		}
		this.tier = tier1;
		
		if (addedToENet) {
			MinecraftForge.EVENT_BUS.post((Event) new EnergyTileLoadEvent((IEnergyTile) this));
			this.addedToEnergyNet = true;
		}
	}
	  public void setOverclockRates() {
	   
	  
	    setTier(applyModifier(this.defaultTier, 0, 1.0D));
	    RecipeOutput output = getOutput();
	    if (output != null) 
	      this.maxEnergy = output.metadata.getDouble("energy");
	  }
	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		
		this.maxEnergy = nbttagcompound.getDouble("maxEnergy");
		this.energy = nbttagcompound.getDouble("energy");
		this.inputEU = nbttagcompound.getDouble("inputEU");
	}

	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		
		nbttagcompound.setDouble("inputEU", this.inputEU);
		nbttagcompound.setDouble("maxEnergy", this.maxEnergy);
		nbttagcompound.setDouble("energy", this.energy);
	}

	public double getProgress() {
		return this.guiProgress;
	}

	

	

	protected void updateEntityServer() {
		super.updateEntityServer();
		boolean needsInvUpdate = false;
		RecipeOutput output = getOutput();
		if (output != null) {
			setActive(true);
			this.active = true;
			if (this.energy == 0)
				((NetworkManager) IC2.network.get()).initiateTileEntityEvent((TileEntity) this, 0, true);

			this.maxEnergy= output.metadata.getDouble("energy");
			double p = (this.energy / output.metadata.getDouble("energy"));
			
			
			if (p <= 1)
				this.guiProgress = p;
			if (p > 1)
				this.guiProgress = 1;
			if (this.energy >= output.metadata.getDouble("energy")) {
				operate(output);
				needsInvUpdate = true;
				
				this.energy = -output.metadata.getDouble("energy");
			
				
				((NetworkManager) IC2.network.get()).initiateTileEntityEvent((TileEntity) this, 2, true);
			}
		} else {
			if (this.energy != 0 && getActive())
				((NetworkManager) IC2.network.get()).initiateTileEntityEvent((TileEntity) this, 1, true);
			if (output == null)
				this.energy = 0;
			setActive(false);
		}

		
	}

	public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage) {
		RecipeOutput output = getOutput();
		if(output != null) {
		if (this.energy >= this.maxEnergy)
			return amount;
		this.energy += amount;
		}

		return 0.0D;
	}



	public void operate(RecipeOutput output) {
		
			List<ItemStack> processResult = output.items;

			operateOnce(output, processResult);
			output = getOutput();
			
				
		
	}

	public void operateOnce(RecipeOutput output, List<ItemStack> processResult) {
		this.inputSlot.consume();
		this.outputSlot.add(processResult);
	}

	public RecipeOutput getOutput() {
		if (this.inputSlot.isEmpty())
			return null;
		RecipeOutput output = this.inputSlot.process();
		if (output == null)
			return null;
		if (this.outputSlot.canAdd(output.items))
			return output;
		return null;
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
	public abstract String getInventoryName();

	public ContainerBase<? extends TileEntityBaseMolecular> getGuiContainer(EntityPlayer entityPlayer) {
		return (ContainerBase<? extends TileEntityBaseMolecular>) new ContainerBaseMolecular(entityPlayer, this);
	}

	public String getStartSoundFile() {
		return null;
	}

	public String getInterruptSoundFile() {
		return null;
	}

	public void onNetworkEvent(int event) {
		if (this.audioSource == null && getStartSoundFile() != null)
			this.audioSource = IC2.audioManager.createSource(this, getStartSoundFile());
		switch (event) {
		case 0:
			if (this.audioSource != null)
				this.audioSource.play();
			break;
		case 1:
			if (this.audioSource != null) {
				this.audioSource.stop();
				if (getInterruptSoundFile() != null)
					IC2.audioManager.playOnce(this, getInterruptSoundFile());
			}
			break;
		case 2:
			if (this.audioSource != null)
				this.audioSource.stop();
			break;
		}
	}

	public static int applyModifier(int base, int extra, double multiplier) {
		double ret = Math.round((base + extra) * multiplier);
		return (ret > 2.147483647E9D) ? Integer.MAX_VALUE : (int) ret;
	}

	public double getEnergy() {
		return this.energy;
	}

	public double getPower() {
		return this.inputEU;
	}

	public boolean useEnergy(double amount) {
		if (this.energy >= amount) {
			this.energy -= amount;
			return true;
		}
		return false;
	}

	public boolean getActive() {
		return this.active;
	}

	public void onGuiClosed(EntityPlayer entityPlayer) {
	}

}
