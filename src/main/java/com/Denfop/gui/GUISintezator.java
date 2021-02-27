

package com.Denfop.gui;

import org.lwjgl.opengl.GL11;

import com.Denfop.Config;
import com.Denfop.SuperSolarPanels;
import com.Denfop.api.IPanel;
import com.Denfop.container.ContainerSinSolarPanel;
import com.Denfop.integration.Avaritia.ItemAvSolarPanel;
import com.Denfop.integration.Avaritia.modules2;
import com.Denfop.integration.Botania.ItemBotSolarPanel;
import com.Denfop.integration.Botania.modules1;
import com.Denfop.integration.DE.ItemDESolarPanel;
import com.Denfop.item.Modules.module6;
import com.Denfop.item.base.ItemSSPSolarPanel;
import com.Denfop.tiles.base.TileSintezator;

import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GUISintezator extends GuiContainer
{
    public TileSintezator tileentity;
	
    private static ResourceLocation tex;


    
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

      
       int yy = 0;
    
       int[] myArray2; 
       int[] myArray3; 

       myArray2 = new int[10]; 
       myArray3 = new int[10]; 
       for(int i = 0; i <10;i++) {
       	if(this.tileentity.chargeSlots[i] != null && this.tileentity.chargeSlots[i].getItem() instanceof IPanel) {
       		ItemStack itemstack = this.tileentity.chargeSlots[i];
       		int meta = itemstack.getMaxDamage();
       		NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(itemstack);
       		int genday = nbt.getInteger("genday");
       		int gennight = nbt.getInteger("gennight");
       		
       		int storage = nbt.getInteger("storage");
       		int output = nbt.getInteger("output");
       	
       		int p = this.tileentity.chargeSlots[i].stackSize;
       		if(p <=  Config.limit) {
       			
       			myArray2[i] = storage* p;
       			myArray3[i] = output* p;
       			yy =1;
           		}else {
           			
           			myArray2[i] = storage*  Config.limit ;
           			myArray3[i]  = output*  Config.limit ;
           			yy =1;
           		}
       	}
       }
      
     
       
       
   int sum2 = 0;
   int sum3 = 0;
   for(int i = 0; i <9;i++) {
   	sum2 = sum2 + myArray2[i];
   	sum3 = sum3 + myArray3[i];
   	
   }

       		
       	     
      

if(sum2 < 2147000000 && yy != 0 && sum2 > 0) {
	float h = sum2;
	 float hh = 0;
	 int i = 0;
	 for(;h >= 10;i++) {
	 h =(float)( h / 10) ;

	
	 }
	 String maxstorage_1= "0";
	if(i >=3 && i <6 && sum2 >= 1000 && sum2 < 1000000) {
		hh=(sum2/(1000));
		 maxstorage_1= String.format("%.2fK", hh);	}
	else if(i >=6 && i <9&& sum2 >= 1000000 && sum2 < 1000000000) {
		hh= (sum2/(1000000));
	maxstorage_1= String.format("%.2fM", hh);	}
	else	if(i >=9 && i <12&& sum2 >= 1000000000 && sum2 < 2100000000) {
		hh= (sum2/(1000000));
		hh = hh /1000;
   maxstorage_1= String.format("%.2fG", hh);	}
		
		
	
		 float g = this.tileentity.storage;
		 float hhh = this.tileentity.storage;
		 float gg = 0;
		  i = 0;
		 for(;g >= 10;i++) {
		 g =( g / 10) ;

		
		 }
		 String maxstorage_2= "0";
		 if(i >=0 && i <3 && hhh <= 1000) {
			 
		 
				gg=(float)(hhh);
				 maxstorage_2= String.format("%.0f", gg);	}
		 else if(i >=3 && i <6 && hhh >= 1000 && hhh< 1000000) {
			gg=(hhh/(1000));
		 maxstorage_2= String.format("%.2fK", gg);	}
		else if(i >=6 && i <9&&hhh >= 1000000 && hhh < 1000000000) {
			gg= (hhh/(1000000));
maxstorage_2= String.format("%.2fM", gg);	}
		else	if(i >=9 && i <12&& hhh >= 1000000000 && hhh < 2100000000) {
			gg= (hhh/(1000000000));
maxstorage_2= String.format("%.2fG", gg);	}
	  this.fontRendererObj.drawString(storageString +maxstorage_2 + "/" +maxstorage_1, 50, 22, 13487565);




}else	if(sum2 > 2147000000 && yy != 0){	 
	
	float h = 2146999999;
	 float hh = 0;
	 int i = 0;
	 for(;h >= 10;i++) {
	 h =(float)( h / 10) ;

	
	 }
	 String maxstorage_1= "0";
	if(i >=3 && i <6 && sum2 >= 1000 && sum2 < 1000000) {
		hh=(float)(2146999999/(1000));
		 maxstorage_1= String.format("%.2fK", hh);	}
	else if(i >=6 && i <9&& sum2 >= 1000000 && sum2 < 1000000000) {
		hh= (float)(2146999999/(1000000));
	maxstorage_1= String.format("%.2fM", hh);	}
	else	if(i >=9 && i <12&& sum2 >= 1000000000 && sum2 < 2100000000) {
		hh= (float)(2146999999/(1000000000));
  maxstorage_1= String.format("%.2fG", hh);	}
		
		
	
		 float g = this.tileentity.storage;
		 float hhh = this.tileentity.storage;
		 float gg = 0;
		  i = 0;
		 for(;g >= 10;i++) {
		 g =(float)( g / 10) ;

		
		 }
		 String maxstorage_2= "0";
		 if(i >=0 && i <3 && hhh <= 1000) {
			 
		 
				gg=(float)(hhh);
				 maxstorage_2= String.format("%.0f", gg);	}
		 else if(i >=3 && i <6 && hhh >= 1000 && hhh< 1000000) {
			gg=(float)(hhh/(1000));
		 maxstorage_2= String.format("%.2fK", gg);	}
		else if(i >=6 && i <9&&hhh >= 1000000 && hhh < 1000000000) {
			gg= (float)(hhh/(1000000));
maxstorage_2= String.format("%.2fM", gg);	}
		else	if(i >=9 && i <12&& hhh >= 1000000000 && hhh < 2100000000) {
			gg= (float)(hhh/(1000000000));
maxstorage_2= String.format("%.2fG", gg);	}
	  this.fontRendererObj.drawString(storageString + maxstorage_2 + "/" +maxstorage_1, 50, 22, 13487565);



	
	

	}else if(sum2 < 0 && yy != 0 && this.tileentity.storage < 0) {
		
		 this.fontRendererObj.drawString(storageString + this.tileentity.storage + "/" + this.tileentity.maxStorage, 50, 22, 13487565);

	}
else {
	float h = 2146999999;
	 float hh = 0;
	 int i = 0;
	 for(;h >= 10;i++) {
	 h =(float)( h / 10) ;

	
	 }
	 String maxstorage_1= "0";
	if(i >=3 && i <6 && sum2 >= 1000 && sum2 < 1000000) {
		hh=(float)(2146999999/(1000));
		 maxstorage_1= String.format("%.2fK", hh);	}
	else if(i >=6 && i <9&& sum2 >= 1000000 && sum2 < 1000000000) {
		hh= (float)(2146999999/(1000000));
	maxstorage_1= String.format("%.2fM", hh);	}
	else	if(i >=9 && i <12&& sum2 >= 1000000000 && sum2 < 2100000000) {
		hh= (float)(2146999999/(1000000000));
 maxstorage_1= String.format("%.2fG", hh);	}
		
		
	
		 float g = this.tileentity.storage;
		 float hhh = this.tileentity.storage;
		 float gg = 0;
		  i = 0;
		 for(;g >= 10;i++) {
		 g =(float)( g / 10) ;

		
		 }
		 String maxstorage_2= "0";
		 if(i >=0 && i <3 && hhh <= 1000) {
			 
		 
				gg=(float)(hhh);
				 maxstorage_2= String.format("%.0f", gg);	}
		 else if(i >=3 && i <6 && hhh >= 1000 && hhh< 1000000) {
			gg=(float)(hhh/(1000));
		 maxstorage_2= String.format("%.2fK", gg);	}
		else if(i >=6 && i <9&&hhh >= 1000000 && hhh < 1000000000) {
			gg= (float)(hhh/(1000000));
maxstorage_2= String.format("%.2fM", gg);	}
		else	if(i >=9 && i <12&& hhh >= 1000000000 && hhh < 2100000000) {
			gg= (float)(hhh/(1000000000));
maxstorage_2= String.format("%.2fG", gg);	}
	  this.fontRendererObj.drawString(storageString + maxstorage_2 + "/" +maxstorage_1, 50, 22, 13487565);



		this.fontRendererObj.drawString(storageString + maxstorage_2 + "/" + maxstorage_1, 50, 22, 13487565);
	}
if(sum3 < 2147000000)	{
	 float g = sum3;
	 float hhh = sum3;
	 float gg = 0;
	int  i = 0;
	 for(;g >= 10;i++) {
	 g =(float)( g / 10) ;

	
	 }
	 String maxstorage_2= "0";
	 if(hhh >= 0 && hhh< 1000) {
		 
		 
			gg=(float)(hhh);
			 maxstorage_2= String.format("%.0f", gg);	}
	 if(i >=0 && i <3 && hhh >= 1000 && hhh< 1000000) {
		 
	 
			gg=(float)(hhh);
			 maxstorage_2= String.format("%.0f", gg);	}
	 else if(i >=3 && i <6 && hhh >= 1000 && hhh< 1000000) {
		gg=(float)(hhh/(1000));
	 maxstorage_2= String.format("%.2fK", gg);	}
	else if(i >=6 && i <9&&hhh >= 1000000 && hhh < 1000000000) {
		gg= (float)(hhh/(1000000));
maxstorage_2= String.format("%.2fM", gg);	}
	else	if(i >=9 && i <12&& hhh >= 1000000000 && hhh < 2100000000) {
		gg= (float)(hhh/(1000000000));
maxstorage_2= String.format("%.2fG", gg);	}
	 this.fontRendererObj.drawString(maxOutputString + maxstorage_2 + (" " + energyPerTickString), 50, 32, 13487565);
}else {   	 
	 float g = 2146999999;
	 float hhh = 2146999999;
	 float gg = 0;
	int  i = 0;
	 for(;g >= 10;i++) {
	 g =(float)( g / 10) ;

	
	 }
	 String maxstorage_2= "0";
	 if(hhh >= 0 && hhh< 1000) {
		 
		 
			gg=(float)(hhh);
			 maxstorage_2= String.format("%.2f", gg);	}
	 if(i >=0 && i <3 && hhh >= 1000 && hhh< 1000000) {
		 
	 
			gg=(float)(hhh);
			 maxstorage_2= String.format("%.2f", gg);	}
	 else if(i >=3 && i <6 && hhh >= 1000 && hhh< 1000000) {
		gg=(float)(hhh/(1000));
	 maxstorage_2= String.format("%.2fK", gg);	}
	else if(i >=6 && i <9&&hhh >= 1000000 && hhh < 1000000000) {
		gg= (float)(hhh/(1000000));
maxstorage_2= String.format("%.2fM", gg);	}
	else	if(i >=9 && i <12&& hhh >= 1000000000 && hhh < 2100000000) {
		gg= (float)(hhh/(1000000000));
maxstorage_2= String.format("%.2fG", gg);	}
	this.fontRendererObj.drawString(maxOutputString + maxstorage_2 + (" " + energyPerTickString), 50, 32, 13487565);

    }
if(this.tileentity.sunIsUp == true ) {
	  float g = this.tileentity.generating;
	 float hhh = this.tileentity.generating;
	 float gg = 0;
	int  i = 0;
	 for(;g >= 10;i++) {
	 g =(float)( g / 10) ;

	
	 }
	 String maxstorage_2= "0";
	 if(i >=0 && i <3 && hhh <= 1000) {
		 
	 
			gg=(float)(hhh);
			 maxstorage_2= String.format("%.0f", gg);	}
	 else if(i >=3 && i <6 && hhh >= 1000 && hhh< 1000000) {
		gg=(float)(hhh/(1000));
	 maxstorage_2= String.format("%.2fK", gg);	}
	else if(i >=6 && i <9&&hhh >= 1000000 && hhh < 1000000000) {
		gg= (float)(hhh/(1000000));
maxstorage_2= String.format("%.2fM", gg);	}
	else	if(i >=9 && i <12&& hhh >= 1000000000 && hhh < 2100000000) {
		gg= (float)(hhh/(1000000000));
maxstorage_2= String.format("%.2fG", gg);	}
	  this.fontRendererObj.drawString(generatingString + maxstorage_2 + (" " + energyPerTickString), 50, 42, 13487565);
}else if(this.tileentity.sunIsUp == false ) 
{
	  float g = this.tileentity.generating;
 float hhh = this.tileentity.generating;
 float gg = 0;
int  i = 0;
 for(;g >= 10;i++) {
 g =(float)( g / 10) ;


 }
 String maxstorage_2= "0";
 if(i >=0 && i <3 && hhh <= 1000) {
	 
 
		gg=(float)(hhh);
		 maxstorage_2= String.format("%.0f", gg);	}
 else if(i >=3 && i <6 && hhh >= 1000 && hhh< 1000000) {
	gg=(float)(hhh/(1000));
 maxstorage_2= String.format("%.2fK", gg);	}
else if(i >=6 && i <9&&hhh >= 1000000 && hhh < 1000000000) {
	gg= (float)(hhh/(1000000));
maxstorage_2= String.format("%.2fM", gg);	}
else	if(i >=9 && i <12&& hhh >= 1000000000 && hhh < 2100000000) {
	gg= (float)(hhh/(1000000000));
maxstorage_2= String.format("%.2fG", gg);	}
	 this.fontRendererObj.drawString(generatingString + maxstorage_2 + (" " + energyPerTickString), 50, 42, 13487565);
}


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
        GUISintezator.tex = new ResourceLocation("supersolarpanel", "textures/gui/GUI_Sintezator_Slots.png");
    }
}
