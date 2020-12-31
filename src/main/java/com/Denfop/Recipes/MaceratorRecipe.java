package com.Denfop.Recipes;

import com.Denfop.SuperSolarPanels;

import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MaceratorRecipe {
	public static void recipe() {
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.spinelore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.spinelcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.platiumore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.platiumcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.chromiumore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.chromiumcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.iridiumore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.iridiumcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.magnesiumore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.magnesiumcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.mikhail_ore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.michalovcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.nicelore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.nickelcrushedore,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.wolframore)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(SuperSolarPanels.wolframcrushedore,2) });
			//
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.endiron_stone)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(IC2Items.getItem("crushedIronOre").getItem(),2,0)});
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.netherironrack)), (NBTTagCompound)null, new ItemStack[] {  new ItemStack(IC2Items.getItem("crushedIronOre").getItem(),2,0) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.endgold_stone)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(IC2Items.getItem("crushedGoldOre").getItem(),2,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.nethergoldrack)), (NBTTagCompound)null, new ItemStack[] { new ItemStack(IC2Items.getItem("crushedGoldOre").getItem(),2,2) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.enduran_stone)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedUraniumOre").getItem(),2,4)});
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.netheruranrack)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedUraniumOre").getItem(),2,4) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.endcopper_stone)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedCopperOre").getItem(),2,1) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.nethercopperrack)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedCopperOre").getItem(),2,1) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.endtin_stone)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedTinOre").getItem(),2,3) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.nethertinrack)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedTinOre").getItem(),2,3) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.endlead_stone)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedLeadOre").getItem(),2,6) });
		   Recipes.macerator.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(SuperSolarPanels.netherleadrack)), (NBTTagCompound)null, new ItemStack[] {new ItemStack(IC2Items.getItem("crushedLeadOre").getItem(),2,6) });
		
	}
}
