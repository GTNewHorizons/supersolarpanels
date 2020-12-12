package com.denfop.ssp.tiles.panels.sun;

import com.denfop.ssp.tiles.panels.entity.TileEntitySolarPanelSun;

public class TileEntityNeutronSun extends TileEntitySolarPanelSun {
	public static TileEntitySolarPanelSun.SolarConfig settings;

	public TileEntityNeutronSun() {
		super(TileEntityNeutronSun.settings);
	}
}
