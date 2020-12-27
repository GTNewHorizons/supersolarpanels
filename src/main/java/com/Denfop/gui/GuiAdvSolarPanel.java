

package com.Denfop.gui;

import org.lwjgl.opengl.GL11;

import com.Denfop.container.ContainerAdvSolarPanel;
import com.Denfop.item.Modules.module3;
import com.Denfop.item.Modules.module4;
import com.Denfop.item.Modules.module5;
import com.Denfop.item.Modules.module6;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiAdvSolarPanel extends GuiContainer
{
    public TileEntitySolarPanel tileentity;
	
    private static ResourceLocation tex;

	private static ResourceLocation tex1;

	private static ResourceLocation tex2;

	private static ResourceLocation tex3;

	private static ResourceLocation tex4;

	private static ResourceLocation tex5;
    
    public GuiAdvSolarPanel(final InventoryPlayer inventoryplayer, final TileEntitySolarPanel tileentitysolarpanel) {
        super((Container)new ContainerAdvSolarPanel(inventoryplayer, tileentitysolarpanel));
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
        

        int maxstorage1 = 0;
        int output = 0;
        
        for(int i= 0; i < 9; i++) {
            if(this.tileentity.chargeSlots[i] != null && this.tileentity.chargeSlots[i].getItem() instanceof module3)
        		maxstorage1++;
        	if(this.tileentity.chargeSlots[i] != null && this.tileentity.chargeSlots[i].getItem() instanceof module4)
        		output++;
        }
        int v1 = 0; int v2 = 0; int v3 = 0; int v4 = 0; int v5 = 0; int v6 = 0; int v7 = 0; int v8 = 0; int v9 = 0; 
        int b1 = 0; int b2 = 0; int b3 = 0; int b4 = 0; int b5 = 0; int b6 = 0; int b7 = 0; int b8 = 0; int b9 = 0; 
      
        	
        if(this.tileentity.chargeSlots[0] != null && this.tileentity.chargeSlots[0].getItem() instanceof module6) {
    		int g = this.tileentity.chargeSlots[0].getItemDamage();
    		if(this.tileentity.tier >= g+1) {
    		
    		v1 = module6.storage(g);
    		b1 = module6.Output(g);
    		}
    	
    }
    	if(this.tileentity.chargeSlots[1] != null && this.tileentity.chargeSlots[1].getItem() instanceof module6) {
    		
    		int kk = this.tileentity.chargeSlots[1].getItemDamage();
    		if(this.tileentity.tier >= kk+1) {
    		
    		v2 = module6.storage(kk);
    		b2 = module6.Output(kk);}
    	
    }
if(this.tileentity.chargeSlots[2] != null && this.tileentity.chargeSlots[2].getItem() instanceof module6) {
    		
    		int kk = this.tileentity.chargeSlots[2].getItemDamage();
    		if(this.tileentity.tier >= kk+1) {
    		
    		v3 = module6.storage(kk);
    		b3 = module6.Output(kk);}
    	
    }
if(this.tileentity.chargeSlots[3] != null && this.tileentity.chargeSlots[3].getItem() instanceof module6) {

int kk = this.tileentity.chargeSlots[3].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v4 = module6.storage(kk);
b4 = module6.Output(kk);}

}
if(this.tileentity.chargeSlots[4] != null && this.tileentity.chargeSlots[4].getItem() instanceof module6) {

int kk = this.tileentity.chargeSlots[4].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v5 = module6.storage(kk);
b5 = module6.Output(kk);}

}
if(this.tileentity.chargeSlots[5] != null && this.tileentity.chargeSlots[5].getItem() instanceof module6) {

int kk = this.tileentity.chargeSlots[5].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v6 = module6.storage(kk);
b6 = module6.Output(kk);}

}
if(this.tileentity.chargeSlots[6] != null && this.tileentity.chargeSlots[6].getItem() instanceof module6) {

int kk = this.tileentity.chargeSlots[6].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v7 = module6.storage(kk);
b7 = module6.Output(kk);}

}
if(this.tileentity.chargeSlots[7] != null && this.tileentity.chargeSlots[7].getItem() instanceof module6) {

int kk = this.tileentity.chargeSlots[7].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v8 = module6.storage(kk);
b8 = module6.Output(kk);}

}
if(this.tileentity.chargeSlots[8] != null && this.tileentity.chargeSlots[8].getItem() instanceof module6) {

int kk = this.tileentity.chargeSlots[8].getItemDamage();
if(this.tileentity.tier >= kk+1) {
v9 = module6.storage(kk);
b9 = module6.Output(kk);}

}
if((int) ((this.tileentity.p + v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9) + (this.tileentity.p +  v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9)*0.2*maxstorage1) < 999999999) {
	  this.fontRendererObj.drawString(storageString + this.tileentity.storage + "/" +(int) ((this.tileentity.p + v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9) + (this.tileentity.p +  v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9)*0.2*maxstorage1), 50, 22, 13487565);
}else	{	  this.fontRendererObj.drawString(storageString + this.tileentity.storage + "/" + "999999999", 50, 22, 13487565);

	}
