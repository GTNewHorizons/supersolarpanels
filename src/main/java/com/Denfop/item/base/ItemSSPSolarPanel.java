
package com.Denfop.item.base;

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

public class ItemSSPSolarPanel extends ItemBlock 
{
    private List<String> itemNames;
    
    public ItemSSPSolarPanel(final Block b) {
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
        this.itemNames.add("blockAdvancedSolarPanel");
        this.itemNames.add("blockHybridSolarPanel");
        this.itemNames.add("blockUltimateSolarPanel");
        this.itemNames.add("blockQuantumSolarPanel");
        this.itemNames.add("blockSpectralSolarPanel");
        this.itemNames.add("blockProtonSolarPanel");
        this.itemNames.add("blockSingularSolarPanel");
        this.itemNames.add("blockAdminSolarPanel");
        this.itemNames.add("blockPhotonicSolarPanel");
        this.itemNames.add("blockNeutronSolarPanel");
       
    }
    
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
        NBTTagCompound nbttagcompound;
        int meta = itemStack.getItemDamage();
        switch (meta) {
        case 0:
      	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.advGenDay  + " EU/t " );
      	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.advGenNight  + " EU/t " );
            
          info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.advOutput  + " EU/t " );
          info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.advStorage + " EU ");
          info.add(StatCollector.translateToLocal("ssp.tier") + "1");
          
          break;
        case 1:
      	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.hGenDay  + " EU/t " );
      	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.hGenNight  + " EU/t " );
            
          info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.hOutput  + " EU/t " );
          info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.hStorage + " EU ");
          info.add(StatCollector.translateToLocal("ssp.tier") + "2");
          break;
        case 2:
       	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.uhGenDay  + " EU/t " );
      	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.uhGenNight  + " EU/t " );
            
          info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.uhOutput  + " EU/t " );
          info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.uhStorage + " EU ");
          info.add(StatCollector.translateToLocal("ssp.tier") + "3");
          break;
        case 3:
       	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.qpGenDay  + " EU/t " );
      	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.qpGenNight  + " EU/t " );
            
          info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.qpOutput  + " EU/t " );
          info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.qpStorage + " EU ");
          info.add(StatCollector.translateToLocal("ssp.tier") + "4");
          break;
          case 4:
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.spectralpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.spectralpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.spectralpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.spectralpanelstorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.spectralpaneltier);
            
            break;
          case 6:
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.singularpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.singularpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.singularpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.singularpanelstorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.singularpaneltier);
            break;
          case 8:
         	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.photonicpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.photonicpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.photonicpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.photonicpanelStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.photonicpaneltier);
            break;
          case 7:
         	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.adminpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.adminpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.AdminpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.AdminpanelStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.adminpaneltier);
            break;
          case 9:
          	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.neutronpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.neutronpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " + SuperSolarPanels.neutronpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.neutronpanelStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.neutronpaneltier);
          break;
          case 5:
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.protongenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.protongennitht  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.protonOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.protontier + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + "6");
            break;
       
        } 
        }
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
                return EnumRarity.rare;
            }
            case 3: {
                return EnumRarity.epic;
            }
            case 4: {
                return EnumRarity.epic;
            }
        
        case 5: {
            return EnumRarity.rare;
        }
        case 6: {
            return EnumRarity.epic;
        }
        case 7: {
            return EnumRarity.epic;
        }
        case 8: {
            return EnumRarity.epic;
        }
          
        case 9: {
            return EnumRarity.epic;
        }
           default: {
                return EnumRarity.uncommon;
            }
        }
    }

		

		
}
