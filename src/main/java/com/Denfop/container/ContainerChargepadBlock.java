package com.Denfop.container;

import ic2.core.ContainerFullInv;
import ic2.core.block.invslot.InvSlot;
import ic2.core.block.invslot.InvSlotArmor;
import ic2.core.slot.SlotInvSlot;
import java.util.List;

import com.Denfop.tiles.base.TileEntityChargepadBlock;
import com.Denfop.tiles.base.TileEntityElectricBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerChargepadBlock extends ContainerFullInv<TileEntityChargepadBlock> {
	 private TileEntityElectricBlock tileentity;
  public ContainerChargepadBlock(EntityPlayer entityPlayer, TileEntityChargepadBlock tileEntity1) {
    super(entityPlayer, tileEntity1, 196);
    this.tileentity = tileEntity1;
    for (int col = 0; col < 4; col++)
        addSlotToContainer((Slot)new InvSlotArmor(entityPlayer.inventory, col, 8 + col * 18, 84)); 
	addSlotToContainer((Slot) new SlotInvSlot(tileentity.inputslotA, 0, 56, 17));
	addSlotToContainer((Slot) new SlotInvSlot(tileentity.inputslotB, 0, 56, 53));
	addSlotToContainer((Slot) new SlotInvSlot(tileentity.inputslotC, 0, 56 - 36, 17));
	addSlotToContainer((Slot) new SlotInvSlot(tileentity.inputslotC, 1, 56 - 36, 17 + 18));
  }
  
  
  public List<String> getNetworkedFields() {
    List<String> ret = super.getNetworkedFields();
    ret.add("energy2");
    ret.add("energy");
	ret.add("personality");
	ret.add("inputslotA");
	ret.add("inputslotB");
	ret.add("inputslotC");
	ret.add("output_plus");
    return ret;
  }
}
