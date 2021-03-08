package com.Denfop.Recipes;

import com.Denfop.SSPItem;
import com.Denfop.SuperSolarPanels;

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
		if(!Loader.isModLoaded("aobd")) {
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.spinelore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SSPItem.spinelcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.platiumore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SSPItem.platiumcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.chromiumore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SSPItem.chromiumcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.iridiumore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SSPItem.iridiumcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.magnesiumore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SSPItem.magnesiumcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.mikhail_ore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SSPItem.michalovcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.nicelore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SSPItem.nickelcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.wolframore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SSPItem.wolframcrushedore,2) });
		}//
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.endiron_stone)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(IC2Items.getItem("crushedIronOre").getItem(),2,0)});
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.netherironrack)), (NBTTagCompound)null, new ItemStack[] {  new ItemStack(IC2Items.getItem("crushedIronOre").getItem(),2,0) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.endgold_stone)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(IC2Items.getItem("crushedGoldOre").getItem(),2,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.nethergoldrack)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(IC2Items.getItem("crushedGoldOre").getItem(),2,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.enduran_stone)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedUraniumOre").getItem(),2,4)});
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.netheruranrack)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedUraniumOre").getItem(),2,4) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.endcopper_stone)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedCopperOre").getItem(),2,1) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.nethercopperrack)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedCopperOre").getItem(),2,1) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.endtin_stone)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedTinOre").getItem(),2,3) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.nethertinrack)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedTinOre").getItem(),2,3) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.endlead_stone)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedLeadOre").getItem(),2,6) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.netherleadrack)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedLeadOre").getItem(),2,6) });
		//
		 //  Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(Ic2Items.advIronIngot.getItem())), (NBTTagCompound)null, new ItemStack[] {new ItemStack(SuperSolarPanels.blast) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.electriumingot)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(SSPItem.electriumdust) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SSPItem.invaringot)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(SSPItem.invardust) });
		
	}
	public static void addmacerator(ItemStack input,int n,ItemStack output) {
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(input,n), (NBTTagCompound)null, new ItemStack[] {output });

	}
}
