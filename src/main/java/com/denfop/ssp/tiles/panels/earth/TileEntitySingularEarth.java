package com.denfop.ssp.tiles.panels.earth;

import com.denfop.ssp.tiles.panels.entity.TileEntityEarthPanel;

public class TileEntitySingularEarth extends TileEntityEarthPanel {
	public static TileEntityEarthPanel.SolarConfig settings;

	public TileEntitySingularEarth() {
		super(TileEntitySingularEarth.settings);
	}
}
