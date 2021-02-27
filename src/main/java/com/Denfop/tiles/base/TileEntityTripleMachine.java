package com.Denfop.tiles.base;

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

import com.Denfop.container.ContainerTripleMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityTripleMachine extends TileEntityElectricMachine implements IHasGui, INetworkTileEntityEventListener, IUpgradableBlock {
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
  
  public InvSlotProcessable inputSlotA;
  public InvSlotProcessable inputSlotB;
  public final InvSlotOutput outputSlotA;
  public final InvSlotOutput outputSlotC;
  public final InvSlotUpgrade upgradeSlot;

  public final InvSlotOutput outputSlotB;

public InvSlotProcessable inputSlotC;
  
  public TileEntityTripleMachine(int energyPerTick, int length, int outputSlots) {
    this(energyPerTick, length, outputSlots, 1);
  }
  
  public TileEntityTripleMachine(int energyPerTick, int length, int outputSlots, int aDefaultTier) {
    super(energyPerTick * length, 1, 1);
    this.progress = 0;
    this.defaultEnergyConsume = this.energyConsume = energyPerTick;
    this.defaultOperationLength = this.operationLength = length;
    this.defaultTier = aDefaultTier;
    this.defaultEnergyStorage = energyPerTick * length;
    this.outputSlotA = new InvSlotOutput(this, "outputA", 2, 1);
    this.outputSlotB = new InvSlotOutput(this, "outputB", 3, 1);
    this.outputSlotC = new InvSlotOutput(this, "outputÑ", 4, 1);
    this.upgradeSlot = new InvSlotUpgrade(this, "upgrade", 5, 4);
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
    
    RecipeOutput output = getOutput();
    RecipeOutput output1 = getOutput1();
    RecipeOutput output2 = getOutput2();
    
    RecipeOutput output4 = getOutput4();
    RecipeOutput output5 = getOutput5();
    RecipeOutput output6 = getOutput6();
    
    RecipeOutput output7 = getOutput7();
    RecipeOutput output8 = getOutput8();
    RecipeOutput output9 = getOutput9();

    if(output != null || output1 != null || output2 != null) {
     if ((output1 != null) && this.energy >= this.energyConsume) {
      setActive(true);
      if (this.progress == 0)
        ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 0, true); 
      this.progress = (short)(this.progress + 1);
      this.energy -= this.energyConsume;
     
      if (this.progress >= this.operationLength) {
    		this.guiProgress = 0;
        operate1(output1);
        needsInvUpdate = true;
        this.progress = 0;
        ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 2, true);
      } 
    } 
    

     if (output != null && this.energy >= this.energyConsume) {
         setActive(true);
         if (this.progress == 0)
           ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 0, true); 
         this.progress = (short)(this.progress + 1);
         this.energy -= this.energyConsume;
        
         if (this.progress >= this.operationLength) {
        		this.guiProgress = 0;
           operate(output);
           needsInvUpdate = true;
           this.progress = 0;
           ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 2, true);
         } 
       }
      
     if (output2 != null && this.energy >= this.energyConsume) {
         setActive(true);
         if (this.progress == 0)
           ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 0, true); 
         this.progress = (short)(this.progress + 1);
         this.energy -= this.energyConsume;
         
         if (this.progress >= this.operationLength) {
        		this.guiProgress = 0;
           operate2(output2);
           needsInvUpdate = true;
           this.progress = 0;
           ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 2, true);
         } 
       }
     
    
    }
    
    else  if(output4 != null || output5 != null || output6 != null) {
        if ((output4 != null) && this.energy >= this.energyConsume) {
         setActive(true);
         if (this.progress == 0)
           ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 0, true); 
         this.progress = (short)(this.progress + 1);
         this.energy -= this.energyConsume;
        
         if (this.progress >= this.operationLength) {
       		this.guiProgress = 0;
           operate4(output4);
           needsInvUpdate = true;
           this.progress = 0;
           ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 2, true);
         } 
       } 
       

        if (output5 != null && this.energy >= this.energyConsume) {
            setActive(true);
            if (this.progress == 0)
              ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 0, true); 
            this.progress = (short)(this.progress + 1);
            this.energy -= this.energyConsume;
           
            if (this.progress >= this.operationLength) {
           		this.guiProgress = 0;
              operate5(output5);
              needsInvUpdate = true;
              this.progress = 0;
              ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 2, true);
            } 
          }
         
        if (output6 != null&& this.energy >= this.energyConsume) {
            setActive(true);
            if (this.progress == 0)
              ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 0, true); 
            this.progress = (short)(this.progress + 1);
            this.energy -= this.energyConsume;
            
            if (this.progress >= this.operationLength) {
           		this.guiProgress = 0;
              operate6(output6);
              needsInvUpdate = true;
              this.progress = 0;
              ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 2, true);
            } 
          }
        
       
       }else  if(output7 != null || output8 != null || output9 != null) {
           if ((output7 != null) && this.energy >= this.energyConsume) {
               setActive(true);
               if (this.progress == 0)
                 ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 0, true); 
               this.progress = (short)(this.progress + 1);
               this.energy -= this.energyConsume;
              
               if (this.progress >= this.operationLength) {
             		this.guiProgress = 0;
                 operate7(output7);
                 needsInvUpdate = true;
                 this.progress = 0;
                 ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 2, true);
               } 
             } 
             

              if (output8 != null&& this.energy >= this.energyConsume) {
                  setActive(true);
                  if (this.progress == 0)
                    ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 0, true); 
                  this.progress = (short)(this.progress + 1);
                  this.energy -= this.energyConsume;
                 
                  if (this.progress >= this.operationLength) {
                 		this.guiProgress = 0;
                    operate8(output8);
                    needsInvUpdate = true;
                    this.progress = 0;
                    ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 2, true);
                  } 
                }
               
              if (output9 != null&& this.energy >= this.energyConsume) {
                  setActive(true);
                  if (this.progress == 0)
                    ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 0, true); 
                  this.progress = (short)(this.progress + 1);
                  this.energy -= this.energyConsume;
                  
                  if (this.progress >= this.operationLength) {
                 		this.guiProgress = 0;
                    operate9(output9);
                    needsInvUpdate = true;
                    this.progress = 0;
                    ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 2, true);
                  } 
                }
              
             
             }
    else {
      if (this.progress != 0 && getActive())
        ((NetworkManager)IC2.network.get()).initiateTileEntityEvent((TileEntity)this, 1, true); 
      if (output == null)
        this.progress = 0; 
      if (output1 == null)
          this.progress = 0; 
      setActive(false);
    } 
    for (int i = 0; i < this.upgradeSlot.size(); i++) {
      ItemStack stack = this.upgradeSlot.get(i);
      if (stack != null && stack.getItem() instanceof IUpgradeItem)
        if (((IUpgradeItem)stack.getItem()).onTick(stack, this))
          needsInvUpdate = true;  
    } 
   
    double k = this.progress;
    double p = (k/ this.operationLength);
  if(p != 0)
    this.guiProgress = p;
    if (needsInvUpdate)
      super.markDirty(); 
    
  }
  
  





