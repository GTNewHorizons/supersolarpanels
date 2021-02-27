package com.Denfop.Recipes;

import com.Denfop.SuperSolarPanels;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CentrifugeRecipe {

	public static void init() {
		addcentrifuge(SuperSolarPanels.reactorDepletedtoriyDual, 1,new ItemStack(SuperSolarPanels.toriy,2) );
		addcentrifuge(SuperSolarPanels.reactorDepletedtoriyQuad, 1,  new ItemStack(SuperSolarPanels.toriy,4) );
		addcentrifuge(SuperSolarPanels.reactorDepletedtoriySimple, 1,  new ItemStack(SuperSolarPanels.toriy,1) );
		
		
		addcentrifuge(SuperSolarPanels.reactorDepletedprotonDual, 1,new ItemStack(SuperSolarPanels.proton,2) );
		addcentrifuge(SuperSolarPanels.reactorDepletedprotonQuad, 1, new ItemStack(SuperSolarPanels.proton,4) );
		addcentrifuge(SuperSolarPanels.reactorDepletedprotoneit, 1,new ItemStack(SuperSolarPanels.proton,8) );
		addcentrifuge(SuperSolarPanels.reactorDepletedprotonSimple, 1,new ItemStack(SuperSolarPanels.proton,1));
	 
	}
	
	public static void addcentrifuge(ItemStack stack, int n,ItemStack output) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setShort("minHeat", (short) 5000);
		Recipes.centrifuge.addRecipe((IRecipeInput)new RecipeInputItemStack(stack,n), nbt, output);
		
	}
}
