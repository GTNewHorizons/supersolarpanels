

package com.Denfop.item.Modules;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.item.Item;

public class module7 extends Item
{
    private List<String> itemNames;
    private IIcon[] IIconsList;
    private int itemsCount;
    
    public module7() {
        this.itemNames = new ArrayList<String>();
        this.IIconsList = new IIcon[6];
        this.itemsCount = 5;
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
        this.itemNames.add("module71");
        this.itemNames.add("module72");
        this.itemNames.add("module73");
        this.itemNames.add("module74");
        this.itemNames.add("module75");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister IIconRegister) {
        this.IIconsList[0] = IIconRegister.registerIcon("supersolarpanel:module71");
        this.IIconsList[1] = IIconRegister.registerIcon("supersolarpanel:module72");
        this.IIconsList[2] = IIconRegister.registerIcon("supersolarpanel:module73");
        this.IIconsList[3] = IIconRegister.registerIcon("supersolarpanel:module74");
        this.IIconsList[4] = IIconRegister.registerIcon("supersolarpanel:module75");

    }
  public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
        NBTTagCompound nbttagcompound;
        int meta = itemStack.getItemDamage();
        switch (meta) {
          case 0:
        	  info.add(StatCollector.translateToLocal("ssp.modules"));
        	  info.add(StatCollector.translateToLocal("wirelles") );
              
          
            break;
          case 1:
        	  info.add(StatCollector.translateToLocal("ssp.modules"));
        	  info.add(StatCollector.translateToLocal("transformator") );   break;
          case 2:
        	  info.add(StatCollector.translateToLocal("ssp.modules"));
        	  info.add(StatCollector.translateToLocal("transformator1") );           break;
         
         }}
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
