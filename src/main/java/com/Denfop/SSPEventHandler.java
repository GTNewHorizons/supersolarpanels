package com.Denfop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.Denfop.block.Base.BlockSSP;
import com.Denfop.block.cable.BlockCable;
import com.Denfop.block.cable.SSPDamageSource;
import com.Denfop.item.armour.ItemArmorQuantumSuit1;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import ic2.core.item.armor.ItemArmorHazmat;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEventData;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import net.minecraftforge.event.world.BlockEvent;

public class SSPEventHandler {
	@SubscribeEvent
	public  void UpdateEntity( LivingEvent.LivingUpdateEvent event) {
		
	    if (event.entityLiving == null || !(event.entityLiving instanceof EntityPlayer)) return;
	    EntityPlayer player = (EntityPlayer) event.entity;
	    
	    if(event.entityLiving instanceof EntityPlayer) { 
		 if(player.capabilities.isCreativeMode ==false) {
			 if(player.inventory.armorInventory[2] != null) {
				 NBTTagCompound nbtData = null;
				 if(player.inventory.armorInventory[2].getItem() ==  SuperSolarPanels.quantumBodyarmor)
				  nbtData = SuperSolarPanels.getOrCreateNbtData(player.inventory.armorInventory[2]);
		if(player.inventory.armorInventory[2].getItem() != SuperSolarPanels.quantumBodyarmor && player.capabilities.isFlying == true ) {
			player.capabilities.isFlying = false;
			player.capabilities.allowFlying = false;
			player.fallDistance = 1.0F;
		    player.distanceWalkedModified = 1.0F;
		}else if(nbtData != null) {
			boolean jetpack = nbtData.getBoolean("jetpack");
			if(jetpack == false) {
				player.capabilities.isFlying = false;
				player.capabilities.allowFlying = false;
				player.fallDistance = 1.0F;
			    player.distanceWalkedModified = 1.0F;
			}else {
				player.capabilities.isFlying = true;
				player.capabilities.allowFlying = true;
			}
		}
		// jetpack = nbtData.getBoolean("jetpack");
		else {
			
		}
			 }else {
				
					player.capabilities.isFlying = false;
					player.capabilities.allowFlying = false;
				}}else {
					return;
				}
	}
	}
	
	@SubscribeEvent
	public void DamageCable(LivingEvent.LivingUpdateEvent event) {
		
		   if (event.entityLiving == null || !(event.entityLiving instanceof EntityPlayer)) 
			  return;
		   for(int i = -1;i < 1; i++) {
			   for(int j = -1;j < 1; j++){
		   EntityPlayer player = (EntityPlayer) event.entity;
		   int x = (int) player.posX;
		   int y = (int) player.posY;
		   int z = (int) player.posZ;
		   Block block =  player.worldObj.getBlock(x+i, y, z+j);
		   
		 if(block instanceof BlockCable) {
			//if(player.inventory.armorInventory[2].getItem() != SuperSolarPanels.quantumBodyarmor && player.inventory.armorInventory[3].getItem() != SuperSolarPanels.quantumHelmet && player.inventory.armorInventory[1].getItem() != SuperSolarPanels.quantumLeggings && player.inventory.armorInventory[0].getItem() != SuperSolarPanels.quantumBoots) {
				if(!ItemArmorQuantumSuit1.hasCompleteHazmat(player) && !ItemArmorHazmat.hasCompleteHazmat(player)) {
				 player.attackEntityFrom(SSPDamageSource.current, 1.0F);}else {
					 return;
				 }
			 
			 
		 } 
		 else if(block instanceof ic2.core.block.wiring.BlockCable) {
			 if(!ItemArmorQuantumSuit1.hasCompleteHazmat(player) && !ItemArmorHazmat.hasCompleteHazmat(player)) {
				 player.attackEntityFrom(SSPDamageSource.current, 1.0F);}else {
					 return;
				 }
		 }
		   }} 
	}

	
}