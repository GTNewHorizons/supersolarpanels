


package com.Denfop.tiles.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import net.minecraftforge.common.util.ForgeDirection;
import ru.wirelesstools.TileWirelessStorageBase;
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
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import java.util.Random;

import com.Denfop.SuperSolarPanels;
import com.Denfop.module1;
import com.Denfop.module2;
import com.Denfop.module3;
import com.Denfop.module4;
import com.Denfop.module5;
import com.Denfop.module6;
import com.Denfop.module7;
import com.Denfop.container.ContainerAdvSolarPanel;

import ic2.api.network.INetworkUpdateListener;
import ic2.api.network.INetworkDataProvider;
import net.minecraft.inventory.IInventory;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.tile.IWrenchable;
import ic2.api.energy.tile.IEnergyTile;

public class TileEntitySolarPanel extends TileEntityBase implements IEnergyTile, IWrenchable, IEnergySource, IInventory, INetworkDataProvider, INetworkUpdateListener
{private TileEntitySolarPanel tileentity;
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
		
	
	public boolean wirelles;
	
	
	public boolean isconnected;
		
	public ArrayList<Integer> xvalue = new ArrayList();
	public ArrayList<Integer> yvalue = new ArrayList();
	public ArrayList<Integer> zvalue = new ArrayList();
	
	public ArrayList<ArrayList<Integer>> xlist = new ArrayList();
	public ArrayList<ArrayList<Integer>> ylist = new ArrayList();
	public ArrayList<ArrayList<Integer>> zlist = new ArrayList();
	
	public ArrayList<TileWirelessStorageBase> listtiles = new ArrayList<TileWirelessStorageBase>();
	
	public Map<Double, Double> mapofcoords = new HashMap<Double, Double>();
	
	public ArrayList<Double> lista = new ArrayList<Double>();
	public ArrayList<Double> listb = new ArrayList<Double>();
	public ArrayList<Double> listc = new ArrayList<Double>();
	
	public Integer targetX;
	public Integer targetY;
	public Integer targetZ;
	
	protected int lasttargetX;
	protected int lasttargetY;
	protected int lasttargetZ;
	
	public Boolean targetSet;
	
	protected int wirelesstransferlimit;
	
	public TileWirelessStorageBase twsb;
	private int o;
	
	
    
    public TileEntitySolarPanel(final String gName,final int tier, final int typeSolar, final int gDay, final int gNight, final int gOutput, final int gmaxStorage) {
    	
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
        this.p =  gmaxStorage;
        this.k =  gDay;
        this.m = gNight;
        this.l = 0;
        this.targetSet = false;
		this.o = tier;
		this.wirelles = false;
        this.chargeSlots = new ItemStack[9];
        this.initialized = false;
        this.production = gOutput;
        this.u = gOutput;
        this.ticker = TileEntitySolarPanel.randomizer.nextInt(this.tickRate());
        this.lastX = this.xCoord;
        this.lastY = this.yCoord;
        this.lastZ = this.zCoord;
        this.machineTire = tier;
        this.tier = tier;
        
        this.lasttargetX = 0;
		this.lasttargetY = 0;
		this.lasttargetZ = 0;
		
		this.isconnected = false;
		
		
		this.wirelesstransferlimit = gOutput;
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
        int gend = 0;
        int genn = 0;
        int maxstorage1 = 0;
        int output = 0;
        
        for(int i= 0; i < 9; i++) {
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module1)
        	gend++;
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module2)
        		genn++;
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module3)
        		maxstorage1++;
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module4)
        		output++;
        	
        	if (this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof ic2.api.item.IElectricItem && this.storage > 0.0D) {
		        sentPacket = ElectricItem.manager.charge(this.chargeSlots[i], this.storage, 2147483647, false, false);
		        if (sentPacket > 0.0D)
		          needInvUpdate = true; 
		        this.storage -= (int)sentPacket;
		      } 
        	
        }
        int tierplus = 0;
        int minus = 0;
        for(int i = 0; i < 9;i++) {
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module7) {
        		int kk = chargeSlots[i].getItemDamage();
        		if(kk == 0) {
        			  compareTargets();
        		}
        		else if(kk == 1) {
        			tierplus++;
        		}
        		else if(kk == 2) {
        			minus++;
        		}
        		else if(kk == 3) {
        			
        			      
        			    
        		}
        	}
        }
        this.tier = this.o + tierplus -  minus;
        int m1 = 0; int m2 = 0; int m3 = 0; int m4 = 0; int m5 = 0; int m6 = 0; int m7 = 0; int m8 = 0; int m9 = 0;
        int n1 = 0; int n2 = 0;  int n3 = 0; int n4 = 0;  int n5 = 0; int n6 = 0;  int n7 = 0; int n8 = 0;  int n9 = 0;
        int v1 = 0; int v2 = 0; int v3 = 0; int v4 = 0; int v5 = 0; int v6 = 0; int v7 = 0; int v8 = 0; int v9 = 0; 
        int b1 = 0; int b2 = 0; int b3 = 0; int b4 = 0; int b5 = 0; int b6 = 0; int b7 = 0; int b8 = 0; int b9 = 0; 
        
        if(this.chargeSlots[8] != null && this.chargeSlots[8].getItem() instanceof module5) {
        	int g = chargeSlots[8].getItemDamage();
        	if( g == 0) {
        		this.solarType =1;
        		
        	}
        	else if( g == 1) {
        		this.solarType =2;
        		
        	}
        	else if( g == 2) {
        		this.solarType =3;
        	}
        	else if( g == 3) {
        		this.solarType =4;
        	}
        	else if( g == 4) {
        		this.solarType =5;
        	}
        	else if( g == 5) {
        		this.solarType =6;
        	}
        	else	if( g == 6) {
        		this.solarType =7;
        	}
        	else {
        		this.solarType = 0;
        		
        	}
        
        }else {
        	
        	this.solarType = 0;
        }
        	if(this.chargeSlots[0] != null && this.chargeSlots[0].getItem() instanceof module6) {
        		int g = chargeSlots[0].getItemDamage();
        		if(tier >= g+1) {
        		m1 = module6.GenDay(g);
        		n1 = module6.GenNight(g);
        		v1 = module6.storage(g);
        		b1 = module6.Output(g);
        		}
        	
        }
        	if(this.chargeSlots[1] != null && this.chargeSlots[1].getItem() instanceof module6) {
        		
        		int kk = chargeSlots[1].getItemDamage();
        		if(tier >= kk+1) {
        		m2 = module6.GenDay(kk);
        		n2 = module6.GenNight(kk);
        		v2 = module6.storage(kk);
        		b2 = module6.Output(kk);}
        	
        }
