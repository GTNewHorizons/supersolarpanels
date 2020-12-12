package com.denfop.ssp.tiles.panels.moon;

import com.denfop.ssp.tiles.panels.entity.TileEntityMoonPanel;

public class TileEntitySingularMoon extends TileEntityMoonPanel {
	public static TileEntityMoonPanel.SolarConfig settings;

	public TileEntitySingularMoon() {
		super(TileEntitySingularMoon.settings);
	}
}
