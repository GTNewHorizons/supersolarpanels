package com.Denfop.Register;

import com.Denfop.IUItem;
import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.IUItem;
import com.Denfop.block.AdminPanel.Adminsolarpanel;
import com.Denfop.block.AdminPanel.ItemAdminSolarPanel;
import com.Denfop.block.Base.BlockElectric;
import com.Denfop.block.Base.BlockSSP;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.block.Chargepad.BlockChargepad;
import com.Denfop.block.Chargepad.ItemBlockChargepad;
import com.Denfop.block.RadiationBlock.RadiationBlock;
import com.Denfop.block.Sintezator.ItemSintezator;
import com.Denfop.block.Sintezator.Sintezator;
import com.Denfop.block.cable.BlockCable;
import com.Denfop.block.mechanism.BlockBaseMachine;
import com.Denfop.block.mechanism.BlockMoreMachine;
import com.Denfop.block.mechanism.BlockMoreMachine2;
import com.Denfop.block.ore.*;
import com.Denfop.item.ItemCell;
import com.Denfop.item.ItemSSPCrafring;
import com.Denfop.item.Machina.ItemBaseMachine;
import com.Denfop.item.Machina.ItemMoreMachine;
import com.Denfop.item.Machina.ItemMoreMachine2;
import com.Denfop.item.Modules.QuarryModule;
import com.Denfop.item.RadionBlock.ItemToriyOre;
import com.Denfop.item.armour.ItemSolarPanelHelmet;
import com.Denfop.item.base.*;
import com.Denfop.item.block.ItemBlockOre;
import com.Denfop.item.energy.EnergyAxe;
import com.Denfop.item.energy.EnergyPickaxe;
import com.Denfop.item.energy.EnergyShovel;
import com.Denfop.item.matter.SolidMatter;
import com.Denfop.item.reactor.ItemRadioactive;
import com.Denfop.tiles.Mechanism.*;
import com.Denfop.tiles.NeutroniumGenerator.TileneutronGenerator;
import com.Denfop.tiles.Sintezator.TileEntitySintezator;
import com.Denfop.tiles.base.*;
import com.Denfop.tiles.overtimepanel.*;
import com.Denfop.tiles.wiring.Chargepad.*;
import com.Denfop.tiles.wiring.Storage.*;
import com.Denfop.utils.NBTData;
import com.Denfop.tiles.wiring.Storage.*;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Register {
	public static void register() {

		GameRegistry.registerBlock(
				IUItem.toriyore = new RadiationBlock().setBlockTextureName("supersolarpanel:toriyore")
						.setHardness(0.6f).setStepSound(Block.soundTypeStone).setBlockName("toriyore"),
				(Class) ItemToriyOre.class, "toriyore");

		GameRegistry.registerItem(IUItem.magnesium_ingot = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("magnesium_ingot").setTextureName("supersolarpanel:magnesium_ingot"),
				"magnesium_ingot");
		GameRegistry.registerItem(IUItem.magnesium_plate = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("magnesium_plate").setTextureName("supersolarpanel:magnesium_plate"),
				"magnesium_plate");
		GameRegistry.registerItem(IUItem.magnesium_nugget = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("magnesium_nugget").setTextureName("supersolarpanel:magnesium_nugget"),
				"magnesium_nugget");
		GameRegistry.registerItem(IUItem.caravky_ingot = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("caravky").setTextureName("supersolarpanel:caravky"), "caravky");

		GameRegistry
				.registerItem(
						IUItem.advanced_core = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("advanced_core").setTextureName("supersolarpanel:advanced_core"),
						"advanced_core");
		GameRegistry.registerItem(IUItem.hybrid_core = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("hybrid_core").setTextureName("supersolarpanel:hybrid_core"), "hybrid_core");
		GameRegistry
				.registerItem(
						IUItem.ultimate_core = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("ultimate_core").setTextureName("supersolarpanel:ultimate_core"),
						"ultimate_core");
		GameRegistry.registerItem(
				IUItem.spectralSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND,
						IUCore.proxy.addArmor("spectralSolarHelmet"), 0, 4).setUnlocalizedName("spectralSolarHelmet"),
				"spectral_solar_helmet");
		GameRegistry.registerItem(
				IUItem.singularSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND,
						IUCore.proxy.addArmor("singularSolarHelmet"), 0, 5).setUnlocalizedName("singularSolarHelmet"),
				"singular_solar_helmet");
		GameRegistry.registerBlock(IUItem.blockSSPSolarPanel = (Block) new BlockSSPSolarPanel(),
				(Class) ItemSSPSolarPanel.class, "BlockSSPSolarPanel");

		GameRegistry.registerItem(IUItem.enderquantumcomponent = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("Ender-QuantumComponent").setTextureName("supersolarpanel:enderquantumcomponent"),
				"enderquantumcomponent");

		GameRegistry.registerBlock(IUItem.blockadmin = (Block) new Adminsolarpanel(),
				(Class) ItemAdminSolarPanel.class, "Aminpanel");
		GameRegistry.registerBlock(IUItem.machines = (Block) new BlockBaseMachine(), (Class) ItemBaseMachine.class,
				"machines");
		GameRegistry.registerBlock(IUItem.electricblock = (Block) new BlockElectric(), (Class) ItemElectricBlock.class,
				"electricblock");
		GameRegistry.registerBlock(IUItem.Chargepadelectricblock = (Block) new BlockChargepad(),
				(Class) ItemBlockChargepad.class, "BlockChargepad");

		GameRegistry.registerItem(IUItem.singularcore = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("singularcore").setTextureName("supersolarpanel:singularcore"), "singularcore");
		GameRegistry.registerItem(IUItem.spectralcore = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("spectralcore").setTextureName("supersolarpanel:spectralcore"), "spectralcore");
		GameRegistry.registerItem(IUItem.photoniy = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("photoniy").setTextureName("supersolarpanel:photoniy"), "photoniy");
		GameRegistry
				.registerItem(
						IUItem.photoniy_ingot = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("photoniy_ingot").setTextureName("supersolarpanel:photoniy_ingot"),
						"photoniy_ingot");
		GameRegistry.registerItem(IUItem.dust = new SSPItemBase().setMaxStackSize(64).setUnlocalizedName("dust")
				.setTextureName("supersolarpanel:dust"), "dust");
		//
		GameRegistry.registerItem(IUItem.spinelcrushedore = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("spinelcrushedore").setTextureName("supersolarpanel:spinelcrushedore"),
				"spinelcrushedore");
		GameRegistry.registerItem(
				IUItem.platiumcrushedore = new SSPItemBase().setMaxStackSize(64)
						.setUnlocalizedName("platiumcrushedore").setTextureName("supersolarpanel:platiumcrushedore"),
				"platiumcrushedore");
		GameRegistry.registerItem(IUItem.nickelcrushedore = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("nickelcrushedore").setTextureName("supersolarpanel:nickelcrushedore"),
				"nickelcrushedore");
		GameRegistry.registerItem(IUItem.magnesiumcrushedore = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("magnesiumcrushedore").setTextureName("supersolarpanel:magnesiumcrushedore"),
				"magnesiumcrushedore");
		GameRegistry.registerItem(
				IUItem.wolframcrushedore = new SSPItemBase().setMaxStackSize(64)
						.setUnlocalizedName("wolframcrushedore").setTextureName("supersolarpanel:wolframcrushedore"),
				"wolframcrushedore");
		GameRegistry.registerItem(
				IUItem.iridiumcrushedore = new SSPItemBase().setMaxStackSize(64)
						.setUnlocalizedName("iridiumcrushedore").setTextureName("supersolarpanel:iridiumcrushedore"),
				"iridiumcrushedore");
		//

		GameRegistry
				.registerItem(
						IUItem.iridium_nugget = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("iridium_nugget").setTextureName("supersolarpanel:iridium_nugget"),
						"iridium_nugget");
		GameRegistry
				.registerItem(
						IUItem.michail_plate = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("michail_plate").setTextureName("supersolarpanel:michail_plate"),
						"michail_plate");
		GameRegistry
				.registerItem(
						IUItem.mikhail_ingot = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("mikhail_ingot").setTextureName("supersolarpanel:mikhail_ingot"),
						"mikhail_ingot");
		GameRegistry
				.registerItem(
						IUItem.mikhail_nugget = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("mikhail_nugget").setTextureName("supersolarpanel:mikhail_nugget"),
						"mikhail_nugget");
		GameRegistry
				.registerItem(
						IUItem.platium_ingot = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("platium_ingot").setTextureName("supersolarpanel:platium_ingot"),
						"platium_ingot");
		GameRegistry
				.registerItem(
						IUItem.platium_nugget = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("platium_nugget").setTextureName("supersolarpanel:platium_nugget"),
						"platium_nugget");
		GameRegistry
				.registerItem(
						IUItem.platium_plate = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("platium_plate").setTextureName("supersolarpanel:platium_plate"),
						"platium_plate");
		GameRegistry.registerItem(IUItem.spinel_ingot = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("spinel_ingot").setTextureName("supersolarpanel:spinel_ingot"), "spinel_ingot");
		GameRegistry
				.registerItem(
						IUItem.spinel_nugget = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("spinel_nugget").setTextureName("supersolarpanel:spinel_nugget"),
						"spinel_nugget");
		GameRegistry.registerItem(IUItem.spinel_plate = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("spinel_plate").setTextureName("supersolarpanel:spinel_plate"), "spinel_plate");
		GameRegistry
				.registerItem(
						IUItem.wolfram_ingot = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("wolfram_ingot").setTextureName("supersolarpanel:wolfram_ingot"),
						"wolfram_ingot");
		GameRegistry
				.registerItem(
						IUItem.wolfram_nugget = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("wolfram_nugget").setTextureName("supersolarpanel:wolfram_nugget"),
						"wolfram_nugget");
		GameRegistry
				.registerItem(
						IUItem.chromium_ingot = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("chromium_ingot").setTextureName("supersolarpanel:chromium_ingot"),
						"chromium_ingot");
		GameRegistry.registerItem(IUItem.chromium_nugget = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("chromium_nugget").setTextureName("supersolarpanel:chromium_nugget"),
				"chromium_nugget");
		GameRegistry
				.registerItem(
						IUItem.chromium_plate = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("chromium_plate").setTextureName("supersolarpanel:chromium_plate"),
						"chromium_plate");

		GameRegistry.registerBlock(
				IUItem.iridiumore = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:iridiumore")
						.setStepSound(Block.soundTypeStone).setBlockName("iridiumore"),
				ItemBlockOre.class, "iridiumore");
		GameRegistry.registerBlock(
				IUItem.endiridium_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endiridium_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endiridium_stone"), "endiridium_stone");
		GameRegistry.registerBlock(
				IUItem.netheriridiumrack = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:netheriridiumrack")
						.setStepSound(Block.soundTypeStone).setBlockName("netheriridiumrack"), "netheriridiumrack");
		GameRegistry.registerBlock(
				IUItem.endplatium_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endplatium_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endplatium_stone"), "endplatium_stone");
		GameRegistry.registerBlock(
				IUItem.netherplatiumrack = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:netherplatiumrack")
						.setStepSound(Block.soundTypeStone).setBlockName("netherplatiumrack"), "netherplatiumrack");
		GameRegistry.registerBlock(
				IUItem.endchromium_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endchromium_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endchromium_stone"), "endchromium_stone");
		GameRegistry.registerBlock(
				IUItem.netherchromiumrack = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:netherchromiumrack")
						.setStepSound(Block.soundTypeStone).setBlockName("netherchromiumrack"), "netherchromiumrack");
		GameRegistry.registerBlock(
				IUItem.endwolfram_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endwolfram_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endwolfram_stone"), "endwolfram_stone");
		GameRegistry.registerBlock(
				IUItem.netherwolfram_rack = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:netherwolfram_rack")
						.setStepSound(Block.soundTypeStone).setBlockName("netherwolfram_rack"), "netherwolfram_rack");
		GameRegistry.registerBlock(
				IUItem.endmagnesium_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endmagnesium_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endmagnesium_stone"), "endmagnesium_stone");
		GameRegistry.registerBlock(
				IUItem.nethermagnesiumrack = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:nethermagnesiumrack")
						.setStepSound(Block.soundTypeStone).setBlockName("nethermagnesiumrack"), "nethermagnesiumrack");
		GameRegistry.registerBlock(
				IUItem.endspinel_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endspinel_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endspinel_stone"), "endspinel_stone");
		GameRegistry.registerBlock(
				IUItem.netherspinelrack = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:netherspinelrack")
						.setStepSound(Block.soundTypeStone).setBlockName("netherspinelrack"), "netherspinelrack");
		GameRegistry.registerBlock(
				IUItem.endmikhail_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endmikhail_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endmikhail_stone"), "endmikhail_stone");
		GameRegistry.registerBlock(
				IUItem.nethermikhailrack = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:nethermikhailrack")
						.setStepSound(Block.soundTypeStone).setBlockName("nethermikhailrack"), "nethermikhailrack");
		GameRegistry.registerBlock(
				IUItem.wolframore = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:wolframore")
						.setStepSound(Block.soundTypeStone).setBlockName("wolframore"),
				ItemBlockOre.class, "wolframore");
		GameRegistry.registerBlock(
				IUItem.chromiumore = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:chromiumore")
						.setStepSound(Block.soundTypeStone).setBlockName("chromiumore"),
				ItemBlockOre.class, "chromiumore");
		GameRegistry.registerBlock(
				IUItem.platiumore = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:platiumore")
						.setStepSound(Block.soundTypeStone).setBlockName("platiumore"),
				ItemBlockOre.class, "platiumore");
		GameRegistry.registerBlock(
				IUItem.magnesiumore = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:magnesiumore")
						.setStepSound(Block.soundTypeStone).setBlockName("magnesiumore"),
				ItemBlockOre.class, "magnesiumore");

		GameRegistry.registerBlock(
				IUItem.mikhail_ore = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:mikhail_ore")
						.setStepSound(Block.soundTypeStone).setBlockName("mikhail_ore"),
				ItemBlockOre.class, "mikhail_ore");
		GameRegistry
				.registerBlock(
						IUItem.spinelore = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:spinelore")
								.setStepSound(Block.soundTypeStone).setBlockName("spinelore"),
						ItemBlockOre.class, "spinelore");

		GameRegistry.registerBlock(
				IUItem.endgold_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endgold_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endgold_stone"),
				"endgold_stone");
		//
		GameRegistry.registerBlock(
				IUItem.magnetitore = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:magnetitore")
						.setStepSound(Block.soundTypeStone).setBlockName("magnetitore"),
				ItemBlockOre.class, "magnetitore");
		GameRegistry
				.registerBlock(
						IUItem.nicelore = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:nicelore")
								.setStepSound(Block.soundTypeStone).setBlockName("nicelore"),
						ItemBlockOre.class, "nicelore");

		//
		GameRegistry.registerBlock(IUItem.nethergoldrack = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:nethergoldrack").setStepSound(Block.soundTypeStone)
				.setBlockName("nethergoldrack"), "nethergoldrack");

		GameRegistry.registerBlock(IUItem.netherironrack = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:netherironrack").setStepSound(Block.soundTypeStone)
				.setBlockName("netherironrack"), "netherironrack");

		GameRegistry.registerBlock(
				IUItem.endiron_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endiron_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endiron_stone"),
				"endiron_stone");

		GameRegistry.registerBlock(IUItem.netherlapisrack = new BlockSSPLapis(Material.rock)
				.setBlockTextureName("supersolarpanel:netherlapisrack").setStepSound(Block.soundTypeStone)
				.setBlockName("netherlapisrack"), "netherlapisrack");

		GameRegistry.registerBlock(IUItem.endlapis_stone = new BlockSSPLapis(Material.rock)
				.setBlockTextureName("supersolarpanel:endlapis_stone").setStepSound(Block.soundTypeStone)
				.setBlockName("endlapis_stone"), "endlapis_stone");

		GameRegistry
				.registerBlock(
						IUItem.netheremeraldrack = new BlockSSPEmerald(Material.rock)
								.setBlockTextureName("supersolarpanel:netheremeraldrack")
								.setStepSound(Block.soundTypeStone).setBlockName("netheremeraldrack"),
						"netheremeraldrack");

		GameRegistry
				.registerBlock(
						IUItem.nethercopperrack = new BlockOre(Material.rock)
								.setBlockTextureName("supersolarpanel:nethercopperrack")
								.setStepSound(Block.soundTypeStone).setBlockName("nethercopperrack"),
						"nethercopperrack");

		GameRegistry.registerBlock(
				IUItem.enduran_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:enduran_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("enduran_stone"),
				"enduran_stone");

		GameRegistry
				.registerBlock(
						IUItem.enddiamond_stone = new BlockSSPDiamond(Material.rock)
								.setBlockTextureName("supersolarpanel:enddiamond_stone")
								.setStepSound(Block.soundTypeStone).setBlockName("enddiamond_stone"),
						"enddiamond_stone");

		GameRegistry.registerBlock(IUItem.netheruranrack = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:netheruranrack").setStepSound(Block.soundTypeStone)
				.setBlockName("netheruranrack"), "netheruranrack");

		GameRegistry.registerBlock(
				IUItem.endtin_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endtin_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endtin_stone"),
				"endtin_stone");

		GameRegistry
				.registerBlock(
						IUItem.netherdiamondrack = new BlockSSPDiamond(Material.rock)
								.setBlockTextureName("supersolarpanel:netherdiamondrack")
								.setStepSound(Block.soundTypeStone).setBlockName("netherdiamondrack"),
						"netherdiamondrack");

		GameRegistry.registerBlock(IUItem.endcoal_stone = new BlockSSPCoal(Material.rock)
				.setBlockTextureName("supersolarpanel:endcoal_stone").setStepSound(Block.soundTypeStone)
				.setBlockName("endcoal_stone"), "endcoal_stone");

		GameRegistry.registerBlock(
				IUItem.nethertinrack = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:nethertinrack")
						.setStepSound(Block.soundTypeStone).setBlockName("nethertinrack"),
				"nethertinrack");
		GameRegistry.registerBlock(IUItem.nethercoalrack = new BlockSSPCoal(Material.rock)
				.setBlockTextureName("supersolarpanel:nethercoalrack").setStepSound(Block.soundTypeStone)
				.setBlockName("nethercoalrack"), "nethercoalrack");
		GameRegistry.registerBlock(
				IUItem.endlead_stone = new BlockOre(Material.rock).setBlockTextureName("supersolarpanel:endlead_stone")
						.setStepSound(Block.soundTypeStone).setBlockName("endlead_stone"),
				"endlead_stone");
		GameRegistry
				.registerBlock(
						IUItem.endredstone_stone = new BlockSSPRedstone(Material.rock)
								.setBlockTextureName("supersolarpanel:endredstone_stone")
								.setStepSound(Block.soundTypeStone).setBlockName("endredstone_stone"),
						"endredstone_stone");
		GameRegistry.registerBlock(IUItem.netherleadrack = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:netherleadrack").setStepSound(Block.soundTypeStone)
				.setBlockName("netherleadrack"), "netherleadrack");
		GameRegistry
				.registerBlock(
						IUItem.netherredstonerack = new BlockSSPRedstone(Material.rock)
								.setBlockTextureName("supersolarpanel:netherredstonerack")
								.setStepSound(Block.soundTypeStone).setBlockName("netherredstonerack"),
						"netherredstonerack");
		GameRegistry
				.registerBlock(
						IUItem.endemerald_stone = new BlockSSPEmerald(Material.rock)
								.setBlockTextureName("supersolarpanel:endemerald_stone")
								.setStepSound(Block.soundTypeStone).setBlockName("endemerald_stone"),
						"endemerald_stone");
		GameRegistry.registerBlock(IUItem.endcopper_stone = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:endcopper_stone").setStepSound(Block.soundTypeStone)
				.setBlockName("endcopper_stone"), "endcopper_stone");
		//

		//
		GameRegistry
				.registerItem(
						IUItem.QuantumItems2 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("QuantumItems2").setTextureName("supersolarpanel:QuantumItems2"),
						"QuantumItems2");
		GameRegistry
				.registerItem(
						IUItem.QuantumItems3 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("QuantumItems3").setTextureName("supersolarpanel:QuantumItems3"),
						"QuantumItems3");
		GameRegistry
				.registerItem(
						IUItem.QuantumItems4 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("QuantumItems4").setTextureName("supersolarpanel:QuantumItems4"),
						"QuantumItems4");
		GameRegistry
				.registerItem(
						IUItem.QuantumItems5 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("QuantumItems5").setTextureName("supersolarpanel:QuantumItems5"),
						"QuantumItems5");
		GameRegistry.registerItem(IUItem.nanoBox = new SSPItemBase().setMaxStackSize(64).setUnlocalizedName("nanobox")
				.setTextureName("supersolarpanel:nanobox"), "nanobox");
		GameRegistry.registerItem(IUItem.photoniccore = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("photoniccore").setTextureName("supersolarpanel:photoniccore"), "photoniccore");
		GameRegistry.registerItem(IUItem.admincore = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("admincore").setTextureName("supersolarpanel:admincore"), "admincore");
		GameRegistry
				.registerItem(
						IUItem.wolfram_plate = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("wolfram_plate").setTextureName("supersolarpanel:wolfram_plate"),
						"wolfram_plate");
		GameRegistry
				.registerItem(
						IUItem.QuantumItems6 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("QuantumItems6").setTextureName("supersolarpanel:QuantumItems6"),
						"QuantumItems6");
		GameRegistry
				.registerItem(
						IUItem.QuantumItems7 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("QuantumItems7").setTextureName("supersolarpanel:QuantumItems7"),
						"QuantumItems7");
		GameRegistry.registerItem(IUItem.neutronium = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("neutronium").setTextureName("supersolarpanel:neutronium"), "neutronium");
		GameRegistry.registerItem(IUItem.neutroniumingot = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("neutroniumingot").setTextureName("supersolarpanel:neutroniumingot"),
				"neutroniumingot");
		GameRegistry
				.registerItem(
						IUItem.neutroniumcore = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("neutroniumcore").setTextureName("supersolarpanel:neutroniumcore"),
						"neutroniumcore");
		GameRegistry.registerBlock(IUItem.blocksintezator = (Block) new Sintezator(), (Class) ItemSintezator.class,
				"BlockSintezator");

		GameRegistry.registerItem(
				IUItem.advancedSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND,
						IUCore.proxy.addArmor("advancedSolarHelmet"), 0, 1).setUnlocalizedName("advancedSolarHelmet"),
				"advanced_solar_helmet");
		GameRegistry.registerItem(
				IUItem.hybridSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND,
						IUCore.proxy.addArmor("hybridSolarHelmet"), 0, 2).setUnlocalizedName("hybridSolarHelmet"),
				"hybrid_solar_helmet");
		GameRegistry.registerItem(
				IUItem.ultimateSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND,
						IUCore.proxy.addArmor("ultimateSolarHelmet"), 0, 3).setUnlocalizedName("ultimateSolarHelmet"),
				"ultimate_solar_helmet");
		GameRegistry.registerItem(IUItem.itemSSP = new ItemSSPCrafring(), "ssp_crafting_items");
		GameRegistry
				.registerItem(
						IUItem.QuantumItems8 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("QuantumItems8").setTextureName("supersolarpanel:QuantumItems8"),
						"QuantumItems8");
		GameRegistry
				.registerItem(
						IUItem.QuantumItems9 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("QuantumItems9").setTextureName("supersolarpanel:QuantumItems9"),
						"QuantumItems9");
		GameRegistry.registerItem(IUItem.coal_chunk1 = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("coal_chunk").setTextureName("supersolarpanel:coal_chunk"), "coal_chunk");
		GameRegistry
				.registerItem(
						IUItem.compresscarbon = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("compresscarbon").setTextureName("supersolarpanel:compresscarbon"),
						"compresscarbon");
		GameRegistry.registerItem(IUItem.compresscarbonultra = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("compresscarbonultra").setTextureName("supersolarpanel:compresscarbonultra"),
				"compresscarbonultra");
		GameRegistry.registerItem(IUItem.protoncore = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("protoncore").setTextureName("supersolarpanel:protoncore"), "protoncore");
		GameRegistry.registerItem(IUItem.nightlinse = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("nightlinse").setTextureName("supersolarpanel:nightlinse"), "nightlinse");
		GameRegistry.registerItem(IUItem.sunlinse = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("sunlinse").setTextureName("supersolarpanel:sunlinse"), "sunlinse");
		GameRegistry.registerItem(IUItem.rainlinse = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("rainlinse").setTextureName("supersolarpanel:rainlinse"), "rainlinse");
		GameRegistry.registerItem(IUItem.aerlinse = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("aerlinse").setTextureName("supersolarpanel:aerlinse"), "aerlinse");
		GameRegistry.registerItem(IUItem.earthlinse = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("earthlinse").setTextureName("supersolarpanel:earthlinse"), "earthlinse");
		GameRegistry.registerItem(IUItem.netherlinse = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("netherlinse").setTextureName("supersolarpanel:netherlinse"), "netherlinse");
		GameRegistry.registerItem(IUItem.endlinse = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("endlinse").setTextureName("supersolarpanel:endlinse"), "endlinse");
		// TODO
		GameRegistry.registerItem(IUItem.nanopickaxe = new EnergyPickaxe(Item.ToolMaterial.EMERALD, "nanopickaxe", 1,
				1, 1000, 1000000, 2, 20, 15, 400, 1600).setUnlocalizedName("nanopickaxe"), "nanopickaxe");
		GameRegistry.registerItem(IUItem.nanoshovel = new EnergyShovel(Item.ToolMaterial.EMERALD, "nanoshovel", 1, 1,
				1000, 1000000, 2, 20, 10, 400, 1600).setUnlocalizedName("nanoshovel"), "nanoshovel");
		GameRegistry.registerItem(IUItem.nanoaxe = new EnergyAxe(Item.ToolMaterial.EMERALD, "nanoaxe", 1, 1, 1000,
				1000000, 2, 20, 15, 400, 1600).setUnlocalizedName("nanoaxe"), "nanoaxe");
		GameRegistry
				.registerItem(
						IUItem.quantumpickaxe = new EnergyPickaxe(Item.ToolMaterial.EMERALD, "quantumpickaxe", 3, 2,
								2500, 10000000, 3, 25, 20, 400, 1600).setUnlocalizedName("quantumpickaxe"),
						"quantumpickaxe");
		GameRegistry.registerItem(IUItem.quantumshovel = new EnergyShovel(Item.ToolMaterial.EMERALD, "quantumshovel",
				3, 2, 2500, 10000000, 3, 25, 10, 400, 1600).setUnlocalizedName("quantumshovel"), "quantumshovel");
		GameRegistry.registerItem(IUItem.quantumaxe = new EnergyAxe(Item.ToolMaterial.EMERALD, "quantumaxe", 3, 2,
				2500, 10000000, 3, 25, 20, 400, 1600).setUnlocalizedName("quantumaxe"), "quantumaxe");
		GameRegistry
				.registerItem(
						IUItem.spectralpickaxe = new EnergyPickaxe(Item.ToolMaterial.EMERALD, "spectralpickaxe", 5, 3,
								5000, 50000000, 4, 30, 25, 400, 1600).setUnlocalizedName("spectralpickaxe"),
						"spectralpickaxe");
		GameRegistry
				.registerItem(
						IUItem.spectralshovel = new EnergyShovel(Item.ToolMaterial.EMERALD, "spectralshovel", 5, 3,
								5000, 50000000, 4, 30, 10, 400, 1600).setUnlocalizedName("spectralshovel"),
						"spectralshovel");
		GameRegistry.registerItem(IUItem.spectralaxe = new EnergyAxe(Item.ToolMaterial.EMERALD, "spectralaxe", 5, 3,
				5000, 50000000, 4, 30, 25, 400, 1600).setUnlocalizedName("spectralaxe"), "spectralaxe");

		//
		GameRegistry.registerItem(IUItem.module7 = new com.Denfop.item.Modules.AdditionModule(), "module7");
		GameRegistry.registerItem(IUItem.module9 = new QuarryModule(), "module8");
		GameRegistry
				.registerItem(
						IUItem.photoniyglass1 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("photoniyglass1").setTextureName("supersolarpanel:photoniyglass1"),
						"photoniyglass1");
		GameRegistry
				.registerItem(
						IUItem.photoniyglass2 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("photoniyglass2").setTextureName("supersolarpanel:photoniyglass2"),
						"photoniyglass2");
		GameRegistry
				.registerItem(
						IUItem.photoniyglass3 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("photoniyglass3").setTextureName("supersolarpanel:photoniyglass3"),
						"photoniyglass3");
		GameRegistry
				.registerItem(
						IUItem.photoniyglass4 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("photoniyglass4").setTextureName("supersolarpanel:photoniyglass4"),
						"photoniyglass4");
		GameRegistry
				.registerItem(
						IUItem.photoniyglass5 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("photoniyglass5").setTextureName("supersolarpanel:photoniyglass5"),
						"photoniyglass5");
		GameRegistry
				.registerItem(
						IUItem.photoniyglass6 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("photoniyglass6").setTextureName("supersolarpanel:photoniyglass6"),
						"photoniyglass6");
		GameRegistry
				.registerItem(
						IUItem.photoniyglass7 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("photoniyglass7").setTextureName("supersolarpanel:photoniyglass7"),
						"photoniyglass7");
		GameRegistry
				.registerItem(
						IUItem.photoniyglass8 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("photoniyglass8").setTextureName("supersolarpanel:photoniyglass8"),
						"photoniyglass8");
		GameRegistry
				.registerItem(
						IUItem.photoniyglass9 = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("photoniyglass9").setTextureName("supersolarpanel:photoniyglass9"),
						"photoniyglass9");
		GameRegistry.registerItem(IUItem.photoniyglass10 = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("photoniyglass10").setTextureName("supersolarpanel:photoniyglass10"),
				"photoniyglass10");

		GameRegistry.registerBlock(IUItem.machines_base = new BlockMoreMachine(), ItemMoreMachine.class,
				"machines_base");
		GameRegistry.registerBlock(IUItem.machines_base1 = new BlockMoreMachine2(), ItemMoreMachine2.class,
				"machines_base1");
		
		GameRegistry.registerItem(IUItem.module8, "WirelessModule1");

		GameRegistry.registerItem(IUItem.ultDDrill, "ultDDrill");
		GameRegistry.registerItem(IUItem.module1 = new com.Denfop.item.Modules.ModuleGenerationDay(Config.percent_day)
				.setMaxStackSize(64).setUnlocalizedName("module1").setTextureName("supersolarpanel:module1"),
				"module1");
		GameRegistry.registerItem(IUItem.module2 = new com.Denfop.item.Modules.ModuleGenerationNight(Config.percent_night)
				.setMaxStackSize(64).setUnlocalizedName("module2").setTextureName("supersolarpanel:module2"),
				"module2");
		GameRegistry.registerItem(IUItem.module3 = new com.Denfop.item.Modules.ModuleStorage(Config.percent_storage).setMaxStackSize(64)
				.setUnlocalizedName("module3").setTextureName("supersolarpanel:module3"), "module3");
		GameRegistry.registerItem(IUItem.module4 = new com.Denfop.item.Modules.ModuleOutput(Config.percent_output).setMaxStackSize(64)
				.setUnlocalizedName("module4").setTextureName("supersolarpanel:module4"), "module4");
		GameRegistry.registerItem(IUItem.module5 = new com.Denfop.item.Modules.ModuleType().setMaxStackSize(64)
				.setUnlocalizedName("module5").setTextureName("supersolarpanel:module5"), "module5");

		GameRegistry.registerItem(IUItem.module6 = new com.Denfop.item.Modules.ModuleTypePanel(), "module6");
		GameRegistry.registerBlock(IUItem.cableblock = new BlockCable(), ItemBlockIC2.class, "blockCable");
		GameRegistry.registerItem(IUItem.cable, "cable");

		GameRegistry.registerItem(IUItem.module, "upgrademodule");
		GameRegistry.registerItem(IUItem.cell_all = new ItemCell(), "cell");
//
		GameRegistry.registerItem(IUItem.matter = new SolidMatter().setMaxStackSize(64).setUnlocalizedName("matter")
				.setTextureName("supersolarpanel:matter"), "matter");
		//
		GameRegistry.registerItem(
				IUItem.chromiumcrushedore = new SSPItemBase().setMaxStackSize(64)
						.setUnlocalizedName("chromiumcrushedore").setTextureName("supersolarpanel:chromiumcrushedore"),
				"chromiumcrushedore");
		GameRegistry
				.registerItem(
						IUItem.electriumdust = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("electriumdust").setTextureName("supersolarpanel:electriumdust"),
						"electriumdust");
		GameRegistry
				.registerItem(
						IUItem.electriumingot = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("electriumingot").setTextureName("supersolarpanel:electriumingot"),
						"electriumingot");
		GameRegistry
				.registerItem(
						IUItem.electriumplate = new SSPItemBase().setMaxStackSize(64)
								.setUnlocalizedName("electriumplate").setTextureName("supersolarpanel:electriumplate"),
						"electriumplate");
		GameRegistry.registerItem(IUItem.blast = new SSPItemBase().setMaxStackSize(64).setUnlocalizedName("blast")
				.setTextureName("supersolarpanel:blast"), "blast");
		GameRegistry.registerItem(IUItem.invardust = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("invardust").setTextureName("supersolarpanel:invardust"), "invardust");
		GameRegistry.registerItem(IUItem.invaringot = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("invaringot").setTextureName("supersolarpanel:invaringot"), "invaringot");
		GameRegistry.registerItem(IUItem.invarplate = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("invarplate").setTextureName("supersolarpanel:invarplate"), "invarplate");
		GameRegistry.registerItem(IUItem.nickel = new SSPItemBase().setMaxStackSize(64).setUnlocalizedName("nickel")
				.setTextureName("supersolarpanel:nickel"), "nickel");
		GameRegistry.registerItem(IUItem.nickelplate = new SSPItemBase().setMaxStackSize(64)
				.setUnlocalizedName("nickelplate").setTextureName("supersolarpanel:nickelplate"), "nickelplate");
		GameRegistry.registerItem(
				IUItem.michalovcrushedore = new SSPItemBase().setMaxStackSize(64)
						.setUnlocalizedName("michalovcrushedore").setTextureName("supersolarpanel:michalovcrushedore"),
				"michalovcrushedore");

	}

	public static void registertiles() {
		GameRegistry.registerTileEntity(TileneutronGenerator.class, "Mass Fabricator1");
		GameRegistry.registerTileEntity(TileEntityChargepadBatBox.class, "Chargepad BatBox1");
		GameRegistry.registerTileEntity(TileEntityChargepadCESU.class, "Chargepad CESU1");
		GameRegistry.registerTileEntity(TileEntityChargepadMFE.class, "Chargepad MFE1");
		GameRegistry.registerTileEntity(TileEntityChargepadMFSU.class, "Chargepad MFSU1");

		GameRegistry.registerTileEntity(TileEntityElectricCESU.class, " CESU1");
		GameRegistry.registerTileEntity(TileEntityElectricMFEMin.class, " MFE1");
		GameRegistry.registerTileEntity(TileEntityElectricMFSUMin.class, " MFSU1");

		GameRegistry.registerTileEntity(TileEntityMolecularTransformer.class, "MolecularTransformer");
		GameRegistry.registerTileEntity(TileEntityQuantumQuarry.class, "QuantumQuarry");
		GameRegistry.registerTileEntity(TileEntityGenerationStone.class, "Generation Stone");
		GameRegistry.registerTileEntity(TileEntityAdvancedMatter.class, "Mass Fabricator Advanced");
		GameRegistry.registerTileEntity(TileEntityImprovedMatter.class, "Mass Fabricator Improved");
		GameRegistry.registerTileEntity(TileEntityUltimateMatter.class, "Mass Fabricator Ultimate");
		GameRegistry.registerTileEntity(TileEntityAlloySmelter.class, "AlloySmelter");
		GameRegistry.registerTileEntity(TileEntityGenerationMicrochip.class, "GenerationMicrochip");
		
		GameRegistry.registerTileEntity((Class) TileEntityAdminSolarPanel.class, "TileEntityAdminSolarPanel");
		GameRegistry.registerTileEntity((Class) TileEntitySintezator.class, "TileEntitySintezator");
		
		GameRegistry.registerTileEntity(TileEntityElectricMFE.class, "MFES");
		GameRegistry.registerTileEntity(TileEntityElectricMFSU.class, "MFSUS");
		GameRegistry.registerTileEntity(TileEntityElectricBatBox.class, "MFSUS1");
		EnumMultiMachine.registerTile();
		GameRegistry.registerTileEntity((Class) TileAdminSolarPanel.class, "Admin Solar Panel");
		GameRegistry.registerTileEntity((Class) TilePhotonicSolarPanel.class, "Photonic Solar Panel");
		GameRegistry.registerTileEntity((Class) TileSingularSolarPanel.class, "Singular Solar Panel");
		GameRegistry.registerTileEntity((Class) TileSpectralSolarPanel.class, "Spectral Solar Panel");
		GameRegistry.registerTileEntity((Class) TileNeutronSolarPanel.class, "Neutron Solar Panel");
		GameRegistry.registerTileEntity((Class) TileProtonSolarPanel.class, "Proton Solar Panel");
		GameRegistry.registerTileEntity(TileEntityChargepadMFES.class, "CMFE");
		GameRegistry.registerTileEntity(TileEntityChargepadMFSUS.class, "CMFSU");
		GameRegistry.registerTileEntity((Class) TileEntityAdvancedSolarPanel.class, "Advanced Solar Panel1");
		GameRegistry.registerTileEntity((Class) TileEntityHybridSolarPanel.class, "Hybrid Solar Panel1");
		GameRegistry.registerTileEntity((Class) TileEntityUltimateSolarPanel.class, "Ultimate Hybrid Solar Panel1");
		GameRegistry.registerTileEntity((Class) TileEntityQuantumSolarPanel.class, "Quantum Solar Panel1");
		GameRegistry.registerTileEntity((Class) TileEntityMolecularTransformer.class, "Molecular Transformer1");
		GameRegistry.registerTileEntity(TileEntityCable.class, "Cable1");

	}
}
