package com.Denfop.item.Machina;

import java.util.List;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.base.ItemBlockIC2;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemMachine1 extends ItemBlockIC2 {
  public ItemMachine1(Block block) {
    super(block);
    setMaxDamage(0);
    setHasSubtypes(true);
    setCreativeTab(SuperSolarPanels.tabssp);
  }
  
  public int getMetadata(int i) {
    return i;
  }
  
  public String getUnlocalizedName(ItemStack itemstack) {
    int meta = itemstack.getItemDamage();
    switch (meta) {
      case 1:
        return "ssp.blockMacerator";
      case 2:
        return "ssp.blockExtractor";
      case 3:
        return "ssp.blockCompressor1";
      case 4:
        return "ssp.blockCompressor2";
      case 5:
        return "ssp.blockMatter1";
      case 6:
          return "ssp.blockMacerator1";
      case 7:
          return "ssp.blockElecFurnace1";
      case 8:
          return "ssp.blockElecFurnace2";
      case 9:
          return "ssp.blockMatter2";
      case 10:
          return "ssp.blockMatter3";
      case 11:
          return "ssp.MetalFormer1";
      case 12:
          return "ssp.MetalFormer2";
      case 13:
          return "ssp.Alloymachine";
    } 
    return null;
  }
  
  public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
    int meta = itemStack.getItemDamage();
    switch (meta) {
      
      case 1:
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.power") + " 2 EU/t, 32 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
        break;
      case 2:
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.power") + " 2 EU/t, 32 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
        break;
      case 3:
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.power") + " 2 EU/t, 32 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
        break;
      
      case 4:
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.power") + " 1 EU/t, 128 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
        break;
      case 5:
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.power") + " 512 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
        break;
      case 6:
          info.add(StatCollector.translateToLocal("ic2.item.tooltip.power") + " 2 EU/t, 32 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
          break;
      
    } 
  }
}
