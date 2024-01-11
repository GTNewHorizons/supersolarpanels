package com.supsolpans.items;

import net.minecraft.item.Item;

import com.supsolpans.MainSSP;

public class ItemRedSpectralComponent extends Item {

    public ItemRedSpectralComponent() {
        this.setCreativeTab(MainSSP.tabssp);
        this.setUnlocalizedName("RedSpectralComponent");
        this.setMaxStackSize(64);
        this.setTextureName("supersolarpanel:Red_Spectral_Component");

    }

}
