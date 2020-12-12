package com.denfop.ssp.tiles.panels.sun;

import com.denfop.ssp.tiles.panels.entity.TileEntitySolarPanelSun;

public class TileEntityAdvancedSolarSun extends TileEntitySolarPanelSun {
	public static SolarConfig settings;

	public TileEntityAdvancedSolarSun() {
		super(TileEntityAdvancedSolarSun.settings);
	}
}
