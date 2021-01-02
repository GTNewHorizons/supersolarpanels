
package com.Denfop.utils;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

import com.Denfop.SuperSolarPanels;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.Iterator;
import java.io.BufferedWriter;
import net.minecraft.item.ItemStack;
import java.util.List;

public class MTRecipeConfig
{
    public static final String SEPARATOR = "; ";
    public static final String NEW_LINE;
    public static List<String> defaultLines;
    public static boolean filled;
    public static String configVersion;
    
    public static void populateDefaults() {
        if (!MTRecipeConfig.filled) {
        	MTRecipeConfig.defaultLines.add("minecraft:skull:1; minecraft:skull-1:1; 1000000");
            MTRecipeConfig.defaultLines.add("minecraft:skull-1:1; minecraft:nether_star:1; 150000000");
            MTRecipeConfig.defaultLines.add("minecraft:iron_ingot:1; IC2:itemOreIridium:1; 15500000");
            MTRecipeConfig.defaultLines.add("IC2:itemPlutonium:1; supersolarpanel:proton:1; 7500000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:spinel_ingot:1; supersolarpanel:photoniy:1; 1000000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:photoniy:4; supersolarpanel:photoniy_ingot:1; 8000000");
            MTRecipeConfig.defaultLines.add("minecraft:netherrack:1; minecraft:gunpowder:2; 50000");
            MTRecipeConfig.defaultLines.add("minecraft:sand:1; minecraft:gravel:1; 25000");
            MTRecipeConfig.defaultLines.add("minecraft:dirt:1; minecraft:clay:1; 25000");
            MTRecipeConfig.defaultLines.add("minecraft:coal-1:1; minecraft:coal-0:1; 30000");
            MTRecipeConfig.defaultLines.add("minecraft:wool-4:1; minecraft:glowstone:1; 300000");
            MTRecipeConfig.defaultLines.add("minecraft:wool-11:1; minecraft:lapis_block:1; 300000");
            MTRecipeConfig.defaultLines.add("minecraft:wool-14:1; minecraft:redstone_block:1; 300000");
            MTRecipeConfig.defaultLines.add("minecraft:dye-4:1; oredict:gemSapphire; 4000000");
            MTRecipeConfig.defaultLines.add("minecraft:redstone:1; oredict:gemRuby:1; 4000000");
            MTRecipeConfig.defaultLines.add("minecraft:coal:1; IC2:itemPartIndustrialDiamond:1; 7000000");
            MTRecipeConfig.defaultLines.add("IC2:itemPartIndustrialDiamond:1; minecraft:diamond:1; 850000");
            MTRecipeConfig.defaultLines.add("oredict:dustTitanium:1; oredict:dustChrome:1; 400000");
            MTRecipeConfig.defaultLines.add("oredict:ingotTitanium:1; oredict:ingotChrome:1; 400000");
            MTRecipeConfig.defaultLines.add("oredict:gemNetherQuartz:1; oredict:gemCertusQuartz:1; 400000");
            MTRecipeConfig.defaultLines.add("oredict:ingotCopper:1; oredict:ingotNickel:1; 250000");
            MTRecipeConfig.defaultLines.add("oredict:ingotLead:1; oredict:ingotGold:1; 250000");
            MTRecipeConfig.defaultLines.add("oredict:ingotTin:1; oredict:ingotSilver:1; 450000");
            MTRecipeConfig.defaultLines.add("oredict:ingotSilver:1; oredict:ingotTungsten:1; 400000");
            MTRecipeConfig.defaultLines.add("oredict:ingotTungsten:1; oredict:ingotIridium:1; 500000");
            MTRecipeConfig.defaultLines.add("oredict:ingotGold:1; oredict:ingotPlatinum:1; 8000000");
            MTRecipeConfig.defaultLines.add("oredict:ingotPlatinum:1; oredict:ingotSpinel:1; 500000");
            MTRecipeConfig.defaultLines.add("oredict:ingotUranium:1; oredict:Chromium:1; 500000");
            MTRecipeConfig.defaultLines.add("oredict:Chromium:1; oredict:Mikhalov:1; 500000");
            //
            MTRecipeConfig.defaultLines.add("supersolarpanel:spinel_plate:9; supersolarpanel:module5-0:1; 15000000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:chromium_plate:9; supersolarpanel:module5-1:1; 15000000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:wolfram_plate:9; supersolarpanel:module5-2:1; 15000000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:michail_plate:9; supersolarpanel:module5-5:1; 15000000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:QuantumItems2:9; supersolarpanel:module5-3:1; 15000000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:photoniy_ingot:9; supersolarpanel:module5-4:1; 15000000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:QuantumItems7:9; supersolarpanel:module5-6:1; 15000000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:wolfram_ingot:1; supersolarpanel:asp_crafting_items-7; 5000000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:ssp_crafting_items-7:1; supersolarpanel:advanced_core:1; 1500");
            MTRecipeConfig.defaultLines.add("supersolarpanel:advanced_core:4; supersolarpanel:hybrid_core:1; 7500");
            MTRecipeConfig.defaultLines.add("supersolarpanel:hybrid_core:4; supersolarpanel:ultimate_core:1; 40000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:ultimate_core:4; supersolarpanel:ssp_crafting_items-10:1; 90000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:ssp_crafting_items-10:4; supersolarpanel:spectralcore:1; 150000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:spectralcore:4; supersolarpanel:protoncore:1; 205000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:protoncore:4; supersolarpanel:singularcore:1; 275000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:singularcore:4; supersolarpanel:admincore:1; 400000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:admincore:4; supersolarpanel:photoniccore:1; 800000");
            MTRecipeConfig.defaultLines.add("supersolarpanel:photoniccore:2; supersolarpanel:BlockSintezator:1; 1000000000");
            MTRecipeConfig.filled = true;
            
            MTRecipeConfig.defaultLines.add("Avaritia:Resource-4:4; supersolarpanel:neutroncore:1; 150000000");
            MTRecipeConfig.defaultLines.add("Avaritia:Resource-6:4; supersolarpanel:infinitycore:1; 1050000000");
        }
    }
    
