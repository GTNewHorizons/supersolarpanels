package com.Denfop.block.Base;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import ic2.core.util.LiquidUtil;
import ic2.core.util.StackUtil;
import java.util.Random;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.base.ItemBlockIC2;
import com.Denfop.utils.InternalName;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlockIC2Fluid extends BlockFluidClassic {
  protected IIcon[] fluidIcon;
  
  protected Fluid fluid;
  
  private final int color;
  
  public BlockIC2Fluid(InternalName internalName, Fluid fluid, Material material, int color) {
    super(fluid, material);
    if (!fluid.getName().startsWith("ic3"))
      throw new RuntimeException("Invalid fluid name: " + fluid.getName()); 
    setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp);
    setBlockName(internalName.name());
    GameRegistry.registerBlock((Block)this, ItemBlockIC2.class, internalName.name());
    this.fluid = fluid;
    this.color = color;
    
  }
  
  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister iconRegister) {
	  
    String name = this.fluidName.substring("ic3".length());
      if (this.fluid.equals(BlocksItems.getFluid(InternalName.fluidUuMatter))) {
        this
          
          .fluidIcon = new IIcon[] { iconRegister.registerIcon(SuperSolarPanels.TEXTURES + ":blocks/" + name + "_still"), iconRegister.registerIcon(SuperSolarPanels.TEXTURES + ":blocks/" + name + "_flow") };
      } else {
        this
          
          .fluidIcon = new IIcon[] { iconRegister.registerIcon(SuperSolarPanels.TEXTURES + ":blocks/" + name + "_still"), iconRegister.registerIcon(SuperSolarPanels.TEXTURES + ":blocks/" + name + "_flow") };
       
    }
   
  }
  
  public void updateTick(World world, int x, int y, int z, Random random) {
    super.updateTick(world, x, y, z, random);
      }
  
  public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
    super.onNeighborBlockChange(world, x, y, z, block);
    hardenFromNeighbors(world, x, y, z);
  }
  
  public void onBlockAdded(World world, int x, int y, int z) {
    super.onBlockAdded(world, x, y, z);
    hardenFromNeighbors(world, x, y, z);
  }
  
  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
    if (!IC2.platform.isSimulating())
      return; 
   
  }
  
  public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity, int x, int y, int z, int oldMeta) {
    if (!IC2.platform.isSimulating())
      return; 
   

  }
  
  
  public IIcon getIcon(int side, int meta) {
    return (side != 0 && side != 1) ? this.fluidIcon[1] : this.fluidIcon[0];
  }
  
  public String getUnlocalizedName() {
    return super.getUnlocalizedName().substring(5);
  }
  
  public int getColor() {
    return this.color;
  }
  
  private boolean hardenFromNeighbors(World world, int x, int y, int z) {
    if (!IC2.platform.isSimulating())
      return false; 
   
      for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
        LiquidUtil.LiquidData data = LiquidUtil.getLiquid(world, x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);
        if (data != null && data.liquid
          .getTemperature() <= this.fluid.getTemperature() / 4) {
          if (isSourceBlock((IBlockAccess)world, x, y, z)) {
            world.setBlock(x, y, z, StackUtil.getBlock(Ic2Items.basaltBlock));
          } else {
            world.setBlockToAir(x, y, z);
          } 
          return true;
        } 
      }  
    return false;
  }
}
