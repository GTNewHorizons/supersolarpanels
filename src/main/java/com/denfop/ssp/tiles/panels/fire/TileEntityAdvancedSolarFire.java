package com.denfop.ssp.tiles.panels.fire;

import com.denfop.ssp.tiles.panels.entity.TileEntityNetherPanel;

public class TileEntityAdvancedSolarFire extends TileEntityNetherPanel {
	public static SolarConfig settings;

	public TileEntityAdvancedSolarFire() {
		super(TileEntityAdvancedSolarFire.settings);
	}
}
