

package com.Denfop.tiles.base;

import org.lwjgl.opengl.GL11;

import com.Denfop.module1;
import com.Denfop.module2;
import com.Denfop.module3;
import com.Denfop.module4;
import com.Denfop.module5;
import com.Denfop.module6;
import com.Denfop.item.base.ItemSSPSolarPanel;

import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GUISintezator extends GuiContainer
{
    public TileSintezator tileentity;
	
    private static ResourceLocation tex;

	private static ResourceLocation tex1;

	private static ResourceLocation tex2;

	private static ResourceLocation tex3;

	private static ResourceLocation tex4;

	private static ResourceLocation tex5;
    
    public GUISintezator(final InventoryPlayer inventoryplayer, final TileSintezator tileentitysolarpanel) {
        super((Container)new ContainerSinSolarPanel(inventoryplayer, tileentitysolarpanel));
        this.tileentity = tileentitysolarpanel;
        this.allowUserInput = false;
        this.xSize = 194;
        this.ySize = 168;
    }
    
    protected void drawGuiContainerForegroundLayer(final int par1, final int par2) {
        final String formatPanelName = I18n.format(this.tileentity.panelName, new Object[0]);
        final int nmPos = (this.xSize - this.fontRendererObj.getStringWidth(formatPanelName)) / 2;
        this.fontRendererObj.drawString(formatPanelName, nmPos, 7, 7718655);
        final String storageString = I18n.format("gui.AdvancedSolarPanel.storage", new Object[0]) + ": ";
        final String maxOutputString = I18n.format("gui.AdvancedSolarPanel.maxOutput", new Object[0]) + ": ";
        final String generatingString = I18n.format("gui.AdvancedSolarPanel.generating", new Object[0]) + ": ";
        final String energyPerTickString = I18n.format("gui.AdvancedSolarPanel.energyPerTick", new Object[0]);
        

      
        int v1 = 0; int v2 = 0; int v3 = 0; int v4 = 0; int v5 = 0; int v6 = 0; int v7 = 0; int v8 = 0; int v9 = 0; 
        int b1 = 0; int b2 = 0; int b3 = 0; int b4 = 0; int b5 = 0; int b6 = 0; int b7 = 0; int b8 = 0; int b9 = 0; 
      
        	
        if(this.tileentity.chargeSlots[0] != null && this.tileentity.chargeSlots[0].getItem() instanceof ItemSSPSolarPanel) {
    		int g = this.tileentity.chargeSlots[0].getItemDamage();
    		int p = this.tileentity.chargeSlots[0].stackSize;
    		if(this.tileentity.tier >= g+1) {
    		
    		v1 = module6.storage(g)*p;
    		b1 = module6.Output(g)*p;
    		}
    	
    }
    	if(this.tileentity.chargeSlots[1] != null && this.tileentity.chargeSlots[1].getItem() instanceof ItemSSPSolarPanel) {
    		int p = this.tileentity.chargeSlots[1].stackSize;
    		int kk = this.tileentity.chargeSlots[1].getItemDamage();
    		if(this.tileentity.tier >= kk+1) {
    		
    		v2 = module6.storage(kk)*p;
    		b2 = module6.Output(kk)*p;}
    	
    }
if(this.tileentity.chargeSlots[2] != null && this.tileentity.chargeSlots[2].getItem() instanceof ItemSSPSolarPanel) {
	int p = this.tileentity.chargeSlots[2].stackSize;
    		int kk = this.tileentity.chargeSlots[2].getItemDamage();
    		if(this.tileentity.tier >= kk+1) {
    		
    		v3 = module6.storage(kk)*p;
    		b3 = module6.Output(kk)*p;}
    	
    }
if(this.tileentity.chargeSlots[3] != null && this.tileentity.chargeSlots[3].getItem() instanceof ItemSSPSolarPanel) {
	int p = this.tileentity.chargeSlots[3].stackSize;
int kk = this.tileentity.chargeSlots[3].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v4 = module6.storage(kk)*p;
b4 = module6.Output(kk)*p;}

}
if(this.tileentity.chargeSlots[4] != null && this.tileentity.chargeSlots[4].getItem() instanceof ItemSSPSolarPanel) {
	int p = this.tileentity.chargeSlots[4].stackSize;
int kk = this.tileentity.chargeSlots[4].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v5 = module6.storage(kk)*p;
b5 = module6.Output(kk)*p;}

}
if(this.tileentity.chargeSlots[5] != null && this.tileentity.chargeSlots[5].getItem() instanceof ItemSSPSolarPanel) {
	int p = this.tileentity.chargeSlots[5].stackSize;
int kk = this.tileentity.chargeSlots[5].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v6 = module6.storage(kk)*p;
b6 = module6.Output(kk)*p;}

}
if(this.tileentity.chargeSlots[6] != null && this.tileentity.chargeSlots[6].getItem() instanceof ItemSSPSolarPanel) {
	int p = this.tileentity.chargeSlots[6].stackSize;
int kk = this.tileentity.chargeSlots[6].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v7 = module6.storage(kk)*p;
b7 = module6.Output(kk)*p;}

}
if(this.tileentity.chargeSlots[7] != null && this.tileentity.chargeSlots[7].getItem() instanceof ItemSSPSolarPanel) {
	int p = this.tileentity.chargeSlots[7].stackSize;
int kk = this.tileentity.chargeSlots[7].getItemDamage();
if(this.tileentity.tier >= kk+1) {
	
v8 = module6.storage(kk)*p;
b8 = module6.Output(kk)*p;}

}
if(this.tileentity.chargeSlots[8] != null && this.tileentity.chargeSlots[8].getItem() instanceof ItemSSPSolarPanel) {
	int p = this.tileentity.chargeSlots[8].stackSize;
int kk = this.tileentity.chargeSlots[8].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v9 = module6.storage(kk)*p;
b9 = module6.Output(kk)*p;}

}
if(v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 < 999999999) {
	  this.fontRendererObj.drawString(storageString + this.tileentity.storage + "/" +(int) (v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9), 50, 22, 13487565);
}else	{	  this.fontRendererObj.drawString(storageString + this.tileentity.storage + "/" + "999999999", 50, 22, 13487565);

	}
