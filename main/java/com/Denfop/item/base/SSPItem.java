
package com.Denfop.item.base;

import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class SSPItem extends Item {

	public SSPItem() {
		this.setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp);
	}

	public int getItemStackLimit() {
		return this.maxStackSize;
	}

	

}
