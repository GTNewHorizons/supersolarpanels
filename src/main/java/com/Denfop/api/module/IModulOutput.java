package com.Denfop.api.module;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public interface IModulOutput {
	public static void setData(ItemStack stack, int output) {
		  NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		  
  
  	nbt.setInteger("percentoutput",output);
  	
	}
	public static void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
		  info.add(StatCollector.translateToLocal("ssp.module4") + " " + IModulOutput.getData(itemStack).get(0)+"% "  + StatCollector.translateToLocal("ssp.module") );
		  info.add(StatCollector.translateToLocal("ssp.modules") );
		 
	 }
	public static List<Integer> getData(ItemStack stack){
		NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(nbt.getInteger("percentoutput"));
		
		return list;
		
	}
}
