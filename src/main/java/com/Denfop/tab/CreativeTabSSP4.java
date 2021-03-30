
package com.Denfop.tab;

import net.minecraft.item.Item;

import com.Denfop.IUItem;
import com.Denfop.IUCore;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabSSP4 extends CreativeTabs {
	public CreativeTabSSP4() {
		super("sspores");
	}

	public Item getTabIconItem() {
		return Item.getItemFromBlock(IUItem.toriyore);
	}
}
