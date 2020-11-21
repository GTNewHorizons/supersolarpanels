// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class MySlot extends Slot
{
    private Boolean canPutInSlot;
    
    public MySlot(final IInventory inventory, final int par3, final int par4, final int par5, final Boolean canPut) {
        super(inventory, par3, par4, par5);
        this.canPutInSlot = canPut;
    }
    
    public boolean func_75214_a(final ItemStack par1ItemStack) {
        return this.canPutInSlot;
    }
}
