


package com.Denfop.tiles.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.server.MinecraftServer;
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
import java.util.Vector;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.WirellesStorage.TileWirelessStorageBase;
import com.Denfop.container.ContainerAdvSolarPanel;
import com.Denfop.item.Modules.module1;
import com.Denfop.item.Modules.module2;
import com.Denfop.item.Modules.module3;
import com.Denfop.item.Modules.module4;
import com.Denfop.item.Modules.module5;
import com.Denfop.item.Modules.module6;
import com.Denfop.item.Modules.module7;
import com.mojang.authlib.GameProfile;

import cofh.api.energy.IEnergyHandler;
import ic2.api.network.INetworkUpdateListener;
import ic2.api.network.INetworkDataProvider;
import net.minecraft.inventory.IInventory;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.tile.IWrenchable;
import ic2.core.IC2;
import ic2.core.block.personal.IPersonalBlock;
import ic2.core.init.MainConfig;
import ic2.core.network.NetworkManager;
import ic2.core.util.ConfigUtil;
import ic2.core.util.StackUtil;
import ic2.api.energy.tile.IEnergyTile;

public class TileEntitySolarPanel extends TileEntityBase implements IEnergyTile, IWrenchable, IEnergySource, IInventory, INetworkDataProvider, INetworkUpdateListener,IPersonalBlock,IEnergyHandler
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
	public int convertState = 0;
	 public int elapsedTicks;
	public boolean wirelles;
	
	private GameProfile owner = null;
	public boolean isconnected;
		
	public ArrayList<Integer> xvalue = new ArrayList();
	public ArrayList<Integer> yvalue = new ArrayList();
	public ArrayList<Integer> zvalue = new ArrayList();
	
	public ArrayList<ArrayList<Integer>> xlist = new ArrayList();
	public ArrayList<ArrayList<Integer>> ylist = new ArrayList();
	public ArrayList<ArrayList<Integer>> zlist = new ArrayList();
	 public int outputEnergyBuffer;
	public ArrayList<TileWirelessStorageBase> listtiles = new ArrayList<TileWirelessStorageBase>();
	  public long lastTimeStamp;
	public Map<Double, Double> mapofcoords = new HashMap<Double, Double>();
	  public int outputEnergyValue;
	public ArrayList<Double> lista = new ArrayList<Double>();
	public ArrayList<Double> listb = new ArrayList<Double>();
	public ArrayList<Double> listc = new ArrayList<Double>();
	
	public Integer targetX;
	public Integer targetY;
	public Integer targetZ;
	  public int inputEnergyBuffer;
	protected int lasttargetX;
	protected int lasttargetY;
	protected int lasttargetZ;
	
	public Boolean targetSet;
	
	protected int wirelesstransferlimit;
	
	public TileWirelessStorageBase twsb;
	public int o;
	public int storage2;
	  
	 public int tickRate = 40;  
	  public int inputEnergyValue;
	  public int maxStorage2;
	public int jj; 
	public int jj1; 
	public int jj2; 
	public int jj3;
	 public int maxRFproduction;
	  public int tickRateFlush = 5;
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
        this.maxStorage2 = this.maxStorage;
        this.targetSet = false;
		this.wirelles = false;
        this.chargeSlots = new ItemStack[9];
        this.initialized = false;
        this.production = gOutput;
        this.u = gOutput;
        this.maxRFproduction = gOutput * 8;
        this.ticker = TileEntitySolarPanel.randomizer.nextInt(this.tickRate());
        this.lastX = this.xCoord;
        this.lastY = this.yCoord;
        this.lastZ = this.zCoord;
        this.machineTire = this.o;
        this.tier = tier;
        
        this.lasttargetX = 0;
		this.lasttargetY = 0;
		this.lasttargetZ = 0;
		
		this.isconnected = false;
		
		
		this.wirelesstransferlimit = gOutput;
    }
    private int ticksSinceSync;
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
    private int numUsingPlayers;
    private void syncNumUsingPlayers() {
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord), 1, this.numUsingPlayers);
      }
    public void intialize() {
        this.wetBiome = (this.worldObj.getWorldChunkManager().getBiomeGenAt(this.xCoord, this.zCoord).getIntRainfall() > 0);
        this.noSunWorld = this.worldObj.provider.hasNoSky;
        this.updateVisibility();
        this.initialized = true;
        if (!this.addedToEnergyNet) {
            this.onLoaded();
        }
        this.lastTimeStamp = System.currentTimeMillis();
    }
   
        
    public void updateEntity() {
    	
        super.updateEntity();
        if (!this.initialized && this.worldObj != null) {
            this.intialize();
        }
        if (this.worldObj.isRemote) {
            return;
        }
        for(int i= 0; i < 9; i++) {
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module7) {
        		
        	if(this.chargeSlots[i].getItemDamage() == 5) {
        if (++this.ticksSinceSync % 20 * 4 == 0 && IC2.platform.isSimulating()) {
            syncNumUsingPlayers(); }
        
        }
        }}
        
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
        
        int tierplus = 0;
        int minus = 0;
        int output = 0;
        long nowTimeStamp = System.currentTimeMillis();
        int testStamp = Math.round((float)(nowTimeStamp - this.lastTimeStamp) / 1000.0F * 20.0F);
        this.elapsedTicks += testStamp;
        if (this.elapsedTicks == 0)
          this.elapsedTicks = 1; 
        if (this.inputEnergyBuffer > 0) {
          this.inputEnergyValue = Math.round((this.inputEnergyBuffer / this.elapsedTicks));
        } else {
          this.inputEnergyValue = 0;
        } 
        if (this.outputEnergyBuffer > 0) {
            this.outputEnergyValue = Math.round((this.outputEnergyBuffer / this.elapsedTicks));
          } else {
            this.outputEnergyValue = 0;
          } 
        if (this.elapsedTicks >= this.tickRate * this.tickRateFlush) {
            this.outputEnergyBuffer = 0;
            this.inputEnergyBuffer = 0;
            this.elapsedTicks = 0;
          } 
          this.lastTimeStamp = System.currentTimeMillis();
        for(int i= 0; i < 9; i++) {
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module1) {
        		
        	gend++;}
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module2) {
        		genn++;
        		}
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module3) {
        		maxstorage1++;}
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module4) {
        		output++;}
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
        			for(int j = 0; j < 9;j++) {
        			if (this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof ic2.api.item.IElectricItem && this.storage > 0.0D) {
        		        sentPacket = ElectricItem.manager.charge(this.chargeSlots[j], this.storage, 2147483647, false, false);
        		        if (sentPacket > 0.0D)
        		          needInvUpdate = true; 
        		        this.storage -= (int)sentPacket;
        		      }     
        			}
        		}else if(kk == 4) {
        			if (this.convertState == 0 && this.worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord + 1, this.zCoord) || this.noSunWorld ) {
        			      if (this.storage >= 0 && this.storage2 < this.maxStorage2 ) {
        			        int maxConvertEnergy = this.storage * 8;
        			        if (this.maxStorage2 < maxConvertEnergy + this.storage2) {
        			          int requestRFEnergy = this.maxStorage2 - this.storage2;
        			          int requestEUEnergy = requestRFEnergy / 4;
        			        
        			          this.storage2 += requestRFEnergy;
        			          this.storage -= requestEUEnergy;
        			        } else {
        			          this.storage2 += maxConvertEnergy;
        			         
        			        } 
        			      } 
        			
        			for (ForgeDirection side : ForgeDirection.VALID_DIRECTIONS) {
        		        TileEntity tile = this.worldObj.getTileEntity(this.xCoord + side.offsetX, this.yCoord + side.offsetY, this.zCoord + side.offsetZ);
        		        if (tile instanceof IEnergyHandler)
        		          extractEnergy(side.getOpposite(), ((IEnergyHandler)tile).receiveEnergy(side.getOpposite(), extractEnergy(side.getOpposite(), (this.production * 8), true), false), false); 
        		      } 
        			
        			}
        		}
        	}
        	
        	
        	
        }
     
      
        if(this.tier + tierplus -  minus > 0) {
        this.o = this.tier + tierplus -  minus;}
        else {
        	this.o = 0;
        }
        int a[];
    	a = new int[9];
    	int b[];
    	b = new int[9];
    	int c[];
    	c = new int[9];
    	int d[];
    	d = new int[9];
        
        if(this.chargeSlots[8] != null && this.chargeSlots[8].getItem() instanceof module5) {
        	int g = chargeSlots[8].getItemDamage();
        	if( g < 7 && g >=0) {
        		this.solarType =g+1;
        		
        	}
        }else {
        	this.solarType = 0;
        }
        for(int i =0;i<9;i++) {
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module6) {
        		int g = chargeSlots[i].getItemDamage();
        		if(o >= g+1) {
        		a[i] = module6.GenDay(g);
        		b[i] = module6.GenNight(g);
        		c[i] = module6.storage(g);
        		d[i] = module6.Output(g);
        		}
        	
        }
        }
        
        int sum = 0,sum1 = 0,sum2 = 0,sum3 = 0;
        for(int i =0;i<9;i++) {
        sum = sum+a[i];
        sum1=	sum1+b[i];	
        sum2=sum2+c[i];
        sum3=sum3+d[i];
        }
        	
