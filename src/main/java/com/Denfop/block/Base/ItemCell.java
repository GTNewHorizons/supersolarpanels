package com.Denfop.block.Base;

import ic2.core.IC2;
import ic2.core.util.LiquidUtil;
import ic2.core.util.StackUtil;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.base.ItemSSP;
import com.Denfop.utils.InternalName;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class ItemCell extends ItemSSP {
  private final Map<Integer, InternalName> names;
  
  private final Map<Block, ItemStack> cells;
  
  public ItemCell(InternalName internalName) {
    super(internalName);
    this.names = new HashMap<Integer, InternalName>();
    this.cells = new IdentityHashMap<Block, ItemStack>();
    setHasSubtypes(true);
    SuperSolarPanels.cell = addCell(0, InternalName.itemCellEmpty, new Block[0]);
  
   
    SuperSolarPanels.uuMatterCell = addRegisterCell(1, InternalName.itemCellUuMatter, InternalName.fluidUuMatter);
    }
  
 
  
  public String getUnlocalizedName(ItemStack stack) {
    InternalName ret = this.names.get(Integer.valueOf(stack.getItemDamage()));
    if (ret == null)
      return null; 
    return "ssp." + ret.name();
  }
  
  public void getSubItems(Item item, CreativeTabs tabs, List itemList) {
    for (int meta = 0; meta < 32767; meta++) {
      ItemStack stack = new ItemStack((Item)this, 1, meta);
      if (getUnlocalizedName(stack) == null)
        break; 
      itemList.add(stack);
    } 
  }
  
  public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset) {
    if (!IC2.platform.isSimulating())
      return false; 
    MovingObjectPosition position = getMovingObjectPositionFromPlayer(world, player, true);
    if (position == null)
      return false; 
    if (position.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
      x = position.blockX;
      y = position.blockY;
      z = position.blockZ;
      if (!world.canMineBlock(player, x, y, z))
        return false; 
      if (!player.canPlayerEdit(x, y, z, position.sideHit, stack))
        return false; 
      if (stack.getItemDamage() == 0) {
        if (world.getBlockMetadata(x, y, z) == 0) {
          ItemStack filledCell = this.cells.get(world.getBlock(x, y, z));
          if (filledCell != null && StackUtil.storeInventoryItem(filledCell.copy(), player, false)) {
            world.setBlockToAir(x, y, z);
            stack.stackSize--;
            return true;
          } 
        } 
      } else {
        FluidStack fs = FluidContainerRegistry.getFluidForFilledItem(stack);
        ForgeDirection dir = ForgeDirection.VALID_DIRECTIONS[position.sideHit];
        if ((fs != null && LiquidUtil.placeFluid(fs, world, x, y, z)) || (player.canPlayerEdit(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ, position.sideHit, stack) && LiquidUtil.placeFluid(fs, world, x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ))) {
          if (!player.capabilities.isCreativeMode)
            stack.stackSize--; 
          return true;
        } 
      } 
    } 
    return false;
  }
  
  private ItemStack addCell(int meta, InternalName name, Block... blocks) {
    this.names.put(Integer.valueOf(meta), name);
    ItemStack ret = new ItemStack((Item)this, 1, meta);
    for (Block block : blocks)
      this.cells.put(block, ret); 
    return ret;
  }
  
  private ItemStack addRegisterCell(int meta, InternalName name, InternalName blockName) {
    ItemStack ret = addCell(meta, name, new Block[] { BlocksItems.getFluidBlock(blockName) });
    FluidContainerRegistry.registerFluidContainer(BlocksItems.getFluid(blockName), ret.copy(), SuperSolarPanels.cell.copy());
    return ret;
  }
}
