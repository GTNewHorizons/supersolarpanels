package com.Denfop.block.containerbase;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.doublemacertator.TileEntityDoubleMacerator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.ContainerBase;
import ic2.core.GuiIC2;
import ic2.core.IC2;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiDoubleMacerator extends GuiIC2 {
  public ContainerDoubleMachine<? extends TileEntityDoubleMacerator> container;
  
  public GuiDoubleMacerator(ContainerDoubleMachine<? extends TileEntityDoubleMacerator> container1) {
    super((ContainerBase)container1);
    this.container = container1;
  }
  
  protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
    super.drawGuiContainerBackgroundLayer(f, x, y);
    int chargeLevel = (int)(14.0F * ((TileEntityDoubleMacerator)this.container.base).getChargeLevel());
    int progress = (int)(24.0F * ((TileEntityDoubleMacerator)this.container.base).getProgress());
    if (chargeLevel >= 0)
      drawTexturedModalRect(this.xoffset + 56+1, this.yoffset + 36 + 14 - chargeLevel, 176, 14 - chargeLevel, 14, chargeLevel); 
    if (progress >= 0)
      drawTexturedModalRect(this.xoffset + 79, this.yoffset + 34, 176, 14, progress + 1, 16); 
  }
  
  public String getName() {
    return StatCollector.translateToLocal("ssp.blockMacerator");
  }
  
  public ResourceLocation getResourceLocation() {
    return new ResourceLocation(SuperSolarPanels.TEXTURES, "textures/gui/GUIMacerator.png");
  }
}
