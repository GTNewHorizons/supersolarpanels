package com.supsolpans.items;

import net.minecraft.item.Item;

import com.supsolpans.MainSSP;

public class ItemBlueSpectralComponent extends Item {

    public ItemBlueSpectralComponent() {

        this.setCreativeTab(MainSSP.tabssp);
        this.setUnlocalizedName("BlueSpectralComponent");
        this.setMaxStackSize(64);
        this.setTextureName("supersolarpanel:Blue_Spectral_Component");
    }

}
