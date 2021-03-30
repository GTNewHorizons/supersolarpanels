package com.Denfop.tiles.wiring.Chargepad;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class TileEntityChargepadCESU extends com.Denfop.tiles.base.TileEntityChargepadBlock {
	public TileEntityChargepadCESU() {
		super(2, 128, 300000);
	}

	public String getInventoryName() {
		return StatCollector.translateToLocal("ssp.blockChargepadCESU.name");
	}

}