    public static String formatItemData(final MTRecipeManager.RawItemData rawItemData) {
        return String.format("%s:%s", rawItemData.modId, rawItemData.itemName);
    }
    
    public static void addDefaultRecipe(final Object input, final int inputStackSize, final Object output, final int outputStackSize, final int energy) {
        String result = "";
        result += "# ";
        result += ((input instanceof ItemStack) ? ((ItemStack)input).getDisplayName() : input);
        result += " -> ";
        result += ((output instanceof ItemStack) ? ((ItemStack)output).getDisplayName() : output);
        result += String.format(" [%d EU]", energy);
        MTRecipeConfig.defaultLines.add(result);
        result = "";
        if (input instanceof String) {
            result = result + "oredict:" + (String)input + "; ";
        }
        else {
            if (!(input instanceof ItemStack)) {
                throw new RuntimeException("addDefaultRecipe(): input unsupported type: " + input.getClass().getCanonicalName());
            }
            result = result + formatItemData(MTRecipeManager.getItemData((ItemStack)input)) + "-" + ((ItemStack)input).getItemDamage() + ":" + ((ItemStack)input).stackSize + "; ";
        }
        if (output instanceof String) {
            result = result + "oredict:" + (String)output + "; ";
        }
        else {
            if (!(output instanceof ItemStack)) {
                throw new RuntimeException("addDefaultRecipe(): output unsupported type: " + output.getClass().getCanonicalName());
            }
            result = result + formatItemData(MTRecipeManager.getItemData((ItemStack)output)) + "-" + ((ItemStack)output).getItemDamage() + ":" + ((ItemStack)output).stackSize + "; ";
        }
        result += energy;
        MTRecipeConfig.defaultLines.add(result);
    }
    
