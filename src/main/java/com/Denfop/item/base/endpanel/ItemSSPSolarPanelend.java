// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.item.base.endpanel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.util.StackUtil;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

import com.Denfop.SuperSolarPanels;

import net.minecraft.item.ItemBlock;

public class ItemSSPSolarPanelend extends ItemBlock
{
    private List<String> itemNames;
    
    public ItemSSPSolarPanelend(final Block b) {
        super(b);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.itemNames = new ArrayList<String>();
        this.addItemsNames();
    }
    
    public int getMetadata(final int i) {
        return i;
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        return this.itemNames.get(itemstack.getItemDamage());
    }
    
    public void addItemsNames() {
        this.itemNames.add("blockSpectralSolarPanel3");
        this.itemNames.add("blockSingularSolarPanel3");
        this.itemNames.add("blockPhotonicSolarPanel3");
        this.itemNames.add("blockAdminSolarPanel3");
        this.itemNames.add("blockNeutronSolarPanel3");
        this.itemNames.add("blockProtonSolarPanel3");
    }
    
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
        NBTTagCompound nbttagcompound;
        int meta = itemStack.getItemDamage();
        switch (meta) {
          case 0:
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.spectralpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.spectralpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.spectralpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.spectralpanelstorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.spectralpaneltier);
            
            break;
          case 1:
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.singularpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.singularpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.singularpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.singularpanelstorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.singularpaneltier);
            break;
          case 2:
         	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.photonicpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.photonicpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.photonicpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.photonicpanelStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.photonicpaneltier);
            break;
          case 3:
         	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.adminpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.adminpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.AdminpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.AdminpanelStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.adminpaneltier);
            break;
          case 4:
          	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.neutronpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.neutronpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " + SuperSolarPanels.neutronpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.neutronpanelStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.neutronpaneltier);
          break;
       
        } 
        switch (meta) {
          case 9:
          case 8:
            nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Store") + " " + nbttagcompound.getInteger("energy") + " EU");
            break;
        }}
        @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(final ItemStack itemstack) {
        final int i = itemstack.getItemDamage();
        switch (i) {
            case 0: {
                return EnumRarity.uncommon;
            }
            case 1: {
                return EnumRarity.rare;
            }
            case 2: {
                return EnumRarity.epic;
            }
            case 3: {
                return EnumRarity.epic;
            }
            case 4: {
                return EnumRarity.epic;
            }
            default: {
                return EnumRarity.uncommon;
            }
        }
    }
}
