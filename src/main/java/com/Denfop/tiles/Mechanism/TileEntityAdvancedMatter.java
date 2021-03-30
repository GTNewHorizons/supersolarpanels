package com.Denfop.tiles.Mechanism;

import com.Denfop.tiles.base.TileEntityMultiMatter;

import net.minecraft.util.StatCollector;

public class TileEntityAdvancedMatter extends TileEntityMultiMatter {

	public TileEntityAdvancedMatter() {
		super(900000F, 8);
	}

	public String getInventoryName() {
		return StatCollector.translateToLocal("ssp.blockMatter1.name");
	}

}
