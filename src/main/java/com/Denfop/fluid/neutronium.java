package com.Denfop.fluid;

import com.Denfop.SuperSolarPanels;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class neutronium extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
    
    public neutronium(Fluid fluid, net.minecraft.block.material.Material water) {
            super(fluid, (net.minecraft.block.material.Material) water);
            setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp);
/*
Вы можете создать дополнительные настройки, такие как
this.setLuminosity(Выбрать число 0-15);
Светимость жидкости.
this.setDensity(1000);
Заменяет ли жидкость другую.
This.setViskosity(6000 и меньше);
Как быстро жидкость течет.
this.setGaseos(false или true)
сделать жидкость газовообразной.
*/

    }
    
    @Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon("supersolarpanel:NeuntroniumStill");
            flowingIcon = register.registerIcon("supersolarpanel:NeuntroniumFlowing");
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
    
}