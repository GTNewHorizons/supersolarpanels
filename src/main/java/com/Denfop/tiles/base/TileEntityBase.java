
package com.Denfop.tiles.base;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.List;

import com.Denfop.item.Modules.AdditionModule;

import ic2.api.network.NetworkHelper;
import net.minecraft.entity.player.EntityPlayer;
import ic2.api.network.INetworkTileEntityEventListener;
import ic2.api.network.INetworkDataProvider;
import ic2.api.tile.IWrenchable;
import ic2.core.IC2;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;

public class TileEntityBase extends TileEntity
		implements IWrenchable, INetworkDataProvider, INetworkTileEntityEventListener {

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

	

	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);

	}

	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);

	}

	public void setFacing(final short var1) {
		this.facing = var1;
		NetworkHelper.updateTileEntityField((TileEntity) this, "facing");
		this.prevFacing = var1;
	}

	public void onNetworkEvent(final int event) {
	}

	public List<String> getNetworkedFields() {
		return null;
	}

	public boolean wrenchCanRemove(final EntityPlayer entityPlayer) {
		if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) instanceof TileEntitySolarPanel) {
			TileEntitySolarPanel tile = (TileEntitySolarPanel) this.worldObj.getTileEntity(this.xCoord, this.yCoord,
					this.zCoord);
			for (int i = 0; i < 9; i++) {
				if (tile.chargeSlots[i] != null && tile.chargeSlots[i].getItem() instanceof AdditionModule) {

					if (tile.chargeSlots[i].getItemDamage() == 0) {
						if (entityPlayer.getDisplayName() == tile.player|| entityPlayer.capabilities.isCreativeMode) {
							return true;
						} else {
							entityPlayer.addChatMessage(new ChatComponentTranslation(
									String.format("ssp.error", new Object[0]), new Object[0]));
							return false;
						}

					} else {
						return true;

					}
				} else {

				}
			}
		}
		return true;
	}

	public float getWrenchDropRate() {
		return 1.0f;
	}

	public ItemStack getWrenchDrop(final EntityPlayer entityPlayer) {
		return new ItemStack(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord), 1,
				this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord));
	}

	@Override
	public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public short getFacing() {
		// TODO Auto-generated method stub
		return 0;
	}

}
