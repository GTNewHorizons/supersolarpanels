package com.Denfop.block.BlockVajra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.lwjgl.input.Keyboard;

import com.Denfop.Config;
import com.Denfop.SuperSolarPanels;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import scala.swing.event.Key;

public class WirelessVajra extends ItemTool implements IElectricItem {
	
	public TileVajraCharger tile1;
	public double maxCharge;
	protected int tier;
	protected float effPower;
	protected int energyPerOperation;
	protected int toolmode;
	protected int transferLimit;
	
	

	public WirelessVajra(ToolMaterial mater) {
		super(0, mater, new HashSet());
		this.setUnlocalizedName("wirelessvajra");
		this.setTextureName("wirelessvajra:itemVajraWireless");
		 setCreativeTab(SuperSolarPanels.tabssp);
		this.tier = 3;
		this.maxCharge = 6000000;
		this.transferLimit = 70000;
		this.toolmode = 0;
		this.effPower = 20000F;
		this.efficiencyOnProperMaterial = this.effPower;
		this.energyPerOperation = 3000; setCreativeTab(SuperSolarPanels.tabssp);
		this.setNoRepair();
		this.getItemEnchantability(null);
		
		
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		
		return false;
	}

	@Override
	public Item getChargedItem(ItemStack itemStack) {
		
		return this;
	}

	@Override
	public Item getEmptyItem(ItemStack itemStack) {
		
		return this;
	}

	@Override
	public double getMaxCharge(ItemStack itemStack) {
		
		
		return this.maxCharge;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		
		return this.tier;
	}

	@Override
	public double getTransferLimit(ItemStack itemStack) {
		
		return this.transferLimit;
	}
	
	
/*	public void doCharge(ItemStack istack, World world, int i, int j, int k) {
		
		istack = new ItemStack(this);
		tile1 = (TileVajraCharger) world.getTileEntity(i, j, k);
		if(!world.isRemote) {
		
		if(tile1.getStored() > 0) {
			int delta = (int) (this.maxCharge - ElectricItem.manager.getCharge(istack));
		
		
		
		
		
		if(tile1.getStored() > 0) {
			ElectricItem.manager.charge(istack, delta, 2147483647, true, false);
			tile1.addEnergy(-delta);
		
		}
		
		
		if(tile1.getStored() < 0) {
			tile1.energy = 0;
		}
		
		}
			
	}
		
	}
	
	
	*/
	
