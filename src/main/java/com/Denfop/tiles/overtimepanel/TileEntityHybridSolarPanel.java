// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.overtimepanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityHybridSolarPanel extends TileEntitySolarPanel
{
    public TileEntityHybridSolarPanel() {
        super("blockHybridSolarPanel.name", 0, SuperSolarPanels.hGenDay, SuperSolarPanels.hGenNight, SuperSolarPanels.hOutput, SuperSolarPanels.hStorage);
    }
    
    @Override
    public String getInvName() {
        return "Hyb Solar Panel";
    }
}
