package ru.wirelesstools;

import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class BlockVajraCharger extends Block implements ITileEntityProvider {
	
	public WirelessVajra wv;
	public ItemStack wvstack;
	

	protected BlockVajraCharger(String unlocalizedName, Material mat) {
		super(mat);
		this.setBlockName(unlocalizedName);
		setBlockTextureName("wirelessvajra:blockVajraCharger");
		 setCreativeTab(SuperSolarPanels.tabssp);
		setHardness(2.0F);
		setResistance(5.0F);
		
		
		
		
		
	}
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		
	return new TileVajraCharger();
	
	
}
	
	
	
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	 {
		 
		 
		 if(!world.isRemote) {
			 
			 TileVajraCharger tileentity2 = (TileVajraCharger) world.getTileEntity(x, y, z);
		
			 player.addChatMessage(new ChatComponentTranslation(String.format("tile.vajracharger.currentenergy")));
			 player.addChatMessage(new ChatComponentTranslation(String.format("%d", tileentity2.getStored())));
		 }
		 
		 
		 
		return true;
		 
		 
		 
	 }
	
}
	
	
	
