

package com.Denfop;
import com.Denfop.item.energy.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import ic2.api.energy.EnergyNet;
import ic2.api.energy.IEnergyNet;
import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import ic2.core.init.MainConfig;
import ic2.core.util.ConfigUtil;
import ic2.core.util.SideGateway;
import ic2.core.util.StackUtil;
import ic2.core.util.Util;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.Denfop.Recipes.AlloySmelterRecipe;
import com.Denfop.Recipes.BasicRecipe;
import com.Denfop.Recipes.CannerRecipe;
import com.Denfop.Recipes.CompressorRecipe;
import com.Denfop.Recipes.FurnaceRecipes;
import com.Denfop.Recipes.MaceratorRecipe;
import com.Denfop.Register.Register;
import com.Denfop.Register.RegisterOreDict;
import com.Denfop.World.GenOre;
import com.Denfop.block.AdminPanel.Adminsolarpanel;
import com.Denfop.block.AdminPanel.ItemAdminSolarPanel;
import com.Denfop.block.Base.BlockElectric;
import com.Denfop.block.Base.BlockIC2Fluid;
import com.Denfop.block.Base.BlockSSP;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.block.Base.BlocksItems;
import com.Denfop.block.Sintezator.ItemSintezator;
import com.Denfop.block.cable.BlockCable;
import com.Denfop.block.expgen.BlockExpGen;
import com.Denfop.block.expgen.TextureHooks;
import com.Denfop.block.mechanism.BlockMachine;
import com.Denfop.events.EventHandlerEntity;
import com.Denfop.events.SSPEventHandler;
import com.Denfop.events.DE.SSPDEEventHandler;
import com.Denfop.events.DE_MF.SSPDEMFEventHandler;
import com.Denfop.events.DE_MF_EP.SSPMFDEEventHandler;
import com.Denfop.events.EP.SSPEPEventHandler;
import com.Denfop.events.EP_DE.SSPDEEPEventHandler;
import com.Denfop.events.MF.SSPMFEventHandler;
import com.Denfop.events.MF_EP.SSPMPMFEventHandler;
import com.Denfop.integration.Avaritia.AvaritiaIntegration;
import com.Denfop.integration.Botania.BotaniaIntegration;
import com.Denfop.integration.DE.DraconicIntegration;
import com.Denfop.item.Modules.ItemWirelessModule;
import com.Denfop.item.armour.ItemArmorImprovemedQuantum;
import com.Denfop.item.base.ItemCable;
import com.Denfop.item.base.SSPItem;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.proxy.CommonProxy;
import com.Denfop.tab.CreativeTabSSP;
import com.Denfop.tab.CreativeTabSSP1;
import com.Denfop.tab.CreativeTabSSP2;
import com.Denfop.tab.CreativeTabSSP3;
import com.Denfop.tab.CreativeTabSSP4;
import com.Denfop.tiles.Mechanism.*;
import com.Denfop.tiles.base.TileEntityAdminSolarPanel;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;


import aroma1997.uncomplication.enet.EnergyNetGlobal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
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
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.MOD_VERSION, dependencies = Constants.DEPENDENCES,acceptedMinecraftVersions = Constants.acceptedMinecraftVersions,certificateFingerprint = "Denfop-certificate")
public class SuperSolarPanels
{
	   
	
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
	public static ItemStack vajraCharger;
	
	
	
	
	public static Block blockfluidxp;
	
	public static Fluid fluidXpJuice;
	
	 public static Item dust;
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
    public static Item singularcore;
    public static Item spectralcore;
    public static Item photoniy;
    public static Item photoniy_ingot;
    public static Item quantumHelmet;
    public static Item quantumBodyarmor;
    public static Item quantumLeggings;
    public static Item quantumBoots;
    public static ItemStack quantumHelmet1;
    public static ItemStack quantumBodyarmor1;
    public static ItemStack quantumLeggings1;
    public static ItemStack quantumBoots1;
    public static Item nanoSaber;
    public static Item lightAlloy;
    public static Item quantumPack;
    public static Item accumulator;
    public static Item bigAccumulator;
    public static Item belt;
    public static Item quantumBox;
    public static Item nanoBox;
    public static Item toolBox;

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
	public static Item lapotronCrystal;
	public static int spectralsaberactive;
	public static int spectralsabernotactive;
	public static int Storagequantumsuit;
	public static int neutronpanelGenDay;
	public static int neutronpanelOutput;
	public static int neutronpanelGenNight;
	public static int neutronpanelStorage;
	
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
	
