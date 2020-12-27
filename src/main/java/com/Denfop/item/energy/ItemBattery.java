package com.Denfop.item.energy;


import com.Denfop.item.base.BaseElectricItem;
import com.Denfop.utils.InternalName;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemBattery extends BaseElectricItem {
  public ItemBattery(InternalName internalName, double maxCharge, double transferLimit, int tier) {
    super(internalName, maxCharge, transferLimit, tier);
  }
  
  public String getTextureName(int index) {
    if (index < 5)
      return getUnlocalizedName().substring(4) + "." + index; 
    return null;
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon getIconFromDamage(int meta) {
    if (meta <= 1)
      return this.textures[4]; 
    if (meta >= getMaxDamage() - 1)
      return this.textures[0]; 
    return this.textures[3 - 3 * (meta - 2) / (getMaxDamage() - 4 + 1)];
  }
  
  public boolean canProvideEnergy(ItemStack itemStack) {
    return true;
  }
  
  public Item getEmptyItem(ItemStack itemStack) {
    if (this == Ic2Items.chargedReBattery.getItem())
      return Ic2Items.reBattery.getItem(); 
    return super.getEmptyItem(itemStack);
  }
  
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityplayer) {
    if (IC2.platform.isSimulating() && itemStack.getItem() == Ic2Items.chargedReBattery.getItem()) {
      boolean transferred = false;
      for (int i = 0; i < 9; i++) {
        ItemStack stack = entityplayer.inventory.mainInventory[i];
        if (stack != null && !(stack.getItem() instanceof ItemBattery)) {
          double transfer = ElectricItem.manager.discharge(itemStack, 2.0D * this.transferLimit, 2147483647, true, true, true);
          if (transfer > 0.0D) {
            transfer = ElectricItem.manager.charge(stack, transfer, this.tier, true, false);
            if (transfer > 0.0D) {
              ElectricItem.manager.discharge(itemStack, transfer, 2147483647, true, true, false);
              transferred = true;
            } 
          } 
        } 
      } 
      if (transferred && !IC2.platform.isRendering())
        entityplayer.openContainer.detectAndSendChanges(); 
    } 
    return itemStack;
  }

public Item setRarity() {
	 
	return null;
}
}
