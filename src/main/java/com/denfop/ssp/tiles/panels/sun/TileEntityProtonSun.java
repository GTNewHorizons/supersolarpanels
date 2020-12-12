package com.denfop.ssp.tiles.panels.sun;

import com.denfop.ssp.tiles.panels.entity.TileEntitySolarPanelSun;

public class TileEntityProtonSun extends TileEntitySolarPanelSun {
	public static TileEntitySolarPanelSun.SolarConfig settings;

	public TileEntityProtonSun() {
		super(TileEntityProtonSun.settings);
	}
}
