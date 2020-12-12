package com.denfop.ssp.tiles.panels.air;

import com.denfop.ssp.tiles.panels.entity.TileEntityAirPanel;

public class TileEntityHybridSolarAir extends TileEntityAirPanel {
	public static SolarConfig settings;

	public TileEntityHybridSolarAir() {
		super(TileEntityHybridSolarAir.settings);
	}
}
