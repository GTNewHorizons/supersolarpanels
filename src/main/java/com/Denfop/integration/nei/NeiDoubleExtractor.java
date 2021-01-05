package com.Denfop.integration.nei;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;
import ic2.core.IC2;
import ic2.neiIntegration.core.recipehandler.MachineRecipeHandler;

import java.util.Map;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.containerbase.GuiDoubleMacerator;
import com.Denfop.block.doubleextractor.GuiExtractor;

import net.minecraft.client.gui.inventory.GuiContainer;

public class NeiDoubleExtractor extends MachineRecipeHandler {
  public Class<? extends GuiContainer> getGuiClass() {
    return (Class)GuiExtractor.class;
  }
  
  public String getRecipeName() {
    return "ssp.blockExtractor";
  }
  
  public String getRecipeId() {
    return "ssp.blockExtractor";
  }
  
  public String getGuiTexture() {
	  return SuperSolarPanels.TEXTURES + ":textures/gui/GUIExtractor1.png";
  }
  
  public String getOverlayIdentifier() {
    return "ssp.blockExtractor";
  }
  
  public Map<IRecipeInput, RecipeOutput> getRecipeList() {
    return Recipes.extractor.getRecipes();
  }
}
