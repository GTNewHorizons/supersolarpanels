package com.Denfop.block.mechanism;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import ic2.core.block.TileEntityBlock;
import ic2.core.block.machine.tileentity.TileEntityCompressor;
import ic2.core.block.machine.tileentity.TileEntityInduction;
import ic2.core.block.machine.tileentity.TileEntityMatter;
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
import com.Denfop.item.Machina.ItemMachine1;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.SuperSolarPanels;
import com.Denfop.block.Base.BlockMultiID;
import com.Denfop.block.TileEntityDoubleMetalFormer.TileEntityDoubleMetalFormer;
import com.Denfop.block.TileEntityTripleMetalFormer.TileEntityTripleMetalFormer;
import com.Denfop.block.advancedmatter.TileEntityAdvancedMatter;
import com.Denfop.block.containerbase.TileEntityTripleMachine;
import com.Denfop.block.doublecompressor.TileEntityDoubleCompressor;
import com.Denfop.block.doubleelecfurnace.TileEntityDoubleElectricFurnace;
import com.Denfop.block.doubleextractor.TileEntityDoubleExtractor;
import com.Denfop.block.doublemacertator.TileEntityDoubleMacerator;
import com.Denfop.block.doublemacertator.TileEntityDoubleMachine;
import com.Denfop.block.improvematter.TileEntityImprovedMatter;
import com.Denfop.block.triplecompressor.TileEntityTripleCompressor;
import com.Denfop.block.tripleelecfurnace.TileEntityTripleElectricFurnace;
import com.Denfop.block.triplemacerator.TileEntityTripleMacerator;
import com.Denfop.block.ultimatematter.TileEntityUltimateMatter;
import com.Denfop.utils.InternalName;

public class BlockMachine extends BlockMultiID {
  public BlockMachine(InternalName internalName1) {
    super(internalName1, Material.iron, ItemMachine1.class);
    setHardness(2.0F);
    setStepSound(soundTypeMetal);
    setCreativeTab(SuperSolarPanels.tabssp);
    SuperSolarPanels.macerator = new ItemStack((Block)this, 1, 1);
    SuperSolarPanels.extractor = new ItemStack((Block)this, 1, 2);
    SuperSolarPanels.compressor = new ItemStack((Block)this, 1, 3);

  

    SuperSolarPanels.compressor1 = new ItemStack((Block)this, 1, 4);
    SuperSolarPanels.massFabricator1 = new ItemStack((Block)this, 1, 5);
    SuperSolarPanels.macerator1 = new ItemStack((Block)this, 1, 6);
    SuperSolarPanels.electroFurnace = new ItemStack((Block)this, 1, 7);
    SuperSolarPanels.electroFurnace1 = new ItemStack((Block)this, 1, 8);
    SuperSolarPanels.massFabricator1 = new ItemStack((Block)this, 1, 9);
    SuperSolarPanels.massFabricator1 = new ItemStack((Block)this, 1, 10);
    SuperSolarPanels.metalformer = new ItemStack((Block)this, 1, 11);
    SuperSolarPanels.metalformer1 = new ItemStack((Block)this, 1, 12);
    SuperSolarPanels.alloymachine = new ItemStack((Block)this, 1, 13);
    GameRegistry.registerTileEntity(TileEntityTripleMacerator.class, "Macerator Triple");
    GameRegistry.registerTileEntity(TileEntityDoubleMacerator.class, "Macerator Double");
    GameRegistry.registerTileEntity(TileEntityDoubleExtractor.class, "Extractor Double");
    GameRegistry.registerTileEntity(TileEntityDoubleCompressor.class, "Compressor Double");
    GameRegistry.registerTileEntity(TileEntityTripleCompressor.class, "Compressor Triple");
    GameRegistry.registerTileEntity(TileEntityDoubleElectricFurnace.class, "Double Electric Furnace");
    GameRegistry.registerTileEntity(TileEntityTripleElectricFurnace.class, "Triple Electric Furnace");
    GameRegistry.registerTileEntity(TileEntityAdvancedMatter.class, "Mass Fabricator Advanced");
    GameRegistry.registerTileEntity(TileEntityImprovedMatter.class, "Mass Fabricator Improved");
    GameRegistry.registerTileEntity(TileEntityUltimateMatter.class, "Mass Fabricator Ultimate");
    GameRegistry.registerTileEntity(TileEntityDoubleMetalFormer.class, "Metal Former Double");
    GameRegistry.registerTileEntity(TileEntityTripleMetalFormer.class, "Metal Former Triple");
  }
  
