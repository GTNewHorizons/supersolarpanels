package com.Denfop.tiles.wiring.Storage;
import com.Denfop.Config;
import com.Denfop.tiles.base.TileEntityElectricBlock;

import net.minecraft.util.StatCollector;
public class TileEntityElectricMFSU extends TileEntityElectricBlock {
  public TileEntityElectricMFSU() {
    super(Config.tier2_MFSU, Config.enegry2, Config.storage2);
  }
  
  public String getInventoryName() {
	  return StatCollector.translateToLocal("ssp.blockMFSU.name");
  }
}
