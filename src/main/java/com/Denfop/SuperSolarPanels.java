

package com.Denfop;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import ic2.core.util.Util;
import com.Denfop.tiles.sunpanels.*;
import com.Denfop.tiles.firepanel.*;
import com.Denfop.tiles.endpanel.*;
import com.Denfop.tiles.earthpanel.*;
import com.Denfop.tiles.rainpanel.*;
import com.Denfop.tiles.aerpanel.*;
import com.Denfop.tiles.nightpanels.*;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import com.Denfop.block.BlockAdvSolarPanel;
import com.Denfop.block.BlockIC2Fluid;
import com.Denfop.block.BlockSSPSolarPanel;
import com.Denfop.block.Blockbitgen;
import com.Denfop.block.BlocksItems;
import com.Denfop.block.aerpanel.BlockAdvSolarPanelaer;
import com.Denfop.block.aerpanel.BlockSSPSolarPanelaer;
import com.Denfop.block.earthpanel.BlockAdvSolarPanelearth;
import com.Denfop.block.earthpanel.BlockSSPSolarPanelearth;
import com.Denfop.block.endpanel.BlockAdvSolarPanelend;
import com.Denfop.block.endpanel.BlockSSPSolarPanelend;
import com.Denfop.block.netherpanel.BlockAdvSolarPanelnether;
import com.Denfop.block.netherpanel.BlockSSPSolarPanelnether;
import com.Denfop.block.nightpanel.BlockAdvSolarPanelmoon;
import com.Denfop.block.nightpanel.BlockSSPSolarPanelmoon;
import com.Denfop.block.rainpanel.BlockAdvSolarPanelrain;
import com.Denfop.block.rainpanel.BlockSSPSolarPanelrain;
import com.Denfop.block.sunpanel.BlockAdvSolarPanelsun;
import com.Denfop.block.sunpanel.BlockSSPSolarPanelsun;
import com.Denfop.events.EventHandlerEntity;
import com.Denfop.handler.ASPPacketHandler;
import com.Denfop.item.ItemAdvSolarPanel;
import com.Denfop.item.SSPItem;
import com.Denfop.item.armour.ItemArmorQuantumSuit1;
import com.Denfop.item.armour.ItemSolarPanelHelmet;
import com.Denfop.item.base.ItemAdvSolarPanel1;
import com.Denfop.item.base.ItemSSPSolarPanel;
import com.Denfop.item.base.aerpanel.ItemAdvSolarPanelaer;
import com.Denfop.item.base.aerpanel.ItemSSPSolarPanelaer;
import com.Denfop.item.base.earthpanel.ItemAdvSolarPanelearth;
import com.Denfop.item.base.earthpanel.ItemSSPSolarPanelearth;
import com.Denfop.item.base.endpanel.ItemAdvSolarPanelend;
import com.Denfop.item.base.endpanel.ItemSSPSolarPanelend;
import com.Denfop.item.base.moonpanel.ItemAdvSolarPanelmoon;
import com.Denfop.item.base.moonpanel.ItemSSPSolarPanelmoon;
import com.Denfop.item.base.netherpanel.ItemAdvSolarPanelnether;
import com.Denfop.item.base.netherpanel.ItemSSPSolarPanelnether;
import com.Denfop.item.base.rainpanel.ItemAdvSolarPanelrain;
import com.Denfop.item.base.rainpanel.ItemSSPSolarPanelrain;
import com.Denfop.item.base.sunpanel.ItemAdvSolarPanelsun;
import com.Denfop.item.base.sunpanel.ItemSSPSolarPanelsun;
import com.Denfop.item.energy.ItemBattery;
import com.Denfop.item.energy.ItemNanoSaber;
import com.Denfop.proxy.CommonProxy;
import com.Denfop.tab.CreativeTabSSP;
import com.Denfop.tiles.firepanel.*;
import com.Denfop.tiles.overtimepanel.*;
import com.Denfop.tiles.overtimepanel.TileNeutronSolarPanel;
import com.Denfop.tiles.overtimepanel.TilePhotonicSolarPanel;
import com.Denfop.tiles.overtimepanel.TileSingularSolarPanel;
import com.Denfop.tiles.overtimepanel.TileSpectralSolarPanel;
import com.Denfop.utils.InternalName;
import com.Denfop.utils.MTRecipeConfig;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
@Mod(modid = "supersolarpanel", name = "Super Solar Panel", version = "1.7.10-1.4-release", dependencies = "required-after:IC2;after:wirelessvajra;after:Thaumcraft;after:AppliedEnergistics;")
public class SuperSolarPanels
{
	   
	 public static Item dust;
	    public static Item EnrichedSunnariumAlloy2;
	    public static Item EnrichedSunnariumAlloy3;
	    public static Item EnrichedSunnariumAlloy4;
	    public static Item EnrichedSunnariumAlloy5;
	    public static Item EnrichedSunnariumAlloy6;
	public static Block blockSSPSolarPanel;
	 public static boolean seasonal = false;
    public static final CreativeTabSSP tabssp;
    public static int spectralpanelGenDay;
    public static int spectralpanelGenNight;
    public static int singularpanelGenDay;
    public static int singularpanelOutput;
    public static int spectralpanelOutput;
    public static int singularpanelGenNight;
    public static int adminpanelGenDay;
    public static int adminpanelGenNight;
    public static int AdminpanelStorage;
    public static int AdminpanelOutput;
    public static int photonicpanelGenDay;
    public static int photonicpanelGenNight;
    public static int photonicpanelOutput;
    public static int photonicpanelStorage;
    public static String configFileName;
    public static Item enderquantumcomponent;
    public static Item solarsplitter;
    public static Item bluecomponent;
    public static Item greencomponent;
    public static Item redcomponent;
    public static Item singularcore;
    public static Item spectralcore;
    public static Item photoniy;
    public static Item photoniy_ingot;
    public static ItemStack quantumHelmet;
    public static ItemStack quantumBodyarmor;
    public static ItemStack quantumLeggings;
    public static ItemStack quantumBoots;
    public static ItemStack quantumHelmet1;
    public static ItemStack quantumBodyarmor1;
    public static ItemStack quantumLeggings1;
    public static ItemStack quantumBoots1;
    public static ItemStack nanoSaber;
    public static Item lightAlloy;
    public static Item quantumPack;
    public static Item accumulator;
    public static Item bigAccumulator;
    public static Item belt;
    public static Item quantumBox;
    public static Item nanoBox;
    public static Item toolBox;
    public static final String MOD_ID = "supersolarpanel";
    public static final String MOD_NAME = "Super Solar Panel";
    public static final String MOD_VERSION = "1.1.4-remastered";
    public static final String TEXTURES_BLOCKS = "supersolarpanel:textures/blocks/";
    public static final String TEXTURES_ITEMS = "supersolarpanel:textures/items/";
    public static final String TEXTURES = "supersolarpanel";
	public static int maxCharge;
	public static int transferLimit;
    @Mod.Instance("supersolarpanel")
    public static SuperSolarPanels instance;
    public static Item singularSolarHelmet;
    public static Item spectralSolarHelmet;
	public static ItemStack insulatedCopperCableBlock;
	public static ItemStack copperCableBlock;
	public static ItemStack copperCableItem;
	public static ItemStack insulatedCopperCableItem;
	public static Item QuantumItems;
	public static Item QuantumItems2;
	public static Item QuantumItems3;
	public static Item QuantumItems4;
	public static Item QuantumItems5;
	public Item lapotronCrystal;
	public static int spectralsaberactive;
	public static int spectralsabernotactive;
	public static int Storagequantumsuit;
	public static int neutronpanelGenDay;
	public static int neutronpanelOutput;
	public static int neutronpanelGenNight;
	public static int neutronpanelStorage;
	public EventHandlerEntity entityEventHandler;

	public static int protonOutput;
	public static int protontier;
	public static int protongenDay;
	public static int protongennitht;
	public static boolean wireless;
	public static int spectralsaber;
	public static int spectralsaber1;
	public static int enegry1;
	public static int storage1;
	public static int tier1;
	public static int energy;
	public static int tier;
	public static int enegry2;
	public static int storage2;
	public static int tier2;
	public static boolean disableeffect;
	public static boolean disableeffect1;
	public static boolean disableeffect2;
	public static boolean disableeffect3;
	public static boolean disableeffect4;
	public static boolean disableeffect5;
	public static boolean disable;
	public static boolean disable1;
	public static boolean disable2;
	public static boolean disable3;
	public static boolean disable4;
	public static Item photoniccore;
	public static Item neutroniumcore;
	public static Item neutronium;
	public static Item neutroniumingot;
	public static Item QuantumItems6;
	public static Item QuantumItems7;
	public static Item admincore;
	public static Item enrichedsolar2;
	public static Item enrichedsolar3;
	public static ItemStack mfeUnit;
	public static ItemStack mfsUnit;
	public static ItemStack hvTransformer;
	public static ItemStack evTransformer;
	  public static Block blockfluidbit;
	  public static Fluid neutronium1 = new Fluid("neutronium1");
	    public static Block blockfluidneutronium;
		public static ItemStack cell;
		public static ItemStack uuMatterCell;
		public static ItemStack massFabricator;
	
