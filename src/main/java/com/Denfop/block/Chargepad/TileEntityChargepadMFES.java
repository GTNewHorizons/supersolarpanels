package com.Denfop.block.Chargepad;

import com.Denfop.SuperSolarPanels;

import ic2.core.block.wiring.TileEntityChargepadBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileEntityChargepadMFES extends TileEntityChargepadBlock {
  public TileEntityChargepadMFES() {
	  super(SuperSolarPanels.tier1, SuperSolarPanels.enegry1, SuperSolarPanels.storage1);
  }
  
  public String getInventoryName() {
    return "Chargepad MFE";
  }
  
  protected void getItems(EntityPlayer player) {
    if (player != null) {
      for (ItemStack current : player.inventory.armorInventory) {
        if (current != null)
          chargeitems(current, SuperSolarPanels.enegry1); 
      } 
      for (ItemStack current : player.inventory.mainInventory) {
        if (current != null)
          chargeitems(current, SuperSolarPanels.enegry1); 
      } 
    } 
  }
}
