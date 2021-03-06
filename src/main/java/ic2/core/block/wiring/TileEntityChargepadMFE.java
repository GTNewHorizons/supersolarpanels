package ic2.core.block.wiring;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileEntityChargepadMFE extends com.Denfop.tiles.base.TileEntityChargepadBlock {
  public TileEntityChargepadMFE() {
    super(3, 512, 4000000);
  }
  
  public String getInventoryName() {
    return "Chargepad MFE";
  }
  
  protected void getItems(EntityPlayer player) {
    if (player != null) {
      for (ItemStack current : player.inventory.armorInventory) {
        if (current != null)
          chargeitems(current, 512); 
      } 
      for (ItemStack current : player.inventory.mainInventory) {
        if (current != null)
          chargeitems(current, 512); 
      } 
    } 
  }
}
