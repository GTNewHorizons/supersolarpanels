
package com.Denfop.utils;

import com.Denfop.SuperSolarPanels;
import com.Denfop.api.IMTRecipeManager;
import com.google.common.collect.Lists;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameData;
import java.util.Collection;
import java.io.File;
import java.util.Iterator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MTRecipeManager implements IMTRecipeManager
{
    public static List<MTRecipeRecord> transformerRecipes;
    public static MTRecipeManager instance;
    public static ArrayList<String> defaultRecipeList;
    private static Method getUniqueName_Item;
    private static Method getUniqueName_Block;
    public static boolean rawReflectionDone;
    
    public void addMTOreDict(final String name, final String output, final int energy) {
        final List<ItemStack> inputs = (List<ItemStack>)OreDictionary.getOres(name);
        final List<ItemStack> outputs = (List<ItemStack>)OreDictionary.getOres(output);
        if (outputs.size() == 0) {
            return;
        }
        if (inputs.size() == 0) {
            return;
        }
        for (final ItemStack inputIS : inputs) {
            for (final ItemStack outputIS : outputs) {
                this.addMTRecipe(inputIS.copy(), outputIS.copy(), energy);
            }
        }
    }
    
    public void addMTOreDict(final String input, final ItemStack output, final int energy) {
        final List<ItemStack> inputs = (List<ItemStack>)OreDictionary.getOres(input);
        for (final ItemStack inputIS : inputs) {
            this.addMTRecipe(inputIS.copy(), output.copy(), energy);
        }
    }
    
    public void addMTOreDict(final ItemStack input, final String output, final int energy) {
        final List<ItemStack> outputs = (List<ItemStack>)OreDictionary.getOres(output);
        if (outputs.size() == 0) {
            return;
        }
        for (final ItemStack outputIS : outputs) {
            this.addMTRecipe(input.copy(), outputIS.copy(), energy);
        }
    }
    
    public void initRecipes() {
        MTRecipeManager.transformerRecipes.clear();
        final String configFilePath = SuperSolarPanels.configFileName.substring(0, SuperSolarPanels.configFileName.lastIndexOf(File.separatorChar) + 1);
        final String tmpFileName = SuperSolarPanels.configFileName.substring(SuperSolarPanels.configFileName.lastIndexOf(File.separatorChar) + 1);
        String recipesFileName = tmpFileName.substring(0, tmpFileName.lastIndexOf("."));
        final String recipesFileExt = tmpFileName.substring(tmpFileName.lastIndexOf("."));
        recipesFileName = recipesFileName + "_MTRecipes" + recipesFileExt;
        final File file = new File(configFilePath, recipesFileName);
        MTRecipeManager.transformerRecipes.clear();
        MTRecipeManager.transformerRecipes.addAll(MTRecipeConfig.parse(file));
    }
    
    private static void lazyReflectionInit() {
        if (!MTRecipeManager.rawReflectionDone) {
            try {
                MTRecipeManager.getUniqueName_Item = GameData.class.getDeclaredMethod("getUniqueName", Item.class);
                MTRecipeManager.getUniqueName_Block = GameData.class.getDeclaredMethod("getUniqueName", Block.class);
                MTRecipeManager.getUniqueName_Item.setAccessible(true);
                MTRecipeManager.getUniqueName_Block.setAccessible(true);
            }
            catch (Exception e) {
            	SuperSolarPanels.addLog("Reflection failed. This is a fatal error and not recoverable");
                throw new RuntimeException(e);
            }
            MTRecipeManager.rawReflectionDone = true;
        }
    }
    
    public static RawItemData getItemData(final ItemStack is) {
        lazyReflectionInit();
        try {
            final Item i = is.getItem();
            if (i instanceof ItemBlock) {
                final Block b = Block.getBlockFromItem(i);
                final GameRegistry.UniqueIdentifier ui = (GameRegistry.UniqueIdentifier)MTRecipeManager.getUniqueName_Block.invoke(null, b);
                return new RawItemData(ui.modId, ui.name);
            }
            final GameRegistry.UniqueIdentifier ui2 = (GameRegistry.UniqueIdentifier)MTRecipeManager.getUniqueName_Item.invoke(null, i);
            return new RawItemData(ui2.modId, ui2.name);
        }
        catch (Throwable t) {
        	SuperSolarPanels.addLog("Reflection failed. Weird error, report it.");
            t.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void addMTRecipe(final ItemStack inputItem, final ItemStack outputItem, final int energyPerOperation) {
        final MTRecipeRecord recipeToAdd = new MTRecipeRecord();
        recipeToAdd.inputStack = inputItem.copy();
        recipeToAdd.outputStack = outputItem.copy();
        recipeToAdd.energyPerOperation = energyPerOperation;
        MTRecipeManager.transformerRecipes.add(recipeToAdd);
    }
    
    static {
        MTRecipeManager.transformerRecipes = Lists.newArrayList();
        MTRecipeManager.instance = new MTRecipeManager();
        MTRecipeManager.defaultRecipeList = new ArrayList<String>();
        MTRecipeManager.rawReflectionDone = false;
    }
    
    public static class RawItemData
    {
        public final String modId;
        public final String itemName;
        
        public RawItemData(final String id, final String name) {
            this.modId = id;
            this.itemName = name;
        }
    }
}
