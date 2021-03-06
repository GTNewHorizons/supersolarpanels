package ic2.core.block.wiring;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.core.IC2;
import ic2.core.IHasGui;
import ic2.core.Ic2Items;
import ic2.core.block.BlockMultiID;
import ic2.core.block.TileEntityBlock;
import ic2.core.init.InternalName;
import ic2.core.init.MainConfig;
import ic2.core.item.block.ItemElectricBlock;
import ic2.core.util.ConfigUtil;
import ic2.core.util.StackUtil;
import ic2.core.util.Util;
import java.util.Random;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.Modules.module7;
import com.Denfop.tiles.base.TileEntityElectricBlock;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.apache.commons.lang3.mutable.MutableObject;

public class BlockElectric extends BlockMultiID {
  public BlockElectric(InternalName internalName1) {
    super(internalName1, Material.iron, ItemElectricBlock.class);
    setHardness(1.5F);
    setStepSound(soundTypeMetal);
    Ic2Items.batBox = new ItemStack((Block)this, 1, 0);
    Ic2Items.mfeUnit = new ItemStack((Block)this, 1, 1);
    Ic2Items.mfsUnit = new ItemStack((Block)this, 1, 2);
    Ic2Items.lvTransformer = new ItemStack((Block)this, 1, 3);
    Ic2Items.mvTransformer = new ItemStack((Block)this, 1, 4);
    Ic2Items.hvTransformer = new ItemStack((Block)this, 1, 5);
    Ic2Items.evTransformer = new ItemStack((Block)this, 1, 6);
    Ic2Items.cesuUnit = new ItemStack((Block)this, 1, 7);
    GameRegistry.registerTileEntity(TileEntityElectricBatBox.class, "BatBox");
    GameRegistry.registerTileEntity(TileEntityElectricCESU.class, "CESU");
    GameRegistry.registerTileEntity(TileEntityElectricMFE.class, "MFE");
    GameRegistry.registerTileEntity(TileEntityElectricMFSU.class, "MFSU");
    GameRegistry.registerTileEntity(TileEntityTransformerLV.class, "LV-Transformer");
    GameRegistry.registerTileEntity(TileEntityTransformerMV.class, "MV-Transformer");
    GameRegistry.registerTileEntity(TileEntityTransformerHV.class, "HV-Transformer");
    GameRegistry.registerTileEntity(TileEntityTransformerEV.class, "EV-Transformer");
   setBlockUnbreakable();
  }
  
  public String getTextureFolder(int id) {
    return "wiring";
  }
  
  public Item getItemDropped(int meta, Random random, int fortune) {
    if (ConfigUtil.getBool(MainConfig.get(), "balance/ignoreWrenchRequirement"))
      return Item.getItemFromBlock((Block)this); 
    switch (meta) {
      case 0:
      case 3:
        return Item.getItemFromBlock((Block)this);
    } 
    return Ic2Items.machine.getItem();
  }
  
  public int damageDropped(int meta) {
    if (ConfigUtil.getBool(MainConfig.get(), "balance/ignoreWrenchRequirement"))
      return meta; 
    switch (meta) {
      case 0:
      case 3:
        return meta;
    } 
    return Ic2Items.machine.getItemDamage();
  }
  
  public int quantityDropped(Random random) {
    return 1;
  }
  
  
  
  public boolean canProvidePower() {
    return true;
  }
  
  public boolean isNormalCube(IBlockAccess world, int i, int j, int k) {
    return false;
  }
  
  public boolean isBlockOpaqueCube(World world, int i, int j, int k) {
    return true;
  }
  
  public boolean isBlockSolid(IBlockAccess world, int x, int y, int z, int side) {
    return true;
  }
  
