package com.Denfop.Recipes;

import com.Denfop.SuperSolarPanels;
import com.Denfop.utils.StackUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BasicRecipe {
public static void recipe() {
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.itemSSP,1,4), new Object[] { 
            "ABA", "DCD", "AFA", Character.valueOf('A'), Items.redstone, Character.valueOf('B'), SuperSolarPanels.photoniy, Character.valueOf('D'), new ItemStack(Items.dye, 1, 4), Character.valueOf('C'), 
            new ItemStack(SuperSolarPanels.itemSSP,1,5), Character.valueOf('F'), Items.diamond });
 
     
	//TODO Recipe Ultimate Drill
	  GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.ultDDrill,1,OreDictionary.WILDCARD_VALUE), new Object[] { " L ", "ODO", "COC",  'O',  SuperSolarPanels.overclockerUpgrade1, 'D' , StackUtils.copyWithWildCard(IC2Items.getItem("diamondDrill")), 'C' ,SuperSolarPanels.QuantumItems5,'L',SuperSolarPanels.QuantumItems3});
  	
      //TODO Recipe Advanced and Improvemed Overclockers
      GameRegistry.addRecipe(SuperSolarPanels.overclockerUpgrade ,new Object[] {  "BAB",   'A' , Ic2Items.overclockerUpgrade,'B',SuperSolarPanels.QuantumItems9 });
      GameRegistry.addRecipe(SuperSolarPanels.overclockerUpgrade1 ,new Object[] {  "BAB",   'A' ,SuperSolarPanels.overclockerUpgrade,'B',SuperSolarPanels.QuantumItems8 });
    //TODO Reciper Rotor`s
      GameRegistry.addRecipe(SuperSolarPanels.myphical ,new Object[] { " B ", "BAB",  " B ", 'A' ,SuperSolarPanels.spectral,'B',SuperSolarPanels.QuantumItems5 });
      GameRegistry.addRecipe(SuperSolarPanels.photon ,new Object[] { " B ", "BAB",  " B ", 'A' , SuperSolarPanels.myphical,'B',SuperSolarPanels.QuantumItems8 });
      GameRegistry.addRecipe(SuperSolarPanels.neutron ,new Object[] { "CBC", "BAB",  "CBC", 'A' , SuperSolarPanels.photon,'B',SuperSolarPanels.QuantumItems9,'C', Ic2Items.iridiumPlate });
   
      GameRegistry.addRecipe(SuperSolarPanels.iridium ,new Object[] { " B ", "BAB",  " B ", 'A' , Ic2Items.carbonrotor,'B',Ic2Items.iridiumPlate });
      GameRegistry.addRecipe(SuperSolarPanels.compressiridium ,new Object[] { " B ", "BAB",  " B ", 'A' , SuperSolarPanels.iridium,'B',SuperSolarPanels.compresscarbon });
      GameRegistry.addRecipe(SuperSolarPanels.spectral ,new Object[] { "C C", "BAB",  "C C", 'A' , SuperSolarPanels.compressiridium,'B',SuperSolarPanels.QuantumItems5,'C', Ic2Items.iridiumPlate });
      GameRegistry.addRecipe(SuperSolarPanels.reactorCoolanttwelve ,new Object[] { "CCC", "ABA",  "CCC", 'A' , Ic2Items.reactorCoolantSix,'B',Ic2Items.plateiron,'C', Ic2Items.platetin });
      GameRegistry.addRecipe(SuperSolarPanels.reactorCoolantmax ,new Object[] { "CCC", "ABA",  "CCC", 'A' , SuperSolarPanels.reactorCoolanttwelve,'B',Ic2Items.plateiron,'C', Ic2Items.platetin });
      
       //TODO Recipes Machines and Quantum/Nano Chip
      GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.QuantumItems9,1) ,new Object[] {  " D ","BAB"," C ",   'A' , Ic2Items.advancedCircuit,'B',SuperSolarPanels.nanoBox,'C',SuperSolarPanels.nickel,'D',SuperSolarPanels.compresscarbon });
      GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.QuantumItems8,1) ,new Object[] {  "DCD","HAH",   'A' , SuperSolarPanels.QuantumItems9,'C',SuperSolarPanels.magnesium_ingot,'D',SuperSolarPanels.compresscarbonultra ,'H',SuperSolarPanels.QuantumItems6});
      GameRegistry.addRecipe(SuperSolarPanels.macerator,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.platium_plate,'B',SuperSolarPanels.QuantumItems9,'C',Ic2Items.macerator,'D',SuperSolarPanels.QuantumItems6});
      GameRegistry.addRecipe(SuperSolarPanels.extractor,new Object[] {"AAA","BCB","DDD", 'A',SuperSolarPanels. chromium_plate,'B',SuperSolarPanels.QuantumItems9,'C',Ic2Items.extractor,'D',SuperSolarPanels.QuantumItems6});
      GameRegistry.addRecipe(SuperSolarPanels.compressor,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.wolfram_plate,'B',SuperSolarPanels.QuantumItems9,'C',Ic2Items.compressor,'D',SuperSolarPanels.QuantumItems6});
      GameRegistry.addRecipe(SuperSolarPanels.compressor1,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.platium_plate,'B',SuperSolarPanels.QuantumItems8,'C',SuperSolarPanels.compressor,'D',SuperSolarPanels.QuantumItems3});
      GameRegistry.addRecipe(SuperSolarPanels.massFabricator1,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.spinel_plate,'B',SuperSolarPanels.QuantumItems9,'C',Ic2Items.massFabricator,'D',SuperSolarPanels.QuantumItems6});
      GameRegistry.addRecipe(SuperSolarPanels.macerator1,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.chromium_plate,'B',SuperSolarPanels.QuantumItems8,'C',SuperSolarPanels.macerator,'D',SuperSolarPanels.QuantumItems3});
      GameRegistry.addRecipe(SuperSolarPanels.electroFurnace,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.chromium_plate,'B',SuperSolarPanels.QuantumItems9,'C',Ic2Items.electroFurnace,'D',SuperSolarPanels.QuantumItems6});
      GameRegistry.addRecipe(SuperSolarPanels.electroFurnace1,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.wolfram_plate,'B',SuperSolarPanels.QuantumItems8,'C',SuperSolarPanels.electroFurnace,'D',SuperSolarPanels.QuantumItems3});
      GameRegistry.addRecipe(SuperSolarPanels.massFabricator2,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.platium_plate,'B',SuperSolarPanels.QuantumItems8,'C',SuperSolarPanels.massFabricator1,'D',SuperSolarPanels.QuantumItems6});
      GameRegistry.addRecipe(SuperSolarPanels.massFabricator3,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.spinel_plate,'B',SuperSolarPanels.QuantumItems5,'C',SuperSolarPanels.massFabricator2,'D',SuperSolarPanels.QuantumItems3});
      GameRegistry.addRecipe(SuperSolarPanels.metalformer,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.spinel_plate,'B',SuperSolarPanels.QuantumItems9,'C',Ic2Items.metalformer,'D',SuperSolarPanels.QuantumItems6});
      GameRegistry.addRecipe(SuperSolarPanels.metalformer1,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.platium_plate,'B',SuperSolarPanels.QuantumItems8,'C',SuperSolarPanels.metalformer,'D',SuperSolarPanels.QuantumItems3});
      GameRegistry.addRecipe(SuperSolarPanels.alloymachine,new Object[] {"AAA","BCB","DDD", 'A', SuperSolarPanels.nickelplate,'B',SuperSolarPanels.QuantumItems9,'C',SuperSolarPanels.extractor,'D',SuperSolarPanels.magnesium_plate});
      
  
	//TODO Old Recipe from Advanced Solar Panels
    GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(SuperSolarPanels.itemIrradiantUranium, new Object[] { " R ", "RSR", " R ", Character.valueOf('R'), Items.glowstone_dust, Character.valueOf('S'), "ingotUranium" }));
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.itemSSP, 6,3), new Object[] { "RRR", "ASA", "RRR", Character.valueOf('R'), IC2Items.getItem("reinforcedGlass"), Character.valueOf('A'), new ItemStack(SuperSolarPanels.itemSSP, 1,0), Character.valueOf('S'), Items.glowstone_dust });
    //TODO recipe neutron core
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.neutroniumcore,1), new Object[] { " A ", "ACA", " A ", 'C', SuperSolarPanels.photoniccore,  'A' ,SuperSolarPanels.neutroniumingot});
   // TODO Recipe Neutron Generator
    GameRegistry.addRecipe(SuperSolarPanels.massFabricator, new Object[] { " B ", "ACA", " B ", 'C', Ic2Items.massFabricator, 'A', new ItemStack(SuperSolarPanels.QuantumItems5, 1), 'B',new ItemStack(SuperSolarPanels.enderquantumcomponent, 1) });
   //TODO Recipe Advanced and Improvemed MFSU
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.electricblock,1,0), new Object[] {  "ACA", 'C', Ic2Items.mfsUnit,  'A' , SuperSolarPanels.photoniy_ingot });
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.electricblock,1,1), new Object[] {  "ACA", 'C', new ItemStack(SuperSolarPanels.electricblock,1,0),  'A' , SuperSolarPanels.QuantumItems5 });
    //TODO Recipe dust
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.dust,1) ,new Object[] {  "AAA","AAA","AAA",   'A' , IC2Items.getItem("energiumDust") });
//TODO Old Recipe from Advanced Solar Panels
    GameRegistry.addRecipe(SuperSolarPanels.itemReinforcedIridiumIronPlate, new Object[] { "ABA", "BCB", "ABA", Character.valueOf('A'), IC2Items.getItem("advancedAlloy"), Character.valueOf('B'), IC2Items.getItem("carbonPlate"), Character.valueOf('C'), Ic2Items.iridiumPlate });
    Recipes.advRecipes.addRecipe(SuperSolarPanels.itemIridiumIronPlate, new Object[] { "AAA", "ABA", "AAA", Character.valueOf('A'), "plateIron", Character.valueOf('B'), "ingotIridium" });
     // TODO Recipe Modules
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.module1,1) ,new Object[] {  "AAA","BDB"," C ",   'A' , SuperSolarPanels.chromium_plate,'B',SuperSolarPanels.wolfram_plate,'C',SuperSolarPanels.michail_plate,'D',new ItemStack(SuperSolarPanels.itemSSP, 1,4) });
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.module2,1) ,new Object[] {  "AAA","BDB"," C ",   'A' , SuperSolarPanels.platium_plate,'B',SuperSolarPanels.chromium_plate,'C',SuperSolarPanels.wolfram_plate,'D',new ItemStack(SuperSolarPanels.itemSSP, 1,4) });
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.module3,1) ,new Object[] {  "AAA","BDB"," C ",   'A' , SuperSolarPanels.QuantumItems2,'B',SuperSolarPanels.michail_plate,'C',SuperSolarPanels.chromium_plate,'D',new ItemStack(SuperSolarPanels.itemSSP, 1,4) });
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.module4,1) ,new Object[] {  "AAA","BDB"," C ",   'A' , SuperSolarPanels.michail_plate,'B',SuperSolarPanels.chromium_plate,'C',SuperSolarPanels.platium_plate,'D',new ItemStack(SuperSolarPanels.itemSSP, 1,4) });
    //TODO Recipes Photoniy Glasses 
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.photoniyglass1,1) ,new Object[] {  "CAC","BBB"," C ",   'A' , Ic2Items.platelead,'B',new ItemStack(SuperSolarPanels.itemSSP, 1,3),'C',Ic2Items.platecopper,'D',Ic2Items.platetin });
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.photoniyglass2,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platelead,'C',Ic2Items.platecopper,'D',Ic2Items.platetin ,'H',SuperSolarPanels.photoniyglass1});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.photoniyglass3,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platelead,'C',Ic2Items.platetin,'D',Items.iron_ingot ,'H',SuperSolarPanels.photoniyglass2});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.photoniyglass4,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SuperSolarPanels.wolfram_ingot,'D',Items.redstone ,'H',SuperSolarPanels.photoniyglass3});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.photoniyglass5,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SuperSolarPanels.wolfram_ingot,'D',Ic2Items.platecopper ,'H',SuperSolarPanels.photoniyglass4});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.photoniyglass6,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SuperSolarPanels.chromium_ingot,'D',Ic2Items.plategold ,'H',SuperSolarPanels.photoniyglass5});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.photoniyglass7,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SuperSolarPanels.chromium_plate,'D',Ic2Items.tinBlock ,'H',SuperSolarPanels.photoniyglass6});
  
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.photoniyglass8,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SuperSolarPanels.platium_plate,'D',Blocks.iron_block ,'H',SuperSolarPanels.photoniyglass7});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.photoniyglass9,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',Ic2Items.leadBlock,'D',Ic2Items.plateadviron ,'H',SuperSolarPanels.photoniyglass8});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.photoniyglass10,1) ,new Object[] {  "DCD","HCH",   'A' , Ic2Items.platecopper,'C',SuperSolarPanels.michail_plate,'D',SuperSolarPanels.chromium_plate ,'H',SuperSolarPanels.photoniyglass9});
 
	//TODO Recipe Connector and Exp Generator
	
	
	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.expgen, 1), new Object[] { 
		    "BAB",
			"BCB",
			"BAB", Character.valueOf('A'), IC2Items.getItem("advancedMachine"), Character.valueOf('B'), IC2Items.getItem("cell"), Character.valueOf('C'), IC2Items.getItem("massFabricator")});

	//TODO Start Recipe  Helmet
	Recipes.advRecipes.addRecipe(new ItemStack(SuperSolarPanels.spectralSolarHelmet, 1), new Object[] { "A", "B", 'A', new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 4), 'B', SuperSolarPanels.ultimateSolarHelmet});
    Recipes.advRecipes.addRecipe(new ItemStack(SuperSolarPanels.singularSolarHelmet, 1), new Object[] { "A", "B", 'A',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 6), 'B', new ItemStack(SuperSolarPanels.spectralSolarHelmet, 1) });
    Recipes.advRecipes.addRecipe(new ItemStack(SuperSolarPanels.advancedSolarHelmet, 1), new Object[] { 
            " A ", "RBR", "FDF", Character.valueOf('A'), new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 0), Character.valueOf('B'), new ItemStack(IC2Items.getItem("nanoHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE), Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'), 
            IC2Items.getItem("lvTransformer"), Character.valueOf('F'), IC2Items.getItem("insulatedGoldCableItem") }); 
            
   
      Recipes.advRecipes.addRecipe(new ItemStack(SuperSolarPanels.hybridSolarHelmet, 1), new Object[] { 
            " A ", "RBR", "FDF", Character.valueOf('A'), new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 1), Character.valueOf('B'),new ItemStack(IC2Items.getItem("quantumHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE), Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'), 
            IC2Items.getItem("hvTransformer"), Character.valueOf('F'), IC2Items.getItem("glassFiberCableItem") });
      
    
      Recipes.advRecipes.addRecipe(new ItemStack(SuperSolarPanels.ultimateSolarHelmet, 1), new Object[] { 
            " A ", "RBR", "FDF", Character.valueOf('A'), new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 2), Character.valueOf('B'), new ItemStack(IC2Items.getItem("quantumHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE), Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'), 
            IC2Items.getItem("hvTransformer"), Character.valueOf('F'), IC2Items.getItem("glassFiberCableItem") });
      //TODO End Recipe Helmet
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.QuantumItems5, 1), new Object[] { "CBC", "BAB", "CBC", 'A', SuperSolarPanels.QuantumItems8, 'B' ,SuperSolarPanels.itemIridiumIronPlate, 'C' ,SuperSolarPanels.QuantumItems3});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.nanoSaber1,1,OreDictionary.WILDCARD_VALUE), new Object[] { "CB ", "CA ", "DEB", 'A', new ItemStack(IC2Items.getItem("nanoSaber").getItem(),1,OreDictionary.WILDCARD_VALUE), 'B', new ItemStack(SuperSolarPanels.QuantumItems8, 1), 'C' ,IC2Items.getItem("carbonPlate"), 'D', Items.glowstone_dust, 'E', new ItemStack(SuperSolarPanels.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE),});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.nanoSaber,1,OreDictionary.WILDCARD_VALUE), new Object[] { "CB ", "CA ", "DEB", 'A', new ItemStack(SuperSolarPanels.nanoSaber1,1,OreDictionary.WILDCARD_VALUE), 'B', new ItemStack(SuperSolarPanels.QuantumItems5, 1), 'C' ,IC2Items.getItem("carbonPlate"), 'D', Items.glowstone_dust, 'E', new ItemStack(SuperSolarPanels.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE),});
    
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), new Object[] { "CBC", "BAB", "CBC", 'A',new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'B' ,new ItemStack(SuperSolarPanels.QuantumItems3, 1), 'C' ,IC2Items.getItem("iridiumPlate")});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.quantumHelmet,1,OreDictionary.WILDCARD_VALUE), new Object[] { " B ", "ACA", " A ", 'A', SuperSolarPanels.QuantumItems6, 'B' ,new ItemStack(SuperSolarPanels.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE)});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.quantumLeggings,1,OreDictionary.WILDCARD_VALUE), new Object[] { " B ", "ACA", " A ", 'A', SuperSolarPanels.QuantumItems6, 'B' ,new ItemStack(SuperSolarPanels.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumLeggings").getItem(),1,OreDictionary.WILDCARD_VALUE)});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.quantumBodyarmor,1,OreDictionary.WILDCARD_VALUE), new Object[] { " B ", "ACA", " A ", 'A', SuperSolarPanels.QuantumItems6, 'B' ,new ItemStack(SuperSolarPanels.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumBodyarmor").getItem(),1,OreDictionary.WILDCARD_VALUE)});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.quantumBoots,1,OreDictionary.WILDCARD_VALUE), new Object[] { " B ", "ACA", " A ", 'A', SuperSolarPanels.QuantumItems6, 'B' ,new ItemStack(SuperSolarPanels.lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumBoots").getItem(),1,OreDictionary.WILDCARD_VALUE)});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.nanoBox, 1), new Object[] { " C ", "CBC", " C ",  'B' ,SuperSolarPanels.dust, 'C' ,IC2Items.getItem("carbonPlate")});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.QuantumItems6,1), new Object[] { " A ", "ACA", " A ", 'A', IC2Items.getItem("iridiumPlate"),  'C' ,SuperSolarPanels.nanoBox});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.QuantumItems7,1), new Object[] { " A ", "ACA", " A ", 'A', SuperSolarPanels.photoniy,  'C' ,SuperSolarPanels.nanoBox});

    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.enderquantumcomponent, 1), new Object[] { "ABA", "BCB", "ABA", 'A', IC2Items.getItem("iridiumPlate"), 'B', Items.ender_eye, 'C', Items.nether_star });
    GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.greencomponent, 1), new Object[] { SuperSolarPanels.itemIrradiantGlassPane });
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.bluecomponent, 1), new Object[] { "AAA", "BBB", "AAA", 'A', IC2Items.getItem("reinforcedGlass"), 'B', new ItemStack(Items.dye, 1, 4) });
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.redcomponent, 1), new Object[] { "AAA", "BBB", "AAA", 'A', IC2Items.getItem("reinforcedGlass"), 'B', Items.redstone });
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.solarsplitter, 1), new Object[] { "ABC", "ABC", "ABC", 'A', new ItemStack(SuperSolarPanels.redcomponent, 1), 'B', new ItemStack(SuperSolarPanels.greencomponent), 'C', new ItemStack(SuperSolarPanels.bluecomponent) });
     GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.QuantumItems3, 1), new Object[] { "CBC", "BAB", "CBC", 'A', new ItemStack(SuperSolarPanels.QuantumItems7, 1), 'B' ,SuperSolarPanels.itemIridiumIronPlate, 'C' ,IC2Items.getItem("carbonPlate")});

	// TODO Recipe Wirelles Storage
    

	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.blockwirelessreciever, 1), new Object[] { 
		    "AAA",
			"ABA",
			"AAA", Character.valueOf('A'), new ItemStack(SuperSolarPanels.module8), Character.valueOf('B'), SuperSolarPanels.mfeUnit});

	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.blockwirelessreciever2, 1), new Object[] { 
		    "BAB",
			"ACA",
			"BAB", Character.valueOf('A'), new ItemStack(SuperSolarPanels.blockwirelessreciever), Character.valueOf('B'), IC2Items.getItem("glassFiberCableItem"),'C',SuperSolarPanels.mfsUnit});

	//TODO Recipe Block Vajra
	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.blockvajracharger), new Object[]{ " A ", 
			"BCB",
			" A ", Character.valueOf('A'), IC2Items.getItem("advancedMachine"), Character.valueOf('B'), Blocks.redstone_block, Character.valueOf('C'), IC2Items.getItem("mfsUnit")});

	//TODO Recipe Vajra
	Recipes.advRecipes.addRecipe(new ItemStack(SuperSolarPanels.wirelessVajra), new Object[]{ "ABA", 
			  "CDE",
			  "FBF",  'A', IC2Items.getItem("iridiumPlate"),
					  'B', new ItemStack(IC2Items.getItem("miningLaser").getItem(),1,OreDictionary.WILDCARD_VALUE),
					  'C', Blocks.lapis_block,
					  'D', new ItemStack(IC2Items.getItem("iridiumDrill").getItem(),1,OreDictionary.WILDCARD_VALUE),
					  'E', Blocks.emerald_block, 
					  'F', IC2Items.getItem("advancedCircuit") });
	   GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.enderquantumcomponent, 1), new Object[] { "ABA", "BCB", "ABA", 'A', IC2Items.getItem("iridiumPlate"), 'B', Items.ender_eye, 'C', Items.nether_star });

	// TODO Recipes Chargepad MFSU
    GameRegistry.addRecipe(SuperSolarPanels.ChargepadmfeUnit, new Object[] { "ABA","CDC", 'B',Blocks.stone_pressure_plate ,'A',SuperSolarPanels.QuantumItems9,'D',SuperSolarPanels.mfeUnit,'C',Ic2Items.rubber});
    GameRegistry.addRecipe(SuperSolarPanels.ChargepadmfsUnit, new Object[] { "ABA","CDC", 'B',Blocks.stone_pressure_plate ,'A',SuperSolarPanels.QuantumItems8,'D',SuperSolarPanels.mfsUnit,'C',Ic2Items.rubber});

	// TODO Panels --> modules
	  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 0), new Object[] { new ItemStack(SuperSolarPanels.module6, 1, 0) });
      GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 1), new Object[] { new ItemStack(SuperSolarPanels.module6, 1, 1) });
      GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 2), new Object[] { new ItemStack(SuperSolarPanels.module6, 1, 2) });
      GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 3), new Object[] { new ItemStack(SuperSolarPanels.module6, 1, 3) });
      GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 4), new Object[] { new ItemStack(SuperSolarPanels.module6, 1, 4) });
      GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 5), new Object[] {new ItemStack(SuperSolarPanels.module6, 1, 5) });
      GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 6), new Object[] {new ItemStack(SuperSolarPanels.module6, 1, 6) });
      GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 7), new Object[] {new ItemStack(SuperSolarPanels.module6, 1, 7) });
      GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 8), new Object[] { new ItemStack(SuperSolarPanels.module6, 1, 8) });
      GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 9), new Object[] { new ItemStack(SuperSolarPanels.module6, 1, 9) });
   // TODO modules --> Panels
	   GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.module6, 1, 0), new Object[] { new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 0) });
       GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.module6, 1, 1), new Object[] { new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 1) });
       GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.module6, 1, 2), new Object[] { new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 2) });
       GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.module6, 1, 3), new Object[] { new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 3)});
       GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.module6, 1, 4), new Object[] { new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 4) });
       GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.module6, 1, 5), new Object[] {new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 5) });
       GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.module6, 1, 6), new Object[] {new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 6) });
       GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.module6, 1, 7), new Object[] {new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 7) });
       GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.module6, 1, 8), new Object[] { new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 8) });
       GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.module6, 1, 9), new Object[] { new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 9) });
