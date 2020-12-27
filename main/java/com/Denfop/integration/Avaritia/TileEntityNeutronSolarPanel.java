

package com.Denfop.integration.Avaritia;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityNeutronSolarPanel extends TileEntitySolarPanel
{
    public TileEntityNeutronSolarPanel() {
        super("blockNeutronSolarPanel.name",8, 0, SuperSolarPanels.adminpanelGenDay, SuperSolarPanels.adminpanelGenNight, SuperSolarPanels.AdminpanelOutput, SuperSolarPanels.AdminpanelStorage);
    }
}
