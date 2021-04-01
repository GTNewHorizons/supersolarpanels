package com.Denfop.container;

import ic2.core.ContainerBase;
import ic2.core.block.invslot.InvSlot;

import ic2.core.slot.SlotInvSlot;
import java.util.List;

import com.Denfop.tiles.base.TileEntityBaseMolecular;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerBaseMolecular<T extends TileEntityBaseMolecular> extends ContainerBase<T> {
	public ContainerBaseMolecular(EntityPlayer entityPlayer, T tileEntity1) {
		this(entityPlayer, tileEntity1, 166, 56, 53, 56, 17, 116, 35, 152, 8);
	}

	public ContainerBaseMolecular(EntityPlayer entityPlayer, T tileEntity1, int height, int dischargeX, int dischargeY,
			int inputX, int inputY, int outputX, int outputY, int upgradeX, int upgradeY) {
		super(tileEntity1);
		if (((TileEntityBaseMolecular) tileEntity1).inputSlot != null)
			addSlotToContainer(
					(Slot) new SlotInvSlot((InvSlot) ((TileEntityBaseMolecular) tileEntity1).inputSlot, 0, 20, 27));
		if (((TileEntityBaseMolecular) tileEntity1).outputSlot != null)
			addSlotToContainer(
					(Slot) new SlotInvSlot((InvSlot) ((TileEntityBaseMolecular) tileEntity1).outputSlot, 0, 20, 68));

		for (int i = 0; i < 3; ++i) {
			for (int k = 0; k < 9; ++k) {
				this.addSlotToContainer(
						new Slot((IInventory) entityPlayer.inventory, k + i * 9 + 9, 18 + k * 21, 98 + i * 21));
			}
		}
		for (int j = 0; j < 9; ++j) {
			this.addSlotToContainer(new Slot((IInventory) entityPlayer.inventory, j, 18 + j * 21, 165));
		}
	}

	public List<String> getNetworkedFields() {
		List<String> ret = super.getNetworkedFields();
		ret.add("guiProgress");
		
		ret.add("inputEU");
		ret.add("redstoneMode");
		ret.add("maxEnergy");
		ret.add("energy");

		return ret;
	}
}
