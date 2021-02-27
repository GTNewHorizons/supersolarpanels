package com.Denfop.item.Modules;

import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class module3 extends Item {
	public module3() {
		this.setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp1);
	}

	public int getItemStackLimit() {
		return this.maxStackSize;
	}
	 public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
		  info.add(StatCollector.translateToLocal("ssp.module3") + " " +"+20% "  + StatCollector.translateToLocal("ssp.module") );
		  info.add(StatCollector.translateToLocal("ssp.modules") );
		 
	 }
}
