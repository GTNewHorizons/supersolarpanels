package com.Denfop.block.Base;
import ic2.core.block.wiring.TileEntityChargepadBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.core.IC2;
import ic2.core.util.StackUtil;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.apache.commons.lang3.mutable.MutableObject;

import com.Denfop.SuperSolarPanels;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.utils.InternalName;

public class BlockChargepad extends BlockMultiID {
  public BlockChargepad(InternalName internalName) {
    super(internalName, Material.iron, ItemChargepadBlock.class);
    setHardness(1.5F);
    setStepSound(soundTypeMetal);
    setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.95F, 1.0F);
    SuperSolarPanels.ChargepadmfeUnit = new ItemStack((Block)this, 1, 0);
    SuperSolarPanels.ChargepadmfsUnit = new ItemStack((Block)this, 1, 1);
    GameRegistry.registerTileEntity(TileEntityChargepadMFES.class, "CMFE");
    GameRegistry.registerTileEntity(TileEntityChargepadMFSUS.class, "CMFSU");
  }
  
  public String getTextureFolder(int id) {
    return null;
  }
  private IIcon[][] iconBuffer;
  public void registerBlockIcons(final IIconRegister par1IconRegister) {
      this.iconBuffer = new IIcon[2][12];
      this.iconBuffer[1][0] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][1] = par1IconRegister.registerIcon("supersolarpanel:hv_transformer_bottomtop");
      this.iconBuffer[1][2] = par1IconRegister.registerIcon("supersolarpanel:blockChargepadMFSUS2");
      this.iconBuffer[1][3] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][4] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][5] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][6] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][7] = par1IconRegister.registerIcon("supersolarpanel:hv_transformer_bottomtop");
      this.iconBuffer[1][8] = par1IconRegister.registerIcon("supersolarpanel:blockChargepadMFSUS3");
      this.iconBuffer[1][9] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][10] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[1][11] = par1IconRegister.registerIcon("supersolarpanel:blockmfsu2");
      this.iconBuffer[0][0] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][1] = par1IconRegister.registerIcon("supersolarpanel:blockChargepadMFSUtop");
      this.iconBuffer[0][2] = par1IconRegister.registerIcon("supersolarpanel:blockChargepadMFSUS");
      this.iconBuffer[0][3] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][4] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][5] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][6] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][7] = par1IconRegister.registerIcon("supersolarpanel:blockChargepadMFSUtop");
      this.iconBuffer[0][8] = par1IconRegister.registerIcon("supersolarpanel:blockChargepadMFSUS1");
      this.iconBuffer[0][9] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][10] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
      this.iconBuffer[0][11] = par1IconRegister.registerIcon("supersolarpanel:blockMFSU");
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
      return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][0]];
  }
  public int isProvidingWeakPower(IBlockAccess blockAccess, int x, int y, int z, int side) {
    TileEntityChargepadBlock te = (TileEntityChargepadBlock)getOwnTe(blockAccess, x, y, z);
    if (te == null)
      return 0; 
    return te.isEmittingRedstone() ? 15 : 0;
  }
  
  public boolean canProvidePower() {
    return true;
  }
  
  public Class<? extends TileEntity> getTeClass(int meta, MutableObject<Class<?>[]> ctorArgTypes, MutableObject<Object[]> ctorArgs) {
    switch (meta) {
      case 0:
        return (Class)TileEntityChargepadMFES.class;
      case 1:
        return (Class)TileEntityChargepadMFSUS.class;
    } 
    return null;
  }
  
  public void randomDisplayTick(World world, int x, int y, int z, Random random) {
    if (!IC2.platform.isRendering())
      return; 
    TileEntityChargepadBlock te = (TileEntityChargepadBlock)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return; 
    te.spawnParticles(world, x, y, z, random);
  }
  
  public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    if (!IC2.platform.isSimulating())
      return; 
    if (entity instanceof EntityPlayer) {
      TileEntityChargepadBlock te = (TileEntityChargepadBlock)getOwnTe((IBlockAccess)world, x, y, z);
      if (te == null)
        return; 
      te.playerstandsat((EntityPlayer)entity);
    } 
  }
  
  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
    if (!IC2.platform.isSimulating())
      return; 
    TileEntityChargepadBlock te = (TileEntityChargepadBlock)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return; 
    NBTTagCompound nbttagcompound = StackUtil.getOrCreateNbtData(stack);
    te.energy = nbttagcompound.getDouble("energy");
    if (entity == null) {
      te.setFacing((short)0);
    } else {
      int yaw = MathHelper.floor_double((entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
      int pitch = Math.round(entity.rotationPitch);
      if (pitch <= -65) {
        te.setFacing((short)0);
      } else {
        switch (yaw) {
          case 0:
            te.setFacing((short)2);
            break;
          case 1:
            te.setFacing((short)5);
            break;
        } 
      } 
    } 
  }
  
  public boolean isOpaqueCube() {
    return false;
  }
  
  public boolean isNormalCube(IBlockAccess world, int i, int j, int k) {
    return false;
  }
}
