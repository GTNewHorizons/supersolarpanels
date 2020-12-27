package com.Denfop.utils;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeUtil {
	
	public static ItemStack copyWithWildCard(ItemStack itemStack) {
        ItemStack aux = itemStack.copy();
        Items.dye.setDamage(aux, 32767);
        return aux;
    }

}
