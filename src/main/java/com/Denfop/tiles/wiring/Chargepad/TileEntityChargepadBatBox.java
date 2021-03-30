package com.Denfop.tiles.wiring.Chargepad;
import com.Denfop.tiles.base.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class TileEntityChargepadBatBox extends TileEntityChargepadBlock {
  public TileEntityChargepadBatBox() {
    super(1, 32, 40000);
  }
  
  public String getInventoryName() {
    return StatCollector.translateToLocal("ssp.blockChargepadBatBox.name");
  }
  
  protected void getItems(EntityPlayer player) {
    if (player != null) {
      for (ItemStack current : player.inventory.armorInventory) {
        if (current != null)
          chargeitems(current, 32); 
      } 
      for (ItemStack current : player.inventory.mainInventory) {
        if (current != null)
          chargeitems(current, 32); 
      } 
    } 
  }
}