  public String getTextureFolder(int id) {
    return null;
  }
  
  public int damageDropped(int meta) {
    if (ConfigUtil.getBool(MainConfig.get(), "balance/ignoreWrenchRequirement"))
      return meta; 
    switch (meta) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
        return meta;
    } 
    return meta;
  }
  
  public Class<? extends TileEntity> getTeClass(int meta, MutableObject<Class<?>[]> ctorArgTypes, MutableObject<Object[]> ctorArgs) {
    switch (meta) {
      case 1:
        return (Class)TileEntityDoubleMacerator.class;
      case 2:
        return (Class)TileEntityDoubleExtractor.class;
      case 3:
        return (Class)TileEntityDoubleCompressor.class;
      case 4:
        return (Class)TileEntityTripleCompressor.class;
      case 5:
        return (Class)TileEntityAdvancedMatter.class;
      case 6:
          return (Class)TileEntityTripleMacerator.class; 
      case 7:
          return (Class)TileEntityDoubleElectricFurnace.class;
      case 8:
          return (Class)TileEntityTripleElectricFurnace.class;
      case 9:
          return (Class)TileEntityImprovedMatter.class;
      case 10:
          return (Class)TileEntityUltimateMatter.class;
      case 11:
          return (Class)TileEntityDoubleMetalFormer.class;
      case 12:
          return (Class)TileEntityTripleMetalFormer.class;
    	  
      
    } 
    return null;
  }
  private IIcon[][] iconBuffer;
  public void registerBlockIcons(final IIconRegister par1IconRegister) {
      this.iconBuffer = new IIcon[13][12];
      this.iconBuffer[1][0] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator");
      this.iconBuffer[1][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][2] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator_1");
      this.iconBuffer[1][3] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][6] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator1");
      this.iconBuffer[1][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][8] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator1_3");
      this.iconBuffer[1][9] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[1][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");
      
      this.iconBuffer[2][0] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor_1");
      this.iconBuffer[2][1] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor_1");
      this.iconBuffer[2][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[2][3] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[2][4] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor1");
      this.iconBuffer[2][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[2][6] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor_2");
      this.iconBuffer[2][7] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor_2");
      this.iconBuffer[2][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");
      this.iconBuffer[2][9] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[2][10] = par1IconRegister.registerIcon("supersolarpanel:blockExtractor2");
      this.iconBuffer[2][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");

      this.iconBuffer[3][0] = par1IconRegister.registerIcon("supersolarpanel:blockcompressor_1");
      this.iconBuffer[3][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][3] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][6] = par1IconRegister.registerIcon("supersolarpanel:blockcompressor1_1");
      this.iconBuffer[3][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][9] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[3][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");

      this.iconBuffer[4][0] = par1IconRegister.registerIcon("supersolarpanel:blockcompressor2_1");
      this.iconBuffer[4][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][3] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][6] = par1IconRegister.registerIcon("supersolarpanel:blockcompressor2_2");
      this.iconBuffer[4][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][9] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[4][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2");
      
      this.iconBuffer[5][0] = par1IconRegister.registerIcon("supersolarpanel:blockMatter1_1");
      this.iconBuffer[5][1] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][2] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][3] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][4] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][5] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][6] = par1IconRegister.registerIcon("supersolarpanel:blockMatter1");
      this.iconBuffer[5][7] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][8] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][9] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][10] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
      this.iconBuffer[5][11] = par1IconRegister.registerIcon("supersolarpanel:blockMatter_3");
	  
	   this.iconBuffer[6][0] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator2");
      this.iconBuffer[6][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][2] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator2_1");
      this.iconBuffer[6][3] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][6] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator2_2");
      this.iconBuffer[6][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][8] = par1IconRegister.registerIcon("supersolarpanel:blockMacerator2_3");
      this.iconBuffer[6][9] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[6][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2");
      
	   this.iconBuffer[7][0] = par1IconRegister.registerIcon("supersolarpanel:blockElecFurnace1");
	      this.iconBuffer[7][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][3] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][6] = par1IconRegister.registerIcon("supersolarpanel:blockElecFurnace1_1");
	      this.iconBuffer[7][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");
	      this.iconBuffer[7][9] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
	      this.iconBuffer[7][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");
		  
	   this.iconBuffer[8][0] = par1IconRegister.registerIcon("supersolarpanel:blockElecFurnace2");
      this.iconBuffer[8][1] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[8][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[8][3] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[8][4] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[8][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[8][6] = par1IconRegister.registerIcon("supersolarpanel:blockElecFurnace2_1");
      this.iconBuffer[8][7] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[8][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2");
      this.iconBuffer[8][9] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[8][10] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[8][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2");
	  
      this.iconBuffer[9][0] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2");
      this.iconBuffer[9][1] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
      this.iconBuffer[9][2] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
      this.iconBuffer[9][3] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
      this.iconBuffer[9][4] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
      this.iconBuffer[9][5] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
      this.iconBuffer[9][6] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_1");
      this.iconBuffer[9][7] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
      this.iconBuffer[9][8] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
      this.iconBuffer[9][9] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
      this.iconBuffer[9][10] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
      this.iconBuffer[9][11] = par1IconRegister.registerIcon("supersolarpanel:blockMatter2_2");
      
      this.iconBuffer[10][0] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3");
      this.iconBuffer[10][1] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[10][2] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[10][3] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[10][4] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[10][5] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[10][6] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_1");
      this.iconBuffer[10][7] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[10][8] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[10][9] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[10][10] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
      this.iconBuffer[10][11] = par1IconRegister.registerIcon("supersolarpanel:blockMatter3_2");
     
      this.iconBuffer[11][0] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer_1");
      this.iconBuffer[11][1] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer_1");
      this.iconBuffer[11][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[11][3] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[11][4] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer");
      this.iconBuffer[11][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[11][6] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer1_1");
      this.iconBuffer[11][7] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer1_1");
      this.iconBuffer[11][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1");
      this.iconBuffer[11][9] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_1");
      this.iconBuffer[11][10] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer1");
      this.iconBuffer[11][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_1"); 
	  
      this.iconBuffer[12][0] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer2_1");
      this.iconBuffer[12][1] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer2_1");
      this.iconBuffer[12][2] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[12][3] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[12][4] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer2");
      this.iconBuffer[12][5] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[12][6] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer2_2");
      this.iconBuffer[12][7] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer2_2");
      this.iconBuffer[12][8] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2");
      this.iconBuffer[12][9] = par1IconRegister.registerIcon("supersolarpanel:blockmachine_2");
      this.iconBuffer[12][10] = par1IconRegister.registerIcon("supersolarpanel:blockMetalFormer2_3");
      this.iconBuffer[12][11] = par1IconRegister.registerIcon("supersolarpanel:blockmachineside_2"); 
	 



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
      return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][0]];
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
        case 2:
          world.spawnParticle("smoke", (f - f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
          world.spawnParticle("flame", (f - f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
          break;
        case 3:
          world.spawnParticle("smoke", (f + f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
          world.spawnParticle("flame", (f + f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
          break;
        
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
    if (te == null)
      return 0; 
    if (te instanceof TileEntityDoubleMachine) {
    	TileEntityDoubleMachine tem = (TileEntityDoubleMachine)te;
        return (int)Math.floor((tem.getProgress() * 15.0F));
    }
    if (te instanceof TileEntityTripleMachine) {
    	TileEntityTripleMachine tem = (TileEntityTripleMachine)te;
        return (int)Math.floor((tem.getProgress() * 15.0F));
    }
    if (te instanceof TileEntityMatter)
      return (int)Math.floor(((TileEntityMatter)te).energy / 1000000.0D * 15.0D); 
  
      
     
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
