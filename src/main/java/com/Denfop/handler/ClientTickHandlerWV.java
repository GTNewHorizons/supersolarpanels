package com.Denfop.handler;

import com.Denfop.SuperSolarPanels;

import cpw.mods.fml.client.FMLClientHandler;
import ic2.api.item.ElectricItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ClientTickHandlerWV {
	
	public static Minecraft mc = FMLClientHandler.instance().getClient();
	
	
	public static void onTickRender() {
		EntityClientPlayerMP entityClientPlayer = mc.thePlayer;
		
		
	if(mc.theWorld != null && mc.inGameHasFocus && !mc.gameSettings.showDebugInfo)
	{
			
			ItemStack stack = entityClientPlayer.getHeldItem();
			int xPos = 0;
			int yPos = 0;
			int xPos2 = 0;
			int yPos2 = 0;
			int elevelFontWidth = 0;
			int yOffset = 1;
			if (stack != null && stack.getItem() == SuperSolarPanels.wirelessVajra) {
				int currCharge = (int) ElectricItem.manager.getCharge(stack);
				String scharge = Integer.toString(currCharge);
				String elevelname = I18n.format("message.text.vajra.energyLevel", new Object[0]) + ": ";
				String stringCharge = elevelname + scharge + " Eu";
				
			if(SuperSolarPanels.hudPos == 1)	{
				xPos =2;
				yPos =2;
				xPos2=2;
				yPos2 = 1 + yOffset + mc.fontRenderer.FONT_HEIGHT;
				mc.ingameGUI.drawString(mc.fontRenderer, stringCharge, xPos2, yPos2, 16777215);
				
			}
			// TODO 2	
				
				
			}
		
			
				
				
				
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
