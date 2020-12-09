package com.denfop.ssp;

import com.denfop.ssp.fluid.neutron.BlockRegister;
import com.denfop.ssp.fluid.neutron.FluidRegister;
import com.denfop.ssp.gui.ProgressBars;
import com.denfop.ssp.integration.avaritia.AvaritiaMod;
import com.denfop.ssp.integration.botania.BotaniaItems;
import com.denfop.ssp.integration.botania.BotaniaMain;
import com.denfop.ssp.integration.botania.BotaniaRecipes;
import com.denfop.ssp.integration.thaumcraft.ThaumcraftMain;
import com.denfop.ssp.integration.wirelesssolarpanel.SWSP_Recipes;
import com.denfop.ssp.items.SSP_Items;
import com.denfop.ssp.items.resource.CraftingThings;
import com.denfop.ssp.keyboard.SSPKeys;
import com.denfop.ssp.proxy.CommonProxy;
import com.denfop.ssp.tiles.SSPBlock;
import com.denfop.ssp.tiles.TileEntityMolecularAssembler;
import ic2.api.event.TeBlockFinalCallEvent;
import ic2.core.block.BlockTileEntity;
import ic2.core.block.TeBlockRegistry;
import ic2.core.util.ReflectionUtil;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Logger;

import java.util.Map;

@Mod.EventBusSubscriber
@Mod(modid = SuperSolarPanels.MOD_ID, name = SuperSolarPanels.MOD_NAME, dependencies = "required-after:ic2@[2.8.170,);", version = "1.3.0", acceptedMinecraftVersions = "[1.12,1.12.2]")
public final class SuperSolarPanels {

    public static final String MOD_ID = "super_solar_panels";
    public static final String MOD_NAME = "Super Solar Panels";
    public static final CreativeTabs SSPtab = new SSPSourceTab("SSPtab");
    private static final String Urane = null;
    public static boolean seasonal = false;
    public static Logger log;

