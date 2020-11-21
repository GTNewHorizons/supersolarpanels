// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.nightpanels;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityHybridNightPanel extends TileEntitySolarPanel
{
    public TileEntityHybridNightPanel() {
        super("blockHybridSolarPanel5.name", 5, SuperSolarPanels.hGenDay, SuperSolarPanels.hGenNight, SuperSolarPanels.hOutput, SuperSolarPanels.hStorage);
    }
    
    @Override
    public String getInvName() {
        return "Hyb Solar Panel";
    }
}
