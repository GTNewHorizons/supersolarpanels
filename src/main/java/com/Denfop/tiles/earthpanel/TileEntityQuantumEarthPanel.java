// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.earthpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityQuantumEarthPanel extends TileEntitySolarPanel
{
    public TileEntityQuantumEarthPanel() {
        super("blockQuantumSolarPanel2.name", 2, SuperSolarPanels.qpGenDay, SuperSolarPanels.qpGenNight, SuperSolarPanels.qpOutput, SuperSolarPanels.qpStorage);
    }
    
    @Override
    public String getInvName() {
        return "Quantum Solar Panel";
    }
}
