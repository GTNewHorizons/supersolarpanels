package com.Denfop.block.mechanism;

import ic2.api.recipe.ICannerBottleRecipeManager;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.RecipeOutput;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlotProcessable;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.ItemStack;

public class InvSlotProcessableAlloy extends InvSlotProcessable {
  public ICannerBottleRecipeManager recipeManager;
  
  public InvSlotProcessableAlloy(TileEntityInventory base1, String name1, int oldStartIndex1, int count, ICannerBottleRecipeManager recipeManager1) {
    super(base1, name1, oldStartIndex1, count);
    this.recipeManager = recipeManager1;
  }
  
  public boolean accepts(ItemStack itemStack) {
	    if (itemStack != null && 
	      itemStack.getItem() instanceof ic2.core.item.ItemUpgradeModule)
	      return false;
		return true; 
	  
	  }

  protected RecipeOutput getOutput(ItemStack container, ItemStack fill, boolean adjustInput, boolean forAccept) {
    
        return Recipes.Alloysmelter.getOutputFor(container, fill, adjustInput, forAccept);
      
    
    
  }
  protected RecipeOutput getOutputFor(ItemStack input,ItemStack input1, boolean adjustInput, boolean forAccept) {
	    return getOutput(input, input1, adjustInput, forAccept);
	  }
  public RecipeOutput process() {
	  ItemStack input = ((TileEntityAlloySmelter)this.base).inputSlotA.get();
    ItemStack input1 = ((TileEntityAlloySmelter)this.base).inputSlotB.get();
    if (input == null && !allowEmptyInput())
      return null; 
    if (input1 == null && !allowEmptyInput())
        return null;
    RecipeOutput output = getOutputFor(input,input1, false, true
    		);
    if (output == null)
      return null; 
    List<ItemStack> itemsCopy = new ArrayList<ItemStack>(output.items.size());
    for (ItemStack itemStack : output.items)
      itemsCopy.add(itemStack.copy()); 
    return new RecipeOutput(output.metadata, itemsCopy);
  }
 
  public void consume() {
	
    ItemStack input = ((TileEntityAlloySmelter)this.base).inputSlotA.get();
    ItemStack input1 = ((TileEntityAlloySmelter)this.base).inputSlotB.get();
    if (input != null && input.stackSize <= 0)
	      ((TileEntityAlloySmelter)this.base).inputSlotA.put(null); 
    if (input1 != null && input1.stackSize <= 0)
	      ((TileEntityAlloySmelter)this.base).inputSlotB.put(null); 
   
    
    RecipeOutput output = getOutputFor(input,input1, true, true);
   
  }
  
  public void setRecipeManager(ICannerBottleRecipeManager recipeManager1) {
    this.recipeManager = recipeManager1;
  }
  

  
  protected boolean allowEmptyInput() {
    return false;
  }
}
