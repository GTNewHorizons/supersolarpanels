// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.nightpanels;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityUltimateNightPanel extends TileEntitySolarPanel
{
    public TileEntityUltimateNightPanel() {
        super("blockUltimateSolarPanel5.name", 5, SuperSolarPanels.uhGenDay, SuperSolarPanels.uhGenNight, SuperSolarPanels.uhOutput, SuperSolarPanels.uhStorage);
    }
    
    @Override
    public String getInvName() {
        return "Ult Solar Panel";
    }
}
