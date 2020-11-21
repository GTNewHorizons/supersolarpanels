// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.base;

import java.util.Arrays;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import cpw.mods.fml.common.eventhandler.Event;
import ic2.api.energy.event.EnergyTileLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import java.util.List;
import net.minecraft.item.ItemStack;
import java.util.Random;

import com.Denfop.container.ContainerAdvSolarPanel;

import ic2.api.network.INetworkUpdateListener;
import ic2.api.network.INetworkDataProvider;
import net.minecraft.inventory.IInventory;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.tile.IWrenchable;
import ic2.api.energy.tile.IEnergyTile;

public class TileEntitySolarPanel extends TileEntityBase implements IEnergyTile, IWrenchable, IEnergySource, IInventory, INetworkDataProvider, INetworkUpdateListener
{
    public static Random randomizer;
    public int ticker;
    public int generating;
    public int genDay;
    public int genNight;
    public boolean initialized;
    public boolean sunIsUp;
    public boolean skyIsVisible;
    private short facing;
    private boolean noSunWorld;
    private boolean wetBiome;
    private int machineTire;
    public boolean addedToEnergyNet;
    private boolean created;
    private ItemStack[] chargeSlots;
    public int fuel;
    private int lastX;
    private int lastY;
    private int lastZ;
    public int storage;
    private int solarType;
    public String panelName;
    public int production;
    public int maxStorage;
    public boolean loaded;
    private static List<String> fields;
    
