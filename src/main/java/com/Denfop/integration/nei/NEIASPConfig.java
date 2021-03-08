
package com.Denfop.integration.nei;

import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IUsageHandler;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIASPConfig implements IConfigureNEI
{
    public void loadConfig() {
        System.out.println("[Super Solar Panels]: Loading NEI compatibility...");
   
        API.registerRecipeHandler((ICraftingHandler)new NEIAlloySmelter());
        API.registerUsageHandler((IUsageHandler)new NEIAlloySmelter());
        API.registerRecipeHandler((ICraftingHandler)new NEIGenStone());
        API.registerUsageHandler((IUsageHandler)new NEIGenStone());
        API.registerRecipeHandler((ICraftingHandler)new NeiMolecularTransfomator());
        API.registerUsageHandler((IUsageHandler)new NeiMolecularTransfomator());
    }
    
    public String getName() {
        return "Super Solar Panels";
    }
    
    public String getVersion() {
        return "v1.0";
    }
}
