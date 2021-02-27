package com.Denfop.block.Base;



import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public class BlockSSP extends Block {
	public BlockSSP(Material material) {
		super(material);
		this.setCreativeTab(SuperSolarPanels.tabssp);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(0.3F);
		this.setLightLevel(0.3F);
		this.setStepSound(Block.soundTypeGlass);
	}
}
