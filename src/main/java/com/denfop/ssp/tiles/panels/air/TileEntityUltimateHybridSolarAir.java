package com.denfop.ssp.tiles.panels.air;

import com.denfop.ssp.tiles.panels.entity.TileEntityAirPanel;

public class TileEntityUltimateHybridSolarAir extends TileEntityAirPanel {
	public static SolarConfig settings;

	public TileEntityUltimateHybridSolarAir() {
		super(TileEntityUltimateHybridSolarAir.settings);
	}
}
