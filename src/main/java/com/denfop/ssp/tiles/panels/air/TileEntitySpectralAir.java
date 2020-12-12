package com.denfop.ssp.tiles.panels.air;

import com.denfop.ssp.tiles.panels.entity.TileEntityAirPanel;

public class TileEntitySpectralAir extends TileEntityAirPanel {
	public static TileEntityAirPanel.SolarConfig settings;

	public TileEntitySpectralAir() {
		super(TileEntitySpectralAir.settings);
	}
}
