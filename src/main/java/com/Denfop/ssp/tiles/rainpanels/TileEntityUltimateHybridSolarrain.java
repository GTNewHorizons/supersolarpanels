package com.Denfop.ssp.tiles.rainpanels;

import com.Denfop.ssp.tiles.TileEntityMoonPanel;
import com.Denfop.ssp.tiles.TileEntityRainPanel;
import com.Denfop.ssp.tiles.TileEntitySolarPanel;
import com.Denfop.ssp.tiles.TileEntitySolarPanelsun;

public class TileEntityUltimateHybridSolarrain extends TileEntityRainPanel
{
    public static SolarConfig settings;
    
    public TileEntityUltimateHybridSolarrain() {
        super(TileEntityUltimateHybridSolarrain.settings);
    }
}
