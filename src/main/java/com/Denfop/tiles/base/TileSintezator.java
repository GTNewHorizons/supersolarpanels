


package com.Denfop.tiles.base;
import com.Denfop.Config;
import java.util.Arrays;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.block.Block;
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

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import java.util.Random;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.integration.Avaritia.ItemAvSolarPanel;
import com.Denfop.integration.Avaritia.modules2;
import com.Denfop.integration.Botania.ItemBotSolarPanel;
import com.Denfop.integration.Botania.modules1;
import com.Denfop.integration.DE.ItemDESolarPanel;
import com.Denfop.item.Modules.module6;
import com.Denfop.item.base.ItemSSPSolarPanel;

import ic2.api.network.INetworkUpdateListener;
import ic2.api.network.INetworkDataProvider;
import net.minecraft.inventory.IInventory;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.tile.IWrenchable;
import ic2.api.energy.tile.IEnergyTile;

public class TileSintezator extends TileEntityBase implements IEnergyTile, IWrenchable, IEnergySource, IInventory, INetworkDataProvider, INetworkUpdateListener
{private TileSintezator tileentity;
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
    public boolean wetBiome;
    private int machineTire;
    public boolean addedToEnergyNet;
    private boolean created;
    public  ItemStack[] chargeSlots;
    public int fuel;
    private int lastX;
    private int lastY;
    private int lastZ;
    public int storage;
    public int solarType;
    public String panelName;
    public int production;
    public int maxStorage;
    public int p;
    public boolean loaded;
	private int k;
	private int m;
	public int u;
	private module6 panel;
	public int tier;
	public int l;
	public boolean modules;
	
    private static List<String> fields;
    
