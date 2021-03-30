package com.Denfop.tiles.wiring.Chargepad;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class TileEntityChargepadMFSU extends com.Denfop.tiles.base.TileEntityChargepadBlock {
  public TileEntityChargepadMFSU() {
    super(4, 2048, 40000000);
  }
  
  public String getInventoryName() {
	  return StatCollector.translateToLocal("ssp.blockChargepadMFSU.name");
  }
  
}
