package com.Denfop.Recipes;

import com.Denfop.SuperSolarPanels;

import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CompressorRecipe {
	public static void recipe() {
		      
	        
	      
		
		
		
	      addcompressor(Ic2Items.carbonFiber,9, new ItemStack(SuperSolarPanels.coal_chunk1));
	        addcompressor(Ic2Items.carbonPlate,9, new ItemStack(SuperSolarPanels.compresscarbon));
	        addcompressor(Ic2Items.advancedAlloy,9, new ItemStack(SuperSolarPanels.compresscarbonultra));
	        addcompressor(Ic2Items.iridiumPlate, 4, new ItemStack(SuperSolarPanels.QuantumItems2));
	        addcompressor(SuperSolarPanels.uuMatterCell, 1, new ItemStack(SuperSolarPanels.neutronium));
	        addcompressor(new ItemStack(SuperSolarPanels.QuantumItems2), 9, new ItemStack(SuperSolarPanels.QuantumItems4));
	        addcompressor(new ItemStack(SuperSolarPanels.wolfram_plate), 9, SuperSolarPanels.cell);
	        addcompressor(new ItemStack(SuperSolarPanels.neutronium), 9,  new ItemStack(SuperSolarPanels.neutroniumingot,1));
	        addcompressor(new ItemStack(SuperSolarPanels.spinel_ingot), 9,  new ItemStack(SuperSolarPanels.spinel_plate,1));
	        addcompressor(new ItemStack(SuperSolarPanels.chromium_ingot), 9,  new ItemStack(SuperSolarPanels.chromium_plate,1));
	        addcompressor(new ItemStack(SuperSolarPanels.wolfram_ingot), 9,  new ItemStack(SuperSolarPanels.wolfram_plate,1));
	        addcompressor(new ItemStack(SuperSolarPanels.mikhail_ingot), 9,  new ItemStack(SuperSolarPanels.michail_plate,1));
	        addcompressor(new ItemStack(SuperSolarPanels.nickel), 9,  new ItemStack(SuperSolarPanels.nickelplate,1));
	        addcompressor(new ItemStack(SuperSolarPanels.electriumingot), 9,  new ItemStack(SuperSolarPanels.electriumplate,1));
	        addcompressor(new ItemStack(SuperSolarPanels.invaringot), 9,  new ItemStack(SuperSolarPanels.invarplate,1));
	        addcompressor(new ItemStack(SuperSolarPanels.magnesium_ingot), 9,  new ItemStack(SuperSolarPanels.magnesium_plate,1));
	        addcompressor(new ItemStack(SuperSolarPanels.platium_ingot), 9,  new ItemStack(SuperSolarPanels.platium_plate,1));
	        addcompressor(Ic2Items.uraniumOre,1,new ItemStack(SuperSolarPanels.itemSSP,1,8));
	  		addcompressor(IC2Items.getItem("UranFuel"),1,new ItemStack(SuperSolarPanels.itemSSP,1,8));
	  		addcompressor(IC2Items.getItem("crushedUraniumOre"),1,new ItemStack(SuperSolarPanels.itemSSP,1,8));
	}
	public static void addcompressor(ItemStack input,int n,ItemStack output) {
		  Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(input, n), null, new ItemStack[] {output });

		
	}
}
