package com.Denfop.integration.ASP;

import com.Denfop.SuperSolarPanels;

import advsolar.common.AdvancedSolarPanel;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ASPIntegration {
public static void init() {
    GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.itemSSP, 1,8), new Object[] { new ItemStack(AdvancedSolarPanel.itemAdvanced, 1, 11) });
    GameRegistry.addShapelessRecipe(SuperSolarPanels.itemMolecularTransformer, new Object[] { AdvancedSolarPanel.itemMolecularTransformer });
    
    GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.itemSSP, 1,3), new Object[] { new ItemStack(AdvancedSolarPanel.itemAdvanced, 1, 5) });
    GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.itemSSP, 1,0), new Object[] { new ItemStack(AdvancedSolarPanel.itemAdvanced, 1, 2) });
    
}
}
