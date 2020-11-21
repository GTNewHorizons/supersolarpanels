// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.api;

import java.lang.reflect.Field;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;

public class SSPItemAPI
{
    private static Class aspClass;
    private static boolean inited;
    
    private static void lazyInit() {
        if (!SSPItemAPI.inited) {
            try {
                SSPItemAPI.aspClass = Class.forName("com.Denfop.SuperSolarPanels");
            }
            catch (Exception e) {
                FMLLog.severe("Fatal exception hapenned when tried to instantiate SSP API.", new Object[0]);
            }
            SSPItemAPI.inited = true;
        }
    }
    
    public static ItemStack get(final String name) {
        lazyInit();
        try {
            final Field fField = SSPItemAPI.aspClass.getField(name);
            final Object retObj = fField.get(null);
            if (retObj instanceof ItemStack) {
                return ((ItemStack)retObj).copy();
            }
            if (retObj instanceof Item) {
                return new ItemStack((Item)retObj).copy();
            }
            if (retObj instanceof Block) {
                return new ItemStack((Block)retObj).copy();
            }
            return null;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    static {
        SSPItemAPI.aspClass = null;
        SSPItemAPI.inited = false;
    }
}
