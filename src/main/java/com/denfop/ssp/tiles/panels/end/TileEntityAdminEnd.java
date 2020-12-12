package com.denfop.ssp.tiles.panels.end;

import com.denfop.ssp.tiles.panels.entity.TileEntityEnderPanel;

public class TileEntityAdminEnd extends TileEntityEnderPanel {
	public static SolarConfig settings;

	public TileEntityAdminEnd() {
		super(TileEntityAdminEnd.settings);
	}


}
