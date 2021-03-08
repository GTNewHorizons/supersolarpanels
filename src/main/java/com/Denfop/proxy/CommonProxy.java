package com.Denfop.proxy;

import java.util.HashMap;
import java.util.Map;
import com.Denfop.SuperSolarPanels;
import com.Denfop.Recipes.CentrifugeRecipe;
import com.Denfop.render.Cable.RenderBlock;
import com.Denfop.tiles.ExpGen.TileExpGen2;
import com.Denfop.tiles.Mechanism.*;
import com.Denfop.tiles.NeutroniumGenerator.TileBitGen2;
import com.Denfop.tiles.base.TileEntityChargepadBlock;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.Denfop.tiles.base.TileEntityMultiMachine;
import com.Denfop.tiles.base.TileEntityMultiMachine1;
import com.Denfop.tiles.base.TileEntityMultiMatter;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.base.TileSintezator;
import com.Denfop.tiles.wiring.Storage.TileEntityElectricMFE;
import com.Denfop.tiles.wiring.Storage.TileEntityElectricMFSU;

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
          return ((TileEntityMolecularTransformer)te).getGuiContainer(player);
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
      if (te instanceof TileEntityMultiMatter) {
			return ((TileEntityMultiMatter) te).getGuiContainer(player);
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
      if (te instanceof TileBitGen2)
      {
    	  return ((TileBitGen2)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityGenerationMicrochip)
      {
    	  return ((TileEntityGenerationMicrochip)te).getGuiContainer(player);
      }
      if (te instanceof TileEntityMultiMachine) {
			return ((TileEntityMultiMachine) te).getGuiContainer(player);
		}
      if (te instanceof TileEntityMultiMachine1) {
			return ((TileEntityMultiMachine1) te).getGuiContainer(player);
		}
      if (te instanceof TileEntityChargepadBlock) {
			return ((TileEntityChargepadBlock) te).getGuiContainer(player);
		}
      if (te instanceof TileEntityGenerationStone)
			return ((TileEntityGenerationStone) te).getGuiContainer(player);
      if (te instanceof TileEntityQuantumQuarry)
			return ((TileEntityQuantumQuarry) te).getGuiContainer(player);
		
      return null;
  }
 
  public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int X, final int Y, final int Z) {
      return null;
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

public void registerRecipe() {
	
	
}

public void integration() {
	
	
}
  
  

}
