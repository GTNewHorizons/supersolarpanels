package com.Denfop.tiles.wiring.Storage;

import com.Denfop.tiles.base.TileEntityElectricBlock;

import net.minecraft.util.StatCollector;

public class TileEntityElectricBatBox extends TileEntityElectricBlock {
  public TileEntityElectricBatBox() {
    super(1, 32, 40000);
  }
  
  public String getInventoryName() {
	  return StatCollector.translateToLocal("ssp.blockBatBox.name");
  }
}
