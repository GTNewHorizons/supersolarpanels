

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

public class module6 extends Item
{
    private List<String> itemNames;
    private IIcon[] IIconsList;
    private int itemsCount;
    
    public module6() {
        this.itemNames = new ArrayList<String>();
        this.IIconsList = new IIcon[10];
        this.itemsCount = 9;
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
        switch (meta) {
          case 0:
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.advGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.advGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.advOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.advStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + "1");
            info.add(StatCollector.translateToLocal("ssp.modules1") );
            break;
          case 1:
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.hGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.hGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.hOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.hStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + "2");
            info.add(StatCollector.translateToLocal("ssp.modules1") );
            break;
          case 2:
         	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.uhGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.uhGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.uhOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.uhStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + "3");
            info.add(StatCollector.translateToLocal("ssp.modules1") );
            break;
          case 3:
         	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.qpGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.qpGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.qpOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.qpStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + "4");
            info.add(StatCollector.translateToLocal("ssp.modules1") );
            break;
          case 4:
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.spectralpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.spectralpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.spectralpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.spectralpanelstorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.spectralpaneltier);
            info.add(StatCollector.translateToLocal("ssp.modules1") );
          break;
          case 5:
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.protongenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.protongennitht  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.protonOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.AdminpanelStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + " 6");
            info.add(StatCollector.translateToLocal("ssp.modules1") );
            break;
          case 6:
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.singularpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.singularpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.singularpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.singularpanelstorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.singularpaneltier);
            info.add(StatCollector.translateToLocal("ssp.modules1") );
            break;
          case 7:
         	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.photonicpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.photonicpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.photonicpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.photonicpanelStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.photonicpaneltier);
            info.add(StatCollector.translateToLocal("ssp.modules1") );
            break;
          case 8:
         	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.adminpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.adminpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " +SuperSolarPanels.AdminpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.AdminpanelStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.adminpaneltier);
            info.add(StatCollector.translateToLocal("ssp.modules1") );
            break;
          case 9:
          	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationDay.tooltip") + " " + SuperSolarPanels.neutronpanelGenDay  + " EU/t " );
        	  info.add(StatCollector.translateToLocal("supsolpans.SSP.GenerationNight.tooltip") + " " + SuperSolarPanels.neutronpanelGenNight  + " EU/t " );
              
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Output") + " " + SuperSolarPanels.neutronpanelOutput  + " EU/t " );
            info.add(StatCollector.translateToLocal("ic2.item.tooltip.Capacity") + " " + SuperSolarPanels.neutronpanelStorage + " EU ");
            info.add(StatCollector.translateToLocal("ssp.tier") + SuperSolarPanels.neutronpaneltier);
            info.add(StatCollector.translateToLocal("ssp.modules1") );
          break;
        } }
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
            itemList.add(stack);
        }
    }
    public static int GenDay(int meta) {
    	
    	if(meta == 0) {
		return SuperSolarPanels.advGenDay;
		}
    	else if(meta ==1) {
    		return SuperSolarPanels.hGenDay;
    	}
    	else if(meta ==2) {
    		return SuperSolarPanels.uhGenDay;
    	}
    	else if(meta ==3) {
    		return SuperSolarPanels.qpGenDay;
    	}
    	else if(meta ==4) {
    		return SuperSolarPanels.spectralpanelGenDay;
    	}
    	else if(meta ==5) {
    		return SuperSolarPanels.protongenDay;
    	}
    	else if(meta ==6) {
    		return SuperSolarPanels.singularpanelGenDay;
    	}
    	else if(meta ==7) {
    		return SuperSolarPanels.adminpanelGenDay;
    	}
    	else if(meta ==8) {
    		return SuperSolarPanels.photonicpanelGenDay;
    	}
    	else if(meta ==9) {
    		return SuperSolarPanels.neutronpanelGenDay;
    	}
    	return 0;
    	
    }
public static int GenNight(int meta) {
    	
    	if(meta == 0) {
		return SuperSolarPanels.advGenNight;
		}
    	else if(meta ==1) {
    		return SuperSolarPanels.hGenNight;
    	}
    	else if(meta ==2) {
    		return SuperSolarPanels.uhGenNight;
    	}
    	else if(meta ==3) {
    		return SuperSolarPanels.qpGenNight;
    	}
    	else if(meta ==4) {
    		return SuperSolarPanels.spectralpanelGenNight;
    	}
    	else if(meta ==5) {
    		return SuperSolarPanels.protongennitht;
    	}
    	else if(meta ==6) {
    		return SuperSolarPanels.singularpanelGenNight;
    	}
    	else if(meta ==7) {
    		return SuperSolarPanels.adminpanelGenNight;
    	}
    	else if(meta ==8) {
    		return SuperSolarPanels.photonicpanelGenNight;
    	}
    	else if(meta ==9) {
    		return SuperSolarPanels.neutronpanelGenNight;
    	}
    	return 0;
    	
    }
public static int Output(int meta) {
	
	if(meta == 0) {
	return SuperSolarPanels.advOutput;
	}
	else if(meta ==1) {
		return SuperSolarPanels.hOutput;
	}
	else if(meta ==2) {
		return SuperSolarPanels.uhOutput;
	}
	else if(meta ==3) {
		return SuperSolarPanels.qpOutput;
	}
	else if(meta ==4) {
		return SuperSolarPanels.spectralpanelOutput;
	}
	else if(meta ==5) {
		return SuperSolarPanels.protonOutput;
	}
	else if(meta ==6) {
		return SuperSolarPanels.singularpanelOutput;
	}
	else if(meta ==7) {
		return SuperSolarPanels.AdminpanelOutput;
	}
	else if(meta ==8) {
		return SuperSolarPanels.photonicpanelOutput;
	}
	else if(meta ==9) {
		return SuperSolarPanels.neutronpanelOutput;
	}
	return 0;
	
}
public static int storage(int meta) {
	
	if(meta == 0) {
	return SuperSolarPanels.advStorage;
	}
	else if(meta ==1) {
		return SuperSolarPanels.hStorage;
	}
	else if(meta ==2) {
		return SuperSolarPanels.uhStorage;
	}
	else if(meta ==3) {
		return SuperSolarPanels.qpStorage;
	}
	else if(meta ==4) {
		return SuperSolarPanels.spectralpanelstorage;
	}
	else if(meta ==5) {
		return SuperSolarPanels.protontier;
	}
	else if(meta ==6) {
		return SuperSolarPanels.singularpanelstorage;
	}
	else if(meta ==7) {
		return SuperSolarPanels.AdminpanelStorage;
	}
	else if(meta ==8) {
		return SuperSolarPanels.photonicpanelStorage;
	}
	else if(meta ==9) {
		return SuperSolarPanels.neutronpanelStorage;
	}
	return 0;
	
}
    public void getSubItems(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        for (int i = 0; i <= this.IIconsList.length - 1; ++i) {
            par3List.add(new ItemStack((Item)this, 1, i));
        }
    }
}
