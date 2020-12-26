package com.Denfop;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileSintezator;

import net.minecraft.util.AxisAlignedBB;


public class TileEntitySintezator extends TileSintezator 
{
    public TileEntitySintezator() {
        super("BlockSitezator.name",11);
    }
    
    @Override
    public String getInvName() {
        return "Sintezator";
    }
    
}
