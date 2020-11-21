// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.nightpanels;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityQuantumNightPanel extends TileEntitySolarPanel
{
    public TileEntityQuantumNightPanel() {
        super("blockQuantumSolarPanel5.name", 5, SuperSolarPanels.qpGenDay,SuperSolarPanels.qpGenNight, SuperSolarPanels.qpOutput, SuperSolarPanels.qpStorage);
    }
    
    @Override
    public String getInvName() {
        return "Quantum Solar Panel";
    }
}
