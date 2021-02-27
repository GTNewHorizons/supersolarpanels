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
import com.Denfop.SuperSolarPanels;
import com.Denfop.SuperSolarPanels.FluidXP;
import com.Denfop.block.Chargepad.BlockChargepad;
import com.Denfop.block.cable.BlockCable;
import com.Denfop.block.expgen.BlockExpGen;
import com.Denfop.block.expgen.TextureHooks;
import com.Denfop.block.mechanism.BlockMachine;
import com.Denfop.fluid.Ic2Fluid;
import com.Denfop.integration.Botania.BotaniaIntegration;
import com.Denfop.integration.Botania.ItemReactorTerasteel;
import com.Denfop.item.Modules.ItemWirelessModule;
import com.Denfop.item.Upgrade.ItemUpgradeModule;
import com.Denfop.item.armour.ItemArmorImprovemedQuantum;
import com.Denfop.item.base.ItemCable;
import com.Denfop.item.energy.ItemBattery;
import com.Denfop.item.energy.ItemNanoSaber;
import com.Denfop.item.energy.ItemNanoSaber1;
import com.Denfop.item.energy.ultDDrill;
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
    registerIC2fluid("fluidUuMatter", Material.water, 3867955, 3000, 3000, 0, 300, false);
	 if (!Loader.isModLoaded("OpenBlocks")) {
		 FluidRegistry.registerFluid(FluidXP.xpJuice);
		 FluidXP.xpJuice.setIcons(TextureHooks.Icons.xpJuiceStill, TextureHooks.Icons.xpJuiceFlowing);
		 }else {
			 
			 FluidXP.xpJuice = FluidRegistry.getFluid("xpjuice");
		 }
  }
  
  private static void initItems() {
	  SuperSolarPanels.photon = new ItemStack((Item)new ItemAdvancedWindRotor("photon", SuperSolarPanels.Radius3, SuperSolarPanels.durability3, SuperSolarPanels.efficiency3, SuperSolarPanels.minWindStrength3, SuperSolarPanels.maxWindStrength3, new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model6.png")));
	  SuperSolarPanels.neutron = new ItemStack((Item)new ItemAdvancedWindRotor("neutron", SuperSolarPanels.Radius4, SuperSolarPanels.durability4, SuperSolarPanels.efficiency4, SuperSolarPanels.minWindStrength4, SuperSolarPanels.maxWindStrength4, new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model5.png")));
	  SuperSolarPanels.myphical = new ItemStack((Item)new ItemAdvancedWindRotor("myphical", SuperSolarPanels.Radius5, SuperSolarPanels.durability5, SuperSolarPanels.efficiency5, SuperSolarPanels.minWindStrength5, SuperSolarPanels.maxWindStrength5, new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model4.png")));
	  SuperSolarPanels.electricblock = new BlockElectric();
      SuperSolarPanels.mfeUnit = new ItemStack(SuperSolarPanels.electricblock, 1, 0);
      SuperSolarPanels.mfsUnit = new ItemStack(SuperSolarPanels.electricblock, 1, 1);
      SuperSolarPanels.electricblock.setCreativeTab(SuperSolarPanels.tabssp);
      SuperSolarPanels.machines = new BlockMachine();
      SuperSolarPanels.machines.setCreativeTab(SuperSolarPanels.tabssp);
      SuperSolarPanels.ultDDrill = new ultDDrill(Item.ToolMaterial.EMERALD).setUnlocalizedName("advDDrill");

      SuperSolarPanels.lapotronCrystal = new ItemBattery("itemBatLamaCrystal", SuperSolarPanels.Storagequantumsuit, 8092.0D, 4);
      SuperSolarPanels.  nanoSaber = new ItemNanoSaber("itemNanoSaber",SuperSolarPanels.maxCharge,SuperSolarPanels.transferLimit,SuperSolarPanels.tier,SuperSolarPanels.spectralsaberactive,SuperSolarPanels.spectralsabernotactive);
      SuperSolarPanels.   nanoSaber1 = new ItemNanoSaber1("itemNanoSaber1",SuperSolarPanels.maxCharge1,SuperSolarPanels.transferLimit1,SuperSolarPanels.tier1,SuperSolarPanels.spectralsaberactive1,SuperSolarPanels.spectralsabernotactive1);
      SuperSolarPanels.  quantumHelmet = new ItemArmorImprovemedQuantum("itemArmorQuantumHelmet", 0, Config.armor_maxcharge, Config.armor_transferlimit, Config.tier);
      SuperSolarPanels.   quantumBodyarmor = new ItemArmorImprovemedQuantum("itemArmorQuantumChestplate", 1, Config.armor_maxcharge_body, Config.armor_transferlimit, Config.tier);
      SuperSolarPanels.    quantumLeggings = new ItemArmorImprovemedQuantum("itemArmorQuantumLegs", 2, Config.armor_maxcharge, Config.armor_transferlimit, Config.tier);
      SuperSolarPanels.   quantumBoots = new ItemArmorImprovemedQuantum("itemArmorQuantumBoots", 3, Config.armor_maxcharge, Config.armor_transferlimit, Config.tier);
    
		
      SuperSolarPanels.expgen = new BlockExpGen("expGen", Material.rock);
      SuperSolarPanels.module8 = new ItemWirelessModule();
	  //
	  SuperSolarPanels.iridium = new ItemStack((Item)new ItemAdvancedWindRotor("iridium", SuperSolarPanels.Radius, SuperSolarPanels.durability, SuperSolarPanels.efficiency, SuperSolarPanels.minWindStrength, SuperSolarPanels.maxWindStrength, new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model1.png")));
	  SuperSolarPanels.compressiridium = new ItemStack((Item)new ItemAdvancedWindRotor("compressiridium", SuperSolarPanels.Radius1, SuperSolarPanels.durability1, SuperSolarPanels.efficiency1, SuperSolarPanels.minWindStrength1, SuperSolarPanels.maxWindStrength1, new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model2.png")));
	  SuperSolarPanels.spectral = new ItemStack((Item)new ItemAdvancedWindRotor("spectral", SuperSolarPanels.Radius2, SuperSolarPanels.durability2, SuperSolarPanels.efficiency2, SuperSolarPanels.minWindStrength2, SuperSolarPanels.maxWindStrength2, new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model3.png")));
	  SuperSolarPanels.reactorDepletedprotonSimple = new ItemStack((Item)new ItemRadioactive("reactorDepletedprotonSimple", 10, 100));
	  SuperSolarPanels.reactorDepletedprotonDual = new ItemStack((Item)new ItemRadioactive("reactorDepletedprotonDual", 10, 100));
	    SuperSolarPanels.reactorDepletedprotonQuad = new ItemStack((Item)new ItemRadioactive("reactorDepletedprotonQuad", 10, 100));
	    SuperSolarPanels.reactorDepletedprotoneit = new ItemStack((Item)new ItemRadioactive("reactorDepletedprotoneit", 10, 100));
	    SuperSolarPanels.reactorprotonSimple = new ItemStack((Item)new ItemReactorproton("reactorprotonSimple", 1,SuperSolarPanels.ProtonRodCells,SuperSolarPanels.ProtonRodHeat,SuperSolarPanels.ProtonPower));
	    SuperSolarPanels.reactorprotonDual = new ItemStack((Item)new ItemReactorproton("reactorprotonDual", 2,SuperSolarPanels.ProtonRodCells,SuperSolarPanels.ProtonRodHeat,SuperSolarPanels.ProtonPower));
	    SuperSolarPanels.reactorprotonQuad = new ItemStack((Item)new ItemReactorproton("reactorprotonQuad", 4,SuperSolarPanels.ProtonRodCells,SuperSolarPanels.ProtonRodHeat,SuperSolarPanels.ProtonPower));
	    SuperSolarPanels.reactorprotoneit = new ItemStack((Item)new ItemReactorproton("reactorprotoneit", 8,SuperSolarPanels.ProtonRodCells,SuperSolarPanels.ProtonRodHeat,SuperSolarPanels.ProtonPower));
	    SuperSolarPanels.proton = new ItemRadioactive("proton", 150, 100);
	    SuperSolarPanels.toriy = new ItemRadioactive("toriy", 150, 100);
	    //
	    SuperSolarPanels.reactortoriySimple = new ItemStack((Item)new ItemReactorproton("reactortoriySimple", 1,Config.toriyRodCells,Config.toriyRodHeat,Config.toriyPower));
	    SuperSolarPanels.reactortoriyDual = new ItemStack((Item)new ItemReactorproton("reactortoriyDual", 2,Config.toriyRodCells,Config.toriyRodHeat,Config.toriyPower));
	    SuperSolarPanels.reactortoriyQuad = new ItemStack((Item)new ItemReactorproton("reactortoriyQuad", 4,Config.toriyRodCells,Config.toriyRodHeat,Config.toriyPower));
		  SuperSolarPanels.reactorDepletedtoriySimple = new ItemStack((Item)new ItemRadioactive("reactorDepletedtoriySimple", 10, 100));
		  SuperSolarPanels.reactorDepletedtoriyDual = new ItemStack((Item)new ItemRadioactive("reactorDepletedtoriyDual", 10, 100));
		    SuperSolarPanels.reactorDepletedtoriyQuad = new ItemStack((Item)new ItemRadioactive("reactorDepletedtoriyQuad", 10, 100));
	    //
		 
	    SuperSolarPanels.protonshard = new ItemRadioactive("protonshard", 150, 100);
	    SuperSolarPanels.reactorCoolantmax = new ItemStack((Item)new ItemReactorHeatStorage("reactorCoolantmax", 240000));
	    SuperSolarPanels.reactorCoolanttwelve = new ItemStack((Item)new ItemReactorHeatStorage("reactorCoolanttwelve", 120000));
	  SuperSolarPanels.module =new ItemUpgradeModule();
	  SuperSolarPanels.cable = new ItemCable();
	
	    if(SuperSolarPanels.BotaniaLoaded) {
	    	BotaniaIntegration.reactorterastrellSimple = new ItemStack((Item)new ItemReactorTerasteel("reactorterastrellSimple", 1));
	    	BotaniaIntegration.reactorterastrellDual = new ItemStack((Item)new ItemReactorTerasteel("reactorterastrellDual", 2));
	    	BotaniaIntegration.reactorterastrellQuad = new ItemStack((Item)new ItemReactorTerasteel("reactorterastrellQuad", 4));
	    	BotaniaIntegration.reactorDepletedterastrellSimple = new ItemStack((Item)new ItemRadioactive("reactorDepletedterastrellSimple", 10, 100));
	    	BotaniaIntegration.reactorDepletedterastrellDual = new ItemStack((Item)new ItemRadioactive("reactorDepletedterastrellDual", 10, 100));
	    	BotaniaIntegration.reactorDepletedterastrellQuad = new ItemStack((Item)new ItemRadioactive("reactorDepletedterastrellQuad", 10, 100));
	  	    
	    }
  }
  
  private static void initMigration() {
    renames.put("blockfluidUuMatter", "fluidUuMatter");
   
  }
  
  private static void registerIC2fluid(String internalName, Material material, int color, int density, int viscosity, int luminosity, int temperature, boolean isGaseous) {
    Block block = null;
    if (!internalName.startsWith("fluid"))
      throw new IllegalArgumentException("Invalid fluid block name: " + internalName); 
    String fluidName = "ic3" + internalName.substring("fluid".length()).toLowerCase(Locale.ENGLISH);
    Fluid fluid = (new Ic2Fluid(fluidName)).setDensity(density).setViscosity(viscosity).setLuminosity(luminosity).setTemperature(temperature).setGaseous(isGaseous);
    if (!FluidRegistry.registerFluid(fluid))
      fluid = FluidRegistry.getFluid(fluidName); 
    if (!fluid.canBePlacedInWorld()) {
      BlockIC2Fluid blockIC2Fluid = new BlockIC2Fluid(internalName, fluid, material, color);
      fluid.setBlock((Block)blockIC2Fluid);
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
          mapping.remap((Block)GameData.getBlockRegistry().getRaw(name));
          continue;
        } 
        mapping.remap((Item)GameData.getItemRegistry().getRaw(name));
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
	  SuperSolarPanels.   itemIrradiantUranium = new ItemStack(SuperSolarPanels.itemSSP.setUnlocalizedName("itemIrradiantUranium"), 1, 0);
      SuperSolarPanels.   itemEnrichedPhotoniyAlloy = new ItemStack(SuperSolarPanels.itemSSP.setUnlocalizedName("itemEnrichedSunnariumAlloy"), 1, 1);
      SuperSolarPanels.   itemIrradiantGlassPane = new ItemStack(SuperSolarPanels.itemSSP.setUnlocalizedName("itemIrradiantGlassPlane"), 1, 3);
      SuperSolarPanels.    itemIridiumIronPlate = new ItemStack(SuperSolarPanels.itemSSP.setUnlocalizedName("itemIridiumIronPlate"), 1, 4);
      SuperSolarPanels.    itemReinforcedIridiumIronPlate = new ItemStack(SuperSolarPanels.itemSSP.setUnlocalizedName("itemReinforcedIridiumIronPlate"), 1, 5);
      SuperSolarPanels.   itemIrradiantReinforcedPlate = new ItemStack(SuperSolarPanels.itemSSP.setUnlocalizedName("itemIrradiantReinforcedPlate"), 1, 6);
      
      SuperSolarPanels.  ingotIridium = new ItemStack(SuperSolarPanels.itemSSP.setUnlocalizedName("ingotIridium"), 1, 7);
      SuperSolarPanels.   itemUranIngot = new ItemStack(SuperSolarPanels.itemSSP.setUnlocalizedName("itemUranIngot"), 1, 8);
      SuperSolarPanels.  itemMTCore = new ItemStack(SuperSolarPanels.itemSSP.setUnlocalizedName("itemMTCore"), 1, 9);
      SuperSolarPanels.   itemQuantumCore = new ItemStack(SuperSolarPanels.itemSSP.setUnlocalizedName("itemQuantumCore"), 1, 10);
      

      SuperSolarPanels.      module61  = new ItemStack(SuperSolarPanels.module6.setUnlocalizedName("module61"), 1, 0);
      SuperSolarPanels.   module62 = new ItemStack(SuperSolarPanels.module6.setUnlocalizedName("module62"), 1, 1);
      SuperSolarPanels.   module63= new ItemStack(SuperSolarPanels.module6.setUnlocalizedName("module63"), 1, 2);
    SuperSolarPanels.   module64= new ItemStack(SuperSolarPanels.module6.setUnlocalizedName("module64"), 1, 3);
    SuperSolarPanels.  module65= new ItemStack(SuperSolarPanels.module6.setUnlocalizedName("module65"), 1, 4);
    SuperSolarPanels.   module66= new ItemStack(SuperSolarPanels.module6.setUnlocalizedName("module66"), 1, 5);
    SuperSolarPanels.    module67= new ItemStack(SuperSolarPanels.module6.setUnlocalizedName("module67"), 1, 6);
    SuperSolarPanels.   module68= new ItemStack(SuperSolarPanels.module6.setUnlocalizedName("module68"), 1, 7);
    SuperSolarPanels.   module69= new ItemStack(SuperSolarPanels.module6.setUnlocalizedName("module69"), 1, 8);
    SuperSolarPanels.    module70 = new ItemStack(SuperSolarPanels.module6.setUnlocalizedName("module70"), 1, 9);
    SuperSolarPanels.   module71  = new ItemStack(SuperSolarPanels.module7.setUnlocalizedName("module71"), 1, 0);
     SuperSolarPanels. module72 = new ItemStack(SuperSolarPanels.module7.setUnlocalizedName("module72"), 1, 1);
    SuperSolarPanels.module73= new ItemStack(SuperSolarPanels.module7.setUnlocalizedName("module73"), 1, 2);
    SuperSolarPanels.copperCableBlock = new ItemStack((Block)SuperSolarPanels.BlockCable, 1, 1);
    SuperSolarPanels.insulatedCopperCableBlock = new ItemStack((Block)SuperSolarPanels.BlockCable, 1, 0);
    SuperSolarPanels.goldCableBlock = new ItemStack((Block)SuperSolarPanels.BlockCable, 1, 2);
    SuperSolarPanels.insulatedGoldCableBlock = new ItemStack((Block)SuperSolarPanels.BlockCable, 1, 3);
    SuperSolarPanels.doubleInsulatedGoldCableBlock = new ItemStack((Block)SuperSolarPanels.BlockCable, 1, 4);
    SuperSolarPanels.ironCableBlock = new ItemStack((Block)SuperSolarPanels.BlockCable, 1, 5);
    SuperSolarPanels.insulatedIronCableBlock = new ItemStack((Block)SuperSolarPanels.BlockCable, 1, 6);
    SuperSolarPanels.doubleInsulatedIronCableBlock = new ItemStack((Block)SuperSolarPanels.BlockCable, 1, 7);
    SuperSolarPanels.trippleInsulatedIronCableBlock = new ItemStack((Block)SuperSolarPanels.BlockCable, 1, 8);
    SuperSolarPanels.glassFiberCableBlock = new ItemStack((Block)SuperSolarPanels.BlockCable, 1, 9);


    SuperSolarPanels.copperCableItem = new ItemStack((Item)SuperSolarPanels.cable, 1, 1);
    SuperSolarPanels.insulatedCopperCableItem = new ItemStack((Item)SuperSolarPanels.cable, 1, 0);
    SuperSolarPanels.goldCableItem = new ItemStack((Item)SuperSolarPanels.cable, 1, 2);
    SuperSolarPanels.insulatedGoldCableItem = new ItemStack((Item)SuperSolarPanels.cable, 1, 3);
    SuperSolarPanels.doubleInsulatedGoldCableItem = new ItemStack((Item)SuperSolarPanels.cable, 1, 4);
    SuperSolarPanels.ironCableItem = new ItemStack((Item)SuperSolarPanels.cable, 1, 5);
    SuperSolarPanels.insulatedIronCableItem = new ItemStack((Item)SuperSolarPanels.cable, 1, 6);
    SuperSolarPanels.doubleInsulatedIronCableItem = new ItemStack((Item)SuperSolarPanels.cable, 1, 7);
    SuperSolarPanels.trippleInsulatedIronCableItem = new ItemStack((Item)SuperSolarPanels.cable, 1, 8);
    SuperSolarPanels.glassFiberCableItem = new ItemStack((Item)SuperSolarPanels.cable, 1, 9);
  //  SuperSolarPanels.macerator = new ItemStack(SuperSolarPanels.machines, 1, 1);
  //  SuperSolarPanels.extractor = new ItemStack(SuperSolarPanels.machines, 1, 2);
 //   SuperSolarPanels.compressor = new ItemStack(SuperSolarPanels.machines, 1, 3);


    SuperSolarPanels.massFabricator = new ItemStack(SuperSolarPanels.machines, 1, 5);
 //   SuperSolarPanels.compressor1 = new ItemStack(SuperSolarPanels.machines, 1, 4);
    SuperSolarPanels.massFabricator1 = new ItemStack(SuperSolarPanels.machines, 1, 1);
   // SuperSolarPanels.macerator1 = new ItemStack(SuperSolarPanels.machines, 1, 6);
  //  SuperSolarPanels.electroFurnace = new ItemStack(SuperSolarPanels.machines, 1, 7);
 //   SuperSolarPanels.electroFurnace1 = new ItemStack(SuperSolarPanels.machines, 1, 8);
    SuperSolarPanels.massFabricator2 = new ItemStack(SuperSolarPanels.machines, 1, 2);
    SuperSolarPanels.massFabricator3 = new ItemStack(SuperSolarPanels.machines, 1, 3);
 //   SuperSolarPanels.metalformer = new ItemStack(SuperSolarPanels.machines, 1, 11);
 //   SuperSolarPanels.metalformer1 = new ItemStack(SuperSolarPanels.machines, 1, 12);
    SuperSolarPanels.alloymachine = new ItemStack(SuperSolarPanels.machines, 1, 4);
    SuperSolarPanels.generationmicrochip = new ItemStack(SuperSolarPanels.machines, 1, 6);
    SuperSolarPanels.moleculartransformer= new ItemStack(SuperSolarPanels.machines, 1, 0);
		
	
}
}
