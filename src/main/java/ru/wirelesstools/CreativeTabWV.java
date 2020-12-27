package ru.wirelesstools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabWV extends CreativeTabs {

	public CreativeTabWV() {
		super("WirelessVajra");
		
	}

	@Override
	public Item getTabIconItem() {
		
		return MainWV.wirelessVajra;
	}

}
