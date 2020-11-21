// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.integration.nei;

import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IUsageHandler;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIASPConfig implements IConfigureNEI
{
    public void loadConfig() {
        System.out.println("[Advanced Solar Panels]: Loading NEI compatibility...");
        API.registerUsageHandler((IUsageHandler)new MTRecipeHandler());
        API.registerRecipeHandler((ICraftingHandler)new MTRecipeHandler());
    }
    
    public String getName() {
        return "Advanced Solar Panels";
    }
    
    public String getVersion() {
        return "v1.0";
    }
}
