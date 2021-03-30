package com.Denfop.tiles.Mechanism;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.Denfop.InvSlot.InvSlotProcessableMultiGeneric;
import com.Denfop.container.ContainerMultiMachine;
import com.Denfop.gui.GuiMultiMachine;
import com.Denfop.tiles.base.TileEntityMultiMachine;
import com.Denfop.tiles.base.TileEntityMultiMachine1;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.Recipes;
import ic2.core.BasicMachineRecipeManager;
import ic2.core.upgrade.UpgradableProperty;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class TileEntityDoubleRecycler extends TileEntityMultiMachine1 {
	public TileEntityDoubleRecycler() {
		super();
		this.inputSlots = new InvSlotProcessableMultiGeneric(this, "input", 2, Recipes.recycler);
	}

	@Override
	protected EnumMultiMachine getMachine() {
		return EnumMultiMachine.DOUBLE_RECYCLER;
	}

	public String getInventoryName() {
		return StatCollector.translateToLocal("ssp.blockRecycler.name");
	}

	public String getStartSoundFile() {
		return "Machines/RecyclerOp.ogg";
	}

	public String getInterruptSoundFile() {
		return "Machines/InterruptOne.ogg";
	}

	public float getWrenchDropRate() {
		return 0.85F;
	}

	public Set<UpgradableProperty> getUpgradableProperties() {
		return EnumSet.of(UpgradableProperty.Processing,
				new UpgradableProperty[] { UpgradableProperty.RedstoneSensitive, UpgradableProperty.Transformer,
						UpgradableProperty.EnergyStorage, UpgradableProperty.ItemConsuming,
						UpgradableProperty.ItemProducing });
	}

}
