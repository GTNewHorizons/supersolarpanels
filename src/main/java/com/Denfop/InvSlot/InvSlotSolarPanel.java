package com.Denfop.InvSlot;

import com.Denfop.item.Modules.*;

import ic2.api.item.ElectricItem;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlot;
import net.minecraft.item.ItemStack;

public class InvSlotSolarPanel extends InvSlot {

	public int stackSizeLimit;

	public InvSlotSolarPanel(TileEntityInventory base1, int oldStartIndex1) {
		super(base1, "input2", oldStartIndex1, InvSlot.Access.IO, 9, InvSlot.InvSide.TOP);
		this.stackSizeLimit = 1;
	}

	public boolean accepts(ItemStack itemStack) {
		return itemStack.getItem() instanceof AdditionModule || itemStack.getItem() instanceof ItemWirelessModule
				|| itemStack.getItem() instanceof ModuleGenerationDay
				|| itemStack.getItem() instanceof ModuleGenerationNight || itemStack.getItem() instanceof ModuleOutput
				|| itemStack.getItem() instanceof ModuleStorage || itemStack.getItem() instanceof ModuleType
				|| itemStack.getItem() instanceof ModuleTypePanel;
	}

	public int getStackSizeLimit() {
		return this.stackSizeLimit;
	}

	public void setStackSizeLimit(int stackSizeLimit) {
		this.stackSizeLimit = stackSizeLimit;
	}

}
