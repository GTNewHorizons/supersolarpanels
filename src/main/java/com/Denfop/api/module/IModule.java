package com.Denfop.api.module;

import com.Denfop.Config;
import com.Denfop.SuperSolarPanels;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IModule {
	public static   void setpercent(ItemStack stack, int i) {
		NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		nbt.setInteger("ioutput", i);
	}
	public static  int getpercent(ItemStack stack) {
		NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
		return nbt.getInteger("ioutput");
	}
	
	
}
