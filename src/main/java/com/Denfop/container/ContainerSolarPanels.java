package com.Denfop.container;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.base.TileSintezator;

import ic2.core.ContainerFullInv;
import ic2.core.IC2;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class ContainerSolarPanels<T extends TileEntitySolarPanel> extends ContainerFullInv<TileEntitySolarPanel> {

	public TileEntitySolarPanel tileentity;

	public ContainerSolarPanels(EntityPlayer entityPlayer, TileEntitySolarPanel tileEntity1) {
		super(entityPlayer, tileEntity1, 117 + 40 + 19 + 16 + 4, 186 - 18);
		this.tileentity = tileEntity1;

		for (int j = 0; j < 9; ++j) {

			this.addSlotToContainer(new Slot(this.tileentity, j, 17 + j * 18, 59));

		}
	}

	public List<String> getNetworkedFields() {
		List<String> ret = super.getNetworkedFields();
		ret.add("sunIsUp");
		ret.add("skyIsVisible");
		ret.add("generating");
		ret.add("genDay");
		ret.add("genNight");
		ret.add("storage");
		ret.add("maxStorage");
		ret.add("storage2");
		ret.add("maxStorage2");
		ret.add("production");
		ret.add("rain");
		ret.add("panelx");
		ret.add("panely");
		ret.add("panelz");
		ret.add("solarType");
		ret.add("rf");

		ret.add("getmodulerf");
		return ret;
	}

}
