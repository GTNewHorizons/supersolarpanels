

package com.Denfop.integration.Botania;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityTerrastelSolarPanel extends TileEntitySolarPanel
{
    public TileEntityTerrastelSolarPanel() {
        super("blockTerrastelSolarPanel.name", 4,0, SuperSolarPanels.qpGenDay, SuperSolarPanels.qpGenNight, SuperSolarPanels.qpOutput, SuperSolarPanels.qpStorage);
    }
    
    @Override
    public String getInvName() {
        return "Terrastel Solar Panel";
    }
}
