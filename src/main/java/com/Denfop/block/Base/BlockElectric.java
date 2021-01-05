package com.Denfop.block.Base;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.IC2Items;
import ic2.api.tile.IWrenchable;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import ic2.core.block.TileEntityBlock;
import ic2.core.block.wiring.TileEntityElectricBlock;
import ic2.core.init.MainConfig;
import ic2.core.util.ConfigUtil;
import ic2.core.util.StackUtil;
import ic2.core.util.Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import org.apache.commons.lang3.mutable.MutableObject;
import com.Denfop.SuperSolarPanels;
import com.Denfop.item.base.ItemElectricBlock;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.ElectricalBase.TileEntityElectricMFE;
import com.Denfop.tiles.ElectricalBase.TileEntityElectricMFSU;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.utils.InternalName;;


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
      this.iconBuffer = new IIcon[2][6];
      this.iconBuffer[1][0] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][1] = par1IconRegister.registerIcon("supersolarpanel:hv_transformer_bottomtop");
      this.iconBuffer[1][2] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][3] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][4] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][5] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
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
  

  public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
	    ArrayList<ItemStack> dropList = super.getDrops(world, x, y, z, metadata, fortune);
	    TileEntity te = world.getTileEntity(x, y, z);
	    if (te instanceof IInventory) {
	      IInventory iinv = (IInventory)te;
	      for (int index = 0; index < iinv.getSizeInventory(); index++) {
	        ItemStack itemstack = iinv.getStackInSlot(index);
	        if (itemstack != null) {
	          dropList.add(itemstack);
	          iinv.setInventorySlotContents(index, (ItemStack)null);
	        } 
	      } 
	    } 
	    return dropList;
	  }
	  
	  public void breakBlock(World world, int x, int y, int z, Block blockID, int blockMeta) {
	    super.breakBlock(world, x, y, z, blockID, blockMeta);
	    boolean var5 = true;
	    for (Iterator<ItemStack> iter = getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), 0).iterator(); iter.hasNext(); var5 = false) {
	      ItemStack var7 = iter.next();
	      if (!var5) {
	        if (var7 == null)
	          return; 
	        double var8 = 0.7D;
	        double var10 = world.rand.nextFloat() * var8 + (1.0D - var8) * 0.5D;
	        double var12 = world.rand.nextFloat() * var8 + (1.0D - var8) * 0.5D;
	        double var14 = world.rand.nextFloat() * var8 + (1.0D - var8) * 0.5D;
	        EntityItem var16 = new EntityItem(world, x + var10, y + var12, z + var14, var7);
	        var16.delayBeforeCanPickup = 10;
	        world.spawnEntityInWorld((Entity)var16);
	        return;
	      } 
	    } 
	  }
	  
	  public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
	    return IC2Items.getItem("advancedMachine").getItem();
	  }
	  
	  public int getDamageValue(World world, int x, int y, int z) {
	    return world.getBlockMetadata(x, y, z);
	  }
	  
	  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
	    super.onBlockPlacedBy(world, x, y, z, player, stack);
	    int heading = MathHelper.floor_double((player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
	    TileEntityBlock te = (TileEntityBlock)world.getTileEntity(x, y, z);
	    switch (heading) {
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
  
  public boolean rotateBlock(World worldObj, int x, int y, int z, ForgeDirection axis) {
	    if (axis == ForgeDirection.UNKNOWN)
	      return false; 
	    TileEntity tileEntity = worldObj.getTileEntity(x, y, z);
	    if (tileEntity instanceof IWrenchable) {
	      IWrenchable te = (IWrenchable)tileEntity;
	      int newFacing = ForgeDirection.getOrientation(te.getFacing()).getRotation(axis).ordinal();
	      if (te.wrenchCanSetFacing(null, newFacing))
	        te.setFacing((short)newFacing); 
	    } 
	    return false;
	  }
  public boolean hasComparatorInputOverride() {
	    return true;
	  }
	  
	
  @SideOnly(Side.CLIENT)
  public EnumRarity getRarity(ItemStack stack) {
    return (stack.getItemDamage() == 0 || stack.getItemDamage() == 1) ? EnumRarity.uncommon : EnumRarity.common;
  }
  
  
  public int getComparatorInputOverride(World world, int x, int y, int z, int side) {
    TileEntityBlock te = (TileEntityBlock)getOwnTe((IBlockAccess)world, x, y, z);
    if (!(te instanceof TileEntityBlock))
      return 0; 
    TileEntityElectricBlock teb = (TileEntityElectricBlock)te;
    return (int)Math.round(Util.map(teb.energy, teb.maxStorage, 15.0D));
  }
}
