// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.earthpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityHybridEarthPanel extends TileEntitySolarPanel
{
    public TileEntityHybridEarthPanel() {
        super("blockHybridSolarPanel2.name", 2, SuperSolarPanels.hGenDay, SuperSolarPanels.hGenNight, SuperSolarPanels.hOutput, SuperSolarPanels.hStorage);
    }
    
    @Override
    public String getInvName() {
        return "Hyb Solar Panel";
    }
}
