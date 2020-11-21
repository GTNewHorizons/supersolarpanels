package com.Denfop.item;

import java.util.List;

import ic2.core.item.block.ItemBlockIC2;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemMachine extends ItemBlockIC2 {
  public ItemMachine(Block block) {
    super(block);
    setMaxDamage(0);
    setHasSubtypes(true);
  }
  
  public int getMetadata(int i) {
    return i;
  }
  
  public String getUnlocalizedName(ItemStack itemstack) {
    int meta = itemstack.getItemDamage();
    switch (meta) {
      case 0:
        return "ssp.blockMatter";
    } 
    return null;
  }
  
  public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
    int meta = itemStack.getItemDamage(); 
    switch (meta) {
     
      case 0:
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.power") + " 512 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
        break;
      
    } 
  }
}
