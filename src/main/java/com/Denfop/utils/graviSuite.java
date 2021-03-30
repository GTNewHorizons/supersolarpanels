package com.Denfop.utils;

import cpw.mods.fml.common.Loader;
import gravisuite.ItemGraviTool;
import ic2.core.item.tool.ItemToolWrench;
import net.minecraft.entity.player.EntityPlayer;

public class graviSuite {
	public static boolean gettrue(EntityPlayer player) {
	if(player.getHeldItem() == null)
		return false;
	
	return player.getHeldItem().getItem() instanceof ItemGraviTool || player.getHeldItem().getItem() instanceof ItemToolWrench;
	
	}
	public static boolean gettrue1(EntityPlayer player) {
		if(player.getHeldItem() == null)
			return false;
		
		return player.getHeldItem().getItem() instanceof ItemToolWrench;
	}
}
