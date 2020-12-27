package ru.wirelesstools.fluidmachines;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import ru.wirelesstools.MainWV;

@SideOnly(Side.CLIENT)
public class TextureHooks {

	public static class Icons {
		public static IIcon xpJuiceStill;
		public static IIcon xpJuiceFlowing;
	}
	
/*	 public static void init()
	    {
	        MinecraftForge.EVENT_BUS.register(new TextureHooks());
	        
	    } */
	
	@SubscribeEvent
	 public void textureHook(TextureStitchEvent.Pre event) {
	  if (event.map.getTextureType() == 0) {
		  Icons.xpJuiceStill = event.map.registerIcon("wirelessvajra:xpliquid_still");
		  Icons.xpJuiceFlowing = event.map.registerIcon("wirelessvajra:xpjuice_flowing");
		  MainWV.FluidXP.xpJuice.setIcons(Icons.xpJuiceStill, Icons.xpJuiceFlowing);
		  
		  
	  }
	}
	
	
}
