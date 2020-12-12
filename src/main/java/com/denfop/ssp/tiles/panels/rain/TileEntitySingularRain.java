package com.denfop.ssp.tiles.panels.rain;

import com.denfop.ssp.tiles.panels.entity.TileEntityRainPanel;

public class TileEntitySingularRain extends TileEntityRainPanel {
	public static TileEntityRainPanel.SolarConfig settings;

	public TileEntitySingularRain() {
		super(TileEntitySingularRain.settings);
	}
}
