package com.Denfop.block.Base;

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

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.Chargepad.BlockChargepad;
import com.Denfop.block.cable.BlockCable;
import com.Denfop.block.cable.ItemCable;
import com.Denfop.block.mechanism.BlockMachine;
import com.Denfop.fluid.Ic2Fluid;
import com.Denfop.integration.Botania.BotaniaIntegration;
import com.Denfop.integration.Botania.ItemReactorTerasteel;
import com.Denfop.item.Upgrade.ItemUpgradeModule;
import com.Denfop.item.reactor.ItemRadioactive;
import com.Denfop.item.reactor.ItemReactorHeatStorage;
import com.Denfop.item.reactor.ItemReactorproton;
import com.Denfop.item.rotor.ItemAdvancedWindRotor;
import com.Denfop.utils.InternalName;

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
	  new BlockElectric(InternalName.blockElectric);
	  SuperSolarPanels.machine1=  new BlockMachine(InternalName.blockMachine);
	  new BlockCable(InternalName.blockCable);
	  new BlockChargepad(InternalName.blockChargepad);
   }
  
  private static void initFluids() {
    MaterialLiquid materialLiquid = new MaterialLiquid(MapColor.silverColor);
    registerIC2fluid(InternalName.fluidUuMatter, Material.water, 3867955, 3000, 3000, 0, 300, false);
  }
  
  private static void initItems() {
	  SuperSolarPanels.iridium = new ItemStack((Item)new ItemAdvancedWindRotor(InternalName.iridium, SuperSolarPanels.Radius, SuperSolarPanels.durability, SuperSolarPanels.efficiency, SuperSolarPanels.minWindStrength, SuperSolarPanels.maxWindStrength, new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model1.png")));
	  SuperSolarPanels.compressiridium = new ItemStack((Item)new ItemAdvancedWindRotor(InternalName.compressiridium, SuperSolarPanels.Radius1, SuperSolarPanels.durability1, SuperSolarPanels.efficiency1, SuperSolarPanels.minWindStrength1, SuperSolarPanels.maxWindStrength1, new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model2.png")));
	  SuperSolarPanels.spectral = new ItemStack((Item)new ItemAdvancedWindRotor(InternalName.spectral, SuperSolarPanels.Radius2, SuperSolarPanels.durability2, SuperSolarPanels.efficiency2, SuperSolarPanels.minWindStrength2, SuperSolarPanels.maxWindStrength2, new ResourceLocation("supersolarpanel", "textures/items/carbon_rotor_model3.png")));
	  SuperSolarPanels.reactorDepletedprotonSimple = new ItemStack((Item)new ItemRadioactive(InternalName.reactorDepletedprotonSimple, 10, 100));
	  SuperSolarPanels.reactorDepletedprotonDual = new ItemStack((Item)new ItemRadioactive(InternalName.reactorDepletedprotonDual, 10, 100));
	    SuperSolarPanels.reactorDepletedprotonQuad = new ItemStack((Item)new ItemRadioactive(InternalName.reactorDepletedprotonQuad, 10, 100));
	    SuperSolarPanels.reactorDepletedprotoneit = new ItemStack((Item)new ItemRadioactive(InternalName.reactorDepletedprotoneit, 10, 100));
	    SuperSolarPanels.reactorprotonSimple = new ItemStack((Item)new ItemReactorproton(InternalName.reactorprotonSimple, 1));
	    SuperSolarPanels.reactorprotonDual = new ItemStack((Item)new ItemReactorproton(InternalName.reactorprotonDual, 2));
	    SuperSolarPanels.reactorprotonQuad = new ItemStack((Item)new ItemReactorproton(InternalName.reactorprotonQuad, 4));
	    SuperSolarPanels.reactorprotoneit = new ItemStack((Item)new ItemReactorproton(InternalName.reactorprotoneit, 8));
	    SuperSolarPanels.proton = new ItemRadioactive(InternalName.proton, 150, 100);
	    SuperSolarPanels.protonshard = new ItemRadioactive(InternalName.protonshard, 150, 100);
	    SuperSolarPanels.reactorCoolantmax = new ItemStack((Item)new ItemReactorHeatStorage(InternalName.reactorCoolantmax, 240000));
	    SuperSolarPanels.reactorCoolanttwelve = new ItemStack((Item)new ItemReactorHeatStorage(InternalName.reactorCoolanttwelve, 120000));
	  SuperSolarPanels.module = new ItemStack( (Item)new ItemUpgradeModule(InternalName.upgradeModule));
	  SuperSolarPanels.cable = new ItemCable(InternalName.itemCable);
	    SuperSolarPanels.cell = new ItemStack((Item)new ItemCell(InternalName.itemCellEmpty));
	    if(SuperSolarPanels.BotaniaLoaded) {
	    	BotaniaIntegration.reactorterastrellSimple = new ItemStack((Item)new ItemReactorTerasteel(InternalName.reactorterastrellSimple, 1));
	    	BotaniaIntegration.reactorterastrellDual = new ItemStack((Item)new ItemReactorTerasteel(InternalName.reactorterastrellDual, 2));
	    	BotaniaIntegration.reactorterastrellQuad = new ItemStack((Item)new ItemReactorTerasteel(InternalName.reactorterastrellQuad, 4));
	    	BotaniaIntegration.reactorDepletedterastrellSimple = new ItemStack((Item)new ItemRadioactive(InternalName.reactorDepletedterastrellSimple, 10, 100));
	    	BotaniaIntegration.reactorDepletedterastrellDual = new ItemStack((Item)new ItemRadioactive(InternalName.reactorDepletedterastrellDual, 10, 100));
	    	BotaniaIntegration.reactorDepletedterastrellQuad = new ItemStack((Item)new ItemRadioactive(InternalName.reactorDepletedterastrellQuad, 10, 100));
	  	    
	    }
  }
  
  private static void initMigration() {
    renames.put("blockfluidUuMatter", InternalName.fluidUuMatter);
   
  }
  
  private static void registerIC2fluid(InternalName internalName, Material material, int color, int density, int viscosity, int luminosity, int temperature, boolean isGaseous) {
    Block block = null;
    if (!internalName.name().startsWith("fluid"))
      throw new IllegalArgumentException("Invalid fluid block name: " + internalName); 
    String fluidName = "ic3" + internalName.name().substring("fluid".length()).toLowerCase(Locale.ENGLISH);
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
      InternalName newName = renames.get(subName);
      if (newName != null) {
        String name = "IC2:" + newName.name();
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
  
  public static Fluid getFluid(InternalName name) {
    return fluids.get(name);
  }
  
  public static Block getFluidBlock(InternalName name) {
    return fluidBlocks.get(name);
  }
  
  public static Collection<InternalName> getIc2FluidNames() {
    return fluids.keySet();
  }
  
  private static Map<InternalName, Fluid> fluids = new EnumMap<InternalName, Fluid>(InternalName.class);
  
  private static Map<InternalName, Block> fluidBlocks = new EnumMap<InternalName, Block>(InternalName.class);
  
  private static Map<String, InternalName> renames = new HashMap<String, InternalName>();
  
  private static Set<String> dropped = new HashSet<String>();
}
