package com.Denfop.tiles.Mechanism;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.core.Ic2Items;
import ic2.core.block.invslot.InvSlotProcessable;
import ic2.core.block.invslot.InvSlotProcessableGeneric;
import ic2.core.upgrade.UpgradableProperty;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.Denfop.SuperSolarPanels;
import com.Denfop.InvSlot.InvSlotProcessableGenerationMicrochip;
import com.Denfop.RecipeManager.MicrochipRecipeManager;
import com.Denfop.api.IMicrochipFarbricatorRecipeManager;
import com.Denfop.api.Recipes;
import com.Denfop.container.ContainerBaseGenerationChipMachine;
import com.Denfop.gui.GuiGenerationMicrochip;
import com.Denfop.tiles.base.TileEntityBaseGenerationMicrochip;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TileEntityGenerationMicrochip extends TileEntityBaseGenerationMicrochip {

public TileEntityGenerationMicrochip() {
    super(1, 300, 1);
    this.inputSlotA = (InvSlotProcessable)new InvSlotProcessableGenerationMicrochip(this, "inputA", 0, 1, Recipes.GenerationMicrochip);
    this.inputSlotB = (InvSlotProcessable)new InvSlotProcessableGenerationMicrochip(this, "inputB", 1, 1, Recipes.GenerationMicrochip); 
    this.inputSlotC = (InvSlotProcessable)new InvSlotProcessableGenerationMicrochip(this, "inputC", 2, 1, Recipes.GenerationMicrochip); 
    this.inputSlotD = (InvSlotProcessable)new InvSlotProcessableGenerationMicrochip(this, "inputD", 3, 1, Recipes.GenerationMicrochip); 
    this.inputSlotE = (InvSlotProcessable)new InvSlotProcessableGenerationMicrochip(this, "inputE", 4, 1, Recipes.GenerationMicrochip); 
    
  }
  
  public static void init() {
	  Recipes.GenerationMicrochip = (IMicrochipFarbricatorRecipeManager)new MicrochipRecipeManager();
	  GenerationMicrochip((IRecipeInput)new RecipeInputItemStack(new ItemStack(Items.coal), 1), 
			  (IRecipeInput)new RecipeInputItemStack(new ItemStack(Items.coal), 1),
			  (IRecipeInput)new RecipeInputItemStack(new ItemStack(Items.coal), 1),
			  (IRecipeInput)new RecipeInputItemStack(new ItemStack(Items.coal), 1),
			  (IRecipeInput)new RecipeInputItemStack(new ItemStack(Items.coal), 1),
			  new ItemStack(Ic2Items.advIronIngot.getItem(),1,3) );
		 
	  }
  
  public String getInventoryName() {
	  
    return "Generation Microchip";
  }
  
  public static void GenerationMicrochip(IRecipeInput container, IRecipeInput fill,IRecipeInput fill1,IRecipeInput fill2,IRecipeInput container1, ItemStack output) {
	    Recipes.GenerationMicrochip.addRecipe(container, fill,fill1,fill2,container1, output);
	   
	    
	  }

  @SideOnly(Side.CLIENT)
  public GuiScreen getGui(EntityPlayer entityPlayer, boolean isAdmin) {
    return (GuiScreen)new GuiGenerationMicrochip(new ContainerBaseGenerationChipMachine(entityPlayer, this));
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