	public static ItemStack mfeUnit;
	public static ItemStack mfsUnit;
	public static ItemStack hvTransformer;
	public static ItemStack evTransformer;
	  public static Block blockfluidbit;
	  public static Fluid neutronium1 = new Fluid("neutronium1");
	    public static Block blockfluidneutronium;
		public static ItemStack cell;
		public static  Item cell_all;
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
	    public static Item advancedSolarHelmet;
	    public static Item hybridSolarHelmet;
	    public static Item ultimateSolarHelmet;
	    public static ItemStack ingotIridium;
	    public static ItemStack itemIrradiantUranium;
	    public static ItemStack itemEnrichedPhotoniyAlloy;
	    public static ItemStack itemIrradiantGlassPane;
	    public static ItemStack itemIridiumIronPlate;
	    public static ItemStack itemReinforcedIridiumIronPlate;
	    public static ItemStack itemIrradiantReinforcedPlate;
	    public static ItemStack itemQuantumCore;
	    public static ItemStack itemUranIngot;
	    public static ItemStack itemUHSP;
	    public static ItemStack itemMTCore;
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
		
		public static ItemStack spectralcable;
		public static ItemStack protoncable;
		public static ItemStack singularcable;
		public static ItemStack photoniycable;
		public static ItemStack machine;
		public static ItemStack advancedMachine;
		public static ItemStack macerator;
		public static ItemStack extractor;
		public static ItemStack compressor;
		public static ItemStack inductionFurnace;
		public static ItemStack massFabricator1;
		public static ItemStack macerator1;
		public static ItemStack ironfurnace;
		public static ItemStack compressor1;
		public static ItemStack electroFurnace;
		public static ItemStack electroFurnace1;
		public static ItemStack metalformer;
		public static ItemStack metalformer1;
		public static ItemStack iridium;
		public static ItemStack compressiridium;
		public static ItemStack spectral;
		public static ItemStack reactorDepletedprotonSimple;
		public static ItemStack reactorDepletedprotonDual;
		public static ItemStack reactorDepletedprotonQuad;
		public static ItemStack reactorDepletedprotoneit;
		public static ItemStack reactorprotonSimple;
		public static ItemStack reactorprotonDual;
		public static ItemStack reactorprotonQuad;
		public static ItemStack reactorprotoneit;
		public static Item proton;
		public static Item protonshard;
		public static Item QuantumItems8;
		public static Item QuantumItems9;
		public static Item coal_chunk1;
		public static Item compresscarbon;
		public static Item compresscarbonultra;
		public static Item protoncore;
		public static Item nightlinse;
		public static Item sunlinse;
		public static Item rainlinse;
		public static ItemStack reactorCoolantsix;
		public static ItemStack reactorCoolanttwelve;
		public static ItemStack reactorCoolantmax;
		public static Item aerlinse;
		public static Item earthlinse;
		public static Item netherlinse;
		public static Item endlinse;
		public Block blockAdvSolarPanel7;
		public static Item nanoSaber1;
		public static  Block wolframore;
		public static Block chromiumore;
		public static Block platiumore;
		public static Block silverore;
		public static Block magnesiumore;
		public static Block mikhail_ore;
		public static Block spinelore;
		public static boolean AvaritiaLoaded;
		public static boolean BotaniaLoaded;
		public static  Item ultDDrill;
		public static ItemStack module61;
		public static ItemStack module62;
		public static ItemStack module63;
		public static ItemStack module65;
		public static  ItemStack module66;
		public static ItemStack module64;
		public static ItemStack module67;
		public static ItemStack module68;
		public static ItemStack module69;
		public static ItemStack module70;
		public static boolean AE2Loaded;
		public static boolean Draconic;
		public static  boolean Botania;
		public static boolean Avaritia;
		public static Block expgen;
		public static Item module8;
		public static Item goldenwrench;
		public static ItemStack module71;
		public static ItemStack module72;
		public static ItemStack module73;
		public static ItemStack module74;
		public static ItemStack module75;
		public static boolean EnchantingPlus;
		public static  boolean MineFactory;
		 public static int Radius;
		 public static int durability;
		 public static int efficiency;
		 public static int minWindStrength;
		 public static int maxWindStrength;
		 public static int Radius1;
		 public static int durability1;
		 public static int efficiency1;
		 public static int minWindStrength1;
		 public static int maxWindStrength1;
		 public static int Radius2;
		 public static int durability2;
		 public static int efficiency2;
		 public static int minWindStrength2;
		 public static int maxWindStrength2;
		public static int MaxChangesaber;
		public static int transferLimitsaber;
		public static int tiersaber;
		public static int Quantumsaberactive;
		public static int Quantumsabernotactive;
		public static boolean Streak;
		
