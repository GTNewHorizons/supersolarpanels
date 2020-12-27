package ru.wirelesstools;




import java.util.logging.Logger;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.wirelesstools.fluidmachines.BlockExpGen;
import ru.wirelesstools.fluidmachines.ItemBlockEG;
import ru.wirelesstools.fluidmachines.TextureHooks;
import ru.wirelesstools.fluidmachines.TileXPGenPublic;
import ru.wirelesstools.packets.WVPacketHandler;
import ru.wirelesstools.proxy.ClientProxy;
import ru.wirelesstools.proxy.ServerProxy;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

@Mod(modid = "wirelessvajra", name = "Wireless Solar Panels Mod", version = "0.4R", dependencies = "required-after:IC2;after:OpenBlocks;after:AdvancedSolarPanel")
public class MainWV {
	public static Item wirelessVajra;
	
	@SidedProxy(clientSide = "ru.wirelesstools.proxy.ClientProxy", serverSide = "ru.wirelesstools.proxy.ServerProxy")
	public static ServerProxy proxy;
	
	public static Item connector3;
	public static Block blockvajracharger;
	public static Block blockwirelessreciever;
	public static Block blockwirelessreciever2;
	public static Block blockwirelessrecieverpersonal;
	public static Block armorcharger;
	public static Block wirelessspsp;
	public static Block wirelessspsppersonal;
	public static Block wirelesssingsp;
	public static Block wirelesssingsppersonal;
	public static Block wirelessabssp;
	public static Block wirelessabssppersonal;
	public static Block wirelessphotonicsp;
	public static Block wirelessphotonicsppersonal;
	public static Block wirelessneutronsp;
	public static Item module;
	public static Item goldenwrench;
	public static ItemStack vajraCharger;
	public static boolean displayHud;
	public static int hudPos;
	public static TickHandlerWV th;
	public static CreativeTabWV tabwv = new CreativeTabWV();
	
	public static class FluidXP {
		public static Fluid xpJuice = new Fluid("xpjuice.wv");
		
	}
	
	public static Block blockfluidxp;
	
	public static Fluid fluidXpJuice;
	
	public static Block expgen;
	
	@Instance("wirelessvajra")
	public static MainWV instance = new MainWV();
	
	
	 @EventHandler
	 public void preInit(FMLPreInitializationEvent event) {
		 wirelessVajra = new WirelessVajra(ToolMaterial.EMERALD);
		 blockvajracharger = new BlockVajraCharger("vajracharger", Material.rock);
		 armorcharger = new BlockArmorCharger("creativearmorcharger", Material.rock);
		 blockwirelessreciever = new BlockWStorage("wirelessStorage1Tier", Material.rock);
		 blockwirelessreciever2 = new BlockWStorage2("wirelessStorage2Tier", Material.rock);
		 expgen = new BlockExpGen("expGen", Material.rock);
		 module = new ItemWirelessModule();
		 goldenwrench = new ItemGoldenWrench();
		 connector3 = new ItemWirelessConnector3("itemConnector3");
		 
		 if (!Loader.isModLoaded("OpenBlocks")) {
			 
	
		 FluidRegistry.registerFluid(FluidXP.xpJuice);
		 FluidXP.xpJuice.setIcons(TextureHooks.Icons.xpJuiceStill, TextureHooks.Icons.xpJuiceFlowing);
		 
		 
		
		 }else {
			 
			 FluidXP.xpJuice = FluidRegistry.getFluid("xpjuice");
		 }
		 
		 GameRegistry.registerBlock(blockwirelessreciever, ItemBlockWirelessStorage.class, "WRes1");
		 GameRegistry.registerBlock(blockwirelessreciever2, ItemBlockWirelessStorage2.class, "WRes2");
			 GameRegistry.registerItem(wirelessVajra, "WirelessVajra");
			 GameRegistry.registerBlock(expgen, ItemBlockEG.class, "ExpGen");
		 GameRegistry.registerItem(goldenwrench, "GoldenWrench");
		 GameRegistry.registerItem(module, "WirelessModule");
		 GameRegistry.registerItem(connector3, "WirelessConnector3");
		 GameRegistry.registerBlock(blockvajracharger, ItemBlockVCh.class, "WCh");
		 GameRegistry.registerBlock(armorcharger, ItemBlockArmorCharger.class, "ArCh");
		 GameRegistry.registerTileEntity(TileVajraCharger.class, "TileVajraCharger");
		
		 GameRegistry.registerTileEntity(TileWirelessStorage1Tier.class, "TileStorageWireless1");
		 GameRegistry.registerTileEntity(TileWirelessStorageTier2.class, "TileStorageWireless2");
		 GameRegistry.registerTileEntity(TileXPGenPublic.class, "TileEG");
		 GameRegistry.registerTileEntity(TileVajraChargerElectric.class, "TileVajraCharger1");
		 
		 NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
	 }
	 @EventHandler
		public void init(FMLInitializationEvent event)
		{
		 
		 th = new TickHandlerWV();
		WVPacketHandler.load();
		ServerProxy.Init();
		ClientProxy.Init();
	//	TextureHooks.init();
		
		
		
		 
		 
		}
	 
	
	
