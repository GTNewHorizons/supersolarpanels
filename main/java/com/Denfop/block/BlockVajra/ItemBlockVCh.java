package com.Denfop.block.BlockVajra;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.core.util.StackUtil;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public class ItemBlockVCh extends ItemBlock {

	public ItemBlockVCh(Block bl) {
		super(bl);
		this.setUnlocalizedName("blockWCh");
		
	}
	
	
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List itemList) {
		
		ItemStack itemStack = new ItemStack(this, 1);
		NBTTagCompound nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
		nbttagcompound.setInteger("energy", 0);
		itemList.add(itemStack);
	}
	
	
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
		
		
		NBTTagCompound nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
		
		info.add(StatCollector.translateToLocal(I18n.format("tile.charger.energy", new Object[0])+ ": " + nbttagcompound.getInteger("energy")));
		
			
			
			
		
		
		
		
	}
	
	

}
