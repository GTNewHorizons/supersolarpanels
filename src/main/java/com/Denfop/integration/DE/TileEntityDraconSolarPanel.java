
package com.Denfop.integration.DE;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityDraconSolarPanel extends TileEntitySolarPanel
{
    public TileEntityDraconSolarPanel() {
        super("blockHDraconSolarPanel.name",2, 0, SuperSolarPanels.hGenDay, SuperSolarPanels.hGenNight, SuperSolarPanels.hOutput, SuperSolarPanels.hStorage);
    }
    
    @Override
    public String getInvName() {
        return "Dracon Solar Panel";
    }
}
