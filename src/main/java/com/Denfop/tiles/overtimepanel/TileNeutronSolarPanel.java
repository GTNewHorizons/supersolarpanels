
package com.Denfop.tiles.overtimepanel;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileNeutronSolarPanel extends TileEntitySolarPanel
{
    public TileNeutronSolarPanel() {
        super("blockNeutronSolarPanel.name", 0, SuperSolarPanels.neutronpanelGenDay, SuperSolarPanels.neutronpanelGenNight, SuperSolarPanels.neutronpanelOutput, SuperSolarPanels.neutronpanelStorage);
    }
}