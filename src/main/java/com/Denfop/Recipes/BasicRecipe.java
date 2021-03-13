package com.Denfop.Recipes;

import com.Denfop.SSPItem;
import com.Denfop.IUCore;
import com.Denfop.tiles.NeutroniumGenerator.TileBitGen2;


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
	GameRegistry.addRecipe(new ItemStack(SSPItem.itemSSP,1,4), new Object[] { 
            "ABA", "DCD", "AFA", Character.valueOf('A'), Items.redstone, Character.valueOf('B'), SSPItem.photoniy, Character.valueOf('D'), new ItemStack(Items.dye, 1, 4), Character.valueOf('C'), 
            new ItemStack(SSPItem.itemSSP,1,5), Character.valueOf('F'), Items.diamond });
 
     //TODO craft matter`s
	 GameRegistry.addRecipe(new ItemStack(SSPItem.matter,1,1), new Object[] { "A A", "AAA", "A A",  'A',  new ItemStack(SSPItem.matter,1,0)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.matter,1,2), new Object[] { "AAA", "A A", "AAA",  'A',  new ItemStack(SSPItem.matter,1,0)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.matter,1,3), new Object[] { "A A", "A A", "A A",  'A',  new ItemStack(SSPItem.matter,1,0)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.matter,1,4), new Object[] { "A A", " A ", "A A",  'A',  new ItemStack(SSPItem.matter,1,0)});
		
	 GameRegistry.addRecipe(new ItemStack(SSPItem.matter,1,5), new Object[] { "A  ", "AAA", "  A",  'A',  new ItemStack(SSPItem.matter,1,0)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.matter,1,6), new Object[] { "A A", " A ", " A ",  'A',  new ItemStack(SSPItem.matter,1,0)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.matter,1,7), new Object[] { "A A", "A A", " A ",  'A',  new ItemStack(SSPItem.matter,1,0)});
		
	 //TODO craft lenses
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module5,1,5), new Object[] { " B ", "AAA", "   ",  'A',  new ItemStack(SSPItem.sunlinse,1), 'B', new ItemStack(SSPItem.QuantumItems9,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module5,1,6), new Object[] { " B ", "AAA", "   ",  'A',  new ItemStack(SSPItem.rainlinse,1), 'B', new ItemStack(SSPItem.QuantumItems9,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module5,1,2), new Object[] { " B ", "AAA", "   ",  'A',  new ItemStack(SSPItem.netherlinse,1), 'B', new ItemStack(SSPItem.QuantumItems8,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module5,1,4), new Object[] { " B ", "AAA", "   ",  'A',  new ItemStack(SSPItem.nightlinse,1), 'B', new ItemStack(SSPItem.QuantumItems8,1)});
		
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module5,1,1), new Object[] { " B ", "AAA", "   ",  'A',  new ItemStack(SSPItem.earthlinse,1), 'B', new ItemStack(SSPItem.QuantumItems9,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module5,1,3), new Object[] { " B ", "AAA", "   ",  'A',  new ItemStack(SSPItem.endlinse,1), 'B', new ItemStack(SSPItem.QuantumItems8,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module5,1,0), new Object[] { " B ", "AAA", "   ",  'A',  new ItemStack(SSPItem.aerlinse,1), 'B', new ItemStack(SSPItem.QuantumItems8,1)});
	
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module9,1,0), new Object[] { "CBD", " A ", "DBC",  'A',  Ic2Items.advancedCircuit, 'B', new ItemStack(SSPItem.caravky_ingot,1),'C', new ItemStack(SSPItem.invaringot,1),'D', new ItemStack(SSPItem.electriumingot,1) });
		
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module9,1,1), new Object[] { "CBD", " A ", "DBC",  'A',  SSPItem.overclockerUpgrade1, 'B', new ItemStack(SSPItem.caravky_ingot,1),'C', new ItemStack(SSPItem.invarplate,1),'D', new ItemStack(SSPItem.electriumplate,1) });
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module9,1,2), new Object[] { "CBD", " A ", "DBC",  'A',  new ItemStack(SSPItem.module9,1,1), 'B', new ItemStack(SSPItem.QuantumItems,1),'C', new ItemStack(SSPItem.photoniy,1),'D', new ItemStack(SSPItem.advanced_core,1) });
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module9,1,3), new Object[] { "CBD", " A ", "DBC",  'A',  new ItemStack(SSPItem.module9,1,2), 'B', new ItemStack(SSPItem.QuantumItems3,1),'C', new ItemStack(SSPItem.photoniy_ingot,1),'D', new ItemStack(SSPItem.hybrid_core,1) });
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module9,1,4), new Object[] { "CBD", " A ", "DBC",  'A',  new ItemStack(SSPItem.module9,1,3), 'B', new ItemStack(SSPItem.QuantumItems8,1),'C', new ItemStack(SSPItem.QuantumItems6,1),'D', new ItemStack(SSPItem.ultimate_core,1) });
	 GameRegistry.addRecipe(new ItemStack(SSPItem.module9,1,5), new Object[] { "CBD", " A ", "DBC",  'A',  new ItemStack(SSPItem.module9,1,4), 'B', new ItemStack(SSPItem.QuantumItems9,1),'C', new ItemStack(SSPItem.QuantumItems7,1),'D', new ItemStack(SSPItem.spectralcore,1) });
	//
	 GameRegistry.addRecipe(new ItemStack(SSPItem.nanoaxe,1), new Object[] { " B ", "CAC", " B ",  'A', Items.diamond_axe, 'B', new ItemStack(SSPItem.QuantumItems9,1),'C', new ItemStack(SSPItem.photoniy,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.nanopickaxe,1), new Object[] { " B ", "CAC", " B ",   'A', Items.diamond_pickaxe, 'B', new ItemStack(SSPItem.QuantumItems9,1),'C', new ItemStack(SSPItem.photoniy,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.nanoshovel,1), new Object[] {  " B ", "CAC", " B ",   'A',  Items.diamond_shovel, 'B', new ItemStack(SSPItem.QuantumItems9,1),'C', new ItemStack(SSPItem.photoniy,1) });
	
	 
	 GameRegistry.addRecipe(new ItemStack(SSPItem.quantumaxe,1), new Object[] { " B ", "CAC", " B ",  'A', new ItemStack(SSPItem.nanoaxe,1), 'B', new ItemStack(SSPItem.QuantumItems8,1),'C', new ItemStack(SSPItem.QuantumItems6,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.quantumpickaxe,1), new Object[] { " B ", "CAC", " B ",   'A', new ItemStack(SSPItem.nanopickaxe,1), 'B', new ItemStack(SSPItem.QuantumItems8,1),'C', new ItemStack(SSPItem.QuantumItems6,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.quantumshovel,1), new Object[] {  " B ", "CAC", " B ",   'A',  new ItemStack(SSPItem.nanoshovel,1), 'B', new ItemStack(SSPItem.QuantumItems8,1),'C', new ItemStack(SSPItem.QuantumItems6,1) });
	
	 GameRegistry.addRecipe(new ItemStack(SSPItem.spectralaxe,1), new Object[] { " B ", "CAC", " B ",  'A', new ItemStack(SSPItem.quantumaxe,1), 'B', new ItemStack(SSPItem.QuantumItems5,1),'C', new ItemStack(SSPItem.QuantumItems3,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.spectralpickaxe,1), new Object[] { " B ", "CAC", " B ",   'A', new ItemStack(SSPItem.quantumpickaxe,1), 'B', new ItemStack(SSPItem.QuantumItems5,1),'C', new ItemStack(SSPItem.QuantumItems3,1)});
	 GameRegistry.addRecipe(new ItemStack(SSPItem.spectralshovel,1), new Object[] {  " B ", "CAC", " B ",   'A',  new ItemStack(SSPItem.quantumshovel,1), 'B', new ItemStack(SSPItem.QuantumItems5,1),'C', new ItemStack(SSPItem.QuantumItems3,1) });
	
	 //TODO Recipe Ultimate Drill
	  GameRegistry.addRecipe(new ItemStack(SSPItem.ultDDrill,1,OreDictionary.WILDCARD_VALUE), new Object[] { " L ", "ODO", "COC",  'O',  SSPItem.overclockerUpgrade1, 'D' , new ItemStack(Ic2Items.diamondDrill.getItem(),1,OreDictionary.WILDCARD_VALUE), 'C' ,SSPItem.QuantumItems5,'L',SSPItem.QuantumItems3});
  	
      //TODO Recipe Advanced and Improvemed Overclockers
      GameRegistry.addRecipe(SSPItem.overclockerUpgrade ,new Object[] {  "BAB",   'A' , Ic2Items.overclockerUpgrade,'B',SSPItem.QuantumItems9 });
      GameRegistry.addRecipe(SSPItem.overclockerUpgrade1 ,new Object[] {  "BAB",   'A' ,SSPItem.overclockerUpgrade,'B',SSPItem.QuantumItems8 });
    //TODO Reciper Rotor`s
      GameRegistry.addRecipe(SSPItem.myphical ,new Object[] { " B ", "BAB",  " B ", 'A' ,SSPItem.spectral,'B',SSPItem.QuantumItems5 });
      GameRegistry.addRecipe(SSPItem.photon ,new Object[] { " B ", "BAB",  " B ", 'A' , SSPItem.myphical,'B',SSPItem.QuantumItems8 });
      GameRegistry.addRecipe(SSPItem.neutron ,new Object[] { "CBC", "BAB",  "CBC", 'A' , SSPItem.photon,'B',SSPItem.QuantumItems9,'C', Ic2Items.iridiumPlate });
   
      GameRegistry.addRecipe(SSPItem.iridium ,new Object[] { " B ", "BAB",  " B ", 'A' , Ic2Items.carbonrotor,'B',Ic2Items.iridiumPlate });
      GameRegistry.addRecipe(SSPItem.compressiridium ,new Object[] { " B ", "BAB",  " B ", 'A' , SSPItem.iridium,'B',SSPItem.compresscarbon });
      GameRegistry.addRecipe(SSPItem.spectral ,new Object[] { "C C", "BAB",  "C C", 'A' , SSPItem.compressiridium,'B',SSPItem.QuantumItems5,'C', Ic2Items.iridiumPlate });
      GameRegistry.addRecipe(SSPItem.reactorCoolanttwelve ,new Object[] { "CCC", "ABA",  "CCC", 'A' , Ic2Items.reactorCoolantSix,'B',Ic2Items.plateiron,'C', Ic2Items.platetin });
      GameRegistry.addRecipe(SSPItem.reactorCoolantmax ,new Object[] { "CCC", "ABA",  "CCC", 'A' , SSPItem.reactorCoolanttwelve,'B',Ic2Items.plateiron,'C', Ic2Items.platetin });
      
       //TODO Recipes Machines and Quantum/Nano Chip
      Recipes.advRecipes.addRecipe(new ItemStack(SSPItem.QuantumItems9, 1), new Object[] { 
    		  " D ","BAB"," C ", Character.valueOf('A'), Ic2Items.advancedCircuit, Character.valueOf('B'), new ItemStack(SSPItem.nanoBox,1), Character.valueOf('C'), OreDictionary.getOres("ingotNickel").get(0), Character.valueOf('D'), 
    		  SSPItem.compresscarbon }); 
   
       GameRegistry.addRecipe(new ItemStack(SSPItem.QuantumItems8,1) ,new Object[] {  "DCD","HAH",   'A' , SSPItem.QuantumItems9,'C',SSPItem.magnesium_ingot,'D',SSPItem.compresscarbonultra ,'H',SSPItem.QuantumItems6});
      GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,0),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.platium_plate,'B',SSPItem.QuantumItems9,'C',Ic2Items.macerator,'D',SSPItem.QuantumItems6});
    GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,6),new Object[] {"AAA","BCB","DDD", 'A',SSPItem. chromium_plate,'B',SSPItem.QuantumItems9,'C',Ic2Items.electroFurnace,'D',SSPItem.QuantumItems6});
    GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,7),new Object[] {"AAA","BCB","DDD", 'A',SSPItem.wolfram_plate,'B',SSPItem.QuantumItems8,'C',new ItemStack(SSPItem.machines_base,1,6),'D',SSPItem.QuantumItems3});
    GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,8),new Object[] {"AAA","BCB","DDD", 'A',SSPItem.michail_plate,'B',SSPItem.QuantumItems5,'C',new ItemStack(SSPItem.machines_base,1,7),'D',SSPItem.QuantumItems3});
    
    GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,3),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.wolfram_plate,'B',SSPItem.QuantumItems9,'C',Ic2Items.compressor,'D',SSPItem.QuantumItems6});
      GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,4),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.magnesium_plate,'B',SSPItem.QuantumItems8,'C',new ItemStack(SSPItem.machines_base,1,3),'D',SSPItem.QuantumItems3});
      GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,5),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.chromium_plate,'B',SSPItem.QuantumItems5,'C',new ItemStack(SSPItem.machines_base,1,4),'D',SSPItem.QuantumItems3});
      
      GameRegistry.addRecipe(SSPItem.massFabricator1,new Object[] {"AAA","BCB","DDD", 'A', SSPItem.magnesium_plate,'B',SSPItem.QuantumItems9,'C',Ic2Items.massFabricator,'D',SSPItem.QuantumItems6});
      GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,1),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.chromium_plate,'B',SSPItem.QuantumItems8,'C',new ItemStack(SSPItem.machines_base,1,0),'D',SSPItem.QuantumItems3});
      GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,2),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.magnesium_plate,'B',SSPItem.QuantumItems5,'C',new ItemStack(SSPItem.machines_base,1,1),'D',SSPItem.QuantumItems3});
      
       GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,9),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.chromium_plate,'B',SSPItem.QuantumItems9,'C',Ic2Items.extractor,'D',SSPItem.QuantumItems6});
      GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,10),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.wolfram_plate,'B',SSPItem.QuantumItems8,'C',new ItemStack(SSPItem.machines_base,1,9),'D',SSPItem.QuantumItems3});
      GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,11),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.michail_plate,'B',SSPItem.QuantumItems5,'C',new ItemStack(SSPItem.machines_base,1,10),'D',SSPItem.QuantumItems3});
      
      GameRegistry.addRecipe(SSPItem.massFabricator2,new Object[] {"AAA","BCB","DDD", 'A', SSPItem.platium_plate,'B',SSPItem.QuantumItems8,'C',SSPItem.massFabricator1,'D',SSPItem.QuantumItems6});
      GameRegistry.addRecipe(SSPItem.massFabricator3,new Object[] {"AAA","BCB","DDD", 'A', SSPItem.spinel_plate,'B',SSPItem.QuantumItems5,'C',SSPItem.massFabricator2,'D',SSPItem.QuantumItems3});
    GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,12),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.magnesium_plate,'B',SSPItem.QuantumItems9,'C',Ic2Items.metalformer,'D',SSPItem.QuantumItems6});
      GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,13),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.platium_plate,'B',SSPItem.QuantumItems8,'C',new ItemStack(SSPItem.machines_base,1,12),'D',SSPItem.QuantumItems3});
    GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base,1,14),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.chromium_plate,'B',SSPItem.QuantumItems5,'C',new ItemStack(SSPItem.machines_base,1,13),'D',SSPItem.QuantumItems3});
      
    GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base1,1,0),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.wolfram_plate,'B',SSPItem.QuantumItems9,'C',Ic2Items.recycler,'D',SSPItem.QuantumItems6});
    GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base1,1,1),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.chromium_plate,'B',SSPItem.QuantumItems8,'C',new ItemStack(SSPItem.machines_base1,1,0),'D',SSPItem.QuantumItems3});
  GameRegistry.addRecipe(new ItemStack(SSPItem.machines_base1,1,2),new Object[] {"AAA","BCB","DDD", 'A', SSPItem.michail_plate,'B',SSPItem.QuantumItems5,'C',new ItemStack(SSPItem.machines_base1,1,1),'D',SSPItem.QuantumItems3});
 
  GameRegistry.addRecipe(new ItemStack(SSPItem.machines,1,4),new Object[] {"AAA","BCB","DDD", 'A', Ic2Items.plateadviron,'B',SSPItem.QuantumItems5,'C',Ic2Items.inductionFurnace,'D',SSPItem.QuantumItems6});
  GameRegistry.addRecipe(new ItemStack(SSPItem.machines,1,7),new Object[] {"AAA","BCB","DDD", 'A', Blocks.cobblestone,'B',Ic2Items.advancedCircuit,'C',Ic2Items.generator,'D',SSPItem.QuantumItems6});
  GameRegistry.addRecipe(new ItemStack(SSPItem.machines,1,8),new Object[] {"A A","BCB","A A", 'A', SSPItem.protoncore,'B',SSPItem.QuantumItems6,'C',new ItemStack(SSPItem.machines,1,0)});
  
      // TODO Recipe Neutron Generator
      GameRegistry.addRecipe(SSPItem.massFabricator, new Object[] { " B ", "ACA", " B ", 'C', Ic2Items.massFabricator, 'A', new ItemStack(SSPItem.QuantumItems5, 1), 'B',new ItemStack(SSPItem.enderquantumcomponent, 1) });

     
  
	//TODO Old Recipe from Advanced Solar Panels
    GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(SSPItem.itemIrradiantUranium, new Object[] { " R ", "RSR", " R ", Character.valueOf('R'), Items.glowstone_dust, Character.valueOf('S'),  new ItemStack(SSPItem.itemSSP, 1,8)}));
    GameRegistry.addRecipe(new ItemStack(SSPItem.itemSSP, 6,3), new Object[] { "RRR", "ASA", "RRR", Character.valueOf('R'), IC2Items.getItem("reinforcedGlass"), Character.valueOf('A'), new ItemStack(SSPItem.itemSSP, 1,0), Character.valueOf('S'), Items.glowstone_dust });
    //TODO recipe neutron core
    
	    GameRegistry.addRecipe(new ItemStack(SSPItem.neutroniumcore,1), new Object[] { " A ", "ACA", " A ", 'C', SSPItem.photoniccore,  'A' ,SSPItem.neutroniumingot});
	   //TODO Recipe Advanced and Improvemed MFSU
	    GameRegistry.addRecipe(new ItemStack(SSPItem.electricblock,1,0), new Object[] {  "ACA", 'C', Ic2Items.mfsUnit,  'A' , SSPItem.photoniy_ingot });
	    GameRegistry.addRecipe(new ItemStack(SSPItem.electricblock,1,1), new Object[] {  "ACA", 'C', new ItemStack(SSPItem.electricblock,1,0),  'A' , SSPItem.QuantumItems5 });
	    //TODO Recipe dust
	    GameRegistry.addRecipe(new ItemStack(SSPItem.dust,1) ,new Object[] {  "AAA","AAA","AAA",   'A' , IC2Items.getItem("energiumDust") });
	//TODO Old Recipe from Advanced Solar Panels
	    GameRegistry.addRecipe(SSPItem.itemReinforcedIridiumIronPlate, new Object[] { "ABA", "BCB", "ABA", Character.valueOf('A'), IC2Items.getItem("advancedAlloy"), Character.valueOf('B'), IC2Items.getItem("carbonPlate"), Character.valueOf('C'), Ic2Items.iridiumPlate });
	    Recipes.advRecipes.addRecipe(SSPItem.itemIridiumIronPlate, new Object[] { "AAA", "ABA", "AAA", Character.valueOf('A'), "plateIron", Character.valueOf('B'), new ItemStack(SSPItem.itemSSP, 1,7) });
	     // TODO Recipe Modules
	    GameRegistry.addRecipe(new ItemStack(SSPItem.module1,1) ,new Object[] {  "AAA","BDB"," C ",   'A' , SSPItem.chromium_plate,'B',SSPItem.wolfram_plate,'C',SSPItem.michail_plate,'D',new ItemStack(SSPItem.itemSSP, 1,4) });
	    GameRegistry.addRecipe(new ItemStack(SSPItem.module2,1) ,new Object[] {  "AAA","BDB"," C ",   'A' , SSPItem.platium_plate,'B',SSPItem.chromium_plate,'C',SSPItem.wolfram_plate,'D',new ItemStack(SSPItem.itemSSP, 1,4) });
	    GameRegistry.addRecipe(new ItemStack(SSPItem.module3,1) ,new Object[] {  "AAA","BDB"," C ",   'A' , SSPItem.QuantumItems2,'B',SSPItem.michail_plate,'C',SSPItem.chromium_plate,'D',new ItemStack(SSPItem.itemSSP, 1,4) });
	    GameRegistry.addRecipe(new ItemStack(SSPItem.module4,1) ,new Object[] {  "AAA","BDB"," C ",   'A' , SSPItem.michail_plate,'B',SSPItem.chromium_plate,'C',SSPItem.platium_plate,'D',new ItemStack(SSPItem.itemSSP, 1,4) });
	    //TODO Recipes Photoniy Glasses 
	    GameRegistry.addRecipe(new ItemStack(SSPItem.photoniyglass1,1) ,new Object[] {  "CAC","BBB"," C ",   'A' , Ic2Items.platelead,'B',new ItemStack(SSPItem.itemSSP, 1,3),'C',Ic2Items.platecopper,'D',Ic2Items.platetin });
	    GameRegistry.addRecipe(new ItemStack(SSPItem.photoniyglass2,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platelead,'C',Ic2Items.platecopper,'D',Ic2Items.platetin ,'H',SSPItem.photoniyglass1});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.photoniyglass3,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platelead,'C',Ic2Items.platetin,'D',Items.iron_ingot ,'H',SSPItem.photoniyglass2});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.photoniyglass4,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SSPItem.wolfram_ingot,'D',Items.redstone ,'H',SSPItem.photoniyglass3});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.photoniyglass5,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SSPItem.magnesium_ingot,'D',Ic2Items.platecopper ,'H',SSPItem.photoniyglass4});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.photoniyglass6,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SSPItem.chromium_ingot,'D',Ic2Items.plategold ,'H',SSPItem.photoniyglass5});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.photoniyglass7,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SSPItem.chromium_plate,'D',Ic2Items.tinBlock ,'H',SSPItem.photoniyglass6});
	  
	    GameRegistry.addRecipe(new ItemStack(SSPItem.photoniyglass8,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SSPItem.platium_plate,'D',Blocks.iron_block ,'H',SSPItem.photoniyglass7});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.photoniyglass9,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',Ic2Items.leadBlock,'D',Ic2Items.plateadviron ,'H',SSPItem.photoniyglass8});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.photoniyglass10,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SSPItem.michail_plate,'D',SSPItem.chromium_plate ,'H',SSPItem.photoniyglass9});
	 
		//TODO Recipe Connector and Exp Generator
		
		
		GameRegistry.addRecipe(new ItemStack(SSPItem.expgen, 1), new Object[] { 
			    "BAB",
				"BCB",
				"BAB", Character.valueOf('A'), IC2Items.getItem("advancedMachine"), Character.valueOf('B'), IC2Items.getItem("cell"), Character.valueOf('C'), IC2Items.getItem("massFabricator")});

		//TODO Start Recipe  Helmet
		Recipes.advRecipes.addRecipe(new ItemStack(SSPItem.spectralSolarHelmet, 1,OreDictionary.WILDCARD_VALUE), new Object[] { "A", "B", 'A', new ItemStack(SSPItem.blockSSPSolarPanel, 1, 4), 'B', new ItemStack(SSPItem.ultimateSolarHelmet,1,OreDictionary.WILDCARD_VALUE)});
	    Recipes.advRecipes.addRecipe(new ItemStack(SSPItem.singularSolarHelmet, 1,OreDictionary.WILDCARD_VALUE), new Object[] { "A", "B", 'A',new ItemStack(SSPItem.blockSSPSolarPanel, 1, 6), 'B', new ItemStack(SSPItem.spectralSolarHelmet, 1,OreDictionary.WILDCARD_VALUE) });
	    Recipes.advRecipes.addRecipe(new ItemStack(SSPItem.advancedSolarHelmet, 1,OreDictionary.WILDCARD_VALUE), new Object[] { 
	            " A ", "RBR", "FDF", Character.valueOf('A'), new ItemStack(SSPItem.blockSSPSolarPanel, 1, 0), Character.valueOf('B'), new ItemStack(IC2Items.getItem("nanoHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE), Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'), 
	            IC2Items.getItem("lvTransformer"), Character.valueOf('F'), IC2Items.getItem("insulatedGoldCableItem") }); 
	            
	   
	      Recipes.advRecipes.addRecipe(new ItemStack(SSPItem.hybridSolarHelmet, 1,OreDictionary.WILDCARD_VALUE), new Object[] { 
	            " A ", "RBR", "FDF", Character.valueOf('A'), new ItemStack(SSPItem.blockSSPSolarPanel, 1, 1), Character.valueOf('B'),new ItemStack(IC2Items.getItem("quantumHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE), Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'), 
	            IC2Items.getItem("hvTransformer"), Character.valueOf('F'), IC2Items.getItem("glassFiberCableItem") });
	      
	    
	      Recipes.advRecipes.addRecipe(new ItemStack(SSPItem.ultimateSolarHelmet, 1,OreDictionary.WILDCARD_VALUE), new Object[] { 
	            " A ", "RBR", "FDF", Character.valueOf('A'), new ItemStack(SSPItem.blockSSPSolarPanel, 1, 2), Character.valueOf('B'), new ItemStack(IC2Items.getItem("quantumHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE), Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'), 
	            IC2Items.getItem("hvTransformer"), Character.valueOf('F'), IC2Items.getItem("glassFiberCableItem") });
	      //TODO End Recipe Helmet
	    GameRegistry.addRecipe(new ItemStack(SSPItem.QuantumItems5, 1), new Object[] { "CBC", "BAB", "CBC", 'A', SSPItem.QuantumItems8, 'B' ,SSPItem.itemIridiumIronPlate, 'C' ,SSPItem.QuantumItems3});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.nanoSaber1,1,OreDictionary.WILDCARD_VALUE), new Object[] { "CB ", "CA ", "DEB", 'A', new ItemStack(IC2Items.getItem("nanoSaber").getItem(),1,OreDictionary.WILDCARD_VALUE), 'B', new ItemStack(SSPItem.QuantumItems8, 1), 'C' ,IC2Items.getItem("carbonPlate"), 'D', Items.glowstone_dust, 'E', new ItemStack(SSPItem.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE),});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.nanoSaber,1,OreDictionary.WILDCARD_VALUE), new Object[] { "CB ", "CA ", "DEB", 'A', new ItemStack(SSPItem.nanoSaber1,1,OreDictionary.WILDCARD_VALUE), 'B', new ItemStack(SSPItem.QuantumItems5, 1), 'C' ,IC2Items.getItem("carbonPlate"), 'D', Items.glowstone_dust, 'E', new ItemStack(SSPItem.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE),});
	    
	    GameRegistry.addRecipe(new ItemStack(SSPItem.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), new Object[] { "CBC", "BAB", "CBC", 'A',new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'B' ,new ItemStack(SSPItem.QuantumItems3, 1), 'C' ,IC2Items.getItem("iridiumPlate")});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.quantumHelmet,1,OreDictionary.WILDCARD_VALUE), new Object[] { " B ", "ACA", " A ", 'A', SSPItem.QuantumItems6, 'B' ,new ItemStack(SSPItem.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE)});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.quantumLeggings,1,OreDictionary.WILDCARD_VALUE), new Object[] { " B ", "ACA", " A ", 'A', SSPItem.QuantumItems6, 'B' ,new ItemStack(SSPItem.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumLeggings").getItem(),1,OreDictionary.WILDCARD_VALUE)});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.quantumBodyarmor,1,OreDictionary.WILDCARD_VALUE), new Object[] { " B ", "ACA", " A ", 'A', SSPItem.QuantumItems6, 'B' ,new ItemStack(SSPItem.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumBodyarmor").getItem(),1,OreDictionary.WILDCARD_VALUE)});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.quantumBoots,1,OreDictionary.WILDCARD_VALUE), new Object[] { " B ", "ACA", " A ", 'A', SSPItem.QuantumItems6, 'B' ,new ItemStack(SSPItem.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumBoots").getItem(),1,OreDictionary.WILDCARD_VALUE)});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.nanoBox, 1), new Object[] { " C ", "CBC", " C ",  'B' ,SSPItem.dust, 'C' ,IC2Items.getItem("carbonPlate")});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.QuantumItems6,1), new Object[] { " A ", "ACA", " A ", 'A', IC2Items.getItem("iridiumPlate"),  'C' ,SSPItem.nanoBox});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.QuantumItems7,1), new Object[] { " A ", "ACA", " A ", 'A', SSPItem.photoniy,  'C' ,SSPItem.nanoBox});

	//
	    GameRegistry.addRecipe(new ItemStack(SSPItem.enderquantumcomponent, 1), new Object[] { "ABA", "BCB", "ABA", 'A', IC2Items.getItem("iridiumPlate"), 'B', Items.ender_eye, 'C', Items.nether_star });
	     GameRegistry.addRecipe(new ItemStack(SSPItem.QuantumItems3, 1), new Object[] { "CBC", "BAB", "CBC", 'A', new ItemStack(SSPItem.QuantumItems7, 1), 'B' ,new ItemStack(SSPItem.itemSSP, 1, 4), 'C' ,IC2Items.getItem("carbonPlate")});

			// TODO Recipes Chargepad MFSU
	    GameRegistry.addRecipe(new ItemStack(SSPItem.Chargepadelectricblock,1,0), new Object[] { "ABA","CDC", 'B',Blocks.stone_pressure_plate ,'A',SSPItem.QuantumItems9,'D',new ItemStack(SSPItem.electricblock,1,0),'C',Ic2Items.rubber});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.Chargepadelectricblock,1,1), new Object[] { "ABA","CDC", 'B',Blocks.stone_pressure_plate ,'A',SSPItem.QuantumItems8,'D',new ItemStack(SSPItem.electricblock,1,1),'C',Ic2Items.rubber});

		//
	 // TODO Panels --> modules
		  GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 0), new Object[] { new ItemStack(SSPItem.module6, 1, 0) });
	      GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 1), new Object[] { new ItemStack(SSPItem.module6, 1, 1) });
	      GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 2), new Object[] { new ItemStack(SSPItem.module6, 1, 2) });
	      GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 3), new Object[] { new ItemStack(SSPItem.module6, 1, 3) });
	      GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 4), new Object[] { new ItemStack(SSPItem.module6, 1, 4) });
	      GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 5), new Object[] {new ItemStack(SSPItem.module6, 1, 5) });
	      GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 6), new Object[] {new ItemStack(SSPItem.module6, 1, 6) });
	      GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 7), new Object[] {new ItemStack(SSPItem.module6, 1, 7) });
	      GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 8), new Object[] { new ItemStack(SSPItem.module6, 1, 8) });
	      GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 9), new Object[] { new ItemStack(SSPItem.module6, 1, 9) });
	   // TODO modules --> Panels
		   GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.module6, 1, 0), new Object[] { new ItemStack(SSPItem.blockSSPSolarPanel, 1, 0) });
	       GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.module6, 1, 1), new Object[] { new ItemStack(SSPItem.blockSSPSolarPanel, 1, 1) });
	       GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.module6, 1, 2), new Object[] { new ItemStack(SSPItem.blockSSPSolarPanel, 1, 2) });
	       GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.module6, 1, 3), new Object[] { new ItemStack(SSPItem.blockSSPSolarPanel, 1, 3)});
	       GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.module6, 1, 4), new Object[] { new ItemStack(SSPItem.blockSSPSolarPanel, 1, 4) });
	       GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.module6, 1, 5), new Object[] {new ItemStack(SSPItem.blockSSPSolarPanel, 1, 5) });
	       GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.module6, 1, 6), new Object[] {new ItemStack(SSPItem.blockSSPSolarPanel, 1, 6) });
	       GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.module6, 1, 7), new Object[] {new ItemStack(SSPItem.blockSSPSolarPanel, 1, 7) });
	       GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.module6, 1, 8), new Object[] { new ItemStack(SSPItem.blockSSPSolarPanel, 1, 8) });
	       GameRegistry.addShapelessRecipe(new ItemStack(SSPItem.module6, 1, 9), new Object[] { new ItemStack(SSPItem.blockSSPSolarPanel, 1, 9) });
	//TODO modules wirelles and transformer
	       GameRegistry.addRecipe(new ItemStack(SSPItem.module8, 1) ,new Object[] {  "AAA"," D ","ECE",   'A' , SSPItem.spinel_plate,'C',SSPItem.michail_plate,'D',new ItemStack(SSPItem.itemSSP, 1,4),'E',SSPItem.QuantumItems4 });
	       GameRegistry.addRecipe(new ItemStack(SSPItem.module7, 1, 1) ,new Object[] {  "AAA","BDB","ECE",   'A' , SSPItem.compresscarbonultra,'B',SSPItem.chromium_plate,'C',SSPItem.wolfram_plate,'D',new ItemStack(SSPItem.itemSSP, 1,4),'E',SSPItem.QuantumItems4  });
	       GameRegistry.addRecipe(new ItemStack(SSPItem.module7, 1, 2) ,new Object[] {  "AAA","BDB","ECE",   'A' , SSPItem.compresscarbon,'B',SSPItem.michail_plate,'C',SSPItem.chromium_plate,'D',new ItemStack(SSPItem.itemSSP, 1,4),'E',SSPItem.QuantumItems4  });
	      
	       GameRegistry.addRecipe(new ItemStack(SSPItem.module7, 1, 3) ,new Object[] {  "AAA","BDB","ECE",   'A' , SSPItem.compresscarbon,'B',SSPItem.nickelplate,'C',SSPItem.invarplate,'D',new ItemStack(SSPItem.itemSSP, 1,4),'E',SSPItem.QuantumItems8  });
	       GameRegistry.addRecipe(new ItemStack(SSPItem.module7, 1, 4) ,new Object[] {  "AAA","BDB","ECE",   'A' , SSPItem.compresscarbonultra,'B',SSPItem.spinel_plate,'C',SSPItem.electriumplate,'D',new ItemStack(SSPItem.itemSSP, 1,4),'E',SSPItem.QuantumItems9  });
	       
	       GameRegistry.addRecipe(new ItemStack(SSPItem.module7, 1, 0) ,new Object[] {  "ACB","A B","   ",   'A' , SSPItem.invarplate,'B',SSPItem.electriumplate,'C',SSPItem.module3 });
	       GameRegistry.addRecipe(new ItemStack(SSPItem.module7, 1, 6) ,new Object[] {  "AC ","   ","   ",   'A' , new ItemStack(SSPItem.module8),'C',new ItemStack(SSPItem.module7, 1, 3) });
	       GameRegistry.addRecipe(new ItemStack(SSPItem.module7, 1, 8) ,new Object[] {  "AC ","   ","   ",   'A' , new ItemStack(SSPItem.module7, 1, 6),'C',new ItemStack(SSPItem.module7, 1, 4) });
	       GameRegistry.addRecipe(new ItemStack(SSPItem.module7, 1, 5) ,new Object[] {  "ACA","   ","   ",   'A' , new ItemStack(SSPItem.module7, 1, 6),'C',new ItemStack(SSPItem.module8) });
	       GameRegistry.addRecipe(new ItemStack(SSPItem.module7, 1, 7) ,new Object[] {  "ACA","   ","   ",   'A' , new ItemStack(SSPItem.module7, 1, 8),'C',new ItemStack(SSPItem.module8) });
			
	       //TODO Recipes cables
		GameRegistry.addRecipe(SSPItem.insulatedCopperCableItem, new Object[] { "BBB","AAA","BBB", 'B', Ic2Items.glassFiberCableItem,'A',SSPItem.photoniy });
		GameRegistry.addRecipe(SSPItem.copperCableItem, new Object[] { "BBB","AAA","BBB", 'B', SSPItem.insulatedCopperCableItem,'A',SSPItem.photoniy });
		GameRegistry.addRecipe(SSPItem.goldCableItem, new Object[] { "BBB","AAA","BBB", 'B', SSPItem.copperCableItem,'A',SSPItem.photoniy });
		GameRegistry.addRecipe(SSPItem.insulatedGoldCableItem, new Object[] { "BBB","AAA","BBB", 'B', SSPItem.goldCableItem,'A',SSPItem.photoniy });
		GameRegistry.addRecipe(SSPItem.doubleInsulatedGoldCableItem, new Object[] { "BBB","AAA","BBB", 'B', SSPItem.insulatedGoldCableItem,'A',SSPItem.photoniy });
		GameRegistry.addRecipe(SSPItem.ironCableItem, new Object[] { "BBB","AAA","BBB", 'B', SSPItem.doubleInsulatedGoldCableItem,'A',SSPItem.photoniy });
		GameRegistry.addRecipe(SSPItem.insulatedIronCableItem, new Object[] { "BBB","AAA","BBB", 'B', SSPItem.ironCableItem,'A',SSPItem.photoniy });
		GameRegistry.addRecipe(SSPItem.doubleInsulatedIronCableItem, new Object[] { "BBB","AAA","BBB", 'B', SSPItem.insulatedIronCableItem,'A',SSPItem.photoniy });
		GameRegistry.addRecipe(SSPItem.trippleInsulatedIronCableItem, new Object[] { "BBB","AAA","BBB", 'B', SSPItem.doubleInsulatedIronCableItem,'A',SSPItem.photoniy });
		GameRegistry.addRecipe(SSPItem.glassFiberCableItem, new Object[] { "BBB","AAA","BBB", 'B', SSPItem.trippleInsulatedIronCableItem,'A',SSPItem.photoniy_ingot });
		GameRegistry.addRecipe(new ItemStack(SSPItem.cable,1,10), new Object[] { "BBB","AAA","BBB", 'B', SSPItem.glassFiberCableItem,'A',SSPItem.photoniy_ingot });
		
		// TODO recipes Molecolar Core and Recipe Molecular Transformer
		GameRegistry.addRecipe(SSPItem.itemMTCore, new Object[] { "MXM", "M M", "MXM", 'M', SSPItem.itemIrradiantGlassPane, 'X', new ItemStack(Ic2Items.reactorReflector.getItem(),1 ,OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addRecipe(SSPItem.moleculartransformer, new Object[] { 
		      "MXM", "ABA", "MXM", Character.valueOf('M'), IC2Items.getItem("advancedMachine"), Character.valueOf('X'), IC2Items.getItem("evTransformer"), Character.valueOf('A'), IC2Items.getItem("advancedCircuit"), Character.valueOf('B'), 
		      SSPItem.itemMTCore });
	//TODO Recipes Panels
	    GameRegistry.addRecipe( new ItemStack(SSPItem.blockSSPSolarPanel, 1, 0), new Object[] { "ABA","RHR", " L ",'B', SSPItem.advanced_core ,'A',SSPItem.photoniyglass1,'H',IC2Items.getItem("advancedCircuit"), 'G',IC2Items.getItem("iridiumPlate") ,'R', IC2Items.getItem("carbonPlate"),'Y',SSPItem.photoniy,'L', IC2Items.getItem("solarPanel") });
	    GameRegistry.addRecipe( new ItemStack(SSPItem.blockSSPSolarPanel, 1, 1), new Object[] { "ABA","YDY","DDD", 'B', SSPItem.hybrid_core,'A', SSPItem.photoniyglass2,'D',new ItemStack(SSPItem.blockSSPSolarPanel, 1, 0),'Y', Ic2Items.iridiumPlate});
	    GameRegistry.addRecipe( new ItemStack(SSPItem.blockSSPSolarPanel, 1, 2), new Object[] { "ABA","YDY","DDD", 'B', SSPItem.ultimate_core,'A', SSPItem.photoniyglass3,'D',new ItemStack(SSPItem.blockSSPSolarPanel, 1,1),'Y', Ic2Items.iridiumPlate});
	    GameRegistry.addRecipe( new ItemStack(SSPItem.blockSSPSolarPanel, 1, 3), new Object[] { "ABA","YDY","DDD", 'B', SSPItem.itemQuantumCore ,'A',SSPItem.photoniyglass4,'D',new ItemStack(SSPItem.blockSSPSolarPanel, 1, 2),'Y', Ic2Items.iridiumPlate});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 4), new Object[] { "ABA","YDY","DDD", 'B', SSPItem.spectralcore,'A',SSPItem.photoniyglass5 ,'D',new ItemStack(SSPItem.blockSSPSolarPanel, 1, 3),'Y',  SSPItem.QuantumItems2});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 5), new Object[] { "ABA","YDY","DDD", 'B', SSPItem.protoncore ,'A',SSPItem.photoniyglass6,'D',new ItemStack(SSPItem.blockSSPSolarPanel, 1, 4),'Y',  SSPItem.QuantumItems2});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 6), new Object[] {"ABA","YDY","DDD",'B', SSPItem.singularcore,'A', SSPItem.photoniyglass7,'D',new ItemStack(SSPItem.blockSSPSolarPanel, 1, 5),'Y', SSPItem.QuantumItems4});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 7), new Object[] {"ABA","YDY","DDD", 'B',SSPItem.admincore,'A', SSPItem.photoniyglass8,'D',new ItemStack(SSPItem.blockSSPSolarPanel, 1, 6),'Y', SSPItem.QuantumItems4});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 8), new Object[] {"ABA","YDY","DDD",'B', SSPItem.photoniccore,'A', SSPItem.photoniyglass9,'D',new ItemStack(SSPItem.blockSSPSolarPanel, 1, 7),'Y', SSPItem.QuantumItems4});
	    GameRegistry.addRecipe(new ItemStack(SSPItem.blockSSPSolarPanel, 1, 9), new Object[] { "ABA","YDY","DDD", 'B',SSPItem.neutroniumcore ,'A',SSPItem.photoniyglass10,'D',new ItemStack(SSPItem.blockSSPSolarPanel, 1, 8),'Y', SSPItem.QuantumItems4});
	   //TODO Recipes Proton Rods
	    Recipes.advRecipes.addRecipe(SSPItem.reactorprotonDual, new Object[] { 
	  		  "SQS",  Character.valueOf('S'), SSPItem.reactorprotonSimple, Character.valueOf('Q'), Ic2Items.plateiron }); 
	  Recipes.advRecipes.addRecipe(SSPItem.reactorprotonQuad, new Object[] { 
	  		  "SQS", "CQC","SQS",  Character.valueOf('S'), SSPItem.reactorprotonSimple, Character.valueOf('Q'), Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper   }); 

	  Recipes.advRecipes.addRecipe(SSPItem.reactorprotonQuad, new Object[] { 
	  		  "SQS",  Character.valueOf('S'), SSPItem.reactorprotonDual, Character.valueOf('Q'), Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper }); 
	  Recipes.advRecipes.addRecipe(SSPItem.reactorprotoneit, new Object[] { 
	  		  "SQS",  Character.valueOf('S'), SSPItem.reactorprotonQuad, Character.valueOf('Q'), Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper }); 
	  Recipes.advRecipes.addRecipe(SSPItem.reactorprotoneit, new Object[] { 
	  		  "SQS", "CQC","SQS",  Character.valueOf('S'), SSPItem.reactorprotonDual, Character.valueOf('Q'), Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper  }); 
	 //TODO Recipes Toriy Rods
	  Recipes.advRecipes.addRecipe(SSPItem.reactortoriyDual, new Object[] { 
	  		  "SQS",  Character.valueOf('S'), SSPItem.reactortoriySimple, Character.valueOf('Q'), Ic2Items.plateiron  }); 
	  Recipes.advRecipes.addRecipe(SSPItem.reactortoriyQuad, new Object[] { 
	  		  "SQS", "CQC","SQS",  Character.valueOf('S'), SSPItem.reactortoriySimple, Character.valueOf('Q'), Ic2Items.plateiron , Character.valueOf('C'), Ic2Items.platecopper }); 

	  Recipes.advRecipes.addRecipe(SSPItem.reactortoriyQuad, new Object[] { 
	  		  "SQS",  Character.valueOf('S'), SSPItem.reactortoriyDual, Character.valueOf('Q'), Ic2Items.plateiron, Character.valueOf('C'), Ic2Items.platecopper}); 
	  

	 
}
}
