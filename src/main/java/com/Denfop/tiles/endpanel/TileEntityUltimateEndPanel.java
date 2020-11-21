// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.endpanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityUltimateEndPanel extends TileEntitySolarPanel
{
    public TileEntityUltimateEndPanel() {
        super("blockUltimateSolarPanel3.name", 4, SuperSolarPanels.uhGenDay, SuperSolarPanels.uhGenNight, SuperSolarPanels.uhOutput, SuperSolarPanels.uhStorage);
    }
    
    @Override
    public String getInvName() {
        return "Ult Solar Panel";
    }
}
