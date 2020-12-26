package com.Denfop.item.base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import com.Denfop.item.base.ItemSSP;
import com.Denfop.utils.InternalName;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGradual extends ItemSSP {
  public ItemGradual(InternalName internalName) {
    super(internalName);
    setMaxStackSize(1);
    setMaxDamage(10000);
    setNoRepair();
  }
  
  public boolean isDamaged(ItemStack stack) {
    return (getDamage(stack) > 1);
  }
  
  public boolean showDurabilityBar(ItemStack stack) {
    return true;
  }
  
  @SideOnly(Side.CLIENT)
  public void getSubItems(Item item, CreativeTabs tabs, List itemList) {
    itemList.add(new ItemStack(this, 1, 1));
  }
}
