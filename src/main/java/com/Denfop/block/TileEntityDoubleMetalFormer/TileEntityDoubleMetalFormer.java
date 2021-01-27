package com.Denfop.block.TileEntityDoubleMetalFormer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.network.INetworkClientTileEntityEventListener;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.BasicMachineRecipeManager;
import ic2.core.ContainerBase;
import ic2.core.Ic2Items;
import ic2.core.block.invslot.InvSlotProcessable;
import ic2.core.block.invslot.InvSlotProcessableGeneric;
import ic2.core.block.machine.container.ContainerMetalFormer;
import ic2.core.block.machine.gui.GuiMetalFormer;
import ic2.core.init.MainConfig;
import ic2.core.upgrade.UpgradableProperty;
import ic2.core.util.ConfigUtil;
import ic2.core.util.StackUtil;
import java.util.EnumSet;
import java.util.Set;

import com.Denfop.block.doublemacertator.TileEntityDoubleMachine;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityDoubleMetalFormer extends TileEntityDoubleMachine implements INetworkClientTileEntityEventListener {
  private int mode;
  
  private static final int EventSwitch = 0;
  
  public TileEntityDoubleMetalFormer() {
    super(10, 200, 1);
    this.inputSlotA = (InvSlotProcessable)new InvSlotProcessableGeneric(this, "inputA", 0, 1, Recipes.metalformerExtruding);
    this.inputSlotB = (InvSlotProcessable)new InvSlotProcessableGeneric(this, "inputB", 0, 1, Recipes.metalformerExtruding);
  }
  
  public static void init() {
    Recipes.metalformerExtruding = (IMachineRecipeManager)new BasicMachineRecipeManager();
    Recipes.metalformerCutting = (IMachineRecipeManager)new BasicMachineRecipeManager();
    Recipes.metalformerRolling = (IMachineRecipeManager)new BasicMachineRecipeManager();
    if (ConfigUtil.getBool(MainConfig.get(), "recipes/allowCoinCrafting"))
      addRecipeCutting(Ic2Items.casingiron, 1, StackUtil.copyWithSize(Ic2Items.coin, 2)); 
  }
  
  public static void addRecipeCutting(ItemStack input, int amount, ItemStack output) {
    addRecipeCutting((IRecipeInput)new RecipeInputItemStack(input, amount), output);
  }
  
  public static void addRecipeCutting(IRecipeInput input, ItemStack output) {
    Recipes.metalformerCutting.addRecipe(input, null, new ItemStack[] { output });
  }
  
  public void readFromNBT(NBTTagCompound nbttagcompound) {
    super.readFromNBT(nbttagcompound);
    setMode(nbttagcompound.getInteger("mode"));
  }
  
  public void writeToNBT(NBTTagCompound nbttagcompound) {
    super.writeToNBT(nbttagcompound);
    nbttagcompound.setInteger("mode", this.mode);
  }
  
  public String getInventoryName() {
    return "Double MetalFormer";
  }
  
  public ContainerBase<TileEntityDoubleMetalFormer> getGuiContainer(EntityPlayer entityPlayer) {
    return (ContainerBase<TileEntityDoubleMetalFormer>)new ContainerDoubleMetalFormer(entityPlayer, this);
  }
  
  @SideOnly(Side.CLIENT)
  public GuiScreen getGui(EntityPlayer entityPlayer, boolean isAdmin) {
    return (GuiScreen)new GuiDoubleMetalFormer(new ContainerDoubleMetalFormer(entityPlayer, this));
  }
  
  public float getWrenchDropRate() {
    return 0.85F;
  }
  
  public void onNetworkEvent(EntityPlayer player, int event) {
    switch (event) {
      case 0:
        cycleMode();
        break;
    } 
  }
  
  public void onNetworkUpdate(String field) {
    super.onNetworkUpdate(field);
    if (field.equals("mode"))
      setMode(this.mode); 
  }
  
  public int getMode() {
    return this.mode;
  }
  
  public void setMode(int mode1) {
    InvSlotProcessableGeneric slot = (InvSlotProcessableGeneric)this.inputSlotA;
    InvSlotProcessableGeneric slot1 = (InvSlotProcessableGeneric)this.inputSlotB;
    switch (mode1) {
      case 0:
        slot.setRecipeManager(Recipes.metalformerExtruding);
        slot1.setRecipeManager(Recipes.metalformerExtruding);
        break;
      case 1:
        slot.setRecipeManager(Recipes.metalformerRolling);
        slot1.setRecipeManager(Recipes.metalformerRolling);
        break;
      case 2:
        slot.setRecipeManager(Recipes.metalformerCutting);
        slot1.setRecipeManager(Recipes.metalformerCutting);
        break;
      default:
        throw new RuntimeException("invalid mode: " + mode1);
    } 
    this.mode = mode1;
  }
  
  private void cycleMode() {
    setMode((getMode() + 1) % 3);
  }
  
  public Set<UpgradableProperty> getUpgradableProperties() {
    return EnumSet.of(UpgradableProperty.Processing, UpgradableProperty.Transformer, UpgradableProperty.EnergyStorage, UpgradableProperty.ItemConsuming, UpgradableProperty.ItemProducing);
  }
}
