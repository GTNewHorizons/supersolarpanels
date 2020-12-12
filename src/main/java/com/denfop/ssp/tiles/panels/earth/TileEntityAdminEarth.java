package com.denfop.ssp.tiles.panels.earth;

import com.denfop.ssp.tiles.panels.entity.TileEntityEarthPanel;

public class TileEntityAdminEarth extends TileEntityEarthPanel {
	public static SolarConfig settings;

	public TileEntityAdminEarth() {
		super(TileEntityAdminEarth.settings);
	}


}
