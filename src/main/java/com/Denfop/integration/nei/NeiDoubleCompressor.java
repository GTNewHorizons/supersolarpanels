package com.Denfop.integration.nei;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;
import ic2.core.IC2;
import ic2.neiIntegration.core.recipehandler.MachineRecipeHandler;

import java.util.Map;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.containerbase.GuiDoubleMacerator;
import com.Denfop.block.doublecompressor.GuiDoubleCompressor;
import com.Denfop.block.doubleextractor.GuiExtractor;

import net.minecraft.client.gui.inventory.GuiContainer;

public class NeiDoubleCompressor extends MachineRecipeHandler {
  public Class<? extends GuiContainer> getGuiClass() {
    return (Class)GuiDoubleCompressor.class;
  }
  
  public String getRecipeName() {
    return "ssp.blockCompressor1";
  }
  
  public String getRecipeId() {
    return "sssp.blockCompressor1";
  }
  
  public String getGuiTexture() {
	  return SuperSolarPanels.TEXTURES + ":textures/gui/GUIExtractor1.png";
  }
  
  public String getOverlayIdentifier() {
    return "ssp.blockCompressor1";
  }
  
  public Map<IRecipeInput, RecipeOutput> getRecipeList() {
    return Recipes.compressor.getRecipes();
  }
}
