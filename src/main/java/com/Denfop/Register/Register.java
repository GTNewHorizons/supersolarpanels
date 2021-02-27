package com.Denfop.Register;

import com.Denfop.SuperSolarPanels;
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
import com.Denfop.block.expgen.ItemBlockEG;
import com.Denfop.block.mechanism.BlockMachine;
import com.Denfop.block.mechanism.BlockMachines;
import com.Denfop.block.ore.BlockOre;
import com.Denfop.block.ore.BlockSSPCoal;
import com.Denfop.block.ore.BlockSSPDiamond;
import com.Denfop.block.ore.BlockSSPEmerald;
import com.Denfop.block.ore.BlockSSPLapis;
import com.Denfop.block.ore.BlockSSPRedstone;
import com.Denfop.item.ItemCell;
import com.Denfop.item.ItemSSPCrafring;
import com.Denfop.item.Machina.ItemMachine1;
import com.Denfop.item.Machina.ItemMachines;
import com.Denfop.item.RadionBlock.ItemToriyOre;
import com.Denfop.item.armour.ItemSolarPanelHelmet;
import com.Denfop.item.base.ItemBlockIC2;
import com.Denfop.item.base.ItemElectricBlock;
import com.Denfop.item.base.ItemSSPSolarPanel;
import com.Denfop.item.base.SSPItem;
import com.Denfop.item.block.ItemBlockOre;
import com.Denfop.item.matter.matter;
import com.Denfop.item.reactor.ItemRadioactive;
import com.Denfop.tiles.ExpGen.TileXPGenPublic;
import com.Denfop.tiles.Mechanism.*;
import com.Denfop.tiles.NeutroniumGenerator.TileBitGen2;
import com.Denfop.tiles.Sintezator.TileEntitySintezator;
import com.Denfop.tiles.base.TileEntityAdminSolarPanel;
import com.Denfop.tiles.base.TileEntityCable;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.Denfop.tiles.base.TileRadioation;
import com.Denfop.tiles.overtimepanel.TileAdminSolarPanel;
import com.Denfop.tiles.overtimepanel.TileEntityAdvancedSolarPanel;
import com.Denfop.tiles.overtimepanel.TileEntityHybridSolarPanel;
import com.Denfop.tiles.overtimepanel.TileEntityQuantumSolarPanel;
import com.Denfop.tiles.overtimepanel.TileEntityUltimateSolarPanel;
import com.Denfop.tiles.overtimepanel.TileNeutronSolarPanel;
import com.Denfop.tiles.overtimepanel.TilePhotonicSolarPanel;
import com.Denfop.tiles.overtimepanel.TileProtonSolarPanel;
import com.Denfop.tiles.overtimepanel.TileSingularSolarPanel;
import com.Denfop.tiles.overtimepanel.TileSpectralSolarPanel;
import com.Denfop.tiles.wiring.Chargepad.TileEntityChargepadMFES;
import com.Denfop.tiles.wiring.Chargepad.TileEntityChargepadMFSUS;
import com.Denfop.tiles.wiring.Storage.TileEntityElectricMFE;
import com.Denfop.tiles.wiring.Storage.TileEntityElectricMFSU;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class Register {
public static void register() {
   
    GameRegistry.registerBlock(SuperSolarPanels.toriyore = new RadiationBlock()
			.setBlockTextureName("supersolarpanel:toriyore" ).setHardness(0.6f)
			.setStepSound(Block.soundTypeStone).setBlockName("toriyore"), (Class)ItemToriyOre.class, "toriyore");
    
	 GameRegistry.registerItem(SuperSolarPanels.magnesium_ingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("magnesium_ingot").setTextureName("supersolarpanel:magnesium_ingot"), "magnesium_ingot");
	 GameRegistry.registerItem(SuperSolarPanels.magnesium_plate = new SSPItem().setMaxStackSize(64).setUnlocalizedName("magnesium_plate").setTextureName("supersolarpanel:magnesium_plate"), "magnesium_plate");
	 GameRegistry.registerItem(SuperSolarPanels.magnesium_nugget = new SSPItem().setMaxStackSize(64).setUnlocalizedName("magnesium_nugget").setTextureName("supersolarpanel:magnesium_nugget"), "magnesium_nugget");
	    
	  GameRegistry.registerItem(SuperSolarPanels.advanced_core = new SSPItem().setMaxStackSize(64).setUnlocalizedName("advanced_core").setTextureName("supersolarpanel:advanced_core"), "advanced_core");
      GameRegistry.registerItem(SuperSolarPanels.hybrid_core = new SSPItem().setMaxStackSize(64).setUnlocalizedName("hybrid_core").setTextureName("supersolarpanel:hybrid_core"), "hybrid_core");
      GameRegistry.registerItem(SuperSolarPanels.ultimate_core = new SSPItem().setMaxStackSize(64).setUnlocalizedName("ultimate_core").setTextureName("supersolarpanel:ultimate_core"), "ultimate_core");
      GameRegistry.registerItem(SuperSolarPanels.spectralSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("spectralSolarHelmet"), 0, 4).setUnlocalizedName("spectralSolarHelmet"), "spectral_solar_helmet");
      GameRegistry.registerItem(SuperSolarPanels.singularSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("singularSolarHelmet"), 0, 5).setUnlocalizedName("singularSolarHelmet"), "singular_solar_helmet");
      GameRegistry.registerBlock(SuperSolarPanels.blockSSPSolarPanel = (Block)new BlockSSPSolarPanel(), (Class)ItemSSPSolarPanel.class, "BlockSSPSolarPanel");
      
      GameRegistry.registerItem(SuperSolarPanels.enderquantumcomponent = new SSPItem().setMaxStackSize(64).setUnlocalizedName("Ender-QuantumComponent").setTextureName("supersolarpanel:enderquantumcomponent"), "enderquantumcomponent");
    
      
      GameRegistry.registerBlock(SuperSolarPanels.blockadmin = (Block)new Adminsolarpanel(), (Class)ItemAdminSolarPanel.class, "Aminpanel");
      GameRegistry.registerBlock(SuperSolarPanels.machines = (Block)new BlockMachine(), (Class)ItemMachine1.class, "machines");
      GameRegistry.registerBlock(SuperSolarPanels.electricblock = (Block)new BlockElectric(), (Class)ItemElectricBlock.class, "electricblock");
      GameRegistry.registerBlock(SuperSolarPanels.Chargepadelectricblock = (Block)new BlockChargepad(), (Class)ItemBlockChargepad.class, "BlockChargepad");
      
      
      
      GameRegistry.registerItem( SuperSolarPanels.singularcore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("singularcore").setTextureName("supersolarpanel:singularcore"),"singularcore");
      GameRegistry.registerItem( SuperSolarPanels.spectralcore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("spectralcore").setTextureName("supersolarpanel:spectralcore"),"spectralcore");
      GameRegistry.registerItem( SuperSolarPanels.photoniy = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniy").setTextureName("supersolarpanel:photoniy"),"photoniy");
      GameRegistry.registerItem( SuperSolarPanels.photoniy_ingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniy_ingot").setTextureName("supersolarpanel:photoniy_ingot"),"photoniy_ingot");
      GameRegistry.registerItem( SuperSolarPanels.dust = new SSPItem().setMaxStackSize(64).setUnlocalizedName("dust").setTextureName("supersolarpanel:dust"),"dust");
      //
      GameRegistry.registerItem( SuperSolarPanels.spinelcrushedore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("spinelcrushedore").setTextureName("supersolarpanel:spinelcrushedore"),"spinelcrushedore");
      GameRegistry.registerItem( SuperSolarPanels.platiumcrushedore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("platiumcrushedore").setTextureName("supersolarpanel:platiumcrushedore"),"platiumcrushedore");
      GameRegistry.registerItem( SuperSolarPanels.nickelcrushedore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("nickelcrushedore").setTextureName("supersolarpanel:nickelcrushedore"),"nickelcrushedore");
      GameRegistry.registerItem( SuperSolarPanels.magnesiumcrushedore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("magnesiumcrushedore").setTextureName("supersolarpanel:magnesiumcrushedore"),"magnesiumcrushedore");
      GameRegistry.registerItem( SuperSolarPanels.wolframcrushedore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("wolframcrushedore").setTextureName("supersolarpanel:wolframcrushedore"),"wolframcrushedore");
      GameRegistry.registerItem( SuperSolarPanels.iridiumcrushedore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("iridiumcrushedore").setTextureName("supersolarpanel:iridiumcrushedore"),"iridiumcrushedore");
      //
      
      GameRegistry.registerItem( SuperSolarPanels.iridium_nugget = new SSPItem().setMaxStackSize(64).setUnlocalizedName("iridium_nugget").setTextureName("supersolarpanel:iridium_nugget"),"iridium_nugget");
      GameRegistry.registerItem( SuperSolarPanels.michail_plate = new SSPItem().setMaxStackSize(64).setUnlocalizedName("michail_plate").setTextureName("supersolarpanel:michail_plate"),"michail_plate");
      GameRegistry.registerItem( SuperSolarPanels.mikhail_ingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("mikhail_ingot").setTextureName("supersolarpanel:mikhail_ingot"),"mikhail_ingot");
      GameRegistry.registerItem( SuperSolarPanels.mikhail_nugget = new SSPItem().setMaxStackSize(64).setUnlocalizedName("mikhail_nugget").setTextureName("supersolarpanel:mikhail_nugget"),"mikhail_nugget");
      GameRegistry.registerItem( SuperSolarPanels.platium_ingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("platium_ingot").setTextureName("supersolarpanel:platium_ingot"),"platium_ingot");
      GameRegistry.registerItem( SuperSolarPanels.platium_nugget = new SSPItem().setMaxStackSize(64).setUnlocalizedName("platium_nugget").setTextureName("supersolarpanel:platium_nugget"),"platium_nugget");
      GameRegistry.registerItem( SuperSolarPanels.platium_plate = new SSPItem().setMaxStackSize(64).setUnlocalizedName("platium_plate").setTextureName("supersolarpanel:platium_plate"),"platium_plate");
      GameRegistry.registerItem( SuperSolarPanels.spinel_ingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("spinel_ingot").setTextureName("supersolarpanel:spinel_ingot"),"spinel_ingot");
      GameRegistry.registerItem( SuperSolarPanels.spinel_nugget = new SSPItem().setMaxStackSize(64).setUnlocalizedName("spinel_nugget").setTextureName("supersolarpanel:spinel_nugget"),"spinel_nugget");
      GameRegistry.registerItem( SuperSolarPanels.spinel_plate = new SSPItem().setMaxStackSize(64).setUnlocalizedName("spinel_plate").setTextureName("supersolarpanel:spinel_plate"),"spinel_plate");
      GameRegistry.registerItem( SuperSolarPanels.wolfram_ingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("wolfram_ingot").setTextureName("supersolarpanel:wolfram_ingot"),"wolfram_ingot");
      GameRegistry.registerItem( SuperSolarPanels.wolfram_nugget = new SSPItem().setMaxStackSize(64).setUnlocalizedName("wolfram_nugget").setTextureName("supersolarpanel:wolfram_nugget"),"wolfram_nugget");
      GameRegistry.registerItem( SuperSolarPanels.chromium_ingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("chromium_ingot").setTextureName("supersolarpanel:chromium_ingot"),"chromium_ingot");
      GameRegistry.registerItem( SuperSolarPanels.chromium_nugget = new SSPItem().setMaxStackSize(64).setUnlocalizedName("chromium_nugget").setTextureName("supersolarpanel:chromium_nugget"),"chromium_nugget");
      GameRegistry.registerItem( SuperSolarPanels.chromium_plate = new SSPItem().setMaxStackSize(64).setUnlocalizedName("chromium_plate").setTextureName("supersolarpanel:chromium_plate"),"chromium_plate");
 	 
      GameRegistry.registerBlock(SuperSolarPanels.iridiumore = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:iridiumore" )
				.setStepSound(Block.soundTypeStone).setBlockName("iridiumore"),ItemBlockOre.class, "iridiumore");
      GameRegistry.registerBlock(SuperSolarPanels.wolframore = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:wolframore" )
				.setStepSound(Block.soundTypeStone).setBlockName("wolframore"),ItemBlockOre.class, "wolframore");
      GameRegistry.registerBlock(SuperSolarPanels.chromiumore = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:chromiumore" )
				.setStepSound(Block.soundTypeStone).setBlockName("chromiumore"),ItemBlockOre.class, "chromiumore");
      GameRegistry.registerBlock(SuperSolarPanels.platiumore = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:platiumore" )
				.setStepSound(Block.soundTypeStone).setBlockName("platiumore"),ItemBlockOre.class, "platiumore");
      GameRegistry.registerBlock(SuperSolarPanels.magnesiumore = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:magnesiumore" )
				.setStepSound(Block.soundTypeStone).setBlockName("magnesiumore"),ItemBlockOre.class, "magnesiumore");
      
      GameRegistry.registerBlock(SuperSolarPanels.mikhail_ore = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:mikhail_ore" ).setStepSound(Block.soundTypeStone).setBlockName("mikhail_ore"),ItemBlockOre.class, "mikhail_ore");
      GameRegistry.registerBlock(SuperSolarPanels.spinelore = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:spinelore" )
				.setStepSound(Block.soundTypeStone).setBlockName("spinelore"),ItemBlockOre.class, "spinelore");
      
      GameRegistry.registerBlock(SuperSolarPanels.endgold_stone = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:endgold_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("endgold_stone"), "endgold_stone");
    //
      GameRegistry.registerBlock(SuperSolarPanels.magnetitore = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:magnetitore" )
				.setStepSound(Block.soundTypeStone).setBlockName("magnetitore"),ItemBlockOre.class, "magnetitore");
      GameRegistry.registerBlock(SuperSolarPanels.nicelore = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:nicelore" )
				.setStepSound(Block.soundTypeStone).setBlockName("nicelore"),ItemBlockOre.class, "nicelore");

      //
      GameRegistry.registerBlock(SuperSolarPanels.nethergoldrack = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:nethergoldrack" )
				.setStepSound(Block.soundTypeStone).setBlockName("nethergoldrack"), "nethergoldrack");
    
      GameRegistry.registerBlock(SuperSolarPanels.netherironrack = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:netherironrack" )
				.setStepSound(Block.soundTypeStone).setBlockName("netherironrack"), "netherironrack");
    
      GameRegistry.registerBlock(SuperSolarPanels.endiron_stone = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:endiron_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("endiron_stone"), "endiron_stone");
    
      GameRegistry.registerBlock(SuperSolarPanels.netherlapisrack = new BlockSSPLapis(Material.rock)
				.setBlockTextureName("supersolarpanel:netherlapisrack" )
				.setStepSound(Block.soundTypeStone).setBlockName("netherlapisrack"), "netherlapisrack");
    
  
      GameRegistry.registerBlock(SuperSolarPanels.endlapis_stone = new BlockSSPLapis(Material.rock)
				.setBlockTextureName("supersolarpanel:endlapis_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("endlapis_stone"), "endlapis_stone");
    
      GameRegistry.registerBlock(SuperSolarPanels.netheremeraldrack = new BlockSSPEmerald(Material.rock)
				.setBlockTextureName("supersolarpanel:netheremeraldrack" )
				.setStepSound(Block.soundTypeStone).setBlockName("netheremeraldrack"), "netheremeraldrack");
    
      GameRegistry.registerBlock(SuperSolarPanels.nethercopperrack = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:nethercopperrack" )
				.setStepSound(Block.soundTypeStone).setBlockName("nethercopperrack"), "nethercopperrack");
    
      GameRegistry.registerBlock(SuperSolarPanels.enduran_stone = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:enduran_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("enduran_stone"), "enduran_stone");
    
      GameRegistry.registerBlock(SuperSolarPanels.enddiamond_stone = new BlockSSPDiamond(Material.rock)
				.setBlockTextureName("supersolarpanel:enddiamond_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("enddiamond_stone"), "enddiamond_stone");
    
      GameRegistry.registerBlock(SuperSolarPanels.netheruranrack = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:netheruranrack" )
				.setStepSound(Block.soundTypeStone).setBlockName("netheruranrack"), "netheruranrack");
    
      GameRegistry.registerBlock(SuperSolarPanels.endtin_stone = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:endtin_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("endtin_stone"), "endtin_stone");
    
      GameRegistry.registerBlock(SuperSolarPanels.netherdiamondrack = new BlockSSPDiamond(Material.rock)
				.setBlockTextureName("supersolarpanel:netherdiamondrack" )
				.setStepSound(Block.soundTypeStone).setBlockName("netherdiamondrack"), "netherdiamondrack");
    
      GameRegistry.registerBlock(SuperSolarPanels.endcoal_stone = new BlockSSPCoal(Material.rock)
				.setBlockTextureName("supersolarpanel:endcoal_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("endcoal_stone"), "endcoal_stone");
    
      GameRegistry.registerBlock(SuperSolarPanels.nethertinrack = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:nethertinrack" )
				.setStepSound(Block.soundTypeStone).setBlockName("nethertinrack"), "nethertinrack");
      GameRegistry.registerBlock(SuperSolarPanels.nethercoalrack = new BlockSSPCoal(Material.rock)
				.setBlockTextureName("supersolarpanel:nethercoalrack" )
				.setStepSound(Block.soundTypeStone).setBlockName("nethercoalrack"), "nethercoalrack");
      GameRegistry.registerBlock(SuperSolarPanels.endlead_stone = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:endlead_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("endlead_stone"), "endlead_stone");
      GameRegistry.registerBlock(SuperSolarPanels.endredstone_stone = new BlockSSPRedstone(Material.rock)
				.setBlockTextureName("supersolarpanel:endredstone_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("endredstone_stone"), "endredstone_stone");
      GameRegistry.registerBlock(SuperSolarPanels.netherleadrack = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:netherleadrack" )
				.setStepSound(Block.soundTypeStone).setBlockName("netherleadrack"), "netherleadrack");
      GameRegistry.registerBlock(SuperSolarPanels.netherredstonerack = new BlockSSPRedstone(Material.rock)
				.setBlockTextureName("supersolarpanel:netherredstonerack" )
				.setStepSound(Block.soundTypeStone).setBlockName("netherredstonerack"), "netherredstonerack");
      GameRegistry.registerBlock(SuperSolarPanels.endemerald_stone = new BlockSSPEmerald(Material.rock)
				.setBlockTextureName("supersolarpanel:endemerald_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("endemerald_stone"), "endemerald_stone");
      GameRegistry.registerBlock(SuperSolarPanels.endcopper_stone = new BlockOre(Material.rock)
				.setBlockTextureName("supersolarpanel:endcopper_stone" )
				.setStepSound(Block.soundTypeStone).setBlockName("endcopper_stone"), "endcopper_stone");
     //
     
      //
      GameRegistry.registerItem(SuperSolarPanels.QuantumItems = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems").setTextureName("supersolarpanel:QuantumItems"), "QuantumItems");
      GameRegistry.registerItem(SuperSolarPanels.QuantumItems2 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems2").setTextureName("supersolarpanel:QuantumItems2"), "QuantumItems2");
      GameRegistry.registerItem(SuperSolarPanels.QuantumItems3 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems3").setTextureName("supersolarpanel:QuantumItems3"), "QuantumItems3");
      GameRegistry.registerItem(SuperSolarPanels.QuantumItems4 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems4").setTextureName("supersolarpanel:QuantumItems4"), "QuantumItems4");
      GameRegistry.registerItem(SuperSolarPanels.QuantumItems5 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems5").setTextureName("supersolarpanel:QuantumItems5"), "QuantumItems5");
      GameRegistry.registerItem(SuperSolarPanels.nanoBox = new SSPItem().setMaxStackSize(64).setUnlocalizedName("nanobox").setTextureName("supersolarpanel:nanobox"), "nanobox");
      GameRegistry.registerItem(SuperSolarPanels.photoniccore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniccore").setTextureName("supersolarpanel:photoniccore"), "photoniccore");
      GameRegistry.registerItem(SuperSolarPanels.admincore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("admincore").setTextureName("supersolarpanel:admincore"), "admincore");
      GameRegistry.registerItem(SuperSolarPanels.wolfram_plate= new SSPItem().setMaxStackSize(64).setUnlocalizedName("wolfram_plate").setTextureName("supersolarpanel:wolfram_plate"), "wolfram_plate");
      GameRegistry.registerItem( SuperSolarPanels.QuantumItems6 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems6").setTextureName("supersolarpanel:QuantumItems6"),"QuantumItems6");
      GameRegistry.registerItem( SuperSolarPanels.QuantumItems7 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems7").setTextureName("supersolarpanel:QuantumItems7"),"QuantumItems7");
      GameRegistry.registerItem( SuperSolarPanels.neutronium = new SSPItem().setMaxStackSize(64).setUnlocalizedName("neutronium").setTextureName("supersolarpanel:neutronium"),"neutronium");
      GameRegistry.registerItem( SuperSolarPanels.neutroniumingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("neutroniumingot").setTextureName("supersolarpanel:neutroniumingot"),"neutroniumingot");
      GameRegistry.registerItem( SuperSolarPanels.neutroniumcore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("neutroniumcore").setTextureName("supersolarpanel:neutroniumcore"),"neutroniumcore");
      GameRegistry.registerBlock(SuperSolarPanels.blocksintezator = (Block)new Sintezator(), (Class)ItemSintezator.class, "BlockSintezator");
     
        GameRegistry.registerItem(SuperSolarPanels.advancedSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("advancedSolarHelmet"), 0, 1).setUnlocalizedName("advancedSolarHelmet"), "advanced_solar_helmet");
      GameRegistry.registerItem(SuperSolarPanels.hybridSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("hybridSolarHelmet"), 0, 2).setUnlocalizedName("hybridSolarHelmet"), "hybrid_solar_helmet");
      GameRegistry.registerItem(SuperSolarPanels.ultimateSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("ultimateSolarHelmet"), 0, 3).setUnlocalizedName("ultimateSolarHelmet"), "ultimate_solar_helmet");
      GameRegistry.registerItem(SuperSolarPanels.itemSSP = new ItemSSPCrafring(), "ssp_crafting_items");
       GameRegistry.registerItem(SuperSolarPanels.QuantumItems8 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems8").setTextureName("supersolarpanel:QuantumItems8"), "QuantumItems8");
      GameRegistry.registerItem(SuperSolarPanels.QuantumItems9 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems9").setTextureName("supersolarpanel:QuantumItems9"), "QuantumItems9");
      GameRegistry.registerItem(SuperSolarPanels.coal_chunk1 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("coal_chunk").setTextureName("supersolarpanel:coal_chunk"), "coal_chunk");
      GameRegistry.registerItem(SuperSolarPanels.compresscarbon = new SSPItem().setMaxStackSize(64).setUnlocalizedName("compresscarbon").setTextureName("supersolarpanel:compresscarbon"), "compresscarbon");
      GameRegistry.registerItem(SuperSolarPanels.compresscarbonultra = new SSPItem().setMaxStackSize(64).setUnlocalizedName("compresscarbonultra").setTextureName("supersolarpanel:compresscarbonultra"), "compresscarbonultra");
       GameRegistry.registerItem(SuperSolarPanels.protoncore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("protoncore").setTextureName("supersolarpanel:protoncore"), "protoncore");
      GameRegistry.registerItem(SuperSolarPanels.nightlinse = new SSPItem().setMaxStackSize(64).setUnlocalizedName("nightlinse").setTextureName("supersolarpanel:nightlinse"), "nightlinse");
      GameRegistry.registerItem(SuperSolarPanels.sunlinse = new SSPItem().setMaxStackSize(64).setUnlocalizedName("sunlinse").setTextureName("supersolarpanel:sunlinse"), "sunlinse");
      GameRegistry.registerItem(SuperSolarPanels.rainlinse = new SSPItem().setMaxStackSize(64).setUnlocalizedName("rainlinse").setTextureName("supersolarpanel:rainlinse"), "rainlinse");
      GameRegistry.registerItem(SuperSolarPanels.aerlinse = new SSPItem().setMaxStackSize(64).setUnlocalizedName("aerlinse").setTextureName("supersolarpanel:aerlinse"), "aerlinse");
      GameRegistry.registerItem(SuperSolarPanels.earthlinse = new SSPItem().setMaxStackSize(64).setUnlocalizedName("earthlinse").setTextureName("supersolarpanel:earthlinse"), "earthlinse");
      GameRegistry.registerItem(SuperSolarPanels.netherlinse = new SSPItem().setMaxStackSize(64).setUnlocalizedName("netherlinse").setTextureName("supersolarpanel:netherlinse"), "netherlinse");
      GameRegistry.registerItem(SuperSolarPanels.endlinse = new SSPItem().setMaxStackSize(64).setUnlocalizedName("endlinse").setTextureName("supersolarpanel:endlinse"), "endlinse");

      GameRegistry.registerItem(SuperSolarPanels.module7 = new com.Denfop.item.Modules.module7(), "module7");
      GameRegistry.registerItem(SuperSolarPanels.photoniyglass1 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniyglass1").setTextureName("supersolarpanel:photoniyglass1"), "photoniyglass1");
      GameRegistry.registerItem(SuperSolarPanels.photoniyglass2 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniyglass2").setTextureName("supersolarpanel:photoniyglass2"), "photoniyglass2");
      GameRegistry.registerItem(SuperSolarPanels.photoniyglass3 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniyglass3").setTextureName("supersolarpanel:photoniyglass3"), "photoniyglass3");
      GameRegistry.registerItem(SuperSolarPanels.photoniyglass4 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniyglass4").setTextureName("supersolarpanel:photoniyglass4"), "photoniyglass4");
      GameRegistry.registerItem(SuperSolarPanels.photoniyglass5 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniyglass5").setTextureName("supersolarpanel:photoniyglass5"), "photoniyglass5");
      GameRegistry.registerItem(SuperSolarPanels.photoniyglass6 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniyglass6").setTextureName("supersolarpanel:photoniyglass6"), "photoniyglass6");
      GameRegistry.registerItem(SuperSolarPanels.photoniyglass7 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniyglass7").setTextureName("supersolarpanel:photoniyglass7"), "photoniyglass7");
      GameRegistry.registerItem(SuperSolarPanels.photoniyglass8 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniyglass8").setTextureName("supersolarpanel:photoniyglass8"), "photoniyglass8");
      GameRegistry.registerItem(SuperSolarPanels.photoniyglass9 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniyglass9").setTextureName("supersolarpanel:photoniyglass9"), "photoniyglass9");
      GameRegistry.registerItem(SuperSolarPanels.photoniyglass10 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniyglass10").setTextureName("supersolarpanel:photoniyglass10"), "photoniyglass10");

		GameRegistry.registerBlock(SuperSolarPanels.machines_base = new BlockMachines(), ItemMachines.class, "machines_base");
			 GameRegistry.registerBlock(SuperSolarPanels.expgen, ItemBlockEG.class, "ExpGen1");
		 GameRegistry.registerItem(SuperSolarPanels.module8, "WirelessModule1");
		
	    GameRegistry.registerItem(SuperSolarPanels.ultDDrill , "ultDDrill");
      GameRegistry.registerItem(SuperSolarPanels.module1 = new com.Denfop.item.Modules.module1().setMaxStackSize(64).setUnlocalizedName("module1").setTextureName("supersolarpanel:module1"), "module1");
      GameRegistry.registerItem(SuperSolarPanels.module2 = new com.Denfop.item.Modules.module2().setMaxStackSize(64).setUnlocalizedName("module2").setTextureName("supersolarpanel:module2"), "module2");
      GameRegistry.registerItem(SuperSolarPanels.module3 = new com.Denfop.item.Modules.module3().setMaxStackSize(64).setUnlocalizedName("module3").setTextureName("supersolarpanel:module3"), "module3");
      GameRegistry.registerItem(SuperSolarPanels.module4 = new com.Denfop.item.Modules.module4().setMaxStackSize(64).setUnlocalizedName("module4").setTextureName("supersolarpanel:module4"), "module4");
      GameRegistry.registerItem(SuperSolarPanels.module5 = new com.Denfop.item.Modules.module5().setMaxStackSize(64).setUnlocalizedName("module5").setTextureName("supersolarpanel:module5"), "module5");
      
      GameRegistry.registerItem(SuperSolarPanels.module6 = new com.Denfop.item.Modules.module6(), "module6");
      GameRegistry.registerBlock(SuperSolarPanels.cableblock =  new BlockCable(), ItemBlockIC2.class, "blockCable");
      GameRegistry.registerItem(SuperSolarPanels.cable, "cable");
      
      GameRegistry.registerItem(SuperSolarPanels.module, "upgrademodule");
      GameRegistry.registerItem(SuperSolarPanels.cell_all = new ItemCell(), "cell");
//
      GameRegistry.registerItem(SuperSolarPanels.matter = new matter().setMaxStackSize(64).setUnlocalizedName("matter").setTextureName("supersolarpanel:matter"), "matter");
      //
      GameRegistry.registerItem(SuperSolarPanels.chromiumcrushedore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("chromiumcrushedore").setTextureName("supersolarpanel:chromiumcrushedore"), "chromiumcrushedore");
      GameRegistry.registerItem(SuperSolarPanels.electriumdust = new SSPItem().setMaxStackSize(64).setUnlocalizedName("electriumdust").setTextureName("supersolarpanel:electriumdust"), "electriumdust");
      GameRegistry.registerItem(SuperSolarPanels.electriumingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("electriumingot").setTextureName("supersolarpanel:electriumingot"), "electriumingot");
      GameRegistry.registerItem(SuperSolarPanels.electriumplate = new SSPItem().setMaxStackSize(64).setUnlocalizedName("electriumplate").setTextureName("supersolarpanel:electriumplate"), "electriumplate");
      GameRegistry.registerItem(SuperSolarPanels.blast = new SSPItem().setMaxStackSize(64).setUnlocalizedName("blast").setTextureName("supersolarpanel:blast"), "blast");
      GameRegistry.registerItem(SuperSolarPanels.invardust = new SSPItem().setMaxStackSize(64).setUnlocalizedName("invardust").setTextureName("supersolarpanel:invardust"), "invardust");
      GameRegistry.registerItem(SuperSolarPanels.invaringot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("invaringot").setTextureName("supersolarpanel:invaringot"), "invaringot");
      GameRegistry.registerItem(SuperSolarPanels.invarplate = new SSPItem().setMaxStackSize(64).setUnlocalizedName("invarplate").setTextureName("supersolarpanel:invarplate"), "invarplate");
      GameRegistry.registerItem(SuperSolarPanels.nickel = new SSPItem().setMaxStackSize(64).setUnlocalizedName("nickel").setTextureName("supersolarpanel:nickel"), "nickel");
      GameRegistry.registerItem(SuperSolarPanels.nickelplate = new SSPItem().setMaxStackSize(64).setUnlocalizedName("nickelplate").setTextureName("supersolarpanel:nickelplate"), "nickelplate");
      GameRegistry.registerItem(SuperSolarPanels.michalovcrushedore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("michalovcrushedore").setTextureName("supersolarpanel:michalovcrushedore"), "michalovcrushedore");
      
      
}
public static void registertiles() {
	 GameRegistry.registerTileEntity(TileBitGen2.class, "Mass Fabricator1");

    GameRegistry.registerTileEntity(TileEntityAdvancedMatter.class, "Mass Fabricator Advanced");
    GameRegistry.registerTileEntity(TileEntityImprovedMatter.class, "Mass Fabricator Improved");
    GameRegistry.registerTileEntity(TileEntityUltimateMatter.class, "Mass Fabricator Ultimate");
    GameRegistry.registerTileEntity(TileEntityAlloySmelter.class, "AlloySmelter");
    GameRegistry.registerTileEntity(TileEntityGenerationMicrochip.class, "GenerationMicrochip");
	 GameRegistry.registerTileEntity(TileRadioation.class, "RadiationOre");
     GameRegistry.registerTileEntity((Class)TileEntityAdminSolarPanel.class, "TileEntityAdminSolarPanel");
     GameRegistry.registerTileEntity((Class)TileEntitySintezator.class, "TileEntitySintezator");
	 GameRegistry.registerTileEntity(TileXPGenPublic.class, "GeneratorXP");
	 GameRegistry.registerTileEntity(TileEntityElectricMFE.class, "MFES");
	    GameRegistry.registerTileEntity(TileEntityElectricMFSU.class, "MFSUS");
	    EnumMultiMachine.registerTile();
	 GameRegistry.registerTileEntity((Class)TileAdminSolarPanel.class, "Admin Solar Panel");
     GameRegistry.registerTileEntity((Class)TilePhotonicSolarPanel.class, "Photonic Solar Panel");
     GameRegistry.registerTileEntity((Class)TileSingularSolarPanel.class, "Singular Solar Panel");
     GameRegistry.registerTileEntity((Class)TileSpectralSolarPanel.class, "Spectral Solar Panel");
     GameRegistry.registerTileEntity((Class)TileNeutronSolarPanel.class, "Neutron Solar Panel");
     GameRegistry.registerTileEntity((Class)TileProtonSolarPanel.class, "Proton Solar Panel");
     GameRegistry.registerTileEntity(TileEntityChargepadMFES.class, "CMFE");
     GameRegistry.registerTileEntity(TileEntityChargepadMFSUS.class, "CMFSU");
     GameRegistry.registerTileEntity((Class)TileEntityAdvancedSolarPanel.class, "Advanced Solar Panel1");
     GameRegistry.registerTileEntity((Class)TileEntityHybridSolarPanel.class, "Hybrid Solar Panel1");
     GameRegistry.registerTileEntity((Class)TileEntityUltimateSolarPanel.class, "Ultimate Hybrid Solar Panel1");
     GameRegistry.registerTileEntity((Class)TileEntityQuantumSolarPanel.class, "Quantum Solar Panel1");
     GameRegistry.registerTileEntity((Class)TileEntityMolecularTransformer.class, "Molecular Transformer1");
     GameRegistry.registerTileEntity(TileEntityCable.class, "Cable1");

}
}
