// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.endpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityHybridEndPanel extends TileEntitySolarPanel
{
    public TileEntityHybridEndPanel() {
        super("blockHybridSolarPanel3.name", 4, SuperSolarPanels.hGenDay, SuperSolarPanels.hGenNight, SuperSolarPanels.hOutput, SuperSolarPanels.hStorage);
    }
    
    @Override
    public String getInvName() {
        return "Hyb Solar Panel";
    }
}
