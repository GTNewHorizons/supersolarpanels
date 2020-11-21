// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.item.base.moonpanel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import net.minecraft.block.Block;
import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.item.ItemBlock;

public class ItemAdvSolarPanelmoon extends ItemBlock
{
    private List<String> itemNames;
    
    public ItemAdvSolarPanelmoon(final Block b) {
        super(b);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.itemNames = new ArrayList<String>();
        this.addItemsNames();
        this.setCreativeTab(SuperSolarPanels.tabssp);
    }
    
    public int getMetadata(final int i) {
        return i;
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        return this.itemNames.get(itemstack.getItemDamage());
    }
    
    public void addItemsNames() {
        this.itemNames.add("blockAdvancedSolarPanel5");
        this.itemNames.add("blockHybridSolarPanel5");
        this.itemNames.add("blockUltimateSolarPanel5");
        this.itemNames.add("blockQuantumSolarPanel5");
        this.itemNames.add("blockQuantumGenerator");
    }
    
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(final ItemStack itemstack) {
        final int i = itemstack.getItemDamage();
        switch (i) {
            case 0: {
                return EnumRarity.uncommon;
            }
            case 1: {
                return EnumRarity.rare;
            }
            case 2: {
                return EnumRarity.epic;
            }
            case 3: {
                return EnumRarity.epic;
            }
            case 4: {
                return EnumRarity.epic;
            }
            default: {
                return EnumRarity.uncommon;
            }
        }
    }
}
