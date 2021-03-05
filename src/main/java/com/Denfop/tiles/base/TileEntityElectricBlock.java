package com.Denfop.tiles.base;

import com.Denfop.SuperSolarPanels;
import com.Denfop.container.ContainerElectricBlock;
import com.Denfop.gui.GuiElectricBlock;
import com.Denfop.item.Modules.ItemWirelessModule;
import com.Denfop.item.Modules.module7;
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
public abstract class TileEntityElectricBlock extends TileEntityInventory implements IEnergySink, IEnergySource, IHasGui, INetworkClientTileEntityEventListener, IEnergyStorage,IEnergyHandler,IEnergyReceiver {
  public final int tier;
  
  public final int output;
  
  public final int maxStorage;
  public double energy;
  
  public boolean hasRedstone;
  
  public byte redstoneMode;
  public  ItemStack[] chargeSlots;

public int maxStorage2;
public String UUID = null; 
public double energy2;
public boolean lastenergy_1=false;
public boolean lastenergy_2=false;
public boolean rf;
public int x =0;
public int y =0;
public int z = 0;
public boolean rfeu = false;
public boolean needsInvUpdate = false;
public boolean movementcharge = false;

public boolean movementchargerf= false;

public boolean movementchargeitemrf= false;

  public TileEntityElectricBlock(int tier1, int output1, int maxStorage1) {
    this.energy = 0.0D;
    this.energy2 = 0.0D;
    this.hasRedstone = false;
    this.redstoneMode = 0;
    this.isEmittingRedstone = false;
    this.redstoneUpdateInhibit = 5;
    this.addedToEnergyNet = false;
    this.tier = tier1;
    this.output = output1;
    this.maxStorage = maxStorage1;
    this.maxStorage2 = maxStorage1;
    this.chargeSlots = new ItemStack[3];
    this.rf = false;
  }
  
