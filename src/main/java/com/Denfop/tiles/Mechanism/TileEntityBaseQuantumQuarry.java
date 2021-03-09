package com.Denfop.tiles.Mechanism;

import ic2.api.network.INetworkTileEntityEventListener;
import ic2.api.recipe.RecipeOutput;
import ic2.core.ContainerBase;
import ic2.core.IC2;
import ic2.core.IHasGui;
import ic2.core.audio.AudioSource;
import ic2.core.block.invslot.InvSlot;
import ic2.core.block.invslot.InvSlotOutput;
import ic2.core.block.invslot.InvSlotProcessable;
import ic2.core.block.invslot.InvSlotUpgrade;
import ic2.core.block.machine.tileentity.TileEntityElectricMachine;
import ic2.core.network.NetworkManager;
import ic2.core.upgrade.IUpgradableBlock;
import ic2.core.upgrade.IUpgradeItem;
import java.util.List;

import com.Denfop.container.ContainerQuantumQuarry;
import com.Denfop.container.ContainerStandardMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityBaseQuantumQuarry extends TileEntityElectricMachine implements IHasGui, INetworkTileEntityEventListener, IUpgradableBlock {
  protected short progress;
  
  public final int defaultEnergyConsume;
  
  public final int defaultOperationLength;
  
  public final int defaultTier;
  
  public final int defaultEnergyStorage;
  
  public int energyConsume;
  
  public int operationLength;
  
  public int operationsPerTick;
  
  protected double guiProgress;
  
  public AudioSource audioSource;
  
  private static final int EventStart = 0;
  
  private static final int EventInterrupt = 1;
  
  private static final int EventStop = 2;
  

  public final InvSlotOutput outputSlot;
  
  public final InvSlotUpgrade upgradeSlot;
  
  
  
  public TileEntityBaseQuantumQuarry() {
    super(1000000, 1, 1);
    this.progress = 0;
    this.defaultEnergyConsume = this.energyConsume = 35000;
    this.defaultOperationLength = this.operationLength = 1;
    this.defaultTier = 11;
    this.defaultEnergyStorage = 35000;
    this.outputSlot = new InvSlotOutput(this, "output", 2, 1);
    this.upgradeSlot = new InvSlotUpgrade(this, "upgrade", 3, 4);
  }
  
  public void readFromNBT(NBTTagCompound nbttagcompound) {
    super.readFromNBT(nbttagcompound);
    this.progress = nbttagcompound.getShort("progress");
  }
  
  public void writeToNBT(NBTTagCompound nbttagcompound) {
    super.writeToNBT(nbttagcompound);
    nbttagcompound.setShort("progress", this.progress);
  }
  
  public double getProgress() {
    return this.guiProgress;
  }
  
  public void onLoaded() {
    super.onLoaded();
    if (IC2.platform.isSimulating())
      setOverclockRates(); 
  }
  
  public void onUnloaded() {
    super.onUnloaded();
    if (IC2.platform.isRendering() && this.audioSource != null) {
      IC2.audioManager.removeSources(this);
      this.audioSource = null;
    } 
  }
  
  public void markDirty() {
    super.markDirty();
    if (IC2.platform.isSimulating())
      setOverclockRates(); 
  }
  
  protected void updateEntityServer() {
    super.updateEntityServer();
    boolean needsInvUpdate = false;
    
    if (this.energy >= this.energyConsume) {
      setActive(true);
      if (this.progress == 0)
        ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 0, true); 
      this.progress = (short)(this.progress + 1);
      this.energy -= this.energyConsume;
      double k = this.progress;
      double p = (k/ this.operationLength);
    
      this.guiProgress = p;
      if (this.progress >= this.operationLength) {
    	  this.guiProgress = 0;
       
        needsInvUpdate = true;
        this.progress = 0;
        ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 2, true);
      } 
    } else {
      if (this.progress != 0 && getActive())
        ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 1, true); 
     
      setActive(false);
    } 
    for (int i = 0; i < this.upgradeSlot.size(); i++) {
      ItemStack stack = this.upgradeSlot.get(i);
      if (stack != null && stack.getItem() instanceof IUpgradeItem)
        if (((IUpgradeItem)stack.getItem()).onTick(stack, this))
          needsInvUpdate = true;  
    } 
   
    if (needsInvUpdate)
      super.markDirty(); 
  }
  
  public void setOverclockRates() {
    this.upgradeSlot.onChanged();
    double previousProgress = this.progress / this.operationLength;
    double stackOpLen = (this.defaultOperationLength + this.upgradeSlot.extraProcessTime) * 64.0D * this.upgradeSlot.processTimeMultiplier;
    this.operationsPerTick = (int)Math.min(Math.ceil(64.0D / stackOpLen), 2.147483647E9D);
    this.operationLength = (int)Math.round(stackOpLen * this.operationsPerTick / 64.0D);
    this.energyConsume = applyModifier(this.defaultEnergyConsume, this.upgradeSlot.extraEnergyDemand, this.upgradeSlot.energyDemandMultiplier);
    setTier(applyModifier(this.defaultTier, this.upgradeSlot.extraTier, 1.0D));
    this.maxEnergy = applyModifier(this.defaultEnergyStorage, this.upgradeSlot.extraEnergyStorage + this.operationLength * this.energyConsume, this.upgradeSlot.energyStorageMultiplier);
    if (this.operationLength < 1)
      this.operationLength = 1; 
    this.progress = (short)(int)Math.floor(previousProgress * this.operationLength + 0.1D);
  }
  
  
 
  
  
  
  public abstract String getInventoryName();
  
  public ContainerBase<? extends TileEntityQuantumQuarry> getGuiContainer(EntityPlayer entityPlayer) {
    return (ContainerBase<? extends TileEntityQuantumQuarry>)new ContainerQuantumQuarry(entityPlayer, this);
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
    return (ret > 2.147483647E9D) ? Integer.MAX_VALUE : (int)ret;
  }
  
  public double getEnergy() {
    return this.energy;
  }
  
  public boolean useEnergy(double amount) {
    if (this.energy >= amount) {
      this.energy -= amount;
      return true;
    } 
    return false;
  }
  
  public void onGuiClosed(EntityPlayer entityPlayer) {}
}
