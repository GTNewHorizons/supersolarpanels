package com.Denfop.api.module;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public interface IModulGenDay {
	public static void setData(ItemStack stack, int day) {
		  NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		  
  
  	nbt.setInteger("percentday",day);
  	
	}
	
	public static List<Integer> getData(ItemStack stack){
		NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(nbt.getInteger("percentday"));
		
		return list;
		
	}
}
