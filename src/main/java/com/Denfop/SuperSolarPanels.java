

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
import com.Denfop.item.base.SSPItemBase;
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
	public static final CreativeTabSSP tabssp;
    @Mod.Instance("supersolarpanel")
    public static SuperSolarPanels instance;
		 @SidedProxy(clientSide = "com.Denfop.proxy.ClientProxy", serverSide = "com.Denfop.proxy.CommonProxy")
		  public static CommonProxy proxy;
		public static CreativeTabSSP1 tabssp1;
		public static CreativeTabSSP2 tabssp2;
		public static CreativeTabSSP3 tabssp3;
		public static CreativeTabSSP4 tabssp4;
		public static Random random;
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        Config.config(event);
        if (Loader.isModLoaded("AdvancedSolarPanel"))
            proxy.throwInitException(new LoaderException("SuperSolarPanels is incompatible with Advanced Solar Panels.Please delete Advanced solar Panels")); 
      proxy.integration();
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
    public void load(final FMLInitializationEvent event) {}
    public static void initENet() {EnergyNet.instance = (IEnergyNet)EnergyNetGlobal.initialize();  }

    public static int getSeaLevel(World world) {return world.provider.getAverageGroundLevel(); }
      

    @EventHandler
    public void onMissingMappings(FMLMissingMappingsEvent event) {
      BlocksItems.onMissingMappings(event);
    }
    public static void addLog(final String logLine) {
        System.out.println("[SuperSolarPanel] " + logLine);
    }
  
    @Mod.EventHandler
    public void Init(final FMLInitializationEvent event) { proxy.registerEvents(); }
   
    @Mod.EventHandler
    public void afterModsLoaded(final FMLPostInitializationEvent event) {
         proxy.registerRenderers();
         proxy.registerRecipe();
    }static {
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
    
}
