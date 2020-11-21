// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.rainpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityUltimateRainPanel extends TileEntitySolarPanel
{
    public TileEntityUltimateRainPanel() {
        super("blockUltimateSolarPanel6.name", 7, SuperSolarPanels.uhGenDay, SuperSolarPanels.uhGenNight, SuperSolarPanels.uhOutput, SuperSolarPanels.uhStorage);
    }
    
    @Override
    public String getInvName() {
        return "Ult Solar Panel";
    }
}
