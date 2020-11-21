
package com.Denfop.tiles.firepanel;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileNeutronNetherPanel extends TileEntitySolarPanel
{
    public TileNeutronNetherPanel() {
        super("blockNeutronSolarPanel4.name", 3, SuperSolarPanels.neutronpanelGenDay, SuperSolarPanels.neutronpanelGenNight, SuperSolarPanels.neutronpanelOutput, SuperSolarPanels.neutronpanelStorage);
    }
}