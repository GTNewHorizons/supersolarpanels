package com.Denfop.integration.DE;


import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.SuperSolarPanels;

public class TileEntityChaosSolarPanel extends TileEntitySolarPanel
{
    public TileEntityChaosSolarPanel() {
        super("blockChaosSolarPanel.name",7, 0, SuperSolarPanels.singularpanelGenDay, SuperSolarPanels.singularpanelGenNight, SuperSolarPanels.singularpanelOutput, SuperSolarPanels.singularpanelstorage);
    }
}