  @Override
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float a, float b, float c) {
    if (entityPlayer.isSneaking())
      return false; 
    TileEntity te = getOwnTe((IBlockAccess)world, x, y, z);
    if (te instanceof IHasGui) 
    {
      if (IC2.platform.isSimulating()) {
    	  
    	  final TileEntity tileentity = world.getTileEntity(x, y, z);
    	  if(tileentity instanceof TileEntityElectricBlock) {
    		  
    		  if(world.getTileEntity(x, y, z) instanceof TileEntityElectricBlock) {
            		TileEntityElectricBlock	tile = (TileEntityElectricBlock) world.getTileEntity(x, y, z);
            		
            		if(tile.chargeSlots[0] != null&& tile.chargeSlots[0].getItem() instanceof module7&& tile.chargeSlots[0].getItemDamage() == 0 && tile.UUID == entityPlayer.getDisplayName()) {
            			 return IC2.platform.launchGui(entityPlayer, (IHasGui)te);
            				 
            			
            				
            				
               }else {
            	   if(tile.personality == false) {
              
            		   return IC2.platform.launchGui(entityPlayer, (IHasGui)te);}else {
                	
                	
                }}
            		
            		
            		}
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  }
    	  }
    	  else {
        return IC2.platform.launchGui(entityPlayer, (IHasGui)te); }
      return true;
    } 
    return false;
  }

      
  public Class<? extends TileEntity> getTeClass(int meta, MutableObject<Class<?>[]> ctorArgTypes, MutableObject<Object[]> ctorArgs) {
    switch (meta) {
      case 0:
        return (Class)TileEntityElectricBatBox.class;
      case 1:
        return (Class)TileEntityElectricMFE.class;
      case 2:
        return (Class)TileEntityElectricMFSU.class;
      case 3:
        return (Class)TileEntityTransformerLV.class;
      case 4:
        return (Class)TileEntityTransformerMV.class;
      case 5:
        return (Class)TileEntityTransformerHV.class;
      case 6:
        return (Class)TileEntityTransformerEV.class;
      case 7:
        return (Class)TileEntityElectricCESU.class;
    } 
    return null;
  }
  
  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
    if (!IC2.platform.isSimulating())
      return; 
    TileEntityBlock te = (TileEntityBlock)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return; 
    if (te instanceof TileEntityElectricBlock) {
      NBTTagCompound nbttagcompound = StackUtil.getOrCreateNbtData(itemStack);
      ((TileEntityElectricBlock)te).energy = nbttagcompound.getDouble("energy");
      if(entityliving instanceof EntityPlayer) {
          EntityPlayer entityplayer = (EntityPlayer) entityliving;
          ((TileEntityElectricBlock)te).UUID = entityplayer.getDisplayName();
           }
    } 
    
    if (entityliving == null) {
      te.setFacing((short)1);
    } else {
      int yaw = MathHelper.floor_double((entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
      int pitch = Math.round(entityliving.rotationPitch);
      if (pitch >= 65) {
        te.setFacing((short)1);
      } else if (pitch <= -65) {
        te.setFacing((short)0);
      } else {
        switch (yaw) {
          case 0:
            te.setFacing((short)2);
            break;
          case 1:
            te.setFacing((short)5);
            break;
          case 2:
            te.setFacing((short)3);
            break;
          case 3:
            te.setFacing((short)4);
            break;
        } 
      } 
    } 
  }
  
  @SideOnly(Side.CLIENT)
  public EnumRarity getRarity(ItemStack stack) {
    return (stack.getItemDamage() == 2 || stack.getItemDamage() == 5) ? EnumRarity.uncommon : EnumRarity.common;
  }
  
  public boolean hasComparatorInputOverride() {
    return true;
  }
  
  public int getComparatorInputOverride(World world, int x, int y, int z, int side) {
    TileEntityBlock te = (TileEntityBlock)getOwnTe((IBlockAccess)world, x, y, z);
    if (!(te instanceof TileEntityBlock))
      return 0; 
    TileEntityElectricBlock teb = (TileEntityElectricBlock)te;
    return (int)Math.round(Util.map(teb.energy, teb.maxStorage, 15.0D));
  }
}
