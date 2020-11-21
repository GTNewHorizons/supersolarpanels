// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.tiles.base;

import net.minecraft.item.ItemStack;
import java.util.List;
import ic2.api.network.NetworkHelper;
import net.minecraft.entity.player.EntityPlayer;
import ic2.api.network.INetworkTileEntityEventListener;
import ic2.api.network.INetworkDataProvider;
import ic2.api.tile.IWrenchable;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBase extends TileEntity implements IWrenchable, INetworkDataProvider, INetworkTileEntityEventListener
{
    public boolean active;
    public short facing;
    public boolean prevActive;
    public short prevFacing;
    
    public TileEntityBase() {
        this.active = false;
        this.facing = 5;
        this.prevActive = false;
        this.prevFacing = 0;
    }
    
    public boolean getActive() {
        return this.active;
    }
    
    public short getFacing() {
        return this.facing;
    }
    
    public boolean wrenchCanSetFacing(final EntityPlayer var1, final int facingToSet) {
        return facingToSet >= 2 && facingToSet != this.facing;
    }
    
    public void setFacing(final short var1) {
        this.facing = var1;
        NetworkHelper.updateTileEntityField((TileEntity)this, "facing");
        this.prevFacing = var1;
    }
    
    public void onNetworkEvent(final int event) {
    }
    
    public List<String> getNetworkedFields() {
        return null;
    }
    
    public boolean wrenchCanRemove(final EntityPlayer entityPlayer) {
        return true;
    }
    
    public float getWrenchDropRate() {
        return 1.0f;
    }
    
    public ItemStack getWrenchDrop(final EntityPlayer entityPlayer) {
        return new ItemStack(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord), 1, this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord));
    }
}
