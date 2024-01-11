package com.supsolpans.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.supsolpans.MainSSP;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnderQuantumComponent extends Item {

    private IIcon[] IIconsList = new IIcon[1];

    public ItemEnderQuantumComponent() {

        this.setCreativeTab(MainSSP.tabssp);
        this.setUnlocalizedName("Ender-QuantumComponent");
        this.setMaxStackSize(64);
        this.setTextureName("supersolarpanel:enderquantumcomponent");

    }

    @SideOnly(Side.CLIENT)
    public void registericons(IIconRegister IIconRegister) {
        this.IIconsList[0] = IIconRegister.registerIcon("supersolarpanel:enderquantumcomponent");

    }

}
