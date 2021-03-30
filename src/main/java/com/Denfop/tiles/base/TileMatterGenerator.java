package com.Denfop.tiles.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.Denfop.Config;
import com.Denfop.InvSlot.InvSlotQuantumQuarry;
import com.Denfop.container.ContainerGenStone;
import com.Denfop.container.ContainerQuantumQuarry;
import com.Denfop.container.ContainerStandardMachine;
import com.Denfop.gui.GuiAlloySmelter;
import com.Denfop.gui.GuiQuantumQuarry;
import com.Denfop.tiles.base.TileEntityBaseGenStone;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.network.INetworkTileEntityEventListener;
import ic2.core.ContainerBase;
import ic2.core.IC2;
import ic2.core.IHasGui;
import ic2.core.audio.AudioSource;
import ic2.core.block.invslot.InvSlot;
import ic2.core.block.invslot.InvSlotOutput;
import ic2.core.block.invslot.InvSlotUpgrade;
import ic2.core.upgrade.IUpgradableBlock;
import ic2.core.upgrade.UpgradableProperty;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.oredict.OreDictionary;

public class TileMatterGenerator extends TileEntityElectricMachine
		implements IHasGui, INetworkTileEntityEventListener {

	private int progress;

	public AudioSource audioSource;

	Random rand = new Random();


	public InvSlotOutput outputSlot;

	public ItemStack itemstack;

	public TileMatterGenerator(ItemStack itemstack) {
		super(Config.SolidMatterStorage, 11, 1);
		this.progress = 0;
		this.itemstack = itemstack;
		this.outputSlot = new InvSlotOutput(this, "output", 1, 24);

	}

	protected void updateEntityServer() {

		super.updateEntityServer();
		if (this.energy > this.maxEnergy)
			this.energy = this.maxEnergy;
		double proccent = Config.enerycost;

		if (this.energy >= proccent) {

			this.setActive(true);
			this.energy -= (proccent);
			if (this.energy == this.maxEnergy) {
				if (this.outputSlot.canAdd(itemstack)) {
					this.outputSlot.add(itemstack);
					this.energy = 0;
				}
			}

		} else {
			this.setActive(false);
		}

	}

	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		this.progress = nbttagcompound.getInteger("progress");

	}

	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		NBTTagList nbttaglist = new NBTTagList();

		nbttagcompound.setInteger("progress", this.progress);

	}

	public double getEnergy() {
		return this.energy;
	}

	public boolean useEnergy(double amount) {
		if (this.energy >= amount) {
			this.energy -= amount;
			return true;
		}
		return false;
	}

	public boolean isItemValidForSlot(final int i, final ItemStack itemstack) {
		return true;
	}

/*	@SideOnly(Side.CLIENT)
	public GuiScreen getGui(EntityPlayer entityPlayer, boolean isAdmin) {
		return new GuiQuantumQuarry(new ContainerQuantumQuarry(entityPlayer, this));
	}

	public ContainerBase<? extends TileMatterGenerator> getGuiContainer(EntityPlayer entityPlayer) {
		return (ContainerBase<? extends TileMatterGenerator>) new ContainerQuantumQuarry(entityPlayer, this);
	}*/

	public void onLoaded() {
		super.onLoaded();

	}

	public void onUnloaded() {
		super.onUnloaded();
		if (IC2.platform.isRendering() && this.audioSource != null) {
			IC2.audioManager.removeSources(this);
			this.audioSource = null;
		}
	}

	public String getStartSoundFile() {
		return "Machines/MaceratorOp.ogg";
	}

	public String getInterruptSoundFile() {
		return "Machines/InterruptOne.ogg";
	}

	public float getWrenchDropRate() {
		return 0.85F;
	}

	@Override
	public void onNetworkEvent(int event) {
		if (this.audioSource == null && getStartSoundFile() != null)
			this.audioSource = IC2.audioManager.createSource(this, getStartSoundFile());
		switch (event) {
		case 0:
			if (this.audioSource != null)
				this.audioSource.play();
			break;
		case 1:
			if (this.audioSource != null) {
				this.audioSource.stop();
				if (getInterruptSoundFile() != null)
					IC2.audioManager.playOnce(this, getInterruptSoundFile());
			}
			break;
		case 2:
			if (this.audioSource != null)
				this.audioSource.stop();
			break;
		}
	}

	@Override
	public void onGuiClosed(EntityPlayer arg0) {
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuiScreen getGui(EntityPlayer arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerBase<?> getGuiContainer(EntityPlayer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
