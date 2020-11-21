// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.item.base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import net.minecraft.block.Block;
import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.item.ItemBlock;

public class ItemAdvSolarPanel1 extends ItemBlock
{
    private List<String> itemNames;
    
    public ItemAdvSolarPanel1(final Block b) {
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
        this.itemNames.add("blockAdvancedSolarPanel4");
        this.itemNames.add("blockHybridSolarPanel4");
        this.itemNames.add("blockUltimateSolarPanel4");
        this.itemNames.add("blockQuantumSolarPanel4");
        this.itemNames.add("blockQuantumGenerator4");
        this.itemNames.add("blockSpectralSolarPanel4");
        this.itemNames.add("blockSingularSolarPanel4");
        this.itemNames.add("blockPhotonicSolarPanel4");
        this.itemNames.add("blockAdminSolarPanel4");
        this.itemNames.add("blockNeutronSolarPanel4");
        this.itemNames.add("blockProtonSolarPanel4");
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
            case 5: {
                return EnumRarity.epic;
            }
            case 6: {
                return EnumRarity.epic;
            }
            case 7: {
                return EnumRarity.epic;
            }
            case 8: {
                return EnumRarity.epic;
            }
            case 9: {
                return EnumRarity.epic;
            }
            default: {
                return EnumRarity.uncommon;
            }
        }
    }
}
