package com.Denfop.block.triplecompressor;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.containerbase.ContainerTripleMachine;
import com.Denfop.block.containerbase.TileEntityTripleMachine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.ContainerBase;
import ic2.core.GuiIC2;
import ic2.core.IC2;
import ic2.core.block.machine.container.ContainerStandardMachine;
import ic2.core.block.machine.tileentity.TileEntityStandardMachine;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiTripleCompressor extends GuiIC2 {
  public ContainerTripleMachine<? extends TileEntityTripleMachine> container;
  
  public GuiTripleCompressor(ContainerTripleMachine<? extends TileEntityTripleMachine> container1) {
    super((ContainerBase)container1);
    this.container = container1;
  }
  
  protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
    super.drawGuiContainerBackgroundLayer(f, x, y);
    int chargeLevel = (int)(14.0F * ((TileEntityTripleMachine)this.container.base).getChargeLevel());
    int progress = (int)(24.0F * ((TileEntityTripleMachine)this.container.base).getProgress());
    if (chargeLevel > 0)
      drawTexturedModalRect(this.xoffset + 56+1, this.yoffset + 36 + 14 - chargeLevel, 176, 14 - chargeLevel, 14, chargeLevel); 
    if (progress > 0)
      drawTexturedModalRect(this.xoffset + 79, this.yoffset + 34, 176, 14, progress + 1, 16); 
  }
  
  public String getName() {
    return StatCollector.translateToLocal("ssp.blockCompressor2");
  }
  
  public ResourceLocation getResourceLocation() {
    return new ResourceLocation(SuperSolarPanels.TEXTURES, "textures/gui/GUItripleCompressor.png");
  }
}
