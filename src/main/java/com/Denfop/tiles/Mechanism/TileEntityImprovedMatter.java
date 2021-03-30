package com.Denfop.tiles.Mechanism;

import com.Denfop.tiles.base.TileEntityMultiMatter;

import net.minecraft.util.StatCollector;

public class TileEntityImprovedMatter extends TileEntityMultiMatter {

	public TileEntityImprovedMatter() {
		super(800000F, 8);
	}

	@Override
	public String getInventoryName() {
		return StatCollector.translateToLocal("ssp.blockMatter2.name");
	}

}
