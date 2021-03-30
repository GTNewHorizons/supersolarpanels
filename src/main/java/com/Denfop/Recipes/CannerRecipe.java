package com.Denfop.Recipes;

import com.Denfop.IUItem;
import com.Denfop.IUCore;

import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

public class CannerRecipe {
	public static void recipe() {
		Recipes.cannerBottle.addRecipe((IRecipeInput) new RecipeInputItemStack(IC2Items.getItem("fuelRod"), 1),
				(IRecipeInput) new RecipeInputItemStack(new ItemStack(IUItem.proton, 1), 1),
				IUItem.reactorprotonSimple);
		Recipes.cannerBottle.addRecipe((IRecipeInput) new RecipeInputItemStack(IC2Items.getItem("fuelRod"), 1),
				(IRecipeInput) new RecipeInputItemStack(new ItemStack(IUItem.toriy, 9), 1),
				IUItem.reactortoriySimple);

	}
}
