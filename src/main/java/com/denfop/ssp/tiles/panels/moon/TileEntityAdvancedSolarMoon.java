package com.denfop.ssp.tiles.panels.moon;

import com.denfop.ssp.tiles.panels.entity.TileEntityMoonPanel;

public class TileEntityAdvancedSolarMoon extends TileEntityMoonPanel {
	public static SolarConfig settings;

	public TileEntityAdvancedSolarMoon() {
		super(TileEntityAdvancedSolarMoon.settings);
	}
}
