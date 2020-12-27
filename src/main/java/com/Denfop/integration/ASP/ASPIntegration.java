package com.Denfop.integration.ASP;

import com.Denfop.SuperSolarPanels;

import advsolar.common.AdvancedSolarPanel;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ASPIntegration {
public static void init() {
    GameRegistry.addShapelessRecipe(new ItemStack(SuperSolarPanels.itemSSP, 1,8), new Object[] { new ItemStack(AdvancedSolarPanel.itemAdvanced, 1, 11) });
    
}
}
