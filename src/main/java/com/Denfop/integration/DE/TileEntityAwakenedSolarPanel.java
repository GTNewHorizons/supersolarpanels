package com.Denfop.integration.DE;
import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.IUCore;


public class TileEntityAwakenedSolarPanel extends TileEntitySolarPanel
{
    public TileEntityAwakenedSolarPanel() {
        super("blockAwakenedSolarPanel.name",Config.awakenedtier,0, Config.awakenedgenday, Config.awakenedgennight, Config.awakenedoutput, Config.awakenedstorage);
    }
}
