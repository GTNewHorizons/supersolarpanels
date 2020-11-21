package com.Denfop.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IItemHudInfo;
import java.util.LinkedList;
import java.util.List;

import com.Denfop.item.base.ItemSSP;
import com.Denfop.utils.InternalName;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class BaseElectricItem extends ItemSSP implements IElectricItem, IItemHudInfo {
  protected final double maxCharge;
  
  protected final double transferLimit;
  
  protected final int tier;
  
  public BaseElectricItem(InternalName internalName, double maxCharge, double transferLimit, int tier) {
    super(internalName);
    this.maxCharge = maxCharge;
    this.transferLimit = transferLimit;
    this.tier = tier;
    setMaxDamage(27);
    setMaxStackSize(1);
    setNoRepair();
  }
  
  public boolean canProvideEnergy(ItemStack itemStack) {
    return false;
  }
  
  public Item getChargedItem(ItemStack itemStack) {
    return this;
  }
  
  public Item getEmptyItem(ItemStack itemStack) {
    return this;
  }
  
  public double getMaxCharge(ItemStack itemStack) {
    return this.maxCharge;
  }
  
  public int getTier(ItemStack itemStack) {
    return this.tier;
  }
  
  public double getTransferLimit(ItemStack itemStack) {
    return this.transferLimit;
  }
  
  public List<String> getHudInfo(ItemStack itemStack) {
    List<String> info = new LinkedList<String>();
    info.add(ElectricItem.manager.getToolTip(itemStack));
    return info;
  }
  
  @SideOnly(Side.CLIENT)
  public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List itemList) {
    ItemStack itemStack = new ItemStack(this, 1);
    if (getChargedItem(itemStack) == this) {
      ItemStack charged = new ItemStack(this, 1);
      ElectricItem.manager.charge(charged, Double.POSITIVE_INFINITY, 2147483647, true, false);
      itemList.add(charged);
    } 
    if (getEmptyItem(itemStack) == this) {
      ItemStack charged = new ItemStack(this, 1);
      ElectricItem.manager.charge(charged, 0.0D, 2147483647, true, false);
      itemList.add(charged);
    } 
  }
}