    public static void doDebug() {
    }
    
    public static void writeGuide(final BufferedWriter bw) {
        try {
            bw.write("##################################################################################################" + MTRecipeConfig.NEW_LINE);
            bw.write("#                        SuperSolarPanels Molecular Transformer Recipes                       #" + MTRecipeConfig.NEW_LINE);
            bw.write("##################################################################################################" + MTRecipeConfig.NEW_LINE);
            bw.write("# Format of recipe: \"inputItem:stackSize;outputItem:outputStackSize;energy\"                      #" + MTRecipeConfig.NEW_LINE);
            bw.write("# InputItem (outputItem) format:                                                                 #" + MTRecipeConfig.NEW_LINE);
            bw.write("# \"oredict:forgeOreDictName\" or \"minecraft:item_name-meta\" or \"modID:item_name-meta\"             #" + MTRecipeConfig.NEW_LINE);
            bw.write("# New line = new recipe.                                                                         #" + MTRecipeConfig.NEW_LINE);
            bw.write("# Add \"#\" before line to skip parsing recipe                                                     #" + MTRecipeConfig.NEW_LINE);
            bw.write("##################################################################################################" + MTRecipeConfig.NEW_LINE);
            bw.write("version=" + MTRecipeConfig.configVersion + MTRecipeConfig.NEW_LINE);
            bw.write("##################################################################################################" + MTRecipeConfig.NEW_LINE);
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public static void fillWithInitials(final BufferedWriter bw) {
        populateDefaults();
        writeGuide(bw);
        System.out.println(MTRecipeConfig.defaultLines.size());
        for (final String s : MTRecipeConfig.defaultLines) {
            try {
                bw.append((CharSequence)(s + "\r\n"));
            }
            catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
    
    public static List<MTRecipeRecord> parse(final File f) {
        final List<MTRecipeRecord> list = Lists.newArrayList();
        try {
            if (!f.exists()) {
            	SuperSolarPanels.addLog("MT recipes config file not found. Create default recipes.");
                f.createNewFile();
                final FileOutputStream fos = new FileOutputStream(f);
                final OutputStreamWriter osw = new OutputStreamWriter(fos);
                final BufferedWriter bw = new BufferedWriter(osw);
                fillWithInitials(bw);
                bw.close();
                fos.close();
            }
            SuperSolarPanels.addLog("* * * * * * Start parsing MT recipes * * * * * * ");
            final FileInputStream fis = new FileInputStream(f);
            final BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                ++lineNumber;
                line = line.replace("\r", "").replace("\n", "");
                if (line.trim().startsWith("#")) {
                    continue;
                }
                if (line.indexOf("#") != 0 && line.indexOf("version") != 0) {
                    if (line.indexOf("#") > 0) {
                        line = line.substring(0, line.indexOf("#"));
                        line = line.trim();
                    }
                }
                else if (line.indexOf("version") == 0) {
                    if (line.indexOf("#") > 0) {
                        line = line.substring(0, line.indexOf("#"));
                        line = line.trim();
                    }
                    final String tmpString = line.substring(line.indexOf("=") + 1);
                    if (tmpString != "") {
                        MTRecipeConfig.configVersion = tmpString;
                        continue;
                    }
                    continue;
                }
                final String[] spaceSplit = line.trim().split("; ".trim());
                if (spaceSplit.length != 3) {
                	SuperSolarPanels.addLog(String.format("Ignoring line %d, incorrect format.", lineNumber));
                }
                else {
                    final String input = spaceSplit[0].trim();
                    final String output = spaceSplit[1].trim();
                    int energy = -1;
                    try {
                        energy = Integer.parseInt(spaceSplit[2].trim());
                    }
                    catch (Exception e) {
                    	SuperSolarPanels.addLog(String.format("Ignoring line %d, energy number is incorrect.", lineNumber));
                        continue;
                    }
                    final List<ItemStack> inputStacks = wrap(input);
                    if (inputStacks == null) {
                    	SuperSolarPanels.addLog(String.format("Ignoring line %d, failed to parse input.", lineNumber));
                    }
                    else {
                        final List<ItemStack> outputStacks = wrap(output);
                        if (outputStacks == null) {
                        	SuperSolarPanels.addLog(String.format("Ignoring line %d, failed to parse output.", lineNumber));
                        }
                        else {
                            final ItemStack outputStack = outputStacks.get(0);
                            for (final ItemStack is : inputStacks) {
                                final MTRecipeRecord recipeToAdd = new MTRecipeRecord();
                                recipeToAdd.inputStack = is.copy();
                                recipeToAdd.outputStack = outputStack.copy();
                                recipeToAdd.energyPerOperation = energy;
                                list.add(recipeToAdd);
                            }
                        }
                    }
                }
            }
            br.close();
            fis.close();
            SuperSolarPanels.addLog("* * * * * * Finished parsing MT recipes * * * * * * ");
            SuperSolarPanels.addLog(String.format("Config loading completed, %d recipes parsed.", list.size()));
            SuperSolarPanels.addLog("* * * * * * Loaded recipes list * * * * * * ");
            for (final MTRecipeRecord record : list) {
                final Object input2 = record.inputStack;
                final Object output2 = record.outputStack;
                final int energy2 = record.energyPerOperation;
                String result = "";
                result += ((input2 instanceof ItemStack) ? ((ItemStack)input2).getDisplayName() : input2);
                result += " -> ";
                result += ((output2 instanceof ItemStack) ? ((ItemStack)output2).getDisplayName() : output2);
                result += String.format(" [%d EU]", energy2);
                SuperSolarPanels.addLog(result);
            }
            SuperSolarPanels.addLog("* * * * * * * * * * * * * * * * * * * * *");
        }
        catch (Throwable t) {
        	SuperSolarPanels.addLog("Fatal error occurred parsing MT recipes config. (" + t.toString() + ")");
        }
        return list;
    }
    
    public static List<ItemStack> wrap(final String s) {
        final List<ItemStack> list = Lists.newArrayList();
        final String[] split = s.split(":");
        final String namespace = split[0];
        int stackSize = 1;
        if (namespace.equalsIgnoreCase("oredict")) {
            if (split.length == 2 || split.length == 3) {
                if (split.length == 3) {
                    stackSize = Integer.parseInt(split[2]);
                }
                final List<ItemStack> retrOreDict = (List<ItemStack>)OreDictionary.getOres(split[1]);
                if (retrOreDict.size() > 0) {
                    for (int i = 0; i < retrOreDict.size(); ++i) {
                        final ItemStack tmpItemStack = retrOreDict.get(i).copy();
                        list.add(new ItemStack(tmpItemStack.getItem(), stackSize, tmpItemStack.getItemDamage()));
                    }
                }
            }
        }
        else if ((namespace.equalsIgnoreCase("minecraft") || Loader.isModLoaded(namespace)) && split.length == 3) {
            final String modId = split[0];
            String itemName = split[1];
            stackSize = Integer.parseInt(split[2]);
            if (stackSize <= 0) {
                stackSize = 1;
            }
            int meta = 0;
            String[] itemArray = null;
            if (itemName.indexOf("-") > 0) {
                itemArray = itemName.split("-");
                itemName = itemArray[0];
                meta = Integer.parseInt(itemArray[1]);
            }
            final ItemStack is = GameRegistry.findItemStack(modId, itemName, 1);
            if (is != null) {
                is.setItemDamage(meta);
                is.stackSize = stackSize;
                list.add(is);
            }
        }
        return (list.size() != 0) ? list : null;
    }
    
    static {
        NEW_LINE = System.getProperty("line.separator");
        MTRecipeConfig.defaultLines = Lists.newArrayList();
        MTRecipeConfig.filled = false;
        MTRecipeConfig.configVersion = "1.0";
    }
}
