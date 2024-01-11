package com.supsolpans.itemblock;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

import com.supsolpans.ConfigLoader;

public class ItemBlockPhotonSP extends ItemBlock {

    public ItemBlockPhotonSP(Block b) {
        super(b);

    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        if (itemstack != null) {
            return this.field_150939_a.getUnlocalizedName();
        }

        return this.field_150939_a.getUnlocalizedName();
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            list.add(StatCollector.translateToLocal("PhotonSp-description"));
            list.add(
                    StatCollector.translateToLocal("supsolpans.all.GenerationDay")
                            + Integer.toString(ConfigLoader.photonicpanelGenDay)
                            + " EU/t");
            list.add(
                    StatCollector.translateToLocal("supsolpans.all.GenerationNight")
                            + Integer.toString(ConfigLoader.photonicpanelGenNight)
                            + " EU/t");
            list.add(
                    StatCollector.translateToLocal("supsolpans.all.Output")
                            + Integer.toString(ConfigLoader.photonicpanelOutput)
                            + " EU/t");
            list.add(
                    StatCollector.translateToLocal("supsolpans.all.Storage")
                            + Integer.toString(ConfigLoader.photonicpanelStorage)
                            + " EU");
        } else list.add(StatCollector.translateToLocal("supsolpans.all.PressShift"));
    }

}
