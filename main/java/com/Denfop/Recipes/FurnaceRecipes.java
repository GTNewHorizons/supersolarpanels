package com.Denfop.Recipes;

import com.Denfop.SuperSolarPanels;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.core.Ic2Items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class FurnaceRecipes {
	public static void recipe() {
		GameRegistry.addSmelting(SuperSolarPanels.platiumore,new ItemStack(SuperSolarPanels.platium_ingot),5.0F);

		  GameRegistry.addSmelting(SuperSolarPanels.wolframore,new ItemStack(SuperSolarPanels.wolfram_ingot),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.spinelore,new ItemStack(SuperSolarPanels.spinel_ingot),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.mikhail_ore,new ItemStack(SuperSolarPanels.mikhail_ingot),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.iridiumore,new ItemStack(SuperSolarPanels.itemSSP,1,7),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.chromiumore,new ItemStack(SuperSolarPanels.chromium_ingot),5.0F);
	    
	        GameRegistry.addSmelting(SuperSolarPanels.nethercoalrack,new ItemStack(Items.coal),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.endcoal_stone,new ItemStack(Items.coal),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.nethercopperrack,Ic2Items.copperIngot,5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.endcopper_stone,Ic2Items.copperIngot,5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.nethertinrack,Ic2Items.tinIngot,5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.endtin_stone,Ic2Items.tinIngot,5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.netherironrack,new ItemStack(Items.iron_ingot),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.endiron_stone,new ItemStack(Items.iron_ingot),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.nethergoldrack,new ItemStack(Items.gold_ingot),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.endgold_stone,new ItemStack(Items.gold_ingot),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.netherdiamondrack,new ItemStack(Items.diamond),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.enddiamond_stone,new ItemStack(Items.diamond),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.netheremeraldrack,new ItemStack(Items.emerald),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.endemerald_stone,new ItemStack(Items.emerald),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.netherredstonerack,new ItemStack(Items.redstone),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.endredstone_stone,new ItemStack(Items.redstone),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.netherlapisrack,new ItemStack(Items.dye,1,4),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.endlapis_stone,new ItemStack(Items.dye,1,4),5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.netherleadrack,Ic2Items.leadIngot,5.0F);
	        GameRegistry.addSmelting(SuperSolarPanels.endlead_stone,Ic2Items.leadIngot,5.0F);
	     
	}
}
