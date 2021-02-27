package com.Denfop.gui;

import com.Denfop.Config;
import com.Denfop.SuperSolarPanels;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.container.ContainerAdvSolarPanel;
import com.Denfop.item.Modules.module5;
import com.Denfop.item.Modules.module6;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.utils.GuiNumberUtils;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiAdvSolarPanel extends GuiContainer {
  public TileEntitySolarPanel tileentity;
  
  public GuiAdvSolarPanel(InventoryPlayer inventoryplayer, TileEntitySolarPanel tileentitysolarpanel) {
    super((Container)new ContainerAdvSolarPanel(inventoryplayer, tileentitysolarpanel));
    this.tileentity = tileentitysolarpanel;
    this.allowUserInput = false;
    this.xSize = 194;
    this.ySize = 168;
  }
  
  public static double roundAvoid(double value, int places) {
    double scale = Math.pow(10.0D, places);
    return Math.round(value * scale) / scale;
  }
  
  protected void drawGuiContainerForegroundLayer(int par1, int par2) {
    String formatPanelName = I18n.format(this.tileentity.panelName, new Object[0]);
    int nmPos = (this.xSize - this.fontRendererObj.getStringWidth(formatPanelName)) / 2;
    this.fontRendererObj.drawString(formatPanelName, nmPos, 7, 7718655);
    String storageString = I18n.format("gui.SuperSolarPanel.storage", new Object[0]) + ": ";
    String maxOutputString = I18n.format("gui.SuperSolarPanel.maxOutput", new Object[0]) + ": ";
    String generatingString = I18n.format("gui.SuperSolarPanel.generating", new Object[0]) + ": ";
    String energyPerTickString = I18n.format("gui.SuperSolarPanel.energyPerTick", new Object[0]);
    String energyPerTickString1 = I18n.format("gui.SuperSolarPanel.energyPerTick1", new Object[0]);
    String tierString = I18n.format("gui.ssp.tier", new Object[0]) + ": ";
    String ModulesString = I18n.format("ssp.genday", new Object[0]);
    String ModulesString1 = I18n.format("ssp.gennight", new Object[0]);
    String ModulesString2 = I18n.format("ssp.storage", new Object[0]);
    String ModulesString3 = I18n.format("ssp.output", new Object[0]);
    String ModulesString4 = I18n.format("ssp.tier1", new Object[0]);
    String ModulesString5 = I18n.format("ssp.tier2", new Object[0]);
    int maxstorage1 = 0;
    int output = 0;
    int tierplus = 0;
    int minus = 0;
    for (int i = 0; i < 9; i++) {
      if (this.tileentity.chargeSlots[i] != null && this.tileentity.chargeSlots[i].getItem() instanceof com.Denfop.item.Modules.module3)
        maxstorage1++; 
      if (this.tileentity.chargeSlots[i] != null && this.tileentity.chargeSlots[i].getItem() instanceof com.Denfop.item.Modules.module4)
        output++; 
      if (this.tileentity.chargeSlots[i] != null && this.tileentity.chargeSlots[i].getItem() instanceof com.Denfop.item.Modules.module7) {
        int kk = this.tileentity.chargeSlots[i].getItemDamage();
        if (kk == 1) {
          tierplus++;
        } else if (kk == 2) {
          minus++;
        } 
      } 
    } 
    int c[];
  	c = new int[9];
  	int d[];
  	d = new int[9];
for(int i = 0; i<9;i++) {
    if (this.tileentity.chargeSlots[i] != null && this.tileentity.chargeSlots[i].getItem() instanceof module6) {
      int g = this.tileentity.chargeSlots[i].getItemDamage();
      if (this.tileentity.tier + tierplus - minus >= g + 1) {
    	  NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(this.tileentity.chargeSlots[i]);
	       
	        TileEntitySolarPanel tile = (TileEntitySolarPanel) BlockSSPSolarPanel.getBlockEntity(g);
	   
	        c[i] =	nbt.getInteger("storage");
	        d[i] = 	nbt.getInteger("output");
       
      } 
    } 
}
int sum1 = 0;
int sum2 = 0;

for(int i = 0; i<9;i++) {
	sum1=sum1+c[i];
	sum2=sum2+d[i];
}
    float[] a = new float[4];
    a[0] = (float)((this.tileentity.p + sum1) + (this.tileentity.p + sum1) * 0.2D * maxstorage1);
    if(a[0] > 2000000000) {
    	a[0] = 2000000000;
    }
    else if(a[0] < 0) {
    	a[0] = 0;
    }
    
     
    	String maxstorage_1 =  GuiNumberUtils.getString(a[0]);
    	String maxstorage_2 =  GuiNumberUtils.getString(this.tileentity.storage);
      
        this.fontRendererObj.drawString(storageString + maxstorage_2 + "/" + maxstorage_1, 50, 16, 13487565);
       if(maxstorage1 != 0)
        this.fontRendererObj.drawString(ModulesString2 + (20 * maxstorage1) + "%", 160, 16, 13487565);
      
    
    a[1] = (float)((this.tileentity.u + sum2) + (this.tileentity.u + sum2) * 0.2D * output);
    if(a[1] > 2000000000) {
    	a[1] = 2000000000;
    }
    else if(a[1] < 0) {
    	a[1] = 0;
    }
 
      
        this.fontRendererObj.drawString(maxOutputString +  GuiNumberUtils.getString(a[1]) + " " + energyPerTickString, 50, 26, 13487565);
        if(output != 0)
this.fontRendererObj.drawString(ModulesString3 + (20 * output) + "%", 150, 26, 13487565);
      
    
    int gend = 0;
    int genn = 0;
    for (int j = 0; j < 9; j++) {
      if (this.tileentity.chargeSlots[j] != null && this.tileentity.chargeSlots[j].getItem() instanceof com.Denfop.item.Modules.module1)
        gend++; 
      if (this.tileentity.chargeSlots[j] != null && this.tileentity.chargeSlots[j].getItem() instanceof com.Denfop.item.Modules.module2)
        genn++; 
    } 
   
    	String generation =  GuiNumberUtils.getString(this.tileentity.generating);
     
      this.fontRendererObj.drawString(generatingString + generation + " " + energyPerTickString, 50, 36, 13487565);
      if(gend !=0 && this.tileentity.sunIsUp)
      this.fontRendererObj.drawString(ModulesString + (gend * 20) + "%", 165, 36, 13487565);
      if(genn !=0 && !this.tileentity.sunIsUp)
          this.fontRendererObj.drawString(ModulesString + (gend * 20) + "%", 165, 36, 13487565);
     
    if (tierplus != 0 && tierplus - minus > 0 && this.tileentity.o > 0) {
      this.fontRendererObj.drawString(tierString + this.tileentity.o, 50, 46, 13487565);
      this.fontRendererObj.drawString(ModulesString4 + (tierplus - minus), 93, 46, 13487565);
    } else if (minus != 0 && tierplus - minus < 0 && this.tileentity.o > 0) {
      this.fontRendererObj.drawString(tierString + this.tileentity.o, 50, 46, 13487565);
      this.fontRendererObj.drawString(ModulesString5 + (minus - tierplus), 93, 46, 13487565);
    } else if (this.tileentity.o > 0) {
      this.fontRendererObj.drawString(tierString + this.tileentity.o, 50, 46, 13487565);
    } else if (this.tileentity.o == 0) {
      this.fontRendererObj.drawString(tierString + Character.MIN_VALUE, 50, 46, 13487565);
    } else {
      this.fontRendererObj.drawString(tierString + Character.MIN_VALUE, 50, 46, 13487565);
    } 
  }
  
  protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    if (this.tileentity.chargeSlots[8] != null && this.tileentity.chargeSlots[8].getItem() instanceof com.Denfop.item.Modules.module5) {
	      int g = this.tileentity.chargeSlots[8].getItemDamage();
	      if (g == 0) {
	        this.tileentity.solarType = 1;
	        if (this.tileentity.yCoord >= 130) {
	          this.mc.renderEngine.bindTexture(tex4);
	        } else {
	          this.mc.renderEngine.bindTexture(tex);
	        } 
	      } else if (g == 1) {
	        this.tileentity.solarType = 2;
	        if (this.tileentity.yCoord <= 40) {
	          this.mc.renderEngine.bindTexture(tex3);
	        } else {
	          this.mc.renderEngine.bindTexture(tex);
	        } 
	      } else if (g == 2) {
	        this.tileentity.solarType = 3;
	        if ((this.tileentity.getWorldObj()).provider.dimensionId == -1) {
	          this.mc.renderEngine.bindTexture(tex1);
	        } else {
	          this.mc.renderEngine.bindTexture(tex);
	        } 
	      } else if (g == 3) {
	        this.tileentity.solarType = 4;
	        if ((this.tileentity.getWorldObj()).provider.dimensionId == 1) {
	          this.mc.renderEngine.bindTexture(tex2);
	        } else {
	          this.mc.renderEngine.bindTexture(tex);
	        } 
	      } else if (g == 4) {
	        this.tileentity.solarType = 5;
	        this.mc.renderEngine.bindTexture(tex);
	      } else if (g == 5) {
	        this.tileentity.solarType = 6;
	        this.mc.renderEngine.bindTexture(tex);
	      } else if (g == 6) {
	        this.tileentity.solarType = 7;
	        if(this.tileentity.rain) {
	        this.mc.renderEngine.bindTexture(tex5);}else {
	        	this.mc.renderEngine.bindTexture(tex);
	        }
	      } else {
	        this.tileentity.solarType = 0;
	        this.mc.renderEngine.bindTexture(tex);
	      } 
	    } else {
	      this.tileentity.solarType = 0;
	      this.mc.renderEngine.bindTexture(tex);
	    } 
    int h = (this.width - this.xSize) / 2;
    int k = (this.height - this.ySize) / 2;
    drawTexturedModalRect(h, k, 0, 0, this.xSize, this.ySize);
    if (this.tileentity.storage > 0 || this.tileentity.storage <= this.tileentity.maxStorage) {
      float l = this.tileentity.gaugeEnergyScaled(24.0F);
      drawTexturedModalRect(h + 19, k + 24, 195, 0, (int)(l + 1.0F), 14);
    } 
    if (this.tileentity.skyIsVisible && this.tileentity.solarType != 3 && this.tileentity.solarType != 4) {
    	if(this.tileentity.rain == false) {
    	 if (this.tileentity.sunIsUp) {
        drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
      } else if (!this.tileentity.sunIsUp) {
        drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
      }  
    	}else {
    		if (this.tileentity.sunIsUp) {
    	        drawTexturedModalRect(h + 24, k + 42, 225, 15, 14, 14);
    	      } else if (!this.tileentity.sunIsUp) {
    	        drawTexturedModalRect(h + 24, k + 42, 240, 15, 14, 14);
    	      } 
    	}
    }
    if (this.tileentity.solarType == 3 && (this.tileentity.getWorldObj()).provider.dimensionId == -1)
      if (this.tileentity.sunIsUp) {
        drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
      } else if (!this.tileentity.sunIsUp) {
        drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
      }  
    if (this.tileentity.solarType == 3 && (this.tileentity.getWorldObj()).provider.dimensionId != -1)
      if (this.tileentity.sunIsUp) {
        drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
      } else if (!this.tileentity.sunIsUp) {
        drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
      }  
    if (this.tileentity.solarType == 4 && (this.tileentity.getWorldObj()).provider.dimensionId == 1)
      if (this.tileentity.sunIsUp) {
        drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
      } else if (!this.tileentity.sunIsUp) {
        drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
      }  
    if (this.tileentity.solarType == 4 && (this.tileentity.getWorldObj()).provider.dimensionId != 1)
      if (this.tileentity.sunIsUp) {
        drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
      } else if (!this.tileentity.sunIsUp) {
        drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
      }  
  }
  
  private static ResourceLocation tex = new ResourceLocation("supersolarpanel", "textures/gui/GUIAdvancedSolarPanel.png");
  
  private static ResourceLocation tex1 = new ResourceLocation("supersolarpanel", "textures/gui/GUInetherSolarPanel.png");
  
  private static ResourceLocation tex2 = new ResourceLocation("supersolarpanel", "textures/gui/GUIendSolarPanel.png");
  
  private static ResourceLocation tex3 = new ResourceLocation("supersolarpanel", "textures/gui/GUIearthSolarPanel.png");
  
  private static ResourceLocation tex4 = new ResourceLocation("supersolarpanel", "textures/gui/GUIaerSolarPanel.png");
  
  private static ResourceLocation tex5 = new ResourceLocation("supersolarpanel", "textures/gui/GUIrainSolarPanel.png");
}