		public static boolean DraconicLoaded;
		 public static int spectralsaberactive1;
		 public static int spectralsabernotactive1;
		 public static int maxCharge1;
		public static int transferLimit1;
		public static ItemStack overclockerUpgrade;
		public static ItemStack overclockerUpgrade1;
		public static Block iridiumore;
		public static Item iridium_nugget;
		public static Item michail_plate;
		public static Item mikhail_ingot;
		public static Item mikhail_nugget;
		public static Item chromium_plate;
		public static Item chromium_nugget;
		public static Item chromium_ingot;
		public static Item wolfram_nugget;
		public static Item spinel_plate;
		public static Item spinel_nugget;
		public static Item spinel_ingot;
		public static Item platium_plate;
		public static Item platium_nugget;
		public static Item platium_ingot;
		public static Item wolfram_ingot;
		public static ItemStack alloymachine;
		public static Item photoniyglass1;
		public static Item photoniyglass5;
		public static Item photoniyglass4;
		public static Item photoniyglass3;
		public static Item photoniyglass2;
		public static Item photoniyglass10;
		public static Item photoniyglass9;
		public static Item photoniyglass8;
		public static Item photoniyglass7;
		public static Item photoniyglass6;
		public static ItemStack goldCableItem;
		public static ItemStack doubleInsulatedGoldCableItem;
		public static ItemStack insulatedGoldCableItem;
		public static ItemStack ironCableItem;
		public static ItemStack tinCableItem;
		public static ItemStack doubleInsulatedIronCableItem;
		public static ItemStack insulatedIronCableItem;
		public static ItemStack glassFiberCableItem;
		public static ItemStack trippleInsulatedIronCableItem;
		public static ItemStack insulatedTinCableItem;
		public static ItemStack splitterCableItem;
		public static ItemStack detectorCableItem;
		public static ItemStack goldCableBlock;
		public static ItemStack doubleInsulatedGoldCableBlock;
		public static ItemStack insulatedGoldCableBlock;
		public static Block BlockCable;
		public static ItemStack ironCableBlock;
		public static ItemStack doubleInsulatedIronCableBlock;
		public static ItemStack trippleInsulatedIronCableBlock;
		public static ItemStack splitterCableBlock;
		public static ItemStack insulatedtinCableBlock;
		public static ItemStack detectorCableBlock;
		public static ItemStack tinCableBlock;
		public static ItemStack glassFiberCableBlock;
		public static ItemStack insulatedIronCableBlock;
		public static ItemStack constructionFoam;
		public static ItemStack constructionFoamWall;
		public static ItemStack ChargepadmfsUnit;
		public static ItemStack ChargepadmfeUnit;
		public static  Block endgold_stone;
		public static Block nethergoldrack;
		public static Block netherironrack;
		public static Block endiron_stone;
		public static Block netherlapisrack;
		public static Block endlapis_stone;
		public static Block netherredstonerack;
		public static Block endredstone_stone;
		public static Block nethercoalrack;
		public static  Block endcoal_stone;
		public static Block netherdiamondrack;
		public static Block enddiamond_stone;
		public static Block netheremeraldrack;
		public static Block endemerald_stone;
		public static Block netherleadrack;
		public static Block endlead_stone;
		public static Block nethertinrack;
		public static Block endtin_stone;
		public static Block netheruranrack;
		public static Block enduran_stone;
		public static Block nethercopperrack;
		public static Block endcopper_stone;
		  public static Random random = new Random();
		public static Item advanced_core;
		public static Item hybrid_core;
		public static Item ultimate_core;
		public static Block blockadmin;
		public static Item module;
		public static Item module1;
		public static Item module2;
		public static Item module3;
		public static Item module4;
		public static Item module5;
		public static Item module6;
		public static Item module7;
		public static int TerrasteelRodCells;
		public static int TerrasteelRodHeat;
		public static float TerrasteelPower;
		public static int ProtonRodHeat;
		public static int ProtonRodCells;
		public static float ProtonPower;
		public static Item wolfram_plate;
		public static ItemCable cable;
		public static Item itemSSP;
		public static BlockMachine machine1;
		public static Block blocksintezator;
		public static boolean displayHud;
		public static int hudPos;
		public static Item magnesium_ingot;
		public static Item magnesium_plate;
		public static Item magnesium_nugget;
		public static Block toriyore;
		public static Item toriy;
		public static Item chromiumcrushedore;
		public static Item electriumdust;
		public static Item electriumingot;
		public static Item electriumplate;
		public static Item blast;
		public static Item invardust;
		public static Item invaringot;
		public static Item invarplate;
		public static Item nickel;
		public static Item nickelplate;
		public static Item michalovcrushedore;
		public static Block nicelore;
		public static Block magnetitore;
		public static ItemStack reactorDepletedtoriySimple;
		public static ItemStack reactorDepletedtoriyDual;
		public static ItemStack reactorDepletedtoriyQuad;
		public static ItemStack reactortoriySimple;
		public static ItemStack reactortoriyDual;
		public static ItemStack reactortoriyQuad;
		public static Item iridiumcrushedore;
		public static Item wolframcrushedore;
		public static Item magnesiumcrushedore;
		public static Item nickelcrushedore;
		public static Item platiumcrushedore;
		public static Item spinelcrushedore;
		public static Item updatekits;
		public static ItemStack photon;
		public static ItemStack neutron;
		public static ItemStack myphical;
		public static int Radius3;
		public static int durability3;
		public static int efficiency3;
		public static int minWindStrength3;
		public static int maxWindStrength3;
		public static int Radius4;
		public static int durability4;
		public static int efficiency4;
		public static int minWindStrength4;
		public static int maxWindStrength4;
		public static int Radius5;
		public static int durability5;
		public static int efficiency5;
		public static int maxWindStrength5;
		public static int minWindStrength5;
		public static Block machines;
		public static Block electricblock;
		public static Item matter;
		public static ItemStack massFabricator2;
		public static ItemStack massFabricator3;
		public static ItemStack generationmicrochip;
		public static ItemStack moleculartransformer;
		public static CreativeTabSSP1 tabssp1;
		public static CreativeTabSSP2 tabssp2;
		public static CreativeTabSSP3 tabssp3;
		public static CreativeTabSSP4 tabssp4;
		public static Block machines_base;
		public static Block Chargepadelectricblock;
		public static Block cableblock;
		
