// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.aerpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityHybridAirPanel extends TileEntitySolarPanel
{
    public TileEntityHybridAirPanel() {
        super("blockHybridSolarPanel1.name", 1, SuperSolarPanels.hGenDay, SuperSolarPanels.hGenNight, SuperSolarPanels.hOutput, SuperSolarPanels.hStorage);
    }
    
    @Override
    public String getInvName() {
        return "Hyb Solar Panel";
    }
}