		 @SidedProxy(clientSide = "com.Denfop.proxy.ClientProxy", serverSide = "com.Denfop.proxy.CommonProxy")
		  public static CommonProxy proxy;
		public static int spectralpanelstorage;
		public static int singularpanelstorage;
		public static int singularpaneltier;
		public static int spectralpaneltier;
		public static int adminpaneltier;
		public static int photonicpaneltier;
		public static int neutronpaneltier;
		public static boolean thaumcraft;
	    public static Block blockAdvSolarPanel;
	    public static Block blockMolecularTransformer;
	    public static Item itemAdvanced;
	    public static Item advancedSolarHelmet;
	    public static Item hybridSolarHelmet;
	    public static Item ultimateSolarHelmet;
	    public static ItemStack itemSunnarium;
	    public static ItemStack itemSunnariumPart;
	    public static ItemStack itemSunnariumAlloy;
	    public static ItemStack ingotIridium;
	    public static ItemStack itemIrradiantUranium;
	    public static ItemStack itemEnrichedSunnarium;
	    public static ItemStack itemEnrichedSunnariumAlloy;
	    public static ItemStack itemIrradiantGlassPane;
	    public static ItemStack itemIridiumIronPlate;
	    public static ItemStack itemReinforcedIridiumIronPlate;
	    public static ItemStack itemIrradiantReinforcedPlate;
	    public static ItemStack itemQuantumCore;
	    public static ItemStack itemUranIngot;
	    public static ItemStack itemUHSP;
	    public static ItemStack itemMTCore;
	    public static ItemStack itemMolecularTransformer;
	    public static Configuration config;
	    public static int advGenDay;
	    public static int advGenNight;
	    public static int advStorage;
	    public static int advOutput;
	    public static int hGenDay;
	    public static int hGenNight;
	    public static int hStorage;
	    public static int hOutput;
	    public static int uhGenDay;
	    public static int uhGenNight;
	    public static int uhStorage;
	    public static int uhOutput;
	    public static int qpGenDay;
	    public static int qpGenNight;
	    public static int qpStorage;
	    public static int qpOutput;
	    public static int qgbaseProduction;
	    public static int qgbaseMaxPacketSize;
	    public static int blockMolecularTransformerRenderID;
	    public static CreativeTabs ic2Tab;
	    public static boolean disableAdvancedSolarHelmetRecipe;
	    public static boolean disableHybridSolarHelmetRecipe;
	    public static boolean disableUltimateSolarHelmetRecipe;
	    public static boolean disableAdvancedSolarPanelRecipe;
	    public static boolean disableHybridSolarPanelRecipe;
	    public static boolean disableUltimateSolarPanelRecipe;
	    public static boolean disableQuantumSolarPanelRecipe;
	    public static boolean disableMolecularTransformerRecipe;
	    public static boolean disableDoubleSlabRecipe;
	    public static boolean enableSimpleAdvancedSolarPanelRecipes;
	    public static boolean enableHardRecipes;
	    public static Block blockSSPSolarPanel1;
		public Block blockAdvSolarPanel1;
	    public static Block blockSSPSolarPanel2;
		public Block blockAdvSolarPanel2;
	    public static Block blockSSPSolarPanel3;
		public Block blockAdvSolarPanel3;
	    public static Block blockSSPSolarPanel4;
		public Block blockAdvSolarPanel4;
	    public static Block blockSSPSolarPanel5;
		public Block blockAdvSolarPanel5;
	    public static Block blockSSPSolarPanel6;
		public Block blockAdvSolarPanel6;
	    public static Block blockSSPSolarPanel7;
		public static ItemStack spectralcable;
		public static ItemStack protoncable;
		public static ItemStack singularcable;
		public static ItemStack photoniycable;
		public Block blockAdvSolarPanel7;
	    public static final String CATEGORY_RECIPES = "recipes settings";
	    public static final String CATEGORY_QGENERATOR = "quantum generator";
	 
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        try {
            config.load();
            MTRecipeConfig.doDebug();
            SuperSolarPanels.configFileName = event.getSuggestedConfigurationFile().getAbsolutePath();
            spectralpanelGenDay = config.get("Spectral Solar panel", "SpectralSPGenDay", 8192).getInt(8192);
            protongenDay = config.get("Proton Solar panel", "ProtonGenDay", 32768).getInt(32768);
            protongennitht = config.get("Proton Solar panel", "ProtonGenNight", 20000).getInt(20000);
            protonOutput = config.get("Proton Solar panel", "ProtonOutput", 32768).getInt(32768);
            protontier = config.get("Proton Solar panel", "Protontier", 6).getInt(6);
            spectralpanelGenNight = config.get("Spectral Solar panel", "SpectralSPGenNight", 5000).getInt(5000);
            singularpanelGenDay = config.get("Singular Solar panel", "SingularSPGenDay", 131072).getInt(131072);
            singularpanelGenNight = config.get("Singular Solar panel", "SingularSPGenNight", 104857).getInt(104857);
            singularpanelOutput = config.get("Singular Solar panel", "SingularSPOutput", 32768).getInt(32768);
            spectralpanelOutput = config.get("Spectral Solar panel", "SpectralSPOutput", 8192).getInt(8192);
            adminpanelGenDay = config.get("Light-Adbord Solar panel", "AdminPanelGenDay", 554288).getInt(554288);
            adminpanelGenNight = config.get("Light-Adbord Solar panel", "AdminPanelGenNight", 554288).getInt(554288);
            AdminpanelStorage = config.get("Light-Adbord Solar panel", "AdminPanelStorage", 1000000000).getInt(1000000000);
            AdminpanelOutput = config.get("Light-Adbord Solar panel", "AdminPanelOutput", 131072).getInt(131072);
            photonicpanelGenDay = config.get("Photonic Solar panel", "PhotonicPanelGenDay", 2621440).getInt(2621440);
            photonicpanelGenNight = config.get("Photonic Solar panel", "PhotonicPanelGenNight", 2621440).getInt(2621440);
            photonicpanelOutput = config.get("Photonic Solar panel", "PhotonicPanelOutput", 554288).getInt(554288);
            photonicpanelStorage = config.get("Photonic Solar panel", "PhotonicPanelStorage", 1000000000).getInt(1000000000);
            neutronpanelGenDay = config.get("Neutronium Solar panel", "NeutronPanelGenDay", 10485760).getInt(10485760);
            neutronpanelGenNight = config.get("Neutronium Solar panel", "NeutronPanelGenNight", 10485760).getInt(10485760);
            neutronpanelOutput = config.get("Neutronium Solar panel", "NeutronPanelOutput", 2621440).getInt(2621440);
            neutronpanelStorage = config.get("Neutronium Solar panel", "NeutronPanelStorage", 1999999999).getInt(1999999999);
            Storagequantumsuit = config.get("Quantum armor", "Storage Enriched Quantum Suit", 100000000).getInt(100000000);
            spectralsaberactive = config.get("Spectral Saber", "SpectralSaber Damage Active", 40).getInt(40);
            spectralsabernotactive = config.get("Spectral Saber", "SpectralSaber Damage Not Active", 8).getInt(8);
            maxCharge = config.get("Spectral Saber", "SpectralSaber max Charge", 300000).getInt(300000);
            transferLimit= config.get("Spectral Saber", "SpectralSaber transfer Limit", 20000).getInt(20000);
            tier= config.get("Spectral Saber", "SpectralSaber tier", 4).getInt(4);
            energy= config.get("Neutronium generator", "Consumes energy to make 1 mb neutronim", 15625000.0F).getInt((int) 15625000.0F);
            spectralpanelstorage= config.get("Spectral Solar panel", "Spectral Solar panel Storage", 10000000).getInt(10000000);
            singularpanelstorage= config.get("Singular Solar panel", "Singular Solar panel Storage", 1000000000).getInt(1000000000);
            //
            enegry1= config.get("Imroved MFSU", "energy transfer Et/t", 32768).getInt(32768);
            storage1= config.get("Imroved MFSU", "energy storage", 100000000).getInt(100000000);
            tier1= config.get("Imroved MFSU", "tier", 5).getInt(5);
            enegry2= config.get("Advanced MFSU", "energy transfer Et/t", 242144).getInt(242144);
            storage2= config.get("Advanced MFSU", "energy storage", 400000000).getInt(400000000);
            tier2= config.get("Advanced MFSU", "tier", 6).getInt(6);
            singularpaneltier= config.get("Singular Solar panel", "tier", 7).getInt(7);
            spectralpaneltier= config.get("Spectral Solar panel", "tier", 5).getInt(5);
           adminpaneltier= config.get("Light-Adbord Solar panel", "tier", 8).getInt(8);
    	 photonicpaneltier= config.get("Photonic Solar panel", "tier", 9).getInt(9);
    	 neutronpaneltier= config.get("Neutronium Solar panel", "tier", 10).getInt(10);
            
            
            //
            
            disableeffect = config.get("Disable Effect", "Disable fireResistance", false).getBoolean(false);
            disableeffect1 = config.get("Disable Effect", "Disable waterBreathing", false).getBoolean(false);
            disableeffect2 = config.get("Disable Effect", "Disable jump", false).getBoolean(false);
            disableeffect3 = config.get("Disable Effect", "Disable moveSpeed", false).getBoolean(false);
            thaumcraft= config.get("Integrestion Thaumcraft", "DIntegrestion Thaumcraft", false).getBoolean(false);
            wireless = config.get("Integrestion wireless", "Integrestion wireless", false).getBoolean(false);
            
        
          
            advGenDay = config.get("general", "AdvancedSPGenDay", 4).getInt(4);
            advGenNight = config.get("general", "AdvancedSPGenNight", 4).getInt(4);
            advStorage = config.get("general", "AdvancedSPStorage", 3200).getInt(32000);
            advOutput = config.get("general", "AdvancedSPOutput", 32).getInt(32);
            hGenDay = config.get("general", "HybrydSPGenDay", 32).getInt(64);
            hGenNight = config.get("general", "HybrydSPGenNight", 8).getInt(8);
            hStorage = config.get("general", "HybrydSPStorage", 10000).getInt(100000);
            hOutput = config.get("general", "HybrydSPOutput", 128).getInt(128);
            uhGenDay = config.get("general", "UltimateHSPGenDay", 256).getInt(512);
            uhGenNight = config.get("general", "UltimateHSPGenNight", 64).getInt(64);
            uhStorage = config.get("general", "UltimateHSPStorage", 100000).getInt(1000000);
            uhOutput = config.get("general", "UltimateHSPOutput", 512).getInt(512);
            qpGenDay = config.get("general", "QuantumSPGenDay", 2048).getInt(4096);
            qpGenNight = config.get("general", "QuantumSPGenNight", 1024).getInt(2048);
            qpStorage = config.get("general", "QuantumSPStorage", 1000000).getInt(10000000);
            qpOutput = config.get("general", "QuantumSPOutput", 8192).getInt(8192);
            qgbaseProduction = config.get("quantum generator", "quantumGeneratorDefaultProduction", 512).getInt(512);
            qgbaseMaxPacketSize = config.get("quantum generator", "quantumGeneratorDefaultPacketSize", 512).getInt(512);
            disableAdvancedSolarHelmetRecipe = config.get("recipes settings", "Disable Advanced Solar Helmet recipe", false).getBoolean(false);
            disableHybridSolarHelmetRecipe = config.get("recipes settings", "Disable Hybrid Solar Helmet recipe", false).getBoolean(false);
            disableUltimateSolarHelmetRecipe = config.get("recipes settings", "Disable Ultimate Solar Helmet recipe", false).getBoolean(false);
            disableAdvancedSolarPanelRecipe = config.get("recipes settings", "Disable AdvancedSolarPanel recipe", false).getBoolean(false);
            disableHybridSolarPanelRecipe = config.get("recipes settings", "Disable HybridSolarPanel recipe", false).getBoolean(false);
            disableUltimateSolarPanelRecipe = config.get("recipes settings", "Disable UltimateSolarPanel recipe", false).getBoolean(false);
            disableQuantumSolarPanelRecipe = config.get("recipes settings", "Disable QuantumSolarPanel recipe", false).getBoolean(false);
            disableMolecularTransformerRecipe = config.get("recipes settings", "Disable MolecularTransformer recipe", false).getBoolean(false);
            disableDoubleSlabRecipe = config.get("recipes settings", "Disable DoubleSlab recipe", false).getBoolean(false);
            enableSimpleAdvancedSolarPanelRecipes = config.get("recipes settings", "Enable simple Advanced Solar Panel recipe", false).getBoolean(false);
            enableHardRecipes = config.get("recipes settings", "Enable hard recipes", true).getBoolean(true);

      
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            config.save();
        }
        //
        GameRegistry.registerBlock(SuperSolarPanels.blockSSPSolarPanel7 = (Block)new BlockSSPSolarPanelsun(), (Class)ItemSSPSolarPanelsun.class, "BlockSSPSolarPanel7");
        GameRegistry.registerBlock(blockAdvSolarPanel7 = (Block)new BlockAdvSolarPanelsun(), (Class)ItemAdvSolarPanelsun.class, "BlockAdvSolarPanel7");
        GameRegistry.registerTileEntity((Class)TileEntityAdvancedSunPanel.class, "Advanced Solar Panel7");
        GameRegistry.registerTileEntity((Class)TileEntityHybridSunPanel.class, "Hybrid Solar Panel7");
        GameRegistry.registerTileEntity((Class)TileEntityUltimateSunPanel.class, "Ultimate Hybrid Solar Panel7");
        GameRegistry.registerTileEntity((Class)TileEntityQuantumSunPanel.class, "Quantum Solar Panel7");
        
