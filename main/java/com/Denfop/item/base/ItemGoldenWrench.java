package com.Denfop.item.base;

import com.Denfop.SuperSolarPanels;

import net.minecraft.item.Item;

public class ItemGoldenWrench extends Item {
	
	public ItemGoldenWrench() {
		 setCreativeTab(SuperSolarPanels.tabssp);
		this.setUnlocalizedName("goldenWrench");
		this.setTextureName("wirelessvajra:itemGoldenWrench");
		this.setMaxStackSize(64);
		
		
	}

}
