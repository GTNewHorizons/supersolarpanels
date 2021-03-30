package com.Denfop.Recipes;

import com.Denfop.SSPItem;
import com.Denfop.IUCore;

import cpw.mods.fml.common.Loader;
import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MaceratorRecipe {
	public static void recipe() {
		if (!Loader.isModLoaded("aobd")) {
			addmacerator(new ItemStack(SSPItem.spinelore), new ItemStack(SSPItem.spinelcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.platiumore), new ItemStack(SSPItem.platiumcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.chromiumore), new ItemStack(SSPItem.chromiumcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.iridiumore), new ItemStack(SSPItem.iridiumcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.magnesiumore), new ItemStack(SSPItem.magnesiumcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.mikhail_ore), new ItemStack(SSPItem.michalovcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.nicelore), new ItemStack(SSPItem.nickelcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.wolframore), new ItemStack(SSPItem.wolframcrushedore, 2));
			
			
			
			addmacerator(new ItemStack(SSPItem.endspinel_stone),
					new ItemStack(SSPItem.spinelcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.netherspinelrack),
					new ItemStack(SSPItem.spinelcrushedore, 2));
			
			addmacerator(new ItemStack(SSPItem.netherplatiumrack),
					new ItemStack(SSPItem.platiumcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.endplatium_stone),
					new ItemStack(SSPItem.platiumcrushedore, 2));
			
			addmacerator(new ItemStack(SSPItem.endchromium_stone),
					new ItemStack(SSPItem.chromiumcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.netherchromiumrack),
					new ItemStack(SSPItem.chromiumcrushedore, 2));

			addmacerator(new ItemStack(SSPItem.netheriridiumrack),
					new ItemStack(SSPItem.iridiumcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.endiridium_stone),
					new ItemStack(SSPItem.iridiumcrushedore, 2));
			
			addmacerator(new ItemStack(SSPItem.endmagnesium_stone),
					new ItemStack(SSPItem.magnesiumcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.nethermagnesiumrack),
					new ItemStack(SSPItem.magnesiumcrushedore, 2));
			
			addmacerator(new ItemStack(SSPItem.nethermikhailrack),
					new ItemStack(SSPItem.michalovcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.endmikhail_stone),
					new ItemStack(SSPItem.michalovcrushedore, 2));
			
			addmacerator(new ItemStack(SSPItem.endwolfram_stone),
					new ItemStack(SSPItem.wolframcrushedore, 2));
			addmacerator(new ItemStack(SSPItem.netherwolfram_rack),
					new ItemStack(SSPItem.wolframcrushedore, 2));
		}
		

		addmacerator(new ItemStack(SSPItem.electriumingot), new ItemStack(SSPItem.electriumdust));
		addmacerator(new ItemStack(SSPItem.invaringot), new ItemStack(SSPItem.invardust));

	}

	public static void addmacerator(ItemStack input, int n, ItemStack output) {
		Recipes.macerator.addRecipe((IRecipeInput) new RecipeInputItemStack(input, n), (NBTTagCompound) null,
				new ItemStack[] { output });

	}

	public static void addmacerator(ItemStack input, ItemStack output) {
		Recipes.macerator.addRecipe((IRecipeInput) new RecipeInputItemStack(input, 1), (NBTTagCompound) null,
				new ItemStack[] { output });

	}
	public static void addmacerato1r(ItemStack input, ItemStack output) {
		Recipes.macerator.addRecipe((IRecipeInput) new RecipeInputItemStack(input, 1), (NBTTagCompound) null,
				new ItemStack[] { output });

	}
}