        GameRegistry.registerTileEntity((Class)TileAdminSunPanel.class, "Admin Solar Panel7");
        GameRegistry.registerTileEntity((Class)TilePhotonicSunPanel.class, "Photonic Solar Panel7");
        GameRegistry.registerTileEntity((Class)TileSingularSunPanel.class, "Singular Solar Panel7");
        GameRegistry.registerTileEntity((Class)TileSpectralSunPanel.class, "Spectral Solar Panel7");
        GameRegistry.registerTileEntity((Class)TileNeutronSunPanel.class, "Neutron Solar Panel7");
        GameRegistry.registerTileEntity((Class)TileProtonSunPanel.class, "Proton Solar Panel7");
        //
        //
        GameRegistry.registerBlock(SuperSolarPanels.blockSSPSolarPanel6 = (Block)new BlockSSPSolarPanelrain(), (Class)ItemSSPSolarPanelrain.class, "BlockSSPSolarPanel6");
        GameRegistry.registerBlock(blockAdvSolarPanel6 = (Block)new BlockAdvSolarPanelrain(), (Class)ItemAdvSolarPanelrain.class, "BlockAdvSolarPanel6");
        GameRegistry.registerTileEntity((Class)TileEntityAdvancedRainPanel.class, "Advanced Solar Panel6");
        GameRegistry.registerTileEntity((Class)TileEntityHybridRainPanel.class, "Hybrid Solar Panel6");
        GameRegistry.registerTileEntity((Class)TileEntityUltimateRainPanel.class, "Ultimate Hybrid Solar Panel6");
        GameRegistry.registerTileEntity((Class)TileEntityQuantumRainPanel.class, "Quantum Solar Panel6");
        
        GameRegistry.registerTileEntity((Class)TileAdminRainPanel.class, "Admin Solar Panel6");
        GameRegistry.registerTileEntity((Class)TilePhotonicRainPanel.class, "Photonic Solar Panel6");
        GameRegistry.registerTileEntity((Class)TileSingularRainPanel.class, "Singular Solar Panel6");
        GameRegistry.registerTileEntity((Class)TileSpectralRainPanel.class, "Spectral Solar Panel6");
        GameRegistry.registerTileEntity((Class)TileNeutronRainPanel.class, "Neutron Solar Panel6");
        GameRegistry.registerTileEntity((Class)TileProtonRainPanel.class, "Proton Solar Panel6");
        //
        //
        GameRegistry.registerBlock(SuperSolarPanels.blockSSPSolarPanel5 = (Block)new BlockSSPSolarPanelmoon(), (Class)ItemSSPSolarPanelmoon.class, "BlockSSPSolarPanel5");
        GameRegistry.registerBlock(blockAdvSolarPanel5 = (Block)new BlockAdvSolarPanelmoon(), (Class)ItemAdvSolarPanelmoon.class, "BlockAdvSolarPanel5");
        GameRegistry.registerTileEntity((Class)TileEntityAdvancedNightPanel.class, "Advanced Solar Panel5");
        GameRegistry.registerTileEntity((Class)TileEntityHybridNightPanel.class, "Hybrid Solar Panel5");
        GameRegistry.registerTileEntity((Class)TileEntityUltimateNightPanel.class, "Ultimate Hybrid Solar Panel5");
        GameRegistry.registerTileEntity((Class)TileEntityQuantumNightPanel.class, "Quantum Solar Panel5");
        
