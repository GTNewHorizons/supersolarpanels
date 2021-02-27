package com.Denfop.tiles.wiring.Storage;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntityElectricBlock;




public class TileEntityElectricMFSU extends TileEntityElectricBlock {
  public TileEntityElectricMFSU() {
    super(SuperSolarPanels.tier2, SuperSolarPanels.enegry2,SuperSolarPanels.storage2);
  }
  
  public String getInventoryName() {
    return "MFSS";
  }
}
