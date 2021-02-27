package com.Denfop.events.MF_EP;

import java.util.Map;

import com.Denfop.SuperSolarPanels;
import com.aesireanempire.eplus.inventory.ContainerEnchantTable;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ic2.core.Ic2Items;
import ic2.core.util.StackUtil;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingEvent;
import powercrystals.minefactoryreloaded.gui.container.ContainerAutoDisenchanter;
import powercrystals.minefactoryreloaded.gui.container.ContainerAutoEnchanter;

public class SSPMPMFEventHandler {


	@SubscribeEvent
	public void onPlayerInteract( LivingEvent.LivingUpdateEvent event) {
		 if (event.entityLiving == null || !(event.entityLiving instanceof EntityPlayer)) return;
		  
		  EntityPlayer player = (EntityPlayer) event.entity;
		  //TODO start for 
		  for(int i = 0 ; i < player.inventory.mainInventory.length ; i++) {
			  //  TODO start Check inventory
			  if(player.inventory.mainInventory[i] != null && (player.inventory.mainInventory[i].getItem() == SuperSolarPanels.ultDDrill  || player.inventory.mainInventory[i].getItem() == Ic2Items.iridiumDrill.getItem()) ) {
				   ItemStack input = player.inventory.mainInventory[i];
				   Map<Integer, Integer> map = null;
				   ItemStack input1 = new ItemStack(SuperSolarPanels.ultDDrill);
				   NBTTagCompound nbtData = SuperSolarPanels.getOrCreateNbtData(input); 
				  if((input.getItem() == SuperSolarPanels.ultDDrill   ||input.getItem() == Ic2Items.iridiumDrill.getItem())) {
					 
					  if(EnchantmentHelper.getEnchantments(input) != null) { 
			  map = EnchantmentHelper.getEnchantments(input);
			  int id = 0;
			  int lvl = 0;
			  for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		             id = entry.getKey();
		             lvl = entry.getValue();
		        }
			  if(id != 0)
			   nbtData.setInteger("ID", id);
			  if(lvl != 0) 
				  nbtData.setInteger("Level", lvl);
	//		   map.put(arg0, arg1)
			  
			  }
				  
				  }
				  Map<Integer, Integer>  map1 = null;
				  if(map != null) {
					  map1 =map;
				  }
			  if(player.openContainer != null && player.openContainer instanceof ContainerAutoDisenchanter) {
				  if(map1 != null) {
				  map1.clear();
				  EnchantmentHelper.setEnchantments(map1, input);
				  
				  }
				if( player.openContainer.getSlot(2).getStack() != null) {
					ItemStack input2 =  player.openContainer.getSlot(2).getStack();
					  nbtData = SuperSolarPanels.getOrCreateNbtData(input2); 
					  if((input2.getItem() == SuperSolarPanels.ultDDrill ||input2.getItem() == Ic2Items.iridiumDrill.getItem())) {
						  System.out.print("1");
						  if(EnchantmentHelper.getEnchantments(input2) != null) { 
				  map = EnchantmentHelper.getEnchantments(input2);
				  int id = 0;
				  int lvl = 0;
				  System.out.print("2");
				  for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			             id = entry.getKey();
			             lvl = entry.getValue();
			        }
				  if(id != 0)
				   nbtData.setInteger("ID", id);
				  if(lvl != 0) 
					  nbtData.setInteger("Level", lvl);
		//		   map.put(arg0, arg1)
				  if(map != null) {
					  map1 =map;
				  }
				  map1.clear();
				  EnchantmentHelper.setEnchantments(map1, input2);
				  }
					  
					  }
					
				}
			  }
			  else  if(player.openContainer != null && player.openContainer instanceof ContainerAutoEnchanter) {
				  map1.clear();
				  EnchantmentHelper.setEnchantments(map1, input);
			  }else  if(player.openContainer != null && player.openContainer instanceof ContainerEnchantTable) {
				  map1.clear();
				  EnchantmentHelper.setEnchantments(map1, input);
			  }
			  else {
				  if(nbtData.getInteger("ID") != 0 && nbtData.getInteger("Level") !=0) {
					  map.put(nbtData.getInteger("ID"), nbtData.getInteger("Level"));
					  EnchantmentHelper.setEnchantments(map, input);}
			  }
	}
				  
				  //  TODO end Check inventory  
			   }
			  //TODO end for
		  } 
		  
	
}
