package com.Denfop.block.neutroniumgenerator;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.IC2;
import ic2.core.block.TileEntityBlock;
import ic2.core.init.MainConfig;
import ic2.core.util.ConfigUtil;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.apache.commons.lang3.mutable.MutableObject;
import com.Denfop.item.Neutroniumgen.ItemMachine;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.Base.BlockMultiID;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.NeutroniumGenerator.TileBitGen2;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.utils.InternalName;


public class Blockbitgen extends BlockMultiID {
  public Blockbitgen(InternalName internalName1) {
    super(internalName1, Material.iron, ItemMachine.class);
    setHardness(2.0F);
    setStepSound(soundTypeMetal);
    SuperSolarPanels.massFabricator = new ItemStack((Block)this, 1, 0);
    GameRegistry.registerTileEntity(TileBitGen2.class, "Mass Fabricator1");
  }
  private IIcon[][] iconBuffer;
  public String getTextureFolder(int id) {
    return "machine";
  }
  public void registerBlockIcons(final IIconRegister par1IconRegister) {
      this.iconBuffer = new IIcon[5][12];
        this.iconBuffer[0][0] = par1IconRegister.registerIcon("supersolarpanel:Blockgenbase");
      this.iconBuffer[0][1] = par1IconRegister.registerIcon("supersolarpanel:blockgentop");
      this.iconBuffer[0][2] = par1IconRegister.registerIcon("supersolarpanel:Blockgenbase");
      this.iconBuffer[0][3] = par1IconRegister.registerIcon("supersolarpanel:Blockgenbase");
      this.iconBuffer[0][4] = par1IconRegister.registerIcon("supersolarpanel:Blockgenbase");
      this.iconBuffer[0][5] = par1IconRegister.registerIcon("supersolarpanel:Blockgenbase");
      this.iconBuffer[0][6] = par1IconRegister.registerIcon("supersolarpanel:blockgentop");
      this.iconBuffer[0][7] = par1IconRegister.registerIcon("supersolarpanel:blockgentop");
      this.iconBuffer[0][8] = par1IconRegister.registerIcon("supersolarpanel:Blockgenbase");
      this.iconBuffer[0][9] = par1IconRegister.registerIcon("supersolarpanel:Blockgenbase");
      this.iconBuffer[0][10] = par1IconRegister.registerIcon("supersolarpanel:Blockgenbase");
      this.iconBuffer[0][11] = par1IconRegister.registerIcon("supersolarpanel:Blockgenbase");
    }
  
  public IIcon getIcon(final IBlockAccess world, final int x, final int y, final int z, final int blockSide) {
      final int blockMeta = world.getBlockMetadata(x, y, z);
      final TileEntity te = world.getTileEntity(x, y, z);
      final int facing = (te instanceof TileEntityBase) ? ((TileEntityBase)te).getFacing() : 0;
      if (isActive(world, x, y, z)) {
          return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][facing] + 6];
      }
      return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][facing]];
  }
  
  public IIcon getIcon(final int blockSide, final int blockMeta) {
      return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][3]];
  }
  
  public int damageDropped(int meta) {
    if (ConfigUtil.getBool(MainConfig.get(), "balance/ignoreWrenchRequirement"))
      return meta; 
    switch (meta) {
      case 0:
    } 
    return 0;
  }
  
  public Class<? extends TileEntity> getTeClass(int meta, MutableObject<Class<?>[]> ctorArgTypes, MutableObject<Object[]> ctorArgs) {
    switch (meta) {
      case 0:
        return (Class)TileBitGen2.class;
      
    } 
    return null;
  }
  
  public void randomDisplayTick(World world, int x, int y, int z, Random random) {
    if (!IC2.platform.isRendering())
      return; 
    int meta = world.getBlockMetadata(x, y, z);
    if (meta == 1 && isActive((IBlockAccess)world, x, y, z)) {
      TileEntityBlock te = (TileEntityBlock)getOwnTe((IBlockAccess)world, x, y, z);
      if (te == null)
        return; 
      int facing = te.getFacing();
      float f = x + 0.5F;
      float f1 = y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
      float f2 = z + 0.5F;
      float f3 = 0.52F;
      float f4 = random.nextFloat() * 0.6F - 0.3F;
      switch (facing) {
       
      } 
    } else if (meta == 3 && isActive((IBlockAccess)world, x, y, z)) {
      float f = x + 1.0F;
      float f1 = y + 1.0F;
      float f2 = z + 1.0F;
      for (int i = 0; i < 4; i++) {
        float fmod = -0.2F - random.nextFloat() * 0.6F;
        float f1mod = -0.1F + random.nextFloat() * 0.2F;
        float f2mod = -0.2F - random.nextFloat() * 0.6F;
        world.spawnParticle("smoke", (f + fmod), (f1 + f1mod), (f2 + f2mod), 0.0D, 0.0D, 0.0D);
      } 
    } 
  }
  
  @SideOnly(Side.CLIENT)
  public EnumRarity getRarity(ItemStack stack) {
    return (stack.getItemDamage() == 14) ? EnumRarity.rare : ((stack.getItemDamage() == 15 || stack.getItemDamage() == 13 || stack.getItemDamage() == 12) ? EnumRarity.uncommon : EnumRarity.common);
  }
  
  public boolean hasComparatorInputOverride() {
    return true;
  }
  
  public int getComparatorInputOverride(World world, int x, int y, int z, int side) {
    TileEntityBlock te = (TileEntityBlock)getOwnTe((IBlockAccess)world, x, y, z);
  
    if (te instanceof TileBitGen2)
      return (int)Math.floor(((TileBitGen2)te).energy / 1000000.0D * 15.0D); 
    
    
    return 0;
  }
  
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    if (world.getBlockMetadata(x, y, z) == 15) {
      if (player.isSneaking())
        return false; 
      if (world.isRemote)
        return true; 
     
      return false;
    } 
    return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
  }
}
