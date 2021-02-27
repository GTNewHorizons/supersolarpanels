package com.Denfop.api.module;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IModulPanel {
	public static void setData(ItemStack stack,int meta, TileEntitySolarPanel tile) {
		  NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		  
    	nbt.setInteger("genday", tile.genDay);
    	nbt.setInteger("gennight", tile.genNight);
    	nbt.setInteger("basestorage", tile.maxStorage);
    	nbt.setInteger("output", tile.production);
    	nbt.setInteger("tier", tile.tier);
	}
	public static List<Integer> getData(ItemStack stack){
		NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		List<Integer> list = new ArrayList<Integer>();
		list.add(nbt.getInteger("genday"));
		list.add(nbt.getInteger("gennight"));
		list.add(nbt.getInteger("basestorage"));
		list.add(nbt.getInteger("output"));
		list.add(nbt.getInteger("tier"));
		
		return list;
		
	}
}
