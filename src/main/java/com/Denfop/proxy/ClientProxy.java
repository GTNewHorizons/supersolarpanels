package com.Denfop.proxy;


import java.util.HashMap;
import java.util.Map;

import com.Denfop.SuperSolarPanels;
import com.Denfop.TileEntityAdminSolarPanel;
import com.Denfop.TileEntitySintezator;
import com.Denfop.api.MTAPI;
import com.Denfop.events.EventDarkQuantumSuitEffect;
import com.Denfop.gui.GuiAdvSolarPanel;
import com.Denfop.gui.GuiMolecularTransformer;
import com.Denfop.handler.EntityStreak;
import com.Denfop.integration.DE.DraconicIntegration;
import com.Denfop.integration.DE.RenderArmor;
import com.Denfop.integration.DE.RenderBowModel;
import com.Denfop.integration.DE.RenderTool;
import com.Denfop.render.EntityRendererStreak;
import com.Denfop.render.block.BlockMolecularTransformerRenderer;
import com.Denfop.render.tile.TileEntityPanelItemRender;
import com.Denfop.render.tile.TileEntityPanelRender;
import com.Denfop.render.tile.TileMolecularTransformerRenderer;
import com.Denfop.tiles.base.GUISintezator;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.base.TileSintezator;
import com.Denfop.tiles.overtimepanel.TileAdminSolarPanel;
import com.Denfop.utils.MTRecipeManager;
import com.brandon3055.draconicevolution.client.render.IRenderTweak;
import com.brandon3055.draconicevolution.client.render.item.RenderBow;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import ic2.core.ContainerBase;
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
import ru.wirelesstools.gui.GuiExpGen;

public class ClientProxy extends CommonProxy  implements IGuiHandler {
	
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
  
  public static int[][] sideAndFacingToSpriteOffset;
  
