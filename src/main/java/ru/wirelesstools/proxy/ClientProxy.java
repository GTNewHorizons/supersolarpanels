package ru.wirelesstools.proxy;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import ru.wirelesstools.fluidmachines.TextureHooks;
import ru.wirelesstools.fluidmachines.TileExpGen2;
import ru.wirelesstools.fluidmachines.TileXPGenPublic;
import ru.wirelesstools.gui.GuiExpGen;

public class ClientProxy extends ServerProxy {
	
	
	@SideOnly(Side.CLIENT)
	public static void Init() {
		
		MinecraftForge.EVENT_BUS.register(new TextureHooks());
		
	}
	
	
	
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		
		if (te != null) {
			
		
			if(te instanceof TileExpGen2) {
				
				return new GuiExpGen(player.inventory, (TileExpGen2) te, x, y, z, world);
				
			}
		
			return null;
		}
		
		
		
		return null;
	}

}
