
package com.Denfop.tiles.rainpanel;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileNeutronRainPanel extends TileEntitySolarPanel
{
    public TileNeutronRainPanel() {
        super("blockNeutronSolarPanel6.name", 7, SuperSolarPanels.neutronpanelGenDay, SuperSolarPanels.neutronpanelGenNight, SuperSolarPanels.neutronpanelOutput, SuperSolarPanels.neutronpanelStorage);
    }
}