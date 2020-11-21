// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.firepanel;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntitySolarPanel;


public class TileEntityUltimateNetherPanel extends TileEntitySolarPanel
{
    public TileEntityUltimateNetherPanel() {
        super("blockUltimateSolarPanel4.name", 3, SuperSolarPanels.uhGenDay,  SuperSolarPanels.uhGenNight,SuperSolarPanels.uhOutput, SuperSolarPanels.uhStorage);
    }
    
    @Override
    public String getInvName() {
        return "Ult Solar Panel";
    }
}
