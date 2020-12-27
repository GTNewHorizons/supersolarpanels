

package com.Denfop.integration.Botania;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityManasteelSolarPanel extends TileEntitySolarPanel
{
    public TileEntityManasteelSolarPanel() {
        super("blockManasteelSolarPanel.name",1, 0, SuperSolarPanels.advGenDay, SuperSolarPanels.advGenNight, SuperSolarPanels.advOutput, SuperSolarPanels.advStorage);
    }
    
    @Override
    public String getInvName() {
        return "Manasteel Solar Panel";
    }
}