    public TileSintezator(final String gName,final int tier) {
        
    	this.loaded = false;
        this.created = false;
        this.facing = 2;

        this.storage = 0;
        this.panelName = gName;
        this.sunIsUp = false;
        this.skyIsVisible = false;

        this.l = 0;
        this.genNight = 0;
        this.genDay = 0;
        this.chargeSlots = new ItemStack[10];
        this.initialized = false;
       this.maxStorage = 0;
        this.ticker = TileSintezator.randomizer.nextInt(this.tickRate());
        this.lastX = this.xCoord;
        this.lastY = this.yCoord;
        this.lastZ = this.zCoord;
        this.machineTire = tier;
        this.tier = tier;
    }
    public int getSolarType() {
    	int type = this.solarType;
    	return type;
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
  
        boolean needInvUpdate = false;
        double sentPacket = 0.0;
        int[] myArray; 
        int[] myArray1; 
        int[] myArray2; 
        int[] myArray3; 
        int[] k; 
        int[] k1; 
        int[] k2; 
        int[] k3; 
        int[] m; 
        int[] m1; 
        int[] m2; 
        int[] m3; 
        int[] n; 
        int[] n1; 
        int[] n2; 
        int[] n3; 
        myArray = new int[10]; 
        myArray1 = new int[10]; 
        myArray2 = new int[10]; 
        myArray3 = new int[10]; 
        k = new int[10]; 
        k1= new int[10]; 
        k2 = new int[10]; 
        k3 = new int[10]; 
        m = new int[10]; 
        m1= new int[10]; 
        m2 = new int[10]; 
        m3 = new int[10];
        n = new int[10]; 
        n1= new int[10]; 
        n2 = new int[10]; 
        n3 = new int[10];
        
        for(int i = 0; i <10;i++) {
   
        		if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof ItemSSPSolarPanel) {
        			int g = chargeSlots[i].getItemDamage();
            		int p = chargeSlots[i].stackSize;
            		if(p <=  Config.limit) {
            			myArray[i] = module6.GenDay(g) * p;
            			myArray1[i] = module6.GenNight(g)* p;
            			myArray2[i] = module6.storage(g)* p;
            			myArray3[i] = module6.Output(g)* p;
                		}else {
                			myArray[i] = module6.GenDay(g) *  Config.limit ;
                			myArray1[i] = module6.GenNight(g)*  Config.limit ;
                			myArray2[i] = module6.storage(g)*  Config.limit ;
                			myArray3[i]  = module6.Output(g)*  Config.limit ;
                		}
        		}
        	
        }
        //
        if(SuperSolarPanels.AvaritiaLoaded && SuperSolarPanels.Avaritia == true) {
        for(int i = 0; i <10;i++) {
        	   
    		if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof ItemAvSolarPanel) {
    			int g = chargeSlots[i].getItemDamage();
        		int p = chargeSlots[i].stackSize;
        		if(p <=  Config.limit) {
        			k[i] = modules2.GenDay(g) * p;
        			k1[i] = modules2.GenNight(g)* p;
        			k2[i] = modules2.storage(g)* p;
        			k3[i] = modules2.Output(g)* p;
            		}else {
            			k[i] = modules2.GenDay(g) *  Config.limit ;
            			k1[i] = modules2.GenNight(g)*  Config.limit ;
            			k2[i] = modules2.storage(g)*  Config.limit ;
            			k3[i]  = modules2.Output(g)*  Config.limit ;
            		}
    		}
    	
    }}//
        if(SuperSolarPanels.BotaniaLoaded && SuperSolarPanels.Botania == true) {
            for(int i = 0; i <10;i++) {
            	   
        		if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof ItemBotSolarPanel) {
        			int g = chargeSlots[i].getItemDamage();
            		int p = chargeSlots[i].stackSize;
            		if(p <=  Config.limit) {
            			m[i] = modules1.GenDay(g) * p;
            			m1[i] = modules1.GenNight(g)* p;
            			m2[i] = modules1.storage(g)* p;
            			m3[i] = modules1.Output(g)* p;
                		}else {
                			m[i] = modules1.GenDay(g) *  Config.limit ;
                			m1[i] = modules1.GenNight(g)*  Config.limit ;
                			m2[i] = modules1.storage(g)*  Config.limit ;
                			m3[i]  = modules1.Output(g)*  Config.limit ;
                		}
        		}
        	
        }}
        //
        if(SuperSolarPanels.DraconicLoaded && SuperSolarPanels.Draconic == true) {
            for(int i = 0; i <10;i++) {
            	   
        		if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof ItemDESolarPanel) {
        			int g = chargeSlots[i].getItemDamage();
            		int p = chargeSlots[i].stackSize;
            		if(p <=  Config.limit) {
            			n[i] = com.Denfop.integration.DE.modules.GenDay(g) * p;
            			n1[i] =  com.Denfop.integration.DE.modules.GenNight(g)* p;
            			n2[i] =  com.Denfop.integration.DE.modules.storage(g)* p;
            			n3[i] =  com.Denfop.integration.DE.modules.Output(g)* p;
                		}else {
                			n[i] =  com.Denfop.integration.DE.modules.GenDay(g) *  Config.limit ;
                			n1[i] =  com.Denfop.integration.DE.modules.GenNight(g)*  Config.limit ;
                			n2[i] =  com.Denfop.integration.DE.modules.storage(g)*  Config.limit ;
                			n3[i]  =  com.Denfop.integration.DE.modules.Output(g)*  Config.limit ;
                		}
        		}
        	
        }}
        //
       
        //
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for(int i = 0; i <9;i++) {
        	sum = sum + myArray[i] + k[i]+ m[i]+n[i];
        	sum1 = sum1 + myArray1[i]+ k1[i]+ m1[i]+n1[i];
        	sum2 = sum2 + myArray2[i]+ k2[i]+ m2[i]+n2[i];
        	sum3 = sum3 + myArray3[i]+ k3[i]+ m3[i]+n3[i];
        	
        }
if(sum < 2147000000) {
        	this.genDay  = sum;}else if(sum < 0){
        		this.genDay = 0;
        	}else {
        		this.genDay = 2146999999;
        	}
