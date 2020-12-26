

package com.Denfop;

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

public class module5 extends Item
{
    private List<String> itemNames;
    private IIcon[] IIconsList;
    private int itemsCount;
    
    public module5() {
        this.itemNames = new ArrayList<String>();
        this.IIconsList = new IIcon[7];
        this.itemsCount = 6;
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
        this.itemNames.add("module51");
        this.itemNames.add("module52");
        this.itemNames.add("module53");
        this.itemNames.add("module54");
        this.itemNames.add("module55");
        this.itemNames.add("module56");
        this.itemNames.add("module57");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister IIconRegister) {
        this.IIconsList[0] = IIconRegister.registerIcon("supersolarpanel:module51");
        this.IIconsList[1] = IIconRegister.registerIcon("supersolarpanel:module52");
        this.IIconsList[2] = IIconRegister.registerIcon("supersolarpanel:module53");
        this.IIconsList[3] = IIconRegister.registerIcon("supersolarpanel:module54");
        this.IIconsList[4] = IIconRegister.registerIcon("supersolarpanel:module55");
        this.IIconsList[5] = IIconRegister.registerIcon("supersolarpanel:module56");
        this.IIconsList[6] = IIconRegister.registerIcon("supersolarpanel:module57");

    }
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
        NBTTagCompound nbttagcompound;
        int meta = itemStack.getItemDamage();
        switch (meta) {
          case 0:
        	  info.add(StatCollector.translateToLocal("ssp.modules12"));
        	  info.add(StatCollector.translateToLocal("aerpanel") );
              
          
            break;
          case 1:
        	  info.add(StatCollector.translateToLocal("ssp.modules12"));
        	  info.add(StatCollector.translateToLocal("earthpanel") );   break;
          case 2:
        	  info.add(StatCollector.translateToLocal("ssp.modules12"));
        	  info.add(StatCollector.translateToLocal("netherpanel") );           break;
          case 3:
        	  info.add(StatCollector.translateToLocal("ssp.modules12"));
        	  info.add(StatCollector.translateToLocal("endpanel") );          break;
          case 4:
        	  info.add(StatCollector.translateToLocal("ssp.modules12"));
        	  info.add(StatCollector.translateToLocal("nightpanel") );          break;
          case 5:
        	  info.add(StatCollector.translateToLocal("ssp.modules12"));
        	  info.add(StatCollector.translateToLocal("sunpanel") );         break;
          case 6:
        	  info.add(StatCollector.translateToLocal("ssp.modules12"));
        	  info.add(StatCollector.translateToLocal("rainpanel") );         break;
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
