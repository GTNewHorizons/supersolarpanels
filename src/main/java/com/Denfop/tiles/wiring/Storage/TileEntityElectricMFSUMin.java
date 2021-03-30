package com.Denfop.tiles.wiring.Storage;

import com.Denfop.tiles.base.TileEntityElectricBlock;

import net.minecraft.util.StatCollector;

public class TileEntityElectricMFSUMin extends TileEntityElectricBlock {
  public TileEntityElectricMFSUMin() {
    super(4, 2048, 40000000);
  }
  
  public String getInventoryName() {
	  return StatCollector.translateToLocal("ssp.blockMFSU1.name");
  }
}
