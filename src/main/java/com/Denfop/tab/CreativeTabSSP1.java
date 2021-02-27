
package com.Denfop.tab;

import net.minecraft.item.Item;

import com.Denfop.SuperSolarPanels;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabSSP1 extends CreativeTabs
{
    public CreativeTabSSP1() {
        super("sspmodules");
    }
    
    public Item getTabIconItem() {
        return SuperSolarPanels.module1;
    }
}
