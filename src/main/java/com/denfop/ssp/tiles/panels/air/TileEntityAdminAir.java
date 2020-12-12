package com.denfop.ssp.tiles.panels.air;

import com.denfop.ssp.tiles.panels.entity.TileEntityAirPanel;

public class TileEntityAdminAir extends TileEntityAirPanel {
	public static SolarConfig settings;

	public TileEntityAdminAir() {
		super(TileEntityAdminAir.settings);
	}


}
