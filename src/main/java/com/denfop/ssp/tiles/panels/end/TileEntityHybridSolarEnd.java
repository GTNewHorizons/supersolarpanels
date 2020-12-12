package com.denfop.ssp.tiles.panels.end;

import com.denfop.ssp.tiles.panels.entity.TileEntityEnderPanel;

public class TileEntityHybridSolarEnd extends TileEntityEnderPanel {
	public static SolarConfig settings;

	public TileEntityHybridSolarEnd() {
		super(TileEntityHybridSolarEnd.settings);
	}
}
