package com.denfop.ssp.tiles.panels.sun;

import com.denfop.ssp.tiles.panels.entity.TileEntitySolarPanelSun;

public class TileEntityQuantumSolarsun extends TileEntitySolarPanelSun {
	public static SolarConfig settings;

	public TileEntityQuantumSolarsun() {
		super(TileEntityQuantumSolarsun.settings);
	}
}
