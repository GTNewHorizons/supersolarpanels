

package com.Denfop.gui;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;

import com.Denfop.tiles.base.*;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    public Object getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int X, final int Y, final int Z) {
        final TileEntity te = world.getTileEntity(X, Y, Z);
        if (te == null) {
            return null;
        }
        if (te instanceof TileEntitySolarPanel) {
            return ((TileEntitySolarPanel)te).getGuiContainer(player.inventory);
        }
        
        if (te instanceof TileEntityMolecularTransformer) {
            return ((TileEntityMolecularTransformer)te).getGuiContainer(player.inventory);
        }
        return null;
    }
    
    public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int X, final int Y, final int Z) {
        final TileEntity te = world.getTileEntity(X, Y, Z);
        System.out.println("OpenGui");
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
    
    public void registerRenderers() {
    }
}
