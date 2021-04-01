package com.Denfop.item.Modules;

import java.util.List;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.api.module.IModulGenDay;
import com.Denfop.api.module.IModulOutput;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ModuleGenerationDay extends BaseModuleGenDay  {
	public ModuleGenerationDay(int percent) {
		super(percent);
		this.setCreativeTab((CreativeTabs) IUCore.tabssp1);
	}

	
	
}
  