package com.Denfop.integration.DE;

import com.Denfop.Config;
import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.SuperSolarPanels;

public class TileEntityChaosSolarPanel extends TileEntitySolarPanel
{
    public TileEntityChaosSolarPanel() {
        super("blockChaosSolarPanel.name",Config.chaostier, 0, Config.chaosgenday, Config.chaosgennight, Config.chaosoutput, Config.chaosstorage);
    }
}
