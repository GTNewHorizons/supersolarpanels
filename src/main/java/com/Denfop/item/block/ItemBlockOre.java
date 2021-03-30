package com.Denfop.item.block;

import java.util.List;

import com.Denfop.IUCore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockOre extends ItemBlock {

	public ItemBlockOre(Block block) {
		super(block);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean isAdv) {

		list.add(StatCollector.translateToLocal("ssp.miny") + " " + 10);
		list.add(StatCollector.translateToLocal("ssp.maxy") + " " + 60);

	}

}