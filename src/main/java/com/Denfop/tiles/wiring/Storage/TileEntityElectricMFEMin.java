package com.Denfop.tiles.wiring.Storage;

import com.Denfop.tiles.base.TileEntityElectricBlock;

import net.minecraft.util.StatCollector;

public class TileEntityElectricMFEMin extends TileEntityElectricBlock {
  public TileEntityElectricMFEMin() {
    super(3, 512, 4000000);
  }
  
  public String getInventoryName() {
	  return StatCollector.translateToLocal("ssp.blockMFE1.name");
  }
}
