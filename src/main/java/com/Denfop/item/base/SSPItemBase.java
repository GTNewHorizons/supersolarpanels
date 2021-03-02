
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

public class SSPItemBase extends Item {

	public SSPItemBase() {
		this.setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp3);
	}

	public int getItemStackLimit() {
		return this.maxStackSize;
	}

	

}
