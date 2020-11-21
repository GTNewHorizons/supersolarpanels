
package com.Denfop.tiles.endpanel;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileNeutronEndPanel extends TileEntitySolarPanel
{
    public TileNeutronEndPanel() {
        super("blockNeutronSolarPanel3.name", 4, SuperSolarPanels.neutronpanelGenDay, SuperSolarPanels.neutronpanelGenNight, SuperSolarPanels.neutronpanelOutput, SuperSolarPanels.neutronpanelStorage);
    }
}