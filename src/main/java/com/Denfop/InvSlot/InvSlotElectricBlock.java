package com.Denfop.InvSlot;

import com.Denfop.item.Modules.QuarryModule;
import com.Denfop.tiles.base.TileEntityElectricBlock;

import cofh.api.energy.IEnergyContainerItem;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlot;
import net.minecraft.item.ItemStack;

public class InvSlotElectricBlock extends InvSlot {

	public InvSlotElectricBlock(TileEntityInventory base1, int oldStartIndex1) {
		super(base1, "input2", oldStartIndex1, InvSlot.Access.IO, 1, InvSlot.InvSide.TOP);

	}

	public boolean accepts(ItemStack itemStack) {
		return itemStack.getItem() instanceof IElectricItem || itemStack.getItem() instanceof IEnergyContainerItem;
	}

	public double charge(double amount, ItemStack stack) {
		if (amount < 0.0) {
			throw new IllegalArgumentException("Amount must be > 0.");
		}
		if (amount == 0.0)
			return 0;
		double charged = 0.0;

		final double energyIn = ElectricItem.manager.charge(stack, amount, 2147483647, false, false);
		amount -= energyIn;
		charged += energyIn;

		return charged;
	}

}