  public float getChargeLevel() {
	 
	  float   ret = (float)this.energy / this.maxStorage;
    
	  
    if (ret > 1.0F)
      ret = 1.0F; 
    return ret;
  }
  public float getChargeLevel1() {
		 
	  float   ret = (float)this.energy2 / this.maxStorage2;
    
	  
    if (ret > 1.0F)
      ret = 1.0F; 
    return ret;
  }
  public void readFromNBT(NBTTagCompound nbttagcompound) {
    super.readFromNBT(nbttagcompound);
    this.UUID= nbttagcompound.getString("UUID");
    this.personality= nbttagcompound.getBoolean("personality");
    this.energy2 = Util.limit(nbttagcompound.getDouble("energy2"), 0.0D, this.maxStorage2 + EnergyNet.instance.getPowerFromTier(this.tier));
	
    this.energy = Util.limit(nbttagcompound.getDouble("energy"), 0.0D, this.maxStorage + EnergyNet.instance.getPowerFromTier(this.tier));
    this.redstoneMode = nbttagcompound.getByte("redstoneMode");
   
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
  
  public void writeToNBT(NBTTagCompound nbttagcompound) {
    super.writeToNBT(nbttagcompound);
    nbttagcompound.setDouble("energy", this.energy);
    nbttagcompound.setDouble("energy2", this.energy2);
    nbttagcompound.setBoolean("active", getActive());
    nbttagcompound.setByte("redstoneMode", this.redstoneMode);
    nbttagcompound.setString("UUID", this.UUID);
    nbttagcompound.setBoolean("personality", this.personality);
    final NBTTagList nbttaglist = new NBTTagList();
    for (int i = 0; i < this.chargeSlots.length; ++i) {
  	  final NBTTagCompound nbttagcompound2 = new NBTTagCompound();
      if (this.chargeSlots[i] != null) {
      	
        
          nbttagcompound2.setByte("Slot", (byte)i);
          this.chargeSlots[i].writeToNBT(nbttagcompound2);
          nbttaglist.appendTag((NBTBase)nbttagcompound2);
      }
  }
  nbttagcompound.setTag("Items", (NBTBase)nbttaglist);
  }
  public ItemStack[] getContents() {
      return this.chargeSlots;
  }
 
  public int getSizeInventory() {
      return 3;
  }
public ItemStack getStackInSlot(final int i) {
      return this.chargeSlots[i];
  }
  
public int getInventoryStackLimit() {
    return 64;
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
      if ( this.energy2 > 0) {
        int energyExtracted = (int) Math.min(this.energy2, maxExtract);
        if (!simulate) {
          this.energy2 -= energyExtracted;
         
        } 
        return energyExtracted;
      } 
      if (this.rf == true);
      return 0;
    }
  
  public boolean canConnectEnergy(ForgeDirection arg0) {
      return true;
    }
    
    public int getEnergyStored(ForgeDirection from) {
      return (int) this.energy2;
    }
    
    public int getMaxEnergyStored(ForgeDirection from) {
      return this.maxStorage2;
    }
   
  protected void updateEntityServer() {
    super.updateEntityServer();
    
    if(this.chargeSlots[0] != null && this.chargeSlots[0].getItem() instanceof module7) {
		int kk = chargeSlots[0].getItemDamage();
		if(kk == 0) {
			personality = true;
		}
    }
    if(this.chargeSlots[0] != null && this.chargeSlots[0].getItem() instanceof module7) {
    	if(chargeSlots[0].getItemDamage() == 5) {
    		this.movementcharge  = true;
    	}
    	if(chargeSlots[0].getItemDamage() == 6) {
    		this.movementchargeitem  = true;
    	}
    	if(chargeSlots[0].getItemDamage() == 7) {
    		this.movementchargerf  = true;
    	}
    	if(chargeSlots[0].getItemDamage() == 8) {
    		this.movementchargeitemrf  = true;
    	}
    	if(chargeSlots[0].getItemDamage() == 4) {
    	this.rf = true;}else {
    		this.rf=false;
    	}
    	if(this.rfeu == false) {
    	if (this.rf == true ) {
		      if (this.energy >= 0 && this.energy2 <= this.maxStorage2 ) {
		       
		   
		          
		        
		          this.energy2 += this.energy*4;
		          this.energy -= this.energy;
		       
		      } 
		if(this.energy2 >= this.maxStorage2) {
		int rf	= (int) (this.energy2-this.maxStorage2);
		this.energy += rf/4;
		this.energy2=this.maxStorage2;
		}
		
		
		}}else {
			if (this.rf == true ) {
			      if (this.energy2 >= 0 && this.energy <= this.maxStorage ) {
			       
			   
			          
			        
			          this.energy += this.energy2/4;
			          this.energy2 -= this.energy2;
			       
			      } 
			if(this.energy >= this.maxStorage) {
			int rf	= (int) (this.energy-this.maxStorage);
			this.energy2 += rf*4;
			this.energy=this.maxStorage2;
			}}
		}
    }else {
    	this.rf = false;
    }
   
    	
		IEnergyContainerItem item = null;
		if(this.energy2 >= 1.0D && this.chargeSlots[1] != null && this.chargeSlots[1].getItem() instanceof IEnergyContainerItem) {
			   item = (IEnergyContainerItem)this.chargeSlots[1].getItem();
	      setTransfer((extractEnergy(null, item.receiveEnergy(this.chargeSlots[1], (int) this.energy2, false), false) > 0));}else {
	    	  setTransfer(false);
	      }
	    
    
   if(this.energy2 >0) {
    for (ForgeDirection side : ForgeDirection.VALID_DIRECTIONS) {
        TileEntity tile = this.worldObj.getTileEntity(this.xCoord + side.offsetX, this.yCoord + side.offsetY, this.zCoord + side.offsetZ);
        if (tile instanceof IEnergyHandler)
          extractEnergy(side.getOpposite(), ((IEnergyHandler)tile).receiveEnergy(side.getOpposite(), extractEnergy(side.getOpposite(), (this.output * 4), true), false), false); 
      } }
        if(this.chargeSlots[0] != null && this.chargeSlots[0].getItem() instanceof ItemWirelessModule) {
   		 NBTTagCompound nbttagcompound = NBTData.getOrCreateNbtData(this.chargeSlots[0]);
   		 nbttagcompound.setInteger("Xcoord", this.xCoord);
   		 nbttagcompound.setInteger("Ycoord", this.yCoord);
   		 nbttagcompound.setInteger("Zcoord", this.zCoord);
   		 nbttagcompound.setInteger("tier", this.tier);
   		nbttagcompound.setInteger("World1", this.worldObj.provider.dimensionId);
   		nbttagcompound.setString("World", this.worldObj.provider.getDimensionName());
   		nbttagcompound.setString("Name", this.getInventoryName());
   	
   		
   		
   	
   	
   	}
    if (this.energy >= 1.0D && this.chargeSlots[1] != null && this.chargeSlots[1].getItem() instanceof ic2.api.item.IElectricItem) {

      double  sent = ElectricItem.manager.charge(this.chargeSlots[1], this.energy, 2147483647, false, false);
      this.energy -= sent;
      needsInvUpdate = (sent > 0.0D);
    } 
    if ( this.chargeSlots[2] != null && this.chargeSlots[2].getItem() instanceof ic2.api.item.IElectricItem&& this.energy >= 0.0D && this.energy <= this.maxStorage) {

        double  sent = ElectricItem.manager.discharge(this.chargeSlots[2], this.energy, 2147483647, false, true, false);
        this.energy += sent;
        needsInvUpdate = (sent > 0.0D);
    	
    } 
    if (this.redstoneMode == 5 || this.redstoneMode == 6)
      this.hasRedstone = this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord); 
    boolean shouldEmitRedstone = shouldEmitRedstone();
    if (shouldEmitRedstone != this.isEmittingRedstone) {
      this.isEmittingRedstone = shouldEmitRedstone;
      setActive(this.isEmittingRedstone);
      this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord));
    } 
    if (needsInvUpdate)
      markDirty(); 
  }
  public boolean transfer = false;
  public void setTransfer(boolean t) {
      this.transfer = t;
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
    this.rfeu = !this.rfeu;
  
  
  }
  
  
  
  public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
    ItemStack ret = super.getWrenchDrop(entityPlayer);
    float energyRetainedInStorageBlockDrops = ConfigUtil.getFloat(MainConfig.get(), "balance/energyRetainedInStorageBlockDrops");
    if (energyRetainedInStorageBlockDrops > 0.0F) {
    	
      NBTTagCompound nbttagcompound = NBTData.getOrCreateNbtData(ret);
      nbttagcompound.setDouble("energy", this.energy * energyRetainedInStorageBlockDrops);
      nbttagcompound.setDouble("energy2", this.energy2 * energyRetainedInStorageBlockDrops);
    } 
    return ret;
  }
  
  public int getStored() {
    return (int)this.energy;
  }
  
  public boolean wrenchCanRemove(final EntityPlayer entityPlayer) {
	   if( 	this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) instanceof TileEntityElectricBlock) {
		   TileEntityElectricBlock tile = 	(TileEntityElectricBlock) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord);
		
		   if(tile.chargeSlots[0] != null && tile.chargeSlots[0].getItem() instanceof module7) {
			   
			   if(tile.chargeSlots[0].getItemDamage() ==  0) {
			   if(entityPlayer.getDisplayName() == tile.UUID) {
				   return true;
			   }else {
				   entityPlayer.addChatMessage(new ChatComponentTranslation(String.format("ssp.error", new Object[0]), new Object[0]));
				      return false;
			   }
			   
		   }else{
			   return true;
		   
		   }}else {
			  
		   }}
			   return true;
		   }
  public int getCapacity() {
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
  
  public static byte redstoneModes = 7;
  
  private boolean isEmittingRedstone;
  
  private int redstoneUpdateInhibit;
  
  public boolean addedToEnergyNet;

public boolean movementchargeitem = false;

public boolean personality = false;




  
}
