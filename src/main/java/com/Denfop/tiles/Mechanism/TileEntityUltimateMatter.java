package com.Denfop.tiles.Mechanism;

import com.Denfop.tiles.base.TileEntityMultiMatter;

import net.minecraft.util.StatCollector;

public class TileEntityUltimateMatter extends TileEntityMultiMatter {

	public TileEntityUltimateMatter() {
		super(700000F, 8);
	}

	@Override
	public String getInventoryName() {
		return StatCollector.translateToLocal("ssp.blockMatter3.name");
	}

}
