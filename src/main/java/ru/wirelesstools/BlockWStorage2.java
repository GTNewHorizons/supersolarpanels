package ru.wirelesstools;

import com.Denfop.SuperSolarPanels;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class BlockWStorage2 extends Block implements ITileEntityProvider {

	protected BlockWStorage2(String name, Material mat) {
		super(mat);
		this.setBlockName(name);
		 setCreativeTab(SuperSolarPanels.tabssp);
		setBlockTextureName("wirelessvajra:wirelessstorage2");
		setHardness(3.0F);
	}
	
	
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
	
		return new TileWirelessStorageTier2();
	}

	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	 {
		if(!world.isRemote){
			TileWirelessStorageTier2 tile = (TileWirelessStorageTier2) world.getTileEntity(x, y, z);
		
			
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