        GameRegistry.registerTileEntity((Class)TileAdminNightPanel.class, "Admin Solar Panel5");
        GameRegistry.registerTileEntity((Class)TilePhotonicNightPanel.class, "Photonic Solar Panel5");
        GameRegistry.registerTileEntity((Class)TileSingularNightPanel.class, "Singular Solar Panel5");
        GameRegistry.registerTileEntity((Class)TileSpectralNightPanel.class, "Spectral Solar Panel5");
        GameRegistry.registerTileEntity((Class)TileNeutronNightPanel.class, "Neutron Solar Panel5");
        GameRegistry.registerTileEntity((Class)TileProtonNightPanel.class, "Proton Solar Panel5");
        //
        //
        GameRegistry.registerBlock(SuperSolarPanels.blockSSPSolarPanel4 = (Block)new BlockSSPSolarPanelnether(), (Class)ItemSSPSolarPanelnether.class, "BlockSSPSolarPanel4");
        GameRegistry.registerBlock(blockAdvSolarPanel4 = (Block)new BlockAdvSolarPanelnether(), (Class)ItemAdvSolarPanelnether.class, "BlockAdvSolarPanel4");
        GameRegistry.registerTileEntity((Class)TileEntityAdvancedNetherPanel.class, "Advanced Solar Panel4");
        GameRegistry.registerTileEntity((Class)TileEntityHybridNetherPanel.class, "Hybrid Solar Panel4");
        GameRegistry.registerTileEntity((Class)TileEntityUltimateNetherPanel.class, "Ultimate Hybrid Solar Panel4");
        GameRegistry.registerTileEntity((Class)TileEntityQuantumNetherPanel.class, "Quantum Solar Panel4");
        
        GameRegistry.registerTileEntity((Class)TileAdminNetherPanel.class, "Admin Solar Panel4");
        GameRegistry.registerTileEntity((Class)TilePhotonicNetherPanel.class, "Photonic Solar Panel4");
        GameRegistry.registerTileEntity((Class)TileSingularNetherPanel.class, "Singular Solar Panel4");
        GameRegistry.registerTileEntity((Class)TileSpectralNetherPanel.class, "Spectral Solar Panel4");
        GameRegistry.registerTileEntity((Class)TileNeutronNetherPanel.class, "Neutron Solar Panel4");
        GameRegistry.registerTileEntity((Class)TileProtonNetherPanel.class, "Proton Solar Panel4");
        //
        //
        GameRegistry.registerBlock(SuperSolarPanels.blockSSPSolarPanel3 = (Block)new BlockSSPSolarPanelend(), (Class)ItemSSPSolarPanelend.class, "BlockSSPSolarPanel3");
        GameRegistry.registerBlock(blockAdvSolarPanel3 = (Block)new BlockAdvSolarPanelend(), (Class)ItemAdvSolarPanelend.class, "BlockAdvSolarPanel3");
        GameRegistry.registerTileEntity((Class)TileEntityAdvancedEarthPanel.class, "Advanced Solar Panel3");
        GameRegistry.registerTileEntity((Class)TileEntityHybridEarthPanel.class, "Hybrid Solar Panel3");
        GameRegistry.registerTileEntity((Class)TileEntityUltimateEarthPanel.class, "Ultimate Hybrid Solar Panel3");
        GameRegistry.registerTileEntity((Class)TileEntityQuantumEarthPanel.class, "Quantum Solar Panel3");
        
        GameRegistry.registerTileEntity((Class)TileAdminEarthPanel.class, "Admin Solar Panel3");
        GameRegistry.registerTileEntity((Class)TilePhotonicEarthPanel.class, "Photonic Solar Panel3");
        GameRegistry.registerTileEntity((Class)TileSingularEarthPanel.class, "Singular Solar Panel3");
        GameRegistry.registerTileEntity((Class)TileSpectralEarthPanel.class, "Spectral Solar Panel3");
        GameRegistry.registerTileEntity((Class)TileNeutronEarthPanel.class, "Neutron Solar Panel3");
        GameRegistry.registerTileEntity((Class)TileProtonEarthPanel.class, "Proton Solar Panel3");
        //
        //
        GameRegistry.registerBlock(SuperSolarPanels.blockSSPSolarPanel2 = (Block)new BlockSSPSolarPanelearth(), (Class)ItemSSPSolarPanelearth.class, "BlockSSPSolarPanel2");
        GameRegistry.registerBlock(blockAdvSolarPanel2 = (Block)new BlockAdvSolarPanelearth(), (Class)ItemAdvSolarPanelearth.class, "BlockAdvSolarPanel2");
        GameRegistry.registerTileEntity((Class)TileEntityAdvancedEarthPanel.class, "Advanced Solar Panel2");
        GameRegistry.registerTileEntity((Class)TileEntityHybridEarthPanel.class, "Hybrid Solar Panel2");
        GameRegistry.registerTileEntity((Class)TileEntityUltimateEarthPanel.class, "Ultimate Hybrid Solar Panel2");
        GameRegistry.registerTileEntity((Class)TileEntityQuantumEarthPanel.class, "Quantum Solar Panel2");
        
        GameRegistry.registerTileEntity((Class)TileAdminEarthPanel.class, "Admin Solar Panel2");
        GameRegistry.registerTileEntity((Class)TilePhotonicEarthPanel.class, "Photonic Solar Panel2");
        GameRegistry.registerTileEntity((Class)TileSingularEarthPanel.class, "Singular Solar Panel2");
        GameRegistry.registerTileEntity((Class)TileSpectralEarthPanel.class, "Spectral Solar Panel2");
        GameRegistry.registerTileEntity((Class)TileNeutronEarthPanel.class, "Neutron Solar Panel2");
        GameRegistry.registerTileEntity((Class)TileProtonEarthPanel.class, "Proton Solar Panel2");
        //
        //
        GameRegistry.registerBlock(SuperSolarPanels.blockSSPSolarPanel1 = (Block)new BlockSSPSolarPanelaer(), (Class)ItemSSPSolarPanelaer.class, "BlockSSPSolarPanel1");
        GameRegistry.registerBlock(blockAdvSolarPanel1 = (Block)new BlockAdvSolarPanelaer(), (Class)ItemAdvSolarPanelaer.class, "BlockAdvSolarPanel1");
        GameRegistry.registerTileEntity((Class)TileEntityAdvancedAirPanel.class, "Advanced Solar Panel1");
        GameRegistry.registerTileEntity((Class)TileEntityHybridAirPanel.class, "Hybrid Solar Panel1");
        GameRegistry.registerTileEntity((Class)TileEntityUltimateAirPanel.class, "Ultimate Hybrid Solar Panel1");
        GameRegistry.registerTileEntity((Class)TileEntityQuantumAirPanel.class, "Quantum Solar Panel1");
        
