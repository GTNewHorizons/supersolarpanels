package com.Denfop.item.Modules;

import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class module4 extends Item{
	public module4() {
		this.setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp);
	}

	public int getItemStackLimit() {
		return this.maxStackSize;
	}
	 public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
		  info.add(StatCollector.translateToLocal("ssp.module4") + " " +"+20% "  + StatCollector.translateToLocal("ssp.module") );
		  info.add(StatCollector.translateToLocal("ssp.modules") );
	        
	 }
}
