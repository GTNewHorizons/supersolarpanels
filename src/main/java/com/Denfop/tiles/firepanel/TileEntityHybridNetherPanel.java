// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.firepanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityHybridNetherPanel extends TileEntitySolarPanel
{
    public TileEntityHybridNetherPanel() {
        super("blockHybridSolarPanel4.name", 3, SuperSolarPanels.hGenDay, SuperSolarPanels.hGenNight,SuperSolarPanels.hOutput, SuperSolarPanels.hStorage);
    }
    
    @Override
    public String getInvName() {
        return "Hyb Solar Panel";
    }
}
