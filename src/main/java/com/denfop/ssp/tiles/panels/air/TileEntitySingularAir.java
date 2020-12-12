package com.denfop.ssp.tiles.panels.air;

import com.denfop.ssp.tiles.panels.entity.TileEntityAirPanel;

public class TileEntitySingularAir extends TileEntityAirPanel {
	public static TileEntityAirPanel.SolarConfig settings;

	public TileEntitySingularAir() {
		super(TileEntitySingularAir.settings);
	}
}
