package com.Denfop.Recipes;

import com.Denfop.IUItem;

import java.util.List;

import com.Denfop.IUCore;

import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

public class CompressorRecipe {
	public static void recipe() {

		addcompressor(Ic2Items.uuMatterCell, new ItemStack(IUItem.matter, 2, 0));
		addcompressor(Ic2Items.carbonFiber, 9, new ItemStack(IUItem.coal_chunk1));
		addcompressor(Ic2Items.carbonPlate, 9, new ItemStack(IUItem.compresscarbon));
		addcompressor(Ic2Items.advancedAlloy, 9, new ItemStack(IUItem.compresscarbonultra));
		addcompressor(Ic2Items.iridiumPlate, 4, new ItemStack(IUItem.QuantumItems2));
		addcompressor(IUItem.uuMatterCell, 1, new ItemStack(IUItem.neutronium));
		addcompressor(new ItemStack(IUItem.QuantumItems2), 9, new ItemStack(IUItem.QuantumItems4));
		addcompressor(new ItemStack(IUItem.wolfram_plate), 9, IUItem.cell);
		addcompressor(new ItemStack(IUItem.neutronium), 9, new ItemStack(IUItem.neutroniumingot, 1));
		addcompressor(new ItemStack(IUItem.spinel_ingot), 9, new ItemStack(IUItem.spinel_plate, 1));
		addcompressor(new ItemStack(IUItem.chromium_ingot), 9, new ItemStack(IUItem.chromium_plate, 1));
		addcompressor(new ItemStack(IUItem.wolfram_ingot), 9, new ItemStack(IUItem.wolfram_plate, 1));
		addcompressor(new ItemStack(IUItem.mikhail_ingot), 9, new ItemStack(IUItem.michail_plate, 1));
		addcompressor(new ItemStack(IUItem.nickel), 9, new ItemStack(IUItem.nickelplate, 1));
		addcompressor(new ItemStack(IUItem.electriumingot), 9, new ItemStack(IUItem.electriumplate, 1));
		addcompressor(OreDictionary.getOres(""), 9, new ItemStack(IUItem.invarplate, 1));
		addcompressor(new ItemStack(IUItem.magnesium_ingot), 9, new ItemStack(IUItem.magnesium_plate, 1));
		addcompressor(new ItemStack(IUItem.platium_ingot), 9, new ItemStack(IUItem.platium_plate, 1));
		addcompressor(Ic2Items.uraniumOre, 1, new ItemStack(IUItem.itemSSP, 1, 8));
		addcompressor(IC2Items.getItem("UranFuel"), 1, new ItemStack(IUItem.itemSSP, 1, 8));
		addcompressor(IC2Items.getItem("crushedUraniumOre"), 1, new ItemStack(IUItem.itemSSP, 1, 8));
	}

	public static void addcompressor(ItemStack input, int n, ItemStack output) {

		Recipes.compressor.addRecipe((IRecipeInput) new RecipeInputItemStack(input, n), null,
				new ItemStack[] { output });
	}
	public static void addcompressor(List<ItemStack> input, int n, ItemStack output) {
for(ItemStack stack : input)
		Recipes.compressor.addRecipe((IRecipeInput) new RecipeInputItemStack(stack, n), null,
				new ItemStack[] { output });
	}
	public static void addcompressor(ItemStack input, ItemStack output) {

		Recipes.compressor.addRecipe((IRecipeInput) new RecipeInputItemStack(input, 1), null,
				new ItemStack[] { output });
	}
}
