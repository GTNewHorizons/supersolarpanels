package com.Denfop.InvSlot;

import java.util.ArrayList;
import java.util.List;

import com.Denfop.Config;
import com.Denfop.api.module.IModulOutput;
import com.Denfop.item.Modules.AdditionModule;
import com.Denfop.item.Modules.BaseModuleOutput;
import com.Denfop.item.Modules.ItemWirelessModule;
import com.Denfop.item.Modules.QuarryModule;
import com.Denfop.tiles.base.TileEntityElectricBlock;
import com.Denfop.utils.NBTData;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class InvSlotElectricBlockB extends InvSlot {

	private int stackSizeLimit;

	public InvSlotElectricBlockB(TileEntityInventory base1, int oldStartIndex1) {
		super(base1, "input4", oldStartIndex1, InvSlot.Access.IO, 2, InvSlot.InvSide.TOP);
		
		this.stackSizeLimit = 1;
	}

	public boolean accepts(ItemStack itemStack) {
		return ((itemStack.getItemDamage() >= 4 || itemStack.getItemDamage() == 0)
				&& itemStack.getItem() instanceof AdditionModule) || (itemStack.getItem() instanceof ItemWirelessModule)
				|| (itemStack.getItem() instanceof IModulOutput);
	}

	public int getStackSizeLimit() {
		return this.stackSizeLimit;
	}

	public void setStackSizeLimit(int stackSizeLimit) {
		this.stackSizeLimit = stackSizeLimit;
	}

	public List<Boolean> getstats(InvSlot inputslotC) {
		List<Boolean> list = new ArrayList<Boolean>();
		List<Boolean> list1 = new ArrayList<Boolean>();

		for (int i = 0; i < inputslotC.size(); i++) {
			if (inputslotC.get(i) == null) {
				list.add(false);
				list.add(false);
				list.add(false);
				list.add(false);
				list.add(false);
				continue;
			}

			ItemStack stack = inputslotC.get(i);
			if (stack.getItemDamage() == 5) {
				list.add(true);
			} else {
				list.add(false);
			}
			if (stack.getItemDamage() == 6) {
				list.add(true);
			} else {
				list.add(false);
			}
			if (stack.getItemDamage() == 7) {
				list.add(true);
			} else {
				list.add(false);
			}
			if (stack.getItemDamage() == 8) {
				list.add(true);
			} else {
				list.add(false);
			}
			if (stack.getItemDamage() == 4) {
				list.add(true);
			} else {
				list.add(false);
			}

		}
		list1.add(gettrue(list.get(0), list.get(5)));
		list1.add(gettrue(list.get(1), list.get(6)));
		list1.add(gettrue(list.get(2), list.get(7)));
		list1.add(gettrue(list.get(3), list.get(8)));
		list1.add(gettrue(list.get(4), list.get(9)));

		return list1;
	}

	public boolean gettrue(boolean o, boolean j) {
		return (o || j);
	}

	public List<Integer> rfmodule(InvSlot inputslotC) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < inputslotC.size(); i++) {
			ItemStack stack = inputslotC.get(i);

		}

		return list;

	}

	

	public void wireless(InvSlot inputslotC, int xCoord, int yCoord, int zCoord, int tier, int dimensionId,
			String string, String string2) {

		for (int i = 0; i < inputslotC.size(); i++) {
			if (inputslotC.get(i) == null)
				continue;
			ItemStack stack = inputslotC.get(i);
			if (stack.getItem() instanceof ItemWirelessModule) {
			
				NBTTagCompound nbttagcompound = NBTData.getOrCreateNbtData(stack);
				nbttagcompound.setInteger("Xcoord", xCoord);
				nbttagcompound.setInteger("Ycoord", yCoord);
				nbttagcompound.setInteger("Zcoord", zCoord);
				nbttagcompound.setInteger("tier", tier);
				nbttagcompound.setInteger("World1", dimensionId);
				nbttagcompound.setString("World", string);
				nbttagcompound.setString("Name", string2);
			}
		}

	}

	public boolean personality(InvSlot inputslotC) {

		for (int i = 0; i < inputslotC.size(); i++) {
			if (inputslotC.get(i) == null)
				continue;
			ItemStack stack = inputslotC.get(i);
			if (stack.getItem() instanceof AdditionModule)
				if (stack.getItemDamage() == 0)
					return true;
		}
		return false;
	}

	public double output_plus(InvSlot inputslotC, double l) {
		List<Double> list = new ArrayList<Double>();
		int output = 0;
		for (int i = 0; i < inputslotC.size(); i++) {
			if (inputslotC.get(i) == null)
				continue;
			ItemStack stack = inputslotC.get(i);
			if (stack.getItem() instanceof BaseModuleOutput) {
				int percent = BaseModuleOutput.getpercent();
				list.add((l / 100) * percent);
			}
		}
		int meta = list.size();
		for (int i = 0; i < meta; i++) {
			output += list.get(i);
		}
		return output;
	}

}
