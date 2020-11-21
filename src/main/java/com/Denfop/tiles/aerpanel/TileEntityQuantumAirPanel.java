// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.aerpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityQuantumAirPanel extends TileEntitySolarPanel
{
    public TileEntityQuantumAirPanel() {
        super("blockQuantumSolarPanel1.name", 1, SuperSolarPanels.qpGenDay, SuperSolarPanels.qpGenNight, SuperSolarPanels.qpOutput, SuperSolarPanels.qpStorage);
    }
    
    @Override
    public String getInvName() {
        return "Quantum Solar Panel";
    }
}
