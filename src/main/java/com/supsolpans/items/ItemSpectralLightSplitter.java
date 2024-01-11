package com.supsolpans.items;

import net.minecraft.item.Item;

import com.supsolpans.MainSSP;

public class ItemSpectralLightSplitter extends Item {

    public ItemSpectralLightSplitter() {
        this.setCreativeTab(MainSSP.tabssp);
        this.setUnlocalizedName("SpectralLightSplitter");
        this.setMaxStackSize(64);
        this.setTextureName("supersolarpanel:spectral_light_splitter");

    }

}
