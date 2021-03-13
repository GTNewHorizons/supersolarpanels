package com.Denfop.tiles.wiring.Chargepad;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileEntityChargepadCESU extends com.Denfop.tiles.base.TileEntityChargepadBlock {
  public TileEntityChargepadCESU() {
    super(2, 128, 300000);
  }
  
  public String getInventoryName() {
    return "Chargepad CESU";
  }
  
  protected void getItems(EntityPlayer player) {
    if (player != null) {
      for (ItemStack current : player.inventory.armorInventory) {
        if (current != null)
          chargeitems(current, 128); 
      } 
      for (ItemStack current : player.inventory.mainInventory) {
        if (current != null)
          chargeitems(current, 128); 
      } 
    } 
  }
}
