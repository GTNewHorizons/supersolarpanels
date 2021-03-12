package com.Denfop.api.module;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.IUCore;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.utils.NBTData;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public interface IModulOutput {
	public static void setData(ItemStack stack, int output) {
		  NBTTagCompound nbt = NBTData.getOrCreateNbtData(stack);
		  
  
  	nbt.setInteger("percentoutput",output);
  	
	}
	
	public static List<Integer> getData(ItemStack stack){
		NBTTagCompound nbt = NBTData.getOrCreateNbtData(stack);
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(nbt.getInteger("percentoutput"));
		
		return list;
		
	}
}
