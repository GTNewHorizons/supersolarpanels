package com.supsolpans.items;

import com.supsolpans.MainSSP;

import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class ItemSpectralLightSplitter extends Item {
	
		
	public ItemSpectralLightSplitter()
	{
		this.setCreativeTab(MainSSP.tabssp);
		this.setUnlocalizedName("SpectralLightSplitter");
		this.setMaxStackSize(64);
		this.setTextureName("supersolarpanel:spectral_light_splitter");
								
	}

}
