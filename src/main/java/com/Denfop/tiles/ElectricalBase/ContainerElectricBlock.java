package com.Denfop.tiles.ElectricalBase;

import ic2.core.ContainerFullInv;
import java.util.List;

import com.Denfop.tiles.base.TileEntityElectricBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerElectricBlock extends ContainerFullInv<TileEntityElectricBlock> {
  private TileEntityElectricBlock tileentity;

public ContainerElectricBlock(EntityPlayer entityPlayer, TileEntityElectricBlock tileEntity1) {
    super(entityPlayer, (TileEntityElectricBlock)tileEntity1, 196);
    for (int col = 0; col < 4; col++)
      addSlotToContainer((Slot)new Slot(entityPlayer.inventory, 36 + 3 - col, 8 + col * 18, 84));
    this.tileentity = tileEntity1;
    for (int j = 0; j < 2; ++j)
	{
		
		this.addSlotToContainer(new Slot(tileEntity1, j, 56-36 + (j*(j+1) * 18)*j , 17));
	}  

    addSlotToContainer((Slot)new Slot(tileEntity1, 2, 56, 53));
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
