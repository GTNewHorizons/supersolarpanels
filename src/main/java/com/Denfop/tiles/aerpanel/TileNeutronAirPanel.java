
package com.Denfop.tiles.aerpanel;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileNeutronAirPanel extends TileEntitySolarPanel
{
    public TileNeutronAirPanel() {
        super("blockNeutronSolarPanel1.name", 1, SuperSolarPanels.neutronpanelGenDay, SuperSolarPanels.neutronpanelGenNight, SuperSolarPanels.neutronpanelOutput, SuperSolarPanels.neutronpanelStorage);
    }
}