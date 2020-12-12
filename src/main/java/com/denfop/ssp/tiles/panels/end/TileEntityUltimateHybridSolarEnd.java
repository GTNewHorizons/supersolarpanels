package com.denfop.ssp.tiles.panels.end;

import com.denfop.ssp.tiles.panels.entity.TileEntityEnderPanel;

public class TileEntityUltimateHybridSolarEnd extends TileEntityEnderPanel {
	public static SolarConfig settings;

	public TileEntityUltimateHybridSolarEnd() {
		super(TileEntityUltimateHybridSolarEnd.settings);
	}
}
