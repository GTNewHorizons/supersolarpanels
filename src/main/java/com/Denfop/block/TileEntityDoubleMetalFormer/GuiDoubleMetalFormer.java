package com.Denfop.block.TileEntityDoubleMetalFormer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.ContainerBase;
import ic2.core.GuiIC2;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import ic2.core.block.machine.container.ContainerMetalFormer;
import ic2.core.block.machine.tileentity.TileEntityMetalFormer;
import ic2.core.network.NetworkManager;
import ic2.core.util.GuiTooltipHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import com.Denfop.SuperSolarPanels;

@SideOnly(Side.CLIENT)
public class GuiDoubleMetalFormer extends GuiIC2 {
  public ContainerDoubleMetalFormer container;
  
  public GuiDoubleMetalFormer(ContainerDoubleMetalFormer container1) {
    super((ContainerBase)container1);
    this.container = container1;
  }
  
  protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    String tooltip = "";
    GL11.glPushAttrib(64);
    RenderItem renderItem = new RenderItem();
    RenderHelper.enableGUIStandardItemLighting();
    switch (((TileEntityDoubleMetalFormer)this.container.base).getMode()) {
      case 0:
        renderItem.renderItemIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, Ic2Items.copperCableItem, 67, 55);
        tooltip = StatCollector.translateToLocal("ic2.MetalFormer.gui.switch.Extruding");
        break;
      case 1:
        renderItem.renderItemIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, Ic2Items.ForgeHammer, 67, 55);
        tooltip = StatCollector.translateToLocal("ic2.MetalFormer.gui.switch.Rolling");
        break;
      case 2:
        renderItem.renderItemIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, Ic2Items.cutter, 67, 55);
        tooltip = StatCollector.translateToLocal("ic2.MetalFormer.gui.switch.Cutting");
        break;
    } 
    GuiTooltipHelper.drawAreaTooltip(mouseX - this.guiLeft, mouseY - this.guiTop, tooltip, 65, 50, 85, 70);
    GL11.glPopAttrib();
    super.drawGuiContainerForegroundLayer(mouseX, mouseY);
  }
  
  protected void actionPerformed(GuiButton guibutton) {
    super.actionPerformed(guibutton);
    ((NetworkManager)IC2.network.get()).initiateClientTileEntityEvent((TileEntity)this.container.base, guibutton.id);
  }
  
  public void initGui() {
    super.initGui();
    this.buttonList.add(new GuiButton(0, (this.width - this.xSize) / 2 + 65, (this.height - this.ySize) / 2 + 53, 20, 20, ""));
  }
  
  protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
    super.drawGuiContainerBackgroundLayer(f, x, y);
    int chargeLevel = (int)(14.0F * ((TileEntityDoubleMetalFormer)this.container.base).getChargeLevel());
    int progress = (int)(48.0F * ((TileEntityDoubleMetalFormer)this.container.base).getProgress());
    if (chargeLevel > 0)
      drawTexturedModalRect(this.xoffset + 17+1, this.yoffset + 50 - chargeLevel, 176, 14 - chargeLevel, 14, chargeLevel); 
    if (progress > 0)
      drawTexturedModalRect(this.xoffset + 51, this.yoffset + 37, 177, 14, progress, 13); 
  }
  
  public String getName() {
    return this.container.base.getInventoryName();
  }
  
  public ResourceLocation getResourceLocation() {
    return new ResourceLocation(SuperSolarPanels.TEXTURES, "textures/gui/GUIMetalFormer.png");
  }
}
