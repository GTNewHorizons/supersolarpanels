

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

import com.Denfop.Recipes.AlloySmelterRecipe;
import com.Denfop.Recipes.BasicRecipe;
import com.Denfop.Recipes.CannerRecipe;
import com.Denfop.Recipes.CompressorRecipe;
import com.Denfop.Recipes.FurnaceRecipes;
import com.Denfop.Recipes.MaceratorRecipe;
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
import com.Denfop.block.mechanism.TileEntityAlloySmelter;
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
		public static boolean AvaritiaLoaded;
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
		public static class FluidXP {
			public static Fluid xpJuice = new Fluid("xpjuice.wv");
			
		}
	    public static final String CATEGORY_RECIPES = "recipes settings";
	    public static final String CATEGORY_QGENERATOR = "quantum generator";
	 
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        Config.config(event);
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
        }
        ultDDrill = new ultDDrill(Item.ToolMaterial.EMERALD).setUnlocalizedName("advDDrill");
        wirelessVajra = new WirelessVajra(ToolMaterial.EMERALD);
 		 blockvajracharger = new BlockVajraCharger("vajracharger", Material.rock);
 		 armorcharger = new BlockArmorCharger("creativearmorcharger", Material.rock);
 		 blockwirelessreciever = new BlockWStorage("wirelessStorage1Tier", Material.rock);
 		 blockwirelessreciever2 = new BlockWStorage2("wirelessStorage2Tier", Material.rock);
 		 expgen = new BlockExpGen("expGen", Material.rock);
 		 module8 = new ItemWirelessModule();
 		 goldenwrench = new ItemGoldenWrench();
 		 connector3 = new ItemWirelessConnector3("itemConnector3");
		 NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
      BlocksItems.init();
        lapotronCrystal = new ItemBattery(InternalName.itemBatLamaCrystal, SuperSolarPanels.Storagequantumsuit, 8092.0D, 4).setRarity(1);
        nanoSaber = new ItemNanoSaber(InternalName.itemNanoSaber);
        nanoSaber1 = new ItemNanoSaber1(InternalName.itemNanoSaber1);
       quantumHelmet = new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumHelmet, 0);
        quantumBodyarmor = new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumChestplate, 1);
        quantumLeggings = new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumLegs, 2);
        quantumBoots = new ItemArmorQuantumSuit1(InternalName.itemArmorQuantumBoots, 3);
    	GameRegistry.registerWorldGenerator(this, 0);
        new Blockbitgen(InternalName.Blockbitgen);
        SuperSolarPanels.bluecomponent = new SSPItem().setMaxStackSize(64).setUnlocalizedName("BlueSpectralComponent").setTextureName("supersolarpanel:Blue_Spectral_Component");
        SuperSolarPanels.greencomponent = new SSPItem().setMaxStackSize(64).setUnlocalizedName("GreenSpectralComponent").setTextureName("supersolarpanel:Green_Spectral_Component");
        SuperSolarPanels.redcomponent = new SSPItem().setMaxStackSize(64).setUnlocalizedName("RedSpectralComponent").setTextureName("supersolarpanel:Red_Spectral_Component");
        Register.register();
		 Register.registertiles();
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
        
        RegisterOreDict.oredict();
          SuperSolarPanels.proxy.registerRenderers();
        SuperSolarPanels.proxy.load();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, (IGuiHandler)SuperSolarPanels.proxy);
        MTRecipeConfig.doDebug();
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
         module71  = new ItemStack(module7.setUnlocalizedName("module71"), 1, 0);
        module72 = new ItemStack(module7.setUnlocalizedName("module72"), 1, 1);
        module73= new ItemStack(module7.setUnlocalizedName("module73"), 1, 2);
        
       TileEntityDoubleMacerator.init();
       TileEntityTripleMacerator.init();
       TileEntityDoubleCompressor.init();
       TileEntityTripleCompressor.init();
       TileEntityDoubleMetalFormer.init();
       TileEntityTripleMetalFormer.init();
       TileEntityDoubleExtractor.init();
       TileEntityAlloySmelter.init();
    
		 if (!Loader.isModLoaded("OpenBlocks")) {
		 FluidRegistry.registerFluid(FluidXP.xpJuice);
		 FluidXP.xpJuice.setIcons(TextureHooks.Icons.xpJuiceStill, TextureHooks.Icons.xpJuiceFlowing);
		 }else {
			 
			 FluidXP.xpJuice = FluidRegistry.getFluid("xpjuice");
		 }
		 NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		
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
	        this.addOreSpawn(SuperSolarPanels.platiumore, world, random, x, y, 16, 16, 1+random.nextInt(2), 2, 0, 20);
	        this.addOreSpawn(SuperSolarPanels.wolframore, world, random, x, y, 16, 16, 3+random.nextInt(2), 8, 10, 60);
	        this.addOreSpawn(SuperSolarPanels.chromiumore, world, random, x, y, 16, 16, 3+random.nextInt(2), 8, 30, 60);
	        this.addOreSpawn(SuperSolarPanels.iridiumore, world, random, x, y, 16, 16, 1+random.nextInt(1), 2, 10, 60);
	        this.addOreSpawn(SuperSolarPanels.magnesiumore, world, random, x, y, 16, 16, 3+random.nextInt(2), 8, 10, 60);
	        this.addOreSpawn(SuperSolarPanels.nicelore, world, random, x, y, 16, 16, 2+random.nextInt(1), 8, 10, 70);
	        this.addOreSpawn(SuperSolarPanels.toriyore, world, random, x, y, 16, 16, 2+random.nextInt(1), 8, 10, 70);
	        this.addOreSpawn(SuperSolarPanels.magnetitore, world, random, x, y, 16, 16, 2+random.nextInt(1), 10, 10, 70);

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
        proxy.initRecipes();
if(DraconicLoaded && Draconic == true)
        DraconicIntegration.Recipes();
if(AvaritiaLoaded && Avaritia == true)
	AvaritiaIntegration.recipe();
AlloySmelterRecipe.recipe();
CompressorRecipe.recipe();
CannerRecipe.recipe();
FurnaceRecipes.recipe();  
MaceratorRecipe.recipe();
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
