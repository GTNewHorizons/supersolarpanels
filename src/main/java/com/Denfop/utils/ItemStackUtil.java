

package com.Denfop.utils;

import net.minecraft.item.ItemStack;

public class ItemStackUtil
{
    public static boolean areStacksEqual(final ItemStack first, final ItemStack second) {
        return first != null && second != null && first.getItem() == second.getItem() && (first.getItemDamage() == second.getItemDamage() || first.getItemDamage() == 32767 || second.getItemDamage() == 32767);
    }
}
