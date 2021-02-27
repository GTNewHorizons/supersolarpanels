package com.Denfop.integration.TE;

import com.Denfop.SuperSolarPanels;

import cofh.thermalfoundation.item.TFItems;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TECompressorRecipe {

	public static void init() {
		  Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(TFItems.ingotNickel,9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.nickelplate,1) });
		    
		
	}

}