//TODO modules wirelles and transformer
       GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.module8, 1) ,new Object[] {  "AAA"," D ","ECE",   'A' , SuperSolarPanels.spinel_plate,'C',SuperSolarPanels.michail_plate,'D',new ItemStack(SuperSolarPanels.itemSSP, 1,4),'E',SuperSolarPanels.QuantumItems4 });
       GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.module7, 1, 1) ,new Object[] {  "AAA","BDB","ECE",   'A' , SuperSolarPanels.compresscarbonultra,'B',SuperSolarPanels.chromium_plate,'C',SuperSolarPanels.wolfram_plate,'D',new ItemStack(SuperSolarPanels.itemSSP, 1,4),'E',SuperSolarPanels.QuantumItems4  });
       GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.module7, 1, 2) ,new Object[] {  "AAA","BDB","ECE",   'A' , SuperSolarPanels.compresscarbon,'B',SuperSolarPanels.michail_plate,'C',SuperSolarPanels.chromium_plate,'D',new ItemStack(SuperSolarPanels.itemSSP, 1,4),'E',SuperSolarPanels.QuantumItems4  });
      
       GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.module7, 1, 3) ,new Object[] {  "AAA","BDB","ECE",   'A' , SuperSolarPanels.compresscarbon,'B',SuperSolarPanels.nickelplate,'C',SuperSolarPanels.invarplate,'D',new ItemStack(SuperSolarPanels.itemSSP, 1,4),'E',SuperSolarPanels.QuantumItems8  });
       GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.module7, 1, 4) ,new Object[] {  "AAA","BDB","ECE",   'A' , SuperSolarPanels.compresscarbonultra,'B',SuperSolarPanels.spinel_plate,'C',SuperSolarPanels.electriumplate,'D',new ItemStack(SuperSolarPanels.itemSSP, 1,4),'E',SuperSolarPanels.QuantumItems9  });
       
       //TODO Recipes cables
	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.cable,3,0), new Object[] { "BBB","AAA","BBB", 'B', Ic2Items.glassFiberCableItem,'A',SuperSolarPanels.photoniy });
	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.cable,3,1), new Object[] { "BBB","AAA","BBB", 'B', new ItemStack(SuperSolarPanels.cable,3,0),'A',SuperSolarPanels.photoniy });
	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.cable,3,2), new Object[] { "BBB","AAA","BBB", 'B', new ItemStack(SuperSolarPanels.cable,3,1),'A',SuperSolarPanels.photoniy });
	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.cable,3,3), new Object[] { "BBB","AAA","BBB", 'B', new ItemStack(SuperSolarPanels.cable,3,2),'A',SuperSolarPanels.photoniy });
	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.cable,3,5), new Object[] { "BBB","AAA","BBB", 'B', new ItemStack(SuperSolarPanels.cable,3,3),'A',SuperSolarPanels.photoniy });
	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.cable,3,6), new Object[] { "BBB","AAA","BBB", 'B', new ItemStack(SuperSolarPanels.cable,3,5),'A',SuperSolarPanels.photoniy });
	GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.cable,3,9), new Object[] { "BBB","AAA","BBB", 'B', new ItemStack(SuperSolarPanels.cable,3,6),'A',SuperSolarPanels.photoniy_ingot });
	// TODO recipes Molecolar Core and Recipe Molecular Transformer
	GameRegistry.addRecipe(SuperSolarPanels.itemMTCore, new Object[] { "MXM", "M M", "MXM", 'M', SuperSolarPanels.itemIrradiantGlassPane, 'X', Ic2Items.reactorReflector });
	GameRegistry.addRecipe(SuperSolarPanels.itemMolecularTransformer, new Object[] { 
	      "MXM", "ABA", "MXM", Character.valueOf('M'), IC2Items.getItem("advancedMachine"), Character.valueOf('X'), IC2Items.getItem("evTransformer"), Character.valueOf('A'), IC2Items.getItem("advancedCircuit"), Character.valueOf('B'), 
	      SuperSolarPanels.itemMTCore });
