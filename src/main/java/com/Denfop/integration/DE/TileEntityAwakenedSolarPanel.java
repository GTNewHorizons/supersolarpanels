package com.Denfop.integration.DE;

import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.SuperSolarPanels;


public class TileEntityAwakenedSolarPanel extends TileEntitySolarPanel
{
    public TileEntityAwakenedSolarPanel() {
        super("blockAwakenedSolarPanel.name",5,0, SuperSolarPanels.spectralpanelGenDay, SuperSolarPanels.spectralpanelGenNight, SuperSolarPanels.spectralpanelOutput, SuperSolarPanels.spectralpanelstorage);
    }
}
