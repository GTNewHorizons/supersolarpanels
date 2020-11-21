// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.endpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityQuantumEndPanel extends TileEntitySolarPanel
{
    public TileEntityQuantumEndPanel() {
        super("blockQuantumSolarPanel3.name", 4, SuperSolarPanels.qpGenDay, SuperSolarPanels.qpGenNight, SuperSolarPanels.qpOutput, SuperSolarPanels.qpStorage);
    }
    
    @Override
    public String getInvName() {
        return "Quantum Solar Panel";
    }
}
