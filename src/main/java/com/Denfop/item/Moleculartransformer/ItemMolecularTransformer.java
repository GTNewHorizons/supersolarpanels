
package com.Denfop.item.Moleculartransformer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemMolecularTransformer extends ItemBlock
{
    public ItemMolecularTransformer(final Block b) {
        super(b);
        this.setMaxDamage(0);
        this.setHasSubtypes(false);
    }
    
    public String func_77667_c(final ItemStack itemstack) {
        return "blockMolecularTransformer";
    }
    
    public int func_77647_b(final int i) {
        return i;
    }
    
    @SideOnly(Side.CLIENT)
    public EnumRarity func_77613_e(final ItemStack itemstack) {
        return EnumRarity.rare;
    }
}
