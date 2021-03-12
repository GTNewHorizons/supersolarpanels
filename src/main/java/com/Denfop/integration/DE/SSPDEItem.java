
package com.Denfop.integration.DE;

import java.util.List;

import com.Denfop.IUCore;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class SSPDEItem extends Item {

	public SSPDEItem() {
		this.setCreativeTab((CreativeTabs)IUCore.tabssp3);
	}

	public int getItemStackLimit() {
		return this.maxStackSize;
	}

	
  public boolean hasEffect(ItemStack par1ItemStack, int pass) {
	    return true;
	  }
}

