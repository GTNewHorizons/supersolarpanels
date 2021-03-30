package com.Denfop.Recipes;

import com.Denfop.IUItem;
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
			addmacerator(new ItemStack(IUItem.spinelore), new ItemStack(IUItem.spinelcrushedore, 2));
			addmacerator(new ItemStack(IUItem.platiumore), new ItemStack(IUItem.platiumcrushedore, 2));
			addmacerator(new ItemStack(IUItem.chromiumore), new ItemStack(IUItem.chromiumcrushedore, 2));
			addmacerator(new ItemStack(IUItem.iridiumore), new ItemStack(IUItem.iridiumcrushedore, 2));
			addmacerator(new ItemStack(IUItem.magnesiumore), new ItemStack(IUItem.magnesiumcrushedore, 2));
			addmacerator(new ItemStack(IUItem.mikhail_ore), new ItemStack(IUItem.michalovcrushedore, 2));
			addmacerator(new ItemStack(IUItem.nicelore), new ItemStack(IUItem.nickelcrushedore, 2));
			addmacerator(new ItemStack(IUItem.wolframore), new ItemStack(IUItem.wolframcrushedore, 2));
			
			
			
			addmacerator(new ItemStack(IUItem.endspinel_stone),
					new ItemStack(IUItem.spinelcrushedore, 2));
			addmacerator(new ItemStack(IUItem.netherspinelrack),
					new ItemStack(IUItem.spinelcrushedore, 2));
			
			addmacerator(new ItemStack(IUItem.netherplatiumrack),
					new ItemStack(IUItem.platiumcrushedore, 2));
			addmacerator(new ItemStack(IUItem.endplatium_stone),
					new ItemStack(IUItem.platiumcrushedore, 2));
			
			addmacerator(new ItemStack(IUItem.endchromium_stone),
					new ItemStack(IUItem.chromiumcrushedore, 2));
			addmacerator(new ItemStack(IUItem.netherchromiumrack),
					new ItemStack(IUItem.chromiumcrushedore, 2));

			addmacerator(new ItemStack(IUItem.netheriridiumrack),
					new ItemStack(IUItem.iridiumcrushedore, 2));
			addmacerator(new ItemStack(IUItem.endiridium_stone),
					new ItemStack(IUItem.iridiumcrushedore, 2));
			
			addmacerator(new ItemStack(IUItem.endmagnesium_stone),
					new ItemStack(IUItem.magnesiumcrushedore, 2));
			addmacerator(new ItemStack(IUItem.nethermagnesiumrack),
					new ItemStack(IUItem.magnesiumcrushedore, 2));
			
			addmacerator(new ItemStack(IUItem.nethermikhailrack),
					new ItemStack(IUItem.michalovcrushedore, 2));
			addmacerator(new ItemStack(IUItem.endmikhail_stone),
					new ItemStack(IUItem.michalovcrushedore, 2));
			
			addmacerator(new ItemStack(IUItem.endwolfram_stone),
					new ItemStack(IUItem.wolframcrushedore, 2));
			addmacerator(new ItemStack(IUItem.netherwolfram_rack),
					new ItemStack(IUItem.wolframcrushedore, 2));
		}
		

		addmacerator(new ItemStack(IUItem.electriumingot), new ItemStack(IUItem.electriumdust));
		addmacerator(new ItemStack(IUItem.invaringot), new ItemStack(IUItem.invardust));

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
