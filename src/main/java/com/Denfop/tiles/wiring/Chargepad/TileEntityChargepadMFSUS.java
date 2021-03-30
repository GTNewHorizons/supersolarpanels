package com.Denfop.tiles.wiring.Chargepad;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.tiles.base.TileEntityChargepadBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class TileEntityChargepadMFSUS extends TileEntityChargepadBlock {
  public TileEntityChargepadMFSUS() {
	  super(Config.tier2_MFSU, Config.enegry2,Config.storage2);
  }
  
  public String getInventoryName() {
	  return StatCollector.translateToLocal("ssp.blockChargepadMFES.name");
  }
 
}
