package com.Denfop.api.module;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public interface IModuleType {
	public static void setData(ItemStack stack, String type) {
		  NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		  
  
  	nbt.setString("type",type);
  	
	}
	
	public static List<String> getData(ItemStack stack){
		NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		List<String> list = new ArrayList<String>();
		
		list.add(nbt.getString("type"));
		
		return list;
		
	}
}
