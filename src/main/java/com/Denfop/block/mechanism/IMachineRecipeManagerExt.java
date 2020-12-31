package com.Denfop.block.mechanism;

import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IMachineRecipeManagerExt extends IMachineRecipeManager {
  boolean addRecipe(IRecipeInput paramIRecipeInput, IRecipeInput paramIRecipeInput1, NBTTagCompound paramNBTTagCompound, boolean paramBoolean, ItemStack... paramVarArgs);
}
