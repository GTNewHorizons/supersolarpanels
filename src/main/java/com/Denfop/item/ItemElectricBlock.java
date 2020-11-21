package com.Denfop.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.Ic2Items;
import ic2.core.util.StackUtil;
import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import ic2.core.item.block.ItemBlockIC2;
public class ItemElectricBlock extends ItemBlockIC2 {
  public ItemElectricBlock(Block block) {
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
        return "ssp.blockMFE";
      case 1:
        return "ssp.blockMFSU";
    } 
    return null;
  }
  
  public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
    NBTTagCompound nbttagcompound;
    int meta = itemStack.getItemDamage();
    switch (meta) {
      case 0:
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " + SuperSolarPanels.enegry1  + " EU/t " );
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.storage1  + " EU ");
        info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.tier1);
        
        break;
      case 1:
    	   info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " + SuperSolarPanels.enegry2  + " EU/t " );
           info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.storage2  + " EU ");
           info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.tier2);
         break;
    } 
    switch (meta) {
      case 3:
      case 2:
        nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
        info.add(StatCollector.translateToLocal("ic2.item.tooltip.Store") + " " + nbttagcompound.getInteger("energy") + " EU");
        break;
    } 
  }
  
  @SideOnly(Side.CLIENT)
  public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List itemList) {
    itemList.add(SuperSolarPanels.mfeUnit);
    itemList.add(SuperSolarPanels.mfsUnit);
    ItemStack  itemStack = new ItemStack(SuperSolarPanels.mfeUnit.getItem(), 1);
    NBTTagCompound nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
    itemStack.setItemDamage(0);
    nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
    nbttagcompound.setDouble("energy", 10.0E7D);
    itemList.add(itemStack);
    itemStack = new ItemStack(SuperSolarPanels.mfsUnit.getItem(), 1);
    itemStack.setItemDamage(1);
    nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
    nbttagcompound.setDouble("energy", 40.0E7D);
    itemList.add(itemStack);
  }
}
