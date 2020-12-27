
package com.Denfop.tab;

import net.minecraft.item.Item;

import com.Denfop.SuperSolarPanels;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabSSP extends CreativeTabs
{
    public CreativeTabSSP() {
        super("Super Solar Panels");
    }
    
    public Item getTabIconItem() {
        return Item.getItemFromBlock(SuperSolarPanels.blockSSPSolarPanel);
    }
}
