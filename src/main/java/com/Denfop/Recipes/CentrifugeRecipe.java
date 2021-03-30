package com.Denfop.Recipes;

import com.Denfop.IUItem;
import com.Denfop.IUCore;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CentrifugeRecipe {

	public static void init() {
		addcentrifuge(IUItem.reactorDepletedtoriyDual, 1, new ItemStack(IUItem.toriy, 2));
		addcentrifuge(IUItem.reactorDepletedtoriyQuad, 1, new ItemStack(IUItem.toriy, 4));
		addcentrifuge(IUItem.reactorDepletedtoriySimple, 1, new ItemStack(IUItem.toriy, 1));

		addcentrifuge(IUItem.reactorDepletedprotonDual, 1, new ItemStack(IUItem.proton, 2));
		addcentrifuge(IUItem.reactorDepletedprotonQuad, 1, new ItemStack(IUItem.proton, 4));
		addcentrifuge(IUItem.reactorDepletedprotoneit, 1, new ItemStack(IUItem.proton, 8));
		addcentrifuge(IUItem.reactorDepletedprotonSimple, 1, new ItemStack(IUItem.proton, 1));

	}

	public static void addcentrifuge(ItemStack stack, int n, ItemStack output) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setShort("minHeat", (short) 5000);
		Recipes.centrifuge.addRecipe((IRecipeInput) new RecipeInputItemStack(stack, n), nbt, output);

	}
}
