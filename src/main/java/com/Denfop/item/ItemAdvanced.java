// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.item;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import net.minecraft.util.IIcon;
import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.item.Item;

public class ItemAdvanced extends Item
{
    private List<String> itemNames;
    private IIcon[] IIconsList;
    private int itemsCount;
    
    public ItemAdvanced() {
        this.itemNames = new ArrayList<String>();
        this.IIconsList = new IIcon[14];
        this.itemsCount = 13;
        this.setHasSubtypes(true);
        this.setCreativeTab(SuperSolarPanels.tabssp);
        this.setMaxStackSize(64);
        this.addItemsNames();
    }
    
    public String getUnlocalizedName(final ItemStack stack) {
        return this.itemNames.get(stack.getItemDamage());
    }
    
    public IIcon getIconFromDamage(final int par1) {
        return this.IIconsList[par1];
    }
    
    public void addItemsNames() {
        this.itemNames.add("itemSunnarium");
        this.itemNames.add("itemSunnariumAlloy");
        this.itemNames.add("itemIrradiantUranium");
        this.itemNames.add("itemEnrichedSunnarium");
        this.itemNames.add("itemEnrichedSunnariumAlloy");
        this.itemNames.add("itemIrradiantGlassPane");
        this.itemNames.add("itemIridiumIronPlate");
        this.itemNames.add("itemReinforcedIridiumIronPlate");
        this.itemNames.add("itemIrradiantReinforcedPlate");
        this.itemNames.add("itemSunnariumPart");
        this.itemNames.add("ingotIridium");
        this.itemNames.add("itemUranIngot");
        this.itemNames.add("itemMTCore");
        this.itemNames.add("itemQuantumCore");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister IIconRegister) {
        this.IIconsList[0] = IIconRegister.registerIcon("supersolarpanel:Sunnarium");
        this.IIconsList[1] = IIconRegister.registerIcon("supersolarpanel:SunnariumAlloy");
        this.IIconsList[2] = IIconRegister.registerIcon("supersolarpanel:IrradiantUranium");
        this.IIconsList[3] = IIconRegister.registerIcon("supersolarpanel:EnrichedSunnarium");
        this.IIconsList[4] = IIconRegister.registerIcon("supersolarpanel:EnrichedSunnariumAlloy");
        this.IIconsList[5] = IIconRegister.registerIcon("supersolarpanel:IrradiantGlassPane");
        this.IIconsList[6] = IIconRegister.registerIcon("supersolarpanel:IridiumIronPlate");
        this.IIconsList[7] = IIconRegister.registerIcon("supersolarpanel:ReinforcedIridiumIronPlate");
        this.IIconsList[8] = IIconRegister.registerIcon("supersolarpanel:IrradiantReinforcedPlate");
        this.IIconsList[9] = IIconRegister.registerIcon("supersolarpanel:SunnariumPart");
        this.IIconsList[10] = IIconRegister.registerIcon("supersolarpanel:IridiumIgnot");
        this.IIconsList[11] = IIconRegister.registerIcon("supersolarpanel:UranIngot");
        this.IIconsList[12] = IIconRegister.registerIcon("supersolarpanel:MTCore");
        this.IIconsList[13] = IIconRegister.registerIcon("supersolarpanel:QuantumCore");
    }
    
    public void getSubItems(final Item item, final CreativeTabs tabs, final List itemList) {
        for (int meta = 0; meta <= this.itemNames.size() - 1; ++meta) {
            final ItemStack stack = new ItemStack((Item)this, 1, meta);
            itemList.add(stack);
        }
    }
    
    public void getSubItems(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        for (int i = 0; i <= this.IIconsList.length - 1; ++i) {
            par3List.add(new ItemStack((Item)this, 1, i));
        }
    }
}
