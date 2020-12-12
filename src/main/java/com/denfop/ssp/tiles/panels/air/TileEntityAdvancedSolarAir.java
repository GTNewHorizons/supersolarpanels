package com.denfop.ssp.tiles.panels.air;

import com.denfop.ssp.tiles.panels.entity.TileEntityAirPanel;

public class TileEntityAdvancedSolarAir extends TileEntityAirPanel {
	public static SolarConfig settings;

	public TileEntityAdvancedSolarAir() {
		super(TileEntityAdvancedSolarAir.settings);
	}
}
