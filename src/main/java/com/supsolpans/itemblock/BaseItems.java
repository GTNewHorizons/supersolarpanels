package com.supsolpans.itemblock;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.supsolpans.MainSSP;
import com.supsolpans.reference.Reference;

public class BaseItems extends Item {

    public BaseItems() {
        super();
        this.setCreativeTab(MainSSP.tabssp);
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public String getUnlocalizedName() {
        return String
                .format("item.%s%s", Reference.MOD_ID + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        int meta = itemstack.getItemDamage();

        if (meta > 0) {
            return String.format(
                    "item.%s%s",
                    Reference.MOD_ID + ":",
                    getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + meta);
        } else {
            return String.format(
                    "item.%s%s",
                    Reference.MOD_ID + ":",
                    getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
        }
    }

}
