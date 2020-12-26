package com.Denfop.block.Base;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.base.ItemBlockIC2;
import com.Denfop.utils.InternalName;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.IC2;
import ic2.core.IHasGui;
import ic2.core.block.BlockTextureStitched;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMetaData extends BlockBase {
  public BlockMetaData(InternalName internalName1, Material mat) {
    super(internalName1, mat);
  }
  
  public BlockMetaData(InternalName internalName1, Material material, Class<? extends ItemBlockIC2> itemClass) {
    super(internalName1, material, itemClass);
  }
  
  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister iconRegister) {
    int metaCount = getMetaCount();
    this.textures = new IIcon[metaCount][6];
    for (int index = 0; index < metaCount; index++) {
      String textureFolder = getTextureFolder(index);
      textureFolder = (textureFolder == null) ? "" : (textureFolder + "/");
      String name = SuperSolarPanels.TEXTURES + ":" + textureFolder + getTextureName(index);
      for (int side = 0; side < 6; side++) {
        int subIndex = side;
        String subName = name + ":" + subIndex;
        TextureAtlasSprite texture = new BlockTextureStitched(subName, subIndex);
        this.textures[index][subIndex] = (IIcon)texture;
        ((TextureMap)iconRegister).setTextureEntry(subName, texture);
      } 
    } 
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int side) {
    int meta = iBlockAccess.getBlockMetadata(x, y, z);
    return getIcon(side, meta);
  }
  
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float a, float b, float c) {
    if (entityPlayer.isSneaking())
      return false; 
    TileEntity te = world.getTileEntity(x, y, z);
    if (te instanceof IHasGui) {
      if (IC2.platform.isSimulating())
        return IC2.platform.launchGui(entityPlayer, (IHasGui)te); 
      return true;
    } 
    return false;
  }
  
  public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
    return new ItemStack(this, 1, world.getBlockMetadata(x, y, z));
  }
}
