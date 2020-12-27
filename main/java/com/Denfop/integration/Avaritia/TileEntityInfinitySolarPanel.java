
package com.Denfop.integration.Avaritia;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityInfinitySolarPanel extends TileEntitySolarPanel
{
    public TileEntityInfinitySolarPanel() {
        super("blockInfinitySolarPanel.name",10, 0, SuperSolarPanels.neutronpanelGenDay * 10, SuperSolarPanels.neutronpanelGenNight * 10, SuperSolarPanels.neutronpanelOutput * 10, SuperSolarPanels.neutronpanelStorage * 10);
    }
}