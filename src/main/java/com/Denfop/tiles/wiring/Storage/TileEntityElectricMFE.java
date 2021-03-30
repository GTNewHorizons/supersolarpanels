package com.Denfop.tiles.wiring.Storage;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.tiles.base.TileEntityElectricBlock;

import net.minecraft.util.StatCollector;

public class TileEntityElectricMFE extends TileEntityElectricBlock {
	public TileEntityElectricMFE() {
		super(Config.tier3_MFSU, Config.enegry1, Config.storage1);
	}

	public String getInventoryName() {
		return StatCollector.translateToLocal("ssp.blockMFE.name");
	}
}
