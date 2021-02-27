package com.Denfop.container;

import ic2.core.ContainerFullInv;
import ic2.core.block.invslot.InvSlot;
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
    for (int j = 0; j < 2; ++j)
	{
		
		this.addSlotToContainer(new Slot(this.tileentity, j, 56-36 + (j*(j+1) * 18)*j , 17));
	}  

    addSlotToContainer((Slot)new Slot(this.tileentity, 2, 56, 53));
  }
  
  
  public List<String> getNetworkedFields() {
    List<String> ret = super.getNetworkedFields();
    ret.add("energy2");
    ret.add("energy");
    ret.add("redstoneMode");
    ret.add("chargeSlots");
    return ret;
  }
}
