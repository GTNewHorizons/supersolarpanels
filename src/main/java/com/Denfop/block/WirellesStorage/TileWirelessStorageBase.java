package com.Denfop.block.WirellesStorage;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.api.IWirelessReciever;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import cpw.mods.fml.common.eventhandler.Event;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.tile.IEnergyStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

public class TileWirelessStorageBase extends TileEntity implements IEnergyStorage, IEnergySource, IWirelessReciever {
	
	public int maxStorage;
	public double energy;
	public int output;
	public int tier;
	public boolean targetSet;
	public int targetX;
	public int targetY;
	public int targetZ;
	
	public TileEntitySolarPanel tilewp;
	
	public boolean initialized;
	public boolean loaded;
	
	private boolean addedToEnergyNet;
	
	public boolean isconnected;
	
	
	
	
	public TileWirelessStorageBase(int output1, int maxStorage1) {
		this.energy = 0;
		this.tier = 3;
		this.output = output1;
		this.maxStorage = maxStorage1;
		this.loaded = false;
		this.initialized = false;
		this.targetSet = false;
		this.isconnected = false;
		
		
		
	}
	
	
	
	
	
	
	public void updateEntity() {
		super.updateEntity();
		
		if (!this.initialized && this.worldObj != null) {
			intialize();
			
			
			  }
		
		if (this.worldObj.isRemote) {
		      return;
		     }
		
		if(this.energy > this.maxStorage) {
			
			this.energy = this.maxStorage;
		
		}
		markDirty();
		
	}
		
	public void validate() {
		super.validate();
		onLoaded();
	}
	
	
	public void onLoaded() {
		if (!this.worldObj.isRemote) {
		MinecraftForge.EVENT_BUS.post((Event)new EnergyTileLoadEvent(this));
		this.addedToEnergyNet = true;
			
		} 
		this.loaded = true;
		
		
	}
		
	public void invalidate() {
		if (this.loaded) {
		onUnloaded();
		// if(tilewp != null) {
			
		//	tilewp.lista.clear();
		//	tilewp.listb.clear();
		//	tilewp.listc.clear();
		//	tilewp.isconnected = false;
		//	tilewp.mapofcoords.clear();
		//	tilewp.targetSet = false;
		// }
		
		}
		super.invalidate();
	}
	
	public void onUnloaded() {
		if (!this.worldObj.isRemote && this.addedToEnergyNet) {
		MinecraftForge.EVENT_BUS.post((Event)new EnergyTileUnloadEvent(this));
		
		
		
		this.addedToEnergyNet = false;
		
		} 
		this.loaded = false;
	}
		
	public void intialize() {
				
		
		this.initialized = true;
		if (!this.addedToEnergyNet) {
		onLoaded();
		}
		
		
		
		
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
	public boolean isTeleporterCompatible(ForgeDirection nameForgeDirection) {
		
		return false;
	}

	@Override
	public boolean emitsEnergyTo(TileEntity nameTileEntity, ForgeDirection nameForgeDirection) {
		
		return true;
	}

	@Override
	public double getOfferedEnergy() {
		if (this.energy >= this.output) {
		return Math.min(this.energy, this.output);
		}
		return 0;
	}
	
	
	
	public void setTargetsWSB(int x, int y, int z) {
		
		this.targetSet = true;
		this.targetX = x;
		this.targetY = y;
		this.targetZ = z;
		
	}	
	
	
	
	

	@Override
	public void drawEnergy(double amount) {
		this.energy -= amount;
		
	}

	@Override
	public int getSourceTier() {
		
		return this.tier;
	}


	

	

	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		   
		nbttagcompound.setDouble("energy", this.energy);
		nbttagcompound.setDouble("maxenergy", this.maxStorage);
		nbttagcompound.setBoolean("targetset", this.targetSet);
		nbttagcompound.setBoolean("isconnected", this.isconnected);
		
		
		
	}
	
	public void readFromNBT(NBTTagCompound nbttagcompound) {
		 super.readFromNBT(nbttagcompound);
		    
		 this.energy = nbttagcompound.getDouble("energy");
		 this.maxStorage = (int) nbttagcompound.getDouble("maxenergy");
		 this.targetSet = nbttagcompound.getBoolean("targetset");
		 this.isconnected = nbttagcompound.getBoolean("isconnected");
		 
		 
	}

	


	


	


	
	

}
