package com.Denfop.block.BlockVajra;

import cpw.mods.fml.common.eventhandler.Event;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergyTile;
import ic2.api.tile.IEnergyStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

public class TileVajraChargerElectric extends TileEntity implements IEnergySink, IEnergyStorage {
  public int tier;
  
  public int maxStorage;
  
  public int output;
  
  public int energy = 0;
  
  private boolean addedToEnergyNet = false;
  
  public TileVajraChargerElectric(int tier1, int output1, int storage1) {
    this.tier = tier1;
    this.output = output1;
    this.maxStorage = storage1;
  }
  
  public void invalidate() {
    super.invalidate();
    onChunkUnloadOrInvalidate();
  }
  
  public void onChunkUnload() {
    onChunkUnloadOrInvalidate();
  }
  
  protected void onChunkUnloadOrInvalidate() {
    removeFromENet();
  }
  
  public void updateEntity() {
    super.updateEntity();
    addToENet();
  }
  
  protected void addToENet() {
    if (!this.addedToEnergyNet && !this.worldObj.isRemote) {
      MinecraftForge.EVENT_BUS.post((Event)new EnergyTileLoadEvent((IEnergyTile)this));
      this.addedToEnergyNet = true;
    } 
  }
  
  protected void removeFromENet() {
    if (!this.worldObj.isRemote && this.addedToEnergyNet) {
      MinecraftForge.EVENT_BUS.post((Event)new EnergyTileUnloadEvent((IEnergyTile)this));
      this.addedToEnergyNet = false;
    } 
  }
  
  public void readFromNBT(NBTTagCompound nbttagcompound) {
    super.readFromNBT(nbttagcompound);
    this.energy = nbttagcompound.getInteger("energy");
  }
  
  public void writeToNBT(NBTTagCompound nbttagcompound) {
    super.writeToNBT(nbttagcompound);
    nbttagcompound.setInteger("energy", this.energy);
  }
  
  public boolean isAddedToEnergyNet() {
    return this.addedToEnergyNet;
  }
  
  public boolean acceptsEnergyFrom(TileEntity nameTileEntity, ForgeDirection nameForgeDirection) {
    return true;
  }
  
  public double getDemandedEnergy() {
    return (this.maxStorage - this.energy);
  }
  
  public int getSinkTier() {
    return this.tier;
  }
  
  public double injectEnergy(ForgeDirection nameForgeDirection, double amount, double voltage) {
    if (this.energy >= this.maxStorage)
      return amount; 
    this.energy += (int)amount;
    return 0.0D;
  }
  
  public int getStored() {
    return this.energy;
  }
  
  public void setStored(int energy) {
    this.energy = energy;
  }
  
  public int addEnergy(int amount) {
    this.energy += amount;
    return getStored();
  }
  
  public int getCapacity() {
    return this.maxStorage;
  }
  
  public int getOutput() {
    return this.output;
  }
  
  public double getOutputEnergyUnitsPerTick() {
    return 128.0D;
  }
  
  public boolean isTeleporterCompatible(ForgeDirection side) {
    return false;
  }
}