        GameRegistry.registerTileEntity((Class)TileAdminAirPanel.class, "Admin Solar Panel1");
        GameRegistry.registerTileEntity((Class)TilePhotonicAirPanel.class, "Photonic Solar Panel1");
        GameRegistry.registerTileEntity((Class)TileSingularAirPanel.class, "Singular Solar Panel1");
        GameRegistry.registerTileEntity((Class)TileSpectralAirPanel.class, "Spectral Solar Panel1");
        GameRegistry.registerTileEntity((Class)TileNeutronAirPanel.class, "Neutron Solar Panel1");
        GameRegistry.registerTileEntity((Class)TileProtonAirPanel.class, "Proton Solar Panel1");
        //
        FluidRegistry.registerFluid(neutronium1);//регистрация самой жидкости
        blockfluidneutronium = new com.Denfop.fluid.neutronium(neutronium1, Material.water).setBlockName("neutronium1");//блок и его настройки.
        GameRegistry.registerBlock(blockfluidneutronium, "neutronium1_Block");//Регистрация блока жидкости.

       
        GameRegistry.registerItem(SuperSolarPanels.spectralSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("spectralSolarHelmet"), 0, 1).setUnlocalizedName("spectralSolarHelmet"), "spectral_solar_helmet");
        GameRegistry.registerItem(SuperSolarPanels.singularSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("singularSolarHelmet"), 0, 2).setUnlocalizedName("singularSolarHelmet"), "singular_solar_helmet");
        BlocksItems.init();
        lapotronCrystal = new ItemBattery(InternalName.itemBatLamaCrystal, SuperSolarPanels.Storagequantumsuit, 8092.0D, 4).setRarity(1);
        nanoSaber = new ItemStack((Item)new ItemNanoSaber(InternalName.itemNanoSaber));
       quantumHelmet = new ItemStack((Item)new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumHelmet, 0));
        quantumBodyarmor = new ItemStack((Item)new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumChestplate, 1));
        quantumLeggings = new ItemStack((Item)new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumLegs, 2));
        quantumBoots = new ItemStack((Item)new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumBoots, 3));
        GameRegistry.registerBlock(SuperSolarPanels.blockSSPSolarPanel = (Block)new BlockSSPSolarPanel(), (Class)ItemSSPSolarPanel.class, "BlockSSPSolarPanel");
        GameRegistry.registerTileEntity((Class)TileAdminSolarPanel.class, "Admin Solar Panel");
        GameRegistry.registerTileEntity((Class)TilePhotonicSolarPanel.class, "Photonic Solar Panel");
        GameRegistry.registerTileEntity((Class)TileSingularSolarPanel.class, "Singular Solar Panel");
        GameRegistry.registerTileEntity((Class)TileSpectralSolarPanel.class, "Spectral Solar Panel");
        GameRegistry.registerTileEntity((Class)TileNeutronSolarPanel.class, "Neutron Solar Panel");
        GameRegistry.registerTileEntity((Class)TileProtonSolarPanel.class, "Proton Solar Panel");
        //
       
        //
        new Blockbitgen(InternalName.Blockbitgen);
        GameRegistry.registerItem(SuperSolarPanels.enderquantumcomponent = new SSPItem().setMaxStackSize(64).setUnlocalizedName("Ender-QuantumComponent").setTextureName("supersolarpanel:enderquantumcomponent"), "enderquantumcomponent");
        GameRegistry.registerItem(SuperSolarPanels.solarsplitter = new SSPItem().setMaxStackSize(64).setUnlocalizedName("SpectralLightSplitter").setTextureName("supersolarpanel:spectral_light_splitter"), "solarsplitter");
        SuperSolarPanels.bluecomponent = new SSPItem().setMaxStackSize(64).setUnlocalizedName("BlueSpectralComponent").setTextureName("supersolarpanel:Blue_Spectral_Component");
        SuperSolarPanels.greencomponent = new SSPItem().setMaxStackSize(64).setUnlocalizedName("GreenSpectralComponent").setTextureName("supersolarpanel:Green_Spectral_Component");
        SuperSolarPanels.redcomponent = new SSPItem().setMaxStackSize(64).setUnlocalizedName("RedSpectralComponent").setTextureName("supersolarpanel:Red_Spectral_Component");
        GameRegistry.registerItem( SuperSolarPanels.singularcore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("singularcore").setTextureName("supersolarpanel:singularcore"),"singularcore");
        GameRegistry.registerItem( SuperSolarPanels.spectralcore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("spectralcore").setTextureName("supersolarpanel:spectralcore"),"spectralcore");
        GameRegistry.registerItem( SuperSolarPanels.photoniy = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniy").setTextureName("supersolarpanel:photoniy"),"photoniy");
        GameRegistry.registerItem( SuperSolarPanels.photoniy_ingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniy_ingot").setTextureName("supersolarpanel:photoniy_ingot"),"photoniy_ingot");
        GameRegistry.registerItem( SuperSolarPanels.dust = new SSPItem().setMaxStackSize(64).setUnlocalizedName("dust").setTextureName("supersolarpanel:dust"),"dust");
        
        GameRegistry.registerItem(SuperSolarPanels.bluecomponent, "bluecomponent");
        GameRegistry.registerItem(SuperSolarPanels.greencomponent, "greencomponent");
        GameRegistry.registerItem(SuperSolarPanels.redcomponent, "redcomponent");
      //  GameRegistry.registerItem(SuperSolarPanels.QuantumItems = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems").setTextureName("supersolarpanel:QuantumItems"), "QuantumItems");
        GameRegistry.registerItem(SuperSolarPanels.QuantumItems2 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems2").setTextureName("supersolarpanel:QuantumItems2"), "QuantumItems2");
        GameRegistry.registerItem(SuperSolarPanels.QuantumItems3 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems3").setTextureName("supersolarpanel:QuantumItems3"), "QuantumItems3");
        GameRegistry.registerItem(SuperSolarPanels.QuantumItems4 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems4").setTextureName("supersolarpanel:QuantumItems4"), "QuantumItems4");
        GameRegistry.registerItem(SuperSolarPanels.QuantumItems5 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems5").setTextureName("supersolarpanel:QuantumItems5"), "QuantumItems5");
        GameRegistry.registerItem(SuperSolarPanels.nanoBox = new SSPItem().setMaxStackSize(64).setUnlocalizedName("nanobox").setTextureName("supersolarpanel:nanobox"), "nanobox");
        GameRegistry.registerItem(SuperSolarPanels.photoniccore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniccore").setTextureName("supersolarpanel:photoniccore"), "photoniccore");
        GameRegistry.registerItem(SuperSolarPanels.admincore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("admincore").setTextureName("supersolarpanel:admincore"), "admincore");
        GameRegistry.registerItem(SuperSolarPanels.enrichedsolar2 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("enrichedsolar2").setTextureName("supersolarpanel:enrichedsolar2"), "enrichedsolar2");
        GameRegistry.registerItem(SuperSolarPanels.enrichedsolar3 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("enrichedsolar3").setTextureName("supersolarpanel:enrichedsolar3"), "enrichedsolar3");
      //
        GameRegistry.registerItem( SuperSolarPanels.QuantumItems6 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems6").setTextureName("supersolarpanel:QuantumItems6"),"QuantumItems6");
        GameRegistry.registerItem( SuperSolarPanels.QuantumItems7 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems7").setTextureName("supersolarpanel:QuantumItems7"),"QuantumItems7");
        GameRegistry.registerItem( SuperSolarPanels.neutronium = new SSPItem().setMaxStackSize(64).setUnlocalizedName("neutronium").setTextureName("supersolarpanel:neutronium"),"neutronium");
        GameRegistry.registerItem( SuperSolarPanels.neutroniumingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("neutroniumingot").setTextureName("supersolarpanel:neutroniumingot"),"neutroniumingot");
        GameRegistry.registerItem( SuperSolarPanels.neutroniumcore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("neutroniumcore").setTextureName("supersolarpanel:neutroniumcore"),"neutroniumcore");
        
        //
        GameRegistry.registerBlock(blockMolecularTransformer = (Block)new com.Denfop.block.BlockMolecularTransformer(), (Class)com.Denfop.item.ItemMolecularTransformer.class, "BlockMolecularTransformer");
        GameRegistry.registerTileEntity((Class)com.Denfop.tiles.base.TileEntityMolecularTransformer.class, "Molecular Transformer");
        GameRegistry.registerBlock(blockAdvSolarPanel = (Block)new com.Denfop.block.BlockAdvSolarPanel(), (Class)com.Denfop.item.ItemAdvSolarPanel.class, "BlockAdvSolarPanel");
        GameRegistry.registerTileEntity((Class)com.Denfop.tiles.overtimepanel.TileEntityAdvancedSolarPanel.class, "Advanced Solar Panel");
        GameRegistry.registerTileEntity((Class)com.Denfop.tiles.overtimepanel.TileEntityHybridSolarPanel.class, "Hybrid Solar Panel");
        GameRegistry.registerTileEntity((Class)com.Denfop.tiles.overtimepanel.TileEntityUltimateSolarPanel.class, "Ultimate Hybrid Solar Panel");
        GameRegistry.registerTileEntity((Class)com.Denfop.tiles.overtimepanel.TileEntityQuantumSolarPanel.class, "Quantum Solar Panel");
        GameRegistry.registerItem(advancedSolarHelmet = new com.Denfop.item.ItemAdvancedSolarHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("advancedSolarHelmet"), 0, 1).setUnlocalizedName("advancedSolarHelmet"), "advanced_solar_helmet");
        GameRegistry.registerItem(hybridSolarHelmet = new com.Denfop.item.ItemAdvancedSolarHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("hybridSolarHelmet"), 0, 2).setUnlocalizedName("hybridSolarHelmet"), "hybrid_solar_helmet");
        GameRegistry.registerItem(ultimateSolarHelmet = new com.Denfop.item.ItemAdvancedSolarHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("ultimateSolarHelmet"), 0, 3).setUnlocalizedName("ultimateSolarHelmet"), "ultimate_solar_helmet");
        GameRegistry.registerItem(itemAdvanced = new com.Denfop.item.ItemAdvanced(), "asp_crafting_items");
        itemSunnarium = new ItemStack(itemAdvanced.setUnlocalizedName("itemSunnarium"), 1, 0);
        itemSunnariumAlloy = new ItemStack(itemAdvanced.setUnlocalizedName("itemSunnariumAlloy"), 1, 1);
        itemIrradiantUranium = new ItemStack(itemAdvanced.setUnlocalizedName("itemIrradiantUranium"), 1, 2);
        itemEnrichedSunnarium = new ItemStack(itemAdvanced.setUnlocalizedName("itemEnrichedSunnarium"), 1, 3);
        itemEnrichedSunnariumAlloy = new ItemStack(itemAdvanced.setUnlocalizedName("itemEnrichedSunnariumAlloy"), 1, 4);
        itemIrradiantGlassPane = new ItemStack(itemAdvanced.setUnlocalizedName("itemIrradiantGlassPlane"), 1, 5);
        itemIridiumIronPlate = new ItemStack(itemAdvanced.setUnlocalizedName("itemIridiumIronPlate"), 1, 6);
        itemReinforcedIridiumIronPlate = new ItemStack(itemAdvanced.setUnlocalizedName("itemReinforcedIridiumIronPlate"), 1, 7);
        itemIrradiantReinforcedPlate = new ItemStack(itemAdvanced.setUnlocalizedName("itemIrradiantReinforcedPlate"), 1, 8);
        itemSunnariumPart = new ItemStack(itemAdvanced.setUnlocalizedName("itemSunnariumPart"), 1, 9);
        ingotIridium = new ItemStack(itemAdvanced.setUnlocalizedName("ingotIridium"), 1, 10);
        itemUranIngot = new ItemStack(itemAdvanced.setUnlocalizedName("itemUranIngot"), 1, 11);
        itemMTCore = new ItemStack(itemAdvanced.setUnlocalizedName("itemMTCore"), 1, 12);
        itemQuantumCore = new ItemStack(itemAdvanced.setUnlocalizedName("itemQuantumCore"), 1, 13);
        itemMolecularTransformer = new ItemStack(blockMolecularTransformer, 1, 0);
        itemUHSP = new ItemStack(blockAdvSolarPanel, 1, 2);
        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("iridiumOre"), 1), (NBTTagCompound)null, new ItemStack[] { ingotIridium });
        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("UranFuel"), 1), (NBTTagCompound)null, new ItemStack[] { itemUranIngot });
        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("uraniumOre"), 1), (NBTTagCompound)null, new ItemStack[] { itemUranIngot });
        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("crushedUraniumOre"), 1), (NBTTagCompound)null, new ItemStack[] { itemUranIngot });
        OreDictionary.registerOre("ingotUranium", itemUranIngot);
        OreDictionary.registerOre("ingotIridium", ingotIridium);
        OreDictionary.registerOre("craftingSolarPanelHV", itemUHSP);
        OreDictionary.registerOre("craftingSunnariumPart", itemSunnariumPart);
        OreDictionary.registerOre("craftingSunnarium", itemSunnarium);
        OreDictionary.registerOre("craftingMTCore", itemMTCore);
        OreDictionary.registerOre("craftingMolecularTransformer", itemMolecularTransformer);
        SuperSolarPanels.proxy.registerRenderers();
        SuperSolarPanels.proxy.load();
        NetworkRegistry.INSTANCE.registerGuiHandler((Object)this, (IGuiHandler)SuperSolarPanels.proxy);
        MTRecipeConfig.doDebug();
          
    }
    public static ItemStack setItemsSize(final ItemStack itemStack, final int newSize) {
        final ItemStack newStack = itemStack.copy();
        newStack.stackSize = newSize;
        return newStack;
    }
    @Mod.EventHandler
    public void load(final FMLInitializationEvent event) {
        ASPPacketHandler.load();
    }

    @EventHandler
    public void onMissingMappings(FMLMissingMappingsEvent event) {
      BlocksItems.onMissingMappings(event);
    }
    public static void addLog(final String logLine) {
        System.out.println("[SuperSolarPanel] " + logLine);
    }
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onViewRenderFogDensity(EntityViewRenderEvent.FogDensity event) {
      if (!(event.block instanceof BlockIC2Fluid))
        return; 
      event.setCanceled(true);
      Fluid fluid = ((BlockIC2Fluid)event.block).getFluid();
      GL11.glFogi(2917, 2048);
      event.density = (float)Util.map(Math.abs(fluid.getDensity()), 20000.0D, 2.0D);
    }
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onViewRenderFogColors(EntityViewRenderEvent.FogColors event) {
      if (!(event.block instanceof BlockIC2Fluid))
        return; 
      int color = ((BlockIC2Fluid)event.block).getColor();
      event.red = (color >>> 16 & 0xFF) / 255.0F;
      event.green = (color >>> 8 & 0xFF) / 255.0F;
      event.blue = (color & 0xFF) / 255.0F;
    }
    @Mod.EventHandler
    public void Init(final FMLInitializationEvent event) {
    	
        GameRegistry.registerTileEntity((Class)TileSingularSolarPanel.class, "SingularSolarPanel");
        GameRegistry.registerTileEntity((Class)TileSpectralSolarPanel.class, "SpectralSolarPanel");
        GameRegistry.registerTileEntity((Class)TileAdminSolarPanel.class, "AdminSolarPanel");
        GameRegistry.registerTileEntity((Class)TilePhotonicSolarPanel.class, "PhotonicSolarPanel");
        proxy.registerEvents();
    }
    @SubscribeEvent
    public void onLivingSpecialSpawn(LivingSpawnEvent.SpecialSpawn event) {
      if (seasonal && (event.entityLiving instanceof net.minecraft.entity.monster.EntityZombie || event.entityLiving instanceof net.minecraft.entity.monster.EntitySkeleton) && event.entityLiving.worldObj.rand.nextFloat() < 0.1F) {
        EntityLiving entity = (EntityLiving)event.entityLiving;
        for (int i = 0; i <= 4; i++)
          entity.setEquipmentDropChance(i, Float.NEGATIVE_INFINITY); 
        
        if (event.entityLiving.worldObj.rand.nextFloat() < 0.1F) {
          entity.setCurrentItemOrArmor(1, quantumHelmet.copy());
          entity.setCurrentItemOrArmor(2, quantumBodyarmor.copy());
          entity.setCurrentItemOrArmor(3, quantumLeggings.copy());
          entity.setCurrentItemOrArmor(4, quantumBoots.copy());
        } 
      } 
    }
  
    @Mod.EventHandler
    public void afterModsLoaded(final FMLPostInitializationEvent event) {
    	ItemStack crystal = IC2Items.getItem("lapotronCrystal");
    	Recipes.advRecipes.addRecipe(new ItemStack(spectralSolarHelmet, 1), new Object[] { "A", "B", 'A', new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 0), 'B', SuperSolarPanels.ultimateSolarHelmet});
        Recipes.advRecipes.addRecipe(new ItemStack(singularSolarHelmet, 1), new Object[] { "A", "B", 'A',new ItemStack(SuperSolarPanels.blockSSPSolarPanel, 1, 1), 'B', new ItemStack(spectralSolarHelmet, 1) });
        proxy.registerRenderers();
        // Thanks for Kotskiy for Renders of Quantum Suit
        GameRegistry.addRecipe(new ItemStack(blockSSPSolarPanel, 1, 0), new Object[] { " B ", "BAB", " B ", 'A', new ItemStack(SuperSolarPanels.spectralcore, 1), 'B', new ItemStack(SuperSolarPanels.blockAdvSolarPanel, 1, 3) });
        GameRegistry.addRecipe(new ItemStack(blockSSPSolarPanel, 1, 1), new Object[] { " A ", "ACA", " A ", 'A', new ItemStack(blockSSPSolarPanel, 1, 0), 'C', new ItemStack(SuperSolarPanels.singularcore, 1) });
        GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.enderquantumcomponent, 1), new Object[] { "ABA", "BCB", "ABA", 'A', IC2Items.getItem("iridiumPlate"), 'B', Items.ender_eye, 'C', Items.nether_star });
        GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.greencomponent, 1), new Object[] { SuperSolarPanels.itemIrradiantGlassPane });
        GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.bluecomponent, 1), new Object[] { "AAA", "BBB", "AAA", 'A', IC2Items.getItem("reinforcedGlass"), 'B', new ItemStack(Items.dye, 1, 4) });
        GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.redcomponent, 1), new Object[] { "AAA", "BBB", "AAA", 'A', IC2Items.getItem("reinforcedGlass"), 'B', Items.redstone });
        GameRegistry.addRecipe(new ItemStack(SuperSolarPanels.solarsplitter, 1), new Object[] { "ABC", "ABC", "ABC", 'A', new ItemStack(SuperSolarPanels.redcomponent, 1), 'B', new ItemStack(SuperSolarPanels.greencomponent), 'C', new ItemStack(SuperSolarPanels.bluecomponent) });
       GameRegistry.addRecipe(new ItemStack(blockSSPSolarPanel, 1, 3), new Object[] { " A ", "ABA", " A ", 'A', new ItemStack(blockSSPSolarPanel, 1, 1),'B', admincore});
        GameRegistry.addRecipe(new ItemStack(blockSSPSolarPanel, 1, 2), new Object[] { " A ", "ABA", " A ", 'A', new ItemStack(blockSSPSolarPanel, 1, 3),'B', photoniccore });
        GameRegistry.addRecipe(new ItemStack(spectralcore, 1), new Object[] { "CBC", "BAB", "CBC", 'A', new ItemStack(solarsplitter, 1), 'B', new ItemStack(QuantumItems4, 1), 'C' ,photoniy });
        GameRegistry.addRecipe(new ItemStack(singularcore, 1), new Object[] { "CBC", "BAB", "CBC", 'A', new ItemStack(spectralcore, 1), 'B' ,new ItemStack(QuantumItems3, 1), 'C' ,photoniy_ingot});
        GameRegistry.addRecipe(new ItemStack(QuantumItems3, 1), new Object[] { "CBC", "BAB", "CBC", 'A', new ItemStack(QuantumItems7, 1), 'B' ,SuperSolarPanels.itemIridiumIronPlate, 'C' ,IC2Items.getItem("carbonPlate")});
        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(IC2Items.getItem("iridiumPlate"), 1), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.QuantumItems2,1) });
        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.QuantumItems2), 9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.QuantumItems4,1) });
        GameRegistry.addRecipe(new ItemStack(QuantumItems5, 1), new Object[] { "CBC", "BAB", "CBC", 'A', IC2Items.getItem("advancedCircuit"), 'B' ,SuperSolarPanels.itemIridiumIronPlate, 'C' ,QuantumItems3});
        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.photoniy), 9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.photoniy_ingot,1) });
        GameRegistry.addRecipe(nanoSaber, new Object[] { "CB ", "CA ", "DEB", 'A', new ItemStack(IC2Items.getItem("nanoSaber").getItem(),1,OreDictionary.WILDCARD_VALUE), 'B', new ItemStack(QuantumItems5, 1), 'C' ,IC2Items.getItem("carbonPlate"), 'D', Items.glowstone_dust, 'E', new ItemStack(lapotronCrystal,1,OreDictionary.WILDCARD_VALUE),});
        GameRegistry.addRecipe(new ItemStack(lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), new Object[] { "CBC", "BAB", "CBC", 'A',new ItemStack(crystal.getItem(), 1, OreDictionary.WILDCARD_VALUE), 'B' ,new ItemStack(QuantumItems3, 1), 'C' ,IC2Items.getItem("iridiumPlate")});
        GameRegistry.addRecipe(quantumHelmet, new Object[] { " B ", "ACA", " A ", 'A', QuantumItems6, 'B' ,new ItemStack(lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(quantumLeggings, new Object[] { " B ", "ACA", " A ", 'A', QuantumItems6, 'B' ,new ItemStack(lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumLeggings").getItem(),1,OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(quantumBodyarmor, new Object[] { " B ", "ACA", " A ", 'A', QuantumItems6, 'B' ,new ItemStack(lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumBodyarmor").getItem(),1,OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(quantumBoots, new Object[] { " B ", "ACA", " A ", 'A', QuantumItems6, 'B' ,new ItemStack(lapotronCrystal,1,OreDictionary.WILDCARD_VALUE), 'C' ,new ItemStack(IC2Items.getItem("quantumBoots").getItem(),1,OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(new ItemStack(nanoBox, 1), new Object[] { " C ", "CBC", " C ",  'B' ,dust, 'C' ,IC2Items.getItem("carbonPlate")});
        GameRegistry.addRecipe(new ItemStack(QuantumItems6,1), new Object[] { " A ", "ACA", " A ", 'A', IC2Items.getItem("iridiumPlate"),  'C' ,nanoBox});
        GameRegistry.addRecipe(new ItemStack(QuantumItems7,1), new Object[] { " A ", "ACA", " A ", 'A', photoniy,  'C' ,nanoBox});
      //  Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(SuperSolarPanels.uuMatterCell,1), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.neutronium,1) });
        Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.neutronium),9), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.neutroniumingot,1) });
        GameRegistry.addRecipe(new ItemStack(neutroniumcore,1), new Object[] { " A ", "ACA", " A ", 'C', photoniccore,  'A' ,neutroniumingot});
        GameRegistry.addRecipe(new ItemStack(enrichedsolar3,1), new Object[] { " A ", "ACA", " A ", 'C',photoniy_ingot,  'A' , SuperSolarPanels.itemEnrichedSunnariumAlloy });
        GameRegistry.addRecipe(new ItemStack(enrichedsolar2,1), new Object[] {  "ACA", 'C',QuantumItems4,  'A' , enrichedsolar3 });
        GameRegistry.addRecipe(new ItemStack(blockSSPSolarPanel, 1, 4), new Object[] { "AAA", "ACA", "AAA", 'A', new ItemStack(blockSSPSolarPanel, 1, 2), 'C', new ItemStack(SuperSolarPanels.neutroniumcore, 1) });
        GameRegistry.addRecipe(massFabricator, new Object[] { " B ", "ACA", " B ", 'C', Ic2Items.massFabricator, 'A', new ItemStack(SuperSolarPanels.QuantumItems5, 1), 'B',new ItemStack(SuperSolarPanels.enderquantumcomponent, 1) });
        GameRegistry.addRecipe(new ItemStack(admincore,1), new Object[] { " A ", "ACA", " A ", 'C',singularcore,  'A' , enrichedsolar3 });
        GameRegistry.addRecipe(new ItemStack(photoniccore,1), new Object[] {  "ACA", 'C',admincore,  'A' , enrichedsolar2 });
        GameRegistry.addRecipe(mfeUnit, new Object[] {  "ACA", 'C', Ic2Items.mfsUnit,  'A' , photoniy_ingot });
        GameRegistry.addRecipe(mfsUnit, new Object[] {  "ACA", 'C', mfeUnit,  'A' , QuantumItems5 });
        GameRegistry.addRecipe(new ItemStack(dust,1) ,new Object[] {  "AAA","AAA","AAA",   'A' , IC2Items.getItem("energiumDust") });
        SuperSolarPanels.proxy.initRecipes();
        
        if (!disableAdvancedSolarHelmetRecipe) {
            Recipes.advRecipes.addRecipe(new ItemStack(advancedSolarHelmet, 1), new Object[] { 
                  " A ", "RBR", "FDF", Character.valueOf('A'), new ItemStack(blockAdvSolarPanel, 1, 0), Character.valueOf('B'), new ItemStack(IC2Items.getItem("nanoHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE), Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'), 
                  IC2Items.getItem("lvTransformer"), Character.valueOf('F'), IC2Items.getItem("insulatedGoldCableItem") }); } else {
                	  Recipes.advRecipes.addRecipe(new ItemStack(advancedSolarHelmet, 1), new Object[] { 
                              " A ", " B ", Character.valueOf('A'), new ItemStack(blockAdvSolarPanel, 1, 0), Character.valueOf('B'), new ItemStack(IC2Items.getItem("nanoHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE) }); 
                       
                  }
          if (!disableHybridSolarHelmetRecipe) {
            Recipes.advRecipes.addRecipe(new ItemStack(hybridSolarHelmet, 1), new Object[] { 
                  " A ", "RBR", "FDF", Character.valueOf('A'), new ItemStack(blockAdvSolarPanel, 1, 1), Character.valueOf('B'),new ItemStack(IC2Items.getItem("quantumHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE), Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'), 
                  IC2Items.getItem("hvTransformer"), Character.valueOf('F'), IC2Items.getItem("glassFiberCableItem") }); }else {
                	  Recipes.advRecipes.addRecipe(new ItemStack(hybridSolarHelmet, 1), new Object[] { 
                              " A ", " B ", Character.valueOf('A'), new ItemStack(blockAdvSolarPanel, 1, 1), Character.valueOf('B'), new ItemStack(IC2Items.getItem("quantumHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE) });
                  }
          if (!disableUltimateSolarHelmetRecipe) {
            Recipes.advRecipes.addRecipe(new ItemStack(ultimateSolarHelmet, 1), new Object[] { 
                  " A ", "RBR", "FDF", Character.valueOf('A'), new ItemStack(blockAdvSolarPanel, 1, 2), Character.valueOf('B'), new ItemStack(IC2Items.getItem("quantumHelmet").getItem(),1,OreDictionary.WILDCARD_VALUE), Character.valueOf('R'), IC2Items.getItem("advancedCircuit"), Character.valueOf('D'), 
                  IC2Items.getItem("hvTransformer"), Character.valueOf('F'), IC2Items.getItem("glassFiberCableItem") });}else {
            Recipes.advRecipes.addRecipe(new ItemStack(ultimateSolarHelmet, 1), new Object[] { "A", "B", Character.valueOf('A'), new ItemStack(blockAdvSolarPanel, 1, 2), Character.valueOf('B'), new ItemStack(hybridSolarHelmet, 1) });
          } 
          if (!enableHardRecipes) {
            if (!disableAdvancedSolarPanelRecipe) {
              Recipes.advRecipes.addRecipe(itemIridiumIronPlate, new Object[] { "AAA", "ABA", "AAA", Character.valueOf('A'), "plateIron", Character.valueOf('B'), "ingotIridium" });
              GameRegistry.addRecipe(itemReinforcedIridiumIronPlate, new Object[] { "ABA", "BCB", "ABA", Character.valueOf('A'), IC2Items.getItem("advancedAlloy"), Character.valueOf('B'), IC2Items.getItem("carbonPlate"), Character.valueOf('C'), itemIridiumIronPlate });
              GameRegistry.addRecipe(itemIrradiantReinforcedPlate, new Object[] { 
                    "ABA", "DCD", "AFA", Character.valueOf('A'), Items.redstone, Character.valueOf('B'), itemSunnariumPart, Character.valueOf('D'), new ItemStack(Items.dye, 1, 4), Character.valueOf('C'), 
                    itemReinforcedIridiumIronPlate, Character.valueOf('F'), Items.diamond });
              if (enableSimpleAdvancedSolarPanelRecipes) {
                GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 0), new Object[] { 
                      "RRR", "DSD", "ABA", Character.valueOf('R'), IC2Items.getItem("reinforcedGlass"), Character.valueOf('D'), IC2Items.getItem("advancedAlloy"), Character.valueOf('S'), IC2Items.getItem("solarPanel"), Character.valueOf('A'), 
                      IC2Items.getItem("advancedCircuit"), Character.valueOf('B'), IC2Items.getItem("advancedMachine") });
              } else {
                GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 0), new Object[] { 
                      "RRR", "DSD", "ABA", Character.valueOf('R'), IC2Items.getItem("reinforcedGlass"), Character.valueOf('D'), IC2Items.getItem("advancedAlloy"), Character.valueOf('S'), IC2Items.getItem("solarPanel"), Character.valueOf('A'), 
                      IC2Items.getItem("advancedCircuit"), Character.valueOf('B'), itemIrradiantReinforcedPlate });
              } 
            } 
            if (!disableUltimateSolarPanelRecipe && !disableAdvancedSolarPanelRecipe)
              GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 2), new Object[] { 
                    " A ", "XMX", "RXR", Character.valueOf('A'), Blocks.lapis_block, Character.valueOf('X'), IC2Items.getItem("coalChunk"), Character.valueOf('M'), new ItemStack(blockAdvSolarPanel, 1, 0), Character.valueOf('R'), 
                    itemSunnariumAlloy }); 
            if (!disableHybridSolarPanelRecipe && !disableAdvancedSolarPanelRecipe) {
              GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 1), new Object[] { 
                    "XMX", "DSD", "ABA", Character.valueOf('X'), IC2Items.getItem("carbonPlate"), Character.valueOf('M'), Blocks.lapis_block, Character.valueOf('D'), IC2Items.getItem("iridiumPlate"), Character.valueOf('S'), 
                    new ItemStack(blockAdvSolarPanel, 1, 0), Character.valueOf('A'), IC2Items.getItem("advancedCircuit"), Character.valueOf('B'), itemSunnarium });
              if (!disableUltimateSolarPanelRecipe)
                GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 2), new Object[] { "MMM", "MXM", "MMM", Character.valueOf('M'), new ItemStack(blockAdvSolarPanel, 1, 1), Character.valueOf('X'), IC2Items.getItem("advancedCircuit") }); 
            } 
          } else {
            if (!disableAdvancedSolarPanelRecipe) {
              ArrayList iridiumList = OreDictionary.getOres("ingotIridium");
              Iterator<ItemStack> iterator = iridiumList.iterator();
              while (iterator.hasNext()) {
                ItemStack itemStack = iterator.next();
                GameRegistry.addRecipe(itemIridiumIronPlate, new Object[] { "AAA", "ABA", "AAA", Character.valueOf('A'), Items.iron_ingot, Character.valueOf('B'), itemStack });
              } 
              GameRegistry.addRecipe(itemReinforcedIridiumIronPlate, new Object[] { "ABA", "BCB", "ABA", Character.valueOf('A'), IC2Items.getItem("advancedAlloy"), Character.valueOf('B'), IC2Items.getItem("carbonPlate"), Character.valueOf('C'), itemIridiumIronPlate });
              GameRegistry.addRecipe(itemIrradiantReinforcedPlate, new Object[] { 
                    "ABA", "DCD", "AFA", Character.valueOf('A'), Items.redstone, Character.valueOf('B'), itemSunnariumPart, Character.valueOf('D'), new ItemStack(Items.dye, 1, 4), Character.valueOf('C'), 
                    itemReinforcedIridiumIronPlate, Character.valueOf('F'), Items.diamond });
              if (enableSimpleAdvancedSolarPanelRecipes) {
                GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 0), new Object[] { 
                      "RRR", "DSD", "ABA", Character.valueOf('R'), itemIrradiantGlassPane, Character.valueOf('D'), IC2Items.getItem("advancedAlloy"), Character.valueOf('S'), IC2Items.getItem("solarPanel"), Character.valueOf('A'), 
                      IC2Items.getItem("advancedCircuit"), Character.valueOf('B'), IC2Items.getItem("advancedMachine") });
              } else {
                GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 0), new Object[] { 
                      "RRR", "DSD", "ABA", Character.valueOf('R'), itemIrradiantGlassPane, Character.valueOf('D'), IC2Items.getItem("advancedAlloy"), Character.valueOf('S'), IC2Items.getItem("solarPanel"), Character.valueOf('A'), 
                      IC2Items.getItem("advancedCircuit"), Character.valueOf('B'), itemIrradiantReinforcedPlate });
              } 
            } 
            if (!disableUltimateSolarPanelRecipe && !disableAdvancedSolarPanelRecipe)
              GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 2), new Object[] { 
                    " A ", "XMX", "RXR", Character.valueOf('A'), Blocks.lapis_block, Character.valueOf('X'), IC2Items.getItem("coalChunk"), Character.valueOf('M'), new ItemStack(blockAdvSolarPanel, 1, 0), Character.valueOf('R'), 
                    itemEnrichedSunnariumAlloy }); 
            if (!disableHybridSolarPanelRecipe && !disableAdvancedSolarPanelRecipe)
              GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 1), new Object[] { 
                    "XMX", "DSD", "ABA", Character.valueOf('X'), IC2Items.getItem("carbonPlate"), Character.valueOf('M'), Blocks.lapis_block, Character.valueOf('D'), IC2Items.getItem("iridiumPlate"), Character.valueOf('S'), 
                    new ItemStack(blockAdvSolarPanel, 1, 0), Character.valueOf('A'), IC2Items.getItem("advancedCircuit"), Character.valueOf('B'), itemEnrichedSunnarium }); 
          } 
          if (!disableUltimateSolarPanelRecipe) {
            GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 2), new Object[] { "MMM", "MXM", "MMM", Character.valueOf('M'), new ItemStack(blockAdvSolarPanel, 1, 1), Character.valueOf('X'), IC2Items.getItem("advancedCircuit") });
            GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 8, 1), new Object[] { "X", Character.valueOf('X'), new ItemStack(blockAdvSolarPanel, 1, 2) });
          } 
          if (!disableMolecularTransformerRecipe) {
            GameRegistry.addRecipe(itemMTCore, new Object[] { "MXM", "M M", "MXM", Character.valueOf('M'), itemIrradiantGlassPane, Character.valueOf('X'), IC2Items.getItem("reactorReflector") });
            GameRegistry.addRecipe(itemMolecularTransformer, new Object[] { 
                  "MXM", "ABA", "MXM", Character.valueOf('M'), IC2Items.getItem("advancedMachine"), Character.valueOf('X'), IC2Items.getItem("evTransformer"), Character.valueOf('A'), IC2Items.getItem("advancedCircuit"), Character.valueOf('B'), 
                  itemMTCore });
          } 
          if (!disableQuantumSolarPanelRecipe) {
            GameRegistry.addRecipe(itemQuantumCore, new Object[] { "XRX", "RSR", "XRX", Character.valueOf('X'), itemEnrichedSunnariumAlloy, Character.valueOf('R'), Items.nether_star, Character.valueOf('S'), Items.ender_eye });
            GameRegistry.addRecipe(new ItemStack(blockAdvSolarPanel, 1, 3), new Object[] { "XXX", "XRX", "XXX", Character.valueOf('X'), new ItemStack(blockAdvSolarPanel, 1, 2), Character.valueOf('R'), itemQuantumCore });
          } 
          GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(itemIrradiantUranium, new Object[] { " R ", "RSR", " R ", Character.valueOf('R'), Items.glowstone_dust, Character.valueOf('S'), "ingotUranium" }));
          GameRegistry.addRecipe(setItemsSize(itemIrradiantGlassPane, 6), new Object[] { "RRR", "ASA", "RRR", Character.valueOf('R'), IC2Items.getItem("reinforcedGlass"), Character.valueOf('A'), itemIrradiantUranium, Character.valueOf('S'), Items.glowstone_dust });
          GameRegistry.addRecipe(itemEnrichedSunnarium, new Object[] { "RRR", "RSR", "RRR", Character.valueOf('R'), itemIrradiantUranium, Character.valueOf('S'), itemSunnarium });
          GameRegistry.addRecipe(itemEnrichedSunnariumAlloy, new Object[] { " R ", "RSR", " R ", Character.valueOf('R'), itemEnrichedSunnarium, Character.valueOf('S'), itemSunnariumAlloy });
          GameRegistry.addRecipe(itemSunnariumAlloy, new Object[] { "MMM", "MXM", "MMM", Character.valueOf('M'), IC2Items.getItem("iridiumPlate"), Character.valueOf('X'), itemSunnarium });
          GameRegistry.addRecipe(itemSunnarium, new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'), itemSunnariumPart });
           }

      
    
    
    static {
        tabssp = new CreativeTabSSP();
        
        SuperSolarPanels.instance = new SuperSolarPanels();
    }
    
    static float getColor(int par1) {
        if (par1 >= 255)
          return 1.0F; 
        if (par1 < 0)
          return 0.0F; 
        return par1 / 255.0F;
      }

    public static boolean isSimulating() {
        return !FMLCommonHandler.instance().getEffectiveSide().isClient();
    }
    
    public static NBTTagCompound getOrCreateNbtData(final ItemStack itemstack) {
        NBTTagCompound nbttagcompound = itemstack.getTagCompound();
        if (nbttagcompound == null) {
            nbttagcompound = new NBTTagCompound();
            itemstack.setTagCompound(nbttagcompound);
            nbttagcompound.setInteger("charge", 0);
        }
        return nbttagcompound;
    }
    
}