if(b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9 < 999999999)	{
	 this.fontRendererObj.drawString(maxOutputString + (b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9) + (" " + energyPerTickString), 50, 32, 13487565);
}else {   	 this.fontRendererObj.drawString(maxOutputString + "999999999" + (" " + energyPerTickString), 50, 32, 13487565);

    }
             this.fontRendererObj.drawString(generatingString + this.tileentity.generating + (" " + energyPerTickString), 50, 42, 13487565);
    }
    protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int j) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        
        
        
     
   		 this.mc.renderEngine.bindTexture(GUISintezator.tex);
        
        
       
       
        
       
        final int h = (this.width - this.xSize) / 2;
        final int k = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(h, k, 0, 0, this.xSize, this.ySize);
        if (this.tileentity.storage > 0 || this.tileentity.storage <= this.tileentity.maxStorage ) {
            final float l = this.tileentity.gaugeEnergyScaled(24);
           
            this.drawTexturedModalRect(h + 19, k + 24, 195, 0, (int) (l + 1), 14);
        }
        if (this.tileentity.skyIsVisible && this.tileentity.solarType != 3 && this.tileentity.solarType != 4) {
            if (this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
            }
            else if (!this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
            }
        }
       
        if (this.tileentity.solarType == 3 && this.tileentity.getWorldObj().provider.dimensionId == -1) {
            if (this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
            }
            else if (!this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
            }
        } 
        if (this.tileentity.solarType == 3 && this.tileentity.getWorldObj().provider.dimensionId != -1) {
            if (this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
            }
            else if (!this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
            }
        }
        if (this.tileentity.solarType == 4 && this.tileentity.getWorldObj().provider.dimensionId == 1) {
            if (this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
            }
            else if (!this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
            }
        } 
        if (this.tileentity.solarType == 4 && this.tileentity.getWorldObj().provider.dimensionId != 1) {
            if (this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
            }
            else if (!this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
            }
        } 
    }
    
    static {
        GUISintezator.tex = new ResourceLocation("supersolarpanel", "textures/gui/GUIAdvancedSolarPanel.png");
        GUISintezator.tex1 = new ResourceLocation("supersolarpanel", "textures/gui/GUInetherSolarPanel.png");
        GUISintezator.tex2 = new ResourceLocation("supersolarpanel", "textures/gui/GUIendSolarPanel.png");
        GUISintezator.tex3 = new ResourceLocation("supersolarpanel", "textures/gui/GUIearthSolarPanel.png");
        GUISintezator.tex4 = new ResourceLocation("supersolarpanel", "textures/gui/GUIaerSolarPanel.png");
        GUISintezator.tex5 = new ResourceLocation("supersolarpanel", "textures/gui/GUIrainSolarPanel.png");
    }
}
