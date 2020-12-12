package com.denfop.ssp.tiles.panels.moon;

import com.denfop.ssp.tiles.panels.entity.TileEntityMoonPanel;

public class TileEntityAdminMoon extends TileEntityMoonPanel {
	public static SolarConfig settings;

	public TileEntityAdminMoon() {
		super(TileEntityAdminMoon.settings);
	}


}
