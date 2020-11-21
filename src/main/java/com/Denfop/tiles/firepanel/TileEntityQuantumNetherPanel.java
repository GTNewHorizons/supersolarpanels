// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.firepanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityQuantumNetherPanel extends TileEntitySolarPanel
{
    public TileEntityQuantumNetherPanel() {
        super("blockQuantumSolarPanel4.name", 3, SuperSolarPanels.qpGenDay, SuperSolarPanels.qpGenNight, SuperSolarPanels.qpOutput, SuperSolarPanels.qpStorage);
    }
    
    @Override
    public String getInvName() {
        return "Quantum Solar Panel";
    }
}
