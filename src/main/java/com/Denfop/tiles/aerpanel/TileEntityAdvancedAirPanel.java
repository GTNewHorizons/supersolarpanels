// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.aerpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityAdvancedAirPanel extends TileEntitySolarPanel
{
    public TileEntityAdvancedAirPanel() {
        super("blockAdvancedSolarPanel1.name", 1, SuperSolarPanels.advGenDay, SuperSolarPanels.advGenNight, SuperSolarPanels.advOutput, SuperSolarPanels.advStorage);
    }
    
    @Override
    public String getInvName() {
        return "Adv Solar Panel";
    }
}
