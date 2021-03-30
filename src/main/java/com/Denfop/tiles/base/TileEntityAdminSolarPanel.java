package com.Denfop.tiles.base;

import com.Denfop.IUCore;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.StatCollector;


public class TileEntityAdminSolarPanel extends TileEntitySolarPanel 
{
    public TileEntityAdminSolarPanel() {
        super("blockAdministatorSolarPanel.name",11, 0, 999999999,999999999, 999999999,999999999);
    }
    
    @Override
    public String getInvName() {
        return StatCollector.translateToLocal("blockAdministatorSolarPanel.name");
    }
    
    
}
