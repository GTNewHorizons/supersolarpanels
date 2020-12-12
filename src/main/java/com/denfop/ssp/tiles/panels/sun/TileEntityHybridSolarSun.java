package com.denfop.ssp.tiles.panels.sun;

import com.denfop.ssp.tiles.panels.entity.TileEntitySolarPanelSun;

public class TileEntityHybridSolarSun extends TileEntitySolarPanelSun {
	public static SolarConfig settings;

	public TileEntityHybridSolarSun() {
		super(TileEntityHybridSolarSun.settings);
	}
}