if((int) ((this.k + sum) + (this.k +sum)*0.2*gend) < 2147000000) {
        	this.genDay  = (int) ((this.k + sum) + (sum)*0.2*gend);}else {
        		this.genDay = 2146999999;
        	}
if((int) ((this.m + sum1) + (this.m + sum1)*0.2*genn) < 2147000000) {
        	this.genNight  = (int) ((this.m + sum1) + (this.m + sum1)*0.2*genn);}else {
        		this.genNight = 2146999999;
        	}//
       
        
        if((int) ((this.p +sum2) + (this.p +  sum2)*0.2*maxstorage1) < 0) {
    		this.maxStorage = 2146999999;
    	}else if((int) ((this.p + sum2) + (this.p +  sum2)*0.2*maxstorage1) > 2147000000){
    		this.maxStorage = 2146999999;
    	}else {
    		this.maxStorage = (int) ((this.p + sum2) + (this.p +  sum2)*0.2*maxstorage1);
    	}
        //
        if((int) ((this.u +  sum3) + (this.u +  sum3)*0.2*output) < 2147000000)	{
        this.production  = (int) ((this.u +  sum3) + (this.u +  sum3)*0.2*output);}else {
        	this.production = 2146999999;
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
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        if (this.convertState == 0 && this.storage2 > 0) {
          int energyExtracted = Math.min(this.storage2, maxExtract);
          if (!simulate) {
            this.storage2 -= energyExtracted;
            this.outputEnergyBuffer += energyExtracted;
          } 
          return energyExtracted;
        } 
        if (this.convertState == 0);
        return 0;
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

      public void readFromNBT(NBTTagCompound nbttagcompound) {
    	    super.readFromNBT(nbttagcompound);
    	    this.storage = nbttagcompound.getInteger("storage");
    	    this.lastX = nbttagcompound.getInteger("lastX");
    	    this.lastY = nbttagcompound.getInteger("lastY");
    	    this.lastZ = nbttagcompound.getInteger("lastZ");
    	    NBTTagList nbttaglist = nbttagcompound.getTagList("Items", 10);
    	    if (nbttagcompound.hasKey("ownerGameProfile"))
    	        this.owner = NBTUtil.func_152459_a(nbttagcompound.getCompoundTag("ownerGameProfile")); 
    	    this.chargeSlots = new ItemStack[getSizeInventory()];
    	    for (int i = 0; i < nbttaglist.tagCount(); i++) {
    	      NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
    	      int j = nbttagcompound1.getByte("Slot") & 0xFF;
    	      if (j >= 0 && j < this.chargeSlots.length)
    	        this.chargeSlots[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1); 
    	    } 
    	    NBTTagList nbttaglist1 = (NBTTagList)nbttagcompound.getTag("positions");
    	    for (int i = 0; i < nbttaglist1.tagCount(); i++) {
    	      NBTTagCompound nbttagcompound1 = nbttaglist1.getCompoundTagAt(i);
    	      this.mapofcoords.put(Double.valueOf(nbttagcompound1.getDouble("A")), Double.valueOf(nbttagcompound1.getDouble("X")));
    	      this.mapofcoords.put(Double.valueOf(nbttagcompound1.getDouble("B")), Double.valueOf(nbttagcompound1.getDouble("Y")));
    	      this.mapofcoords.put(Double.valueOf(nbttagcompound1.getDouble("C")), Double.valueOf(nbttagcompound1.getDouble("Z")));
    	      this.lista.add(Double.valueOf(nbttagcompound1.getDouble("A")));
    	      this.listb.add(Double.valueOf(nbttagcompound1.getDouble("B")));
    	      this.listc.add(Double.valueOf(nbttagcompound1.getDouble("C")));
    	    } 
    	    this.targetSet = Boolean.valueOf(nbttagcompound.getBoolean("targetset"));
    	    this.isconnected = nbttagcompound.getBoolean("isconnected");
    	  }
      public boolean permitsAccess(GameProfile profile) {
    	    if (profile == null)
    	      return (this.owner == null); 
    	    if (IC2.platform.isSimulating()) {
    	      if (this.owner == null) {
    	        this.owner = profile;
    	        ((NetworkManager)IC2.network.get()).updateTileEntityField((TileEntity)this, "owner");
    	        return true;
    	      } 
    	      if (MinecraftServer.getServer().getConfigurationManager().func_152596_g(profile))
    	        return true; 
    	    } else if (this.owner == null) {
    	      return true;
    	    } 
    	    return this.owner.equals(profile);
    	  }
    	  
    	  public GameProfile getOwner() {
    	    return this.owner;
    	  }
    	  public void writeToNBT(NBTTagCompound nbttagcompound) {
    	    super.writeToNBT(nbttagcompound);
    
    	    if (this.owner != null) {
    	        NBTTagCompound ownerNbt = new NBTTagCompound();
    	        NBTUtil.func_152460_a(ownerNbt, this.owner);
    	        nbttagcompound.setTag("ownerGameProfile", (NBTBase)ownerNbt);
    	      } 
    	    NBTTagList nbttaglist = new NBTTagList();
    	    nbttagcompound.setInteger("storage", this.storage);
    	    nbttagcompound.setInteger("lastX", this.lastX);
    	    nbttagcompound.setInteger("lastY", this.lastY);
    	    nbttagcompound.setInteger("lastZ", this.lastZ);
    	    for (int i = 0; i < this.chargeSlots.length; i++) {
    	      if (this.chargeSlots[i] != null) {
    	        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
    	        nbttagcompound1.setByte("Slot", (byte)i);
    	        this.chargeSlots[i].writeToNBT(nbttagcompound1);
    	        nbttaglist.appendTag((NBTBase)nbttagcompound1);
    	      } 
    	    } 
    	    nbttagcompound.setTag("Items", (NBTBase)nbttaglist);
    	    NBTTagList list1 = new NBTTagList();
    	    for (int l = 0, m = 0, n = 0; l < this.lista.size() && m < this.listb.size() && n < this.listc.size(); l++, m++, n++) {
    	      NBTTagCompound com = new NBTTagCompound();
    	      if (this.worldObj.getTileEntity((int)((Double)this.mapofcoords.get(this.lista.get(l))).doubleValue(), (int)((Double)this.mapofcoords.get(this.listb.get(m))).doubleValue(), (int)((Double)this.mapofcoords.get(this.listc.get(n))).doubleValue()) != null) {
    	        com.setDouble("A", ((Double)this.lista.get(l)).doubleValue());
    	        com.setDouble("B", ((Double)this.listb.get(m)).doubleValue());
    	        com.setDouble("C", ((Double)this.listc.get(n)).doubleValue());
    	        com.setDouble("X", ((Double)this.mapofcoords.get(this.lista.get(l))).doubleValue());
    	        com.setDouble("Y", ((Double)this.mapofcoords.get(this.listb.get(m))).doubleValue());
    	        com.setDouble("Z", ((Double)this.mapofcoords.get(this.listc.get(n))).doubleValue());
    	        list1.appendTag((NBTBase)com);
    	      } 
    	    } 
    	    nbttagcompound.setTag("positions", (NBTBase)list1);
    	    nbttagcompound.setDouble("energy", this.storage);
    	    nbttagcompound.setBoolean("targetset", this.targetSet.booleanValue());
    	    nbttagcompound.setBoolean("isconnected", this.isconnected);
    	  }
    
    public boolean isAddedToEnergyNet() {
        return this.addedToEnergyNet;
    }
    
    public int getMaxEnergyOutput() {
        return this.production;
    }
    
    public float gaugeEnergyScaled(final float i) {
    	  int tierplus = 0;
          int minus = 0;
          int gg = 0;
          for(int j = 0; j < 9;j++) {
          	if(this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof module7) {
          		int kk = chargeSlots[j].getItemDamage();
          		
          		 if(kk == 1) {
          			tierplus++;
          		}
          		else if(kk == 2) {
          			minus++;
          		}
          		
          	}
          }
          this.o = this.tier + tierplus -  minus;
    	int maxstorage1 = 0;
    	
    	 for(int j= 0; j < 9; j++) {
         
         	if(this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof module3)
         		maxstorage1++;
         	
         }
    	
      	int c[];
      	c = new int[9];
      	for(int j =0;j<9;j++) {
        	if(this.chargeSlots[j] != null && this.chargeSlots[j].getItem() instanceof module6) {
        		int g = chargeSlots[j].getItemDamage();
        		if(o >= g+1) {
        		c[j] = module6.storage(g);
        		}
        	
        }
        	
        }
        
        int sum = 0,sum1 = 0,sum2 = 0,sum3 = 0;
        for(int j =0;j<9;j++) {

        sum2=sum2+c[j];
        }
    	

         return  (float) (this.storage * i /(  ((this.p + sum2) + (this.p +  sum2)*0.2*maxstorage1)));

}
        
    public boolean canConnectEnergy(ForgeDirection arg0) {
        return true;
      }
      
      public int getEnergyStored(ForgeDirection from) {
        return this.storage2;
      }
      
      public int getMaxEnergyStored(ForgeDirection from) {
        return this.maxStorage2;
      }
      public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
    	    if (this.convertState == 0)
    	      return true; 
    	    return false;
    	  }
    public int gaugeFuelScaled(final int i) {
        return i;
    }
    
    @Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistance((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

    public short getFacing() {
        return this.facing;
      }
      
      public void setFacing(short facing) {
        this.facing = facing;
      }
  
      
    public void openInventory() {
    	for(int i= 0; i < 9; i++) {
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module7) {
        		
        	if(this.chargeSlots[i].getItemDamage() == 5) {
        		 this.numUsingPlayers++;
    	    syncNumUsingPlayers();}
        }
        }
    }
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        ItemStack ret = super.getWrenchDrop(entityPlayer);
        float energyRetainedInStorageBlockDrops = ConfigUtil.getFloat(MainConfig.get(), "balance/energyRetainedInStorageBlockDrops");
      
        return ret;
      }
    public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
        return (getFacing() != side);
      }
        
    public void closeInventory() {
    	for(int i= 0; i < 9; i++) {
        	if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() instanceof module7) {
        		
        	if(this.chargeSlots[i].getItemDamage() == 5) {
        		 this.numUsingPlayers--;
    	    syncNumUsingPlayers();}
        }
        }
    	 
    }
    
    public int tickRate() {
        return 40;
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
    	List<String> ret = new Vector<String>(1);
    	  ret.add("owner");
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

	@Override
	 public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
	    if (this.convertState == 1) {
	      if (this.storage2 >= this.maxStorage2)
	        return 0; 
	      if (this.storage2 + maxReceive > this.maxStorage2) {
	        int energyReceived = this.maxStorage2 - this.storage2;
	        if (!simulate) {
	          this.storage2 = this.maxStorage2;
	          this.inputEnergyBuffer += energyReceived;
	        } 
	        return energyReceived;
	      } 
	      if (!simulate) {
	        this.inputEnergyBuffer += maxReceive;
	        this.storage2 += maxReceive;
	      } 
	      return maxReceive;
	    } 
	    return 0;
	  }

	
}
