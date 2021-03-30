package com.Denfop.InvSlot;

import com.Denfop.item.Modules.QuarryModule;

import ic2.api.item.ElectricItem;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlot;
import net.minecraft.item.ItemStack;

public class InvSlotQuantumQuarry extends InvSlot {

	public InvSlotQuantumQuarry(TileEntityInventory base1, int oldStartIndex1) {
		super(base1, "input2", oldStartIndex1, InvSlot.Access.IO, 1, InvSlot.InvSide.TOP);

	}

	public boolean accepts(ItemStack itemStack) {
		return itemStack.getItem() instanceof QuarryModule;
	}
	 protected boolean allowEmptyInput() {
		    return false;
		  }
}
