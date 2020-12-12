package com.denfop.ssp.tiles.panels.earth;

import com.denfop.ssp.tiles.panels.entity.TileEntityEarthPanel;

public class TileEntityQuantumSolarEarth extends TileEntityEarthPanel {
	public static SolarConfig settings;

	public TileEntityQuantumSolarEarth() {
		super(TileEntityQuantumSolarEarth.settings);
	}
}
