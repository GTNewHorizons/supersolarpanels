package com.Denfop.Recipes;

import com.Denfop.SuperSolarPanels;

import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

public class CannerRecipe {
	public static void recipe() {
		Recipes.cannerBottle.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("fuelRod"),1),(IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.proton,1),1),SuperSolarPanels.reactorprotonSimple);
		Recipes.cannerBottle.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("fuelRod"),1),(IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.toriy,1),1),SuperSolarPanels.reactortoriySimple);

	}
}
