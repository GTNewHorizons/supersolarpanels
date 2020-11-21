// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.sunpanels;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityUltimateSunPanel extends TileEntitySolarPanel
{
    public TileEntityUltimateSunPanel() {
        super("blockUltimateSolarPanel7.name", 6, SuperSolarPanels.uhGenDay, SuperSolarPanels.uhGenNight, SuperSolarPanels.uhOutput, SuperSolarPanels.uhStorage);
    }
    
    @Override
    public String getInvName() {
        return "Ult Solar Panel";
    }
}
