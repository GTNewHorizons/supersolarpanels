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
		Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(SuperSolarPanels.reactorDepletedtoriyDual, 1), (NBTTagCompound)null,new ItemStack[]{ new ItemStack(SuperSolarPanels.toriy,2)} );
		Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(SuperSolarPanels.reactorDepletedtoriyQuad, 1), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.toriy,4) });
		Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(SuperSolarPanels.reactorDepletedtoriySimple, 1), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.toriy,1) });
	
		//
		Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(SuperSolarPanels.reactorDepletedprotonDual, 1), (NBTTagCompound)null,new ItemStack[]{ new ItemStack(SuperSolarPanels.proton,2)} );
		Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(SuperSolarPanels.reactorDepletedprotonQuad, 1), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.proton,4) });
		Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(SuperSolarPanels.reactorDepletedprotoneit, 1), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.proton,8) });
		Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(SuperSolarPanels.reactorDepletedprotonSimple, 1), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.proton,1)});
	      Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("carbonFiber"), 63), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.coal_chunk1,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("carbonPlate"), 9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.compresscarbon,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("advancedAlloy"), 9), (NBTTagCompound)null, new ItemStack[] {new ItemStack(SuperSolarPanels.compresscarbonultra,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("iridiumPlate"), 1), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.QuantumItems2,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(SuperSolarPanels.uuMatterCell), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.neutronium,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.QuantumItems2), 9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.QuantumItems4,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.neutronium),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.neutroniumingot,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.wolfram_plate),1), (NBTTagCompound)null, new ItemStack[] { SuperSolarPanels.cell });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.spinel_ingot),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.spinel_plate,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.chromium_ingot),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.chromium_plate,1)});
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.wolfram_ingot),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.wolfram_plate,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.mikhail_ingot),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.michail_plate,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.nickel),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.nickelplate,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.electriumingot),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.electriumplate,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.invaringot),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.invarplate,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.magnesium_ingot),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.magnesium_plate,1) });
	        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.platium_ingot),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.platium_plate,1) });

		
	          Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(Ic2Items.uraniumOre, 1), (NBTTagCompound)null, new ItemStack[] {new ItemStack(SuperSolarPanels.itemSSP,1,8) });
	          Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("UranFuel"), 1), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.itemSSP,1,8) });
	          Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("crushedUraniumOre"), 1), (NBTTagCompound)null, new ItemStack[] {new ItemStack(SuperSolarPanels.itemSSP,1,8) });

	         
	}
}
