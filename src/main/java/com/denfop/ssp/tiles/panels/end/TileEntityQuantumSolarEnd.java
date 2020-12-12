package com.denfop.ssp.tiles.panels.end;

import com.denfop.ssp.tiles.panels.entity.TileEntityEnderPanel;

public class TileEntityQuantumSolarEnd extends TileEntityEnderPanel {
	public static SolarConfig settings;

	public TileEntityQuantumSolarEnd() {
		super(TileEntityQuantumSolarEnd.settings);
	}
}
