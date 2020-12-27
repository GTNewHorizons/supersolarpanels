package com.Denfop.proxy;

import com.Denfop.SuperSolarPanels;
import com.Denfop.api.MTAPI;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.base.TileSintezator;
import com.Denfop.utils.MTRecipeManager;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
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
  
  public void registerEvents() {}
  
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
      if (te instanceof TileSintezator) {
          return ((TileSintezator)te).getGuiContainer(player.inventory);
      }
      if (te instanceof TileEntityMolecularTransformer) {
          return ((TileEntityMolecularTransformer)te).getGuiContainer(player.inventory);
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
  

}
