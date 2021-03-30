package com.Denfop.container;

import ic2.core.ContainerBase;
import ic2.core.ContainerFullInv;
import ic2.core.block.invslot.InvSlot;
import ic2.core.slot.SlotInvSlot;
import java.util.List;

import com.Denfop.tiles.base.TileEntityElectricMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public abstract class ContainerElectricMachine<T extends TileEntityElectricMachine> extends ContainerBase<T> {
	public ContainerElectricMachine(EntityPlayer entityPlayer, T base1, int height, int dischargeX, int dischargeY) {
		super(base1);

	}

	public List<String> getNetworkedFields() {
		List<String> ret = super.getNetworkedFields();
		ret.add("guiChargeLevel");
		ret.add("tier");
		return ret;
	}
}
