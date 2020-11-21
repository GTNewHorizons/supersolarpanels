package com.Denfop.tiles.ElectricalBase;

import com.Denfop.SuperSolarPanels;

import ic2.core.block.wiring.TileEntityElectricBlock;

public class TileEntityElectricMFE extends TileEntityElectricBlock {
  public TileEntityElectricMFE() {
    super(SuperSolarPanels.tier1, SuperSolarPanels.enegry1, SuperSolarPanels.storage1);
  }
  
  public String getInventoryName() {
    return "MFES";
  }
}
