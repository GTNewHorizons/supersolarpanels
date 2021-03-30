package com.Denfop.integration.Avaritia;

import com.Denfop.IUItem;
import com.Denfop.IUCore;
import com.Denfop.integration.Botania.TileEntityElementumSolarPanel;
import com.Denfop.integration.Botania.TileEntityManasteelSolarPanel;
import com.Denfop.integration.DE.ItemDESolarPanel;
import com.Denfop.integration.DE.SSPDEItem;
import com.Denfop.integration.DE.blockDESolarPanel;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.brandon3055.draconicevolution.common.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.items.LudicrousItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class AvaritiaIntegration {

	public static Block blockAvSolarPanel;
	public static Item neutroncore;
	public static Item infinitycore;

	public static void init() {
		GameRegistry.registerBlock(blockAvSolarPanel = (Block) new blockAvaritiaSolarPanel(),
				(Class) ItemAvaritiaSolarPanel.class, "blockAvSolarPanel");
		GameRegistry.registerItem(neutroncore = new SSPDEItem().setMaxStackSize(64).setUnlocalizedName("neutroncore")
				.setTextureName("supersolarpanel:neutroncore"), "neutroncore");
		GameRegistry.registerItem(infinitycore = new SSPDEItem().setMaxStackSize(64).setUnlocalizedName("infinitycore")
				.setTextureName("supersolarpanel:infinitycore"), "infinitycore");
		GameRegistry.registerTileEntity((Class) TileEntityNeutronSolarPanel.class, "Neutron Solar Panel Avaritia");
		GameRegistry.registerTileEntity((Class) TileEntityInfinitySolarPanel.class, "Infinity Solar Panel");

	}

	public static void recipe() {
		GameRegistry.addRecipe(new ItemStack(blockAvSolarPanel, 1, 0), new Object[] { " B ", "BAB", " B ", 'B',
				new ItemStack(IUItem.blockSSPSolarPanel, 1, 8), 'A', neutroncore });
		GameRegistry.addRecipe(new ItemStack(blockAvSolarPanel, 1, 1),
				new Object[] { " B ", "BAB", " B ", 'B', new ItemStack(blockAvSolarPanel, 1, 0), 'A', infinitycore });

		GameRegistry.addRecipe(new ItemStack(neutroncore, 1), new Object[] { " A ", "ABA", " A ", 'B',
				new ItemStack(IUItem.protoncore, 1), 'A', new ItemStack(LudicrousItems.resource, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(infinitycore, 1), new Object[] { "BAB", "ABA", "BAB", 'B',
				new ItemStack(neutroncore, 1), 'A', new ItemStack(LudicrousItems.resource, 1, 6) });

	}

}
