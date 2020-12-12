package com.denfop.ssp.tiles.panels.air;

import com.denfop.ssp.tiles.panels.entity.TileEntityAirPanel;

public class TileEntityQuantumSolarAir extends TileEntityAirPanel {
	public static SolarConfig settings;

	public TileEntityQuantumSolarAir() {
		super(TileEntityQuantumSolarAir.settings);
	}
}
