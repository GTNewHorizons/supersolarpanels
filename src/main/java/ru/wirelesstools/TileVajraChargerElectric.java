package ru.wirelesstools;

import cpw.mods.fml.common.eventhandler.Event;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergyTile;
import ic2.api.network.INetworkClientTileEntityEventListener;
import ic2.api.tile.IEnergyStorage;
import ic2.core.IC2;
import ic2.core.block.TileEntityBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

public class TileVajraChargerElectric extends TileEntity implements IEnergySink, IEnergyStorage {

	public int tier;
	public int maxStorage;
	public int output;
	public double energy = 0.0D;
	private boolean addedToEnergyNet = false;
	
	
	public TileVajraChargerElectric(int tier1, int output1, int storage1) {
		this.tier = tier1;
		this.output = output1;
		this.maxStorage = storage1;
		
		
		
		
	}
	
	public void invalidate()
	   {
	    super.invalidate();
	     onChunkUnloadOrInvalidate();
	   }
	
	  public void onChunkUnload()
	  {
	     onChunkUnloadOrInvalidate();
	   }
	
	  protected void onChunkUnloadOrInvalidate() {
	    removeFromENet();
	   }
	
	   public void updateEntity()
	  {
		   super.updateEntity();
	    addToENet();
	   }
	 
	  protected void addToENet() {
	    if ((!this.addedToEnergyNet) && (!this.worldObj.isRemote)) {
	       MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
	       this.addedToEnergyNet = true;
	    }
	  }
	 
	   protected void removeFromENet() {
	     if ((!this.worldObj.isRemote) && (this.addedToEnergyNet)) {
	       MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
	       this.addedToEnergyNet = false;
	     }
	   }
	
	public void readFromNBT(NBTTagCompound nbttagcompound) {
		     super.readFromNBT(nbttagcompound);
		    
		  this.energy = nbttagcompound.getDouble("energy");
		  }
		
		
		
		
		
		 
		  public void writeToNBT(NBTTagCompound nbttagcompound) {
		    super.writeToNBT(nbttagcompound);
		     
		    nbttagcompound.setDouble("energy", this.energy);
		  }
	
	
	
	

	
	



	public boolean isAddedToEnergyNet() {
		     return this.addedToEnergyNet;
		  }










	@Override
	public boolean acceptsEnergyFrom(TileEntity nameTileEntity, ForgeDirection nameForgeDirection) {
		
		return true;
	}

	


	


	@Override
	public double getDemandedEnergy() {
		return this.maxStorage - this.energy;
	}






	@Override
	public int getSinkTier() {
		
		return this.tier;
	}







	@Override
	public double injectEnergy(ForgeDirection nameForgeDirection, double amount, double voltage) {
		if (this.energy >= this.maxStorage) {
			return amount;
			}
			this.energy += amount;
			return 0.0D;
	}

	@Override
	public int getStored() {
		
		return (int) this.energy;
	}

	@Override
	public void setStored(int energy) {
		
		this.energy = energy;
	}

	@Override
	public int addEnergy(int amount) {
		this.energy += amount;
	    return getStored();
	}

	@Override
	public int getCapacity() {
		
		return this.maxStorage;
	}

	@Override
	public int getOutput() {
		
		return this.output;
	}

	@Override
	public double getOutputEnergyUnitsPerTick() {
		
		return 128;
	}

	@Override
	public boolean isTeleporterCompatible(ForgeDirection side) {
		
		return false;
	}

}
