package com.Denfop.container;

import ic2.core.ContainerFullInv;
import ic2.core.block.invslot.InvSlot;
import ic2.core.block.machine.container.ContainerElectricMachine;
import ic2.core.slot.SlotInvSlot;
import java.util.List;

import com.Denfop.tiles.Mechanism.TileEntityBaseQuantumQuarry;
import com.Denfop.tiles.Mechanism.TileEntityQuantumQuarry;
import com.Denfop.tiles.base.TileEntityBaseAlloySmelter;
import com.Denfop.tiles.base.TileEntityChargepadBlock;
import com.Denfop.tiles.base.TileEntityElectricBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerQuantumQuarry<T extends TileEntityBaseQuantumQuarry> extends ContainerFullInv<T> {
	 private TileEntityBaseQuantumQuarry tileentity;
  public ContainerQuantumQuarry(EntityPlayer entityPlayer, TileEntityBaseQuantumQuarry tileEntityBaseQuantumQuarry) {
	  this(entityPlayer, (T) tileEntityBaseQuantumQuarry, 166);
    this.tileentity = tileEntityBaseQuantumQuarry;
    for (int j = 0; j < 6; ++j)
	{
		
		this.addSlotToContainer(new Slot(this.tileentity, j, 30+18*j , 6));
	}  
    for (int j = 0; j < 6; ++j)
	{
		
		this.addSlotToContainer(new Slot(this.tileentity, j+6, 30+18*j , 6+18));
	}  
    for (int j = 0; j < 6; ++j)
	{
		
		this.addSlotToContainer(new Slot(this.tileentity, j+12, 30+18*j , 6+18+18));
	} 
    for (int j = 0; j < 6; ++j)
	{
		
		this.addSlotToContainer(new Slot(this.tileentity, j+18, 30+18*j , 6+18+18+18));
	} 
  }
    public ContainerQuantumQuarry(EntityPlayer entityPlayer, T tileEntity1, int height) {
        super(entityPlayer, tileEntity1, height);
           }
    

  
  
  
  







public List<String> getNetworkedFields() {
    List<String> ret = super.getNetworkedFields();
    ret.add("energyconsume");
    ret.add("energy");
   
    ret.add("getblock");
    ret.add("maxEnergy");
    return ret;
  }
}
