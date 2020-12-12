package com.denfop.ssp.tiles.panels.earth;

import com.denfop.ssp.tiles.panels.entity.TileEntityEarthPanel;

public class TileEntityHybridSolarEarth extends TileEntityEarthPanel {
	public static SolarConfig settings;

	public TileEntityHybridSolarEarth() {
		super(TileEntityHybridSolarEarth.settings);
	}
}
