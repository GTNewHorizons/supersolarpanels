package com.Denfop.proxy;


import com.Denfop.SuperSolarPanels;
import com.Denfop.api.MTAPI;
import com.Denfop.events.EventDarkQuantumSuitEffect;
import com.Denfop.gui.GuiAdvSolarPanel;
import com.Denfop.gui.GuiMolecularTransformer;
import com.Denfop.handler.EntityStreak;
import com.Denfop.render.EntityRendererStreak;
import com.Denfop.render.block.BlockMolecularTransformerRenderer;
import com.Denfop.render.tile.TileMolecularTransformerRenderer;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.utils.MTRecipeManager;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy  implements IGuiHandler {
  public boolean isClient() {
    return true;
  }
  
  public void registerTabs(CreativeTabs tab, final ItemStack icon) {
   
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
      
 
  
  public void registerRenderers() {
    RenderingRegistry.registerEntityRenderingHandler(EntityStreak.class, (Render)new EntityRendererStreak());
    SuperSolarPanels.blockMolecularTransformerRenderID = RenderingRegistry.getNextAvailableRenderId();
    RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new BlockMolecularTransformerRenderer());
    ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityMolecularTransformer.class, (TileEntitySpecialRenderer)new TileMolecularTransformerRenderer());

  }
  
  public void registerEvents() {
    MinecraftForge.EVENT_BUS.register(new EventDarkQuantumSuitEffect());
    FMLCommonHandler.instance().bus().register(new EventDarkQuantumSuitEffect());
    
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
}
