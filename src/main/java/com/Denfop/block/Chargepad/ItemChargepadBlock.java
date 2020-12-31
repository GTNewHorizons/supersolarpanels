package com.Denfop.block.Chargepad;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.core.Ic2Items;
import ic2.core.util.StackUtil;
import java.util.List;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.base.ItemBlockIC2;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public class ItemChargepadBlock extends ItemBlockIC2 {
  public ItemChargepadBlock(Block block) {
    super(block);
    setMaxDamage(0);
    setHasSubtypes(true);
    setMaxStackSize(1);
  }
  
  public int getMetadata(int i) {
    return i;
  }
  
  public String getUnlocalizedName(ItemStack itemstack) {
    int meta = itemstack.getItemDamage();
    switch (meta) {
      case 0:
        return "ssp.blockChargepadMFE";
      case 1:
        return "ssp.blockChargepadMFES";
  
    } 
    return null;
  }
  
  public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
    NBTTagCompound nbttagcompound;
    int meta = itemStack.getItemDamage();
    switch (meta) {
      case 0:
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output")+ " " +  SuperSolarPanels.enegry1 + " EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + SuperSolarPanels.storage1 +" EU");
        break;
      case 1:
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output")+ " " + SuperSolarPanels.enegry2 + " EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + SuperSolarPanels.storage2 + " EU");
        break;
    } 
    switch (meta) {
      case 0:
      case 1:
      case 2:
      case 3:
        nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.Store") + " " + nbttagcompound.getInteger("energy") + " EU");
        break;
    }}
  @SideOnly(Side.CLIENT)
  public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List itemList) {
    itemList.add(SuperSolarPanels.ChargepadmfeUnit);
    itemList.add(SuperSolarPanels.ChargepadmfsUnit);
    ItemStack  itemStack = new ItemStack(SuperSolarPanels.ChargepadmfeUnit.getItem(), 1);
    NBTTagCompound nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
    itemStack.setItemDamage(0);
    nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
    nbttagcompound.setDouble("energy",  SuperSolarPanels.storage1);
    itemList.add(itemStack);
    itemStack = new ItemStack(SuperSolarPanels.ChargepadmfsUnit.getItem(), 1);
    itemStack.setItemDamage(1);
    nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
    nbttagcompound.setDouble("energy",  SuperSolarPanels.storage2);
    itemList.add(itemStack);
  }


} 
  
  
 
