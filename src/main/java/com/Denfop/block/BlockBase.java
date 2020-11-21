package com.Denfop.block;


import com.Denfop.SuperSolarPanels;
import com.Denfop.utils.InternalName;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.IC2;
import ic2.core.item.block.ItemBlockIC2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public abstract class BlockBase extends Block {
  protected final InternalName internalName;
  
  public BlockBase(InternalName internalName1, Material material) {
    this(internalName1, material, ItemBlockIC2.class);
  }
  
  public BlockBase(InternalName internalName1, Material material, Class<? extends ItemBlockIC2> itemClass) {
    super(material);
    setBlockName(internalName1.name());
    setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp);
    this.internalName = internalName1;
    GameRegistry.registerBlock(this, itemClass, internalName1.name());
  }
  
  @SideOnly(Side.CLIENT)
  public abstract void registerBlockIcons(IIconRegister paramIIconRegister);
  
  @SideOnly(Side.CLIENT)
  public abstract IIcon getIcon(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @SideOnly(Side.CLIENT)
  public IIcon getIcon(int side, int meta) {
    int facing = getFacing(meta);
    int index = getTextureIndex(meta);
    int subIndex = getTextureSubIndex(facing, side);
    if (index >= this.textures.length)
      return null; 
    try {
      return this.textures[index][subIndex];
    } catch (Exception e) {
      IC2.platform.displayError(e, "Side: %d\nBlock: %s\nMeta: %d\nFacing: %d\nIndex: %d\nSubIndex: %d", new Object[] { Integer.valueOf(side), this, Integer.valueOf(meta), Integer.valueOf(facing), Integer.valueOf(index), Integer.valueOf(subIndex) });
      return null;
    } 
  }
  
  public String getUnlocalizedName() {
    return super.getUnlocalizedName().substring(5);
  }
  
  protected int getFacing(int meta) {
    return 3;
  }
  
  public int getFacing(IBlockAccess iBlockAccess, int x, int y, int z) {
    int meta = iBlockAccess.getBlockMetadata(x, y, z);
    return getFacing(meta);
  }
  
  protected String getTextureFolder(int index) {
    return null;
  }
  
  protected String getTextureName(int index) {
    Item item = Item.getItemFromBlock(this);
    if (!item.getHasSubtypes()) {
      if (index == 0)
        return getUnlocalizedName(); 
      return null;
    } 
    ItemStack itemStack = new ItemStack(this, 1, index);
    String ret = item.getUnlocalizedName(itemStack);
    if (ret == null)
      return null; 
    return ret.substring(4).replace("item", "block");
  }
  
  public boolean canBeReplacedByLeaves(IBlockAccess aWorld, int aX, int aY, int aZ) {
    return false;
  }
  
  protected int getTextureIndex(int meta) {
    return meta;
  }
  
  public static final int getTextureSubIndex(int facing, int side) {
    return facingAndSideToSpriteOffset[facing][side];
  }
  
  protected int getMetaCount() {
    int metaCount = 0;
    for (; getTextureName(metaCount) != null; metaCount++);
    return metaCount;
  }
  
  @SideOnly(Side.CLIENT)
  public EnumRarity getRarity(ItemStack stack) {
    return EnumRarity.common;
  }
  
  private static final int[][] facingAndSideToSpriteOffset = new int[][] { { 3, 5, 1, 0, 4, 2 }, { 5, 3, 1, 0, 2, 4 }, { 0, 1, 3, 5, 4, 2 }, { 0, 1, 5, 3, 2, 4 }, { 0, 1, 2, 4, 3, 5 }, { 0, 1, 4, 2, 5, 3 } };
  
  @SideOnly(Side.CLIENT)
  protected IIcon[][] textures;
}
