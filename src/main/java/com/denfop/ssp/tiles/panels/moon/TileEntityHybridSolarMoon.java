package com.denfop.ssp.tiles.panels.moon;

import com.denfop.ssp.tiles.panels.entity.TileEntityMoonPanel;

public class TileEntityHybridSolarMoon extends TileEntityMoonPanel {
	public static SolarConfig settings;

	public TileEntityHybridSolarMoon() {
		super(TileEntityHybridSolarMoon.settings);
	}
}
