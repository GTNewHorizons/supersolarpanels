package com.Denfop.proxy;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Denfop.Config;
import com.Denfop.IUItem;
import com.Denfop.IUCore;
import com.Denfop.Recipes.BasicRecipe;
import com.Denfop.Recipes.CannerRecipe;
import com.Denfop.Recipes.CentrifugeRecipe;
import com.Denfop.Recipes.CompressorRecipe;
import com.Denfop.Recipes.FurnaceRecipes;
import com.Denfop.Recipes.MaceratorRecipe;
import com.Denfop.Register.Register;
import com.Denfop.Register.RegisterOreDict;
import com.Denfop.World.GenOre;
import com.Denfop.block.Base.BlocksItems;
import com.Denfop.container.*;
import com.Denfop.events.EventDarkQuantumSuitEffect;
import com.Denfop.events.SSPEventHandler;
import com.Denfop.events.DE.SSPDEEventHandler;
import com.Denfop.events.DE_MF.SSPDEMFEventHandler;
import com.Denfop.events.DE_MF_EP.SSPMFDEEventHandler;
import com.Denfop.events.EP.SSPEPEventHandler;
import com.Denfop.events.EP_DE.SSPDEEPEventHandler;
import com.Denfop.events.MF.SSPMFEventHandler;
import com.Denfop.events.MF_EP.SSPMPMFEventHandler;
import com.Denfop.gui.*;
import com.Denfop.handler.EntityStreak;
import com.Denfop.integration.Avaritia.AvaritiaIntegration;
import com.Denfop.integration.Botania.BotaniaIntegration;
import com.Denfop.integration.DE.DraconicIntegration;
import com.Denfop.integration.DE.RenderArmor;
import com.Denfop.integration.DE.RenderBowModel;
import com.Denfop.integration.DE.RenderTool;
import com.Denfop.integration.crafttweaker.CTCore;
import com.Denfop.render.EntityRendererStreak;
import com.Denfop.render.Cable.RenderBlock;
import com.Denfop.render.Cable.RenderBlockCable;
import com.Denfop.render.Cable.RenderBlockWall;
import com.Denfop.render.Sintezator.TileEntitySintezatorItemRender;
import com.Denfop.render.Sintezator.TileEntitySintezatorRender;
import com.Denfop.render.tile.TileEntityPanelItemRender;
import com.Denfop.render.tile.TileEntityPanelRender;
import com.Denfop.tiles.Mechanism.*;
import com.Denfop.tiles.NeutroniumGenerator.TileneutronGenerator;
import com.Denfop.tiles.Sintezator.TileEntitySintezator;
import com.Denfop.tiles.base.TileEntityAdminSolarPanel;
import com.Denfop.tiles.base.TileEntityChargepadBlock;
import com.Denfop.tiles.base.TileEntityElectricBlock;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.Denfop.tiles.base.TileEntityMultiMachine;
import com.Denfop.tiles.base.TileEntityMultiMachine1;
import com.Denfop.tiles.base.TileEntityMultiMatter;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.base.TileSintezator;
import com.Denfop.tiles.overtimepanel.TileAdminSolarPanel;
import com.Denfop.tiles.wiring.Chargepad.TileEntityChargepadMFES;
import com.Denfop.tiles.wiring.Storage.TileEntityElectricMFE;
import com.Denfop.tiles.wiring.Storage.TileEntityElectricMFSU;
import com.Denfop.utils.Check;
import com.Denfop.utils.graviSuite;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.network.IGuiHandler;
import ic2.core.ContainerBase;
import ic2.core.Ic2Items;
import ic2.core.item.tool.ItemToolWrench;
import modtweaker2.utils.TweakerPlugin;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy implements IGuiHandler {

	Map<String, RenderBlock> renders;
	public static int adminpanel;

	public boolean isClient() {

		return true;
	}

	public void registerTabs(CreativeTabs tab, final ItemStack icon) {

	}

	public RenderBlock getRender(String name) {
		return this.renders.get(name);
	}

	public static Logger logger = LogManager.getLogger("industrialupgrade");
	public static int[][] sideAndFacingToSpriteOffset;

	public void check() {
		Check.check();
	}

	@Override
	public void load() {

		try {
			sideAndFacingToSpriteOffset = (int[][]) Class.forName("ic2.core.block.BlockMultiID")
					.getField("sideAndFacingToSpriteOffset").get(null);
		} catch (Exception e) {
			sideAndFacingToSpriteOffset = new int[][] { { 3, 2, 0, 0, 0, 0 }, { 2, 3, 1, 1, 1, 1 },
					{ 1, 1, 3, 2, 5, 4 }, { 0, 0, 2, 3, 4, 5 }, { 4, 5, 4, 5, 3, 2 }, { 5, 4, 5, 4, 2, 3 } };
		}
	}

	private void addBlockRenderer(String name, RenderBlock renderer) {
		RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler) renderer);
		this.renders.put(name, renderer);
	}

	public void integration() {
		Config.DraconicLoaded = Loader.isModLoaded("DraconicEvolution");
		Config.AvaritiaLoaded = Loader.isModLoaded("Avaritia");
		Config.BotaniaLoaded = Loader.isModLoaded("Botania");
		Config.EnchantingPlus = Loader.isModLoaded("eplus");
		Config.MineFactory = Loader.isModLoaded("MineFactoryReloaded");
		if (Loader.isModLoaded("modtweaker2")) {
			TweakerPlugin.register("supersolarpanel", CTCore.class);

		}
		if (Config.DraconicLoaded && Config.Draconic) {
			DraconicIntegration.init();
		}
		if (Config.AvaritiaLoaded && Config.Avaritia) {
			AvaritiaIntegration.init();
		}

		if (Config.BotaniaLoaded && Config.Botania) {
			BotaniaIntegration.init();
		}
	}

	public void initCore() {

		TileEntityAlloySmelter.init();
		TileEntityMolecularTransformer.init();
		TileEntityGenerationMicrochip.init();
		TileEntityGenerationStone.init();

	}

	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityStreak.class, (Render) new EntityRendererStreak());
		//

		//

		this.renders = new HashMap<String, RenderBlock>();
		addBlockRenderer("cable", (RenderBlock) new RenderBlockCable());
		addBlockRenderer("wall", (RenderBlock) new RenderBlockWall());
		if (Config.DraconicLoaded)
			DraconicIntegration.render();

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAdminSolarPanel.class, new TileEntityPanelRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(IUItem.blockadmin),
				new TileEntityPanelItemRender());
		//
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySintezator.class, new TileEntitySintezatorRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(IUItem.blocksintezator),
				new TileEntitySintezatorItemRender());
		
	}

	public void registerRecipe() {

		if (Config.BotaniaLoaded && Config.Botania)
			BotaniaIntegration.recipe();
		BasicRecipe.recipe();
		if (Config.DraconicLoaded && Config.Draconic)
			DraconicIntegration.Recipes();
		if (Config.AvaritiaLoaded && Config.Avaritia)
			AvaritiaIntegration.recipe();

		CompressorRecipe.recipe();
		CannerRecipe.recipe();
		FurnaceRecipes.recipe();
		CentrifugeRecipe.init();
		MaceratorRecipe.recipe();

	}

	public void registerEvents() {
		MinecraftForge.EVENT_BUS.register(new EventDarkQuantumSuitEffect());
		if (Config.Streak == true) {
			FMLCommonHandler.instance().bus().register(new EventDarkQuantumSuitEffect());
		}
		

		if (Config.DraconicLoaded && Config.EnchantingPlus && Config.MineFactory) {
			MinecraftForge.EVENT_BUS.register(new SSPMFDEEventHandler());

		} else if (Config.DraconicLoaded && Config.EnchantingPlus) {
			MinecraftForge.EVENT_BUS.register(new SSPDEEPEventHandler());
		} else if (Config.DraconicLoaded && Config.MineFactory) {
			MinecraftForge.EVENT_BUS.register(new SSPDEMFEventHandler());
		} else if (Config.EnchantingPlus && Config.MineFactory) {
			MinecraftForge.EVENT_BUS.register(new SSPMPMFEventHandler());
		} else {
			if (Config.DraconicLoaded) {
				MinecraftForge.EVENT_BUS.register(new SSPDEEventHandler());
			}

			if (Config.EnchantingPlus) {
				MinecraftForge.EVENT_BUS.register(new SSPEPEventHandler());
			}
			if (Config.MineFactory) {
				MinecraftForge.EVENT_BUS.register(new SSPMFEventHandler());
			}
		}
		MinecraftForge.EVENT_BUS.register(new SSPEventHandler());
	}

	@Override
	public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int X,
			final int Y, final int Z) {
		final TileEntity te = world.getTileEntity(X, Y, Z);

		if (te == null) {
			return null;
		}
		
		if(!Loader.isModLoaded("GraviSuite")) {
		if (!(graviSuite.gettrue1(player))) {
			if (te instanceof TileEntitySolarPanel) {

				return new GuiSolarPanels(new ContainerSolarPanels(player, (TileEntitySolarPanel) te));
			}
			if (te instanceof TileSintezator) {
				return new GUISintezator(new ContainerSinSolarPanel(player, (TileSintezator) te));
			}

			if (te instanceof TileEntityMolecularTransformer) {
				return new GuiMolecularTransformer(new ContainerBaseMolecular(player, (TileEntityMolecularTransformer) te));
			}
			if (te instanceof TileEntityMultiMachine) {
				return ((TileEntityMultiMachine) te).getGui(player, false);
			}

			if (player.getHeldItem() != Ic2Items.electricWrench) {
				if (te instanceof TileEntityMultiMachine1) {
					return ((TileEntityMultiMachine1) te).getGui(player, false);
				}
			}
			if (player.getHeldItem() != Ic2Items.electricWrench) {
				if (te instanceof TileEntityMultiMatter) {
					return ((TileEntityMultiMatter) te).getGui(player, false);
				}
			}
			if (te instanceof TileEntityAlloySmelter) {
				return new GuiAlloySmelter(new ContainerStandardMachine(player, (TileEntityAlloySmelter) te));
			}
			if (te instanceof TileEntityElectricMFE) {

				return new GuiElectricBlock(new ContainerElectricBlock(player, (TileEntityElectricMFE) te));
			}

			if (te instanceof TileEntityElectricBlock) {

				return new GuiElectricBlock(new ContainerElectricBlock(player, (TileEntityElectricBlock) te));
			}
			if (te instanceof TileneutronGenerator) {

				return new GuiNeutronGenerator(new ContainerNeutrniumGenerator(player, (TileneutronGenerator) te));
			}
			if (te instanceof TileEntityGenerationMicrochip) {
				return new GuiGenerationMicrochip(
						new ContainerBaseGenerationChipMachine(player, (TileEntityGenerationMicrochip) te));
			}
			if (te instanceof TileEntityChargepadBlock) {

				return new GuiChargepadBlock(new ContainerChargepadBlock(player, (TileEntityChargepadBlock) te));
			}
			if (te instanceof TileEntityGenerationStone)
				return new GuiGenStone(new ContainerGenStone(player, (TileEntityGenerationStone) te));
			if (te instanceof TileEntityQuantumQuarry)
				return new GuiQuantumQuarry(new ContainerQuantumQuarry(player, (TileEntityQuantumQuarry) te));
		}
		}else {
			if (!(graviSuite.gettrue(player)) ) {
				if (te instanceof TileEntitySolarPanel) {

					return new GuiSolarPanels(new ContainerSolarPanels(player, (TileEntitySolarPanel) te));
				}
				if (te instanceof TileSintezator) {
					return new GUISintezator(new ContainerSinSolarPanel(player, (TileSintezator) te));
				}

				if (te instanceof TileEntityMolecularTransformer) {
					return new GuiMolecularTransformer(new ContainerBaseMolecular(player, (TileEntityMolecularTransformer) te));
				}
				if (te instanceof TileEntityMultiMachine) {
					return ((TileEntityMultiMachine) te).getGui(player, false);
				}

				if (player.getHeldItem() != Ic2Items.electricWrench) {
					if (te instanceof TileEntityMultiMachine1) {
						return ((TileEntityMultiMachine1) te).getGui(player, false);
					}
				}
				if (player.getHeldItem() != Ic2Items.electricWrench) {
					if (te instanceof TileEntityMultiMatter) {
						return ((TileEntityMultiMatter) te).getGui(player, false);
					}
				}
				if (te instanceof TileEntityAlloySmelter) {
					return new GuiAlloySmelter(new ContainerStandardMachine(player, (TileEntityAlloySmelter) te));
				}
				if (te instanceof TileEntityElectricMFE) {

					return new GuiElectricBlock(new ContainerElectricBlock(player, (TileEntityElectricMFE) te));
				}

				if (te instanceof TileEntityElectricBlock) {

					return new GuiElectricBlock(new ContainerElectricBlock(player, (TileEntityElectricBlock) te));
				}
				if (te instanceof TileneutronGenerator) {

					return new GuiNeutronGenerator(new ContainerNeutrniumGenerator(player, (TileneutronGenerator) te));
				}
				if (te instanceof TileEntityGenerationMicrochip) {
					return new GuiGenerationMicrochip(
							new ContainerBaseGenerationChipMachine(player, (TileEntityGenerationMicrochip) te));
				}
				if (te instanceof TileEntityChargepadBlock) {

					return new GuiChargepadBlock(new ContainerChargepadBlock(player, (TileEntityChargepadBlock) te));
				}
				if (te instanceof TileEntityGenerationStone)
					return new GuiGenStone(new ContainerGenStone(player, (TileEntityGenerationStone) te));
				if (te instanceof TileEntityQuantumQuarry)
					return new GuiQuantumQuarry(new ContainerQuantumQuarry(player, (TileEntityQuantumQuarry) te));
			
		}}
		return null;
	}

	public void preint() {
		if (Loader.isModLoaded("AdvancedSolarPanel"))
			throwInitException(new LoaderException(
					"SuperSolarPanels is incompatible with Advanced Solar Panels.Please delete Advanced solar Panels"));
		BlocksItems.init();
		integration();
		initCore();
		GenOre.init();
		Register.register();
		Register.registertiles();
		BlocksItems.registermetadata();
		RegisterOreDict.oredict();
		registerRenderers();
		load();

	}

	@Override
	public int addArmor(final String armorName) {
		return RenderingRegistry.addNewArmourRendererPrefix(armorName);
	}

	public int getRenderId(String name) {
		return ((RenderBlock) this.renders.get(name)).getRenderId();
	}
}
