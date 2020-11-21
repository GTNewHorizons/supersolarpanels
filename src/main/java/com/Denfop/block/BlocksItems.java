package com.Denfop.block;

import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.info.Info;
import ic2.core.IC2;
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
import com.Denfop.fluid.Ic2Fluid;
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
	  ;
   }
  
  private static void initFluids() {
    MaterialLiquid materialLiquid = new MaterialLiquid(MapColor.silverColor);
    registerIC2fluid(InternalName.fluidUuMatter, Material.water, 3867955, 3000, 3000, 0, 300, false);
  }
  
  private static void initItems() {
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
