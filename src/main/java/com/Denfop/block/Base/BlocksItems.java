package com.Denfop.block.Base;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.info.Info;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import ic2.core.util.ConfigUtil;
import ic2.core.util.StackUtil;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.Denfop.Config;
import com.Denfop.IUItem;
import com.Denfop.IUCore;
import com.Denfop.block.Chargepad.BlockChargepad;
import com.Denfop.block.cable.BlockCable;
import com.Denfop.block.mechanism.BlockBaseMachine;
import com.Denfop.fluid.Ic2Fluid;
import com.Denfop.integration.Botania.BotaniaIntegration;
import com.Denfop.integration.Botania.ItemReactorTerasteel;
import com.Denfop.item.Modules.ItemWirelessModule;
import com.Denfop.item.Upgrade.ItemUpgradeModule;
import com.Denfop.item.armour.ItemArmorImprovemedQuantum;
import com.Denfop.item.base.ItemCable;
import com.Denfop.item.energy.EnergyAxe;
import com.Denfop.item.energy.EnergyPickaxe;
import com.Denfop.item.energy.EnergyShovel;
import com.Denfop.item.energy.ItemBattery;
import com.Denfop.item.energy.ItemSpectralSaber;
import com.Denfop.item.energy.ItemQuantumSaber;
import com.Denfop.item.energy.AdvancedMultiTool;
import com.Denfop.item.reactor.ItemRadiationToriyRod;
import com.Denfop.item.reactor.ItemRadioactive;
import com.Denfop.item.reactor.ItemReactorHeatStorage;
import com.Denfop.item.reactor.ItemReactorproton;
import com.Denfop.item.rotor.ItemAdvancedWindRotor;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlocksItems {
	public static void init() {
		initPotions();
		initBlocks();
		initFluids();
		initItems();
		initMigration();
	}

	private static void initPotions() {
	}

	private static void initBlocks() {

	}

	private static void initFluids() {
		MaterialLiquid materialLiquid = new MaterialLiquid(MapColor.silverColor);
		registerIC2fluid("fluidNeutron", Material.water, 3867955, 3000, 3000, 0, 300, false);
		
	}

	private static void initItems() {
		IUItem.photon = new ItemStack((Item) new ItemAdvancedWindRotor("photon", Config.Radius3, Config.durability3,
				Config.efficiency3, Config.minWindStrength3, Config.maxWindStrength3,
				new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model6.png")));
		IUItem.neutron = new ItemStack((Item) new ItemAdvancedWindRotor("neutron", Config.Radius4, Config.durability4,
				Config.efficiency4, Config.minWindStrength4, Config.maxWindStrength4,
				new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model5.png")));
		IUItem.myphical = new ItemStack((Item) new ItemAdvancedWindRotor("myphical", Config.Radius5,
				Config.durability5, Config.efficiency5, Config.minWindStrength5, Config.maxWindStrength5,
				new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model4.png")));
		
		IUItem.adronrotor = new ItemStack((Item) new ItemAdvancedWindRotor("adronrotor", Config.Radius5,
				Config.durability5, (int)(Config.efficiency4*1.8), Config.minWindStrength5, Config.maxWindStrength5,
				new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model8.png")));
		IUItem.barionrotor = new ItemStack((Item) new ItemAdvancedWindRotor("barionrotor", Config.Radius5,
				Config.durability5, (int)(Config.efficiency4*3.2), Config.minWindStrength5, Config.maxWindStrength5,
				new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model7.png")));
		IUItem.sprengerrotor = new ItemStack((Item) new ItemAdvancedWindRotor("sprengerrotor", Config.Radius5,
				Config.durability5, (int)(Config.efficiency4*4.5), Config.minWindStrength5, Config.maxWindStrength5,
				new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model9.png")));
		IUItem.electricblock = new BlockElectric();
		IUItem.mfeUnit = new ItemStack(IUItem.electricblock, 1, 0);
		IUItem.mfsUnit = new ItemStack(IUItem.electricblock, 1, 1);
		IUItem.mfeUnit1 = new ItemStack(IUItem.electricblock1, 1, 0);
		IUItem.mfsUnit1 = new ItemStack(IUItem.electricblock1, 1, 1);
		IUItem.electricblock.setCreativeTab(IUCore.tabssp);
		IUItem.machines = new BlockBaseMachine();
		IUItem.machines.setCreativeTab(IUCore.tabssp);
		IUItem.ultDDrill = new AdvancedMultiTool(Item.ToolMaterial.EMERALD).setUnlocalizedName("advDDrill");

		IUItem.lapotronCrystal = new ItemBattery("itemBatLamaCrystal", Config.Storagequantumsuit, 8092.0D, 4);
		IUItem.nanoSaber = new ItemSpectralSaber("itemNanoSaber", Config.maxCharge, Config.transferLimit, Config.tier,
				Config.spectralsaberactive, Config.spectralsabernotactive);
		IUItem.nanoSaber1 = new ItemQuantumSaber("itemNanoSaber1", Config.maxCharge1, Config.transferLimit1,
				Config.tier1, Config.spectralsaberactive1, Config.spectralsabernotactive1);
		IUItem.quantumHelmet = new ItemArmorImprovemedQuantum("itemArmorQuantumHelmet", 0, Config.armor_maxcharge,
				Config.armor_transferlimit, Config.tier);
		IUItem.quantumBodyarmor = new ItemArmorImprovemedQuantum("itemArmorQuantumChestplate", 1,
				Config.armor_maxcharge_body, Config.armor_transferlimit, Config.tier);
		IUItem.quantumLeggings = new ItemArmorImprovemedQuantum("itemArmorQuantumLegs", 2, Config.armor_maxcharge,
				Config.armor_transferlimit, Config.tier);
		IUItem.quantumBoots = new ItemArmorImprovemedQuantum("itemArmorQuantumBoots", 3, Config.armor_maxcharge,
				Config.armor_transferlimit, Config.tier);

		
		IUItem.module8 = new ItemWirelessModule();
		//
		IUItem.iridium = new ItemStack((Item) new ItemAdvancedWindRotor("iridium", Config.Radius, Config.durability,
				Config.efficiency, Config.minWindStrength, Config.maxWindStrength,
				new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model1.png")));
		IUItem.compressiridium = new ItemStack((Item) new ItemAdvancedWindRotor("compressiridium", Config.Radius1,
				Config.durability1, Config.efficiency1, Config.minWindStrength1, Config.maxWindStrength1,
				new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model2.png")));
		IUItem.spectral = new ItemStack((Item) new ItemAdvancedWindRotor("spectral", Config.Radius2,
				Config.durability2, Config.efficiency2, Config.minWindStrength2, Config.maxWindStrength2,
				new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model3.png")));
		IUItem.reactorDepletedprotonSimple = new ItemStack(
				(Item) new ItemRadioactive("reactorDepletedprotonSimple", 10, 100));
		IUItem.reactorDepletedprotonDual = new ItemStack(
				(Item) new ItemRadioactive("reactorDepletedprotonDual", 10, 100));
		IUItem.reactorDepletedprotonQuad = new ItemStack(
				(Item) new ItemRadioactive("reactorDepletedprotonQuad", 10, 100));
		IUItem.reactorDepletedprotoneit = new ItemStack(
				(Item) new ItemRadioactive("reactorDepletedprotoneit", 10, 100));
		IUItem.reactorprotonSimple = new ItemStack((Item) new ItemReactorproton("reactorprotonSimple", 1,
				Config.ProtonRodCells, Config.ProtonRodHeat, Config.ProtonPower));
		IUItem.reactorprotonDual = new ItemStack((Item) new ItemReactorproton("reactorprotonDual", 2,
				Config.ProtonRodCells, Config.ProtonRodHeat, Config.ProtonPower));
		IUItem.reactorprotonQuad = new ItemStack((Item) new ItemReactorproton("reactorprotonQuad", 4,
				Config.ProtonRodCells, Config.ProtonRodHeat, Config.ProtonPower));
		IUItem.reactorprotoneit = new ItemStack((Item) new ItemReactorproton("reactorprotoneit", 8,
				Config.ProtonRodCells, Config.ProtonRodHeat, Config.ProtonPower));
		IUItem.proton = new ItemRadioactive("proton", 150, 100);
		IUItem.toriy = new ItemRadioactive("toriy", 150, 100);
		//
		IUItem.reactortoriySimple = new ItemStack((Item) new ItemRadiationToriyRod("reactortoriySimple", 1,
				Config.toriyRodCells, Config.toriyRodHeat, Config.toriyPower));
		IUItem.reactortoriyDual = new ItemStack((Item) new ItemRadiationToriyRod("reactortoriyDual", 2,
				Config.toriyRodCells, Config.toriyRodHeat, Config.toriyPower));
		IUItem.reactortoriyQuad = new ItemStack((Item) new ItemRadiationToriyRod("reactortoriyQuad", 4,
				Config.toriyRodCells, Config.toriyRodHeat, Config.toriyPower));
		IUItem.reactorDepletedtoriySimple = new ItemStack(
				(Item) new ItemRadioactive("reactorDepletedtoriySimple", 10, 100));
		IUItem.reactorDepletedtoriyDual = new ItemStack(
				(Item) new ItemRadioactive("reactorDepletedtoriyDual", 10, 100));
		IUItem.reactorDepletedtoriyQuad = new ItemStack(
				(Item) new ItemRadioactive("reactorDepletedtoriyQuad", 10, 100));
		//

		IUItem.protonshard = new ItemRadioactive("protonshard", 150, 100);
		IUItem.reactorCoolantmax = new ItemStack((Item) new ItemReactorHeatStorage("reactorCoolantmax", 240000));
		IUItem.reactorCoolanttwelve = new ItemStack((Item) new ItemReactorHeatStorage("reactorCoolanttwelve", 120000));
		IUItem.module = new ItemUpgradeModule();
		IUItem.cable = new ItemCable();

		if (Config.BotaniaLoaded) {
			BotaniaIntegration.reactorterastrellSimple = new ItemStack(
					(Item) new ItemReactorTerasteel("reactorterastrellSimple", 1));
			BotaniaIntegration.reactorterastrellDual = new ItemStack(
					(Item) new ItemReactorTerasteel("reactorterastrellDual", 2));
			BotaniaIntegration.reactorterastrellQuad = new ItemStack(
					(Item) new ItemReactorTerasteel("reactorterastrellQuad", 4));
			BotaniaIntegration.reactorDepletedterastrellSimple = new ItemStack(
					(Item) new ItemRadioactive("reactorDepletedterastrellSimple", 10, 100));
			BotaniaIntegration.reactorDepletedterastrellDual = new ItemStack(
					(Item) new ItemRadioactive("reactorDepletedterastrellDual", 10, 100));
			BotaniaIntegration.reactorDepletedterastrellQuad = new ItemStack(
					(Item) new ItemRadioactive("reactorDepletedterastrellQuad", 10, 100));

		}
	}

	private static void initMigration() {
		renames.put("blockfluidUuMatter", "fluidUuMatter");

	}

	private static void registerIC2fluid(String internalName, Material material, int color, int density, int viscosity,
			int luminosity, int temperature, boolean isGaseous) {
		Block block = null;
		if (!internalName.startsWith("fluid"))
			throw new IllegalArgumentException("Invalid fluid block name: " + internalName);
		String fluidName = internalName.substring("fluid".length()).toLowerCase(Locale.ENGLISH);
		Fluid fluid = (new Ic2Fluid(fluidName)).setDensity(density).setViscosity(viscosity).setLuminosity(luminosity)
				.setTemperature(temperature).setGaseous(isGaseous);
		if (!FluidRegistry.registerFluid(fluid))
			fluid = FluidRegistry.getFluid(fluidName);
		if (!fluid.canBePlacedInWorld()) {
			BlockIC2Fluid blockIC2Fluid = new BlockIC2Fluid(internalName, fluid, material, color);
			fluid.setBlock((Block) blockIC2Fluid);
			fluid.setUnlocalizedName(blockIC2Fluid.getUnlocalizedName());
		} else {
			block = fluid.getBlock();
		}
		fluids.put(internalName, fluid);
		fluidBlocks.put(internalName, block);
	}

	public static void onMissingMappings(FMLMissingMappingsEvent event) {
		for (FMLMissingMappingsEvent.MissingMapping mapping : event.get()) {
			if (!mapping.name.startsWith("IC2:"))
				continue;
			String subName = mapping.name.substring("IC2".length() + 1);
			String newName = renames.get(subName);
			if (newName != null) {
				String name = "IC2:" + newName;
				if (mapping.type == GameRegistry.Type.BLOCK) {
					mapping.remap((Block) GameData.getBlockRegistry().getRaw(name));
					continue;
				}
				mapping.remap((Item) GameData.getItemRegistry().getRaw(name));
				continue;
			}
			if (dropped.contains(subName))
				mapping.ignore();
		}
	}

	public static Fluid getFluid(String name) {
		return fluids.get(name);
	}

	public static Block getFluidBlock(String blockName) {
		return fluidBlocks.get(blockName);
	}

	public static Collection<String> getIc2FluidNames() {
		return fluids.keySet();
	}

	private static Map<String, Fluid> fluids = new HashMap<String, Fluid>();

	private static Map<String, Block> fluidBlocks = new HashMap<String, Block>();

	private static Map<String, String> renames = new HashMap<String, String>();

	private static Set<String> dropped = new HashSet<String>();

	public static void registermetadata() {
		IUItem.itemIrradiantUranium = new ItemStack(IUItem.itemSSP.setUnlocalizedName("itemIrradiantUranium"), 1, 0);
		IUItem.itemEnrichedPhotoniyAlloy = new ItemStack(
				IUItem.itemSSP.setUnlocalizedName("itemEnrichedSunnariumAlloy"), 1, 1);
		IUItem.itemIrradiantGlassPane = new ItemStack(IUItem.itemSSP.setUnlocalizedName("itemIrradiantGlassPlane"), 1,
				3);
		IUItem.itemIridiumIronPlate = new ItemStack(IUItem.itemSSP.setUnlocalizedName("itemIridiumIronPlate"), 1, 4);
		IUItem.itemReinforcedIridiumIronPlate = new ItemStack(
				IUItem.itemSSP.setUnlocalizedName("itemReinforcedIridiumIronPlate"), 1, 5);
		IUItem.itemIrradiantReinforcedPlate = new ItemStack(
				IUItem.itemSSP.setUnlocalizedName("itemIrradiantReinforcedPlate"), 1, 6);

		IUItem.ingotIridium = new ItemStack(IUItem.itemSSP.setUnlocalizedName("ingotIridium"), 1, 7);
		IUItem.itemUranIngot = new ItemStack(IUItem.itemSSP.setUnlocalizedName("itemUranIngot"), 1, 8);
		IUItem.itemMTCore = new ItemStack(IUItem.itemSSP.setUnlocalizedName("itemMTCore"), 1, 9);
		IUItem.itemQuantumCore = new ItemStack(IUItem.itemSSP.setUnlocalizedName("itemQuantumCore"), 1, 10);

		IUItem.module61 = new ItemStack(IUItem.module6.setUnlocalizedName("module61"), 1, 0);
		IUItem.module62 = new ItemStack(IUItem.module6.setUnlocalizedName("module62"), 1, 1);
		IUItem.module63 = new ItemStack(IUItem.module6.setUnlocalizedName("module63"), 1, 2);
		IUItem.module64 = new ItemStack(IUItem.module6.setUnlocalizedName("module64"), 1, 3);
		IUItem.module65 = new ItemStack(IUItem.module6.setUnlocalizedName("module65"), 1, 4);
		IUItem.module66 = new ItemStack(IUItem.module6.setUnlocalizedName("module66"), 1, 5);
		IUItem.module67 = new ItemStack(IUItem.module6.setUnlocalizedName("module67"), 1, 6);
		IUItem.module68 = new ItemStack(IUItem.module6.setUnlocalizedName("module68"), 1, 7);
		IUItem.module69 = new ItemStack(IUItem.module6.setUnlocalizedName("module69"), 1, 8);
		IUItem.module70 = new ItemStack(IUItem.module6.setUnlocalizedName("module70"), 1, 9);
		IUItem.module71 = new ItemStack(IUItem.module7.setUnlocalizedName("module71"), 1, 0);
		IUItem.module72 = new ItemStack(IUItem.module7.setUnlocalizedName("module72"), 1, 1);
		IUItem.module73 = new ItemStack(IUItem.module7.setUnlocalizedName("module73"), 1, 2);
		IUItem.copperCableBlock = new ItemStack((Block) IUItem.BlockCable, 1, 1);
		IUItem.insulatedCopperCableBlock = new ItemStack((Block) IUItem.BlockCable, 1, 0);
		IUItem.goldCableBlock = new ItemStack((Block) IUItem.BlockCable, 1, 2);
		IUItem.insulatedGoldCableBlock = new ItemStack((Block) IUItem.BlockCable, 1, 3);
		IUItem.doubleInsulatedGoldCableBlock = new ItemStack((Block) IUItem.BlockCable, 1, 4);
		IUItem.ironCableBlock = new ItemStack((Block) IUItem.BlockCable, 1, 5);
		IUItem.insulatedIronCableBlock = new ItemStack((Block) IUItem.BlockCable, 1, 6);
		IUItem.doubleInsulatedIronCableBlock = new ItemStack((Block) IUItem.BlockCable, 1, 7);
		IUItem.trippleInsulatedIronCableBlock = new ItemStack((Block) IUItem.BlockCable, 1, 8);
		IUItem.glassFiberCableBlock = new ItemStack((Block) IUItem.BlockCable, 1, 9);

		IUItem.glassFiberCableItem1 = new ItemStack((Block) IUItem.BlockCable, 1, 10);
		IUItem.copperCableItem = new ItemStack((Item) IUItem.cable, 1, 1);
		IUItem.insulatedCopperCableItem = new ItemStack((Item) IUItem.cable, 1, 0);
		IUItem.goldCableItem = new ItemStack((Item) IUItem.cable, 1, 2);
		IUItem.insulatedGoldCableItem = new ItemStack((Item) IUItem.cable, 1, 3);
		IUItem.doubleInsulatedGoldCableItem = new ItemStack((Item) IUItem.cable, 1, 4);
		IUItem.ironCableItem = new ItemStack((Item) IUItem.cable, 1, 5);
		IUItem.insulatedIronCableItem = new ItemStack((Item) IUItem.cable, 1, 6);
		IUItem.doubleInsulatedIronCableItem = new ItemStack((Item) IUItem.cable, 1, 7);
		IUItem.trippleInsulatedIronCableItem = new ItemStack((Item) IUItem.cable, 1, 8);
		IUItem.glassFiberCableItem = new ItemStack((Item) IUItem.cable, 1, 9);
		// SuperSolarPanels.macerator = new ItemStack(SuperSolarPanels.machines, 1, 1);
		// SuperSolarPanels.extractor = new ItemStack(SuperSolarPanels.machines, 1, 2);
		// SuperSolarPanels.compressor = new ItemStack(SuperSolarPanels.machines, 1, 3);

		IUItem.massFabricator = new ItemStack(IUItem.machines, 1, 5);
		// SuperSolarPanels.compressor1 = new ItemStack(SuperSolarPanels.machines, 1,
		// 4);
		IUItem.massFabricator1 = new ItemStack(IUItem.machines, 1, 1);
		// SuperSolarPanels.macerator1 = new ItemStack(SuperSolarPanels.machines, 1, 6);
		// SuperSolarPanels.electroFurnace = new ItemStack(SuperSolarPanels.machines, 1,
		// 7);
		// SuperSolarPanels.electroFurnace1 = new ItemStack(SuperSolarPanels.machines,
		// 1, 8);
		IUItem.massFabricator2 = new ItemStack(IUItem.machines, 1, 2);
		IUItem.massFabricator3 = new ItemStack(IUItem.machines, 1, 3);
		// SuperSolarPanels.metalformer = new ItemStack(SuperSolarPanels.machines, 1,
		// 11);
		// SuperSolarPanels.metalformer1 = new ItemStack(SuperSolarPanels.machines, 1,
		// 12);
		IUItem.alloymachine = new ItemStack(IUItem.machines, 1, 4);
		IUItem.generationmicrochip = new ItemStack(IUItem.machines, 1, 6);
		IUItem.moleculartransformer = new ItemStack(IUItem.machines, 1, 0);

	}
}
