

package com.Denfop.block.moleculartransformer;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.Random;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockContainer;

public class BlockMolecularTransformer extends BlockContainer
{
    public IIcon icon;
    
    public BlockMolecularTransformer() {
        super(Material.iron);
        this.setHardness(3.0f);
        this.setLightLevel(1.0f);
        this.setCreativeTab(SuperSolarPanels.tabssp);
    }
    
    public void registerBlockIcons(final IIconRegister par1IconRegister) {
        this.icon = par1IconRegister.registerIcon("supersolarpanel:blockMacerator");
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return SuperSolarPanels.blockMolecularTransformerRenderID;
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
    public static boolean isActive(final IBlockAccess var0, final int var1, final int var2, final int var3) {
        return ((TileEntityBase)var0.getTileEntity(var1, var2, var3)).getActive();
    }
    
    public void breakBlock(final World world, final int i, final int j, final int k, final Block par5, final int par6) {
        final TileEntity tileentity = world.getTileEntity(i, j, k);
        if (tileentity != null) {
            this.dropItems((TileEntityMolecularTransformer)tileentity, world);
        }
        world.removeTileEntity(i, j, k);
        super.breakBlock(world, i, j, k, par5, par6);
    }
    
    public int quantityDropped(final Random random) {
        return 1;
    }
    
    public int damageDropped(final int i) {
        return i;
    }
    
    public TileEntity getBlockEntity(final int i) {
        return new TileEntityMolecularTransformer();
    }
    
    public boolean onBlockActivated(final World world, final int i, final int j, final int k, final EntityPlayer player, final int s, final float f1, final float f2, final float f3) {
        if (player.isSneaking()) {
            return false;
        }
        if (world.isRemote) {
            return true;
        }
        final TileEntity tileentity = world.getTileEntity(i, j, k);
        if (tileentity != null) {
            player.openGui((Object)SuperSolarPanels.instance, 1, world, i, j, k);
        }
        return true;
    }
    
    private void dropItems(final TileEntityMolecularTransformer tileentity, final World world) {
        final Random rand = new Random();
        if (!(tileentity instanceof IInventory)) {
            return;
        }
        final IInventory inventory = (IInventory)tileentity;
        for (int i = 0; i < inventory.getSizeInventory(); ++i) {
            final ItemStack item = inventory.getStackInSlot(i);
            if (item != null && item.stackSize > 0) {
                final float rx = rand.nextFloat() * 0.8f + 0.1f;
                final float ry = rand.nextFloat() * 0.8f + 0.1f;
                final float rz = rand.nextFloat() * 0.8f + 0.1f;
                final EntityItem entityItem = new EntityItem(world, (double)(tileentity.xCoord + rx), (double)(tileentity.yCoord + ry), (double)(tileentity.zCoord + rz), new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
                if (item.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound)item.getTagCompound().copy());
                }
                final float factor = 0.05f;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.20000000298023224;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld((Entity)entityItem);
                item.stackSize = 0;
            }
        }
    }
    
    public TileEntity getBlockEntity() {
        return null;
    }
    
    public TileEntity createNewTileEntity(final World var1, final int i) {
        return this.getBlockEntity(i);
    }
}
