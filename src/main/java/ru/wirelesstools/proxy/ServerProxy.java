package ru.wirelesstools.proxy;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ru.wirelesstools.fluidmachines.TileExpGen2;
import ru.wirelesstools.fluidmachines.TileXPGenPublic;


public class ServerProxy implements IGuiHandler {
	
	public static void Init() {
		
	}

	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity te = world.getTileEntity(x, y, z);
		
		if (te != null) {
			
			if(te instanceof TileExpGen2) {
				
				return ((TileExpGen2) te).getGuiContainer(player.inventory);			
			}
			
			return null;
		}
		
		return null;
	}

	
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		return null;
	}

}
