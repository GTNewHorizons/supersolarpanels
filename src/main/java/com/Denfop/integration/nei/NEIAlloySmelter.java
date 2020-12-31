package com.Denfop.integration.nei;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import ic2.core.IC2;
import ic2.neiIntegration.core.recipehandler.MachineRecipeHandler;

import java.util.Map;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.mechanism.GuiMacerator;
import com.Denfop.block.mechanism.Recipes;

import net.minecraft.client.gui.inventory.GuiContainer;

public class NEIAlloySmelter extends MachineRecipeHandler {
  public Class<? extends GuiContainer> getGuiClass() {
    return (Class)GuiMacerator.class;
  }
  
  public String getRecipeName() {
    return "Alloy Smelter";
  }
  
  public String getRecipeId() {
    return "ssp.Alloymachine";
  }
  
  public String getGuiTexture() {
    return SuperSolarPanels.TEXTURES + ":textures/gui/GUIAlloySmelter1.png";
  }
  
  public String getOverlayIdentifier() {
    return "Alloy Smelter";
  }
  
  public Map<IRecipeInput, RecipeOutput> getRecipeList() {
    return Recipes.Alloysmelter.getRecipes();
  }
}
