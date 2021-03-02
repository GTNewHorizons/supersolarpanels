package com.Denfop.Register;

import com.Denfop.SSPItem;
import com.Denfop.SuperSolarPanels;

import net.minecraftforge.oredict.OreDictionary;

public class RegisterOreDict {
public static void oredict() {
    OreDictionary.registerOre("ingotUranium", SSPItem.itemUranIngot);
    OreDictionary.registerOre("ingotIridium", SSPItem.ingotIridium);
    OreDictionary.registerOre("ingotPlatinum", SSPItem.platium_ingot);
    OreDictionary.registerOre("ingotSpinel", SSPItem.spinel_ingot);
    OreDictionary.registerOre("ingotNickel", SSPItem.nickel);
    OreDictionary.registerOre("ingotInvar", SSPItem.invaringot);
    OreDictionary.registerOre("ingotElectrum", SSPItem.electriumingot);
    OreDictionary.registerOre("ingotMikhalov", SSPItem.mikhail_ingot);
    OreDictionary.registerOre("ingotChromium", SSPItem.chromium_ingot);
    OreDictionary.registerOre("ingotTungsten", SSPItem.wolfram_ingot);
    OreDictionary.registerOre("craftingMTCore", SSPItem.itemMTCore);

}
}
