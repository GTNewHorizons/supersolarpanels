package com.Denfop.integration.nei;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;
import ic2.core.IC2;
import ic2.neiIntegration.core.recipehandler.MachineRecipeHandler;

import java.util.Map;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.containerbase.GuiDoubleMacerator;

import net.minecraft.client.gui.inventory.GuiContainer;

public class NEIDoubleMacerator extends MachineRecipeHandler {
  public Class<? extends GuiContainer> getGuiClass() {
    return (Class)GuiDoubleMacerator.class;
  }
  
  public String getRecipeName() {
    return "ssp.blockMacerator";
  }
  
  public String getRecipeId() {
    return "ssp.blockMacerator";
  }
  
  public String getGuiTexture() {
	  return SuperSolarPanels.TEXTURES + ":textures/gui/GUIMacerator1.png";
  }
  
  public String getOverlayIdentifier() {
    return "ssp.blockMacerator";
  }
  
  public Map<IRecipeInput, RecipeOutput> getRecipeList() {
    return Recipes.macerator.getRecipes();
  }
}
