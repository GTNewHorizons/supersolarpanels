package com.Denfop.item.base;

import com.Denfop.SuperSolarPanels;
import com.Denfop.utils.InternalName;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.IMetalArmor;
import ic2.core.IC2;
import ic2.core.util.Util;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemArmorSSP extends ItemArmor implements IMetalArmor {
  private final String armorName;
  
  private final Object repairMaterial;
  
  public ItemArmorSSP(InternalName internalName, ItemArmor.ArmorMaterial armorMaterial, InternalName armorName1, int armorType1, Object repairMaterial1) {
    super(armorMaterial, IC2.platform.addArmor(armorName1.name()), armorType1);
    this.repairMaterial = repairMaterial1;
    this.armorName = armorName1.name();
    setMaxDamage(armorMaterial.getDurability(armorType1));
    setUnlocalizedName(internalName.name());
    setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp);
    GameRegistry.registerItem((Item)this, internalName.name());
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister iconRegister) {
    String name = getUnlocalizedName();
    if (name != null && name.length() > 4)
      name = name.substring(4); 
    this.itemIcon = iconRegister.registerIcon(SuperSolarPanels.TEXTURES + ":" + name);
  }
  
  public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
    int suffix = (this.armorType == 2) ? 2 : 1;
    return SuperSolarPanels.TEXTURES + ":textures/armor/" + this.armorName + "_" + suffix + ".png";
  }
  
  public String getUnlocalizedName() {
    return "supersolarpanels." + super.getUnlocalizedName().substring(5);
  }
  
  public String getUnlocalizedName(ItemStack itemStack) {
    return getUnlocalizedName();
  }
  
  public String getItemStackDisplayName(ItemStack itemStack) {
    return StatCollector.translateToLocal(getUnlocalizedName(itemStack));
  }
  
  public boolean isMetalArmor(ItemStack itemstack, EntityPlayer player) {
    return true;
  }
  
  public boolean getIsRepairable(ItemStack stack1, ItemStack stack2) {
    return (stack2 != null && Util.matchesOD(stack2, this.repairMaterial));
  }
}
