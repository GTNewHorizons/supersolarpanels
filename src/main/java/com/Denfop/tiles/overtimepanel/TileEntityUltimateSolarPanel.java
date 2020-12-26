
package com.Denfop.tiles.overtimepanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityUltimateSolarPanel extends TileEntitySolarPanel
{
    public TileEntityUltimateSolarPanel() {
        super("blockUltimateSolarPanel.name", 3,0, SuperSolarPanels.uhGenDay, SuperSolarPanels.uhGenNight, SuperSolarPanels.uhOutput, SuperSolarPanels.uhStorage);
    }
    
    @Override
    public String getInvName() {
        return "Ult Solar Panel";
    }
}
