package com.Denfop.tiles.wiring.Chargepad;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.tiles.base.TileEntityChargepadBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class TileEntityChargepadMFES extends TileEntityChargepadBlock {
  public TileEntityChargepadMFES() {
	  super(Config.tier3_MFSU, Config.enegry1, Config.storage1);
  }
  
  public String getInventoryName() {
	  return StatCollector.translateToLocal("ssp.blockChargepadMFE.name");
  }
  
}
