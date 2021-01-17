package com.Denfop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.Denfop.block.Base.BlockSSP;
import com.Denfop.block.cable.BlockCable;
import com.Denfop.block.cable.SSPDamageSource;
import com.Denfop.block.cable.TileEntityCable;
import com.Denfop.item.armour.ItemArmorQuantumSuit1;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import ic2.api.energy.EnergyNet;
import ic2.api.energy.NodeStats;
import ic2.api.energy.event.EnergyTileEvent;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import ic2.core.WorldData;
import ic2.core.item.armor.ItemArmorHazmat;
import ic2.core.util.LogCategory;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.event.world.*;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.*;
import net.minecraftforge.event.world.WorldEvent;
public class SSPEventHandler {
	@SubscribeEvent
	public  void FlyUpdate( LivingEvent.LivingUpdateEvent event) {
		
	    if (event.entityLiving == null || !(event.entityLiving instanceof EntityPlayer)) return;
	    EntityPlayer player = (EntityPlayer) event.entity;
	    
	    if(event.entityLiving instanceof EntityPlayer) { 
		 if(player.capabilities.isCreativeMode ==false) {
			 
			 NBTTagCompound nbtData = SuperSolarPanels.getOrCreateNbtData1(player);
			boolean fly = nbtData.getBoolean("isFlyActive");
			if(player.inventory.armorInventory[2] != null) {
			if(player.inventory.armorInventory[2].getItem() == SuperSolarPanels.quantumBodyarmor) {
				NBTTagCompound	 nbtData1 = SuperSolarPanels.getOrCreateNbtData(player.inventory.armorInventory[2]);
				boolean jetpack = nbtData1.getBoolean("jetpack");
				if(jetpack == false) {
					player.capabilities.isFlying = false;
					player.capabilities.allowFlying = false;
					nbtData1.setBoolean("isFlyActive",false);
					nbtData.setBoolean("isFlyActive",false);
				}else {
					player.capabilities.isFlying = true;
					player.capabilities.allowFlying = true;
				    nbtData.setBoolean("isFlyActive",true);
				    nbtData1.setBoolean("isFlyActive",true);
				}
			}else if(player.inventory.armorInventory[2].getItem() != SuperSolarPanels.quantumBodyarmor&& player.inventory.armorInventory[2] != null) {
				if(nbtData.getBoolean("isFlyActive") == true) {
					player.capabilities.isFlying = false;
					player.capabilities.allowFlying = false;
				    nbtData.setBoolean("isFlyActive",false);
				}
			}	
			}else {
				if(nbtData.getBoolean("isFlyActive") == true) {
					player.capabilities.isFlying = false;
					player.capabilities.allowFlying = false;
				    nbtData.setBoolean("isFlyActive",false);
				}
			}
			
			
			}
	}
	}

	
	@SubscribeEvent
	public void UpdateHelmet(LivingEvent.LivingUpdateEvent event) {
		
		if (event.entityLiving == null || !(event.entityLiving instanceof EntityPlayer)) return;
		 EntityPlayer player = (EntityPlayer) event.entity;
		 NBTTagCompound nbtData = SuperSolarPanels.getOrCreateNbtData1(player);
		 if(player.inventory.armorInventory[3] != null) {
			 if(player.inventory.armorInventory[3].getItem() == SuperSolarPanels.quantumHelmet) {
				 nbtData.setBoolean("isNightVision", true);
			 }else if(player.inventory.armorInventory[3].getItem() ==Ic2Items.nanoHelmet.getItem()) {
				 nbtData.setBoolean("isNightVision", true);
			 }else if(player.inventory.armorInventory[3].getItem() ==Ic2Items.quantumHelmet.getItem()){
				 nbtData.setBoolean("isNightVision", true);
			 }else if(player.inventory.armorInventory[3].getItem() == SuperSolarPanels.advancedSolarHelmet) {
				 nbtData.setBoolean("isNightVision", true);
			 }else if(player.inventory.armorInventory[3].getItem() == SuperSolarPanels.hybridSolarHelmet) {
				 nbtData.setBoolean("isNightVision", true);
			 }else if(player.inventory.armorInventory[3].getItem() == SuperSolarPanels.spectralSolarHelmet) {
				 nbtData.setBoolean("isNightVision", true);
			 }else if(player.inventory.armorInventory[3].getItem() == SuperSolarPanels.singularSolarHelmet) {
				 nbtData.setBoolean("isNightVision", true);
			 }else if(player.inventory.armorInventory[3].getItem() ==Ic2Items.nightvisionGoggles.getItem()){
				 nbtData.setBoolean("isNightVision", true);
			 }else if(player.inventory.armorInventory[3].getItem() == SuperSolarPanels.ultimateSolarHelmet) {
				 nbtData.setBoolean("isNightVision", true);
			 }
		 }else if(nbtData.getBoolean("isNightVision")) {
			 nbtData.setBoolean("isNightVision", false);
		 }
	}
	
	@SubscribeEvent
	public void UpdateBightVision(LivingEvent.LivingUpdateEvent event) {
		if(Config.nightvision) {
		if (event.entityLiving == null || !(event.entityLiving instanceof EntityPlayer)) return;
	    EntityPlayer player = (EntityPlayer) event.entity;
	    int x = MathHelper.floor_double(player.posX);
        int z = MathHelper.floor_double(player.posZ);
        int y = MathHelper.floor_double(player.posY);
        int skylight = player.worldObj.getBlockLightValue(x, y, z);
        NBTTagCompound nbtData = SuperSolarPanels.getOrCreateNbtData1(player);
        if(nbtData.getBoolean("isNightVision")){
        	if(player.posY < 60 && skylight <8) {
           	 player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 300, 0, true));
           }
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

	@SubscribeEvent
	public void Potion(LivingEvent.LivingUpdateEvent event) {
		 if (event.entityLiving == null || !(event.entityLiving instanceof EntityPlayer)) 
			  return;
		 EntityPlayer player = (EntityPlayer) event.entity;
		 if(ItemArmorQuantumSuit1.hasCompleteHazmat(player))
			 player.addPotionEffect(new PotionEffect(Potion.jump.id, 300, 0, true));
	}
	
}