  @Override
  public void load() {
	
	  try {
    	  ClientProxy.sideAndFacingToSpriteOffset = (int[][])Class.forName("ic2.core.block.BlockMultiID").getField("sideAndFacingToSpriteOffset").get(null);
      }
      catch (Exception e) {
    	  ClientProxy.sideAndFacingToSpriteOffset = new int[][] { { 3, 2, 0, 0, 0, 0 }, { 2, 3, 1, 1, 1, 1 }, { 1, 1, 3, 2, 5, 4 }, { 0, 0, 2, 3, 4, 5 }, { 4, 5, 4, 5, 3, 2 }, { 5, 4, 5, 4, 2, 3 } };
      }
  }     
  private void addBlockRenderer(String name, RenderBlock renderer) {
	    RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)renderer);
	    this.renders.put(name, renderer);
	  }  
 
  
  public void registerRenderers() {
    RenderingRegistry.registerEntityRenderingHandler(EntityStreak.class, (Render)new EntityRendererStreak());
    SuperSolarPanels.blockMolecularTransformerRenderID = RenderingRegistry.getNextAvailableRenderId();
    RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new BlockMolecularTransformerRenderer());
    ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityMolecularTransformer.class, (TileEntitySpecialRenderer)new TileMolecularTransformerRenderer());
    this.renders = new HashMap<String, RenderBlock>();
	  addBlockRenderer("cable", (RenderBlock)new RenderBlockCable());
	  addBlockRenderer("wall", (RenderBlock)new RenderBlockWall());
	  if(SuperSolarPanels.DraconicLoaded) {
		  MinecraftForgeClient.registerItemRenderer(DraconicIntegration.ChaosBow, (IItemRenderer)new RenderBowModel(true));
		  MinecraftForgeClient.registerItemRenderer(DraconicIntegration.ChaosSword, (IItemRenderer)new RenderTool("models/tools/DraconicSword.obj", "textures/models/tools/DraconicSword.png", (IRenderTweak)DraconicIntegration.ChaosSword));
		  MinecraftForgeClient.registerItemRenderer(DraconicIntegration.ChaosPickaxe, (IItemRenderer)new RenderTool("models/tools/DraconicPickaxe.obj", "textures/models/tools/DraconicPickaxe.png", (IRenderTweak)DraconicIntegration.ChaosPickaxe));
	      MinecraftForgeClient.registerItemRenderer(DraconicIntegration.ChaosAxe, (IItemRenderer)new RenderTool("models/tools/DraconicLumberAxe.obj", "textures/models/tools/DraconicLumberAxe.png", (IRenderTweak)DraconicIntegration.ChaosAxe));
	      MinecraftForgeClient.registerItemRenderer(DraconicIntegration.ChaosShovel, (IItemRenderer)new RenderTool("models/tools/DraconicShovel.obj", "textures/models/tools/DraconicShovel.png", (IRenderTweak)DraconicIntegration.ChaosShovel));
	      MinecraftForgeClient.registerItemRenderer(DraconicIntegration.ChaosDestructionStaff, (IItemRenderer)new RenderTool("models/tools/DraconicStaffOfPower.obj", "textures/models/tools/DraconicStaffOfPower.png", (IRenderTweak)DraconicIntegration.ChaosDestructionStaff));
	      MinecraftForgeClient.registerItemRenderer(DraconicIntegration.ChaosHoe, (IItemRenderer)new RenderTool("models/tools/DraconicHoe.obj", "textures/models/tools/DraconicHoe.png", (IRenderTweak)DraconicIntegration.ChaosHoe));
	    
	      MinecraftForgeClient.registerItemRenderer((Item)DraconicIntegration.ChaosHelm, (IItemRenderer)new RenderArmor(DraconicIntegration.ChaosHelm));
	      MinecraftForgeClient.registerItemRenderer((Item)DraconicIntegration.ChaosChest, (IItemRenderer)new RenderArmor(DraconicIntegration.ChaosChest));
	      MinecraftForgeClient.registerItemRenderer((Item)DraconicIntegration.ChaosLeggs, (IItemRenderer)new RenderArmor(DraconicIntegration.ChaosLeggs));
	      MinecraftForgeClient.registerItemRenderer((Item)DraconicIntegration.ChaosBoots, (IItemRenderer)new RenderArmor(DraconicIntegration.ChaosBoots));
	    } 
	  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAdminSolarPanel.class, new TileEntityPanelRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(SuperSolarPanels.blockadmin),
				new TileEntityPanelItemRender());
		//
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySintezator.class, new TileEntitySintezatorRender());
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(SuperSolarPanels.blocksintezator),
					new TileEntitySintezatorItemRender());
	 	
  }
  
  public void registerEvents() {
    MinecraftForge.EVENT_BUS.register(new EventDarkQuantumSuitEffect());
    if(SuperSolarPanels.Streak == true) {
    FMLCommonHandler.instance().bus().register(new EventDarkQuantumSuitEffect());}
    
  }
  @Override
  public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int X, final int Y, final int Z) {
      final TileEntity te = world.getTileEntity(X, Y, Z);
     
      if (te == null) {
          return null;
      }
      if (te instanceof TileEntitySolarPanel) {
          return new GuiAdvSolarPanel(player.inventory, (TileEntitySolarPanel)te);
      }
      if (te instanceof TileSintezator) {
          return new GUISintezator(player.inventory, (TileSintezator)te);
      }
      
      if (te instanceof TileEntitySolarPanel) {
          return new GuiAdvSolarPanel(player.inventory, (TileEntitySolarPanel)te);
      }
      if (te instanceof TileEntityMolecularTransformer) {
          return new GuiMolecularTransformer(player.inventory, (TileEntityMolecularTransformer)te);
      }
     
		
		
		
      return null;
  }
  
  @Override
  public void initRecipes() {
      MTAPI.manager = MTRecipeManager.instance;
      MTRecipeManager.instance.initRecipes();
  }
  
  @Override
  public int addArmor(final String armorName) {
      return RenderingRegistry.addNewArmourRendererPrefix(armorName);
  }
  public int getRenderId(String name) {
	    return ((RenderBlock)this.renders.get(name)).getRenderId();
	  }
}