if(this.chargeSlots[2] != null && this.chargeSlots[2].getItem() instanceof module6) {
        		
        		int kk = chargeSlots[2].getItemDamage();
        		if(tier >= kk+1) {
        		m3 = module6.GenDay(kk);
        		n3 = module6.GenNight(kk);
        		v3 = module6.storage(kk);
        		b3 = module6.Output(kk);}
        	
        }
if(this.chargeSlots[3] != null && this.chargeSlots[3].getItem() instanceof module6) {
	
	int kk = chargeSlots[3].getItemDamage();
	if(tier >= kk+1) {
	m4 = module6.GenDay(kk);
	n4 = module6.GenNight(kk);
	v4 = module6.storage(kk);
	b4 = module6.Output(kk);}

}
if(this.chargeSlots[4] != null && this.chargeSlots[4].getItem() instanceof module6) {
	
	int kk = chargeSlots[4].getItemDamage();
	if(tier >= kk+1) {
	m5 = module6.GenDay(kk);
	n5 = module6.GenNight(kk);
	v5 = module6.storage(kk);
	b5 = module6.Output(kk);}

}
if(this.chargeSlots[5] != null && this.chargeSlots[5].getItem() instanceof module6) {
	
	int kk = chargeSlots[5].getItemDamage();
	if(tier >= kk+1) {
	m6 = module6.GenDay(kk);
	n6 = module6.GenNight(kk);
	v6 = module6.storage(kk);
	b6 = module6.Output(kk);}

}
if(this.chargeSlots[6] != null && this.chargeSlots[6].getItem() instanceof module6) {
	
	int kk = chargeSlots[6].getItemDamage();
	if(tier >= kk+1) {
	m7 = module6.GenDay(kk);
	n7 = module6.GenNight(kk);
	v7 = module6.storage(kk);
	b7 = module6.Output(kk);}

}
if(this.chargeSlots[7] != null && this.chargeSlots[7].getItem() instanceof module6) {
	
	int kk = chargeSlots[7].getItemDamage();
	if(tier >= kk+1) {
	m8 = module6.GenDay(kk);
	n8 = module6.GenNight(kk);
	v8 = module6.storage(kk);
	b8 = module6.Output(kk);}

}
if(this.chargeSlots[8] != null && this.chargeSlots[8].getItem() instanceof module6) {
	
	int kk = chargeSlots[8].getItemDamage();
	if(tier >= kk+1) {
	m9 = module6.GenDay(kk);
	n9 = module6.GenNight(kk);
	v9 = module6.storage(kk);
	b9 = module6.Output(kk);}

}
if((int) ((this.k + m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9) + (this.k + m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9)*0.2*gend) < 999999999) {
        	this.genDay  = (int) ((this.k + m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9) + (this.k + m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9)*0.2*gend);}else {
        		this.genDay = 999999998;
        	}
