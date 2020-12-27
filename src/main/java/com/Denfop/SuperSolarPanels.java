

package com.Denfop;

import com.Denfop.item.energy.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

import com.Denfop.Recipes.BasicRecipe;
import com.Denfop.Recipes.CannerRecipe;
import com.Denfop.Recipes.CompressorRecipe;
import com.Denfop.Recipes.FurnaceRecipes;
import com.Denfop.api.TickHandlerWV;
import com.Denfop.block.AdminPanel.Adminsolarpanel;
import com.Denfop.block.AdminPanel.ItemAdminSolarPanel;
import com.Denfop.block.AdminPanel.TileEntityAdminSolarPanel;
import com.Denfop.block.Base.BlockIC2Fluid;
import com.Denfop.block.Base.BlockSSP;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.block.Base.BlocksItems;
import com.Denfop.block.BlockVajra.BlockVajraCharger;
import com.Denfop.block.BlockVajra.ItemBlockVCh;
import com.Denfop.block.BlockVajra.TileVajraCharger;
import com.Denfop.block.BlockVajra.TileVajraChargerElectric;
import com.Denfop.block.BlockVajra.WirelessVajra;
import com.Denfop.block.Sintezator.ItemSintezator;
import com.Denfop.block.Sintezator.Sintezator;
import com.Denfop.block.Sintezator.TileEntitySintezator;
import com.Denfop.block.TileEntityDoubleMetalFormer.TileEntityDoubleMetalFormer;
import com.Denfop.block.TileEntityTripleMetalFormer.TileEntityTripleMetalFormer;
import com.Denfop.block.WirellesStorage.BlockWStorage;
import com.Denfop.block.WirellesStorage.BlockWStorage2;
import com.Denfop.block.WirellesStorage.ItemBlockWirelessStorage;
import com.Denfop.block.WirellesStorage.ItemBlockWirelessStorage2;
import com.Denfop.block.WirellesStorage.TileWirelessStorage1Tier;
import com.Denfop.block.WirellesStorage.TileWirelessStorageTier2;
import com.Denfop.block.armorcharge.BlockArmorCharger;
import com.Denfop.block.armorcharge.ItemBlockArmorCharger;
import com.Denfop.block.cable.ItemCable;
import com.Denfop.block.doublecompressor.TileEntityDoubleCompressor;
import com.Denfop.block.doubleelecfurnace.TileEntityDoubleElectricFurnace;
import com.Denfop.block.doubleextractor.TileEntityDoubleExtractor;
import com.Denfop.block.doublemacertator.TileEntityDoubleMacerator;
import com.Denfop.block.expgen.BlockExpGen;
import com.Denfop.block.expgen.ItemBlockEG;
import com.Denfop.block.expgen.TextureHooks;
import com.Denfop.block.expgen.TileXPGenPublic;
import com.Denfop.block.mechanism.BlockMachine;
import com.Denfop.block.moleculartransformer.BlockMolecularTransformer;
import com.Denfop.block.neutroniumgenerator.Blockbitgen;
import com.Denfop.block.ore.BlockSSPCoal;
import com.Denfop.block.ore.BlockSSPDiamond;
import com.Denfop.block.ore.BlockSSPEmerald;
import com.Denfop.block.ore.BlockSSPLapis;
import com.Denfop.block.ore.BlockSSPRedstone;
import com.Denfop.block.triplecompressor.TileEntityTripleCompressor;
import com.Denfop.block.triplemacerator.TileEntityTripleMacerator;
import com.Denfop.events.EventHandlerEntity;
import com.Denfop.handler.ASPPacketHandler;
import com.Denfop.integration.ASP.ASPIntegration;
import com.Denfop.integration.Avaritia.AvaritiaIntegration;
import com.Denfop.integration.Botania.BotaniaIntegration;
import com.Denfop.integration.DE.DraconicIntegration;
import com.Denfop.item.ItemSSPCrafring;
import com.Denfop.item.Connector.ItemWirelessConnector3;
import com.Denfop.item.Modules.ItemWirelessModule;
import com.Denfop.item.Moleculartransformer.ItemMolecularTransformer;
import com.Denfop.item.Upgrade.ItemUpgradeModule;
import com.Denfop.item.armour.ItemArmorQuantumSuit1;
import com.Denfop.item.armour.ItemSolarPanelHelmet;
import com.Denfop.item.base.ItemAdvSolarPanel1;
import com.Denfop.item.base.ItemGoldenWrench;
import com.Denfop.item.base.ItemSSPSolarPanel;
import com.Denfop.item.base.SSPItem;
import com.Denfop.item.energy.ItemBattery;
import com.Denfop.item.energy.ItemNanoSaber;
import com.Denfop.item.solarhelmet.ItemAdvancedSolarHelmet;
import com.Denfop.packets.WVPacketHandler;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.proxy.CommonProxy;
import com.Denfop.tab.CreativeTabSSP;
import com.Denfop.tiles.overtimepanel.*;
import com.Denfop.tiles.overtimepanel.TileNeutronSolarPanel;
import com.Denfop.tiles.overtimepanel.TilePhotonicSolarPanel;
import com.Denfop.tiles.overtimepanel.TileSingularSolarPanel;
import com.Denfop.tiles.overtimepanel.TileSpectralSolarPanel;
import com.Denfop.utils.InternalName;
import com.Denfop.utils.MTRecipeConfig;
import com.Denfop.utils.StackUtils;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
@Mod(modid = "supersolarpanel", name = "Super Solar Panel && Industrial Upgrade", version = "1.4.1", dependencies = "required-after:IC2;after:wirelessvajra;after:Thaumcraft;after:AppliedEnergistics;")
public class SuperSolarPanels implements IWorldGenerator
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
	public static TickHandlerWV th;
	
	
	
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
    public static Item solarsplitter;
    public static Item bluecomponent;
    public static Item greencomponent;
    public static Item redcomponent;
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
    public static final String MOD_ID = "supersolarpanel";
    public static final String MOD_NAME = "Super Solar Panel";
    public static final String MOD_VERSION = "1.4";
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
	public static Item lapotronCrystal;
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
	    public static Item wirelessVajra;
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
		public boolean AvaritiaLoaded;
		public static boolean BotaniaLoaded;
		public static  Item ultDDrill;
		public ItemStack module61;
		public ItemStack module62;
		public ItemStack module63;
		public ItemStack module65;
		public ItemStack module66;
		public ItemStack module64;
		public ItemStack module67;
		public ItemStack module68;
		public ItemStack module69;
		public ItemStack module70;
		public static boolean AE2Loaded;
		public static boolean Draconic;
		public static  boolean Botania;
		public static boolean Avaritia;
		public static boolean ASPLoaded;
		public static Block expgen;
		public static Item module8;
		public static Item goldenwrench;
		public ItemStack module71;
		public ItemStack module72;
		public ItemStack module73;
		public ItemStack module74;
		public ItemStack module75;
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
		public static ItemStack module;
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
		//

		public static boolean displayHud;
		public static int hudPos;
		public static class FluidXP {
			public static Fluid xpJuice = new Fluid("xpjuice.wv");
			
		}
		
		
		//
	    public static final String CATEGORY_RECIPES = "recipes settings";
	    public static final String CATEGORY_QGENERATOR = "quantum generator";
	 
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        try {
            config.load();
            MTRecipeConfig.doDebug();
            singularpanelstorage = config.get("Singular Solar panel", "SingularSPStorage", 10000000).getInt(10000000); 
            SuperSolarPanels.configFileName = event.getSuggestedConfigurationFile().getAbsolutePath();
          //
            
            //
            spectralpanelGenDay = config.get("Spectral Solar panel", "SpectralSPGenDay", 2560).getInt(2560);
            protongenDay = config.get("Proton Solar panel", "ProtonGenDay", 10240).getInt(10240);
            protongennitht = config.get("Proton Solar panel", "ProtonGenNight", 5120).getInt(5120);
            protonOutput = config.get("Proton Solar panel", "ProtonOutput", 20480).getInt(20480);
            protontier = config.get("Proton Solar panel", "Protonstorage", 5000000).getInt(5000000);
            spectralpanelGenNight = config.get("Spectral Solar panel", "SpectralSPGenNight", 1280).getInt(1280);
            singularpanelGenDay = config.get("Singular Solar panel", "SingularSPGenDay", 40960).getInt(40960);
            singularpanelGenNight = config.get("Singular Solar panel", "SingularSPGenNight", 40960).getInt(40960);
            singularpanelOutput = config.get("Singular Solar panel", "SingularSPOutput", 81920).getInt(81920);
            spectralpanelOutput = config.get("Spectral Solar panel", "SpectralSPOutput", 5120).getInt(5120);
            adminpanelGenDay = config.get("Light-Adbord Solar panel", "AdminPanelGenDay", 163840).getInt(163840);
            adminpanelGenNight = config.get("Light-Adbord Solar panel", "AdminPanelGenNight", 163840).getInt(163840);
            AdminpanelStorage = config.get("Light-Adbord Solar panel", "AdminPanelStorage", 10000000).getInt(10000000);
            AdminpanelOutput = config.get("Light-Adbord Solar panel", "AdminPanelOutput", 327680).getInt(327680);
            photonicpanelGenDay = config.get("Photonic Solar panel", "PhotonicPanelGenDay", 655360).getInt(655360);
            photonicpanelGenNight = config.get("Photonic Solar panel", "PhotonicPanelGenNight", 655360).getInt(655360);
            photonicpanelOutput = config.get("Photonic Solar panel", "PhotonicPanelOutput", 1310720).getInt(1310720);
            photonicpanelStorage = config.get("Photonic Solar panel", "PhotonicPanelStorage", 10000000).getInt(10000000);
            neutronpanelGenDay = config.get("Neutronium Solar panel", "NeutronPanelGenDay", 2621440).getInt(2621440);
            neutronpanelGenNight = config.get("Neutronium Solar panel", "NeutronPanelGenNight", 2621440).getInt(2621440);
            neutronpanelOutput = config.get("Neutronium Solar panel", "NeutronPanelOutput", 5242880).getInt(5242880);
            neutronpanelStorage = config.get("Neutronium Solar panel", "NeutronPanelStorage", 30000000).getInt(30000000);
            Storagequantumsuit = config.get("Quantum armor", "Storage Enriched Quantum Suit", 100000000).getInt(100000000);
            spectralsaberactive1 = config.get("Quantum Saber", "SpectralSaber Damage Active", 40).getInt(40);
            spectralsabernotactive1 = config.get("Quantum Saber", "SpectralSaber Damage Not Active", 8).getInt(8);
            maxCharge1 = config.get("Quantum Saber", "SpectralSaber max Charge", 300000).getInt(300000);
            transferLimit1= config.get("Quantum Saber", "SpectralSaber transfer Limit", 20000).getInt(20000);
            tier1= config.get("Quantum Saber", "SpectralSaber tier", 4).getInt(4);
            energy= config.get("Neutronium generator", "Consumes energy to make 1 mb neutronim", 15625000.0F).getInt((int) 15625000.0F);
            spectralpanelstorage= config.get("Spectral Solar panel", "Spectral Solar panel Storage", 500000).getInt(500000);
            
            maxCharge = config.get("Quantum Saber", "SpectralSaber max Charge", 600000).getInt(300000);
            transferLimit= config.get("Quantum Saber", "SpectralSaber transfer Limit", 40000).getInt(20000);
            tier= config.get("Quantum Saber", "SpectralSaber tier", 5).getInt(5);
            spectralsaberactive = config.get("Spectral Saber", "SpectralSaber Damage Active", 60).getInt(60);
            spectralsabernotactive = config.get("Spectral Saber", "SpectralSaber Damage Not Active", 12).getInt(12);
          
            
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
    	   MaxChangesaber= config.get("Quantum Saber", "MaxChange", 300000).getInt(300000);
    	   transferLimitsaber= config.get("Quantum Saber", "transfer Limit", 1000).getInt(1000);
    	   tiersaber= config.get("Quantum Saber", "tier", 3).getInt(3);
    	   Quantumsaberactive= config.get("Quantum Saber", "Damage saber active", 40).getInt(40);
    	   Quantumsabernotactive= config.get("Quantum Saber", "Damage saber not active", 8).getInt(8);
    	   
    	   
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
            thaumcraft= config.get("Integrestion", "DIntegrestion Thaumcraft", false).getBoolean(false);
            wireless = config.get("Integrestion", "Integrestion Wireless Solar Panels", false).getBoolean(false);
            Draconic = config.get("Integrestion", "Integrestion Draconic Evolution", true).getBoolean(true);
            Botania = config.get("Integrestion", "Integrestion Botania", true).getBoolean(true); 
            Avaritia = config.get("Integrestion", "Integrestion Avaritia", true).getBoolean(true); 
          
            advGenDay = config.get("general", "AdvancedSPGenDay", 10).getInt(10);
            advGenNight = config.get("general", "AdvancedSPGenNight", 5).getInt(5);
            advStorage = config.get("general", "AdvancedSPStorage", 3200).getInt(3200);
            advOutput = config.get("general", "AdvancedSPOutput", 20).getInt(20);
            hGenDay = config.get("general", "HybrydSPGenDay", 40).getInt(40);
            hGenNight = config.get("general", "HybrydSPGenNight", 15).getInt(15);
            hStorage = config.get("general", "HybrydSPStorage", 10000).getInt(10000);
            hOutput = config.get("general", "HybrydSPOutput", 80).getInt(80);
            uhGenDay = config.get("general", "UltimateHSPGenDay", 160).getInt(160);
            uhGenNight = config.get("general", "UltimateHSPGenNight", 80).getInt(80);
            uhStorage = config.get("general", "UltimateHSPStorage", 100000).getInt(100000);
            uhOutput = config.get("general", "UltimateHSPOutput", 320).getInt(320);
            qpGenDay = config.get("general", "QuantumSPGenDay", 640).getInt(640);
            qpGenNight = config.get("general", "QuantumSPGenNight", 160).getInt(160);
            qpStorage = config.get("general", "QuantumSPStorage", 1000000).getInt(1000000);
            qpOutput = config.get("general", "QuantumSPOutput", 1280).getInt(1280);
         //
            TerrasteelRodHeat = config.get("TerrasteelRod", "Heat", 1).getInt(1);
            TerrasteelRodCells = config.get("TerrasteelRod", "Cells", 20000).getInt(20000);
            TerrasteelPower = config.get("TerrasteelRod", "Power", 2).getInt(2);
            //
            ProtonRodHeat = config.get("ProtonRod", "Heat", 2).getInt(2);
            ProtonRodCells = config.get("ProtonRod", "Cells", 30000).getInt(30000);
            ProtonPower = config.get("ProtonRod", "Power", 4).getInt(4);
            //
            Radius = config.get("Iridium rotor", "Radius", 11).getInt(11);
            durability = config.get("Iridium rotor", "durability", 648000).getInt(648000);
            efficiency = config.get("Iridium rotor", "efficiency", 2.0F).getInt((int) 2.0F);
            minWindStrength = config.get("Iridium rotor", "minWindStrength", 25).getInt(25);
            maxWindStrength = config.get("Iridium rotor", "maxWindStrength", 110).getInt(110);
            //
            Radius1 = config.get("Compress Iridium rotor", "Radius", 11).getInt(11);
            durability1 = config.get("Compress Iridium rotor", "durability", 720000).getInt(720000);
            efficiency1 = config.get("Compress Iridium rotor", "efficiency", 3.0F).getInt((int) 3.0F);
            minWindStrength1 = config.get("Compress Iridium rotor", "minWindStrength", 25).getInt(25);
            maxWindStrength1 = config.get("Compress Iridium rotor", "maxWindStrength", 110).getInt(110);
            //
            Radius2 = config.get("Spectral rotor", "Radius", 11).getInt(11);
            durability2 = config.get("Spectral rotor", "durability", 172800).getInt(172800);
            efficiency2 = config.get("Spectral rotor", "efficiency", 4.0F).getInt((int) 4.0F);
            minWindStrength2 = config.get("Spectral rotor", "minWindStrength", 25).getInt(25);
            maxWindStrength2 = config.get("Spectral rotor", "maxWindStrength", 110).getInt(110);
            Streak = config.get("Quantum Armor", "Allow Streak", true).getBoolean(true); 
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            config.save();
        }
        ASPLoaded = Loader.isModLoaded("AdvancedSolarPanel");
        DraconicLoaded = Loader.isModLoaded("DraconicEvolution");
        AvaritiaLoaded = Loader.isModLoaded("Avaritia");
        BotaniaLoaded = Loader.isModLoaded("Botania");
       
        if(DraconicLoaded && Draconic == true) {
        	DraconicIntegration.init();
        }
        if(AvaritiaLoaded && Avaritia == true) {
        	AvaritiaIntegration.init();
        }
       
        if(BotaniaLoaded && Botania == true) {
        	BotaniaIntegration.init();
        }//
       
        GameRegistry.registerItem(SuperSolarPanels.advanced_core = new SSPItem().setMaxStackSize(64).setUnlocalizedName("advanced_core").setTextureName("supersolarpanel:advanced_core"), "advanced_core");
        GameRegistry.registerItem(SuperSolarPanels.hybrid_core = new SSPItem().setMaxStackSize(64).setUnlocalizedName("hybrid_core").setTextureName("supersolarpanel:hybrid_core"), "hybrid_core");
        GameRegistry.registerItem(SuperSolarPanels.ultimate_core = new SSPItem().setMaxStackSize(64).setUnlocalizedName("ultimate_core").setTextureName("supersolarpanel:ultimate_core"), "ultimate_core");
     
        
        GameRegistry.registerBlock(SuperSolarPanels.blockadmin = (Block)new Adminsolarpanel(), (Class)ItemAdminSolarPanel.class, "Aminpanel");
      //
        
        
     
		 
		 NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
        //
       
        GameRegistry.registerTileEntity((Class)TileAdminSolarPanel.class, "Admin Solar Panel");
        GameRegistry.registerTileEntity((Class)TilePhotonicSolarPanel.class, "Photonic Solar Panel");
        GameRegistry.registerTileEntity((Class)TileSingularSolarPanel.class, "Singular Solar Panel");
        GameRegistry.registerTileEntity((Class)TileSpectralSolarPanel.class, "Spectral Solar Panel");
        GameRegistry.registerTileEntity((Class)TileNeutronSolarPanel.class, "Neutron Solar Panel");
        GameRegistry.registerTileEntity((Class)TileProtonSolarPanel.class, "Proton Solar Panel");
  
        GameRegistry.registerItem(SuperSolarPanels.spectralSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("spectralSolarHelmet"), 0, 1).setUnlocalizedName("spectralSolarHelmet"), "spectral_solar_helmet");
        GameRegistry.registerItem(SuperSolarPanels.singularSolarHelmet = new ItemSolarPanelHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("singularSolarHelmet"), 0, 2).setUnlocalizedName("singularSolarHelmet"), "singular_solar_helmet");
        BlocksItems.init();
        lapotronCrystal = new ItemBattery(InternalName.itemBatLamaCrystal, SuperSolarPanels.Storagequantumsuit, 8092.0D, 4).setRarity(1);
        nanoSaber = new ItemNanoSaber(InternalName.itemNanoSaber);
        nanoSaber1 = new ItemNanoSaber1(InternalName.itemNanoSaber1);
       quantumHelmet = new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumHelmet, 0);
        quantumBodyarmor = new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumChestplate, 1);
        quantumLeggings = new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumLegs, 2);
        quantumBoots = new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumBoots, 3);
        GameRegistry.registerBlock(SuperSolarPanels.blockSSPSolarPanel = (Block)new BlockSSPSolarPanel(), (Class)ItemSSPSolarPanel.class, "BlockSSPSolarPanel");
        
       
        
    	GameRegistry.registerWorldGenerator(this, 0);
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
       
        
        GameRegistry.registerBlock(iridiumore = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:iridiumore" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("iridiumore"), "iridiumore").setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(wolframore = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:wolframore" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("wolframore"), "wolframore").setHarvestLevel("pickaxe", 2);
        GameRegistry.registerBlock(chromiumore = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:chromiumore" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("chromiumore"), "chromiumore").setHarvestLevel("pickaxe", 2);
        GameRegistry.registerBlock(platiumore = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:platiumore" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("platiumore"), "platiumore").setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(magnesiumore = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:magnesiumore" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("magnesiumore"), "magnesiumore").setHarvestLevel("pickaxe", 2);
        
        GameRegistry.registerBlock(mikhail_ore = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:mikhail_ore" ).setHardness(0.6f).setStepSound(Block.soundTypeStone).setBlockName("mikhail_ore"), "mikhail_ore").setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(spinelore = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:spinelore" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("spinelore"), "spinelore").setHarvestLevel("pickaxe", 3);
        
        GameRegistry.registerBlock(endgold_stone = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:endgold_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("endgold_stone"), "endgold_stone").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(nethergoldrack = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:nethergoldrack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("nethergoldrack"), "nethergoldrack").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(netherironrack = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:netherironrack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("netherironrack"), "netherironrack").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(endiron_stone = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:endiron_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("endiron_stone"), "endiron_stone").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(netherlapisrack = new BlockSSPLapis(Material.rock)
				.setBlockTextureName("supersolarpanel:netherlapisrack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("netherlapisrack"), "netherlapisrack").setHarvestLevel("pickaxe", 3);
      
    
        GameRegistry.registerBlock(endlapis_stone = new BlockSSPLapis(Material.rock)
				.setBlockTextureName("supersolarpanel:endlapis_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("endlapis_stone"), "endlapis_stone").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(netheremeraldrack = new BlockSSPEmerald(Material.rock)
				.setBlockTextureName("supersolarpanel:netheremeraldrack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("netheremeraldrack"), "netheremeraldrack").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(nethercopperrack = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:nethercopperrack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("nethercopperrack"), "nethercopperrack").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(enduran_stone = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:enduran_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("enduran_stone"), "enduran_stone").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(enddiamond_stone = new BlockSSPDiamond(Material.rock)
				.setBlockTextureName("supersolarpanel:enddiamond_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("enddiamond_stone"), "enddiamond_stone").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(netheruranrack = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:netheruranrack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("netheruranrack"), "netheruranrack").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(endtin_stone = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:endtin_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("endtin_stone"), "endtin_stone").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(netherdiamondrack = new BlockSSPDiamond(Material.rock)
				.setBlockTextureName("supersolarpanel:netherdiamondrack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("netherdiamondrack"), "netherdiamondrack").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(endcoal_stone = new BlockSSPCoal(Material.rock)
				.setBlockTextureName("supersolarpanel:endcoal_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("endcoal_stone"), "endcoal_stone").setHarvestLevel("pickaxe", 3);
      
        GameRegistry.registerBlock(nethertinrack = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:nethertinrack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("nethertinrack"), "nethertinrack").setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(nethercoalrack = new BlockSSPCoal(Material.rock)
				.setBlockTextureName("supersolarpanel:nethercoalrack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("nethercoalrack"), "nethercoalrack").setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(endlead_stone = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:endlead_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("endlead_stone"), "endlead_stone").setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(endredstone_stone = new BlockSSPRedstone(Material.rock)
				.setBlockTextureName("supersolarpanel:endredstone_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("endredstone_stone"), "endredstone_stone").setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(netherleadrack = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:netherleadrack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("netherleadrack"), "netherleadrack").setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(netherredstonerack = new BlockSSPRedstone(Material.rock)
				.setBlockTextureName("supersolarpanel:netherredstonerack" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("netherredstonerack"), "netherredstonerack").setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(endemerald_stone = new BlockSSPEmerald(Material.rock)
				.setBlockTextureName("supersolarpanel:endemerald_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("endemerald_stone"), "endemerald_stone").setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(endcopper_stone = new BlockSSP(Material.rock)
				.setBlockTextureName("supersolarpanel:endcopper_stone" ).setHardness(0.6f)
				.setStepSound(Block.soundTypeStone).setBlockName("endcopper_stone"), "endcopper_stone").setHarvestLevel("pickaxe", 3);
       
         //
      
     
        
        //
        GameRegistry.registerItem(SuperSolarPanels.bluecomponent, "bluecomponent");
        GameRegistry.registerItem(SuperSolarPanels.greencomponent, "greencomponent");
        GameRegistry.registerItem(SuperSolarPanels.redcomponent, "redcomponent");
        GameRegistry.registerItem(SuperSolarPanels.QuantumItems = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems").setTextureName("supersolarpanel:QuantumItems"), "QuantumItems");
        GameRegistry.registerItem(SuperSolarPanels.QuantumItems2 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems2").setTextureName("supersolarpanel:QuantumItems2"), "QuantumItems2");
        GameRegistry.registerItem(SuperSolarPanels.QuantumItems3 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems3").setTextureName("supersolarpanel:QuantumItems3"), "QuantumItems3");
        GameRegistry.registerItem(SuperSolarPanels.QuantumItems4 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems4").setTextureName("supersolarpanel:QuantumItems4"), "QuantumItems4");
        GameRegistry.registerItem(SuperSolarPanels.QuantumItems5 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems5").setTextureName("supersolarpanel:QuantumItems5"), "QuantumItems5");
        GameRegistry.registerItem(SuperSolarPanels.nanoBox = new SSPItem().setMaxStackSize(64).setUnlocalizedName("nanobox").setTextureName("supersolarpanel:nanobox"), "nanobox");
        GameRegistry.registerItem(SuperSolarPanels.photoniccore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("photoniccore").setTextureName("supersolarpanel:photoniccore"), "photoniccore");
        GameRegistry.registerItem(SuperSolarPanels.admincore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("admincore").setTextureName("supersolarpanel:admincore"), "admincore");
        GameRegistry.registerItem(wolfram_plate= new SSPItem().setMaxStackSize(64).setUnlocalizedName("wolfram_plate").setTextureName("supersolarpanel:wolfram_plate"), "wolfram_plate");
        GameRegistry.registerItem( SuperSolarPanels.QuantumItems6 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems6").setTextureName("supersolarpanel:QuantumItems6"),"QuantumItems6");
        GameRegistry.registerItem( SuperSolarPanels.QuantumItems7 = new SSPItem().setMaxStackSize(64).setUnlocalizedName("QuantumItems7").setTextureName("supersolarpanel:QuantumItems7"),"QuantumItems7");
        GameRegistry.registerItem( SuperSolarPanels.neutronium = new SSPItem().setMaxStackSize(64).setUnlocalizedName("neutronium").setTextureName("supersolarpanel:neutronium"),"neutronium");
        GameRegistry.registerItem( SuperSolarPanels.neutroniumingot = new SSPItem().setMaxStackSize(64).setUnlocalizedName("neutroniumingot").setTextureName("supersolarpanel:neutroniumingot"),"neutroniumingot");
        GameRegistry.registerItem( SuperSolarPanels.neutroniumcore = new SSPItem().setMaxStackSize(64).setUnlocalizedName("neutroniumcore").setTextureName("supersolarpanel:neutroniumcore"),"neutroniumcore");
        //
        
        //
        
        GameRegistry.registerTileEntity((Class)TileEntityAdvancedSolarPanel.class, "Advanced Solar Panel1");
        GameRegistry.registerTileEntity((Class)TileEntityHybridSolarPanel.class, "Hybrid Solar Panel1");
        GameRegistry.registerTileEntity((Class)TileEntityUltimateSolarPanel.class, "Ultimate Hybrid Solar Panel1");
        GameRegistry.registerTileEntity((Class)TileEntityQuantumSolarPanel.class, "Quantum Solar Panel1");
    //
        GameRegistry.registerBlock(blocksintezator = (Block)new Sintezator(), (Class)ItemSintezator.class, "BlockSintezator");
        
        //
        GameRegistry.registerBlock(blockMolecularTransformer = (Block)new BlockMolecularTransformer(), (Class)ItemMolecularTransformer.class, "BlockMolecularTransformer1");
        GameRegistry.registerTileEntity((Class)com.Denfop.tiles.base.TileEntityMolecularTransformer.class, "Molecular Transformer1");
          GameRegistry.registerItem(advancedSolarHelmet = new ItemAdvancedSolarHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("advancedSolarHelmet"), 0, 1).setUnlocalizedName("advancedSolarHelmet"), "advanced_solar_helmet");
        GameRegistry.registerItem(hybridSolarHelmet = new ItemAdvancedSolarHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("hybridSolarHelmet"), 0, 2).setUnlocalizedName("hybridSolarHelmet"), "hybrid_solar_helmet");
        GameRegistry.registerItem(ultimateSolarHelmet = new ItemAdvancedSolarHelmet(ItemArmor.ArmorMaterial.DIAMOND, SuperSolarPanels.proxy.addArmor("ultimateSolarHelmet"), 0, 3).setUnlocalizedName("ultimateSolarHelmet"), "ultimate_solar_helmet");
        GameRegistry.registerItem(itemSSP = new ItemSSPCrafring(), "ssp_crafting_items");
         itemIrradiantUranium = new ItemStack(itemSSP.setUnlocalizedName("itemIrradiantUranium"), 1, 0);
       itemEnrichedPhotoniyAlloy = new ItemStack(itemSSP.setUnlocalizedName("itemEnrichedSunnariumAlloy"), 1, 1);
        itemIrradiantGlassPane = new ItemStack(itemSSP.setUnlocalizedName("itemIrradiantGlassPlane"), 1, 3);
        itemIridiumIronPlate = new ItemStack(itemSSP.setUnlocalizedName("itemIridiumIronPlate"), 1, 4);
        itemReinforcedIridiumIronPlate = new ItemStack(itemSSP.setUnlocalizedName("itemReinforcedIridiumIronPlate"), 1, 5);
        itemIrradiantReinforcedPlate = new ItemStack(itemSSP.setUnlocalizedName("itemIrradiantReinforcedPlate"), 1, 6);
       
        ingotIridium = new ItemStack(itemSSP.setUnlocalizedName("ingotIridium"), 1, 7);
        itemUranIngot = new ItemStack(itemSSP.setUnlocalizedName("itemUranIngot"), 1, 8);
        itemMTCore = new ItemStack(itemSSP.setUnlocalizedName("itemMTCore"), 1, 9);
        itemQuantumCore = new ItemStack(itemSSP.setUnlocalizedName("itemQuantumCore"), 1, 10);
        itemMolecularTransformer = new ItemStack(blockMolecularTransformer, 1, 0);
        itemUHSP = new ItemStack(blockAdvSolarPanel, 1, 2);
        //
        
          OreDictionary.registerOre("ingotUranium", itemUranIngot);
        OreDictionary.registerOre("ingotIridium", ingotIridium);
        OreDictionary.registerOre("craftingSolarPanelHV", itemUHSP);
        OreDictionary.registerOre("ingotPlatinum", platium_ingot);
        OreDictionary.registerOre("ingotSpinel", spinel_ingot);
        OreDictionary.registerOre("ingotMikhalov", mikhail_ingot);
        OreDictionary.registerOre("ingotChromium", chromium_ingot);
  //      OreDictionary.registerOre("ingotMagnesium", magnesium_ingot);
        OreDictionary.registerOre("ingotTungsten", wolfram_ingot);
        OreDictionary.registerOre("craftingMTCore", itemMTCore);
        OreDictionary.registerOre("craftingMolecularTransformer", itemMolecularTransformer);
        SuperSolarPanels.proxy.registerRenderers();
        SuperSolarPanels.proxy.load();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, (IGuiHandler)SuperSolarPanels.proxy);
        MTRecipeConfig.doDebug();
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
        GameRegistry.registerTileEntity((Class)TileEntityAdminSolarPanel.class, "TileEntityAdminSolarPanel");
        GameRegistry.registerTileEntity((Class)TileEntitySintezator.class, "TileEntitySintezator");
        
        GameRegistry.registerItem(SuperSolarPanels.module1 = new com.Denfop.item.Modules.module1().setMaxStackSize(64).setUnlocalizedName("module1").setTextureName("supersolarpanel:module1"), "module1");
        GameRegistry.registerItem(SuperSolarPanels.module2 = new com.Denfop.item.Modules.module2().setMaxStackSize(64).setUnlocalizedName("module2").setTextureName("supersolarpanel:module2"), "module2");
        GameRegistry.registerItem(SuperSolarPanels.module3 = new com.Denfop.item.Modules.module3().setMaxStackSize(64).setUnlocalizedName("module3").setTextureName("supersolarpanel:module3"), "module3");
        GameRegistry.registerItem(SuperSolarPanels.module4 = new com.Denfop.item.Modules.module4().setMaxStackSize(64).setUnlocalizedName("module4").setTextureName("supersolarpanel:module4"), "module4");
        GameRegistry.registerItem(SuperSolarPanels.module5 = new com.Denfop.item.Modules.module5().setMaxStackSize(64).setUnlocalizedName("module5").setTextureName("supersolarpanel:module5"), "module5");
        
        GameRegistry.registerItem(SuperSolarPanels.module6 = new com.Denfop.item.Modules.module6(), "module6");
        module61  = new ItemStack(module6.setUnlocalizedName("module61"), 1, 0);
        module62 = new ItemStack(module6.setUnlocalizedName("module62"), 1, 1);
        module63= new ItemStack(module6.setUnlocalizedName("module63"), 1, 2);
        module64= new ItemStack(module6.setUnlocalizedName("module64"), 1, 3);
        module65= new ItemStack(module6.setUnlocalizedName("module65"), 1, 4);
        module66= new ItemStack(module6.setUnlocalizedName("module66"), 1, 5);
        module67= new ItemStack(module6.setUnlocalizedName("module67"), 1, 6);
        module68= new ItemStack(module6.setUnlocalizedName("module68"), 1, 7);
        module69= new ItemStack(module6.setUnlocalizedName("module69"), 1, 8);
        module70 = new ItemStack(module6.setUnlocalizedName("module70"), 1, 9);
        //
        GameRegistry.registerItem(SuperSolarPanels.module7 = new com.Denfop.item.Modules.module7(), "module7");
        module71  = new ItemStack(module7.setUnlocalizedName("module71"), 1, 0);
        module72 = new ItemStack(module7.setUnlocalizedName("module72"), 1, 1);
        module73= new ItemStack(module7.setUnlocalizedName("module73"), 1, 2);
        //
        
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
       TileEntityDoubleMacerator.init();
       TileEntityTripleMacerator.init();
       TileEntityDoubleCompressor.init();
       TileEntityTripleCompressor.init();
       TileEntityDoubleMetalFormer.init();
       TileEntityTripleMetalFormer.init();
       TileEntityDoubleExtractor.init();
       ultDDrill = new ultDDrill(Item.ToolMaterial.EMERALD).setUnlocalizedName("advDDrill");
       GameRegistry.registerItem(ultDDrill , "ultDDrill");
       //
       wirelessVajra = new WirelessVajra(ToolMaterial.EMERALD);
		 blockvajracharger = new BlockVajraCharger("vajracharger", Material.rock);
		 armorcharger = new BlockArmorCharger("creativearmorcharger", Material.rock);
		 blockwirelessreciever = new BlockWStorage("wirelessStorage1Tier", Material.rock);
		 blockwirelessreciever2 = new BlockWStorage2("wirelessStorage2Tier", Material.rock);
		 expgen = new BlockExpGen("expGen", Material.rock);
		 module8 = new ItemWirelessModule();
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
		 GameRegistry.registerItem(module8, "WirelessModule");
		 GameRegistry.registerItem(connector3, "WirelessConnector3");
		 GameRegistry.registerBlock(blockvajracharger, ItemBlockVCh.class, "WCh");
		 GameRegistry.registerBlock(armorcharger, ItemBlockArmorCharger.class, "ArCh");
		 GameRegistry.registerTileEntity(TileVajraCharger.class, "TileVajraCharger");
		
		 GameRegistry.registerTileEntity(TileWirelessStorage1Tier.class, "TileStorageWireless1");
		 GameRegistry.registerTileEntity(TileWirelessStorageTier2.class, "TileStorageWireless2");
		 GameRegistry.registerTileEntity(TileXPGenPublic.class, "TileEG");
		 GameRegistry.registerTileEntity(TileVajraChargerElectric.class, "TileVajraCharger1");
		 
		 NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
       //
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
    public static int getSeaLevel(World world) {
        return world.provider.getAverageGroundLevel();
      }
      
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        
        switch(world.provider.dimensionId){
        case -1:
            generateNether(world, random, chunkX*16,chunkZ*16);
        case 0 :
            generateSurface(world, random, chunkX*16,chunkZ*16);
        case 1:
            generateEnd(world, random, chunkX*16,chunkZ*16);
        }
    }
    
    private void generateNether(World world, Random random, int x, int y) {
    	addOreSpawn1(SuperSolarPanels.nethercopperrack, world, random, x, y, 16, 16, 3+random.nextInt(2), 20, 20, 80);
    	addOreSpawn1(SuperSolarPanels.netheruranrack, world, random, x, y, 16, 16, 3+random.nextInt(2), 4, 20, 70);
    	 addOreSpawn1(SuperSolarPanels.nethertinrack, world, random, x, y, 16, 16, 3+random.nextInt(2), 16, 5, 70);
	        addOreSpawn1(SuperSolarPanels.netherleadrack, world, random, x, y, 16, 16, 3+random.nextInt(2), 4, 10, 80);
	        addOreSpawn1(SuperSolarPanels.netheremeraldrack, world, random, x, y, 16, 16, 3+random.nextInt(2), 4, 30, 60);
	        addOreSpawn1(SuperSolarPanels.netherdiamondrack, world, random, x, y, 16, 16, 3+random.nextInt(2), 4, 10, 60);
	      
	        addOreSpawn1(SuperSolarPanels.nethercoalrack, world, random, x, y, 16, 16, 3+random.nextInt(2), 30, 10, 70);
	        addOreSpawn1(SuperSolarPanels.netherredstonerack,  world, random, x, y, 16, 16, 3+random.nextInt(2), 15, 10, 70);
	        addOreSpawn1(SuperSolarPanels.netherlapisrack, world, random, x, y, 16, 16, 3+random.nextInt(2), 12, 10, 70);
	       addOreSpawn1(SuperSolarPanels.netherironrack, world, random, x, y, 16, 16, 3+random.nextInt(2), 16, 10, 70);
	        addOreSpawn1(SuperSolarPanels.nethergoldrack, world, random, x, y,16,16, 10, 10, 0, 128);
	        
    }
   
    private void generateSurface(World world, Random random, int x, int y) {
    	 this.addOreSpawn(SuperSolarPanels.mikhail_ore, world, random, x, y, 16, 16, 3+random.nextInt(2), 3, 10, 60);
	        this.addOreSpawn(SuperSolarPanels.spinelore, world, random, x, y, 16, 16, 3+random.nextInt(2), 1, 20, 30);
	        this.addOreSpawn(SuperSolarPanels.platiumore, world, random, x, y, 16, 16, 3+random.nextInt(2), 2, 0, 20);
	        this.addOreSpawn(SuperSolarPanels.wolframore, world, random, x, y, 16, 16, 3+random.nextInt(2), 8, 10, 60);
	        this.addOreSpawn(SuperSolarPanels.chromiumore, world, random, x, y, 16, 16, 3+random.nextInt(2), 8, 30, 60);
	        this.addOreSpawn(SuperSolarPanels.iridiumore, world, random, x, y, 16, 16, 3+random.nextInt(2), 2, 10, 60);
	        this.addOreSpawn(SuperSolarPanels.magnesiumore, world, random, x, y, 16, 16, 3+random.nextInt(2), 8, 10, 60);

    }
    
    private void generateEnd(World world, Random random, int x, int y) {
      	addOreSpawn2(SuperSolarPanels.endcopper_stone, world, random, x, y, 16, 16, 3+random.nextInt(2), 20, 0, 128);
      	addOreSpawn2(SuperSolarPanels.enduran_stone, world, random, x, y, 16, 16, 3+random.nextInt(2), 4, 0, 128);
      	addOreSpawn2(SuperSolarPanels.endtin_stone, world, random, x, y, 16, 16, 3+random.nextInt(2), 16, 0, 128);
      	addOreSpawn2(SuperSolarPanels.endlead_stone, world, random, x, y, 16, 16, 3+random.nextInt(2), 4, 0, 128);
      	addOreSpawn2(SuperSolarPanels.endemerald_stone, world, random, x, y, 16, 16, 3+random.nextInt(2), 4, 0, 128);
      	addOreSpawn2(SuperSolarPanels.enddiamond_stone, world, random, x, y, 16, 16, 3+random.nextInt(2), 4, 0, 128);
	      
      	addOreSpawn2(SuperSolarPanels.endcoal_stone, world, random, x, y, 16, 16, 3+random.nextInt(2), 30, 0, 128);
	        addOreSpawn2(SuperSolarPanels.endredstone_stone,  world, random, x, y, 16, 16, 3+random.nextInt(2), 15, 0, 128);
	        addOreSpawn2(SuperSolarPanels.endlapis_stone, world, random, x, y, 16, 16, 3+random.nextInt(2), 12, 0, 128);
	        addOreSpawn2(SuperSolarPanels.endiron_stone, world, random, x, y, 16, 16, 6+random.nextInt(2), 10, 0, 128);
	        addOreSpawn2(SuperSolarPanels.endgold_stone, world, random, x, y,16,16, 4, 10, 0, 128);
	
    }

    public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
        for(int i = 0; i < chancesToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
          
            
          
            (new WorldGenMinable(block, 0, maxVeinSize, Blocks.stone)).generate(world, random, posX, posY, posZ);
           
        }
    }

    public void addOreSpawn1(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
        for(int i = 0; i < chancesToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
          
            
            
            (new WorldGenMinable(block, 0, maxVeinSize, Blocks.netherrack)).generate(world, random, posX, posY, posZ);
        }
    }

    public void addOreSpawn2(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
        for(int i = 0; i < chancesToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
          
          
            (new WorldGenMinable(block, 0, maxVeinSize, Blocks.end_stone)).generate(world, random, posX, posY, posZ);
            }
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
		WVPacketHandler.load();
		
		
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
        
       
      } 
    }
  
    @Mod.EventHandler
    public void afterModsLoaded(final FMLPostInitializationEvent event) {
    	BasicRecipe.recipe();
         proxy.registerRenderers();
        if(BotaniaLoaded && Botania == true)
        	BotaniaIntegration.recipe();
        
if(DraconicLoaded && Draconic == true)
        DraconicIntegration.Recipes();
if(AvaritiaLoaded && Avaritia == true)
	AvaritiaIntegration.recipe();

CompressorRecipe.recipe();
CannerRecipe.recipe();
FurnaceRecipes.recipe();  }

      
    
    
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
