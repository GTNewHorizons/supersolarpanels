package com.supsolpans.items;

import net.minecraft.item.Item;

import com.supsolpans.MainSSP;

public class ItemGreenSpectralComponent extends Item {

    public ItemGreenSpectralComponent() {
        this.setCreativeTab(MainSSP.tabssp);
        this.setUnlocalizedName("GreenSpectralComponent");
        this.setMaxStackSize(64);
        this.setTextureName("supersolarpanel:Green_Spectral_Component");

    }

}