if((int) ((this.m + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9) + (this.m + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9)*0.2*genn) < 999999999) {
        	this.genNight  = (int) ((this.m + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9) + (this.m + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9)*0.2*genn);}else {
        		this.genNight = 999999998;
        	}
        if((int) ((this.p + v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9) + (this.p +  v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9)*0.2*maxstorage1) < 999999999) {
        	this.maxStorage  = (int) ((this.p + v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9) + (this.p +  v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9)*0.2*maxstorage1);}else {
        		this.maxStorage = 999999998;
        	}
        if((int) ((this.u +  b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9) + (this.u +  b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9)*0.2*output) < 999999999)	{
        this.production  = (int) ((this.u +  b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9) + (this.u +  b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9)*0.2*output);}else {
        	this.production = 999999998;
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
	if(solarType == 3) {
		if(this.worldObj.provider.dimensionId == -1) {
            return this.generating = 0 + 2 * this.genDay;}
		else {
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
			}  }
	if(solarType == 4) {
		if(this.worldObj.provider.dimensionId == 1) {
            return this.generating = 0 + 2 * this.genDay;
	}else {if (this.ticker++ % this.tickRate() == 0) {
        this.updateVisibility();
    }
    if (this.sunIsUp && this.skyIsVisible) {
        return this.generating = 0 + this.genDay;
    }
    if (this.skyIsVisible) {
        return this.generating = 0 + this.genNight;
    }
    return this.generating = 0;}}
	
	if(solarType == 5) {
		
        if (this.ticker++ % this.tickRate() == 0) {
            this.updateVisibility();
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0;
        }
        if (this.skyIsVisible) {
            return this.generating = 2 * this.genNight;
        }
	}
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
	}
