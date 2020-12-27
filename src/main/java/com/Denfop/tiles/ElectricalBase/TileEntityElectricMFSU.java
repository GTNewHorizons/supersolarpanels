package com.Denfop.tiles.ElectricalBase;

import com.Denfop.SuperSolarPanels;

import ic2.core.block.wiring.TileEntityElectricBlock;

public class TileEntityElectricMFSU extends TileEntityElectricBlock {
  public TileEntityElectricMFSU() {
    super(SuperSolarPanels.tier2, SuperSolarPanels.enegry2,SuperSolarPanels.storage2);
  }
  
  public String getInventoryName() {
    return "MFSS";
  }
}
