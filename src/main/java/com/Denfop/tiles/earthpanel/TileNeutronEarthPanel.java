
package com.Denfop.tiles.earthpanel;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileNeutronEarthPanel extends TileEntitySolarPanel
{
    public TileNeutronEarthPanel() {
        super("blockNeutronSolarPanel2.name", 2, SuperSolarPanels.neutronpanelGenDay, SuperSolarPanels.neutronpanelGenNight, SuperSolarPanels.neutronpanelOutput, SuperSolarPanels.neutronpanelStorage);
    }
}