package com.denfop.ssp.tiles.panels.sun;

import com.denfop.ssp.tiles.panels.entity.TileEntitySolarPanelSun;

public class TileEntityPhotonicSun extends TileEntitySolarPanelSun {
	public static TileEntitySolarPanelSun.SolarConfig settings;

	public TileEntityPhotonicSun() {
		super(TileEntityPhotonicSun.settings);
	}


}
