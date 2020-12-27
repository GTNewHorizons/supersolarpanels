package com.Denfop.block.WirellesStorage;

import com.Denfop.SuperSolarPanels;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class BlockWStorage extends Block implements ITileEntityProvider {

	public BlockWStorage(String name, Material mat) {
		super(mat);
		this.setBlockName(name);
		 setCreativeTab(SuperSolarPanels.tabssp);
		setBlockTextureName("wirelessvajra:wirelessstorage1");
		setHardness(3.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
	
		return new TileWirelessStorage1Tier();
	}

	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	 {
		if(!world.isRemote){
			TileWirelessStorage1Tier tile = (TileWirelessStorage1Tier) world.getTileEntity(x, y, z);
		
			player.addChatMessage(new ChatComponentTranslation("tile.wirelessstorage.currentstorage", new Object[0]));
			player.addChatMessage(new ChatComponentTranslation(String.format("%d", tile.getStored())));
			player.addChatMessage(new ChatComponentTranslation("tile.wirelessstorage.isconnected", new Object[0]));
			player.addChatMessage(new ChatComponentTranslation(String.format("%b", tile.isconnected)));
			player.addChatMessage(new ChatComponentTranslation("tile.wirelessstorage.targetset"));
			player.addChatMessage(new ChatComponentTranslation(String.format("%b", tile.targetSet)));
		
		
		}
		
		
		return true;
		
		
	 }
	
	
	
	
}