	public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int side, float a, float b, float c) {
		
			if(!world.isRemote) {
				
				if(world.getTileEntity(i, j, k) instanceof TileVajraCharger) {
					
					tile1 = (TileVajraCharger) world.getTileEntity(i, j, k);
					
					if(tile1.getStored() > 0) {
						
					if(ElectricItem.manager.getCharge(itemstack) != this.maxCharge) {
					if(ElectricItem.manager.getCharge(itemstack) == 0) {
						
						
						int delta = (int)(tile1.getStored() - ElectricItem.manager.getCharge(itemstack));
						ElectricItem.manager.charge(itemstack, delta, 2147483647, true, false);
						if(delta>this.maxCharge) {
						delta = (int) this.maxCharge;						
						tile1.addEnergy(-delta);
						//entityplayer.addChatMessage(new ChatComponentTranslation("delta_sub1", new Object[0]));
						}
						else {
							tile1.addEnergy(-delta);
							//entityplayer.addChatMessage(new ChatComponentTranslation("delta_sub2", new Object[0]));
						}
						
					}
					else if(ElectricItem.manager.getCharge(itemstack) > 0) {
						if(ElectricItem.manager.getCharge(itemstack) > tile1.getStored()) {
							
							int en1 = (int) ElectricItem.manager.getCharge(itemstack);
							int delta1 = tile1.getStored();
							ElectricItem.manager.charge(itemstack, delta1, 2147483647, true, false);
							int en2 = (int) ElectricItem.manager.getCharge(itemstack);
							int deltaen = en2-en1;
							
							tile1.addEnergy(-deltaen);
							//entityplayer.addChatMessage(new ChatComponentTranslation("deltaen", new Object[0]));
						}
						
						
						else if(tile1.getStored() >= ElectricItem.manager.getCharge(itemstack)) {
								
								
								int en1 = (int) ElectricItem.manager.getCharge(itemstack);
								int delta2 = (int) tile1.getStored();
								ElectricItem.manager.charge(itemstack, delta2, 2147483647, true, false);
								int en2 = (int) ElectricItem.manager.getCharge(itemstack);
								int deltaen1 = en2-en1;
								
								if(deltaen1 <= tile1.getStored()) {
									int deltaene = deltaen1;
									tile1.addEnergy(-deltaene);
									//entityplayer.addChatMessage(new ChatComponentTranslation("deltaen1", new Object[0]));
								}
								else if(deltaen1 > tile1.getStored()) {
									int deltaene = tile1.getStored();
									
									tile1.addEnergy(-deltaene);
									//entityplayer.addChatMessage(new ChatComponentTranslation("deltaen2", new Object[0]));
								}
								
							}
					}
						
						
					}
					
					
					if(tile1.getStored() < 0) {
						tile1.energy = 0;
					}
					
					}
					
				}
			
			
			return true;
			}
				return false;
	}
	 
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if(!world.isRemote) {
		if(player.isSneaking()) {
			
			Map<Integer, Integer> enchantmentMap = new HashMap<Integer, Integer>();
			toolmode +=1;
			
			if(toolmode == 1) {
				enchantmentMap.put(Integer.valueOf(Enchantment.fortune.effectId), Integer.valueOf(5));
				EnchantmentHelper.setEnchantments(enchantmentMap, itemStack);
			toolmode +=1;
			
			}
			else if(toolmode == 2) {
				enchantmentMap.clear();
				EnchantmentHelper.setEnchantments(enchantmentMap, itemStack);
			toolmode +=1;
			
			}
			else if(toolmode == 3) {
				toolmode = 0;
				EnchantmentHelper.setEnchantments(enchantmentMap, itemStack);
				
				
			}
			  
		}
		
		
		
		}
		return itemStack;
	}
	

	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase attacker) {
		  if (ElectricItem.manager.use(itemstack, (this.energyPerOperation * 2), attacker)) {
		   
		    entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)attacker), 25.0F);
		    }
		     else {
		      
		     entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)attacker), 1.0F);
		    } 
		     
		     return false;
	}
	public boolean canHarvestBlock(Block block, ItemStack stack) {
		     if (block != Blocks.bedrock) {
		       return true;
		 }
		
		     
		    return false;
		  }
	
	public float getDigSpeed(ItemStack tool, Block block, int meta) {
		   if (!ElectricItem.manager.canUse(tool, this.energyPerOperation)) {
		     return 1.0F;
		  }
		    
		    if (canHarvestBlock(block, tool)) {
		     return this.efficiencyOnProperMaterial;
		     }
		     return 1.0F;
	}
		
	
	
	public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int xPos, int yPos, int zPos, EntityLivingBase entityliving) {
		     if (block.getBlockHardness(world, xPos, yPos, zPos) != 0.0D) {
		       if (entityliving != null) {
		        ElectricItem.manager.use(itemstack, this.energyPerOperation, entityliving);
		       } else {
		         ElectricItem.manager.discharge(itemstack, this.energyPerOperation, this.tier, true, false, false);
		       } 
		     }
		     
		     return true;
	}
	public boolean isRepairable() { return false; }
	public int getItemEnchantability() { return 0; }
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
		info.add(StatCollector.translateToLocal(I18n.format("item.vajra.energy", new Object[0]) + ": ") + ElectricItem.manager.getCharge(itemStack) + " Eu");
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			info.add(I18n.format("about.ench1"));
			info.add(I18n.format("about.ench2"));
		}
		else {
			info.add(I18n.format("press.lshift"));
		}
	}
	
	
	protected ItemStack getItemStack(double charge) {
		 ItemStack st = new ItemStack(this);
		 ElectricItem.manager.charge(st, charge, 2147483647, true, false);
		   
		   return st;
	 }
	public void getSubItems(Item item, CreativeTabs tabs, List itemList) {
		itemList.add(getItemStack(Double.POSITIVE_INFINITY));
		itemList.add(getItemStack(0.0D));
		 }
	
}
