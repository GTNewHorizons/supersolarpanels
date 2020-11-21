// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.sunpanels;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityAdvancedSunPanel extends TileEntitySolarPanel
{
    public TileEntityAdvancedSunPanel() {
        super("blockAdvancedSolarPanel7.name", 6, SuperSolarPanels.advGenDay, SuperSolarPanels.advGenNight, SuperSolarPanels.advOutput, SuperSolarPanels.advStorage);
    }
    
    @Override
    public String getInvName() {
        return "Adv Solar Panel";
    }
}
