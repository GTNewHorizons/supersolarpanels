package com.Denfop.item.reactor;

import com.Denfop.SSPItem;
import com.Denfop.IUCore;

import ic2.api.reactor.IReactor;
import ic2.core.Ic2Items;
import net.minecraft.item.ItemStack;

public class ItemRadiationToriyRod extends ItemReactorBase {
	private int time;
	private int heat;
	private float power;

	public ItemRadiationToriyRod(String internalName, int cells, int time, int heat, float power) {
		super(internalName, cells, time);
		this.time = time;
		this.heat = heat;
		this.power = power;
		this.setCreativeTab(IUCore.tabssp3);
	}

	protected int getFinalHeat(IReactor reactor, ItemStack stack, int x, int y, int heat) {
		if (reactor.isFluidCooled()) {
			float breedereffectiveness = reactor.getHeat() / reactor.getMaxHeat();
			if (breedereffectiveness > 0.5D)
				heat *= this.heat;
		}
		return heat;
	}

	protected ItemStack getDepletedStack(IReactor reactor, ItemStack stack) {
		ItemStack ret;
		switch (this.numberOfCells) {
		case 1:
			ret = SSPItem.reactorDepletedtoriySimple;
			return new ItemStack(ret.getItem(), 1);
		case 2:
			ret = SSPItem.reactorDepletedtoriyDual;
			return new ItemStack(ret.getItem(), 1);
		case 4:
			ret = SSPItem.reactorDepletedtoriyQuad;
			return new ItemStack(ret.getItem(), 1);

		}
		throw new RuntimeException("invalid cell count: " + this.numberOfCells);
	}

	public boolean acceptUraniumPulse(IReactor reactor, ItemStack yourStack, ItemStack pulsingStack, int youX, int youY,
			int pulseX, int pulseY, boolean heatrun) {
		if (!heatrun) {
			float breedereffectiveness =   (float)((float)reactor.getHeat() /  (float)reactor.getMaxHeat());
			float ReaktorOutput = 4 * breedereffectiveness + this.power;
			reactor.addOutput(ReaktorOutput);
		}
		return true;
	}
}
