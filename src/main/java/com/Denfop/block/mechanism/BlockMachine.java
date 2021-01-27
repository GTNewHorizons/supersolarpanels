package com.Denfop.block.mechanism;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.IC2Items;
import ic2.api.tile.IWrenchable;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import ic2.core.block.TileEntityBlock;
import ic2.core.block.machine.tileentity.TileEntityCompressor;
import ic2.core.block.machine.tileentity.TileEntityInduction;
import ic2.core.block.machine.tileentity.TileEntityMatter;
import ic2.core.init.MainConfig;
import ic2.core.util.ConfigUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import org.apache.commons.lang3.mutable.MutableObject;
import com.Denfop.item.Machina.ItemMachine1;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.SuperSolarPanels;
import com.Denfop.block.Base.BlockMultiID;
import com.Denfop.block.TileEntityDoubleMetalFormer.TileEntityDoubleMetalFormer;
import com.Denfop.block.TileEntityTripleMetalFormer.TileEntityTripleMetalFormer;
import com.Denfop.block.advancedmatter.TileEntityAdvancedMatter;
import com.Denfop.block.containerbase.TileEntityTripleMachine;
import com.Denfop.block.doublecompressor.TileEntityDoubleCompressor;
import com.Denfop.block.doubleelecfurnace.TileEntityDoubleElectricFurnace;
import com.Denfop.block.doubleextractor.TileEntityDoubleExtractor;
import com.Denfop.block.doublemacertator.TileEntityDoubleMacerator;
import com.Denfop.block.doublemacertator.TileEntityDoubleMachine;
import com.Denfop.block.improvematter.TileEntityImprovedMatter;
import com.Denfop.block.triplecompressor.TileEntityTripleCompressor;
import com.Denfop.block.tripleelecfurnace.TileEntityTripleElectricFurnace;
import com.Denfop.block.triplemacerator.TileEntityTripleMacerator;
import com.Denfop.block.ultimatematter.TileEntityUltimateMatter;
import com.Denfop.utils.InternalName;

