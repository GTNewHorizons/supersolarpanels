package com.Denfop.tiles.base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.network.INetworkClientTileEntityEventListener;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.RecipeOutput;
import ic2.core.BasicMachineRecipeManager;
import ic2.core.IC2;
import ic2.core.block.invslot.InvSlotProcessable;
import ic2.core.block.invslot.InvSlotProcessableGeneric; 
import ic2.core.upgrade.UpgradableProperty;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.Denfop.SSPItem;
import com.Denfop.SuperSolarPanels;
import com.Denfop.api.Recipes;
import com.Denfop.container.ContainerBaseMolecular;
import com.Denfop.gui.GuiMolecularTransformer;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public class TileEntityMolecularTransformer extends TileEntityBaseMolecular implements INetworkClientTileEntityEventListener {
	public byte redstoneMode;
  public TileEntityMolecularTransformer() {
    super(1, 500 , 1);
    this.inputSlot = (InvSlotProcessable)new InvSlotProcessableGeneric(this, "input", 0, 1, Recipes.molecular);
    this.redstoneMode = 0;
    this.setTier(11);
  }
  private boolean isActive;

  public static void init() {
    Recipes.molecular = (IMachineRecipeManager)new BasicMachineRecipeManager();
    NBTTagCompound nbt = new NBTTagCompound();
    nbt.setInteger("energy", 9000000);
    Recipes.molecular.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.spinelore,1)), nbt, new ItemStack[] { new ItemStack(SSPItem.spinelcrushedore,2 )});
    NBTTagCompound nbt1 = new NBTTagCompound();
    nbt1.setInteger("energy", 5000000);
    Recipes.molecular.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.spinel_ingot,1)), nbt1, new ItemStack[] { new ItemStack(SSPItem.ingotIridium.getItem(),1,7 )});

  }

	public boolean isActive()
	{
		return this.isActive;
	}
  public String getInventoryName() {
    return "Molecular Transformer";
  }
  public void readFromNBT(NBTTagCompound nbttagcompound) {
	    super.readFromNBT(nbttagcompound);
	    this.maxEnergy = nbttagcompound.getInteger("energy");
	
	    this.redstoneMode = nbttagcompound.getByte("redstoneMode");
	  }
	  
	  public void writeToNBT(NBTTagCompound nbttagcompound) {
	    super.writeToNBT(nbttagcompound);
	    nbttagcompound.setInteger("energy", (int) this.maxEnergy);
	    nbttagcompound.setByte("redstoneMode", this.redstoneMode);
	  }
	 
  @SideOnly(Side.CLIENT)
  public GuiScreen getGui(EntityPlayer entityPlayer, boolean isAdmin) {
    return (GuiScreen)new GuiMolecularTransformer(new ContainerBaseMolecular(entityPlayer, this));
  }
  protected void updateEntityServer() {
	    super.updateEntityServer();
	
  }

  public void onNetworkEvent(EntityPlayer player, int event) {
	  
    this.redstoneMode = (byte)(this.redstoneMode + 1);
    if (this.redstoneMode >= 8)
      this.redstoneMode = 0; 
   
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
  
  
  
  public static List<Map.Entry<ItemStack, ItemStack>> recipes = new Vector<Map.Entry<ItemStack, ItemStack>>();



}
