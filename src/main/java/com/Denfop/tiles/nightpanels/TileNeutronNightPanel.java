
package com.Denfop.tiles.nightpanels;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileNeutronNightPanel extends TileEntitySolarPanel
{
    public TileNeutronNightPanel() {
        super("blockNeutronSolarPanel5.name", 5, SuperSolarPanels.neutronpanelGenDay,   SuperSolarPanels.neutronpanelGenNight, SuperSolarPanels.neutronpanelOutput, SuperSolarPanels.neutronpanelStorage);
    }
}