if((int) ((this.tileentity.u +  b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9) + (this.tileentity.u +  b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9)*0.2*output) < 999999999)	{
	 this.fontRendererObj.drawString(maxOutputString + (int) ((this.tileentity.u +  b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9) + (this.tileentity.u +  b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9)*0.2*output) + (" " + energyPerTickString), 50, 32, 13487565);
}else {   	 this.fontRendererObj.drawString(maxOutputString + "999999999" + (" " + energyPerTickString), 50, 32, 13487565);

    }
             this.fontRendererObj.drawString(generatingString + this.tileentity.generating + (" " + energyPerTickString), 50, 42, 13487565);
    }
    protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int j) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        
        
        if(this.tileentity.chargeSlots[8] != null && this.tileentity.chargeSlots[8].getItem() instanceof module5) {
        	int g = this.tileentity.chargeSlots[8].getItemDamage();
        	if( g == 0) {
        		this.tileentity.solarType =1;
        		if(this.tileentity.yCoord >=130) {
        	        this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex4);}
        	        	else {
        	        		this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex);
        	        	}
        	}
        	else if( g == 1) {
        		this.tileentity.solarType =2;
        		if(this.tileentity.yCoord <=40) {
        	        this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex3);}
        	        	else {
        	        		this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex);
        	        	}
        	}
        	else if( g == 2) {
        		this.tileentity.solarType =3;
        		if(this.tileentity.getWorldObj().provider.dimensionId == -1) {
        	        this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex1);}
        	        	else {
        	        		this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex);
        	        	}
        	}
        	else if( g == 3) {
        		this.tileentity.solarType =4;
        		if(this.tileentity.getWorldObj().provider.dimensionId == 1) {
        	        this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex2);}
        	        	else {
        	        		this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex);
        	        	}
        	}
        	else if( g == 4) {
        		this.tileentity.solarType =5;
        		 this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex);
        	}
        	else if( g == 5) {
        		this.tileentity.solarType =6;
        		 this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex);
        	}
        	else	if( g == 6) {
        		this.tileentity.solarType =7;
        		this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex5);
        	}
        	else {
        		this.tileentity.solarType = 0;
        		 this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex);
        	}
        
        }else {
        this.tileentity.solarType = 0;
   		 this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex);
        }
        
       
       
        
       
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
        GuiAdvSolarPanel.tex = new ResourceLocation("supersolarpanel", "textures/gui/GUIAdvancedSolarPanel.png");
        GuiAdvSolarPanel.tex1 = new ResourceLocation("supersolarpanel", "textures/gui/GUInetherSolarPanel.png");
        GuiAdvSolarPanel.tex2 = new ResourceLocation("supersolarpanel", "textures/gui/GUIendSolarPanel.png");
        GuiAdvSolarPanel.tex3 = new ResourceLocation("supersolarpanel", "textures/gui/GUIearthSolarPanel.png");
        GuiAdvSolarPanel.tex4 = new ResourceLocation("supersolarpanel", "textures/gui/GUIaerSolarPanel.png");
        GuiAdvSolarPanel.tex5 = new ResourceLocation("supersolarpanel", "textures/gui/GUIrainSolarPanel.png");
    }
}
