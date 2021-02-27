package com.Denfop.integration.TE;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.Mechanism.TileEntityAlloySmelter;

import cofh.thermalfoundation.item.TFItems;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TEAlloySmelterRecipe {

	public static void init() {

		TileEntityAlloySmelter.addAlloysmelter((IRecipeInput)new RecipeInputItemStack(TFItems.ingotNickel, 1), (IRecipeInput)new RecipeInputItemStack(new ItemStack(Items.iron_ingot), 1), new ItemStack(SuperSolarPanels.invaringot) );
  }

}
