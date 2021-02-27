package com.Denfop.api;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.block.BlockContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IPanel {
	
	public  void getSubItems(final Item item, final CreativeTabs tabs, final List itemList);
	
	public static <T> void setData(ItemStack stack,int meta, TileEntitySolarPanel tile) {
		  NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		  
      	nbt.setInteger("genday", tile.genDay);
      	nbt.setInteger("gennight", tile.genNight);
      	nbt.setInteger("storage", tile.maxStorage);
      	nbt.setInteger("output", tile.production);
      	nbt.setInteger("tier", tile.tier);
	}
	public static List<Integer> getData(ItemStack stack){
		return null;
		
	}
}
