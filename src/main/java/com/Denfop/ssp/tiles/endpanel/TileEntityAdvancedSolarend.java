package com.Denfop.ssp.tiles.endpanel;

import com.Denfop.ssp.tiles.TileEntityEnderPanel;
import com.Denfop.ssp.tiles.TileEntityMoonPanel;
import com.Denfop.ssp.tiles.TileEntitySolarPanel;
import com.Denfop.ssp.tiles.TileEntitySolarPanelsun;

public class TileEntityAdvancedSolarend extends TileEntityEnderPanel
{
    public static SolarConfig settings;
    
    public TileEntityAdvancedSolarend() {
        super(TileEntityAdvancedSolarend.settings);
    }
}