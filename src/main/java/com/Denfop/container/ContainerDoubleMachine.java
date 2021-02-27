package com.Denfop.container;

import ic2.core.block.invslot.InvSlot;
import ic2.core.block.machine.container.ContainerElectricMachine;
import ic2.core.slot.SlotInvSlot;
import java.util.List;

import com.Denfop.tiles.base.TileEntityDoubleMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class ContainerDoubleMachine<T extends TileEntityDoubleMachine> extends ContainerElectricMachine<T> {
  public ContainerDoubleMachine(EntityPlayer entityPlayer, T tileEntity1) {
    this(entityPlayer, tileEntity1, 166, 56, 53, 56, 17, 116, 35, 152, 8);
  }
  
  public ContainerDoubleMachine(EntityPlayer entityPlayer, T tileEntity1, int height, int dischargeX, int dischargeY, int inputX, int inputY, int outputX, int outputY, int upgradeX, int upgradeY) {
    super(entityPlayer, tileEntity1, height, dischargeX, dischargeY);
    addSlotToContainer((Slot)new SlotInvSlot((InvSlot)((TileEntityDoubleMachine)tileEntity1).inputSlotA, 0, inputX - 8 , inputY)); 
      addSlotToContainer((Slot)new SlotInvSlot((InvSlot)((TileEntityDoubleMachine)tileEntity1).inputSlotB, 0, inputX + 8, inputY)); 
      addSlotToContainer((Slot)new SlotInvSlot((InvSlot)((TileEntityDoubleMachine)tileEntity1).outputSlotA, 0, outputX - 8, outputY)); 
      addSlotToContainer((Slot)new SlotInvSlot((InvSlot)((TileEntityDoubleMachine)tileEntity1).outputSlotB, 0, outputX + 8, outputY)); 
    for (int i = 0; i < 4; i++)
      addSlotToContainer((Slot)new SlotInvSlot((InvSlot)((TileEntityDoubleMachine)tileEntity1).upgradeSlot, i, upgradeX, upgradeY + i * 18)); 
  }
  
  public List<String> getNetworkedFields() {
    List<String> ret = super.getNetworkedFields();
    ret.add("guiProgress");
    return ret;
  }
}
