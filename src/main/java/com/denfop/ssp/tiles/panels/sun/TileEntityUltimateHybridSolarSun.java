package com.denfop.ssp.tiles.panels.sun;

import com.denfop.ssp.tiles.panels.entity.TileEntitySolarPanelSun;

public class TileEntityUltimateHybridSolarSun extends TileEntitySolarPanelSun {
	public static SolarConfig settings;

	public TileEntityUltimateHybridSolarSun() {
		super(TileEntityUltimateHybridSolarSun.settings);
	}
}
