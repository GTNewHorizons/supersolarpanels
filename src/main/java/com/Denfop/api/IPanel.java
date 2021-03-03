package com.Denfop.api;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.utils.NBTData;

import net.minecraft.block.BlockContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IPanel {
	
	public  void getSubItems(final Item item, final CreativeTabs tabs, final List itemList);
	
	public static void setData(ItemStack stack, TileEntitySolarPanel tile) {
		  NBTTagCompound nbt = NBTData.getOrCreateNbtData(stack);
		  
      	nbt.setInteger("genday", tile.genDay);
      	nbt.setInteger("gennight", tile.genNight);
      	nbt.setInteger("basestorage", tile.maxStorage);
      	nbt.setInteger("output", tile.production);
      	nbt.setInteger("tier", tile.tier);
	}
	public static List<Integer> getData(ItemStack stack){
		NBTTagCompound nbt = NBTData.getOrCreateNbtData(stack);
		List<Integer> list = new ArrayList<Integer>();
		list.add(nbt.getInteger("genday"));
		list.add(nbt.getInteger("gennight"));
		list.add(nbt.getInteger("basestorage"));
		list.add(nbt.getInteger("output"));
		list.add(nbt.getInteger("tier"));
		
		return list;
		
	}
}