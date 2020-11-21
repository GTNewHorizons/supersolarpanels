// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.rainpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityAdvancedRainPanel extends TileEntitySolarPanel
{
    public TileEntityAdvancedRainPanel() {
        super("blockAdvancedSolarPanel6.name", 7, SuperSolarPanels.advGenDay, SuperSolarPanels.advGenNight, SuperSolarPanels.advOutput, SuperSolarPanels.advStorage);
    }
    
    @Override
    public String getInvName() {
        return "Adv Solar Panel";
    }
}
