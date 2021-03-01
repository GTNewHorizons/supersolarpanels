package com.Denfop.item.Modules;

import java.util.List;

import com.Denfop.Config;
import com.Denfop.SuperSolarPanels;
import com.Denfop.api.module.IModulOutput;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public class module4 extends Item implements IModulOutput {
	public module4() {
		this.setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp1);
		
	}
	
	public int getItemStackLimit() {
		return this.maxStackSize;
	}
	public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
		  info.add(StatCollector.translateToLocal("ssp.module4") + " " + IModulOutput.getData(itemStack).get(0)+"% "  + StatCollector.translateToLocal("ssp.module") );
		  info.add(StatCollector.translateToLocal("ssp.modules") );
		 
	 } 
	 public void getSubItems(final Item item, final CreativeTabs tabs, final List itemList) {
	        for (int meta = 0; meta <= 0; ++meta) {
	            final ItemStack stack = new ItemStack((Item)this, 1, meta);
	            IModulOutput.setData(stack,Config.percent_output);
	            itemList.add(stack);
	        }
	    }
}
