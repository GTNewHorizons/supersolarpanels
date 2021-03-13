package com.Denfop.tiles.wiring.Chargepad;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileEntityChargepadMFSU extends com.Denfop.tiles.base.TileEntityChargepadBlock {
  public TileEntityChargepadMFSU() {
    super(4, 2048, 40000000);
  }
  
  public String getInventoryName() {
    return "Chargepad MFSU";
  }
  
  protected void getItems(EntityPlayer player) {
    for (ItemStack current : player.inventory.armorInventory) {
      if (current != null)
        chargeitems(current, 2048); 
    } 
    for (ItemStack current : player.inventory.mainInventory) {
      if (current != null)
        chargeitems(current, 2048); 
    } 
  }
}
