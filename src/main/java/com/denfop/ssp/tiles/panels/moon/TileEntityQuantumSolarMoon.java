package com.denfop.ssp.tiles.panels.moon;

import com.denfop.ssp.tiles.panels.entity.TileEntityMoonPanel;

public class TileEntityQuantumSolarMoon extends TileEntityMoonPanel {
	public static SolarConfig settings;

	public TileEntityQuantumSolarMoon() {
		super(TileEntityQuantumSolarMoon.settings);
	}
}
