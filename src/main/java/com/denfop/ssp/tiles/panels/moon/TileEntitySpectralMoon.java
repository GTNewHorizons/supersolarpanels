package com.denfop.ssp.tiles.panels.moon;

import com.denfop.ssp.tiles.panels.entity.TileEntityMoonPanel;

public class TileEntitySpectralMoon extends TileEntityMoonPanel {
	public static TileEntityMoonPanel.SolarConfig settings;

	public TileEntitySpectralMoon() {
		super(TileEntitySpectralMoon.settings);
	}
}
