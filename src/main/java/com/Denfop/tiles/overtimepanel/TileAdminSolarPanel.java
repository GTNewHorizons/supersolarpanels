// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.overtimepanel;


import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileAdminSolarPanel extends TileEntitySolarPanel
{
    public TileAdminSolarPanel() {
        super("blockAdminSolarPanel.name", 0, SuperSolarPanels.adminpanelGenDay, SuperSolarPanels.adminpanelGenNight, SuperSolarPanels.AdminpanelOutput, SuperSolarPanels.AdminpanelStorage);
    }
}
