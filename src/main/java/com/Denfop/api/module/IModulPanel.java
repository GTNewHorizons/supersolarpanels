package com.Denfop.api.module;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.IUCore;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.utils.NBTData;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IModulPanel {
	public static void setData(ItemStack stack, TileEntitySolarPanel tile) {
		NBTTagCompound nbt = NBTData.getOrCreateNbtData(stack);

		nbt.setDouble("genday", tile.genDay);
		nbt.setDouble("gennight", tile.genNight);
		nbt.setDouble("basestorage", tile.maxStorage);
		nbt.setDouble("output", tile.production);
		nbt.setDouble("tier", tile.tier);
	}

	public static List<Double> getData(ItemStack stack) {
		NBTTagCompound nbt = NBTData.getOrCreateNbtData(stack);
		List<Double> list = new ArrayList<Double>();
		list.add(nbt.getDouble("genday"));
		list.add(nbt.getDouble("gennight"));
		list.add(nbt.getDouble("basestorage"));
		list.add(nbt.getDouble("output"));
		list.add(nbt.getDouble("tier"));

		return list;

	}
}
