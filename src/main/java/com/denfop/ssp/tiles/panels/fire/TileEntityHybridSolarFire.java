package com.denfop.ssp.tiles.panels.fire;

import com.denfop.ssp.tiles.panels.entity.TileEntityNetherPanel;

public class TileEntityHybridSolarFire extends TileEntityNetherPanel {
	public static SolarConfig settings;

	public TileEntityHybridSolarFire() {
		super(TileEntityHybridSolarFire.settings);
	}
}
