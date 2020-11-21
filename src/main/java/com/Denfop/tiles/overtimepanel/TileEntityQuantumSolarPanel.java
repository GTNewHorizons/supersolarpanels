// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.overtimepanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityQuantumSolarPanel extends TileEntitySolarPanel
{
    public TileEntityQuantumSolarPanel() {
        super("blockQuantumSolarPanel.name", 0, SuperSolarPanels.qpGenDay, SuperSolarPanels.qpGenNight, SuperSolarPanels.qpOutput, SuperSolarPanels.qpStorage);
    }
    
    @Override
    public String getInvName() {
        return "Quantum Solar Panel";
    }
}