if(solarType == 7) {
	if(this.worldObj.isRaining() || this.worldObj.isThundering() && this.worldObj.provider.dimensionId != 1 && this.worldObj.provider.dimensionId != -1) {
    if (this.ticker++ % this.tickRate() == 0) {
        this.updateVisibility();
    }
        return this.generating = 0 + 2 * this.genDay;
	}
	else { 
		return this.generating = 0;
	}
	    
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
        if (!this.worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord + 1, this.zCoord) || this.noSunWorld) {
            this.skyIsVisible = false;
        }
       
        else {
            this.skyIsVisible = true;
        }
       
    }
    
    protected void compareTargets() {
        if (!this.worldObj.isRemote)
          if (!this.lista.contains(null) && !this.listb.contains(null) && !this.listc.contains(null))
            for (Iterator<Double> iterator = this.lista.iterator(); iterator.hasNext(); ) {
              double i = ((Double)iterator.next()).doubleValue();
              for (Iterator<Double> iterator1 = this.listb.iterator(); iterator1.hasNext(); ) {
                double j = ((Double)iterator1.next()).doubleValue();
                for (Iterator<Double> iterator2 = this.listc.iterator(); iterator2.hasNext(); ) {
                  double k = ((Double)iterator2.next()).doubleValue();
                  if (this.mapofcoords.get(Double.valueOf(i)) != null && this.mapofcoords.get(Double.valueOf(j)) != null && this.mapofcoords.get(Double.valueOf(k)) != null) {
                    if ((TileWirelessStorageBase)this.worldObj.getTileEntity((int)((Double)this.mapofcoords.get(Double.valueOf(i))).doubleValue(), (int)((Double)this.mapofcoords.get(Double.valueOf(j))).doubleValue(), (int)((Double)this.mapofcoords.get(Double.valueOf(k))).doubleValue()) != null) {
                      this.listtiles.add((TileWirelessStorageBase)this.worldObj.getTileEntity((int)((Double)this.mapofcoords.get(Double.valueOf(i))).doubleValue(), (int)((Double)this.mapofcoords.get(Double.valueOf(j))).doubleValue(), (int)((Double)this.mapofcoords.get(Double.valueOf(k))).doubleValue()));
                      tryChargeBlocks(this.listtiles);
                      markDirty();
                    } 
                    continue;
                  } 
                  this.isconnected = false;
                } 
              } 
            }   
      }
      
      public void tryChargeBlocks(ArrayList<TileWirelessStorageBase> listtiles1) {
        if (!this.worldObj.isRemote)
          for (TileWirelessStorageBase te : listtiles1) {
            if ((this.isconnected & te.isconnected) != false) {
              if ((this.targetSet = Boolean.valueOf(true & (te.targetSet = true))).booleanValue()) 
                chargeBlocks(te); 
              continue;
            } 
            if (this.isconnected != te.isconnected && 
              this.targetSet.booleanValue() != te.targetSet) {
              if (te.isInvalid()) {
                te.targetSet = this.targetSet.booleanValue();
                this.isconnected = false;
                continue;
              } 
              if (!te.isInvalid()) {
                te.isconnected = false;
                this.isconnected = false;
                this.targetSet = Boolean.valueOf(false);
              } 
            } 
          }  
      }
      
      public void chargeBlocks(TileWirelessStorageBase te) {
        int sentPacket = this.wirelesstransferlimit;
        if (!this.worldObj.isRemote && (this.targetSet = Boolean.valueOf(true & (te.targetSet = true))).booleanValue() && (
          this.isconnected = true & (te.isconnected = true)))
          if ((((this.storage > 0.0D) ? 1 : 0) & ((this.storage != 0.0D) ? 1 : 0)) != 0)
            if (te.energy < te.maxStorage) {
            	System.out.println("invokes-te-Valid");
              te.energy += sentPacket;
              this.storage -= sentPacket;
              if (this.storage < 0)
                this.storage = 0; 
            }   
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
    	for(int l = 0,  m = 0, n = 0; l < this.lista.size() && m < this.listb.size() && n < this.listc.size(); l++, m++, n++) {
			NBTTagCompound com = new NBTTagCompound();
			
			if(this.worldObj.getTileEntity((int)this.mapofcoords.get(this.lista.get(l)).doubleValue(), (int)this.mapofcoords.get(this.listb.get(m)).doubleValue(), (int)this.mapofcoords.get(this.listc.get(n)).doubleValue()) != null) {
			
			com.setDouble("A", this.lista.get(l));
			com.setDouble("B", this.listb.get(m));
			com.setDouble("C", this.listc.get(n));
			
			com.setDouble("X", this.mapofcoords.get(this.lista.get(l))); // System.out.println("X value written: " + this.mapofcoords.get(this.lista.get(l)));
			com.setDouble("Y", this.mapofcoords.get(this.listb.get(m))); // System.out.println("Y value written: " + this.mapofcoords.get(this.listb.get(m)));
			com.setDouble("Z", this.mapofcoords.get(this.listc.get(n))); // System.out.println("Z value written: " + this.mapofcoords.get(this.listc.get(n)));
			
		//	System.out.println("A value written: " + this.lista.get(l));
		//	System.out.println("B value written: " + this.listb.get(m));
		//	System.out.println("C value written: " + this.listc.get(n));
			
			nbttaglist.appendTag(com);
			
			}
		}
		
		
		nbttagcompound.setTag("positions", nbttaglist);
		
		
		
	nbttagcompound.setDouble("energy", this.storage);
	nbttagcompound.setBoolean("targetset", this.targetSet);
	nbttagcompound.setBoolean("isconnected", this.isconnected);
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
        
        nbttagcompound.setInteger("storage", this.storage);
        nbttagcompound.setInteger("lastX", this.lastX);
        nbttagcompound.setInteger("lastY", this.lastY);
        nbttagcompound.setInteger("lastZ", this.lastZ);
        nbttagcompound.setInteger("genDay",this.genDay);
        nbttagcompound.setInteger("genNight",this.genNight);
        NBTTagList nbttaglist = (NBTTagList) nbttagcompound.getTag("positions");
		 
		 for(int i = 0; i < nbttaglist.tagCount(); i++) {
			 NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);
			 
			 
			 this.mapofcoords.put(nbttagcompound1.getDouble("A"), nbttagcompound1.getDouble("X"));
			 this.mapofcoords.put(nbttagcompound1.getDouble("B"), nbttagcompound1.getDouble("Y"));
			 this.mapofcoords.put(nbttagcompound1.getDouble("C"), nbttagcompound1.getDouble("Z"));
			 
			 
			 this.lista.add(nbttagcompound1.getDouble("A"));
			 this.listb.add(nbttagcompound1.getDouble("B"));
			 this.listc.add(nbttagcompound1.getDouble("C"));
			 
			
			 
		//	 System.out.println("X value read: " + nbttagcompound1.getInteger("X"));
		//	 System.out.println("Y value read: " + nbttagcompound1.getInteger("Y"));
		//	 System.out.println("Z value read: " + nbttagcompound1.getInteger("Z"));
			 
		//	 System.out.println("A value read: " + nbttagcompound1.getInteger("A"));
		//	 System.out.println("B value read: " + nbttagcompound1.getInteger("B"));
		//	 System.out.println("C value read: " + nbttagcompound1.getInteger("C"));
			 
			 
		 }
		 
		 this.storage = (int) nbttagcompound.getDouble("energy");
		 this.targetSet = nbttagcompound.getBoolean("targetset");
		 this.isconnected = nbttagcompound.getBoolean("isconnected");
         nbttagcompound.setInteger("production",this.production);
        nbttagcompound.setInteger("solarType", this.solarType);
        for (int i = 0; i < this.chargeSlots.length; ++i) {
        	  final NBTTagCompound nbttagcompound2 = new NBTTagCompound();
            if (this.chargeSlots[i] != null) {
            	if(this.chargeSlots[8] != null && this.chargeSlots[8].getItem() instanceof module5) {
            		nbttagcompound.setBoolean("RenderNewTexture", true);
            		nbttagcompound.setBoolean("modules",true);
            	}
              
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
    	
    	int maxstorage1 = 0;
    	 int v1 = 0; int v2 = 0; int v3 = 0; int v4 = 0; int v5 = 0; int v6 = 0; int v7 = 0; int v8 = 0; int v9 = 0; 
    	//
    	 for(int j= 0; j < 9; j++) {
         
         	if(this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof module3)
         		maxstorage1++;
         	
         }
    	 //
    	 
    	 if(this.chargeSlots[0] != null && this.chargeSlots[0].getItem() instanceof module6) {
     		int g = chargeSlots[0].getItemDamage();
     		if(tier >= g+1) {
     		v1 = module6.storage(g);
     		}
     	
     }
     	if(this.chargeSlots[1] != null && this.chargeSlots[1].getItem() instanceof module6) {
     		
     		int kk = chargeSlots[1].getItemDamage();
     		if(tier >= kk+1) {
     		v2 = module6.storage(kk);}
     	
     }
if(this.chargeSlots[2] != null && this.chargeSlots[2].getItem() instanceof module6) {
     		
     		int kk = chargeSlots[2].getItemDamage();
     		if(tier >= kk+1) {
     		v3 = module6.storage(kk);}
     	
     }
if(this.chargeSlots[3] != null && this.chargeSlots[3].getItem() instanceof module6) {
	
	int kk = chargeSlots[3].getItemDamage();
	if(tier >= kk+1) {
	v4 = module6.storage(kk);}

}
if(this.chargeSlots[4] != null && this.chargeSlots[4].getItem() instanceof module6) {
	
	int kk = chargeSlots[4].getItemDamage();
	if(tier >= kk+1) {
	v5 = module6.storage(kk);}

}
if(this.chargeSlots[5] != null && this.chargeSlots[5].getItem() instanceof module6) {
	
	int kk = chargeSlots[5].getItemDamage();
	if(tier >= kk+1) {
	v6 = module6.storage(kk);}

}
if(this.chargeSlots[6] != null && this.chargeSlots[6].getItem() instanceof module6) {
	
	int kk = chargeSlots[6].getItemDamage();
	if(tier >= kk+1) {
	v7 = module6.storage(kk);}

}
if(this.chargeSlots[7] != null && this.chargeSlots[7].getItem() instanceof module6) {
	
	int kk = chargeSlots[7].getItemDamage();
	if(tier >= kk+1) {
	
	v8 = module6.storage(kk);}

}
if(this.chargeSlots[8] != null && this.chargeSlots[8].getItem() instanceof module6) {
	
	int kk = chargeSlots[8].getItemDamage();
	if(tier >= kk+1) {
	
	v9 = module6.storage(kk);}

}
         return (int)( this.storage * i /(  ((this.p + v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9) + (this.p +  v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9)*0.2*maxstorage1)));
        
        
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
        return 9;
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
    private static List<String> fields = Arrays.asList(new String[0]);
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
    public void onGuiClosed(EntityPlayer entityPlayer) {}
    
    public int getSourceTier() {
        return this.machineTire;
    }
    
    static {
        TileEntitySolarPanel.randomizer = new Random();
        TileEntitySolarPanel.fields = Arrays.asList(new String[0]);
    }

	
}
