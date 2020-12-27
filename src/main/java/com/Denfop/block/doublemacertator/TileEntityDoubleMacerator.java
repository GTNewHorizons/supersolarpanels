package com.Denfop.block.doublemacertator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.Recipes;
import ic2.core.BasicMachineRecipeManager;
import ic2.core.block.invslot.InvSlotProcessable;
import ic2.core.block.invslot.InvSlotProcessableGeneric;
import ic2.core.block.machine.tileentity.TileEntityStandardMachine;
import ic2.core.upgrade.UpgradableProperty;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.Denfop.block.containerbase.ContainerDoubleMachine;
import com.Denfop.block.containerbase.GuiDoubleMacerator;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileEntityDoubleMacerator extends TileEntityDoubleMachine {
  public TileEntityDoubleMacerator() {
    super(2, 300, 2);
    this.inputSlotA = (InvSlotProcessable)new InvSlotProcessableGeneric(this, "inputA", 0, 2, Recipes.macerator);
    this.inputSlotB = (InvSlotProcessable)new InvSlotProcessableGeneric(this, "inputB", 1, 2, Recipes.macerator);
  }
  
  public static void init() {
    Recipes.macerator = (IMachineRecipeManager)new BasicMachineRecipeManager();
  }
  
  public String getInventoryName() {
    return "Macerator";
  }
  
  @SideOnly(Side.CLIENT)
  public GuiScreen getGui(EntityPlayer entityPlayer, boolean isAdmin) {
    return (GuiScreen)new GuiDoubleMacerator(new ContainerDoubleMachine(entityPlayer, this));
  }
  
  public String getStartSoundFile() {
    return "Machines/MaceratorOp.ogg";
  }
  
  public String getInterruptSoundFile() {
    return "Machines/InterruptOne.ogg";
  }
  
  public float getWrenchDropRate() {
    return 0.85F;
  }
  
  public Set<UpgradableProperty> getUpgradableProperties() {
    return EnumSet.of(UpgradableProperty.Processing, UpgradableProperty.Transformer, UpgradableProperty.EnergyStorage, UpgradableProperty.ItemConsuming, UpgradableProperty.ItemProducing);
  }
  
  public static List<Map.Entry<ItemStack, ItemStack>> recipes = new Vector<Map.Entry<ItemStack, ItemStack>>();
}
