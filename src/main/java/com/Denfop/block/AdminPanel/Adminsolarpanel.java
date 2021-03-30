package com.Denfop.block.AdminPanel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.tile.IWrenchable;

import java.util.List;
import java.util.Random;

import com.Denfop.IUCore;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.base.TileEntityAdminSolarPanel;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.tiles.base.TileEntityElectricBlock;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.base.TileSintezator;
import com.Denfop.tiles.overtimepanel.TileEntityAdvancedSolarPanel;
import com.Denfop.utils.NBTData;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class Adminsolarpanel extends BlockContainer implements ITileEntityProvider {
	public boolean qgActive;
	private IIcon icon;

	public Adminsolarpanel() {
		super(Material.iron);
		setHardness(3.0F);
		setCreativeTab(IUCore.tabssp);

	}
	public void registerBlockIcons(IIconRegister par1IconRegister) {
	    this.icon = par1IconRegister.registerIcon("supersolarpanel:genstone");
	  }
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityAdminSolarPanel();
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
		super.onBlockPlacedBy(world, x, y, z, player, stack);
		int heading = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		TileEntitySolarPanel te = (TileEntitySolarPanel) world.getTileEntity(x, y, z);

		switch (heading) {
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
	public boolean rotateBlock(World worldObj, int x, int y, int z, ForgeDirection axis) {
		if (axis == ForgeDirection.UNKNOWN) {
			return false;
		}
		TileEntity tileEntity = worldObj.getTileEntity(x, y, z);

		if ((tileEntity instanceof IWrenchable)) {
			IWrenchable te = (IWrenchable) tileEntity;

			int newFacing = ForgeDirection.getOrientation(te.getFacing()).getRotation(axis).ordinal();

			if (te.wrenchCanSetFacing(null, newFacing)) {
				te.setFacing((short) newFacing);
			}
		}

		return false;
	}

	public void breakBlock(World world, int i, int j, int k, Block par5, int par6) {
		TileEntity tileentity = world.getTileEntity(i, j, k);
		if (tileentity != null)

			dropItems((TileEntitySolarPanel) tileentity, world);
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

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int s, float f1, float f2,
			float f3) {
		if (player.isSneaking())
			return false;
		if (world.isRemote)
			return true;
		TileEntity tileentity = world.getTileEntity(i, j, k);
		if (tileentity != null)
			player.openGui(IUCore.instance, 1, world, i, j, k);
		return true;
	}

	private void dropItems(TileEntitySolarPanel tileentity, World world) {
		Random rand = new Random();
		if (!(tileentity instanceof net.minecraft.inventory.IInventory))
			return;
		TileEntitySolarPanel tileEntitySolarPanel = tileentity;
		for (int i = 0; i < tileEntitySolarPanel.getSizeInventory(); i++) {
			ItemStack item = tileEntitySolarPanel.getStackInSlot(i);
			if (item != null && item.stackSize > 0) {
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;
				EntityItem entityItem = new EntityItem(world, (tileentity.xCoord + rx), (tileentity.yCoord + ry),
						(tileentity.zCoord + rz), new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
				if (item.hasTagCompound())
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.20000000298023224D;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld((Entity) entityItem);
				item.stackSize = 0;
			}
		}
	}

}
