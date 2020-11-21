// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.rainpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityQuantumRainPanel extends TileEntitySolarPanel
{
    public TileEntityQuantumRainPanel() {
        super("blockQuantumSolarPanel6.name", 7, SuperSolarPanels.qpGenDay, SuperSolarPanels.qpGenNight, SuperSolarPanels.qpOutput, SuperSolarPanels.qpStorage);
    }
    
    @Override
    public String getInvName() {
        return "Quantum Solar Panel";
    }
}
