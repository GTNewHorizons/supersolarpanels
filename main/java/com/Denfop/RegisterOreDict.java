package com.Denfop;

import net.minecraftforge.oredict.OreDictionary;

public class RegisterOreDict {
public static void oredict() {
    OreDictionary.registerOre("ingotUranium", SuperSolarPanels.itemUranIngot);
    OreDictionary.registerOre("ingotIridium", SuperSolarPanels.ingotIridium);
    OreDictionary.registerOre("ingotPlatinum", SuperSolarPanels.platium_ingot);
    OreDictionary.registerOre("ingotSpinel", SuperSolarPanels.spinel_ingot);
    OreDictionary.registerOre("ingotMikhalov", SuperSolarPanels.mikhail_ingot);
    OreDictionary.registerOre("ingotChromium", SuperSolarPanels.chromium_ingot);
    OreDictionary.registerOre("ingotTungsten", SuperSolarPanels.wolfram_ingot);
    OreDictionary.registerOre("craftingMTCore", SuperSolarPanels.itemMTCore);
    OreDictionary.registerOre("craftingMolecularTransformer", SuperSolarPanels.itemMolecularTransformer);

}
}
