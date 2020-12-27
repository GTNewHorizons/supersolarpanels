

package com.Denfop.integration.Botania;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityElementumSolarPanel extends TileEntitySolarPanel
{
    public TileEntityElementumSolarPanel() {
        super("blockElementumSolarPanel.name",2, 0, SuperSolarPanels.hGenDay, SuperSolarPanels.hGenNight, SuperSolarPanels.hOutput, SuperSolarPanels.hStorage);
    }
    
    @Override
    public String getInvName() {
        return "Elementum Solar Panel";
    }
}
