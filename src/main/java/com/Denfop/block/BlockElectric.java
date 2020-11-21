package com.Denfop.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import ic2.core.block.TileEntityBlock;
import ic2.core.block.wiring.TileEntityElectricBlock;
import ic2.core.init.MainConfig;
import ic2.core.util.ConfigUtil;
import ic2.core.util.StackUtil;
import ic2.core.util.Util;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.apache.commons.lang3.mutable.MutableObject;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.ItemElectricBlock;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.ElectricalBase.TileEntityElectricMFE;
import com.Denfop.tiles.ElectricalBase.TileEntityElectricMFSU;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.utils.InternalName;


public class BlockElectric extends BlockMultiID {
  public BlockElectric(InternalName internalName) {
    super(internalName, Material.iron, ItemElectricBlock.class);
    setHardness(1.5F);
    setStepSound(soundTypeMetal);
    SuperSolarPanels.mfeUnit = new ItemStack((Block)this, 1, 0);
    SuperSolarPanels.mfsUnit = new ItemStack((Block)this, 1, 1);
    GameRegistry.registerTileEntity(TileEntityElectricMFE.class, "MFES");
    GameRegistry.registerTileEntity(TileEntityElectricMFSU.class, "MFSUS");
  }
  private IIcon[][] iconBuffer;
  public void registerBlockIcons(final IIconRegister par1IconRegister) {
      this.iconBuffer = new IIcon[5][6];
      this.iconBuffer[1][0] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[1][1] = par1IconRegister.registerIcon("supersolarpanel:blockChargepadMFSUtop");
      this.iconBuffer[1][2] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[1][3] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[1][4] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[1][5] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][0] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][1] = par1IconRegister.registerIcon("supersolarpanel:blockChargepadMFSUtop");
      this.iconBuffer[0][2] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][3] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][4] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][5] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
  }
  
  public IIcon getIcon(final IBlockAccess world, final int x, final int y, final int z, final int blockSide) {
      final int blockMeta = world.getBlockMetadata(x, y, z);
      final TileEntity te = world.getTileEntity(x, y, z);
      final int facing = (te instanceof TileEntityBase) ? ((TileEntityBase)te).getFacing() : 0;
      if (isActive(world, x, y, z)) {
          return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][facing] + 6];
      }
      return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][facing]];
  }
  
  public IIcon getIcon(final int blockSide, final int blockMeta) {
      return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][3]];
  }
  

  public Item getItemDropped(int meta, Random random, int fortune) {
    if (ConfigUtil.getBool(MainConfig.get(), "balance/ignoreWrenchRequirement"))
      return Item.getItemFromBlock((Block)this); 
    switch (meta) {
      case 2:
      case 3:
        return Item.getItemFromBlock((Block)this);
    } 
    return Ic2Items.machine.getItem();
  }
  
  public int damageDropped(int meta) {
    if (ConfigUtil.getBool(MainConfig.get(), "balance/ignoreWrenchRequirement"))
      return meta; 
    switch (meta) {
      case 2:
      case 3:
        return meta;
    } 
    return Ic2Items.machine.getItemDamage();
  }
  
  public int quantityDropped(Random random) {
    return 1;
  }
  
  public int isProvidingWeakPower(IBlockAccess blockAccess, int x, int y, int z, int side) {
    TileEntityBlock te = (TileEntityBlock)getOwnTe(blockAccess, x, y, z);
    if (!(te instanceof TileEntityElectricBlock))
      return 0; 
    return ((TileEntityElectricBlock)te).isEmittingRedstone() ? 15 : 0;
  }
  
  public boolean canProvidePower() {
    return true;
  }
  
  public boolean isNormalCube(IBlockAccess world, int i, int j, int k) {
    return false;
  }
  
  public boolean isBlockOpaqueCube(World world, int i, int j, int k) {
    return true;
  }
  
  public boolean isBlockSolid(IBlockAccess world, int x, int y, int z, int side) {
    return true;
  }
  
  public Class<? extends TileEntity> getTeClass(int meta, MutableObject<Class<?>[]> ctorArgTypes, MutableObject<Object[]> ctorArgs) {
    switch (meta) {
      case 0:
        return (Class)TileEntityElectricMFE.class;
      case 1:
        return (Class)TileEntityElectricMFSU.class;
    } 
    return null;
  }
  
  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
    if (!IC2.platform.isSimulating())
      return; 
    TileEntityBlock te = (TileEntityBlock)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return; 
    if (te instanceof TileEntityElectricBlock) {
      NBTTagCompound nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
      ((TileEntityElectricBlock)te).energy = nbttagcompound.getDouble("energy");
    } 
    if (entityliving == null) {
      te.setFacing((short)1);
    } else {
      int yaw = MathHelper.floor_double((entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
      int pitch = Math.round(entityliving.rotationPitch);
      if (pitch >= 65) {
        te.setFacing((short)1);
      } else if (pitch <= -65) {
        te.setFacing((short)0);
      } else {
        switch (yaw) {
          case 0:
            te.setFacing((short)2);
            break;
          case 1:
            te.setFacing((short)5);
            break;
          case 2:
            te.setFacing((short)3);
            break;
          case 3:
            te.setFacing((short)4);
            break;
        } 
      } 
    } 
  }
  
  @SideOnly(Side.CLIENT)
  public EnumRarity getRarity(ItemStack stack) {
    return (stack.getItemDamage() == 2 || stack.getItemDamage() == 5) ? EnumRarity.uncommon : EnumRarity.common;
  }
  
  public boolean hasComparatorInputOverride() {
    return true;
  }
  
  public int getComparatorInputOverride(World world, int x, int y, int z, int side) {
    TileEntityBlock te = (TileEntityBlock)getOwnTe((IBlockAccess)world, x, y, z);
    if (!(te instanceof TileEntityBlock))
      return 0; 
    TileEntityElectricBlock teb = (TileEntityElectricBlock)te;
    return (int)Math.round(Util.map(teb.energy, teb.maxStorage, 15.0D));
  }
}
