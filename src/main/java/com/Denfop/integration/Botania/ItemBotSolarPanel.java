
package com.Denfop.integration.Botania;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

import java.util.List;

import com.Denfop.SuperSolarPanels;
import com.Denfop.api.IPanel;
import com.Denfop.integration.Avaritia.blockAvSolarPanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.item.ItemBlock;

public class ItemBotSolarPanel extends ItemBlock implements IPanel 
{
    private List<String> itemNames;
    
    public ItemBotSolarPanel(final Block b) {
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
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        return this.itemNames.get(itemstack.getItemDamage());
    }
    public void getSubItems(final Item item, final CreativeTabs tabs, final List itemList) {
        for (int meta = 0; meta <= this.itemNames.size() - 1; ++meta) {
            final ItemStack stack = new ItemStack((Item)this, 1, meta);
            NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(stack);
        	TileEntitySolarPanel tile = (TileEntitySolarPanel) blockBotSolarPanel.getBlockEntity(meta);
        	nbt.setInteger("genday", tile.genDay);
        	nbt.setInteger("gennight", tile.genNight);
        	nbt.setInteger("storage", tile.maxStorage);
        	nbt.setInteger("output", tile.production);
            itemList.add(stack);
        }
    }
    public void addItemsNames() {
        this.itemNames.add("blockManasteelSolarPanel");
        this.itemNames.add("blockElementumSolarPanel");
        this.itemNames.add("blockTerrasteelSolarPanel");
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
                return EnumRarity.epic;
            }
           
            default: {
                return EnumRarity.uncommon;
            }
        }
    }
}
