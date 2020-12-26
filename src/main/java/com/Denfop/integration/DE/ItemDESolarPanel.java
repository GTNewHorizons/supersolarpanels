
package com.Denfop.integration.DE;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import net.minecraft.block.Block;
import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.item.ItemBlock;

public class ItemDESolarPanel extends ItemBlock
{
    private List<String> itemNames;
    
    public ItemDESolarPanel(final Block b) {
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
        this.itemNames.add("blockDraconSolarPanel");
        this.itemNames.add("blockAwakenedSolarPanel");
        this.itemNames.add("blockChaosSolarPanel");
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
           
            default: {
                return EnumRarity.uncommon;
            }
        }
    }
}
