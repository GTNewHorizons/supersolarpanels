package com.Denfop.integration.crafttweaker;

import minetweaker.MineTweakerAPI;
import modtweaker2.utils.TweakerPlugin;

public class CTCore {
  public CTCore() {
    MineTweakerAPI.registerClass(CTMoleculatTransformer.class);
    MineTweakerAPI.registerClass(CTAlloySmelter.class);
    
  }
  public static void register() {
	  TweakerPlugin.register("industrialupgrade", CTCore.class);
  }
}
