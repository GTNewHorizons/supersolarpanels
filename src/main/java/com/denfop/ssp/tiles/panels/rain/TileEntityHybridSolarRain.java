package com.denfop.ssp.tiles.panels.rain;

import com.denfop.ssp.tiles.panels.entity.TileEntityRainPanel;

public class TileEntityHybridSolarRain extends TileEntityRainPanel {
	public static SolarConfig settings;

	public TileEntityHybridSolarRain() {
		super(TileEntityHybridSolarRain.settings);
	}
}
