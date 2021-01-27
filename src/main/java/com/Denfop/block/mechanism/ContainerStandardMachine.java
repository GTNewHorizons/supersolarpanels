package com.Denfop.block.mechanism;

import ic2.core.block.invslot.InvSlot;
import ic2.core.block.machine.container.ContainerElectricMachine;
import ic2.core.slot.SlotInvSlot;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class ContainerStandardMachine<T extends TileEntityStandardMachine> extends ContainerElectricMachine<T> {
  public ContainerStandardMachine(EntityPlayer entityPlayer, T tileEntity1) {
    this(entityPlayer, tileEntity1, 166, 56, 53, 56, 17, 116, 35, 152, 8);
  }
  
  public ContainerStandardMachine(EntityPlayer entityPlayer, T tileEntity1, int height, int dischargeX, int dischargeY, int inputX, int inputY, int outputX, int outputY, int upgradeX, int upgradeY) {
    super(entityPlayer, tileEntity1, height, dischargeX, dischargeY);
    if (((TileEntityStandardMachine)tileEntity1).inputSlotB != null)
        addSlotToContainer((Slot)new SlotInvSlot((InvSlot)((TileEntityStandardMachine)tileEntity1).inputSlotB, 0, inputX-18, inputY)); 
    
    if (((TileEntityStandardMachine)tileEntity1).inputSlotA != null)
      addSlotToContainer((Slot)new SlotInvSlot((InvSlot)((TileEntityStandardMachine)tileEntity1).inputSlotA, 0, inputX+18, inputY)); 
    if (((TileEntityStandardMachine)tileEntity1).outputSlot != null)
      addSlotToContainer((Slot)new SlotInvSlot((InvSlot)((TileEntityStandardMachine)tileEntity1).outputSlot, 0, outputX, outputY)); 
    for (int i = 0; i < 4; i++)
      addSlotToContainer((Slot)new SlotInvSlot((InvSlot)((TileEntityStandardMachine)tileEntity1).upgradeSlot, i, upgradeX, upgradeY + i * 18)); 
  }
  
  public List<String> getNetworkedFields() {
    List<String> ret = super.getNetworkedFields();
    ret.add("guiProgress");
    return ret;
  }
}
