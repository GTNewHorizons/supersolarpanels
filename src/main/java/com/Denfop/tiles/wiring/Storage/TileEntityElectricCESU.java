package com.Denfop.tiles.wiring.Storage;

import com.Denfop.tiles.base.TileEntityElectricBlock;

import net.minecraft.util.StatCollector;

public class TileEntityElectricCESU extends TileEntityElectricBlock {
  public TileEntityElectricCESU() {
    super(2, 128, 300000);
  }
  
  public String getInventoryName() {
	  return StatCollector.translateToLocal("ssp.blockCESU.name");
  }
}
