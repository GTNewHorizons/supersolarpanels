package com.supsolpans;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabSSP extends CreativeTabs {

    public CreativeTabSSP() {
        super("Super Solar Panels");
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(MainSSP.BlockSpectralSP);
    }

}
