package com.Denfop.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Random;

import com.Denfop.SuperSolarPanels;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.firepanel.TileAdminNetherPanel;
import com.Denfop.tiles.overtimepanel.TileAdminSolarPanel;
import com.Denfop.tiles.overtimepanel.TileNeutronSolarPanel;
import com.Denfop.tiles.overtimepanel.TilePhotonicSolarPanel;
import com.Denfop.tiles.overtimepanel.TileProtonSolarPanel;
import com.Denfop.tiles.overtimepanel.TileSingularSolarPanel;
import com.Denfop.tiles.overtimepanel.TileSpectralSolarPanel;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockContainer;

public class BlockSSPSolarPanel extends BlockContainer{
    public boolean qgActive;
    private IIcon[][] iconBuffer;
    
    public BlockSSPSolarPanel() {
        super(Material.iron);
        this.setHardness(3.0f);
        this.setCreativeTab(SuperSolarPanels.tabssp);
        this.qgActive = false;
    }
    
    public void registerBlockIcons(final IIconRegister par1IconRegister) {
        this.iconBuffer = new IIcon[6][12];
        this.iconBuffer[1][0] = par1IconRegister.registerIcon("supersolarpanel:ssp_bottom");
        this.iconBuffer[1][1] = par1IconRegister.registerIcon("supersolarpanel:ssp_top");
        this.iconBuffer[1][2] = par1IconRegister.registerIcon("supersolarpanel:ssp_side");
        this.iconBuffer[1][3] = par1IconRegister.registerIcon("supersolarpanel:ssp_side");
        this.iconBuffer[1][4] = par1IconRegister.registerIcon("supersolarpanel:ssp_side");
        this.iconBuffer[1][5] = par1IconRegister.registerIcon("supersolarpanel:ssp_side");
        this.iconBuffer[1][6] = par1IconRegister.registerIcon("supersolarpanel:ssp_bottom");
        this.iconBuffer[1][7] = par1IconRegister.registerIcon("supersolarpanel:ssp_top");
        this.iconBuffer[1][8] = par1IconRegister.registerIcon("supersolarpanel:ssp_side");
        this.iconBuffer[1][9] = par1IconRegister.registerIcon("supersolarpanel:ssp_side");
        this.iconBuffer[1][10] = par1IconRegister.registerIcon("supersolarpanel:ssp_side");
        this.iconBuffer[1][11] = par1IconRegister.registerIcon("supersolarpanel:ssp_side");
        this.iconBuffer[0][0] = par1IconRegister.registerIcon("supersolarpanel:spsp_bottom");
        this.iconBuffer[0][1] = par1IconRegister.registerIcon("supersolarpanel:spsp_top");
        this.iconBuffer[0][2] = par1IconRegister.registerIcon("supersolarpanel:spsp_side");
        this.iconBuffer[0][3] = par1IconRegister.registerIcon("supersolarpanel:spsp_side");
        this.iconBuffer[0][4] = par1IconRegister.registerIcon("supersolarpanel:spsp_side");
        this.iconBuffer[0][5] = par1IconRegister.registerIcon("supersolarpanel:spsp_side");
        this.iconBuffer[0][6] = par1IconRegister.registerIcon("supersolarpanel:spsp_bottom");
        this.iconBuffer[0][7] = par1IconRegister.registerIcon("supersolarpanel:spsp_top");
        this.iconBuffer[0][8] = par1IconRegister.registerIcon("supersolarpanel:spsp_side");
        this.iconBuffer[0][9] = par1IconRegister.registerIcon("supersolarpanel:spsp_side");
        this.iconBuffer[0][10] = par1IconRegister.registerIcon("supersolarpanel:spsp_side");
        this.iconBuffer[0][11] = par1IconRegister.registerIcon("supersolarpanel:spsp_side");
        this.iconBuffer[3][0] = par1IconRegister.registerIcon("supersolarpanel:admsp_bottom");
        this.iconBuffer[3][1] = par1IconRegister.registerIcon("supersolarpanel:admsp_top");
        this.iconBuffer[3][2] = par1IconRegister.registerIcon("supersolarpanel:admsp_side");
        this.iconBuffer[3][3] = par1IconRegister.registerIcon("supersolarpanel:admsp_side");
        this.iconBuffer[3][4] = par1IconRegister.registerIcon("supersolarpanel:admsp_side");
        this.iconBuffer[3][5] = par1IconRegister.registerIcon("supersolarpanel:admsp_side");
        this.iconBuffer[3][6] = par1IconRegister.registerIcon("supersolarpanel:admsp_bottom");
        this.iconBuffer[3][7] = par1IconRegister.registerIcon("supersolarpanel:admsp_top");
        this.iconBuffer[3][8] = par1IconRegister.registerIcon("supersolarpanel:admsp_side");
        this.iconBuffer[3][9] = par1IconRegister.registerIcon("supersolarpanel:admsp_side");
        this.iconBuffer[3][10] = par1IconRegister.registerIcon("supersolarpanel:admsp_side");
        this.iconBuffer[3][11] = par1IconRegister.registerIcon("supersolarpanel:admsp_side");
        this.iconBuffer[2][0] = par1IconRegister.registerIcon("supersolarpanel:phsp_bottom");
        this.iconBuffer[2][1] = par1IconRegister.registerIcon("supersolarpanel:phsp_top");
        this.iconBuffer[2][2] = par1IconRegister.registerIcon("supersolarpanel:phsp_side");
        this.iconBuffer[2][3] = par1IconRegister.registerIcon("supersolarpanel:phsp_side");
        this.iconBuffer[2][4] = par1IconRegister.registerIcon("supersolarpanel:phsp_side");
        this.iconBuffer[2][5] = par1IconRegister.registerIcon("supersolarpanel:phsp_side");
        this.iconBuffer[2][6] = par1IconRegister.registerIcon("supersolarpanel:phsp_bottom");
        this.iconBuffer[2][7] = par1IconRegister.registerIcon("supersolarpanel:phsp_top");
        this.iconBuffer[2][8] = par1IconRegister.registerIcon("supersolarpanel:phsp_side");
        this.iconBuffer[2][9] = par1IconRegister.registerIcon("supersolarpanel:phsp_side");
        this.iconBuffer[2][10] = par1IconRegister.registerIcon("supersolarpanel:phsp_side");
        this.iconBuffer[2][11] = par1IconRegister.registerIcon("supersolarpanel:phsp_side");
        this.iconBuffer[4][0] = par1IconRegister.registerIcon("supersolarpanel:nsp_bottom");
        this.iconBuffer[4][1] = par1IconRegister.registerIcon("supersolarpanel:nsp_top");
        this.iconBuffer[4][2] = par1IconRegister.registerIcon("supersolarpanel:nsp_side");
        this.iconBuffer[4][3] = par1IconRegister.registerIcon("supersolarpanel:nsp_side");
        this.iconBuffer[4][4] = par1IconRegister.registerIcon("supersolarpanel:nsp_side");
        this.iconBuffer[4][5] = par1IconRegister.registerIcon("supersolarpanel:nsp_side");
        this.iconBuffer[4][6] = par1IconRegister.registerIcon("supersolarpanel:nsp_bottom");
        this.iconBuffer[4][7] = par1IconRegister.registerIcon("supersolarpanel:nsp_top");
        this.iconBuffer[4][8] = par1IconRegister.registerIcon("supersolarpanel:nsp_side");
        this.iconBuffer[4][9] = par1IconRegister.registerIcon("supersolarpanel:nsp_side");
        this.iconBuffer[4][10] = par1IconRegister.registerIcon("supersolarpanel:nsp_side");
        this.iconBuffer[4][11] = par1IconRegister.registerIcon("supersolarpanel:nsp_side");
        this.iconBuffer[5][0] = par1IconRegister.registerIcon("supersolarpanel:nsp_bottom");
        this.iconBuffer[5][1] = par1IconRegister.registerIcon("supersolarpanel:psp_top");
        this.iconBuffer[5][2] = par1IconRegister.registerIcon("supersolarpanel:psp_bottom");
        this.iconBuffer[5][3] = par1IconRegister.registerIcon("supersolarpanel:psp_bottom");
        this.iconBuffer[5][4] = par1IconRegister.registerIcon("supersolarpanel:psp_bottom");
        this.iconBuffer[5][5] = par1IconRegister.registerIcon("supersolarpanel:psp_bottom");
        this.iconBuffer[5][6] = par1IconRegister.registerIcon("supersolarpanel:nsp_bottom");
        this.iconBuffer[5][7] = par1IconRegister.registerIcon("supersolarpanel:psp_top");
        this.iconBuffer[5][8] = par1IconRegister.registerIcon("supersolarpanel:psp_bottom");
        this.iconBuffer[5][9] = par1IconRegister.registerIcon("supersolarpanel:psp_bottom");
        this.iconBuffer[5][10] = par1IconRegister.registerIcon("supersolarpanel:psp_bottom");
        this.iconBuffer[5][11] = par1IconRegister.registerIcon("supersolarpanel:psp_bottom");
   
   
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
    
    public static boolean isActive(final IBlockAccess var0, final int var1, final int var2, final int var3) {
        return ((TileEntityBase)var0.getTileEntity(var1, var2, var3)).getActive();
    }
    
    public void breakBlock(final World world, final int i, final int j, final int k, final Block par5, final int par6) {
        final TileEntity tileentity = world.getTileEntity(i, j, k);
        if (tileentity != null) {
            
                this.dropItems((TileEntitySolarPanel)tileentity, world);
           
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
        switch (i) {
            case 0: {
                return new TileSpectralSolarPanel();
            }
            case 1: {
                return new TileSingularSolarPanel();
            }
            case 2: {
                return new TilePhotonicSolarPanel();
            }
            case 3: {
                return new TileAdminSolarPanel();
            }
            case 4: {
                return new TileNeutronSolarPanel();
            }
            case 5: {
            	 return new TileProtonSolarPanel();
            }
           
        }
		return null;
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
    
    private void dropItems(final TileEntitySolarPanel tileentity, final World world) {
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
    
    public TileEntity createNewTileEntity(final World var1, final int var2) {
        return this.getBlockEntity(var2);
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(final Item item, final CreativeTabs tab, final List subItems) {
        for (int ix = 0; ix < this.iconBuffer.length; ++ix) {
            subItems.add(new ItemStack((Block)this, 1, ix));
        }
    }
}
