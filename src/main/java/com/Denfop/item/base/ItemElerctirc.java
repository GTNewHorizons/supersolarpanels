package com.Denfop.item.base;

import ic2.api.item.ElectricItem;
import ic2.api.item.ICustomDamageItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IItemHudInfo;
import ic2.core.IC2;
import ic2.core.util.LogCategory;
import java.util.LinkedList;
import java.util.List;

import com.Denfop.utils.InternalName;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.ISpecialArmor;

public abstract class ItemElerctirc extends ItemArmorSSP implements ISpecialArmor, IElectricItem, IItemHudInfo, ICustomDamageItem {
  protected final double maxCharge;
  
  protected final double transferLimit;
  
  protected final int tier;
  
  private final ThreadLocal<Boolean> allowDamaging;
  
  public ItemElerctirc(InternalName internalName, InternalName armorName, int armorType1, double maxCharge1, double transferLimit1, int tier1) {
    super(internalName, ItemArmor.ArmorMaterial.DIAMOND, armorName, armorType1, (Object)null);
    this.allowDamaging = new ThreadLocal<Boolean>();
    this.maxCharge = maxCharge1;
    this.tier = tier1;
    this.transferLimit = transferLimit1;
    setMaxDamage(27);
    setMaxStackSize(1);
    setNoRepair();
  }
  
  public int getItemEnchantability() {
    return 0;
  }
  
  public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
    return false;
  }
  
  public List<String> getHudInfo(ItemStack itemStack) {
    List<String> info = new LinkedList<String>();
    info.add(ElectricItem.manager.getToolTip(itemStack));
    info.add(StatCollector.translateToLocal("ic2.item.tooltip.PowerTier") + " " + this.tier);
    return info;
  }
  
  public void Information(ItemStack itemStack, EntityPlayer player, List<String> info, boolean b) {
    info.add(StatCollector.translateToLocal("ic2.item.tooltip.PowerTier") + " " + this.tier);
  }
  
  public void SubItems(Item item, CreativeTabs tabs, List<ItemStack> itemList) {
    ItemStack charged = new ItemStack((Item)this, 1);
    ElectricItem.manager.charge(charged, Double.POSITIVE_INFINITY, 2147483647, true, false);
    itemList.add(charged);
    itemList.add(new ItemStack((Item)this, 1, getMaxDamage()));
  }
  
  public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
    if (source.isUnblockable())
      return new ISpecialArmor.ArmorProperties(0, 0.0D, 0); 
    double absorptionRatio = getBaseAbsorptionRatio() * getDamageAbsorptionRatio();
    int energyPerDamage = getEnergyPerDamage();
    int damageLimit = Integer.MAX_VALUE;
    if (energyPerDamage > 0)
      damageLimit = (int)Math.min(damageLimit, 25.0D * ElectricItem.manager.getCharge(armor) / energyPerDamage); 
    return new ISpecialArmor.ArmorProperties(0, absorptionRatio, damageLimit);
  }
  
  public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
    if (ElectricItem.manager.getCharge(armor) >= getEnergyPerDamage())
      return (int)Math.round(20.0D * getBaseAbsorptionRatio() * getDamageAbsorptionRatio()); 
    return 0;
  }
  
  public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
    ElectricItem.manager.discharge(stack, (damage * getEnergyPerDamage()), 2147483647, true, false, false);
  }
  
  public boolean canProvideEnergy(ItemStack itemStack) {
    return false;
  }
  
  public Item getChargedItem(ItemStack itemStack) {
    return (Item)this;
  }
  
  public Item getEmptyItem(ItemStack itemStack) {
    return (Item)this;
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
  
  public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
    return false;
  }
  
  public void setDamage(ItemStack stack, int damage) {
    if (damage == stack.getItemDamage())
      return; 
    Boolean allow = this.allowDamaging.get();
    if (allow == null || !allow.booleanValue()) {
      IC2.log.warn(LogCategory.Item, new Throwable(), "Detected invalid armor damage application:");
    } else {
      super.setDamage(stack, damage);
    } 
  }
  
  public int getCustomDamage(ItemStack stack) {
    return stack.getItemDamage();
  }
  
  public int getMaxCustomDamage(ItemStack stack) {
    return stack.getMaxDamage();
  }
  
  public void setCustomDamage(ItemStack stack, int damage) {
    this.allowDamaging.set(Boolean.valueOf(true));
    stack.setItemDamage(damage);
    this.allowDamaging.set(Boolean.valueOf(false));
  }
  
  public boolean applyCustomDamage(ItemStack stack, int damage, EntityLivingBase src) {
    if (src != null) {
      stack.damageItem(damage, src);
      return true;
    } 
    return stack.attemptDamageItem(damage, IC2.random);
  }
  
  public abstract double getDamageAbsorptionRatio();
  
  public abstract int getEnergyPerDamage();
  
  private double getBaseAbsorptionRatio() {
    switch (this.armorType) {
      case 0:
        return 0.15D;
      case 1:
        return 0.4D;
      case 2:
        return 0.3D;
      case 3:
        return 0.15D;
    } 
    return 0.0D;
  }
}
