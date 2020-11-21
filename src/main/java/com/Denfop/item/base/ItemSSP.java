package com.Denfop.item.base;

import com.Denfop.SuperSolarPanels;
import com.Denfop.utils.InternalName;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.IC2;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

public class ItemSSP extends Item {
  private int rarity;
  
  protected IIcon[] textures;
  
  public ItemSSP(InternalName internalName) {
    this.rarity = 0;
    setUnlocalizedName(internalName.name());
    setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp);
    GameRegistry.registerItem(this, internalName.name());
  }
  
  public String getTextureFolder() {
    return null;
  }
  
  public String getTextureName(int index) {
    if (!this.hasSubtypes && index > 0)
      return null; 
    String name = getUnlocalizedName(new ItemStack(this, 1, index));
    if (name != null && name.length() > 4)
      return name.substring(4); 
    return name;
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister iconRegister) {
    int indexCount = 0;
    while (getTextureName(indexCount) != null) {
      indexCount++;
      if (indexCount > 32767)
        throw new RuntimeException("More Item Icons than actually possible @ " + getUnlocalizedName()); 
    } 
    this.textures = new IIcon[indexCount];
    String textureFolder = (getTextureFolder() == null) ? "" : (getTextureFolder() + "/");
    for (int index = 0; index < indexCount; index++)
      this.textures[index] = iconRegister.registerIcon(SuperSolarPanels.TEXTURES + ":" + textureFolder + getTextureName(index)); 
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon getIconFromDamage(int meta) {
    if (meta < this.textures.length)
      return this.textures[meta]; 
    return (this.textures.length < 1) ? null : this.textures[0];
  }
  
  public String getUnlocalizedName() {
    return "ssp." + super.getUnlocalizedName().substring(5);
  }
  
  public String getUnlocalizedName(ItemStack itemStack) {
    return getUnlocalizedName();
  }
  
  public String getItemStackDisplayName(ItemStack itemStack) {
    return StatCollector.translateToLocal(getUnlocalizedName(itemStack));
  }
  
  public ItemSSP setRarity(int aRarity) {
    this.rarity = aRarity;
    return this;
  }
  
  @SideOnly(Side.CLIENT)
  public EnumRarity getRarity(ItemStack stack) {
    return EnumRarity.values()[this.rarity];
  }
}
