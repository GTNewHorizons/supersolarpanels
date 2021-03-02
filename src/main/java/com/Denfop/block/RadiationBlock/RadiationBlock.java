package com.Denfop.block.RadiationBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import com.Denfop.SSPItem;
import com.Denfop.SuperSolarPanels;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.base.TileRadioation;
import com.Denfop.tiles.base.TileSintezator;
import com.Denfop.tiles.overtimepanel.TileEntityAdvancedSolarPanel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RadiationBlock extends Block implements ITileEntityProvider {
  public boolean qgActive;
  
  
  public RadiationBlock() {
    super(Material.iron);
    setHardness(3.0F);
    setCreativeTab(SuperSolarPanels.tabssp4);
   
  }
  public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
	    return SSPItem.toriy;
	  }
  @Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileRadioation();
	}

  public void breakBlock(World world, int i, int j, int k, Block par5, int par6) {
    TileEntity tileentity = world.getTileEntity(i, j, k);
    if (tileentity != null)
     
     
    world.removeTileEntity(i, j, k);
    super.breakBlock(world, i, j, k, par5, par6);
  }
  
  public int quantityDropped(Random random) {
    return 1;
  }
  
  public int damageDropped(int i) {
    return i;
  }
  
  
 
  public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int s, float f1, float f2, float f3) {
    if (player.isSneaking())
      return false; 
    if (world.isRemote)
      return true; 
    TileEntity tileentity = world.getTileEntity(i, j, k);
    if (tileentity != null)
      player.openGui(SuperSolarPanels.instance, 1, world, i, j, k); 
    return true;
  }
  
  
  
  
  
  
}
