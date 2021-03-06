package com.Denfop.gui;

import com.Denfop.Constants;
import com.Denfop.SuperSolarPanels;
import com.Denfop.container.ContainerQuantumQuarry;
import com.Denfop.container.ContainerStandardMachine;
import com.Denfop.tiles.Mechanism.TileEntityAlloySmelter;
import com.Denfop.tiles.Mechanism.TileEntityQuantumQuarry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.ContainerBase;
import ic2.core.GuiIC2;
import ic2.core.IC2;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiQuantumQuarry extends GuiIC2 {
  public ContainerQuantumQuarry container;
  
  public GuiQuantumQuarry(ContainerQuantumQuarry container1) {
    super((ContainerBase)container1);
    this.container = container1;
  }
  
  protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
    super.drawGuiContainerBackgroundLayer(f, x, y);
    
  
    this.fontRendererObj.drawString(""+this.container.base.getblock, this.xoffset+50, this.yoffset +7, 7718655);
    int chargeLevel = (int)(14.0F * ((TileEntityQuantumQuarry)this.container.base).getChargeLevel());
    
    if (chargeLevel > 0)
      drawTexturedModalRect(this.xoffset + 56+1, this.yoffset + 36 + 14 - chargeLevel, 176, 14 - chargeLevel, 14, chargeLevel); 
    
  }
  
  public String getName() {
    return this.container.base.getInventoryName();
  }
  
  public ResourceLocation getResourceLocation() {
    return new ResourceLocation(Constants.TEXTURES, "textures/gui/GUIAlloySmelter.png");
  }
}