public class BlockMachine extends BlockContainer {
  public BlockMachine() {
    super(Material.iron);
    setHardness(2.0F);
    setStepSound(soundTypeMetal);
    this.setCreativeTab(SuperSolarPanels.tabssp);
   

  }
  
  
 

  
  @Override
  public TileEntity createTileEntity(World world, int meta) {
    switch (meta) {
       case 1:
    	   return new TileEntityDoubleMacerator();
        case 2:
        	return new TileEntityDoubleExtractor();
        case 3:
        	return new TileEntityDoubleCompressor();
        case 4:
        	return new  TileEntityTripleCompressor();
        case 5:
        	return new TileEntityAdvancedMatter();
        case 6:
        	return new TileEntityTripleMacerator(); 
        case 7:
        	return new TileEntityDoubleElectricFurnace();
        case 8:
        	return new TileEntityTripleElectricFurnace();
        case 9:
        	return new TileEntityImprovedMatter();
        case 10:
        	return new TileEntityUltimateMatter();
        case 11:
        	return new TileEntityDoubleMetalFormer();
        case 12:
        	return new TileEntityTripleMetalFormer();
        case 13:
        	return new com.Denfop.block.mechanism.TileEntityAlloySmelter();
    } 
    return null;
  }
  
  
  private IIcon[][] iconBuffer;
  @Override
  public void registerBlockIcons(final IIconRegister par1IconRegister) {
      this.iconBuffer = new IIcon[14][12];
      this.iconBuffer[1][0] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][1] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator_1");
      this.iconBuffer[1][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][3] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator");
      this.iconBuffer[1][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][6] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][7] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator1_3");
      this.iconBuffer[1][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][9] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator1");
      this.iconBuffer[1][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");   
	      
      this.iconBuffer[2][0] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[2][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[2][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[2][3] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor1");
      this.iconBuffer[2][4] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor_1");
      this.iconBuffer[2][5] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor_1");
      this.iconBuffer[2][6] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[2][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[2][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[2][9] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor2");
      this.iconBuffer[2][10] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor_2");
      this.iconBuffer[2][11] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor_2");
      
      this.iconBuffer[3][0] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][3] = par1IconRegister.registerIcon("supersolarpanel:blockcompressor_1");
      this.iconBuffer[3][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][6] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][9] = par1IconRegister.registerIcon("supersolarpanel:blockcompressor1_1");
      this.iconBuffer[3][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");
      
      this.iconBuffer[4][0] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][3] = par1IconRegister.registerIcon("supersolarpanel:blockcompressor2_1");
      this.iconBuffer[4][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][6] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][9] = par1IconRegister.registerIcon("supersolarpanel:blockcompressor2_2");
      this.iconBuffer[4][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2");
      
      this.iconBuffer[5][0] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][1] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][2] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][3] = par1IconRegister.registerIcon("supersolarpanel:blockMatter1_1");
      this.iconBuffer[5][4] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][5] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][6] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][7] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][8] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][9] = par1IconRegister.registerIcon("supersolarpanel:blockMatter1");
      this.iconBuffer[5][10] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][11] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      
      this.iconBuffer[6][0] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][1] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator2_1");
      this.iconBuffer[6][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][3] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator2");
      this.iconBuffer[6][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][6] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][7] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator2_3");
      this.iconBuffer[6][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][9] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator2_2");
      this.iconBuffer[6][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2");
      
	     this.iconBuffer[7][0] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][3] = par1IconRegister.registerIcon("supersolarpanel:blockElecFurnace1");
	      this.iconBuffer[7][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][6] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");
	      this.iconBuffer[7][9] = par1IconRegister.registerIcon("supersolarpanel:blockElecFurnace1_1");
	      this.iconBuffer[7][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");
	      
	      this.iconBuffer[8][0] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[8][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[8][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[8][3] = par1IconRegister.registerIcon("supersolarpanel:blockElecFurnace2");
	      this.iconBuffer[8][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[8][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[8][6] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[8][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[8][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2");
	      this.iconBuffer[8][9] = par1IconRegister.registerIcon("supersolarpanel:blockElecFurnace2_1");
	      this.iconBuffer[8][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[8][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2");
	      
	      this.iconBuffer[9][0] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
	      this.iconBuffer[9][1] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
	      this.iconBuffer[9][2] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
	      this.iconBuffer[9][3] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2");
	      this.iconBuffer[9][4] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
	      this.iconBuffer[9][5] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
	      this.iconBuffer[9][6] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
	      this.iconBuffer[9][7] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
	      this.iconBuffer[9][8] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
	      this.iconBuffer[9][9] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_1");
	      this.iconBuffer[9][10] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
	      this.iconBuffer[9][11] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
	      
	      this.iconBuffer[10][0] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
	      this.iconBuffer[10][1] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
	      this.iconBuffer[10][2] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
	      this.iconBuffer[10][3] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3");
	      this.iconBuffer[10][4] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
	      this.iconBuffer[10][5] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
	      this.iconBuffer[10][6] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
	      this.iconBuffer[10][7] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
	      this.iconBuffer[10][8] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
	      this.iconBuffer[10][9] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_1");
	      this.iconBuffer[10][10] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
	      this.iconBuffer[10][11] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
	      
	      this.iconBuffer[12][0] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[12][1] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer2");
	      this.iconBuffer[12][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[12][3] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer2_1");
	      this.iconBuffer[12][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[12][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[12][6] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[12][7] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer2_3");
	      this.iconBuffer[12][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[12][9] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer2_2");
	      this.iconBuffer[12][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
	      this.iconBuffer[12][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2");
		  
	     this.iconBuffer[11][0] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[11][1] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer");
	      this.iconBuffer[11][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[11][3] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer_1");
	      this.iconBuffer[11][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[11][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[11][6] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[11][7] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer1");
	      this.iconBuffer[11][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[11][9] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer1_1");
	      this.iconBuffer[11][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[11][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");   
	      
      this.iconBuffer[13][0] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[13][1] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[13][2] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[13][3] = par1IconRegister.registerIcon("supersolarpanel:blockcompressor_3");
      this.iconBuffer[13][4] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[13][5] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[13][6] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[13][7] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[13][8] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[13][9] = par1IconRegister.registerIcon("supersolarpanel:blockcompressor3_1");
      this.iconBuffer[13][10] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[13][11] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
  }
  
  @Override
  public IIcon getIcon(IBlockAccess world, int x, int y, int z, int blockSide)
  {
      int blockMeta = world.getBlockMetadata(x, y, z);
      TileEntity te = world.getTileEntity(x, y, z);
      int facing = (te instanceof TileEntityBlock) ? ((int) (((TileEntityBlock) te).getFacing())) : 0;

      if (isActive(world, x, y, z))
          return iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][facing] + 6];
      else
          return iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][facing]];
  }

  @Override
  public IIcon getIcon(int blockSide, int blockMeta)
  {
      return iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][3]];
  }

  @Override
  public TileEntity createNewTileEntity(World world, int i)
  {
      return null;
  }
 
 
  @Override
  public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
  {
      ArrayList<ItemStack> dropList = super.getDrops(world, x, y, z, metadata, fortune);
      TileEntity te = world.getTileEntity(x, y, z);
      if (te instanceof IInventory)
      {
          IInventory iinv = (IInventory) te;
          for (int index = 0; index < iinv.getSizeInventory(); ++index)
          {
              ItemStack itemstack = iinv.getStackInSlot(index);
              if (itemstack != null)
              {
                  dropList.add(itemstack);
                  iinv.setInventorySlotContents(index, (ItemStack) null);
              }
          }
      }

      return dropList;
  }

  @Override
  public void breakBlock(World world, int x, int y, int z, Block blockID, int blockMeta)
  {
      super.breakBlock(world, x, y, z, blockID, blockMeta);
      boolean var5 = true;
      for (Iterator<ItemStack> iter = getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), 0).iterator(); iter.hasNext(); var5 = false)
      {
          ItemStack var7 = (ItemStack) iter.next();
          if (!var5)
          {
              if (var7 == null)
              {
                  return;
              }

              double var8 = 0.7D;
              double var10 = (double) world.rand.nextFloat() * var8 + (1.0D - var8) * 0.5D;
              double var12 = (double) world.rand.nextFloat() * var8 + (1.0D - var8) * 0.5D;
              double var14 = (double) world.rand.nextFloat() * var8 + (1.0D - var8) * 0.5D;
              EntityItem var16 = new EntityItem(world, (double) x + var10, (double) y + var12, (double) z + var14, var7);
              var16.delayBeforeCanPickup = 10;
              world.spawnEntityInWorld(var16);
              return;
          }
      }
  }
  
  @Override
  public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
  {
      return IC2Items.getItem("advancedMachine").getItem();
  }
  @Override
  public int getDamageValue(World world, int x, int y, int z)
  {
      return world.getBlockMetadata(x, y, z); // advanced machine item meta
                                              // exactly equals the block meta
  }

  @Override
  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
  {
      super.onBlockPlacedBy(world, x, y, z, player, stack);
      int heading = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
      TileEntityBlock te = (TileEntityBlock) world.getTileEntity(x, y, z);
      switch (heading)
      {
      case 0:
          te.setFacing((short) 2);
          break;
      case 1:
          te.setFacing((short) 5);
          break;
      case 2:
          te.setFacing((short) 3);
          break;
      case 3:
          te.setFacing((short) 4);
          break;
      }
  }

  @Override
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
  {
      if (!entityPlayer.isSneaking())
      {
          entityPlayer.openGui(SuperSolarPanels.instance, 0, world, x, y, z);
          return true;
      }

      return false;
  }

  private boolean isActive(IBlockAccess iba, int x, int y, int z)
  {
      return ((TileEntityBlock) iba.getTileEntity(x, y, z)).getActive();
  }

  @Override
  public boolean rotateBlock(World worldObj, int x, int y, int z, ForgeDirection axis)
  {
      if (axis == ForgeDirection.UNKNOWN)
      {
          return false;
      }
      TileEntity tileEntity = worldObj.getTileEntity(x, y, z);

      if ((tileEntity instanceof IWrenchable))
      {
          IWrenchable te = (IWrenchable) tileEntity;

          int newFacing = ForgeDirection.getOrientation(te.getFacing()).getRotation(axis).ordinal();

          if (te.wrenchCanSetFacing(null, newFacing))
          {
              te.setFacing((short) newFacing);
          }
      }

      return false;
  }

  @Override
  public void randomDisplayTick(World world, int i, int j, int k, Random random)
  {
      if (!IC2.platform.isRendering())
      {
          return;
      }
      int meta = world.getBlockMetadata(i, j, k);

      if ((meta == 1) && (isActive(world, i, j, k)))
      {
          TileEntity te = world.getTileEntity(i, j, k);
          int facing = (te instanceof TileEntityBlock) ? ((TileEntityBlock) te).getFacing() : 0;

          float f = i + 0.5F;
          float f1 = j + 0.0F + random.nextFloat() * 6.0F / 16.0F;
          float f2 = k + 0.5F;
          float f3 = 0.52F;
          float f4 = random.nextFloat() * 0.6F - 0.3F;

          switch (facing)
          {
          case 4:
              world.spawnParticle("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
              world.spawnParticle("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
              break;
          case 5:
              world.spawnParticle("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
              world.spawnParticle("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
              break;
          case 2:
              world.spawnParticle("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
              world.spawnParticle("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
              break;
          case 3:
              world.spawnParticle("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
              world.spawnParticle("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
          }

      }
      if ((meta == 3) && (isActive(world, i, j, k)))
      {
          float f = i + 1.0F;
          float f1 = j + 1.0F;
          float f2 = k + 1.0F;
          for (int z = 0; z < 4; z++)
          {
              float fmod = -0.2F - random.nextFloat() * 0.6F;
              float f1mod = -0.1F + random.nextFloat() * 0.2F;
              float f2mod = -0.2F - random.nextFloat() * 0.6F;
              world.spawnParticle("smoke", f + fmod, f1 + f1mod, f2 + f2mod, 0.0D, 0.0D, 0.0D);
          }
      }
  }
  
  @Override
  public boolean hasComparatorInputOverride()
  {
      return true;
  }

  


}
