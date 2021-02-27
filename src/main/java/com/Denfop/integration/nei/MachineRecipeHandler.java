package com.Denfop.integration.nei;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import ic2.core.util.StackUtil;
import ic2.neiIntegration.core.PositionedStackIc2;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.lwjgl.opengl.GL11;

public abstract class MachineRecipeHandler extends TemplateRecipeHandler {
  protected int ticks;
  
  public abstract String getRecipeName();
  
  public abstract String getRecipeId();
  
  public abstract String getGuiTexture();
  
  public abstract String getOverlayIdentifier();
  
  public abstract Map<IRecipeInput, RecipeOutput> getRecipeList();
  
  public class CachedIORecipe extends TemplateRecipeHandler.CachedRecipe {
    private final List<PositionedStack> ingredients;
    
    private final PositionedStack output;
    
    private final List<PositionedStack> otherStacks;
    
    final NBTTagCompound meta;

    
    public List<PositionedStack> getIngredients() {
      return getCycledIngredients(MachineRecipeHandler.this.cycleticks / 20, this.ingredients);
    }
    
    public PositionedStack getResult() {
      return this.output ;
    }
    
    public List<PositionedStack> getOtherStacks() {
      return this.otherStacks;
    }
    
    public CachedIORecipe(ItemStack input, ItemStack output1) {
      super();
      this.ingredients = new ArrayList<PositionedStack>();
      this.otherStacks = new ArrayList<PositionedStack>();
      if (input == null)
        throw new NullPointerException("Input must not be null (recipe " + input + " -> " + output1 + ")."); 
      if (output1 == null)
        throw new NullPointerException("Output must not be null (recipe " + input + " -> " + output1 + ")."); 
      this.ingredients.add(new PositionedStack(input, MachineRecipeHandler.this.getInputPosX()-9, MachineRecipeHandler.this.getInputPosY()));
      this.ingredients.add(new PositionedStack(input, MachineRecipeHandler.this.getInputPosX()+7, MachineRecipeHandler.this.getInputPosY()));
      
      this.output = new PositionedStack(output1, MachineRecipeHandler.this.getOutputPosX()-9, MachineRecipeHandler.this.getOutputPosY());
        this.meta = null;
    }
    
    public CachedIORecipe(IRecipeInput input, RecipeOutput output1) {
      super();
      this.ingredients = new ArrayList<PositionedStack>();
     
      this.otherStacks = new ArrayList<PositionedStack>();
      if (input == null)
        throw new NullPointerException("Input must not be null (recipe " + input + " -> " + output1 + ")."); 
      if (output1 == null)
        throw new NullPointerException("Output must not be null (recipe " + input + " -> " + output1 + ")."); 
      if (output1.items.isEmpty())
        throw new IllegalArgumentException("Output must not be empty (recipe " + input + " -> " + output1 + ")."); 
      if (output1.items.contains(null))
        throw new IllegalArgumentException("Output must not contain null (recipe " + input + " -> " + output1 + ")."); 
      List<ItemStack> items = new ArrayList<ItemStack>();
      for (ItemStack item : input.getInputs())
        items.add(StackUtil.copyWithSize(item, input.getAmount())); 
      this.ingredients.add(new PositionedStackIc2(items, MachineRecipeHandler.this.getInputPosX()+7, MachineRecipeHandler.this.getInputPosY()));
      
      this.ingredients.add(new PositionedStackIc2(items, MachineRecipeHandler.this.getInputPosX()-9, MachineRecipeHandler.this.getInputPosY()));
      this.output = (PositionedStack)new PositionedStackIc2(output1.items.get(0), MachineRecipeHandler.this.getOutputPosX()+7, MachineRecipeHandler.this.getOutputPosY());
       
          this.otherStacks.add(new PositionedStack(output1.items.get(0), MachineRecipeHandler.this.getOutputPosX()-9, MachineRecipeHandler.this.getOutputPosY()));
       
      this.meta = output1.metadata;
    }
  }
  
  public void drawBackground(int i) {
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    GuiDraw.changeTexture(getGuiTexture());
    GuiDraw.drawTexturedModalRect(0, 0, 5, 11, 140, 65);
  }
  
  public void drawExtras(int i) {
    float f = (this.ticks >= 20) ? (((this.ticks - 20) % 20) / 20.0F) : 0.0F;
    drawProgressBar(74, 23, 176, 14, 25, 16, f, 0);
    f = (this.ticks <= 20) ? (this.ticks / 20.0F) : 1.0F;
    drawProgressBar(52, 25, 176, 0, 14, 14, f, 3);
  }
  
  public void onUpdate() {
    super.onUpdate();
    this.ticks++;
  }
  
  public void loadTransferRects() {
    this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(74, 23, 25, 16), getRecipeId(), new Object[0]));
  }
  
  public void loadCraftingRecipes(String outputId, Object... results) {
    if (outputId.equals(getRecipeId())) {
      for (Map.Entry<IRecipeInput, RecipeOutput> entry : getRecipeList().entrySet())
        this.arecipes.add(new CachedIORecipe(entry.getKey(), entry.getValue())); 
    } else {
      super.loadCraftingRecipes(outputId, results);
    } 
  }
  
  public void loadCraftingRecipes(ItemStack result) {
    for (Map.Entry<IRecipeInput, RecipeOutput> entry : getRecipeList().entrySet()) {
      for (ItemStack output : ((RecipeOutput)entry.getValue()).items) {
        if (NEIServerUtils.areStacksSameTypeCrafting(output, result))
          this.arecipes.add(new CachedIORecipe(entry.getKey(), entry.getValue())); 
      } 
    } 
  }
  
  public void loadUsageRecipes(ItemStack ingredient) {
    for (Map.Entry<IRecipeInput, RecipeOutput> entry : getRecipeList().entrySet()) {
      if (((IRecipeInput)entry.getKey()).matches(ingredient))
        this.arecipes.add(new CachedIORecipe(entry.getKey(), entry.getValue())); 
    } 
  }
  
  protected int getInputPosX() {
    return 51;
  }
  
  protected int getInputPosY() {
    return 6;
  }
  
  protected int getOutputPosX() {
    return 111;
  }
  
  protected int getOutputPosY() {
    return 24;
  }
  
  protected boolean isOutputsVertical() {
    return true;
  }
}
