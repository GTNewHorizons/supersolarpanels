package com.denfop.ssp.tiles.panels.fire;

import com.denfop.ssp.tiles.panels.entity.TileEntityNetherPanel;

public class TileEntityAdminFire extends TileEntityNetherPanel {
	public static SolarConfig settings;

	public TileEntityAdminFire() {
		super(TileEntityAdminFire.settings);
	}


}