		public static class FluidXP {
			public static Fluid xpJuice = new Fluid("xpjuice.wv");
			
		}
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        Config.config(event);
        if (Loader.isModLoaded("AdvancedSolarPanel"))
            proxy.throwInitException(new LoaderException("SuperSolarPanels is incompatible with Advanced Solar Panels.Please delete Advanced solar Panels")); 
        DraconicLoaded = Loader.isModLoaded("DraconicEvolution");
        AvaritiaLoaded = Loader.isModLoaded("Avaritia");
        BotaniaLoaded = Loader.isModLoaded("Botania");
        EnchantingPlus = Loader.isModLoaded("eplus");
MineFactory = Loader.isModLoaded("MineFactoryReloaded");
if(SuperSolarPanels.DraconicLoaded && SuperSolarPanels.Draconic == true) {
	DraconicIntegration.init();
}
if(SuperSolarPanels.AvaritiaLoaded && SuperSolarPanels.Avaritia == true) {
	AvaritiaIntegration.init();
}

if(SuperSolarPanels.BotaniaLoaded && SuperSolarPanels.Botania == true) {
	BotaniaIntegration.init();
}
BlocksItems.init();
       
		 NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
       	GenOre.init();
       
        Register.register();
		 Register.registertiles();
		 BlocksItems.registermetadata();
		 
