package com.Denfop.tiles.Mechanism;

import java.util.Random;
import java.util.Set;

import com.Denfop.container.ContainerGenStone;
import com.Denfop.container.ContainerQuantumQuarry;
import com.Denfop.container.ContainerStandardMachine;
import com.Denfop.gui.GuiAlloySmelter;
import com.Denfop.gui.GuiQuantumQuarry;
import com.Denfop.tiles.base.TileEntityBaseGenStone;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.network.INetworkTileEntityEventListener;
import ic2.core.ContainerBase;
import ic2.core.IC2;
import ic2.core.IHasGui;
import ic2.core.audio.AudioSource;
import ic2.core.block.invslot.InvSlotOutput;
import ic2.core.block.invslot.InvSlotUpgrade;
import ic2.core.block.machine.tileentity.TileEntityElectricMachine;
import ic2.core.upgrade.IUpgradableBlock;
import ic2.core.upgrade.UpgradableProperty;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.oredict.OreDictionary;

public class TileEntityQuantumQuarry extends TileEntityElectricMachine implements IHasGui, INetworkTileEntityEventListener{
	
	private int progress;

	 public AudioSource audioSource;
	 public  ItemStack[] chargeSlots;
	 Random rand = new Random();

	 public int energyconsume;

	 public int getblock;
	
		  
		  public TileEntityQuantumQuarry() {
		    super(10000000, 11, 1);
		    this.progress = 0;
		  this.getblock =0;
		   this.energyconsume=25000;
		  
		    this.chargeSlots = new ItemStack[24];
		  }
		  protected void updateEntityServer() {
			    super.updateEntityServer();
		    	
		        if(this.energy >= this.energyconsume) {
		        	
		        	this.energy-=(this.energyconsume);
		        	
		        	int chance = rand.nextInt(100)+1;
		        	if(chance <= 90) {
		        		this.getblock++;
		        	}else if(chance >=  91 && chance <=100) {
		        		this.getblock++;
		        		 int chance1 = rand.nextInt(100)+1; 
		        		 int chance2 = rand.nextInt(100)+1; 
		        		boolean get = false;
		        		if(chance2 <= 20 ) {
		        		if(chance1 <=25) {
		        		for(int i =0;i <getSizeInventory();i++) {
		        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == Items.coal&& this.chargeSlots[i].stackSize < 64) {
		        				this.chargeSlots[i].stackSize++;
		        				get = true;
		        				break;
		        			}
		        		}
		        		if(!get) {
		        			for(int i =0;i <getSizeInventory();i++) {
			        			if(this.chargeSlots[i] == null) {
			        				this.chargeSlots[i]=new ItemStack(Items.coal);
			        				break;
			        			}
			        		}
		        		}
		        	}else if(chance1 > 25 && chance1 <=50) {
		        		for(int i =0;i <getSizeInventory();i++) {
		        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == Item.getItemFromBlock(Blocks.iron_ore)&& this.chargeSlots[i].stackSize < 64) {
		        				this.chargeSlots[i].stackSize++;
		        				get = true;
		        				break;
		        			}
		        		}
		        		if(!get) {
		        			for(int i =0;i <getSizeInventory();i++) {
			        			if(this.chargeSlots[i] == null) {
			        				this.chargeSlots[i]=new ItemStack(Blocks.iron_ore);
			        				break;
			        			}
			        		}
		        		}
		        	}else if(chance1 > 50 && chance1 <=75) {
		        		for(int i =0;i <getSizeInventory();i++) { 
		        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreCopper").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
		        				this.chargeSlots[i].stackSize++;
		        				get = true;
		        				break;
		        			}
		        		}
		        		if(!get) {
		        			for(int i =0;i <getSizeInventory();i++) {
			        			if(this.chargeSlots[i] == null) {
			        				this.chargeSlots[i]= OreDictionary.getOres("oreCopper").get(0);
			        				break;
			        			}
			        		}
		        		}
		        	}else if(chance1 > 75 && chance1 <=100) {
		        		for(int i =0;i <getSizeInventory();i++) { 
		        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreTin").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
		        				this.chargeSlots[i].stackSize++;
		        				get = true;
		        				break;
		        			}
		        		}
		        		if(!get) {
		        			for(int i =0;i <getSizeInventory();i++) {
			        			if(this.chargeSlots[i] == null) {
			        				this.chargeSlots[i]= OreDictionary.getOres("oreTin").get(0);
			        				break;
			        			}
			        		}
		        		}
		        	}
		        	
		        		}else if(chance2 > 21 &&  chance2 <=40) {
			        		if(chance1 <=25) {
				        		for(int i =0;i <getSizeInventory();i++) {
				        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreChromium").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
				        				this.chargeSlots[i].stackSize++;
				        				get = true;
				        				break;
				        			}
				        		}
				        		if(!get) {
				        			for(int i =0;i <getSizeInventory();i++) {
					        			if(this.chargeSlots[i] == null) {
					        				this.chargeSlots[i]=OreDictionary.getOres("oreChromium").get(0);
					        				break;
					        			}
					        		}
				        		}
				        	}else if(chance1 > 25 && chance1 <=50) {
				        		for(int i =0;i <getSizeInventory();i++) {
				        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreTungsten").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
				        				this.chargeSlots[i].stackSize++;
				        				get = true;
				        				break;
				        			}
				        		}
				        		if(!get) {
				        			for(int i =0;i <getSizeInventory();i++) {
					        			if(this.chargeSlots[i] == null) {
					        				this.chargeSlots[i]=OreDictionary.getOres("oreTungsten").get(0);
					        				break;
					        			}
					        		}
				        		}
				        	}else if(chance1 > 50 && chance1 <=75) {
				        		for(int i =0;i <getSizeInventory();i++) { 
				        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreSpinel").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
				        				this.chargeSlots[i].stackSize++;
				        				get = true;
				        				break;
				        			}
				        		}
				        		if(!get) {
				        			for(int i =0;i <getSizeInventory();i++) {
					        			if(this.chargeSlots[i] == null) {
					        				this.chargeSlots[i]= OreDictionary.getOres("oreSpinel").get(0);
					        				break;
					        			}
					        		}
				        		}
				        	}else if(chance1 > 75 && chance1 <=100) {
				        		for(int i =0;i <getSizeInventory();i++) { 
				        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreMikhalov").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
				        				this.chargeSlots[i].stackSize++;
				        				get = true;
				        				break;
				        			}
				        		}
				        		if(!get) {
				        			for(int i =0;i <getSizeInventory();i++) {
					        			if(this.chargeSlots[i] == null) {
					        				this.chargeSlots[i]= OreDictionary.getOres("oreMikhalov").get(0);
					        				break;
					        			}
					        		}
				        		}
				        	}
				        	
				        		}else if(chance2 > 41 &&  chance2 <=60) {
					        		if(chance1 <=25) {
						        		for(int i =0;i <getSizeInventory();i++) {
						        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == Items.redstone&& this.chargeSlots[i].stackSize < 64) {
						        				int meta =0;
						        				int chance3 = rand.nextInt(100)+1;
						        				if(chance <=25)
						        					meta =1;
						        				if(chance3 >25&& chance3 <= 50)
						        					meta =2;
						        				if(chance3 >50&& chance3 <= 75)
						        					meta =3;
						        				if(chance3 >75&& chance3 <= 100)
						        					meta =4;
						        				if( this.chargeSlots[i].stackSize+meta <=64)
						        				this.chargeSlots[i].stackSize = this.chargeSlots[i].stackSize+meta;
						        				else 
						        					this.chargeSlots[i].stackSize = 64;
						        				get = true;
						        				break;
						        			}
						        		}
						        		if(!get) {
						        			for(int i =0;i <getSizeInventory();i++) {
							        			if(this.chargeSlots[i] == null) {
							        				int meta =0;
							        				int chance3 = rand.nextInt(100)+1;
							        				if(chance <=25)
							        					meta =1;
							        				if(chance3 >25&& chance3 <= 50)
							        					meta =2;
							        				if(chance3 >50&& chance3 <= 75)
							        					meta =3;
							        				if(chance3 >75&& chance3 <= 100)
							        					meta =4;
							        				this.chargeSlots[i]=new ItemStack(Items.redstone,meta);
							        				break;
							        			}
							        		}
						        		}
						        	}else if(chance1 > 25 && chance1 <=50) {
						        		for(int i =0;i <getSizeInventory();i++) {
						        			
						        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("gemLapis").get(0).getItem() && this.chargeSlots[i].stackSize < 64) {
						        				int meta =0;
						        				int chance3 = rand.nextInt(100)+1;
						        				if(chance <=25)
						        					meta =1;
						        				if(chance3 >25&& chance3 <= 50)
						        					meta =2;
						        				if(chance3 >50&& chance3 <= 75)
						        					meta =3;
						        				if(chance3 >75&& chance3 <= 100)
						        					meta =4;
						        				if( this.chargeSlots[i].stackSize+meta <=64)
						        				this.chargeSlots[i].stackSize = this.chargeSlots[i].stackSize+meta;
						        				else 
						        					this.chargeSlots[i].stackSize = 64;
						        				get = true;
						        				break;
						        			}
						        		}
						        		if(!get) {
						        			for(int i =0;i <getSizeInventory();i++) {
							        			if(this.chargeSlots[i] == null) {
							        				int meta =0;
							        				int chance3 = rand.nextInt(100)+1;
							        				if(chance <=25)
							        					meta =1;
							        				if(chance3 >25&& chance3 <= 50)
							        					meta =2;
							        				if(chance3 >50&& chance3 <= 75)
							        					meta =3;
							        				if(chance3 >75&& chance3 <= 100)
							        					meta =4;
							        				this.chargeSlots[i]=new ItemStack(Items.dye,meta,4);
							        				break;
							        			}
							        		}
						        		}
						        	}else if(chance1 > 50 && chance1 <=75) {
						        		for(int i =0;i <getSizeInventory();i++) { 
						        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreQuartz").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
						        				this.chargeSlots[i].stackSize++;
						        				get = true;
						        				break;
						        			}
						        		}
						        		if(!get) {
						        			for(int i =0;i <getSizeInventory();i++) {
							        			if(this.chargeSlots[i] == null) {
							        				this.chargeSlots[i]= OreDictionary.getOres("oreQuartz").get(0);
							        				break;
							        			}
							        		}
						        		}
						        	}else if(chance1 > 75 && chance1 <=100) {
						        		for(int i =0;i <getSizeInventory();i++) { 
						        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreGold").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
						        				this.chargeSlots[i].stackSize++;
						        				get = true;
						        				break;
						        			}
						        		}
						        		if(!get) {
						        			for(int i =0;i <getSizeInventory();i++) {
							        			if(this.chargeSlots[i] == null) {
							        				this.chargeSlots[i]= OreDictionary.getOres("oreGold").get(0);
							        				break;
							        			}
							        		}
						        		}
						        	}
						        	
						        		}
		        		//
				        		else if(chance2 > 61 &&  chance2 <=80) {
							        		if(chance1 <=25) {
								        		for(int i =0;i <getSizeInventory();i++) {
								        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreNickel").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
								        				this.chargeSlots[i].stackSize++;
								        				get = true;
								        				break;
								        			}
								        		}
								        		if(!get) {
								        			for(int i =0;i <getSizeInventory();i++) {
									        			if(this.chargeSlots[i] == null) {
									        				this.chargeSlots[i]=OreDictionary.getOres("oreNickel").get(0);
									        				break;
									        			}
									        		}
								        		}
								        	}else if(chance1 > 25 && chance1 <=50) {
								        		if(OreDictionary.getOres("oreAluminium").size() >=1) {
								        		for(int i =0;i <getSizeInventory();i++) {
								        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreAluminium").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
								        				this.chargeSlots[i].stackSize++;
								        				get = true;
								        				break;
								        			}
								        		}
								        		if(!get) {
								        			for(int i =0;i <getSizeInventory();i++) {
									        			if(this.chargeSlots[i] == null) {
									        				this.chargeSlots[i]=OreDictionary.getOres("oreAluminium").get(0);
									        				break;
									        			}
									        		}
								        		}}
								        	}else if(chance1 > 50 && chance1 <=75) {
								        		for(int i =0;i <getSizeInventory();i++) { 
								        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("oreIridium").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
								        				this.chargeSlots[i].stackSize++;
								        				get = true;
								        				break;
								        			}
								        		}
								        		if(!get) {
								        			for(int i =0;i <getSizeInventory();i++) {
									        			if(this.chargeSlots[i] == null) {
									        				this.chargeSlots[i]= OreDictionary.getOres("oreIridium").get(0);
									        				break;
									        			}
									        		}
								        		}
								        	}else if(chance1 > 75 && chance1 <=100) {
								        		for(int i =0;i <getSizeInventory();i++) { 
								        			if(this.chargeSlots[i] != null && this.chargeSlots[i].getItem() == OreDictionary.getOres("orePlatinum").get(0).getItem()&& this.chargeSlots[i].stackSize < 64) {
								        				this.chargeSlots[i].stackSize++;
								        				get = true;
								        				break;
								        			}
								        		}
								        		if(!get) {
								        			for(int i =0;i <getSizeInventory();i++) {
									        			if(this.chargeSlots[i] == null) {
									        				this.chargeSlots[i]= OreDictionary.getOres("orePlatinum").get(0);
									        				break;
									        			}
									        		}
								        		}
								        	}
								        	
								        		}
		        		//
		        	
		        	}
		        }
		        	
		        
		  }
		  
		  public void readFromNBT(NBTTagCompound nbttagcompound) {
			    super.readFromNBT(nbttagcompound);
			    this.progress = nbttagcompound.getInteger("progress");
			    NBTTagList nbttaglist = nbttagcompound.getTagList("Items", 10);
		    	this.getblock = nbttagcompound.getInteger("getblock");
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
			    nbttagcompound.setInteger("getblock", this.getblock);
			    nbttagcompound.setInteger("progress", this.progress);
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
			  public ItemStack[] getContents() {
			        return this.chargeSlots;
			    }
			   
			    public int getSizeInventory() {
			        return 24;
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
	 @SideOnly(Side.CLIENT)
	  public GuiScreen getGui(EntityPlayer entityPlayer, boolean isAdmin) {
	    return new GuiQuantumQuarry(new ContainerQuantumQuarry(entityPlayer, this));
	  }
	 public ContainerBase<? extends TileEntityQuantumQuarry> getGuiContainer(EntityPlayer entityPlayer) {
		    return (ContainerBase<? extends TileEntityQuantumQuarry>)new ContainerQuantumQuarry(entityPlayer, this);
		  }
	 public void onLoaded() {
		    super.onLoaded();
		   
		  }
		  
		  public void onUnloaded() {
		    super.onUnloaded();
		    if (IC2.platform.isRendering() && this.audioSource != null) {
		      IC2.audioManager.removeSources(this);
		      this.audioSource = null;
		    } 
		  }
	  public String getStartSoundFile() {
	    return "Machines/MaceratorOp.ogg";
	  }
	  
	  public String getInterruptSoundFile() {
	    return "Machines/InterruptOne.ogg";
	  }
	  
	  public float getWrenchDropRate() {
	    return 0.85F;
	  }



	@Override
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

	

	@Override
	public void onGuiClosed(EntityPlayer arg0) {}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
