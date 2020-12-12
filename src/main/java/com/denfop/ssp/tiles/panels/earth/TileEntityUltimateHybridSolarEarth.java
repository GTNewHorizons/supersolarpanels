package com.denfop.ssp.tiles.panels.earth;

import com.denfop.ssp.tiles.panels.entity.TileEntityEarthPanel;

public class TileEntityUltimateHybridSolarEarth extends TileEntityEarthPanel {
	public static SolarConfig settings;

	public TileEntityUltimateHybridSolarEarth() {
		super(TileEntityUltimateHybridSolarEarth.settings);
	}
}
