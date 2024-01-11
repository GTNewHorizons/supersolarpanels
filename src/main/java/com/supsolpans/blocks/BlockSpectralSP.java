package com.supsolpans.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.supsolpans.MainSSP;
import com.supsolpans.tiles.TileSpectralSolarPanel;

import advsolar.common.AdvancedSolarPanel;

public class BlockSpectralSP extends AbstractSSP {

    private IIcon[][] icons;

    public BlockSpectralSP() {
        super(Material.rock);
        this.setBlockName("BlockSpectralSP");
        this.setStepSound(soundTypeMetal);
        this.setHardness(3F);
        this.setCreativeTab(MainSSP.tabssp);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        switch (meta) {

            case 1:
                return new TileSpectralSolarPanel();

            default:
                return new TileSpectralSolarPanel();
        }
    }

    public void registerBlockIcons(IIconRegister reg) {
        this.icons = new IIcon[2][6];
        this.icons[0][0] = reg.registerIcon("supersolarpanel:ssp_bottom");
        this.icons[0][1] = reg.registerIcon("supersolarpanel:ssp_top");
        this.icons[0][2] = reg.registerIcon("supersolarpanel:ssp_side");
        this.icons[0][3] = reg.registerIcon("supersolarpanel:ssp_side");
        this.icons[0][4] = reg.registerIcon("supersolarpanel:ssp_side");
        this.icons[0][5] = reg.registerIcon("supersolarpanel:ssp_side");
        this.icons[1][0] = reg.registerIcon("supersolarpanel:spsp_bottom");
        this.icons[1][1] = reg.registerIcon("supersolarpanel:spsp_top");
        this.icons[1][2] = reg.registerIcon("supersolarpanel:spsp_side");
        this.icons[1][3] = reg.registerIcon("supersolarpanel:spsp_side");
        this.icons[1][4] = reg.registerIcon("supersolarpanel:spsp_side");
        this.icons[1][5] = reg.registerIcon("supersolarpanel:spsp_side");
    }

    public IIcon getIcon(int side, int metadata) {
        switch (side) {
            case 0:
                return this.icons[1][0];
            case 1:
                return this.icons[1][1];
            case 2:
                if (metadata == 2) return this.icons[1][2];
                else return this.icons[1][2];
            case 3:
                return this.icons[1][2];
            case 4:
                return this.icons[1][2];
            case 5:
                return this.icons[1][2];
        }

        return this.icons[1][1];
    }

    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int s, float f1, float f2,
            float f3) {
        if (player.isSneaking()) {
            return false;
        } else if (world.isRemote) {
            return true;
        } else {
            TileEntity tileentity = world.getTileEntity(i, j, k);
            if (tileentity != null) {
                player.openGui(AdvancedSolarPanel.instance, 1, world, i, j, k);
            }

            return true;
        }
    }

}
