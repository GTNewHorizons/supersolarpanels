package ru.wirelesstools;

import com.Denfop.SuperSolarPanels;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.core.item.armor.ItemArmorElectric;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class BlockArmorCharger extends Block implements ITileEntityProvider {

	protected BlockArmorCharger(String unlocalizedName, Material mat) {
		super(mat);
		this.setBlockName(unlocalizedName);
		 setCreativeTab(SuperSolarPanels.tabssp);
		setBlockTextureName("wirelessvajra:blockArmorCharger");
		setHardness(2.0F);
		setResistance(5.0F);
		
		
	}

	
	public TileEntity createNewTileEntity(World world, int meta) {
		
		return null;
	}
	
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	 {
		 if(!world.isRemote) {
		 for(ItemStack armorcharged : player.inventory.armorInventory) {
			 if(armorcharged != null) {
				 if(armorcharged.getItem() instanceof IElectricItem) {
					 ElectricItem.manager.charge(armorcharged, Double.POSITIVE_INFINITY, 2147483647, true, false);
					 player.inventoryContainer.detectAndSendChanges();
					 
				 }
				 
			 }
			 
		 }
		 for(ItemStack armorcharged1 : player.inventory.armorInventory) {
			 ItemStack[] istack = player.inventory.armorInventory;
			 if(armorcharged1 == istack[0] && armorcharged1 != null) {
				 
				 player.addChatMessage(new ChatComponentTranslation(String.format("boots.successfully.charged", new Object[0]), new Object[0]));
			 }
			 else if(armorcharged1 == istack[1] && armorcharged1 != null) {
				 
				 player.addChatMessage(new ChatComponentTranslation(String.format("leggings.successfully.charged", new Object[0]), new Object[0]));
				 
			 }
			 else if(armorcharged1 == istack[2] && armorcharged1 != null) {
				 
				 player.addChatMessage(new ChatComponentTranslation(String.format("armorchest.successfully.charged", new Object[0]), new Object[0]));
				 
			 }
			 else if(armorcharged1 == istack[3] && armorcharged1 != null) {
				 
				 player.addChatMessage(new ChatComponentTranslation(String.format("helmet.successfully.charged", new Object[0]), new Object[0]));
				 
			 }
			 
		 }
		 
		 
		 }
		 
		return true;
		 
	 }
	
	
	
}
