package com.denfop.ssp;


import com.denfop.ssp.tiles.SSPBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class SSPSourceTab extends CreativeTabs {
	public SSPSourceTab(String label) {
		super(label);
	}

	@Nonnull
	@Override
	public ItemStack createIcon() {
		return SuperSolarPanels.machines.getItemStack(SSPBlock.admin_solar_panel);
	}

}
