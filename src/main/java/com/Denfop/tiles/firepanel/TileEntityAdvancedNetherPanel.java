// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.firepanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityAdvancedNetherPanel extends TileEntitySolarPanel
{
    public TileEntityAdvancedNetherPanel() {
        super("blockAdvancedSolarPanel4.name", 3, SuperSolarPanels.advGenDay, SuperSolarPanels.advGenNight, SuperSolarPanels.advOutput, SuperSolarPanels.advStorage);
    }
    
    @Override
    public String getInvName() {
        return "Adv Solar Panel";
    }
}
