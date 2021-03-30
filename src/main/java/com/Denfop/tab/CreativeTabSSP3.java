
package com.Denfop.tab;

import net.minecraft.item.Item;

import com.Denfop.IUItem;
import com.Denfop.IUCore;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabSSP3 extends CreativeTabs {
	public CreativeTabSSP3() {
		super("sspitems");
	}

	public Item getTabIconItem() {
		return IUItem.QuantumItems5;
	}
}
