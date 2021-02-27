package com.Denfop.tiles.Mechanism;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.Denfop.InvSlot.InvSlotProcessableMultiGeneric;
import com.Denfop.InvSlot.InvSlotProcessableMultiSmelting;
import com.Denfop.tiles.base.TileEntityMultiMachine;

import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.Recipes;
import ic2.core.BasicMachineRecipeManager;
import ic2.core.block.invslot.InvSlotProcessable;
import ic2.core.block.invslot.InvSlotProcessableGeneric;
import ic2.core.upgrade.UpgradableProperty;
import net.minecraft.item.ItemStack;

public class TileEntityTripleMacerator extends TileEntityMultiMachine {
	public TileEntityTripleMacerator() {
		super();
		this.inputSlots = new InvSlotProcessableMultiGeneric(this, "input", sizeWorkingSlot, Recipes.macerator);
	}

	@Override
	protected EnumMultiMachine getMachine() {
		return EnumMultiMachine.TRIPLE_MACERATOR;
	}

	public String getInventoryName() {
		return "Triple Macerator";
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

	public Set<UpgradableProperty> getUpgradableProperties() {
		return EnumSet.of(UpgradableProperty.Processing, UpgradableProperty.Transformer,
				UpgradableProperty.EnergyStorage, UpgradableProperty.ItemConsuming, UpgradableProperty.ItemProducing);
	}

}
