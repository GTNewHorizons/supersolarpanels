package com.denfop.ssp.tiles.panels.sun;

import com.denfop.ssp.tiles.panels.entity.TileEntitySolarPanelSun;

public class TileEntityAdminSun extends TileEntitySolarPanelSun {
	public static TileEntitySolarPanelSun.SolarConfig settings;

	public TileEntityAdminSun() {
		super(TileEntityAdminSun.settings);
	}


}
