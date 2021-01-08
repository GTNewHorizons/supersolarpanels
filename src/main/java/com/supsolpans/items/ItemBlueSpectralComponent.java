package com.supsolpans.items;

import com.supsolpans.MainSSP;

import net.minecraft.item.Item;

public class ItemBlueSpectralComponent extends Item {
	
	public ItemBlueSpectralComponent()
	{
		
		this.setCreativeTab(MainSSP.tabssp);
		this.setUnlocalizedName("BlueSpectralComponent");
		this.setMaxStackSize(64);
		this.setTextureName("supersolarpanel:Blue_Spectral_Component");
	}

}
