// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.integration.nei;

import codechicken.nei.PositionedStack;
import net.minecraft.client.gui.inventory.GuiContainer;
import java.util.Iterator;
import com.Denfop.utils.ItemStackUtil;
import com.Denfop.utils.MTRecipeRecord;
import com.Denfop.utils.MTRecipeManager;
import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.FontRenderer;
import com.Denfop.gui.GuiMolecularTransformer;
import net.minecraft.client.Minecraft;
import java.awt.Rectangle;
import codechicken.lib.gui.GuiDraw;
import org.lwjgl.opengl.GL11;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class MTRecipeHandler extends TemplateRecipeHandler
{
    public int ticks;
    
    public void onUpdate() {
        super.onUpdate();
        ++this.ticks;
    }
    
    public void drawBackground(final int i) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GuiDraw.changeTexture(this.getGuiTexture());
        GuiDraw.drawTexturedModalRect(0, 0, 5, 11, 167, 67);
    }
    
    public void loadTransferRects() {
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(17, 35, 12, 12), this.getRecipeId(), new Object[0]));
    }
    
    public String getRecipeName() {
        return "Molecular Transformer";
    }
    
    public String getRecipeId() {
        return "Molecular Transformer";
    }
    
    public void drawExtras(final int r) {
        final float f = (this.ticks >= 20) ? ((this.ticks - 20) % 20 / 20.0f) : 0.0f;
        this.drawProgressBar(15, 29, 177, 3, 10, 9, f, 1);
        final CachedMTRecipe recipe = (CachedMTRecipe) this.arecipes.get(r);
        final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        final ItemStack inputStack = recipe.input;
        final ItemStack outputStack = recipe.output;
        final int energy = recipe.energy;
        final String formatedEnergy = GuiMolecularTransformer.parsingNumber(String.valueOf(energy));
        fontRenderer.drawString("Input: " + inputStack.getDisplayName(), 46, 18, 16777215);
        fontRenderer.drawString("Output: " + outputStack.getDisplayName(), 46, 28, 16777215);
        fontRenderer.drawString("Energy: " + formatedEnergy, 46, 38, 16777215);
    }
    
    public String getGuiTexture() {
        return "advancedsolarpanel:textures/gui/guiMolecularTransformer_nei.png";
    }
    
    public void loadUsageRecipes(final ItemStack ingredient) {
        for (final MTRecipeRecord record : MTRecipeManager.transformerRecipes) {
            if (ItemStackUtil.areStacksEqual(record.inputStack, ingredient)) {
                this.arecipes.add(new CachedMTRecipe(record.inputStack, record.outputStack, record.energyPerOperation));
            }
        }
    }
    
    public void loadCraftingRecipes(final String outputId, final Object... results) {
        if (outputId.equals(this.getRecipeId())) {
            for (final MTRecipeRecord record : MTRecipeManager.transformerRecipes) {
                this.arecipes.add(new CachedMTRecipe(record.inputStack, record.outputStack, record.energyPerOperation));
            }
        }
        else {
            super.loadCraftingRecipes(outputId, results);
        }
    }
    
    public void loadCraftingRecipes(final ItemStack ingredient) {
        for (final MTRecipeRecord record : MTRecipeManager.transformerRecipes) {
            if (ItemStackUtil.areStacksEqual(record.outputStack, ingredient)) {
                this.arecipes.add(new CachedMTRecipe(record.inputStack, record.outputStack, record.energyPerOperation));
            }
        }
    }
    
    public int recipiesPerPage() {
        return 2;
    }
    
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiMolecularTransformer.class;
    }
    
    public class CachedMTRecipe extends TemplateRecipeHandler.CachedRecipe
    {
        public ItemStack input;
        public ItemStack output;
        public int energy;
        
        public CachedMTRecipe(final ItemStack input, final ItemStack output, final int energy) {
            super();
            this.input = input;
            this.output = output;
            this.energy = energy;
        }
        
        public PositionedStack getIngredient() {
            return new PositionedStack((Object)this.input, 12, 8);
        }
        
        public PositionedStack getResult() {
            return new PositionedStack((Object)this.output, 12, 43);
        }
    }
}
