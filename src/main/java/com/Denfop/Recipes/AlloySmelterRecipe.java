package com.Denfop.Recipes;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.mechanism.Recipes;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.core.Ic2Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class AlloySmelterRecipe {
public static void recipe() {
	Recipes.Alloysmelter.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.blast), 1), (NBTTagCompound)null,new ItemStack[]{ Ic2Items.advIronIngot} );
	Recipes.Alloysmelter.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.electriumdust), 1), (NBTTagCompound)null,new ItemStack[]{ new ItemStack(SuperSolarPanels.electriumingot)} );
	Recipes.Alloysmelter.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.invardust), 1), (NBTTagCompound)null,new ItemStack[]{ new ItemStack(SuperSolarPanels.invaringot)} );
}
}
