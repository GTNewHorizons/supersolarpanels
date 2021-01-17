package com.Denfop.proxy;

import java.util.HashMap;
import java.util.Map;

import com.Denfop.SuperSolarPanels;
import com.Denfop.api.MTAPI;
import com.Denfop.block.TileEntityDoubleMetalFormer.TileEntityDoubleMetalFormer;
import com.Denfop.block.TileEntityTripleMetalFormer.TileEntityTripleMetalFormer;
import com.Denfop.block.advancedmatter.TileEntityAdvancedMatter;
import com.Denfop.block.containerbase.ContainerDoubleMachine;
import com.Denfop.block.containerbase.GuiDoubleMacerator;
import com.Denfop.block.doublecompressor.TileEntityDoubleCompressor;
import com.Denfop.block.doubleelecfurnace.TileEntityDoubleElectricFurnace;
import com.Denfop.block.doubleextractor.TileEntityDoubleExtractor;
import com.Denfop.block.doublemacertator.TileEntityDoubleMacerator;
import com.Denfop.block.expgen.TileExpGen2;
import com.Denfop.block.improvematter.TileEntityImprovedMatter;
import com.Denfop.block.mechanism.TileEntityAlloySmelter;
import com.Denfop.block.triplecompressor.TileEntityTripleCompressor;
import com.Denfop.block.tripleelecfurnace.TileEntityTripleElectricFurnace;
import com.Denfop.block.triplemacerator.TileEntityTripleMacerator;
import com.Denfop.block.ultimatematter.TileEntityUltimateMatter;
import com.Denfop.render.Cable.RenderBlock;
import com.Denfop.tiles.ElectricalBase.ContainerElectricBlock;
import com.Denfop.tiles.ElectricalBase.GuiElectricBlock;
import com.Denfop.tiles.ElectricalBase.TileEntityElectricMFE;
import com.Denfop.tiles.ElectricalBase.TileEntityElectricMFSU;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.base.TileSintezator;
import com.Denfop.utils.MTRecipeManager;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler{
  public boolean isClient() {
    return false;
  }
  
	  public boolean isSimulating() {
	    return !FMLCommonHandler.instance().getEffectiveSide().isClient();
	  }
	  public int getRenderId(String name) {
		    return -1;
		  }
	  public RenderBlock getRender(String name) {
		    return null;
		  }
	  public boolean isRendering() {
	    return !isSimulating();
	  }
  public void registerTabs(CreativeTabs tab, ItemStack icon) {}
  
  public void registerRenderers() {}
  
  public void registerEvents() {
	  
  }
  
  public void registerPackets(SimpleNetworkWrapper netInstance) {}

  public void load() {
  }
  
  public Object getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int X, final int Y, final int Z) {
      final TileEntity te = world.getTileEntity(X, Y, Z);
      if (te == null) {
          return null;
      }
      if (te instanceof TileEntitySolarPanel) {
          return ((TileEntitySolarPanel)te).getGuiContainer(player.inventory);
      }
      if(te instanceof TileExpGen2) {
			
			return ((TileExpGen2) te).getGuiContainer(player.inventory);			
		}
      if (te instanceof TileSintezator) {
          return ((TileSintezator)te).getGuiContainer(player.inventory);
      }
      if (te instanceof TileEntityMolecularTransformer) {
          return ((TileEntityMolecularTransformer)te).getGuiContainer(player.inventory);
      }
      if (te instanceof TileEntityDoubleMacerator) {
          return ((TileEntityDoubleMacerator)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityDoubleExtractor) {
          return ((TileEntityDoubleExtractor)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityDoubleElectricFurnace) {
          return ((TileEntityDoubleElectricFurnace)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityDoubleCompressor) {
          return ((TileEntityDoubleCompressor)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityDoubleMetalFormer) {
          return ((TileEntityDoubleMetalFormer)te).getGuiContainer(player);
      }
      //
      if (te instanceof TileEntityTripleMacerator) {
          return ((TileEntityTripleMacerator)te).getGuiContainer(player);
      }
      
      if (te instanceof TileEntityTripleElectricFurnace) {
          return ((TileEntityTripleElectricFurnace)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityTripleCompressor) {
          return ((TileEntityTripleCompressor)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityTripleMetalFormer) {
          return ((TileEntityTripleMetalFormer)te).getGuiContainer(player);
      }
      //
      if (te instanceof TileEntityAdvancedMatter) {
          return ((TileEntityAdvancedMatter)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityImprovedMatter) {
          return ((TileEntityImprovedMatter)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityUltimateMatter) {
          return ((TileEntityUltimateMatter)te).getGuiContainer(player);
      }
     
      if (te instanceof TileEntityAlloySmelter) {
          return ((TileEntityAlloySmelter)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityElectricMFE)
      {
    	  return ((TileEntityElectricMFE)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityElectricMFSU)
      {
    	  return ((TileEntityElectricMFSU)te).getGuiContainer(player);
      }
      return null;
  }
 
  public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int X, final int Y, final int Z) {
      return null;
  }
  
  public void initRecipes() {
      MTAPI.manager = MTRecipeManager.instance;
      MTRecipeManager.instance.initRecipes();
  }
  
  public int addArmor(final String armorName) {
      return 0;
  }

public static void sendPlayerMessage(EntityPlayer player, String message) {
    if (SuperSolarPanels.isSimulating())
      player.addChatMessage((IChatComponent)new ChatComponentTranslation(message, new Object[0])); 
  }




 public void initCore() {}

 public Void throwInitException(LoaderException e) {
	    throw e;
	  }
  
  

}
