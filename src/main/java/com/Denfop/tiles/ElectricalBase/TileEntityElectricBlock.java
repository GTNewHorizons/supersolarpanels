package com.Denfop.tiles.ElectricalBase;

import com.Denfop.item.Modules.module1;
import com.Denfop.item.Modules.module2;
import com.Denfop.item.Modules.module3;
import com.Denfop.item.Modules.module4;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.energy.EnergyNet;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.energy.tile.IEnergyTile;
import ic2.api.network.INetworkClientTileEntityEventListener;
import ic2.api.tile.IEnergyStorage;
import ic2.core.ContainerBase;
import ic2.core.IC2;
import ic2.core.IHasGui;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlot;
import ic2.core.block.invslot.InvSlot.Access;
import ic2.core.block.invslot.InvSlotCharge;
import ic2.core.block.invslot.InvSlotDischarge;
import ic2.core.init.MainConfig;
import ic2.core.util.ConfigUtil;
import ic2.core.util.StackUtil;
import ic2.core.util.Util;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityElectricBlock extends TileEntityInventory implements IEnergySink, IEnergySource, IHasGui, INetworkClientTileEntityEventListener, IEnergyStorage {
  public final int tier;
  
  public final int output;
  
  public int maxStorage;
  
  public double energy;
  
  public boolean hasRedstone;
  
  public byte redstoneMode;

public ItemStack[] chargeSlots;

public int p;



  
  public TileEntityElectricBlock(int tier1, int output1, int maxStorage1) {
    this.energy = 0.0D;
    this.hasRedstone = false;
    this.redstoneMode = 0;
    this.isEmittingRedstone = false;
    this.redstoneUpdateInhibit = 5;
    this.addedToEnergyNet = false;
    this.tier = tier1;
    this.output = output1;
    this.maxStorage = maxStorage1;
    this.p =maxStorage1;
    this.chargeSlots = new ItemStack[1];
    this.chargeSlot = new InvSlotCharge(this, 0, tier1);
   
    this.dischargeSlot = new InvSlotDischarge(this, 1, InvSlot.Access.IO, tier1, InvSlot.InvSide.BOTTOM);
  }
  
  public float getChargeLevel() {
	  int maxstorage1 = 0;
	   
	    
  	if(this.chargeSlots[0] != null && this.chargeSlots[0].getItem() instanceof module3) {
  		maxstorage1++;}
  	
  	
  	this.maxStorage = (int) (p* Math.pow(1.5, maxstorage1));
  	
  
    float ret = (float)this.energy / this.maxStorage;
    if (ret > 1.0F)
      ret = 1.0F; 
    return ret;
  }
  
  public void readFromNBT(NBTTagCompound nbttagcompound) {
    super.readFromNBT(nbttagcompound);
    this.energy = Util.limit(nbttagcompound.getDouble("energy"), 0.0D, this.maxStorage + EnergyNet.instance.getPowerFromTier(this.tier));
    this.redstoneMode = nbttagcompound.getByte("redstoneMode");
    NBTTagList nbttaglist = nbttagcompound.getTagList("Items", 10);
    this.chargeSlots = new ItemStack[getSizeInventory()];
    for (int i = 0; i < nbttaglist.tagCount(); i++) {
      NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
      int j = nbttagcompound1.getByte("Slot") & 0xFF;
      if (j >= 0 && j < this.chargeSlots.length)
        this.chargeSlots[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1); 
    } 
  }
  
  public void writeToNBT(NBTTagCompound nbttagcompound) {
    super.writeToNBT(nbttagcompound);
    NBTTagList nbttaglist = new NBTTagList();
    nbttagcompound.setDouble("energy", this.energy);
    nbttagcompound.setBoolean("active", getActive());
    nbttagcompound.setByte("redstoneMode", this.redstoneMode);
    for (int i = 0; i < this.chargeSlots.length; i++) {
	      if (this.chargeSlots[i] != null) {
	        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	        nbttagcompound1.setByte("Slot", (byte)i);
	        this.chargeSlots[i].writeToNBT(nbttagcompound1);
	        nbttaglist.appendTag((NBTBase)nbttagcompound1);
	      } 
	    } 
	    nbttagcompound.setTag("Items", (NBTBase)nbttaglist);
    
  }
  
  public void onLoaded() {
    super.onLoaded();
    if (IC2.platform.isSimulating()) {
      MinecraftForge.EVENT_BUS.post((Event)new EnergyTileLoadEvent((IEnergyTile)this));
      this.addedToEnergyNet = true;
    } 
  }
  
  public void onUnloaded() {
    if (IC2.platform.isSimulating() && this.addedToEnergyNet) {
      MinecraftForge.EVENT_BUS.post((Event)new EnergyTileUnloadEvent((IEnergyTile)this));
      this.addedToEnergyNet = false;
    } 
    super.onUnloaded();
  }
  
  protected void updateEntityServer() {
    super.updateEntityServer();
    boolean needsInvUpdate = false;
    if (this.energy >= 1.0D) {
      double sent = this.chargeSlot.charge(this.energy);
      this.energy -= sent;
      needsInvUpdate = (sent > 0.0D);
    } 
    if (getDemandedEnergy() > 0.0D && !this.dischargeSlot.isEmpty()) {
      double gain = this.dischargeSlot.discharge(this.maxStorage - this.energy, false);
      this.energy += gain;
      needsInvUpdate = (gain > 0.0D);
    } 
    if (this.redstoneMode == 5 || this.redstoneMode == 6)
      this.hasRedstone = this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord); 
    boolean shouldEmitRedstone = shouldEmitRedstone();
    if (shouldEmitRedstone != this.isEmittingRedstone) {
      this.isEmittingRedstone = shouldEmitRedstone;
      setActive(this.isEmittingRedstone);
      this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord));
    } 
     int maxstorage1 = 0;
   
    
    	if(this.chargeSlots[0] != null && this.chargeSlots[0].getItem() instanceof module3) {
    		maxstorage1++;}
    	
    	
    	this.maxStorage = (int) (p* Math.pow(1.5, maxstorage1));
    	
    
    if (needsInvUpdate)
      markDirty(); 
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
  
  public double getOfferedEnergy() {
    if (this.energy >= this.output && (this.redstoneMode != 5 || !this.hasRedstone) && (this.redstoneMode != 6 || !this.hasRedstone || this.energy >= this.maxStorage))
      return Math.min(this.energy, this.output); 
    return 0.0D;
  }
  
  public void drawEnergy(double amount) {
    this.energy -= amount;
  }
  
  public double getDemandedEnergy() {
	  int maxstorage1 = 0;
	   
	    
  	if(this.chargeSlots[0] != null && this.chargeSlots[0].getItem() instanceof module3) {
  		maxstorage1++;}
  	
  	
  	this.maxStorage = (int) (p* Math.pow(1.5, maxstorage1));
  	
  
    return this.maxStorage - this.energy;
  }
  
  public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage) {
    if (this.energy >= this.maxStorage)
      return amount; 
    this.energy += amount;
    return 0.0D;
  }
  
  public int getSourceTier() {
    return this.tier;
  }
  
  public int getSinkTier() {
    return this.tier;
  }
  
  public ContainerBase<? extends TileEntityElectricBlock> getGuiContainer(EntityPlayer entityPlayer) {
    return (ContainerBase<? extends TileEntityElectricBlock>)new ContainerElectricBlock(entityPlayer, this);
  }
  
  @SideOnly(Side.CLIENT)
  public GuiScreen getGui(EntityPlayer entityPlayer, boolean isAdmin) {
    return (GuiScreen)new GuiElectricBlock(new ContainerElectricBlock(entityPlayer, this));
  }
  
  public void onGuiClosed(EntityPlayer entityPlayer) {}
  
  public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
    return (getFacing() != side);
  }
  
  public void setFacing(short facing) {
    if (this.addedToEnergyNet)
      MinecraftForge.EVENT_BUS.post((Event)new EnergyTileUnloadEvent((IEnergyTile)this)); 
    super.setFacing(facing);
    if (this.addedToEnergyNet) {
      this.addedToEnergyNet = false;
      MinecraftForge.EVENT_BUS.post((Event)new EnergyTileLoadEvent((IEnergyTile)this));
      this.addedToEnergyNet = true;
    } 
  }
  
  public boolean isEmittingRedstone() {
    return this.isEmittingRedstone;
  }
  
  public boolean shouldEmitRedstone() {
    boolean shouldEmitRedstone = false;
    switch (this.redstoneMode) {
      case 1:
        shouldEmitRedstone = (this.energy >= (this.maxStorage - this.output * 20));
        break;
      case 2:
        shouldEmitRedstone = (this.energy > this.output && this.energy < this.maxStorage);
        break;
      case 3:
        shouldEmitRedstone = ((this.energy > this.output && this.energy < this.maxStorage) || this.energy < this.output);
        break;
      case 4:
        shouldEmitRedstone = (this.energy < this.output);
        break;
    } 
    if (this.isEmittingRedstone == shouldEmitRedstone || this.redstoneUpdateInhibit == 0) {
      this.redstoneUpdateInhibit = 5;
      return shouldEmitRedstone;
    } 
    this.redstoneUpdateInhibit--;
    return this.isEmittingRedstone;
  }
  
  public void onNetworkEvent(EntityPlayer player, int event) {
    this.redstoneMode = (byte)(this.redstoneMode + 1);
    if (this.redstoneMode >= redstoneModes)
      this.redstoneMode = 0; 
    IC2.platform.messagePlayer(player, getredstoneMode(), new Object[0]);
  }
  
  public String getredstoneMode() {
    if (this.redstoneMode > 6 || this.redstoneMode < 0)
      return ""; 
    return StatCollector.translateToLocal("ic2.EUStorage.gui.mod.redstone" + this.redstoneMode);
  }
  
  public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
    ItemStack ret = super.getWrenchDrop(entityPlayer);
    float energyRetainedInStorageBlockDrops = ConfigUtil.getFloat(MainConfig.get(), "balance/energyRetainedInStorageBlockDrops");
    if (energyRetainedInStorageBlockDrops > 0.0F) {
      NBTTagCompound nbttagcompound = StackUtil.getOrCreateNbtData(ret);
      nbttagcompound.setDouble("energy", this.energy * energyRetainedInStorageBlockDrops);
    } 
    return ret;
  }
  
  public int getStored() {
    return (int)this.energy;
  }
  
  public int getCapacity() {
	  int maxstorage1 = 0;
	   
	    
  	if(this.chargeSlots[0] != null && this.chargeSlots[0].getItem() instanceof module3) {
  		maxstorage1++;}
  	
  	
  	this.maxStorage = (int) (p* Math.pow(1.5, maxstorage1));
  	
  
    return this.maxStorage;
  }
  
  public int getOutput() {
    return this.output;
  }
  
  public double getOutputEnergyUnitsPerTick() {
    return this.output;
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
  public ItemStack[] getContents() {
      return this.chargeSlots;
  }
 
  public int getSizeInventory() {
      return 1;
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
  public int getInventoryStackLimit() {
      return 64;
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
  public static byte redstoneModes = 7;
  
  private boolean isEmittingRedstone;
  
  private int redstoneUpdateInhibit;
  
  public boolean addedToEnergyNet;
  
  public final InvSlotCharge chargeSlot;
  
  public final InvSlotDischarge dischargeSlot;
}
