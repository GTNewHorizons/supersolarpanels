package com.denfop.ssp.tiles.panels.end;

import com.denfop.ssp.tiles.panels.entity.TileEntityEnderPanel;

public class TileEntityAdvancedSolarEnd extends TileEntityEnderPanel {
	public static SolarConfig settings;

	public TileEntityAdvancedSolarEnd() {
		super(TileEntityAdvancedSolarEnd.settings);
	}
}
