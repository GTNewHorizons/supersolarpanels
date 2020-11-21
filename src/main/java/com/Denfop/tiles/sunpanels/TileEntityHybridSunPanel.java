// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.sunpanels;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityHybridSunPanel extends TileEntitySolarPanel
{
    public TileEntityHybridSunPanel() {
        super("blockHybridSolarPanel7.name", 6, SuperSolarPanels.hGenDay, SuperSolarPanels.hGenNight, SuperSolarPanels.hOutput, SuperSolarPanels.hStorage);
    }
    
    @Override
    public String getInvName() {
        return "Hyb Solar Panel";
    }
}