	 @EventHandler
	   public void afterModsLoaded(FMLPostInitializationEvent event) {
		 
		
		
		
		 Recipes.advRecipes.addRecipe(new ItemStack(wirelessVajra), new Object[]{ "ABA", 
				 																  "CDE",
				 																  "FBF",  'A', IC2Items.getItem("iridiumPlate"),
				 												 						  'B', RecipeUtil.copyWithWildCard(IC2Items.getItem("miningLaser")),
				 												 						  'C', Blocks.lapis_block,
				 												 						  'D', RecipeUtil.copyWithWildCard(IC2Items.getItem("iridiumDrill")),
				 												 						  'E', Blocks.emerald_block, 
				 												 						  'F', IC2Items.getItem("advancedCircuit") });
		 
		 
		 GameRegistry.addRecipe(new ItemStack(blockvajracharger), new Object[]{ " A ", 
																				"BCB",
																				" A ", Character.valueOf('A'), IC2Items.getItem("advancedMachine"), Character.valueOf('B'), Blocks.redstone_block, Character.valueOf('C'), IC2Items.getItem("mfsUnit")});
		 
		 GameRegistry.addRecipe(new ItemStack(wirelessspsp, 1), new Object[] {
				    "AAA",
					"ABA",
					"AAA", Character.valueOf('A'), new ItemStack(module), Character.valueOf('B'), IC2Items.getItem("solarPanel")});
		 
		 GameRegistry.addRecipe(new ItemStack(wirelesssingsp, 1), new Object[] {
		 																	"AAA",
				 															"A A",
		 																	"AAA", Character.valueOf('A'), new ItemStack(wirelessspsp)});
		 																			
		 GameRegistry.addRecipe(new ItemStack(wirelessabssp, 1), new Object[] {
				    "AAA",
					"A A",
					"AAA", Character.valueOf('A'), new ItemStack(wirelesssingsp)});
		 
		 GameRegistry.addRecipe(new ItemStack(wirelessphotonicsp, 1), new Object[] { 
				    "AAA",
					"A A",
					"AAA", Character.valueOf('A'), new ItemStack(wirelessabssp)});
		 
		 GameRegistry.addRecipe(new ItemStack(wirelessneutronsp, 1), new Object[] { 
				    "AAA",
					"A A",
					"AAA", Character.valueOf('A'), new ItemStack(wirelessphotonicsp)});
		 
		 GameRegistry.addRecipe(new ItemStack(module, 1), new Object[] {
				 																"ABA",
				 																"CDC",
				 																"ABA", Character.valueOf('A'), IC2Items.getItem("iridiumOre"), 
				 																	   Character.valueOf('B'), Blocks.redstone_block, 
				 																	   Character.valueOf('C'), IC2Items.getItem("advancedCircuit"),
				 																	   Character.valueOf('D'), Items.ender_pearl});
		 
		 GameRegistry.addRecipe(new ItemStack(blockwirelessreciever, 1), new Object[] { 
				    "AAA",
					"ABA",
					"AAA", Character.valueOf('A'), new ItemStack(module), Character.valueOf('B'), IC2Items.getItem("advancedMachine")});
		 
		 GameRegistry.addRecipe(new ItemStack(blockwirelessreciever2, 1), new Object[] { 
				    "BAB",
					"A A",
					"BAB", Character.valueOf('A'), new ItemStack(blockwirelessreciever), Character.valueOf('B'), IC2Items.getItem("glassFiberCableItem")});
		 
		 GameRegistry.addShapelessRecipe(new ItemStack(connector3, 1), new Object[]{IC2Items.getItem("glassFiberCableItem"), IC2Items.getItem("advancedCircuit")});
		 
		 hudPos = 1;
		 
		 GameRegistry.addShapelessRecipe(new ItemStack(wirelessspsppersonal, 1), new Object[]{new ItemStack(wirelessspsp), new ItemStack(goldenwrench)});
		 GameRegistry.addShapelessRecipe(new ItemStack(wirelesssingsppersonal, 1), new Object[]{new ItemStack(wirelesssingsp), new ItemStack(goldenwrench)});
		 GameRegistry.addShapelessRecipe(new ItemStack(wirelessabssppersonal, 1), new Object[]{new ItemStack(wirelessabssp), new ItemStack(goldenwrench)});
		 GameRegistry.addShapelessRecipe(new ItemStack(wirelessphotonicsppersonal, 1), new Object[]{new ItemStack(wirelessphotonicsp), new ItemStack(goldenwrench)});
		 GameRegistry.addShapelessRecipe(new ItemStack(blockwirelessrecieverpersonal, 1), new Object[]{new ItemStack(blockwirelessreciever2), new ItemStack(goldenwrench)});
	 
		 GameRegistry.addRecipe(new ItemStack(goldenwrench, 1), new Object[] {
					" A ",
					"ABA",
					" A ", Character.valueOf('A'), Items.gold_ingot, Character.valueOf('B'), IC2Items.getItem("wrench")});
		 
		 GameRegistry.addRecipe(new ItemStack(expgen, 1), new Object[] { 
				    "BAB",
					"BCB",
					"BAB", Character.valueOf('A'), IC2Items.getItem("advancedMachine"), Character.valueOf('B'), IC2Items.getItem("cell"), Character.valueOf('C'), IC2Items.getItem("massFabricator")});
	 
	 }

}
