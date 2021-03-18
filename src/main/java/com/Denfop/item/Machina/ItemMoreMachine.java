package com.Denfop.item.Machina;

import java.util.List;

import com.Denfop.IUCore;
import com.Denfop.block.mechanism.BlockBaseMachine;
import com.Denfop.block.mechanism.BlockMoreMachine;
import com.Denfop.tiles.Mechanism.EnumMultiMachine;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemMoreMachine extends ItemBlock {
	public ItemMoreMachine(Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
		  this.setCreativeTab(IUCore.tabssp);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return "ssp.block" + BlockMoreMachine.names[itemstack.getItemDamage()];
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {		
		info.add(StatCollector.translateToLocal("ic2.item.tooltip.power") + " " + EnumMultiMachine.values()[itemStack.getItemDamage()].usagePerTick + " EU/t, 32 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
	}

	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < BlockMoreMachine.names.length; i++)
			par3List.add(new ItemStack(par1, 1, i));
	}
}
