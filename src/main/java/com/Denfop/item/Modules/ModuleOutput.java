package com.Denfop.item.Modules;

import java.util.List;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.api.module.IModulOutput;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public class ModuleOutput extends BaseModuleOutput {
	public ModuleOutput(int percent) {
		super(percent);
		this.setCreativeTab((CreativeTabs) IUCore.tabssp1);
	}

	
}
