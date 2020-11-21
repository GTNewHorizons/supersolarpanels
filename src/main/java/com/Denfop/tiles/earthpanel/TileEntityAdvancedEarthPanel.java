// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.earthpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityAdvancedEarthPanel extends TileEntitySolarPanel
{
    public TileEntityAdvancedEarthPanel() {
        super("blockAdvancedSolarPanel2.name", 2, SuperSolarPanels.advGenDay, SuperSolarPanels.advGenNight, SuperSolarPanels.advOutput, SuperSolarPanels.advStorage);
    }
    
    @Override
    public String getInvName() {
        return "Adv Solar Panel";
    }
}