//TODO Recipes Panels
    GameRegistry.addRecipe( new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 0), new Object[] { "ABA","RHR", " L ",'B', SuperSolarPanels.advanced_core ,'A',SuperSolarPanels.photoniyglass1,'H',IC2Items.getItem("advancedCircuit"), 'G',IC2Items.getItem("iridiumPlate") ,'R', IC2Items.getItem("carbonPlate"),'Y',SuperSolarPanels.photoniy,'L', IC2Items.getItem("solarPanel") });
    GameRegistry.addRecipe( new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 1), new Object[] { "ABA","YDY","DDD", 'B', SuperSolarPanels.hybrid_core,'A', SuperSolarPanels.photoniyglass2,'D',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 0),'Y', Ic2Items.iridiumPlate});
    GameRegistry.addRecipe( new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 2), new Object[] { "ABA","YDY","DDD", 'B', SuperSolarPanels.ultimate_core,'A', SuperSolarPanels.photoniyglass3,'D',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1,1),'Y', Ic2Items.iridiumPlate});
    GameRegistry.addRecipe( new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 3), new Object[] { "ABA","YDY","DDD", 'B', SuperSolarPanels.itemQuantumCore ,'A',SuperSolarPanels.photoniyglass4,'D',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 2),'Y', Ic2Items.iridiumPlate});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 4), new Object[] { "ABA","YDY","DDD", 'B', SuperSolarPanels.spectralcore,'A',SuperSolarPanels.photoniyglass5 ,'D',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 3),'Y',  SuperSolarPanels.QuantumItems2});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 5), new Object[] { "ABA","YDY","DDD", 'B', SuperSolarPanels.protoncore ,'A',SuperSolarPanels.photoniyglass6,'D',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 4),'Y',  SuperSolarPanels.QuantumItems2});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 6), new Object[] {"ABA","YDY","DDD",'B', SuperSolarPanels.singularcore,'A', SuperSolarPanels.photoniyglass7,'D',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 5),'Y', SuperSolarPanels.QuantumItems4});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 7), new Object[] {"ABA","YDY","DDD", 'B',SuperSolarPanels.admincore,'A', SuperSolarPanels.photoniyglass8,'D',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 6),'Y', SuperSolarPanels.QuantumItems4});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 8), new Object[] {"ABA","YDY","DDD",'B', SuperSolarPanels.photoniccore,'A', SuperSolarPanels.photoniyglass9,'D',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 7),'Y', SuperSolarPanels.QuantumItems4});
    GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 9), new Object[] { "ABA","YDY","DDD", 'B',SuperSolarPanels.neutroniumcore ,'A',SuperSolarPanels.photoniyglass10,'D',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 8),'Y', SuperSolarPanels.QuantumItems4});
   //TODO Recipes Proton Rods
    Recipes.advRecipes.addRecipe(SuperSolarPanels.reactorprotonDual, new Object[] { 
  		  "SQS",  Character.valueOf('S'), SuperSolarPanels.reactorprotonSimple, Character.valueOf('Q'), "plateIron"  }); 
  Recipes.advRecipes.addRecipe(SuperSolarPanels.reactorprotonQuad, new Object[] { 
  		  "SQS", "CQC","SQS",  Character.valueOf('S'), SuperSolarPanels.reactorprotonSimple, Character.valueOf('Q'), "plateIron", Character.valueOf('C'), "plateCopper"  }); 

  Recipes.advRecipes.addRecipe(SuperSolarPanels.reactorprotonQuad, new Object[] { 
  		  "SQS",  Character.valueOf('S'), SuperSolarPanels.reactorprotonDual, Character.valueOf('Q'), "plateIron", Character.valueOf('C'), "plateCopper" }); 
  Recipes.advRecipes.addRecipe(SuperSolarPanels.reactorprotoneit, new Object[] { 
  		  "SQS",  Character.valueOf('S'), SuperSolarPanels.reactorprotonQuad, Character.valueOf('Q'), "plateIron", Character.valueOf('C'), "plateCopper" }); 
  Recipes.advRecipes.addRecipe(SuperSolarPanels.reactorprotoneit, new Object[] { 
  		  "SQS", "CQC","SQS",  Character.valueOf('S'), SuperSolarPanels.reactorprotonDual, Character.valueOf('Q'), "plateIron", Character.valueOf('C'), "plateCopper"  }); 
 //TODO Recipes Toriy Rods
  Recipes.advRecipes.addRecipe(SuperSolarPanels.reactortoriyDual, new Object[] { 
  		  "SQS",  Character.valueOf('S'), SuperSolarPanels.reactortoriySimple, Character.valueOf('Q'), "plateIron"  }); 
  Recipes.advRecipes.addRecipe(SuperSolarPanels.reactortoriyQuad, new Object[] { 
  		  "SQS", "CQC","SQS",  Character.valueOf('S'), SuperSolarPanels.reactortoriySimple, Character.valueOf('Q'), "plateIron", Character.valueOf('C'), "plateCopper"  }); 

  Recipes.advRecipes.addRecipe(SuperSolarPanels.reactortoriyQuad, new Object[] { 
  		  "SQS",  Character.valueOf('S'), SuperSolarPanels.reactortoriyDual, Character.valueOf('Q'), "plateIron", Character.valueOf('C'), "plateCopper" }); 
  
  //TODO add craft blast dust
  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blast), new Object[] { new ItemStack(Items.iron_ingot), new ItemStack(Items.coal)});
  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blast), new Object[] { Ic2Items.ironDust,Ic2Items.coalDust});
  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blast), new Object[] {  new ItemStack(Items.iron_ingot),Ic2Items.coalDust});
  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.blast), new Object[] {  Ic2Items.ironDust,new ItemStack(Items.coal)});
  //
  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.electriumdust), new Object[] { new ItemStack(Items.gold_ingot), Ic2Items.silverIngot});
  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.electriumdust), new Object[] { Ic2Items.goldDust,Ic2Items.silverDust});
  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.electriumdust), new Object[] {  new ItemStack(Items.gold_ingot),Ic2Items.silverDust});
  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.electriumdust), new Object[] {  Ic2Items.goldDust,Ic2Items.silverIngot});
 //
  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.invardust), new Object[] { new ItemStack(Items.iron_ingot), new ItemStack(SuperSolarPanels.nickel)});
  GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.invardust), new Object[] { Ic2Items.ironDust,new ItemStack(SuperSolarPanels.nickel)});
 
}
}
