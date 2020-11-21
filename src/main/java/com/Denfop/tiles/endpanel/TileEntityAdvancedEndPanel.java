// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.endpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityAdvancedEndPanel extends TileEntitySolarPanel
{
    public TileEntityAdvancedEndPanel() {
        super("blockAdvancedSolarPanel3.name", 4, SuperSolarPanels.advGenDay, SuperSolarPanels.advGenNight, SuperSolarPanels.advOutput, SuperSolarPanels.advStorage);
    }
    
    @Override
    public String getInvName() {
        return "Adv Solar Panel";
    }
}
