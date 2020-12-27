package com.Denfop.block.Sintezator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import com.Denfop.SuperSolarPanels;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.tiles.base.TileEntitySolarPanel;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Sintezator extends Block implements ITileEntityProvider {
  public boolean qgActive;
  
  
  public Sintezator() {
    super(Material.iron);
    setHardness(3.0F);
    setCreativeTab(SuperSolarPanels.tabssp);
   
  }
  
  @Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntitySintezator();
	}

	public int getRenderType() {
		return -1;
	}
  
	public boolean isOpaqueCube() {
		return false;
	}
  
  public static boolean isActive(IBlockAccess var0, int var1, int var2, int var3) {
    return ((TileEntityBase)var0.getTileEntity(var1, var2, var3)).getActive();
  }
  
  public void breakBlock(World world, int i, int j, int k, Block par5, int par6) {
    TileEntity tileentity = world.getTileEntity(i, j, k);
    if (tileentity != null)
     
        dropItems((TileSintezator)tileentity, world);  
    world.removeTileEntity(i, j, k);
    super.breakBlock(world, i, j, k, par5, par6);
  }
  
  public int quantityDropped(Random random) {
    return 1;
  }
  
  public int damageDropped(int i) {
    return i;
  }
  
  
  public boolean renderAsNormalBlock() {
		return false;
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
  
  private void dropItems(TileSintezator tileentity, World world) {
    Random rand = new Random();
    if (!(tileentity instanceof net.minecraft.inventory.IInventory))
      return; 
    TileSintezator tileEntitySolarPanel = tileentity;
    for (int i = 0; i < tileEntitySolarPanel.getSizeInventory(); i++) {
      ItemStack item = tileEntitySolarPanel.getStackInSlot(i);
      if (item != null && item.stackSize > 0) {
        float rx = rand.nextFloat() * 0.8F + 0.1F;
        float ry = rand.nextFloat() * 0.8F + 0.1F;
        float rz = rand.nextFloat() * 0.8F + 0.1F;
        EntityItem entityItem = new EntityItem(world, (tileentity.xCoord + rx), (tileentity.yCoord + ry), (tileentity.zCoord + rz), new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
        if (item.hasTagCompound())
          entityItem.getEntityItem().setTagCompound((NBTTagCompound)item.getTagCompound().copy()); 
        float factor = 0.05F;
        entityItem.motionX = rand.nextGaussian() * factor;
        entityItem.motionY = rand.nextGaussian() * factor + 0.20000000298023224D;
        entityItem.motionZ = rand.nextGaussian() * factor;
        world.spawnEntityInWorld((Entity)entityItem);
        item.stackSize = 0;
      } 
    } 
  }
  
  
  
  
}
