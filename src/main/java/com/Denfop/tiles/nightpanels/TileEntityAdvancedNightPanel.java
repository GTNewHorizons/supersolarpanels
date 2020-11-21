// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.nightpanels;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityAdvancedNightPanel extends TileEntitySolarPanel
{
    public TileEntityAdvancedNightPanel() {
        super("blockAdvancedSolarPanel5.name", 5, SuperSolarPanels.advGenDay, SuperSolarPanels.advGenNight, SuperSolarPanels.advOutput, SuperSolarPanels.advStorage);
    }
    
    @Override
    public String getInvName() {
        return "Adv Solar Panel";
    }
}
