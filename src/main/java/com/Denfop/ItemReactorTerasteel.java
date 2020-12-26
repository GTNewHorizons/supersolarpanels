package com.Denfop;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.reactor.ItemReactorUranium;
import com.Denfop.utils.InternalName;

import ic2.api.reactor.IReactor;
import ic2.core.Ic2Items;
import net.minecraft.item.ItemStack;

public class ItemReactorTerasteel extends ItemReactorUranium {
  public ItemReactorTerasteel(InternalName internalName, int cells) {
    super(internalName, cells, SuperSolarPanels.TerrasteelRodCells);
  }
  
  protected int getFinalHeat(IReactor reactor, ItemStack stack, int x, int y, int heat) {
    if (reactor.isFluidCooled()) {
      float breedereffectiveness = reactor.getHeat() / reactor.getMaxHeat();
      if (breedereffectiveness > 0.5D)
        heat *= SuperSolarPanels.TerrasteelRodHeat; 
    } 
    return heat;
  }
  
  protected ItemStack getDepletedStack(IReactor reactor, ItemStack stack) {
    ItemStack ret;
    switch (this.numberOfCells) {
      case 1:
        ret = SuperSolarPanels.reactorDepletedprotonSimple;
        return new ItemStack(ret.getItem(), 1);
      case 2:
        ret = SuperSolarPanels.reactorDepletedprotonDual;
        return new ItemStack(ret.getItem(), 1);
      case 4:
        ret = SuperSolarPanels.reactorDepletedprotonQuad;
        return new ItemStack(ret.getItem(), 1);
    } 
    throw new RuntimeException("invalid cell count: " + this.numberOfCells);
  }
  
  public boolean acceptUraniumPulse(IReactor reactor, ItemStack yourStack, ItemStack pulsingStack, int youX, int youY, int pulseX, int pulseY, boolean heatrun) {
    if (!heatrun) {
      float breedereffectiveness = reactor.getHeat() / reactor.getMaxHeat();
      float ReaktorOutput = SuperSolarPanels.TerrasteelPower * breedereffectiveness + 3.0F;
      reactor.addOutput(ReaktorOutput);
    } 
    return true;
  }
}
