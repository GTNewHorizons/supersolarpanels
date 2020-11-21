// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.overtimepanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityAdvancedSolarPanel extends TileEntitySolarPanel
{
    public TileEntityAdvancedSolarPanel() {
        super("blockAdvancedSolarPanel.name", 0, SuperSolarPanels.advGenDay, SuperSolarPanels.advGenNight, SuperSolarPanels.advOutput, SuperSolarPanels.advStorage);
    }
    
    @Override
    public String getInvName() {
        return "Adv Solar Panel";
    }
}
