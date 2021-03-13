

package com.Denfop;

import java.util.Random;
import com.Denfop.Register.*;
import com.Denfop.World.GenOre;
import com.Denfop.block.Base.BlocksItems;
import com.Denfop.proxy.CommonProxy;
import com.Denfop.tab.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import ic2.api.energy.*;
import ic2.core.energy.EnergyNetGlobal;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.MOD_VERSION, dependencies = Constants.DEPENDENCES,acceptedMinecraftVersions = Constants.acceptedMinecraftVersions,certificateFingerprint = "Denfop-certificate")
public class IUCore
{
	public static final CreativeTabSSP tabssp;
    @Mod.Instance("industrialupgrade")
    public static IUCore instance;
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
      proxy.check();
BlocksItems.init();
		 NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
       	GenOre.init();
        Register.register();
    
		 Register.registertiles();
		 BlocksItems.registermetadata();
        RegisterOreDict.oredict();
          IUCore.proxy.registerRenderers();
        IUCore.proxy.load();
      
        proxy.initCore();
        
    }
  
    public static ItemStack setItemsSize(final ItemStack itemStack, final int newSize) {
        final ItemStack newStack = itemStack.copy();
        newStack.stackSize = newSize;
        return newStack;
    }
    @Mod.EventHandler
    public void load(final FMLInitializationEvent event) {
    	if(Loader.isModLoaded("Waila"))
    	FMLInterModComms.sendMessage("Waila", "register", "com.Denfop.integration.Waila.WailaHandler.callbackRegister");
    	}
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
        IUCore.instance = new IUCore();
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
