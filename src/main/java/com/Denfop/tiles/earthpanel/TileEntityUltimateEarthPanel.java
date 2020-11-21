// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.earthpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityUltimateEarthPanel extends TileEntitySolarPanel
{
    public TileEntityUltimateEarthPanel() {
        super("blockUltimateSolarPanel2.name", 2, SuperSolarPanels.uhGenDay, SuperSolarPanels.uhGenNight, SuperSolarPanels.uhOutput, SuperSolarPanels.uhStorage);
    }
    
    @Override
    public String getInvName() {
        return "Ult Solar Panel";
    }
}
