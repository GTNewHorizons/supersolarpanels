package com.Denfop.Recipes;

import com.Denfop.IUItem;
import com.Denfop.IUCore;
import com.Denfop.tiles.NeutroniumGenerator.TileneutronGenerator;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BasicRecipe {
	public static void recipe() {
		GameRegistry.addRecipe(new ItemStack(IUItem.itemSSP, 1, 4),
				new Object[] { "ABA", "DCD", "AFA", Character.valueOf('A'), Items.redstone, Character.valueOf('B'),
						IUItem.photoniy, Character.valueOf('D'), new ItemStack(Items.dye, 1, 4),
						Character.valueOf('C'), new ItemStack(IUItem.itemSSP, 1, 5), Character.valueOf('F'),
						Items.diamond });

		// TODO craft matter`s
		GameRegistry.addRecipe(new ItemStack(IUItem.matter, 1, 1),
				new Object[] { "A A", "AAA", "A A", 'A', new ItemStack(IUItem.matter, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(IUItem.matter, 1, 2),
				new Object[] { "AAA", "A A", "AAA", 'A', new ItemStack(IUItem.matter, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(IUItem.matter, 1, 3),
				new Object[] { "A A", "A A", "A A", 'A', new ItemStack(IUItem.matter, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(IUItem.matter, 1, 4),
				new Object[] { "A A", " A ", "A A", 'A', new ItemStack(IUItem.matter, 1, 0) });

		GameRegistry.addRecipe(new ItemStack(IUItem.matter, 1, 5),
				new Object[] { "A  ", "AAA", "  A", 'A', new ItemStack(IUItem.matter, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(IUItem.matter, 1, 6),
				new Object[] { "A A", " A ", " A ", 'A', new ItemStack(IUItem.matter, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(IUItem.matter, 1, 7),
				new Object[] { "A A", "A A", " A ", 'A', new ItemStack(IUItem.matter, 1, 0) });

		// TODO craft lenses
		GameRegistry.addRecipe(new ItemStack(IUItem.module5, 1, 5), new Object[] { " B ", "AAA", "   ", 'A',
				new ItemStack(IUItem.sunlinse, 1), 'B', new ItemStack(IUItem.QuantumItems9, 1) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module5, 1, 6), new Object[] { " B ", "AAA", "   ", 'A',
				new ItemStack(IUItem.rainlinse, 1), 'B', new ItemStack(IUItem.QuantumItems9, 1) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module5, 1, 2), new Object[] { " B ", "AAA", "   ", 'A',
				new ItemStack(IUItem.netherlinse, 1), 'B', new ItemStack(IUItem.QuantumItems8, 1) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module5, 1, 4), new Object[] { " B ", "AAA", "   ", 'A',
				new ItemStack(IUItem.nightlinse, 1), 'B', new ItemStack(IUItem.QuantumItems8, 1) });

		GameRegistry.addRecipe(new ItemStack(IUItem.module5, 1, 1), new Object[] { " B ", "AAA", "   ", 'A',
				new ItemStack(IUItem.earthlinse, 1), 'B', new ItemStack(IUItem.QuantumItems9, 1) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module5, 1, 3), new Object[] { " B ", "AAA", "   ", 'A',
				new ItemStack(IUItem.endlinse, 1), 'B', new ItemStack(IUItem.QuantumItems8, 1) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module5, 1, 0), new Object[] { " B ", "AAA", "   ", 'A',
				new ItemStack(IUItem.aerlinse, 1), 'B', new ItemStack(IUItem.QuantumItems8, 1) });

		GameRegistry.addRecipe(new ItemStack(IUItem.module9, 1, 0),
				new Object[] { "CBD", " A ", "DBC", 'A', Ic2Items.advancedCircuit, 'B',
						new ItemStack(IUItem.caravky_ingot, 1), 'C', new ItemStack(IUItem.invaringot, 1), 'D',
						new ItemStack(IUItem.electriumingot, 1) });

		GameRegistry.addRecipe(new ItemStack(IUItem.module9, 1, 1),
				new Object[] { "CBD", " A ", "DBC", 'A', IUItem.overclockerUpgrade1, 'B',
						new ItemStack(IUItem.caravky_ingot, 1), 'C', new ItemStack(IUItem.invarplate, 1), 'D',
						new ItemStack(IUItem.electriumplate, 1) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module9, 1, 2),
				new Object[] { "CBD", " A ", "DBC", 'A', new ItemStack(IUItem.module9, 1, 1), 'B',
						new ItemStack(IUItem.QuantumItems7, 1), 'C', new ItemStack(IUItem.photoniy, 1), 'D',
						new ItemStack(IUItem.advanced_core, 1) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module9, 1, 3),
				new Object[] { "CBD", " A ", "DBC", 'A', new ItemStack(IUItem.module9, 1, 2), 'B',
						new ItemStack(IUItem.QuantumItems3, 1), 'C', new ItemStack(IUItem.photoniy_ingot, 1), 'D',
						new ItemStack(IUItem.hybrid_core, 1) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module9, 1, 4),
				new Object[] { "CBD", " A ", "DBC", 'A', new ItemStack(IUItem.module9, 1, 3), 'B',
						new ItemStack(IUItem.QuantumItems8, 1), 'C', new ItemStack(IUItem.QuantumItems6, 1), 'D',
						new ItemStack(IUItem.ultimate_core, 1) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module9, 1, 5),
				new Object[] { "CBD", " A ", "DBC", 'A', new ItemStack(IUItem.module9, 1, 4), 'B',
						new ItemStack(IUItem.QuantumItems9, 1), 'C', new ItemStack(IUItem.QuantumItems7, 1), 'D',
						new ItemStack(IUItem.spectralcore, 1) });
		//
		GameRegistry.addRecipe(new ItemStack(IUItem.nanoaxe, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "CAC", " D ", 'A', Items.diamond_axe, 'B',
						new ItemStack(IUItem.QuantumItems9, 1), 'C', new ItemStack(IUItem.photoniy, 1),'D',new ItemStack(Ic2Items.energyCrystal.getItem() , 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addRecipe(new ItemStack(IUItem.nanopickaxe, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "CAC", " D ", 'A', Items.diamond_pickaxe, 'B',
						new ItemStack(IUItem.QuantumItems9, 1), 'C', new ItemStack(IUItem.photoniy, 1) ,'D',new ItemStack(Ic2Items.energyCrystal.getItem() , 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addRecipe(new ItemStack(IUItem.nanoshovel, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "CAC", " D ", 'A', Items.diamond_shovel, 'B',
						new ItemStack(IUItem.QuantumItems9, 1), 'C', new ItemStack(IUItem.photoniy, 1),'D',new ItemStack(Ic2Items.energyCrystal.getItem() , 1, OreDictionary.WILDCARD_VALUE) });

		GameRegistry.addRecipe(new ItemStack(IUItem.quantumaxe, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "CAC", " D ", 'A',
						new ItemStack(IUItem.nanoaxe, 1, OreDictionary.WILDCARD_VALUE), 'B',
						new ItemStack(IUItem.QuantumItems8, 1), 'C', new ItemStack(IUItem.QuantumItems6, 1),'D',new ItemStack(Ic2Items.lapotronCrystal.getItem() , 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addRecipe(new ItemStack(IUItem.quantumpickaxe, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "CAC", " D ", 'A',
						new ItemStack(IUItem.nanopickaxe, 1, OreDictionary.WILDCARD_VALUE), 'B',
						new ItemStack(IUItem.QuantumItems8, 1), 'C', new ItemStack(IUItem.QuantumItems6, 1),'D',new ItemStack(Ic2Items.lapotronCrystal.getItem() , 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addRecipe(new ItemStack(IUItem.quantumshovel, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "CAC", " D ", 'A',
						new ItemStack(IUItem.nanoshovel, 1, OreDictionary.WILDCARD_VALUE), 'B',
						new ItemStack(IUItem.QuantumItems8, 1), 'C', new ItemStack(IUItem.QuantumItems6, 1),'D',new ItemStack(Ic2Items.lapotronCrystal.getItem() , 1, OreDictionary.WILDCARD_VALUE) });

		GameRegistry.addRecipe(new ItemStack(IUItem.spectralaxe, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "CAC", " B ", 'A',
						new ItemStack(IUItem.quantumaxe, 1, OreDictionary.WILDCARD_VALUE), 'B',
						new ItemStack(IUItem.QuantumItems5, 1), 'C', new ItemStack(IUItem.QuantumItems3, 1),'D',new ItemStack(IUItem.lapotronCrystal , 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addRecipe(new ItemStack(IUItem.spectralpickaxe, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "CAC", " B ", 'A',
						new ItemStack(IUItem.quantumpickaxe, 1, OreDictionary.WILDCARD_VALUE), 'B',
						new ItemStack(IUItem.QuantumItems5, 1), 'C', new ItemStack(IUItem.QuantumItems3, 1),'D',new ItemStack(IUItem.lapotronCrystal , 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addRecipe(new ItemStack(IUItem.spectralshovel, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "CAC", " B ", 'A',
						new ItemStack(IUItem.quantumshovel, 1, OreDictionary.WILDCARD_VALUE), 'B',
						new ItemStack(IUItem.QuantumItems5, 1), 'C', new ItemStack(IUItem.QuantumItems3, 1),'D',new ItemStack(IUItem.lapotronCrystal , 1, OreDictionary.WILDCARD_VALUE) });

		// TODO Recipe Ultimate Drill
		GameRegistry.addRecipe(new ItemStack(IUItem.ultDDrill, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { "MLQ", "ODO", "COC", 'O', IUItem.overclockerUpgrade1, 'D',
						new ItemStack(IUItem.spectralpickaxe, 1, OreDictionary.WILDCARD_VALUE), 'C',
						IUItem.QuantumItems5, 'L', IUItem.QuantumItems3, 'Q',
						new ItemStack(IUItem.spectralaxe, 1, OreDictionary.WILDCARD_VALUE), 'M',
						new ItemStack(IUItem.spectralshovel, 1, OreDictionary.WILDCARD_VALUE) });
		// ,OreDictionary.WILDCARD_VALUE
		// TODO Recipe Advanced and Improvemed Overclockers
		GameRegistry.addRecipe(IUItem.overclockerUpgrade,
				new Object[] { "BAB", 'A', Ic2Items.overclockerUpgrade, 'B', IUItem.QuantumItems9 });
		GameRegistry.addRecipe(IUItem.overclockerUpgrade1,
				new Object[] { "BAB", 'A', IUItem.overclockerUpgrade, 'B', IUItem.QuantumItems8 });
		// TODO Reciper Rotor`s
		GameRegistry.addRecipe(IUItem.myphical,
				new Object[] { " B ", "BAB", " B ", 'A', IUItem.spectral, 'B', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(IUItem.photon,
				new Object[] { " B ", "BAB", " B ", 'A', IUItem.myphical, 'B', IUItem.QuantumItems8 });
		GameRegistry.addRecipe(IUItem.neutron, new Object[] { "CBC", "BAB", "CBC", 'A', IUItem.photon, 'B',
				IUItem.QuantumItems9, 'C', Ic2Items.iridiumPlate });
		GameRegistry.addRecipe(IUItem.barionrotor, new Object[] { "CBC", "BAB", "CBC", 'A', IUItem.neutron, 'B',
				IUItem.QuantumItems3, 'C', Ic2Items.advironblock });
		GameRegistry.addRecipe(IUItem.adronrotor, new Object[] { "CBC", "BAB", "CBC", 'A', IUItem.barionrotor, 'B',
				IUItem.QuantumItems5, 'C', Ic2Items.leadBlock });
		GameRegistry.addRecipe(IUItem.sprengerrotor, new Object[] { "CBC", "BAB", "CBC", 'A', IUItem.adronrotor, 'B',
				IUItem.protoncore, 'C', Ic2Items.leadBlock });

		GameRegistry.addRecipe(IUItem.iridium,
				new Object[] { " B ", "BAB", " B ", 'A', Ic2Items.carbonrotor, 'B', Ic2Items.iridiumPlate });
		GameRegistry.addRecipe(IUItem.compressiridium,
				new Object[] { " B ", "BAB", " B ", 'A', IUItem.iridium, 'B', IUItem.compresscarbon });
		GameRegistry.addRecipe(IUItem.spectral, new Object[] { "C C", "BAB", "C C", 'A', IUItem.compressiridium, 'B',
				IUItem.QuantumItems7, 'C', Ic2Items.iridiumPlate });
		GameRegistry.addRecipe(IUItem.reactorCoolanttwelve, new Object[] { "CCC", "ABA", "CCC", 'A',
				Ic2Items.reactorCoolantSix, 'B', Ic2Items.plateiron, 'C', Ic2Items.platetin });
		GameRegistry.addRecipe(IUItem.reactorCoolantmax, new Object[] { "CCC", "ABA", "CCC", 'A',
				IUItem.reactorCoolanttwelve, 'B', Ic2Items.plateiron, 'C', Ic2Items.platetin });

		// TODO Recipes Machines and Quantum/Nano Chip
		Recipes.advRecipes.addRecipe(new ItemStack(IUItem.QuantumItems9, 1),
				new Object[] { " D ", "BAB", " C ", Character.valueOf('A'), Ic2Items.advancedCircuit,
						Character.valueOf('B'), new ItemStack(IUItem.nanoBox, 1), Character.valueOf('C'),
						OreDictionary.getOres("ingotNickel"), Character.valueOf('D'), IUItem.compresscarbon });
		//

		//
		
		GameRegistry.addRecipe(new ItemStack(IUItem.QuantumItems8, 1),
				new Object[] { "DCD", "HAH", 'A', IUItem.QuantumItems9, 'C', IUItem.magnesium_ingot, 'D',
						IUItem.compresscarbonultra, 'H', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 0),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.platium_plate, 'B', IUItem.QuantumItems9, 'C',
						Ic2Items.macerator, 'D', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 6),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.chromium_plate, 'B', IUItem.QuantumItems9, 'C',
						Ic2Items.electroFurnace, 'D', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 7),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.wolfram_plate, 'B', IUItem.QuantumItems8, 'C',
						new ItemStack(IUItem.machines_base, 1, 6), 'D', IUItem.QuantumItems3 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 8),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.michail_plate, 'B', IUItem.QuantumItems5, 'C',
						new ItemStack(IUItem.machines_base, 1, 7), 'D', IUItem.QuantumItems3 });

		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 3),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.wolfram_plate, 'B', IUItem.QuantumItems9, 'C',
						Ic2Items.compressor, 'D', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 4),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.magnesium_plate, 'B', IUItem.QuantumItems8, 'C',
						new ItemStack(IUItem.machines_base, 1, 3), 'D', IUItem.QuantumItems3 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 5),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.chromium_plate, 'B', IUItem.QuantumItems5, 'C',
						new ItemStack(IUItem.machines_base, 1, 4), 'D', IUItem.QuantumItems3 });

		GameRegistry.addRecipe(IUItem.massFabricator1,
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.magnesium_plate, 'B', IUItem.QuantumItems9, 'C',
						Ic2Items.massFabricator, 'D', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 1),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.chromium_plate, 'B', IUItem.QuantumItems8, 'C',
						new ItemStack(IUItem.machines_base, 1, 0), 'D', IUItem.QuantumItems3 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 2),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.magnesium_plate, 'B', IUItem.QuantumItems5, 'C',
						new ItemStack(IUItem.machines_base, 1, 1), 'D', IUItem.QuantumItems3 });

		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 9),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.chromium_plate, 'B', IUItem.QuantumItems9, 'C',
						Ic2Items.extractor, 'D', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 10),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.wolfram_plate, 'B', IUItem.QuantumItems8, 'C',
						new ItemStack(IUItem.machines_base, 1, 9), 'D', IUItem.QuantumItems3 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 11),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.michail_plate, 'B', IUItem.QuantumItems5, 'C',
						new ItemStack(IUItem.machines_base, 1, 10), 'D', IUItem.QuantumItems3 });

		GameRegistry.addRecipe(IUItem.massFabricator2, new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.platium_plate,
				'B', IUItem.QuantumItems8, 'C', IUItem.massFabricator1, 'D', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(IUItem.massFabricator3, new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.spinel_plate,
				'B', IUItem.QuantumItems5, 'C', IUItem.massFabricator2, 'D', IUItem.QuantumItems3 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 12),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.magnesium_plate, 'B', IUItem.QuantumItems9, 'C',
						Ic2Items.metalformer, 'D', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 13),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.platium_plate, 'B', IUItem.QuantumItems8, 'C',
						new ItemStack(IUItem.machines_base, 1, 12), 'D', IUItem.QuantumItems3 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base, 1, 14),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.chromium_plate, 'B', IUItem.QuantumItems5, 'C',
						new ItemStack(IUItem.machines_base, 1, 13), 'D', IUItem.QuantumItems3 });

		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base1, 1, 0),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.wolfram_plate, 'B', IUItem.QuantumItems9, 'C',
						Ic2Items.recycler, 'D', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base1, 1, 1),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.chromium_plate, 'B', IUItem.QuantumItems8, 'C',
						new ItemStack(IUItem.machines_base1, 1, 0), 'D', IUItem.QuantumItems3 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines_base1, 1, 2),
				new Object[] { "AAA", "BCB", "DDD", 'A', IUItem.michail_plate, 'B', IUItem.QuantumItems5, 'C',
						new ItemStack(IUItem.machines_base1, 1, 1), 'D', IUItem.QuantumItems3 });

		GameRegistry.addRecipe(new ItemStack(IUItem.machines, 1, 4),
				new Object[] { "AAA", "BCB", "DDD", 'A', Ic2Items.plateadviron, 'B', Ic2Items.advancedCircuit, 'C',
						Ic2Items.inductionFurnace, 'D', IUItem.nanoBox });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines, 1, 7),
				new Object[] { "AAA", "BCB", "DDD", 'A', Blocks.cobblestone, 'B', Ic2Items.advancedCircuit, 'C',
						Ic2Items.generator, 'D', IUItem.QuantumItems6 });
		GameRegistry.addRecipe(new ItemStack(IUItem.machines, 1, 8), new Object[] { "A A", "BCB", "A A", 'A',
				IUItem.protoncore, 'B', IUItem.QuantumItems6, 'C', new ItemStack(IUItem.machines, 1, 0) });

		// TODO Recipe Neutron Generator
		GameRegistry.addRecipe(IUItem.massFabricator, new Object[] { " B ", "ACA", " B ", 'C', Ic2Items.massFabricator,
				'A', new ItemStack(IUItem.QuantumItems5, 1), 'B', new ItemStack(IUItem.enderquantumcomponent, 1) });

		// TODO Old Recipe from Advanced Solar Panels
		GameRegistry.addRecipe((IRecipe) new ShapedOreRecipe(IUItem.itemIrradiantUranium,
				new Object[] { " R ", "RSR", " R ", Character.valueOf('R'), Items.glowstone_dust,
						Character.valueOf('S'), new ItemStack(IUItem.itemSSP, 1, 8) }));
		GameRegistry.addRecipe(new ItemStack(IUItem.itemSSP, 6, 3),
				new Object[] { "RRR", "ASA", "RRR", Character.valueOf('R'), IC2Items.getItem("reinforcedGlass"),
						Character.valueOf('A'), new ItemStack(IUItem.itemSSP, 1, 0), Character.valueOf('S'),
						Items.glowstone_dust });
		// TODO recipe neutron core

		GameRegistry.addRecipe(new ItemStack(IUItem.neutroniumcore, 1),
				new Object[] { " A ", "ACA", " A ", 'C', IUItem.photoniccore, 'A', IUItem.neutroniumingot });
		// TODO Recipe Electric Storage
		GameRegistry.addRecipe(new ItemStack(IUItem.electricblock, 1, 4),
				new Object[] { "ABA", "ACA", "ADA", 'C', new ItemStack(IUItem.electricblock, 1, 3), 'A',
						new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE),
						'B', Ic2Items.advancedCircuit, 'D', Ic2Items.advancedMachine });
		GameRegistry.addRecipe(new ItemStack(IUItem.electricblock, 1, 3),
				new Object[] { "ABA", "BCB", "ABA", 'C', Ic2Items.machine, 'A',
						new ItemStack(Ic2Items.energyCrystal.getItem(), 1, OreDictionary.WILDCARD_VALUE), 'B',
						Ic2Items.insulatedGoldCableItem });

		GameRegistry.addRecipe(new ItemStack(IUItem.electricblock, 1, 2),
				new Object[] { "ABA", "CCC", "AAA", 'C',
						new ItemStack(Ic2Items.reBattery.getItem(), 1, OreDictionary.WILDCARD_VALUE), 'A',
						OreDictionary.getOres("plankWood").get(0), 'B', Ic2Items.insulatedTinCableItem });
		GameRegistry.addRecipe(new ItemStack(IUItem.electricblock, 1, 5),
				new Object[] { "ABA", "CCC", "AAA", 'C',
						new ItemStack(Ic2Items.advBattery.getItem(), 1, OreDictionary.WILDCARD_VALUE), 'A',
						Ic2Items.platebronze, 'B', Ic2Items.insulatedCopperCableItem });

		GameRegistry.addRecipe(new ItemStack(IUItem.electricblock, 1, 0),
				new Object[] { "ACA", 'C', new ItemStack(IUItem.electricblock, 1, 4), 'A', IUItem.photoniy_ingot });
		GameRegistry.addRecipe(new ItemStack(IUItem.electricblock, 1, 1),
				new Object[] { "ACA", 'C', new ItemStack(IUItem.electricblock, 1, 0), 'A', IUItem.QuantumItems5 });
		// TODO Recipe dust
		GameRegistry.addRecipe(new ItemStack(IUItem.dust, 1),
				new Object[] { "AAA", "AAA", "AAA", 'A', IC2Items.getItem("energiumDust") });
		// TODO Old Recipe from Advanced Solar Panels
		GameRegistry.addRecipe(IUItem.itemReinforcedIridiumIronPlate,
				new Object[] { "ABA", "BCB", "ABA", Character.valueOf('A'), IC2Items.getItem("advancedAlloy"),
						Character.valueOf('B'), IC2Items.getItem("carbonPlate"), Character.valueOf('C'),
						Ic2Items.iridiumPlate });
		Recipes.advRecipes.addRecipe(IUItem.itemIridiumIronPlate, new Object[] { "AAA", "ABA", "AAA",
				Character.valueOf('A'), "plateIron", Character.valueOf('B'), new ItemStack(IUItem.itemSSP, 1, 7) });
		// TODO Recipe Modules
		GameRegistry.addRecipe(new ItemStack(IUItem.module1, 1),
				new Object[] { "AAA", "BDB", " C ", 'A', IUItem.chromium_plate, 'B', IUItem.wolfram_plate, 'C',
						IUItem.michail_plate, 'D', new ItemStack(IUItem.itemSSP, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module2, 1),
				new Object[] { "AAA", "BDB", " C ", 'A', IUItem.platium_plate, 'B', IUItem.chromium_plate, 'C',
						IUItem.wolfram_plate, 'D', new ItemStack(IUItem.itemSSP, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module3, 1),
				new Object[] { "AAA", "BDB", " C ", 'A', IUItem.QuantumItems2, 'B', IUItem.michail_plate, 'C',
						IUItem.chromium_plate, 'D', new ItemStack(IUItem.itemSSP, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module4, 1),
				new Object[] { "AAA", "BDB", " C ", 'A', IUItem.michail_plate, 'B', IUItem.chromium_plate, 'C',
						IUItem.platium_plate, 'D', new ItemStack(IUItem.itemSSP, 1, 4) });
		// TODO Recipes Photoniy Glasses
		GameRegistry.addRecipe(new ItemStack(IUItem.photoniyglass1, 1),
				new Object[] { "CAC", "BBB", " C ", 'A', Ic2Items.platelead, 'B', new ItemStack(IUItem.itemSSP, 1, 3),
						'C', Ic2Items.platecopper, 'D', Ic2Items.platetin });
		GameRegistry.addRecipe(new ItemStack(IUItem.photoniyglass2, 1), new Object[] { "DCD", "HCH", 'A',
				Ic2Items.platelead, 'C', Ic2Items.platecopper, 'D', Ic2Items.platetin, 'H', IUItem.photoniyglass1 });
		GameRegistry.addRecipe(new ItemStack(IUItem.photoniyglass3, 1), new Object[] { "DCD", "HCH", 'A',
				Ic2Items.platelead, 'C', Ic2Items.platetin, 'D', Items.iron_ingot, 'H', IUItem.photoniyglass2 });
		GameRegistry.addRecipe(new ItemStack(IUItem.photoniyglass4, 1), new Object[] { "DCD", "HCH", 'A',
				Ic2Items.platecopper, 'C', IUItem.wolfram_ingot, 'D', Items.redstone, 'H', IUItem.photoniyglass3 });
		GameRegistry.addRecipe(new ItemStack(IUItem.photoniyglass5, 1),
				new Object[] { "DCD", "HCH", 'A', Ic2Items.platecopper, 'C', IUItem.magnesium_ingot, 'D',
						Ic2Items.platecopper, 'H', IUItem.photoniyglass4 });
		GameRegistry.addRecipe(new ItemStack(IUItem.photoniyglass6, 1),
				new Object[] { "DCD", "HCH", 'A', Ic2Items.platecopper, 'C', IUItem.chromium_ingot, 'D',
						Ic2Items.plategold, 'H', IUItem.photoniyglass5 });
		GameRegistry.addRecipe(new ItemStack(IUItem.photoniyglass7, 1),
				new Object[] { "DCD", "HCH", 'A', Ic2Items.platecopper, 'C', IUItem.chromium_plate, 'D',
						Ic2Items.tinBlock, 'H', IUItem.photoniyglass6 });

		GameRegistry.addRecipe(new ItemStack(IUItem.photoniyglass8, 1),
				new Object[] { "DCD", "HCH", 'A', Ic2Items.platecopper, 'C', IUItem.platium_plate, 'D',
						Blocks.iron_block, 'H', IUItem.photoniyglass7 });
		GameRegistry.addRecipe(new ItemStack(IUItem.photoniyglass9, 1),
				new Object[] { "DCD", "HCH", 'A', Ic2Items.platecopper, 'C', Ic2Items.leadBlock, 'D',
						Ic2Items.plateadviron, 'H', IUItem.photoniyglass8 });
		GameRegistry.addRecipe(new ItemStack(IUItem.photoniyglass10, 1),
				new Object[] { "DCD", "HCH", 'A', Ic2Items.platecopper, 'C', IUItem.michail_plate, 'D',
						IUItem.chromium_plate, 'H', IUItem.photoniyglass9 });

		

		// TODO Start Recipe Helmet
		Recipes.advRecipes.addRecipe(new ItemStack(IUItem.spectralSolarHelmet, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { "A", "B", 'A', new ItemStack(IUItem.blockSSPSolarPanel, 1, 4), 'B',
						new ItemStack(IUItem.ultimateSolarHelmet, 1, OreDictionary.WILDCARD_VALUE) });
		Recipes.advRecipes.addRecipe(new ItemStack(IUItem.singularSolarHelmet, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { "A", "B", 'A', new ItemStack(IUItem.blockSSPSolarPanel, 1, 6), 'B',
						new ItemStack(IUItem.spectralSolarHelmet, 1, OreDictionary.WILDCARD_VALUE) });
		Recipes.advRecipes.addRecipe(new ItemStack(IUItem.advancedSolarHelmet, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " A ", "RBR", "FDF", Character.valueOf('A'),
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 0), Character.valueOf('B'),
						new ItemStack(IC2Items.getItem("nanoHelmet").getItem(), 1, OreDictionary.WILDCARD_VALUE),
						Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'),
						IC2Items.getItem("lvTransformer"), Character.valueOf('F'),
						IC2Items.getItem("insulatedGoldCableItem") });

		Recipes.advRecipes.addRecipe(new ItemStack(IUItem.hybridSolarHelmet, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " A ", "RBR", "FDF", Character.valueOf('A'),
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 1), Character.valueOf('B'),
						new ItemStack(IC2Items.getItem("quantumHelmet").getItem(), 1, OreDictionary.WILDCARD_VALUE),
						Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'),
						IC2Items.getItem("hvTransformer"), Character.valueOf('F'),
						IC2Items.getItem("glassFiberCableItem") });

		Recipes.advRecipes.addRecipe(new ItemStack(IUItem.ultimateSolarHelmet, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " A ", "RBR", "FDF", Character.valueOf('A'),
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 2), Character.valueOf('B'),
						new ItemStack(IC2Items.getItem("quantumHelmet").getItem(), 1, OreDictionary.WILDCARD_VALUE),
						Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'),
						IC2Items.getItem("hvTransformer"), Character.valueOf('F'),
						IC2Items.getItem("glassFiberCableItem") });
		// TODO End Recipe Helmet
		GameRegistry.addRecipe(new ItemStack(IUItem.QuantumItems5, 1), new Object[] { "CBC", "BAB", "CBC", 'A',
				IUItem.QuantumItems8, 'B', IUItem.itemIridiumIronPlate, 'C', IUItem.QuantumItems3 });
		GameRegistry.addRecipe(new ItemStack(IUItem.nanoSaber1, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { "CB ", "CA ", "DEB", 'A',
						new ItemStack(IC2Items.getItem("nanoSaber").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'B',
						new ItemStack(IUItem.QuantumItems8, 1), 'C', IC2Items.getItem("carbonPlate"), 'D',
						Items.glowstone_dust, 'E',
						new ItemStack(IUItem.lapotronCrystal, 1, OreDictionary.WILDCARD_VALUE), });
		GameRegistry.addRecipe(new ItemStack(IUItem.nanoSaber, 1, OreDictionary.WILDCARD_VALUE), new Object[] { "CB ",
				"CA ", "DEB", 'A', new ItemStack(IUItem.nanoSaber1, 1, OreDictionary.WILDCARD_VALUE), 'B',
				new ItemStack(IUItem.QuantumItems5, 1), 'C', IC2Items.getItem("carbonPlate"), 'D',
				Items.glowstone_dust, 'E', new ItemStack(IUItem.lapotronCrystal, 1, OreDictionary.WILDCARD_VALUE), });

		GameRegistry.addRecipe(new ItemStack(IUItem.lapotronCrystal, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { "CBC", "BAB", "CBC", 'A',
						new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE),
						'B', new ItemStack(IUItem.QuantumItems3, 1), 'C', IC2Items.getItem("iridiumPlate") });
		GameRegistry.addRecipe(new ItemStack(IUItem.quantumHelmet, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "ACA", " A ", 'A', IUItem.QuantumItems6, 'B',
						new ItemStack(IUItem.lapotronCrystal, 1, OreDictionary.WILDCARD_VALUE), 'C',
						new ItemStack(IC2Items.getItem("quantumHelmet").getItem(), 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addRecipe(new ItemStack(IUItem.quantumLeggings, 1, OreDictionary.WILDCARD_VALUE), new Object[] {
				" B ", "ACA", " A ", 'A', IUItem.QuantumItems6, 'B',
				new ItemStack(IUItem.lapotronCrystal, 1, OreDictionary.WILDCARD_VALUE), 'C',
				new ItemStack(IC2Items.getItem("quantumLeggings").getItem(), 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addRecipe(new ItemStack(IUItem.quantumBodyarmor, 1, OreDictionary.WILDCARD_VALUE), new Object[] {
				" B ", "ACA", " A ", 'A', IUItem.QuantumItems6, 'B',
				new ItemStack(IUItem.lapotronCrystal, 1, OreDictionary.WILDCARD_VALUE), 'C',
				new ItemStack(IC2Items.getItem("quantumBodyarmor").getItem(), 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addRecipe(new ItemStack(IUItem.quantumBoots, 1, OreDictionary.WILDCARD_VALUE),
				new Object[] { " B ", "ACA", " A ", 'A', IUItem.QuantumItems6, 'B',
						new ItemStack(IUItem.lapotronCrystal, 1, OreDictionary.WILDCARD_VALUE), 'C',
						new ItemStack(IC2Items.getItem("quantumBoots").getItem(), 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addRecipe(new ItemStack(IUItem.nanoBox, 1),
				new Object[] { " C ", "CBC", " C ", 'B', IUItem.dust, 'C', IC2Items.getItem("carbonPlate") });
		GameRegistry.addRecipe(new ItemStack(IUItem.QuantumItems6, 1),
				new Object[] { " A ", "ACA", " A ", 'A', IC2Items.getItem("iridiumPlate"), 'C', IUItem.nanoBox });
		GameRegistry.addRecipe(new ItemStack(IUItem.QuantumItems7, 1),
				new Object[] { " A ", "ACA", " A ", 'A', IUItem.photoniy, 'C', IUItem.nanoBox });

		//
		GameRegistry.addRecipe(new ItemStack(IUItem.enderquantumcomponent, 1), new Object[] { "ABA", "BCB", "ABA", 'A',
				IC2Items.getItem("iridiumPlate"), 'B', Items.ender_eye, 'C', Items.nether_star });
		GameRegistry.addRecipe(new ItemStack(IUItem.QuantumItems3, 1),
				new Object[] { "CBC", "BAB", "CBC", 'A', new ItemStack(IUItem.QuantumItems7, 1), 'B',
						new ItemStack(IUItem.itemSSP, 1, 4), 'C', IC2Items.getItem("carbonPlate") });

		// TODO Recipes Chargepad MFSU
		GameRegistry.addRecipe(new ItemStack(IUItem.Chargepadelectricblock, 1, 0),
				new Object[] { "ABA", "CDC", 'B', Blocks.stone_pressure_plate, 'A', IUItem.QuantumItems9, 'D',
						new ItemStack(IUItem.electricblock, 1, 0), 'C', Ic2Items.rubber });
		GameRegistry.addRecipe(new ItemStack(IUItem.Chargepadelectricblock, 1, 1),
				new Object[] { "ABA", "CDC", 'B', Blocks.stone_pressure_plate, 'A', IUItem.QuantumItems8, 'D',
						new ItemStack(IUItem.electricblock, 1, 1), 'C', Ic2Items.rubber });
		GameRegistry.addRecipe(new ItemStack(IUItem.Chargepadelectricblock, 1, 2),
				new Object[] { "ABA", "CDC", 'B', Blocks.stone_pressure_plate, 'A', Ic2Items.electronicCircuit, 'D',
						new ItemStack(IUItem.electricblock, 1, 2), 'C', Ic2Items.rubber });
		GameRegistry.addRecipe(new ItemStack(IUItem.Chargepadelectricblock, 1, 3),
				new Object[] { "ABA", "CDC", 'B', Blocks.stone_pressure_plate, 'A', Ic2Items.electronicCircuit, 'D',
						new ItemStack(IUItem.electricblock, 1, 5), 'C', Ic2Items.rubber });
		GameRegistry.addRecipe(new ItemStack(IUItem.Chargepadelectricblock, 1, 4),
				new Object[] { "ABA", "CDC", 'B', Blocks.stone_pressure_plate, 'A', Ic2Items.advancedCircuit, 'D',
						new ItemStack(IUItem.electricblock, 1, 3), 'C', Ic2Items.rubber });
		GameRegistry.addRecipe(new ItemStack(IUItem.Chargepadelectricblock, 1, 5),
				new Object[] { "ABA", "CDC", 'B', Blocks.stone_pressure_plate, 'A', Ic2Items.advancedCircuit, 'D',
						new ItemStack(IUItem.electricblock, 1, 4), 'C', Ic2Items.rubber });

		//
		// TODO Panels --> modules
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 0),
				new Object[] { new ItemStack(IUItem.module6, 1, 0) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 1),
				new Object[] { new ItemStack(IUItem.module6, 1, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 2),
				new Object[] { new ItemStack(IUItem.module6, 1, 2) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 3),
				new Object[] { new ItemStack(IUItem.module6, 1, 3) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 4),
				new Object[] { new ItemStack(IUItem.module6, 1, 4) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 5),
				new Object[] { new ItemStack(IUItem.module6, 1, 5) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 6),
				new Object[] { new ItemStack(IUItem.module6, 1, 6) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 7),
				new Object[] { new ItemStack(IUItem.module6, 1, 7) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 8),
				new Object[] { new ItemStack(IUItem.module6, 1, 8) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 9),
				new Object[] { new ItemStack(IUItem.module6, 1, 9) });
		// TODO modules --> Panels
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.module6, 1, 0),
				new Object[] { new ItemStack(IUItem.blockSSPSolarPanel, 1, 0) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.module6, 1, 1),
				new Object[] { new ItemStack(IUItem.blockSSPSolarPanel, 1, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.module6, 1, 2),
				new Object[] { new ItemStack(IUItem.blockSSPSolarPanel, 1, 2) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.module6, 1, 3),
				new Object[] { new ItemStack(IUItem.blockSSPSolarPanel, 1, 3) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.module6, 1, 4),
				new Object[] { new ItemStack(IUItem.blockSSPSolarPanel, 1, 4) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.module6, 1, 5),
				new Object[] { new ItemStack(IUItem.blockSSPSolarPanel, 1, 5) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.module6, 1, 6),
				new Object[] { new ItemStack(IUItem.blockSSPSolarPanel, 1, 6) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.module6, 1, 7),
				new Object[] { new ItemStack(IUItem.blockSSPSolarPanel, 1, 7) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.module6, 1, 8),
				new Object[] { new ItemStack(IUItem.blockSSPSolarPanel, 1, 8) });
		GameRegistry.addShapelessRecipe(new ItemStack(IUItem.module6, 1, 9),
				new Object[] { new ItemStack(IUItem.blockSSPSolarPanel, 1, 9) });
		// TODO modules wirelles and transformer
		GameRegistry.addRecipe(new ItemStack(IUItem.module8, 1),
				new Object[] { "AAA", " D ", "ECE", 'A', IUItem.spinel_plate, 'C', IUItem.michail_plate, 'D',
						new ItemStack(IUItem.itemSSP, 1, 4), 'E', IUItem.QuantumItems4 });
		GameRegistry.addRecipe(new ItemStack(IUItem.module7, 1, 1),
				new Object[] { "AAA", "BDB", "ECE", 'A', IUItem.compresscarbonultra, 'B', IUItem.chromium_plate, 'C',
						IUItem.wolfram_plate, 'D', new ItemStack(IUItem.itemSSP, 1, 4), 'E', IUItem.QuantumItems4 });
		GameRegistry.addRecipe(new ItemStack(IUItem.module7, 1, 2),
				new Object[] { "AAA", "BDB", "ECE", 'A', IUItem.compresscarbon, 'B', IUItem.michail_plate, 'C',
						IUItem.chromium_plate, 'D', new ItemStack(IUItem.itemSSP, 1, 4), 'E',
						IUItem.QuantumItems4 });

		GameRegistry.addRecipe(new ItemStack(IUItem.module7, 1, 3),
				new Object[] { "AAA", "BDB", "ECE", 'A', IUItem.compresscarbon, 'B', IUItem.nickelplate, 'C',
						IUItem.invarplate, 'D', new ItemStack(IUItem.itemSSP, 1, 4), 'E', IUItem.QuantumItems8 });
		GameRegistry.addRecipe(new ItemStack(IUItem.module7, 1, 4),
				new Object[] { "AAA", "BDB", "ECE", 'A', IUItem.compresscarbonultra, 'B', IUItem.spinel_plate, 'C',
						IUItem.electriumplate, 'D', new ItemStack(IUItem.itemSSP, 1, 4), 'E',
						IUItem.QuantumItems9 });

		GameRegistry.addRecipe(new ItemStack(IUItem.module7, 1, 0), new Object[] { "ACB", "A B", "   ", 'A',
				IUItem.invarplate, 'B', IUItem.electriumplate, 'C', IUItem.module3 });
		GameRegistry.addRecipe(new ItemStack(IUItem.module7, 1, 6), new Object[] { "AC ", "   ", "   ", 'A',
				new ItemStack(IUItem.module8), 'C', new ItemStack(IUItem.module7, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module7, 1, 8), new Object[] { "AC ", "   ", "   ", 'A',
				new ItemStack(IUItem.module7, 1, 6), 'C', new ItemStack(IUItem.module7, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module7, 1, 5), new Object[] { "ACA", "   ", "   ", 'A',
				new ItemStack(IUItem.module7, 1, 6), 'C', new ItemStack(IUItem.module8) });
		GameRegistry.addRecipe(new ItemStack(IUItem.module7, 1, 7), new Object[] { "ACA", "   ", "   ", 'A',
				new ItemStack(IUItem.module7, 1, 8), 'C', new ItemStack(IUItem.module8) });

		// TODO Recipes cables
		GameRegistry.addRecipe(IUItem.insulatedCopperCableItem,
				new Object[] { "BBB", "A A", "BBB", 'B', Ic2Items.glassFiberCableItem, 'A', Ic2Items.plateadviron });
		GameRegistry.addRecipe(IUItem.copperCableItem,
				new Object[] { "BBB", "A A", "BBB", 'B', IUItem.insulatedCopperCableItem, 'A', Ic2Items.platelead });
		GameRegistry.addRecipe(IUItem.goldCableItem,
				new Object[] { "BBB", "A A", "BBB", 'B', IUItem.copperCableItem, 'A', Ic2Items.denseplatelapi });
		GameRegistry.addRecipe(IUItem.insulatedGoldCableItem,
				new Object[] { "BBB", "A A", "BBB", 'B', IUItem.goldCableItem, 'A', Ic2Items.denseplateiron });
		GameRegistry.addRecipe(IUItem.doubleInsulatedGoldCableItem,
				new Object[] { "BBB", "A A", "BBB", 'B', IUItem.insulatedGoldCableItem, 'A', Ic2Items.denseplategold });
		GameRegistry.addRecipe(IUItem.ironCableItem,
				new Object[] { "BBB", "A A", "BBB", 'B', IUItem.doubleInsulatedGoldCableItem, 'A', Ic2Items.iridiumOre });
		GameRegistry.addRecipe(IUItem.insulatedIronCableItem,
				new Object[] { "BBB", "A A", "BBB", 'B', IUItem.ironCableItem, 'A', Ic2Items.iridiumPlate });
		GameRegistry.addRecipe(IUItem.doubleInsulatedIronCableItem,
				new Object[] { "BBB", "A A", "BBB", 'B', IUItem.insulatedIronCableItem, 'A', IUItem.photoniy });
		GameRegistry.addRecipe(IUItem.trippleInsulatedIronCableItem,
				new Object[] { "BBB", "AAA", "BBB", 'B', IUItem.doubleInsulatedIronCableItem, 'A', IUItem.photoniy_ingot });
		GameRegistry.addRecipe(IUItem.glassFiberCableItem, new Object[] { "BBB", "AAA", "BBB", 'B',
				IUItem.trippleInsulatedIronCableItem, 'A', IUItem.photoniy_ingot });
		GameRegistry.addRecipe(new ItemStack(IUItem.cable, 1, 10),
				new Object[] { "BBB", "AAA", "BBB", 'B', IUItem.glassFiberCableItem, 'A', IUItem.photoniy_ingot });

		// TODO recipes Molecolar Core and Recipe Molecular Transformer
		GameRegistry.addRecipe(IUItem.itemMTCore,
				new Object[] { "MXM", "M M", "MXM", 'M', IUItem.itemIrradiantGlassPane, 'X',
						new ItemStack(Ic2Items.reactorReflector.getItem(), 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addRecipe(IUItem.moleculartransformer,
				new Object[] { "MXM", "ABA", "MXM", Character.valueOf('M'), IC2Items.getItem("advancedMachine"),
						Character.valueOf('X'), IC2Items.getItem("evTransformer"), Character.valueOf('A'),
						IC2Items.getItem("advancedCircuit"), Character.valueOf('B'), IUItem.itemMTCore });
		// TODO Recipes Panels
		GameRegistry.addRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 0),
				new Object[] { "ABA", "RHR", " L ", 'B', IUItem.advanced_core, 'A', IUItem.photoniyglass1, 'H',
						IC2Items.getItem("advancedCircuit"), 'G', IC2Items.getItem("iridiumPlate"), 'R',
						IC2Items.getItem("carbonPlate"), 'Y', IUItem.photoniy, 'L', IC2Items.getItem("solarPanel") });
		GameRegistry.addRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 1),
				new Object[] { "ABA", "YDY", "DDD", 'B', IUItem.hybrid_core, 'A', IUItem.photoniyglass2, 'D',
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 0), 'Y', Ic2Items.iridiumPlate });
		GameRegistry.addRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 2),
				new Object[] { "ABA", "YDY", "DDD", 'B', IUItem.ultimate_core, 'A', IUItem.photoniyglass3, 'D',
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 1), 'Y', Ic2Items.iridiumPlate });
		GameRegistry.addRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 3),
				new Object[] { "ABA", "YDY", "DDD", 'B', IUItem.itemQuantumCore, 'A', IUItem.photoniyglass4, 'D',
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 2), 'Y', Ic2Items.iridiumPlate });
		GameRegistry.addRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 4),
				new Object[] { "ABA", "YDY", "DDD", 'B', IUItem.spectralcore, 'A', IUItem.photoniyglass5, 'D',
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 3), 'Y', IUItem.QuantumItems2 });
		GameRegistry.addRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 5),
				new Object[] { "ABA", "YDY", "DDD", 'B', IUItem.protoncore, 'A', IUItem.photoniyglass6, 'D',
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 4), 'Y', IUItem.QuantumItems2 });
		GameRegistry.addRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 6),
				new Object[] { "ABA", "YDY", "DDD", 'B', IUItem.singularcore, 'A', IUItem.photoniyglass7, 'D',
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 5), 'Y', IUItem.QuantumItems4 });
		GameRegistry.addRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 7),
				new Object[] { "ABA", "YDY", "DDD", 'B', IUItem.admincore, 'A', IUItem.photoniyglass8, 'D',
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 6), 'Y', IUItem.QuantumItems4 });
		GameRegistry.addRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 8),
				new Object[] { "ABA", "YDY", "DDD", 'B', IUItem.photoniccore, 'A', IUItem.photoniyglass9, 'D',
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 7), 'Y', IUItem.QuantumItems4 });
		GameRegistry.addRecipe(new ItemStack(IUItem.blockSSPSolarPanel, 1, 9),
				new Object[] { "ABA", "YDY", "DDD", 'B', IUItem.neutroniumcore, 'A', IUItem.photoniyglass10, 'D',
						new ItemStack(IUItem.blockSSPSolarPanel, 1, 8), 'Y', IUItem.QuantumItems4 });
		// TODO Recipes Proton Rods
		Recipes.advRecipes.addRecipe(IUItem.reactorprotonDual, new Object[] { "SQS", Character.valueOf('S'),
				IUItem.reactorprotonSimple, Character.valueOf('Q'), Ic2Items.plateiron });
		Recipes.advRecipes.addRecipe(IUItem.reactorprotonQuad,
				new Object[] { "SQS", "CQC", "SQS", Character.valueOf('S'), IUItem.reactorprotonSimple,
						Character.valueOf('Q'), Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper });

		Recipes.advRecipes.addRecipe(IUItem.reactorprotonQuad,
				new Object[] { "SQS", Character.valueOf('S'), IUItem.reactorprotonDual, Character.valueOf('Q'),
						Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper });
		Recipes.advRecipes.addRecipe(IUItem.reactorprotoneit,
				new Object[] { "SQS", Character.valueOf('S'), IUItem.reactorprotonQuad, Character.valueOf('Q'),
						Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper });
		Recipes.advRecipes.addRecipe(IUItem.reactorprotoneit,
				new Object[] { "SQS", "CQC", "SQS", Character.valueOf('S'), IUItem.reactorprotonDual,
						Character.valueOf('Q'), Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper });
		// TODO Recipes Toriy Rods
		Recipes.advRecipes.addRecipe(IUItem.reactortoriyDual, new Object[] { "SQS", Character.valueOf('S'),
				IUItem.reactortoriySimple, Character.valueOf('Q'), Ic2Items.plateiron });
		Recipes.advRecipes.addRecipe(IUItem.reactortoriyQuad,
				new Object[] { "SQS", "CQC", "SQS", Character.valueOf('S'), IUItem.reactortoriySimple,
						Character.valueOf('Q'), Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper });

		Recipes.advRecipes.addRecipe(IUItem.reactortoriyQuad,
				new Object[] { "SQS", Character.valueOf('S'), IUItem.reactortoriyDual, Character.valueOf('Q'),
						Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper });

	}
}
