package com.Denfop;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class StackUtils {
  public static ItemStack copyWithWildCard(ItemStack itemStack) {
    ItemStack ret = itemStack.copy();
    Items.dye.setDamage(ret, 32767);
    return ret;
  }
}