        RegisterOreDict.oredict();
          SuperSolarPanels.proxy.registerRenderers();
        SuperSolarPanels.proxy.load();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, (IGuiHandler)SuperSolarPanels.proxy);

        proxy.initCore();
   
	
		
		 
    }
 
    public static ItemStack setItemsSize(final ItemStack itemStack, final int newSize) {
        final ItemStack newStack = itemStack.copy();
        newStack.stackSize = newSize;
        return newStack;
    }
    @Mod.EventHandler
    public void load(final FMLInitializationEvent event) {
    	
    }

    

    public static void initENet() {
        EnergyNet.instance = (IEnergyNet)EnergyNetGlobal.initialize();
    }

	public static int getSeaLevel(World world) {
        return world.provider.getAverageGroundLevel();
      }
      

    @EventHandler
    public void onMissingMappings(FMLMissingMappingsEvent event) {
      BlocksItems.onMissingMappings(event);
    }
    public static void addLog(final String logLine) {
        System.out.println("[SuperSolarPanel] " + logLine);
    }
  
    @Mod.EventHandler
    public void Init(final FMLInitializationEvent event) {
		
		
		
     
        proxy.registerEvents();
    }
   
    @Mod.EventHandler
    public void afterModsLoaded(final FMLPostInitializationEvent event) {
    	
         proxy.registerRenderers();
         proxy.registerRecipe();
      
    }

      
    
    
    static {
        tabssp = new CreativeTabSSP();
         tabssp1 = new CreativeTabSSP1();
         tabssp2 = new CreativeTabSSP2();
         tabssp3 = new CreativeTabSSP3();
         tabssp4 = new CreativeTabSSP4();
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
            nbttagcompound.setInteger("Fly", 0);
            nbttagcompound.setInteger("solarType", 0);
            nbttagcompound.setInteger("energy", 0);
            nbttagcompound.setInteger("energy2", 0);
            nbttagcompound.setBoolean("isFlyActive", false);
            nbttagcompound.setBoolean("EnableWirelles", false);
            nbttagcompound.setBoolean("create", true);
            nbttagcompound.setString("World", "");
            nbttagcompound.setInteger("World1", 0);
            nbttagcompound.setInteger("Xcoord", 0);
            nbttagcompound.setInteger("Ycoord", 0);
            nbttagcompound.setInteger("Zcoord", 0);
            nbttagcompound.setInteger("tier", 0);
            nbttagcompound.setString("Name", "");
            
        }
        return nbttagcompound;
    }
   
    public static NBTTagCompound getOrCreateNbtData1(final EntityPlayer player) {
        NBTTagCompound nbttagcompound = player.getEntityData();

        if (nbttagcompound == null) {
            nbttagcompound = new NBTTagCompound();
            nbttagcompound.setBoolean("isFlyActive", false);
            nbttagcompound.setBoolean("isNightVision", false);
            nbttagcompound.setBoolean("stepHeight", false);
        }
        return nbttagcompound;
    }
    
   
}
