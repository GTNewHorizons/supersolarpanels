
package com.Denfop.block.Sintezator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

import com.Denfop.Config;
import com.Denfop.SuperSolarPanels;

import net.minecraft.item.ItemBlock;

public class ItemSintezator extends ItemBlock
{
    private List<String> itemNames;
    
    public ItemSintezator(final Block b) {
        super(b);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.itemNames = new ArrayList<String>();
        this.addItemsNames();
        this.setCreativeTab(SuperSolarPanels.tabssp);
    }
    
    public int getMetadata(final int i) {
        return i;
    }
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
        NBTTagCompound nbttagcompound;
        
        
        	   info.add(StatCollector.translateToLocal("ssp.sintezator") + Config.limit);
            }
    public String getUnlocalizedName(final ItemStack itemstack) {
        return this.itemNames.get(itemstack.getItemDamage());
    }
    
    public void addItemsNames() {
        this.itemNames.add("blockSintezator");
    }
    
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(final ItemStack itemstack) {
        final int i = itemstack.getItemDamage();
        switch (i) {
            case 0: {
                return EnumRarity.epic;
            }
            
            
           
            default: {
                return EnumRarity.uncommon;
            }
        }
    }
}