public void setOverclockRates() {
    this.upgradeSlot.onChanged();

    double previousProgress = this.progress / this.operationLength;
    this.guiProgress = previousProgress;
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
  
  public void operate(RecipeOutput output1) {
	    for (int i = 0; i < this.operationsPerTick; i++) {

	      List<ItemStack> processResult1 = output1.items;
	      for (int j = 0; j < this.upgradeSlot.size(); j++) {
	        ItemStack stack = this.upgradeSlot.get(j);
	        if (stack != null && stack.getItem() instanceof IUpgradeItem)
	            ((IUpgradeItem)stack.getItem()).onProcessEnd(stack, this, processResult1); 
	      } 
	      
	      operateOnce(output1, processResult1);
	     
	      output1 = getOutput();
	      
	      if (output1 == null)
	          break; 
	    } 
	  }//
  public void operate2(RecipeOutput output) {
	    for (int i = 0; i < this.operationsPerTick; i++) {

	      List<ItemStack> processResult = output.items;
	      for (int j = 0; j < this.upgradeSlot.size(); j++) {
	        ItemStack stack = this.upgradeSlot.get(j);
	        if (stack != null && stack.getItem() instanceof IUpgradeItem)
	            ((IUpgradeItem)stack.getItem()).onProcessEnd(stack, this, processResult); 
	      } 
	      
	      operateOnce3(output, processResult);
	     
	      output = getOutput2();
	      
	      if (output == null)
	          break; 
	    } 
	  }
	  public void operate1(RecipeOutput output) {
		    for (int i = 0; i < this.operationsPerTick; i++) {

		      List<ItemStack> processResult = output.items;
		      for (int j = 0; j < this.upgradeSlot.size(); j++) {
		        ItemStack stack = this.upgradeSlot.get(j);
		        if (stack != null && stack.getItem() instanceof IUpgradeItem)
		            ((IUpgradeItem)stack.getItem()).onProcessEnd(stack, this, processResult); 
		      } 
		      
		      operateOnce1(output, processResult);
		     
		      output = getOutput1();
		      
		      if (output == null)
		          break; 
		    } 
		  }
	  
	  public void operate4(RecipeOutput output) {
		    for (int i = 0; i < this.operationsPerTick; i++) {

		      List<ItemStack> processResult = output.items;
		      for (int j = 0; j < this.upgradeSlot.size(); j++) {
		        ItemStack stack = this.upgradeSlot.get(j);
		        if (stack != null && stack.getItem() instanceof IUpgradeItem)
		            ((IUpgradeItem)stack.getItem()).onProcessEnd(stack, this, processResult); 
		      } 
		      
		      operateOnce4(output, processResult);
		     
		      output = getOutput4();
		      
		      if (output == null)
		          break; 
		    } 
		  }
	  public void operate5(RecipeOutput output) {
		    for (int i = 0; i < this.operationsPerTick; i++) {

		      List<ItemStack> processResult = output.items;
		      for (int j = 0; j < this.upgradeSlot.size(); j++) {
		        ItemStack stack = this.upgradeSlot.get(j);
		        if (stack != null && stack.getItem() instanceof IUpgradeItem)
		            ((IUpgradeItem)stack.getItem()).onProcessEnd(stack, this, processResult); 
		      } 
		      
		      operateOnce5(output, processResult);
		     
		      output = getOutput5();
		      
		      if (output == null)
		          break; 
		    } 
		  }
	
	  public void operate6(RecipeOutput output) {
		    for (int i = 0; i < this.operationsPerTick; i++) {

		      List<ItemStack> processResult = output.items;
		      for (int j = 0; j < this.upgradeSlot.size(); j++) {
		        ItemStack stack = this.upgradeSlot.get(j);
		        if (stack != null && stack.getItem() instanceof IUpgradeItem)
		            ((IUpgradeItem)stack.getItem()).onProcessEnd(stack, this, processResult); 
		      } 
		      
		      operateOnce6(output, processResult);
		     
		      output = getOutput6();
		      
		      if (output == null)
		          break; 
		    } 
		  }
	
	 //
	  public void operate7(RecipeOutput output) {
		    for (int i = 0; i < this.operationsPerTick; i++) {

		      List<ItemStack> processResult = output.items;
		      for (int j = 0; j < this.upgradeSlot.size(); j++) {
		        ItemStack stack = this.upgradeSlot.get(j);
		        if (stack != null && stack.getItem() instanceof IUpgradeItem)
		            ((IUpgradeItem)stack.getItem()).onProcessEnd(stack, this, processResult); 
		      } 
		      
		      operateOnce7(output, processResult);
		     
		      output = getOutput7();
		      
		      if (output == null)
		          break; 
		    } 
		  }
	  public void operate8(RecipeOutput output) {
		    for (int i = 0; i < this.operationsPerTick; i++) {

		      List<ItemStack> processResult = output.items;
		      for (int j = 0; j < this.upgradeSlot.size(); j++) {
		        ItemStack stack = this.upgradeSlot.get(j);
		        if (stack != null && stack.getItem() instanceof IUpgradeItem)
		            ((IUpgradeItem)stack.getItem()).onProcessEnd(stack, this, processResult); 
		      } 
		      
		      operateOnce8(output, processResult);
		     
		      output = getOutput8();
		      
		      if (output == null)
		          break; 
		    } 
		  }
	
	  public void operate9(RecipeOutput output) {
		    for (int i = 0; i < this.operationsPerTick; i++) {

		      List<ItemStack> processResult = output.items;
		      for (int j = 0; j < this.upgradeSlot.size(); j++) {
		        ItemStack stack = this.upgradeSlot.get(j);
		        if (stack != null && stack.getItem() instanceof IUpgradeItem)
		            ((IUpgradeItem)stack.getItem()).onProcessEnd(stack, this, processResult); 
		      } 
		      
		      operateOnce9(output, processResult);
		     
		      output = getOutput9();
		      
		      if (output == null)
		          break; 
		    } 
		  }
	
	  public void operateOnce1(RecipeOutput output, List<ItemStack> processResult) {
		
	    this.inputSlotB.consume();
	    this.outputSlotB.add(processResult);
	  
	    
	 }
	  public void operateOnce(RecipeOutput output, List<ItemStack> processResult) {
		
		  this.inputSlotA.consume();
		  this.outputSlotA.add(processResult);
		  
		    
		 }
	  public void operateOnce3(RecipeOutput output, List<ItemStack> processResult) {
		
		  this.inputSlotC.consume();
		  this.outputSlotC.add(processResult);
		  
		    
		 }
	  public void operateOnce4(RecipeOutput output, List<ItemStack> processResult) {
		 
		  this.inputSlotA.consume();
		  this.outputSlotB.add(processResult);
		  
		    
		 }
	  public void operateOnce5(RecipeOutput output, List<ItemStack> processResult) {
		
		  this.inputSlotB.consume();
		  this.outputSlotC.add(processResult);
		  
		    
		 }
	  public void operateOnce6(RecipeOutput output, List<ItemStack> processResult) {
		 
		  this.inputSlotC.consume();
		  this.outputSlotA.add(processResult);
		  
		    
		 }
	  //
	  public void operateOnce7(RecipeOutput output, List<ItemStack> processResult) {
		 
		  this.inputSlotA.consume();
		  this.outputSlotC.add(processResult);
		  
		    
		 }
	  public void operateOnce8(RecipeOutput output, List<ItemStack> processResult) {
		 
		  this.inputSlotB.consume();
		  this.outputSlotA.add(processResult);
		  
		    
		 }
	  public void operateOnce9(RecipeOutput output, List<ItemStack> processResult) {
		 
		  this.inputSlotC.consume();
		  this.outputSlotB.add(processResult);
		  
		    
		 }
	  public RecipeOutput getOutput4() {
		    if (this.inputSlotA.isEmpty())
		      return null; 
		    RecipeOutput output = this.inputSlotA.process();
		    if (output == null)
		      return null; 
		    if (this.outputSlotB.canAdd(output.items))
		      return output; 
		    return null;
		  }
	  public RecipeOutput getOutput7() {
		    if (this.inputSlotA.isEmpty())
		      return null; 
		    RecipeOutput output = this.inputSlotA.process();
		    if (output == null)
		      return null; 
		    if (this.outputSlotC.canAdd(output.items))
		      return output; 
		    return null;
		  }
	  public RecipeOutput getOutput8() {
		    if (this.inputSlotB.isEmpty())
		      return null; 
		    RecipeOutput output = this.inputSlotB.process();
		    if (output == null)
		      return null; 
		    if (this.outputSlotA.canAdd(output.items))
		      return output; 
		    return null;
		  }
	  public RecipeOutput getOutput5() {
		    if (this.inputSlotB.isEmpty())
		      return null; 
		    RecipeOutput output = this.inputSlotB.process();
		    if (output == null)
		      return null; 
		    if (this.outputSlotC.canAdd(output.items))
		      return output; 
		    return null;
		  }
	  public RecipeOutput getOutput9() {
		    if (this.inputSlotC.isEmpty())
		      return null; 
		    RecipeOutput output = this.inputSlotC.process();
		    if (output == null)
		      return null; 
		    if (this.outputSlotB.canAdd(output.items))
		      return output; 
		    return null;
		  }
	  public RecipeOutput getOutput6() {
		    if (this.inputSlotC.isEmpty())
		      return null; 
		    RecipeOutput output = this.inputSlotC.process();
		    if (output == null)
		      return null; 
		    if (this.outputSlotA.canAdd(output.items))
		      return output; 
		    return null;
		  }
	  public RecipeOutput getOutput1() {
		    if (this.inputSlotB.isEmpty())
		      return null; 
		    RecipeOutput output = this.inputSlotB.process();
		    if (output == null)
		      return null; 
		    if (this.outputSlotB.canAdd(output.items))
		      return output; 
		    return null;
		  }
	  public RecipeOutput getOutput() {
		    if (this.inputSlotA.isEmpty())
		      return null; 
		    RecipeOutput output = this.inputSlotA.process();
		    if (output == null)
		      return null; 
		    if (this.outputSlotA.canAdd(output.items))
		      return output; 
		    return null;
		  }
	  public RecipeOutput getOutput2() {
		    if (this.inputSlotC.isEmpty())
		      return null; 
		    RecipeOutput output = this.inputSlotC.process();
		    if (output == null)
		      return null; 
		    if (this.outputSlotC.canAdd(output.items))
		      return output; 
		    return null;
		  }
	  
  public abstract String getInventoryName();
  
  public ContainerBase<? extends TileEntityTripleMachine> getGuiContainer(EntityPlayer entityPlayer) {
    return (ContainerBase<? extends TileEntityTripleMachine>)new ContainerTripleMachine(entityPlayer, this);
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
