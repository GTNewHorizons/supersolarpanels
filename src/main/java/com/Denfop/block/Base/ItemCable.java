package com.Denfop.block.Base;

import ic2.api.item.IBoxable;
import ic2.core.util.StackUtil;
import java.util.List;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.base.ItemBlockIC2;
import com.Denfop.item.base.ItemSSP;
import com.Denfop.utils.InternalName;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ItemCable extends ItemSSP implements IBoxable {
  public ItemCable(InternalName internalName) {
    super(internalName);
    setHasSubtypes(true);
    SuperSolarPanels.copperCableItem = new ItemStack((Item)this, 1, 1);
    SuperSolarPanels.insulatedCopperCableItem = new ItemStack((Item)this, 1, 0);
    SuperSolarPanels.goldCableItem = new ItemStack((Item)this, 1, 2);
    SuperSolarPanels.insulatedGoldCableItem = new ItemStack((Item)this, 1, 3);
    SuperSolarPanels.doubleInsulatedGoldCableItem = new ItemStack((Item)this, 1, 4);
    SuperSolarPanels.ironCableItem = new ItemStack((Item)this, 1, 5);
    SuperSolarPanels.insulatedIronCableItem = new ItemStack((Item)this, 1, 6);
    SuperSolarPanels.doubleInsulatedIronCableItem = new ItemStack((Item)this, 1, 7);
    SuperSolarPanels.trippleInsulatedIronCableItem = new ItemStack((Item)this, 1, 8);
    SuperSolarPanels.glassFiberCableItem = new ItemStack((Item)this, 1, 9);
  }
  
  public String getUnlocalizedName(ItemStack itemstack) {
    InternalName ret;
    int meta = itemstack.getItemDamage();
    switch (meta) {
      case 0:
        ret = InternalName.itemCable;
        return "ssp." + ret.name();
      case 1:
        ret = InternalName.itemCableO;
        return "ssp." + ret.name();
      case 2:
        ret = InternalName.itemGoldCable;
        return "ssp." + ret.name();
      case 3:
        ret = InternalName.itemGoldCableI;
        return "ssp." + ret.name();
      case 4:
        ret = InternalName.itemGoldCableII;
        return "ssp." + ret.name();
      case 5:
        ret = InternalName.itemIronCable;
        return "ssp." + ret.name();
      case 6:
        ret = InternalName.itemIronCableI;
        return "ssp." + ret.name();
      case 7:
        ret = InternalName.itemIronCableII;
        return "ssp." + ret.name();
      case 8:
        ret = InternalName.itemIronCableIIII;
        return "ssp." + ret.name();
      case 9:
        ret = InternalName.itemGlassCable;
        return "ssp." + ret.name();
      
    } 
    return null;
  }
  
  public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
    int capacity = TileEntityCable.getMaxCapacity(itemStack.getItemDamage());
    info.add(capacity + " EU/t");
  }
  
  public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float a, float b, float c) {
    Block oldBlock = world.getBlock(x, y, z);
    if (!oldBlock.isAir((IBlockAccess)world, x, y, z))
      if (oldBlock == Blocks.snow_layer) {
        side = 1;
      } else if (oldBlock != Blocks.vine && oldBlock != Blocks.tallgrass && oldBlock != Blocks.deadbush && 
        
        !oldBlock.isReplaceable((IBlockAccess)world, x, y, z)) {
        switch (side) {
          case 0:
            y--;
            break;
          case 1:
            y++;
            break;
          case 2:
            z--;
            break;
          case 3:
            z++;
            break;
          case 4:
            x--;
            break;
          case 5:
            x++;
            break;
        } 
      }  
    BlockCable block = (BlockCable)StackUtil.getBlock(SuperSolarPanels.insulatedCopperCableBlock);
    if ((oldBlock.isAir((IBlockAccess)world, x, y, z) || world.canPlaceEntityOnSide(StackUtil.getBlock(SuperSolarPanels.insulatedCopperCableBlock), x, y, z, false, side, (Entity)entityplayer, itemstack)) && world
      .checkNoEntityCollision(block.getCollisionBoundingBoxFromPool(world, x, y, z, itemstack.getItemDamage())) && world
      .setBlock(x, y, z, (Block)block, itemstack.getItemDamage(), 3)) {
      block.onPostBlockPlaced(world, x, y, z, side);
      block.onBlockPlacedBy(world, x, y, z, (EntityLivingBase)entityplayer, itemstack);
      if (!entityplayer.capabilities.isCreativeMode)
        itemstack.stackSize--; 
      return true;
    } 
    return false;
  }
  
  public void getSubItems(Item item, CreativeTabs tabs, List itemList) {
    for (int meta = 0; meta < 32767; meta++) {
      if (meta != 4 && meta != 7 && meta != 8) {
        ItemStack stack = new ItemStack((Item)this, 1, meta);
        if (getUnlocalizedName(stack) != null)
          itemList.add(stack); 
      } 
    } 
  }
  
  public boolean canBeStoredInToolbox(ItemStack itemstack) {
    return true;
  }
}
