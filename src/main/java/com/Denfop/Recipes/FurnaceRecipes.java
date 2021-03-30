package com.Denfop.Recipes;

import com.Denfop.IUItem;
import com.Denfop.IUCore;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.core.Ic2Items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class FurnaceRecipes {
	public static void recipe() {
		GameRegistry.addSmelting(IUItem.platiumore, new ItemStack(IUItem.platium_ingot), 5.0F);

		GameRegistry.addSmelting(IUItem.wolframore, new ItemStack(IUItem.wolfram_ingot), 5.0F);
		GameRegistry.addSmelting(IUItem.spinelore, new ItemStack(IUItem.spinel_ingot), 5.0F);
		GameRegistry.addSmelting(IUItem.mikhail_ore, new ItemStack(IUItem.mikhail_ingot), 5.0F);
		GameRegistry.addSmelting(IUItem.iridiumore, new ItemStack(IUItem.itemSSP, 1, 7), 5.0F);
		GameRegistry.addSmelting(IUItem.chromiumore, new ItemStack(IUItem.chromium_ingot), 5.0F);

		GameRegistry.addSmelting(IUItem.magnesiumore, new ItemStack(IUItem.magnesium_ingot, 1), 5.0F);
		GameRegistry.addSmelting(IUItem.nicelore, new ItemStack(IUItem.nickel), 5.0F);
		//
		GameRegistry.addSmelting(IUItem.platiumcrushedore, new ItemStack(IUItem.platium_ingot), 5.0F);

		GameRegistry.addSmelting(IUItem.wolframcrushedore, new ItemStack(IUItem.wolfram_ingot), 5.0F);
		GameRegistry.addSmelting(IUItem.spinelcrushedore, new ItemStack(IUItem.spinel_ingot), 5.0F);
		GameRegistry.addSmelting(IUItem.michalovcrushedore, new ItemStack(IUItem.mikhail_ingot), 5.0F);
		GameRegistry.addSmelting(IUItem.iridiumcrushedore, new ItemStack(IUItem.itemSSP, 1, 7), 5.0F);
		GameRegistry.addSmelting(IUItem.chromiumcrushedore, new ItemStack(IUItem.chromium_ingot), 5.0F);

		GameRegistry.addSmelting(IUItem.magnesiumcrushedore, new ItemStack(IUItem.magnesium_ingot, 1), 5.0F);
		GameRegistry.addSmelting(IUItem.nickelcrushedore, new ItemStack(IUItem.nickel), 5.0F);

		//
		GameRegistry.addSmelting(IUItem.nethercoalrack, new ItemStack(Items.coal), 5.0F);
		GameRegistry.addSmelting(IUItem.endcoal_stone, new ItemStack(Items.coal), 5.0F);
		GameRegistry.addSmelting(IUItem.nethercopperrack, Ic2Items.copperIngot, 5.0F);
		GameRegistry.addSmelting(IUItem.endcopper_stone, Ic2Items.copperIngot, 5.0F);
		GameRegistry.addSmelting(IUItem.nethertinrack, Ic2Items.tinIngot, 5.0F);
		GameRegistry.addSmelting(IUItem.endtin_stone, Ic2Items.tinIngot, 5.0F);
		GameRegistry.addSmelting(IUItem.netherironrack, new ItemStack(Items.iron_ingot), 5.0F);
		GameRegistry.addSmelting(IUItem.endiron_stone, new ItemStack(Items.iron_ingot), 5.0F);
		GameRegistry.addSmelting(IUItem.nethergoldrack, new ItemStack(Items.gold_ingot), 5.0F);
		GameRegistry.addSmelting(IUItem.endgold_stone, new ItemStack(Items.gold_ingot), 5.0F);
		GameRegistry.addSmelting(IUItem.netherdiamondrack, new ItemStack(Items.diamond), 5.0F);
		GameRegistry.addSmelting(IUItem.enddiamond_stone, new ItemStack(Items.diamond), 5.0F);
		GameRegistry.addSmelting(IUItem.netheremeraldrack, new ItemStack(Items.emerald), 5.0F);
		GameRegistry.addSmelting(IUItem.endemerald_stone, new ItemStack(Items.emerald), 5.0F);
		GameRegistry.addSmelting(IUItem.netherredstonerack, new ItemStack(Items.redstone), 5.0F);
		GameRegistry.addSmelting(IUItem.endredstone_stone, new ItemStack(Items.redstone), 5.0F);
		GameRegistry.addSmelting(IUItem.netherlapisrack, new ItemStack(Items.dye, 1, 4), 5.0F);
		GameRegistry.addSmelting(IUItem.endlapis_stone, new ItemStack(Items.dye, 1, 4), 5.0F);
		GameRegistry.addSmelting(IUItem.netherleadrack, Ic2Items.leadIngot, 5.0F);
		GameRegistry.addSmelting(IUItem.endlead_stone, Ic2Items.leadIngot, 5.0F);
		//
		GameRegistry.addSmelting(IUItem.invardust, new ItemStack(IUItem.invaringot), 5.0F);
		GameRegistry.addSmelting(IUItem.electriumdust, new ItemStack(IUItem.electriumingot), 5.0F);
		GameRegistry.addSmelting(IUItem.blast, Ic2Items.advIronIngot, 5.0F);

	}
}
