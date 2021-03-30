package com.Denfop.tiles.wiring.Chargepad;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class TileEntityChargepadMFE extends com.Denfop.tiles.base.TileEntityChargepadBlock {
	public TileEntityChargepadMFE() {
		super(3, 512, 4000000);
	}

	public String getInventoryName() {
		return StatCollector.translateToLocal("ssp.blockChargepadMFE1.name");
	}

}
