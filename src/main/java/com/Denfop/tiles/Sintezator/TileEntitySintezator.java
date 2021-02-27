package com.Denfop.tiles.Sintezator;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileSintezator;

import net.minecraft.util.AxisAlignedBB;


public class TileEntitySintezator extends TileSintezator 
{
    public TileEntitySintezator() {
        super("blockSintezator.name",11);
    }
    
    @Override
    public String getInvName() {
        return "Sintezator";
    }
    
}