    public static boolean avaritiaLoaded = false;
    public static boolean botaniaLoaded = false;
    public static boolean wirelesLoaded = false;
    public static boolean thaumcraftLoaded = false;
    public static BlockTileEntity machines;
    @SidedProxy(clientSide = "com.denfop.ssp.proxy.ClientProxy", serverSide = "com.denfop.ssp.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static SuperSolarPanels instance;
    public static BlockTileEntity machines1;
    public static BlockTileEntity machines2;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @SubscribeEvent
    public static void register(final TeBlockFinalCallEvent event) {
        botaniaLoaded = Loader.isModLoaded("botania");
        avaritiaLoaded = Loader.isModLoaded("avaritia");
        TeBlockRegistry.addAll(com.denfop.ssp.tiles.SSPBlock.class, SSPBlock.IDENTITY);
        TeBlockRegistry.setDefaultMaterial(SSPBlock.IDENTITY, Material.ROCK);
        if (SuperSolarPanels.botaniaLoaded) {
            TeBlockRegistry.addAll(com.denfop.ssp.integration.botania.BotaniaMain.class, BotaniaMain.IDENTITY1);
            TeBlockRegistry.setDefaultMaterial(BotaniaMain.IDENTITY1, Material.ROCK);

        }
        if (avaritiaLoaded) {
            TeBlockRegistry.addAll(com.denfop.ssp.integration.avaritia.AvaritiaMod.class, AvaritiaMod.IDENTITY2);
            TeBlockRegistry.setDefaultMaterial(AvaritiaMod.IDENTITY2, Material.ROCK);
        }

    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void doColourThings(final ColorHandlerEvent.Item event) {
        final ItemColors colours = event.getItemColors();
        final IItemColor armourColouring = (IItemColor) ((Map) ReflectionUtil.getFieldValue(ReflectionUtil.getField(ItemColors.class, Map.class), colours)).get(Items.LEATHER_BOOTS.delegate);
        colours.registerItemColorHandler(armourColouring, SSP_Items.Spectral_SOLAR_HELMET.getInstance());
        colours.registerItemColorHandler(armourColouring, SSP_Items.Singular_SOLAR_HELMET.getInstance());
        colours.registerItemColorHandler(armourColouring, SSP_Items.HYBRID_SOLAR_HELMET.getInstance(), SSP_Items.ULTIMATE_HYBRID_SOLAR_HELMET.getInstance());

    }

    public static ResourceLocation getIdentifier(final String name) {
        return new ResourceLocation("super_solar_panels", name);
    }

    @Mod.EventHandler
    public void load(final FMLPreInitializationEvent event) {
        botaniaLoaded = Loader.isModLoaded("botania");
        avaritiaLoaded = Loader.isModLoaded("avaritia");
        thaumcraftLoaded = Loader.isModLoaded("thaumcraft");
        if (botaniaLoaded) {
            SuperSolarPanels.machines1 = TeBlockRegistry.get(BotaniaMain.IDENTITY1);

            BotaniaItems.buildItems(event.getSide());
        }
        if (thaumcraftLoaded) {
            ThaumcraftMain.init();
        }
        if (avaritiaLoaded) {
            SuperSolarPanels.machines2 = TeBlockRegistry.get(AvaritiaMod.IDENTITY2);
            AvaritiaMod.buildItems(event.getSide());
        }
        proxy.preInit(event);
        SuperSolarPanels.log = event.getModLog();
        Configs.loadConfig(event.getSuggestedConfigurationFile(), event.getSide().isClient());
        SuperSolarPanels.machines = TeBlockRegistry.get(SSPBlock.IDENTITY);
        if (event.getSide().isClient())
            setupRenderingGuf();
        SSP_Items.buildItems(event.getSide());
        FluidRegister.register();
        BlockRegister.register();
        SSPKeys.addFlyKey();
        SPPRecipes.addMolecularTransformerRecipes();
        GameRegistry.registerWorldGenerator(new SSPWorldDecorator(), 0);
        OreDictionary.registerOre("enderquantumcomponent", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.enderquantumcomponent));
        OreDictionary.registerOre("solarsplitter", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.solarsplitter));
        OreDictionary.registerOre("bluecomponent", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.bluecomponent));
        OreDictionary.registerOre("greencomponent", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.greencomponent));
        OreDictionary.registerOre("redcomponent", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.redcomponent));
        OreDictionary.registerOre("singularcore", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.singularcore));
        OreDictionary.registerOre("photoniy", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.photoniy));
        OreDictionary.registerOre("photoniy_ingot", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.photoniy_ingot));
        OreDictionary.registerOre("spectralcore", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.spectralcore));

        OreDictionary.registerOre("ingotUranium", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.URANIUM_INGOT));
        OreDictionary.registerOre("ingotIridium", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.IRIDIUM_INGOT));
//OreDictionary.registerOre("craftingSolarPanelHV", ModernSolarPanels.machines.getItemStack((ITeBlock)TEs.ultimate_solar_panel));
        OreDictionary.registerOre("craftingSunnariumPart", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.SUNNARIUM_PART));
        OreDictionary.registerOre("craftingSunnarium", SSP_Items.CRAFTING.getItemStack(CraftingThings.CraftingTypes.SUNNARIUM));

    }

    @SideOnly(Side.CLIENT)
    private static void setupRenderingGuf() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMolecularAssembler.class, new PrettyMolecularTransformerTESR());
        ForgeHooksClient.registerTESRItemStack(machines.getItem(), SSPBlock.molecular_transformer.getId(), SSPBlock.molecular_transformer.getTeClass());

    }

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        botaniaLoaded = Loader.isModLoaded("botania");
        proxy.init(event);
        SSPBlock.buildDummies();
        SPPRecipes.addCraftingRecipes();
        ProgressBars.addStyles();
        if (botaniaLoaded) {
            BotaniaRecipes.addCraftingRecipes();
            BotaniaMain.buildDummies();

        }
        avaritiaLoaded = Loader.isModLoaded("avaritia");
        wirelesLoaded = Loader.isModLoaded("wirelesstools");
        if (wirelesLoaded) {
            SWSP_Recipes.addCraftingRecipes();


        }
        if (avaritiaLoaded) {
            AvaritiaMod.buildDummies();
        }
        TileEntityMolecularAssembler.MolecularOutput.registerNetwork();
    }

    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }


}