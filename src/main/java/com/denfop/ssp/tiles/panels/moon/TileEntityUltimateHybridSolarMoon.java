package com.denfop.ssp.tiles.panels.moon;

import com.denfop.ssp.tiles.panels.entity.TileEntityMoonPanel;

public class TileEntityUltimateHybridSolarMoon extends TileEntityMoonPanel {
	public static SolarConfig settings;

	public TileEntityUltimateHybridSolarMoon() {
		super(TileEntityUltimateHybridSolarMoon.settings);
	}
}