if(sum1 < 2146999999) {
        	this.genNight  = sum1;}else {
        		this.genNight = 2146999999;
        	}//
       if(sum2 < 0) {
        		this.maxStorage = 2146999999;
        	}else if(sum2 > 2147000000){
        		this.maxStorage = 2146999999;
        	}else {
        		this.maxStorage = sum2;
        	}
        //
        if(sum3 < 2147000000)	{
        this.production  = sum3;}else {
        	this.production = 2146999999;
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
            if(this.storage < 0) {
            	this.storage = 0;
            }
            if(this.maxStorage <= 0) {
            	this.storage = 0;
            }
        if (needInvUpdate) {
            super.markDirty();
        }
    }
    
    public int gainFuel() {
    	
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
 
    public void updateVisibility() {
        
       
        	final Boolean rainWeather = this.wetBiome && (this.worldObj.isRaining() || this.worldObj.isThundering());
        if (!this.worldObj.isDaytime() || rainWeather) {
        	
            this.sunIsUp = false;
        }
        else {
            this.sunIsUp = true;
        }
       
            this.skyIsVisible = true;
        
       
    }
    public void readFromNBT(final NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        this.storage = nbttagcompound.getInteger("storage");
        this.lastX = nbttagcompound.getInteger("lastX");
        this.lastY = nbttagcompound.getInteger("lastY");
        this.lastZ = nbttagcompound.getInteger("lastZ");
        this.solarType = nbttagcompound.getInteger("solarType");
        this.genDay = nbttagcompound.getInteger("genDay");
        this.genNight = nbttagcompound.getInteger("genNight");
     
        this.production = nbttagcompound.getInteger("production");
        
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
        nbttagcompound.setInteger("genDay",this.genDay);
        nbttagcompound.setInteger("genNight",this.genNight);
        
         nbttagcompound.setInteger("production",this.production);
        nbttagcompound.setInteger("solarType", this.solarType);
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
    
    public boolean isAddedToEnergyNet() {
        return this.addedToEnergyNet;
    }
    
    public int getMaxEnergyOutput() {
        return this.production;
    }
    
    public float gaugeEnergyScaled(final float i) {
        int[] m2; 
        m2 = new int[10]; 
    	if(SuperSolarPanels.BotaniaLoaded && SuperSolarPanels.Botania == true) {
            for(int j = 0; j <10;j++) {
            	   
        		if(this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof ItemBotSolarPanel) {
        			int g = chargeSlots[j].getItemDamage();
            		int p = chargeSlots[j].stackSize;
            		if(p <=  Config.limit) {
            		
            			m2[j] = modules1.storage(g)* p;
            			
                		}else {
                			
                			m2[j] = modules1.storage(g)*  Config.limit ;
                		}
        		}
        	
        }}
    	//
    	
          int[] k2; 
          k2 = new int[10]; 
    	  if(SuperSolarPanels.AvaritiaLoaded && SuperSolarPanels.Avaritia == true) {
    	        for(int j = 0; j <10;j++) {
    	        	   
    	    		if(this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof ItemAvSolarPanel) {
    	    			int g = chargeSlots[j].getItemDamage();
    	        		int p = chargeSlots[j].stackSize;
    	        		if(p <=  Config.limit) {
    	        			k2[j] = modules2.storage(g)* p;
    	            		}else {
    	            			k2[j] = modules2.storage(g)*  Config.limit ;
    	            		}
    	    		}
    	    	
    	    }}
     //

          int[] n2; 
    	  n2 = new int[10]; 
    	  if(SuperSolarPanels.DraconicLoaded && SuperSolarPanels.Draconic == true) {
              for(int j = 0; j <10;j++) {
              	   
          		if(this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof ItemDESolarPanel) {
          			int g = chargeSlots[j].getItemDamage();
              		int p = chargeSlots[j].stackSize;
              		if(p <=  Config.limit) {
              			n2[j] =  com.Denfop.integration.DE.modules.storage(g)* p;
                  		}else {
                  			n2[j] =  com.Denfop.integration.DE.modules.storage(g)*  Config.limit ;
                  		}
          		}
          	
          }}
    	  //
         int[] myArray2; 
         myArray2 = new int[10]; 
         
         for(int j = 0; j <10;j++) {
    
         		if(this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof ItemSSPSolarPanel) {
         			int g = chargeSlots[j].getItemDamage();
             		int p = chargeSlots[j].stackSize;
             		if(p <=  Config.limit) {
             			myArray2[j] = module6.storage(g)* p;
                 		}else {
                 			myArray2[j] = module6.storage(g)*  Config.limit ;
                 		}
         		}
         	
         }
      
         int sum2 = 0;
         for(int j = 0; j <9;j++) {
         	sum2 = sum2 + myArray2[j]+k2[j]+m2[j]+n2[j];
         	
         }
if((sum2) !=0) {
         return  (float)(this.storage * i /( sum2));
        
}else {
	return 0;
}

    }
    
    public int gaugeFuelScaled(final int i) {
        return i;
    }
    
    @Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistance((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
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
        return 10;
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
        return new ContainerSinSolarPanel(inventoryplayer, this);
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
        return TileSintezator.fields;
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
    public void onGuiClosed(EntityPlayer entityPlayer) {}
    
    public int getSourceTier() {
        return this.machineTire;
    }
    
    static {
        TileSintezator.randomizer = new Random();
        TileSintezator.fields = Arrays.asList(new String[0]);
    }

	
}
