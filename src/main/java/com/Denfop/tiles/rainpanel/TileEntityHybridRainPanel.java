// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.rainpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityHybridRainPanel extends TileEntitySolarPanel
{
    public TileEntityHybridRainPanel() {
        super("blockHybridSolarPanel6.name", 7, SuperSolarPanels.hGenDay, SuperSolarPanels.hGenNight, SuperSolarPanels.hOutput, SuperSolarPanels.hStorage);
    }
    
    @Override
    public String getInvName() {
        return "Hyb Solar Panel";
    }
}
