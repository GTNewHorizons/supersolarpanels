
package com.Denfop.tiles.sunpanels;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileNeutronSunPanel extends TileEntitySolarPanel
{
    public TileNeutronSunPanel() {
        super("blockNeutronSolarPanel7.name",6, SuperSolarPanels.neutronpanelGenDay, SuperSolarPanels.neutronpanelGenNight, SuperSolarPanels.neutronpanelOutput, SuperSolarPanels.neutronpanelStorage);
    }
}