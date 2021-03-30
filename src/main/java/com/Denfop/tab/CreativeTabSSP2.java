
package com.Denfop.tab;

import net.minecraft.item.Item;

import com.Denfop.IUItem;
import com.Denfop.IUCore;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabSSP2 extends CreativeTabs {
	public CreativeTabSSP2() {
		super("ssptools");
	}

	public Item getTabIconItem() {
		return IUItem.quantumHelmet;
	}
}
