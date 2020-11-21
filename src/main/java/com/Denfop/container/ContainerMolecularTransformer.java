// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.container;

import net.minecraft.item.ItemStack;

import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.Denfop.utils.MySlot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerMolecularTransformer extends Container
{
    private TileEntityMolecularTransformer tileentity;
    private short lastProgress;
    private int energyUsed;
    private int energyPerOperartion;
    private int inputEU;
    private int doWork;
    private int lastRecipeNumber;
    
    public ContainerMolecularTransformer(final InventoryPlayer inventoryplayer, final TileEntityMolecularTransformer tileentitymoleculartransformer) {
        this.lastProgress = -1;
        this.tileentity = tileentitymoleculartransformer;
        this.addSlotToContainer(new Slot((IInventory)this.tileentity, 0, 20, 27));
        this.addSlotToContainer((Slot)new MySlot((IInventory)this.tileentity, 1, 20, 68, false));
        for (int i = 0; i < 3; ++i) {
            for (int k = 0; k < 9; ++k) {
                this.addSlotToContainer(new Slot((IInventory)inventoryplayer, k + i * 9 + 9, 18 + k * 21, 98 + i * 21));
            }
        }
        for (int j = 0; j < 9; ++j) {
            this.addSlotToContainer(new Slot((IInventory)inventoryplayer, j, 18 + j * 21, 165));
        }
    }
    
    public void addCraftingToCrafters(final ICrafting icrafting) {
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate((Container)this, 0, this.tileentity.lastRecipeEnergyUsed & 0xFFFF);
        icrafting.sendProgressBarUpdate((Container)this, 1, this.tileentity.lastRecipeEnergyUsed >>> 16);
        icrafting.sendProgressBarUpdate((Container)this, 2, this.tileentity.lastRecipeEnergyPerOperation & 0xFFFF);
        icrafting.sendProgressBarUpdate((Container)this, 3, this.tileentity.lastRecipeEnergyPerOperation >>> 16);
        icrafting.sendProgressBarUpdate((Container)this, 4, (int)(this.tileentity.doWork ? 1 : 0));
        icrafting.sendProgressBarUpdate((Container)this, 5, (int)this.tileentity.lastProgress);
        icrafting.sendProgressBarUpdate((Container)this, 6, this.tileentity.lastRecipeNumber);
        icrafting.sendProgressBarUpdate((Container)this, 7, this.tileentity.inputEU & 0xFFFF);
        icrafting.sendProgressBarUpdate((Container)this, 8, this.tileentity.inputEU >>> 16);
    }
    
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i) {
            final ICrafting icrafting = (ICrafting) this.crafters.get(i);
            icrafting.sendProgressBarUpdate((Container)this, 0, this.tileentity.lastRecipeEnergyUsed & 0xFFFF);
            icrafting.sendProgressBarUpdate((Container)this, 1, this.tileentity.lastRecipeEnergyUsed >>> 16);
            icrafting.sendProgressBarUpdate((Container)this, 2, this.tileentity.lastRecipeEnergyPerOperation & 0xFFFF);
            icrafting.sendProgressBarUpdate((Container)this, 3, this.tileentity.lastRecipeEnergyPerOperation >>> 16);
            if (this.doWork != (this.tileentity.doWork ? 1 : 0)) {
                icrafting.sendProgressBarUpdate((Container)this, 4, (int)(this.tileentity.doWork ? 1 : 0));
            }
            if (this.lastProgress != this.tileentity.lastProgress) {
                icrafting.sendProgressBarUpdate((Container)this, 5, (int)this.tileentity.lastProgress);
            }
            if (this.lastRecipeNumber != this.tileentity.lastRecipeNumber) {
                icrafting.sendProgressBarUpdate((Container)this, 6, this.tileentity.lastRecipeNumber);
            }
            icrafting.sendProgressBarUpdate((Container)this, 7, this.tileentity.inputEU & 0xFFFF);
            icrafting.sendProgressBarUpdate((Container)this, 8, this.tileentity.inputEU >>> 16);
        }
        this.energyUsed = this.tileentity.lastRecipeEnergyUsed;
        this.energyPerOperartion = this.tileentity.lastRecipeEnergyPerOperation;
        this.doWork = (this.tileentity.doWork ? 1 : 0);
        this.lastProgress = this.tileentity.lastProgress;
        this.lastRecipeNumber = this.tileentity.lastRecipeNumber;
        this.inputEU = this.tileentity.inputEU;
    }
    
    public void updateProgressBar(final int index, final int value) {
        if (index == 0) {
            this.tileentity.lastRecipeEnergyUsed = ((this.tileentity.lastRecipeEnergyUsed & 0xFFFF0000) | value);
        }
        if (index == 1) {
            this.tileentity.lastRecipeEnergyUsed = ((this.tileentity.lastRecipeEnergyUsed & 0xFFFF) | value << 16);
        }
        if (index == 2) {
            this.tileentity.lastRecipeEnergyPerOperation = ((this.tileentity.lastRecipeEnergyPerOperation & 0xFFFF0000) | value);
        }
        if (index == 3) {
            this.tileentity.lastRecipeEnergyPerOperation = ((this.tileentity.lastRecipeEnergyPerOperation & 0xFFFF) | value << 16);
        }
        if (index == 4) {
            this.tileentity.doWork = (value == 1);
        }
        if (index == 5) {
            this.tileentity.lastProgress = (short)value;
        }
        if (index == 6) {
            this.tileentity.lastRecipeNumber = value;
        }
        if (index == 7) {
            this.tileentity.inputEU = ((this.tileentity.inputEU & 0xFFFF0000) | value);
        }
        if (index == 8) {
            this.tileentity.inputEU = ((this.tileentity.inputEU & 0xFFFF) | value << 16);
        }
    }
    
    public ItemStack transferStackInSlot(final EntityPlayer par1EntityPlayer, final int par2) {
        final int slot = par2;
        ItemStack stack = null;
        final int mainInventorySlotsStart;
        final int mySlotsCount = mainInventorySlotsStart = 2;
        final int hotBarSlotStart;
        final int mainInventorySlotsEnd = hotBarSlotStart = 27 + mySlotsCount;
        final int hotBarslotsEnd = this.inventorySlots.size();
        final Slot slotObject = (Slot) this.inventorySlots.get(par2);
        if (slotObject != null && slotObject.getHasStack()) {
            final ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();
            if (slot <= 1) {
                if (!this.mergeItemStack(stackInSlot, hotBarSlotStart, hotBarslotsEnd, false) && !this.mergeItemStack(stackInSlot, mainInventorySlotsStart, mainInventorySlotsEnd, false)) {
                    return null;
                }
            }
            else if (slot >= mainInventorySlotsStart && slot < mainInventorySlotsEnd) {
                if (!this.mergeItemStack(stackInSlot, 0, 1, false) && !this.mergeItemStack(stackInSlot, hotBarSlotStart, hotBarslotsEnd, false)) {
                    return null;
                }
            }
            else if (slot >= hotBarSlotStart && slot < hotBarslotsEnd && !this.mergeItemStack(stackInSlot, 0, 1, false) && !this.mergeItemStack(stackInSlot, mainInventorySlotsStart, mainInventorySlotsEnd, false)) {
                return null;
            }
            if (stackInSlot.stackSize == 0) {
                slotObject.putStack((ItemStack)null);
            }
            else {
                slotObject.onSlotChanged();
            }
            if (stack.stackSize == stackInSlot.stackSize) {
                return null;
            }
            slotObject.onPickupFromSlot(par1EntityPlayer, stackInSlot);
        }
        return stack;
    }
    
    public boolean canInteractWith(final EntityPlayer entityplayer) {
        return this.tileentity.isUseableByPlayer(entityplayer);
    }
}
