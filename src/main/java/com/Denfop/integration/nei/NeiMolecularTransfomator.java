package com.Denfop.integration.nei;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import ic2.core.IC2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.client.renderer.RenderHelper;
import java.util.Map;
import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

import com.Denfop.Constants;
import com.Denfop.IUCore;
import com.Denfop.api.Recipes;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler.CachedRecipe;

public class NeiMolecularTransfomator extends MolecularRecipeHandler {
	public Class<? extends GuiContainer> getGuiClass() {
		return (Class) com.Denfop.gui.GuiMolecularTransformer.class;
	}

	public void drawBackground(int i) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		RenderHelper.enableGUIStandardItemLighting();
		GuiDraw.changeTexture(getGuiTexture());
		GuiDraw.drawTexturedModalRect(4, 0, 4, 22, 155, 70);

	}

	public String getRecipeName() {
		return StatCollector.translateToLocal("blockMolecularTransformer.name");
	}

	public String getRecipeId() {
		return StatCollector.translateToLocal("blockMolecularTransformer.name");
	}

	public String getGuiTexture() {
		return Constants.TEXTURES + ":textures/gui/guiMolecularTransformerNew.png";
	}

	public String getOverlayIdentifier() {
		return StatCollector.translateToLocal("blockMolecularTransformer.name");
	}

	public Map<IRecipeInput, RecipeOutput> getRecipeList() {
		return Recipes.molecular.getRecipes();
	}
}
