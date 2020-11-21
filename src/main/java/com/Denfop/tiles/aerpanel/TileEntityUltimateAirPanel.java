// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.aerpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityUltimateAirPanel extends TileEntitySolarPanel
{
    public TileEntityUltimateAirPanel() {
        super("blockUltimateSolarPanel1.name", 1, SuperSolarPanels.uhGenDay, SuperSolarPanels.uhGenNight, SuperSolarPanels.uhOutput, SuperSolarPanels.uhStorage);
    }
    
    @Override
    public String getInvName() {
        return "Ult Solar Panel";
    }
}