    public TileEntitySolarPanel(final String gName, final int typeSolar, final int gDay, final int gNight, final int gOutput, final int gmaxStorage) {
        this.loaded = false;
        this.created = false;
        this.facing = 2;
        this.solarType = typeSolar;
        this.genDay = gDay;
        this.genNight = gNight;
        this.storage = 0;
        this.panelName = gName;
        this.sunIsUp = false;
        this.skyIsVisible = false;
        this.maxStorage = gmaxStorage;
        this.chargeSlots = new ItemStack[4];
        this.initialized = false;
        this.production = gOutput;
        this.ticker = TileEntitySolarPanel.randomizer.nextInt(this.tickRate());
        this.lastX = this.xCoord;
        this.lastY = this.yCoord;
        this.lastZ = this.zCoord;
        this.machineTire = Integer.MAX_VALUE;
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
            MinecraftForge.EVENT_BUS.post((Event)new EnergyTileLoadEvent((IEnergyTile)this));
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
            MinecraftForge.EVENT_BUS.post((Event)new EnergyTileUnloadEvent((IEnergyTile)this));
            this.addedToEnergyNet = false;
        }
        this.loaded = false;
    }
    
    public void intialize() {
        this.wetBiome = (this.worldObj.getWorldChunkManager().getBiomeGenAt(this.xCoord, this.zCoord).getIntRainfall() > 0);
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
        this.gainFuel();
        if (this.generating > 0) {
            if (this.storage + this.generating <= this.maxStorage) {
                this.storage += this.generating;
            }
            else {
                this.storage = this.maxStorage;
            }
        }
        boolean needInvUpdate = false;
        double sentPacket = 0.0;
        for (int i = 0; i < this.chargeSlots.length; ++i) {
            if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof IElectricItem && this.storage > 0) {
                sentPacket = ElectricItem.manager.charge(this.chargeSlots[i], (double)this.storage, Integer.MAX_VALUE, false, false);
                if (sentPacket > 0.0) {
                    needInvUpdate = true;
                }
                this.storage -= (int)sentPacket;
            }
        }
        if (needInvUpdate) {
            super.markDirty();
        }
    }
    
    public int gainFuel() {
    	if(solarType == 0) {
        if (this.ticker++ % this.tickRate() == 0) {
            this.updateVisibility();
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0 + this.genDay;
        }
        if (this.skyIsVisible) {
            return this.generating = 0 + this.genNight;
        }
        return this.generating = 0;
    }  
    
    //
	if(solarType == 1) {
		if(this.yCoord >= 130) {
        if (this.ticker++ % this.tickRate() == 0) {
            this.updateVisibility();
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0 + 2 * this.genDay;
        }
        if (this.skyIsVisible) {
            return this.generating = 0 + 2 * this.genNight;
        }
        
      
	
	}else {
		if (this.ticker++ % this.tickRate() == 0) {
            this.updateVisibility();
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0 + this.genDay;
        }
        if (this.skyIsVisible) {
            return this.generating = 0 + this.genNight;
        }
        return this.generating = 0;
    }  
	}
	//
	if(solarType == 2) {
		if(this.yCoord <= 40) {
        if (this.ticker++ % this.tickRate() == 0) {
            this.updateVisibility();
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0 + 2 * this.genDay;
        }
        if (this.skyIsVisible) {
            return this.generating = 0 + 2 * this.genNight;
        }
        
      
	
	}else {
		if (this.ticker++ % this.tickRate() == 0) {
            this.updateVisibility();
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0 + this.genDay;
        }
        if (this.skyIsVisible) {
            return this.generating = 0 + this.genNight;
        }
        return this.generating = 0;
    }  
	}
	//
	if(solarType == 3) {
		if(this.worldObj.provider.dimensionId == -1) {
        
            return this.generating = 0 + 2 * this.genDay;
        
        
      
	
	}else {
		if (this.ticker++ % this.tickRate() == 0) {
            this.updateVisibility();
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0 + this.genDay;
        }
        if (this.skyIsVisible) {
            return this.generating = 0 + this.genNight;
        }
        return this.generating = 0;
    }  
	}//
	if(solarType == 4) {
		if(this.worldObj.provider.dimensionId == 1) {
        
            return this.generating = 0 + 2 * this.genDay;
        
        
      
	
	}else {
		if (this.ticker++ % this.tickRate() == 0) {
            this.updateVisibility();
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0 + this.genDay;
        }
        if (this.skyIsVisible) {
            return this.generating = 0 + this.genNight;
        }
        return this.generating = 0;
    }  
	}
	//
	if(solarType == 5) {
		
        if (this.ticker++ % this.tickRate() == 0) {
            this.updateVisibility();
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0 + 0 * this.genDay;
        }
        if (this.skyIsVisible) {
            return this.generating = 0 + 2 * this.genNight;
        }
        
      
	
	 
	}
	//
if(solarType == 6) {
		
        if (this.ticker++ % this.tickRate() == 0) {
            this.updateVisibility();
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0 + 2 * this.genDay;
        }
        if (this.skyIsVisible) {
            return this.generating = 0 + 0 * this.genNight;
        }
        
      
	
	 
	}//
if(solarType == 7) {
	if(this.wetBiome && (this.worldObj.isRaining() || this.worldObj.isThundering())) {
    if (this.ticker++ % this.tickRate() == 0) {
        this.updateVisibility();
    }

        return this.generating = 0 + 2 * this.genNight;
    
    
	}else {
		if (this.ticker++ % this.tickRate() == 0) {
	        this.updateVisibility();
	    }
	    if (this.sunIsUp && this.skyIsVisible) {
	        return this.generating = 0 + this.genDay;
	    }
	    if (this.skyIsVisible) {
	        return this.generating = 0 +  this.genNight;
	    }
	}

 
}
	//
	return this.generating = 0;
    }
    
    public void updateVisibility() {
        
       
        	final Boolean rainWeather = this.wetBiome && (this.worldObj.isRaining() || this.worldObj.isThundering());
        if (!this.worldObj.isDaytime() || rainWeather) {
        	
            this.sunIsUp = false;
        }
        else {
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
        this.storage = nbttagcompound.getInteger("storage");
        this.lastX = nbttagcompound.getInteger("lastX");
        this.lastY = nbttagcompound.getInteger("lastY");
        this.lastZ = nbttagcompound.getInteger("lastZ");
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
        nbttagcompound.setInteger("storage", this.storage);
        nbttagcompound.setInteger("lastX", this.lastX);
        nbttagcompound.setInteger("lastY", this.lastY);
        nbttagcompound.setInteger("lastZ", this.lastZ);
        for (int i = 0; i < this.chargeSlots.length; ++i) {
            if (this.chargeSlots[i] != null) {
                final NBTTagCompound nbttagcompound2 = new NBTTagCompound();
                nbttagcompound2.setByte("Slot", (byte)i);
                this.chargeSlots[i].writeToNBT(nbttagcompound2);
                nbttaglist.appendTag((NBTBase)nbttagcompound2);
            }
        }
        nbttagcompound.setTag("Items", (NBTBase)nbttaglist);
    }
    
    public boolean isAddedToEnergyNet() {
        return this.addedToEnergyNet;
    }
    
    public int getMaxEnergyOutput() {
        return this.production;
    }
    
    public int gaugeEnergyScaled(final int i) {
        return this.storage * i / this.maxStorage;
    }
    
    public int gaugeFuelScaled(final int i) {
        return i;
    }
    
    public boolean isUseableByPlayer(final EntityPlayer entityplayer) {
        return entityplayer.getDistance(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5) <= 64.0;
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
        return new ItemStack(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord), 1, this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord));
    }
    
    public ItemStack[] getContents() {
        return this.chargeSlots;
    }
    
    public int getSizeInventory() {
        return 4;
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
        return "Super Solar Panel";
    }
    
    public boolean hasCustomInventoryName() {
        return false;
    }
    
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public Container getGuiContainer(final InventoryPlayer inventoryplayer) {
        return new ContainerAdvSolarPanel(inventoryplayer, this);
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
        return TileEntitySolarPanel.fields;
    }
    
    public boolean emitsEnergyTo(final TileEntity receiver, final ForgeDirection direction) {
        return true;
    }
    
    public double getOfferedEnergy() {
        return Math.min(this.production, this.storage);
    }
    
    public void drawEnergy(final double amount) {
        this.storage -= (int)amount;
    }
    
    public int getSourceTier() {
        return this.machineTire;
    }
    
    static {
        TileEntitySolarPanel.randomizer = new Random();
        TileEntitySolarPanel.fields = Arrays.asList(new String[0]);
    }

	
}
