package com.denfop.ssp.tiles.panels.sun;

import com.denfop.ssp.tiles.panels.entity.TileEntitySolarPanelSun;

public class TileEntitySpectralSun extends TileEntitySolarPanelSun {
	public static TileEntitySolarPanelSun.SolarConfig settings;

	public TileEntitySpectralSun() {
		super(TileEntitySpectralSun.settings);
	}
}
