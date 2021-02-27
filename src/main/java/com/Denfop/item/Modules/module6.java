

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
import com.Denfop.api.IPanel;
import com.Denfop.api.module.IModulPanel;
import com.Denfop.block.Base.BlockSSPSolarPanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.item.Item;

public class module6 extends Item implements IModulPanel
{
    private List<String> itemNames;
    private IIcon[] IIconsList;
    private int itemsCount;
    
    public module6() {
        this.itemNames = new ArrayList<String>();
        this.IIconsList = new IIcon[10];
        this.itemsCount = 9;
        this.setHasSubtypes(true);
        this.setCreativeTab(SuperSolarPanels.tabssp1);
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
        this.itemNames.add("module61");
        this.itemNames.add("module62");
        this.itemNames.add("module63");
        this.itemNames.add("module64");
        this.itemNames.add("module65");
        this.itemNames.add("module66");
        this.itemNames.add("module67");
        this.itemNames.add("module68");
        this.itemNames.add("module69");
        this.itemNames.add("module70");
    }
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
        NBTTagCompound nbttagcompound;
        int meta = itemStack.getItemDamage();
        NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(itemStack);
       
        TileEntitySolarPanel tile = (TileEntitySolarPanel) BlockSSPSolarPanel.getBlockEntity(meta);
    int day=	nbt.getInteger("genday");
    int night =	nbt.getInteger("gennight");
    int storage =	nbt.getInteger("storage");
   int output = 	nbt.getInteger("output");
   int tier = 	nbt.getInteger("tier");
    	
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + day  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + night  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +output  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + storage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + tier);
            info.add(StatCollector.translateToLocal("ssp.modules1") );
            info.add(StatCollector.translateToLocal("ssp.modules2") );
            }
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister IIconRegister) {
        this.IIconsList[0] = IIconRegister.registerIcon("supersolarpanel:module61");
        this.IIconsList[1] = IIconRegister.registerIcon("supersolarpanel:module62");
        this.IIconsList[2] = IIconRegister.registerIcon("supersolarpanel:module63");
        this.IIconsList[3] = IIconRegister.registerIcon("supersolarpanel:module64");
        this.IIconsList[4] = IIconRegister.registerIcon("supersolarpanel:module65");
        this.IIconsList[5] = IIconRegister.registerIcon("supersolarpanel:module66");
        this.IIconsList[6] = IIconRegister.registerIcon("supersolarpanel:module67");
        this.IIconsList[7] = IIconRegister.registerIcon("supersolarpanel:module68");
        this.IIconsList[8] = IIconRegister.registerIcon("supersolarpanel:module69");
        this.IIconsList[9] = IIconRegister.registerIcon("supersolarpanel:module70");

    }
    
    public void getSubItems(final Item item, final CreativeTabs tabs, final List itemList) {
        for (int meta = 0; meta <= this.itemNames.size() - 1; ++meta) {
            final ItemStack stack = new ItemStack((Item)this, 1, meta);
            
            TileEntitySolarPanel tile = (TileEntitySolarPanel) BlockSSPSolarPanel.getBlockEntity(meta);
            IModulPanel.setData(stack, meta, tile);
            itemList.add(stack);
        }
    }
   
   
   
}
