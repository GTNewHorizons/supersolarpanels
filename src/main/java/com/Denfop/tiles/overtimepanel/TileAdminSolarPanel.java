
package com.Denfop.tiles.overtimepanel;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.util.AxisAlignedBB;


public class TileAdminSolarPanel extends TileEntitySolarPanel
{
    public TileAdminSolarPanel() {
        super("blockAdminSolarPanel.name",8, 0, SuperSolarPanels.adminpanelGenDay, SuperSolarPanels.adminpanelGenNight, SuperSolarPanels.AdminpanelOutput, SuperSolarPanels.AdminpanelStorage);
    }
    
}
