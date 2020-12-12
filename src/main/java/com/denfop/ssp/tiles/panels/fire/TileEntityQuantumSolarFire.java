package com.denfop.ssp.tiles.panels.fire;

import com.denfop.ssp.tiles.panels.entity.TileEntityNetherPanel;

public class TileEntityQuantumSolarFire extends TileEntityNetherPanel {
	public static SolarConfig settings;

	public TileEntityQuantumSolarFire() {
		super(TileEntityQuantumSolarFire.settings);
	}
}
