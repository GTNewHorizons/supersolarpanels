package com.Denfop.tiles.wiring.Chargepad;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntityChargepadBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileEntityChargepadMFSUS extends TileEntityChargepadBlock {
  public TileEntityChargepadMFSUS() {
	  super(SuperSolarPanels.tier2, SuperSolarPanels.enegry2,SuperSolarPanels.storage2);
  }
  
  public String getInventoryName() {
    return "Chargepad MFSS";
  }
  
  protected void getItems(EntityPlayer player) {
    for (ItemStack current : player.inventory.armorInventory) {
      if (current != null)
        chargeitems(current, SuperSolarPanels.enegry2); 
    } 
    for (ItemStack current : player.inventory.mainInventory) {
      if (current != null)
        chargeitems(current, SuperSolarPanels.enegry2); 
    } 
  }
}
