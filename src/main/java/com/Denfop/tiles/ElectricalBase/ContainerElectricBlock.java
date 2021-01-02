package com.Denfop.tiles.ElectricalBase;

import ic2.core.ContainerFullInv;
import ic2.core.block.invslot.InvSlot;
import ic2.core.block.invslot.InvSlotArmor;
import ic2.core.slot.SlotInvSlot;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerElectricBlock extends ContainerFullInv<TileEntityElectricBlock> {
  private TileEntityElectricBlock tileentity;

public ContainerElectricBlock(EntityPlayer entityPlayer, TileEntityElectricBlock tileEntity1) {
    super(entityPlayer, (TileEntityElectricBlock)tileEntity1, 196);
    for (int col = 0; col < 4; col++)
      addSlotToContainer((Slot)new InvSlotArmor(entityPlayer.inventory, col, 8 + col * 18, 84));
    this.tileentity = tileEntity1;
    for (int j = 0; j < 1; ++j)
	{
		
		this.addSlotToContainer(new Slot(this.tileentity, j, 56-18 + j * 18, 17));
	}  
    addSlotToContainer((Slot)new SlotInvSlot((InvSlot)tileEntity1.chargeSlot, 0, 56, 17));
    addSlotToContainer((Slot)new SlotInvSlot((InvSlot)tileEntity1.dischargeSlot, 0, 56, 53));
  }
  
  public List<String> getNetworkedFields() {
    List<String> ret = super.getNetworkedFields();
    ret.add("energy");
    ret.add("redstoneMode");
    ret.add("chargeSlot");

    ret.add("dischargeSlot");
    return ret;
  }
  
}
