package com.denfop.ssp.tiles.panels.earth;

import com.denfop.ssp.tiles.panels.entity.TileEntityEarthPanel;

public class TileEntityAdvancedSolarEarth extends TileEntityEarthPanel {
	public static SolarConfig settings;

	public TileEntityAdvancedSolarEarth() {
		super(TileEntityAdvancedSolarEarth.settings);
	}
}
