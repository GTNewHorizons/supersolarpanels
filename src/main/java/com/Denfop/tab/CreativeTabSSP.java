
package com.Denfop.tab;

import net.minecraft.item.Item;

import com.Denfop.IUItem;
import com.Denfop.IUCore;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabSSP extends CreativeTabs {
	public CreativeTabSSP() {
		super("sspblocks");
	}

	public Item getTabIconItem() {
		return Item.getItemFromBlock(IUItem.blockSSPSolarPanel);
	}
}
