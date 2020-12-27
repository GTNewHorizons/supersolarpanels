package com.Denfop.block.cable;

import ic2.core.IC2;
import ic2.core.util.StackUtil;
import java.util.Random;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.Base.BlockMetaData;
import com.Denfop.item.base.ItemBlockIC2;
import com.Denfop.utils.InternalName;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFoam extends BlockMetaData {
  public BlockFoam(InternalName internalName1) {
    super(internalName1, Material.cloth, ItemBlockIC2.class);
    setTickRandomly(true);
    setHardness(0.01F);
    setResistance(10.0F);
    setStepSound(soundTypeCloth);
    SuperSolarPanels.constructionFoam = new ItemStack(this);
  }
  
  public String getTextureFolder(int id) {
    return "cf";
  }
  
  public int tickRate(World world) {
    return 500;
  }
  
  public int quantityDropped(Random r) {
    return 0;
  }
  
  public boolean isOpaqueCube() {
    return false;
  }
  
  public boolean isNormalCube(IBlockAccess world, int i, int j, int k) {
    return true;
  }
  
  public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
    return null;
  }
  
  public boolean isBlockSolid(IBlockAccess world, int x, int y, int z, int side) {
    return false;
  }
  
  public void updateTick(World world, int i, int j, int k, Random random) {
    if (!IC2.platform.isSimulating())
      return; 
    if (world.getBlockLightValue(i, j, k) * 6 >= world.rand.nextInt(1000)) {
      world.setBlock(i, j, k, StackUtil.getBlock(SuperSolarPanels.constructionFoamWall), 7, 7);
    } else {
      world.scheduleBlockUpdate(i, j, k, this, tickRate(world));
    } 
  }
  
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float xOffset, float yOffset, float zOffset) {
    ItemStack itemStack = entityPlayer.getCurrentEquippedItem();
    if (itemStack != null && StackUtil.equals((Block)Blocks.sand, itemStack)) {
      world.setBlock(x, y, z, StackUtil.getBlock(SuperSolarPanels.constructionFoamWall), 7, 7);
      if (!entityPlayer.capabilities.isCreativeMode) {
        itemStack.stackSize--;
        if (itemStack.stackSize <= 0)
          entityPlayer.inventory.mainInventory[entityPlayer.inventory.currentItem] = null; 
      } 
      return true;
    } 
    return false;
  }
  
  public boolean canPlaceBlockAt(World world, int x, int y, int z) {
    Block block = world.getBlock(x, y, z);
    return (block.isAir((IBlockAccess)world, x, y, z) || block == Blocks.fire || block
      
      .getMaterial().isLiquid());
  }
  
  public ItemStack createStackedBlock(int i) {
    return null;
  }
  
  public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
    return false;
  }
}
