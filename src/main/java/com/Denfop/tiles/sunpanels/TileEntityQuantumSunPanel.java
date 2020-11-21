// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.sunpanels;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityQuantumSunPanel extends TileEntitySolarPanel
{
    public TileEntityQuantumSunPanel() {
        super("blockQuantumSolarPanel7.name", 6, SuperSolarPanels.qpGenDay, SuperSolarPanels.qpGenNight, SuperSolarPanels.qpOutput, SuperSolarPanels.qpStorage);
    }
    
    @Override
    public String getInvName() {
        return "Quantum Solar Panel";
    }
}
