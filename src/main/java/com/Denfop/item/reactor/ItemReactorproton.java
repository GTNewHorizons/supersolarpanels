package com.Denfop.item.reactor;

import com.Denfop.IUItem;
import com.Denfop.utils.ModUtils;

import java.util.List;

import com.Denfop.IUCore;

import ic2.api.reactor.IReactor;
import ic2.core.Ic2Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemReactorproton extends ItemReactorBase {
	private int time;
	private int heat;
	private float power;

	public ItemReactorproton(String internalName, int cells, int time, int heat, float power) {
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
				heat *= (this.heat*1.5);
		}
		return heat;
	}

	protected ItemStack getDepletedStack(IReactor reactor, ItemStack stack) {
		ItemStack ret;
		switch (this.numberOfCells) {
		case 1:
			ret = IUItem.reactorDepletedprotonSimple;
			return new ItemStack(ret.getItem(), 1);
		case 2:
			ret = IUItem.reactorDepletedprotonDual;
			return new ItemStack(ret.getItem(), 1);
		case 4:
			ret = IUItem.reactorDepletedprotonQuad;
			return new ItemStack(ret.getItem(), 1);
		case 8:
			ret = IUItem.reactorDepletedprotoneit;
			return new ItemStack(ret.getItem(), 1);
		}
		throw new RuntimeException("invalid cell count: " + this.numberOfCells);
	}
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean b) {
		super.addInformation(stack, player, info, b);
		
		if(stack.getItem() == IUItem.reactorprotonSimple.getItem()) {
			info.add(StatCollector.translateToLocal("reactor.info")+ ModUtils.getString((double) 5 * this.power)+" EU");
			info.add(StatCollector.translateToLocal("reactor.info1")+ModUtils.getString( 5 * this.power+19.8D)+" EU");
		}
		
		if(stack.getItem() == IUItem.reactorprotonDual.getItem()) {
		info.add(StatCollector.translateToLocal("reactor.info")+ ModUtils.getString((double) 20 * this.power)+" EU");
		info.add(StatCollector.translateToLocal("reactor.info1")+ModUtils.getString( 20 * this.power+79.2D)+" EU");
		}
		if(stack.getItem() == IUItem.reactorprotonQuad.getItem()) {
			info.add(StatCollector.translateToLocal("reactor.info")+ ModUtils.getString((double) 60 * this.power)+" EU");
			info.add(StatCollector.translateToLocal("reactor.info1")+ModUtils.getString( 60 * this.power+237.6D)+" EU");
			}
		if(stack.getItem() == IUItem.reactorprotoneit.getItem()) {
			info.add(StatCollector.translateToLocal("reactor.info")+ ModUtils.getString((double) 200 * this.power)+" EU");
			info.add(StatCollector.translateToLocal("reactor.info1")+ModUtils.getString( 200 * this.power+792D)+" EU");
			}
	}
	public boolean acceptUraniumPulse(IReactor reactor, ItemStack yourStack, ItemStack pulsingStack, int youX, int youY,
			int pulseX, int pulseY, boolean heatrun) {
		if (!heatrun) {
			float breedereffectiveness =  (float)((float)reactor.getHeat() /  (float)reactor.getMaxHeat());
			float ReaktorOutput = 4 * breedereffectiveness + this.power;
			reactor.addOutput(ReaktorOutput);
		}
		return true;
	}
}
