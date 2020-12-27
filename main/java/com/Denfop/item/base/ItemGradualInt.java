package com.Denfop.item.base;

import com.Denfop.utils.InternalName;

import ic2.api.item.ICustomDamageItem;
import ic2.core.util.StackUtil;
import ic2.core.util.Util;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemGradualInt extends ItemGradual implements ICustomDamageItem {
  private final int maxDmg;
  
  public ItemGradualInt(InternalName internalName, int maxdmg) {
    super(internalName);
    this.maxDmg = maxdmg;
  }
  
  public int getCustomDamage(ItemStack stack) {
    NBTTagCompound nbt = StackUtil.getOrCreateNbtData(stack);
    return nbt.getInteger("advDmg");
  }
  
  public int getMaxCustomDamage(ItemStack stack) {
    return this.maxDmg;
  }
  
  public void setCustomDamage(ItemStack stack, int damage) {
    NBTTagCompound nbt = StackUtil.getOrCreateNbtData(stack);
    nbt.setInteger("advDmg", damage);
    int maxStackDamage = stack.getMaxDamage();
    if (maxStackDamage > 2)
      stack.setItemDamage(1 + (int)Util.map(damage, this.maxDmg, (maxStackDamage - 2))); 
  }
  
  public boolean applyCustomDamage(ItemStack stack, int damage, EntityLivingBase src) {
    setCustomDamage(stack, getCustomDamage(stack) + damage);
    return true;
  }
}
