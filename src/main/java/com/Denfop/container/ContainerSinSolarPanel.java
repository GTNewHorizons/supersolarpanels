package com.Denfop.container;

import java.util.List;

import com.Denfop.tiles.base.TileEntityBaseMolecular;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.base.TileSintezator;

import ic2.core.ContainerBase;
import ic2.core.ContainerFullInv;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerSinSolarPanel<T extends TileSintezator> extends ContainerFullInv<TileSintezator> {
	public TileSintezator tileentity;
	private int storage = 0;
	private int fuel = 0;
	private boolean sunIsUp;
	private boolean skyIsVisible;
	private int generating;

	public ContainerSinSolarPanel(EntityPlayer entityPlayer, TileSintezator tileEntity1) {
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
		ret.add("production");
		ret.add("rain");
		ret.add("machineTire");

		return ret;
	}

}
