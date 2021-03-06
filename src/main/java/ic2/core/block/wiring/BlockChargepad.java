package ic2.core.block.wiring;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.core.IC2;
import ic2.core.IHasGui;
import ic2.core.Ic2Items;
import ic2.core.block.BlockMultiID;
import ic2.core.init.InternalName;
import ic2.core.item.block.ItemChargepadBlock;
import ic2.core.util.StackUtil;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.apache.commons.lang3.mutable.MutableObject;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.Modules.module7;
import com.Denfop.tiles.base.TileEntityChargepadBlock;
import com.Denfop.tiles.base.TileEntityElectricBlock;

import cofh.api.energy.IEnergyContainerItem;

public class BlockChargepad extends BlockMultiID {
  public BlockChargepad(InternalName internalName) {
    super(internalName, Material.iron, ItemChargepadBlock.class);
    setHardness(1.5F);
    setStepSound(soundTypeMetal);
    setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.95F, 1.0F);
    Ic2Items.ChargepadbatBox = new ItemStack((Block)this, 1, 0);
    Ic2Items.ChargepadcesuUnit = new ItemStack((Block)this, 1, 1);
    Ic2Items.ChargepadmfeUnit = new ItemStack((Block)this, 1, 2);
    Ic2Items.ChargepadmfsUnit = new ItemStack((Block)this, 1, 3);
    GameRegistry.registerTileEntity(TileEntityChargepadBatBox.class, "Chargepad BatBox");
    GameRegistry.registerTileEntity(TileEntityChargepadCESU.class, "Chargepad CESU");
    GameRegistry.registerTileEntity(TileEntityChargepadMFE.class, "Chargepad MFE");
    GameRegistry.registerTileEntity(TileEntityChargepadMFSU.class, "Chargepad MFSU");
  }
  
  public String getTextureFolder(int id) {
    return "wiring";
  }
  
  public int isProvidingWeakPower(IBlockAccess blockAccess, int x, int y, int z, int side) {
    TileEntityChargepadBlock te = (TileEntityChargepadBlock)getOwnTe(blockAccess, x, y, z);
    if (te == null)
      return 0; 
    return te.isEmittingRedstone() ? 15 : 0;
  }
  
  public boolean canProvidePower() {
    return true;
  }
  
  public Class<? extends TileEntity> getTeClass(int meta, MutableObject<Class<?>[]> ctorArgTypes, MutableObject<Object[]> ctorArgs) {
    switch (meta) {
      case 0:
        return (Class)TileEntityChargepadBatBox.class;
      case 1:
        return (Class)TileEntityChargepadCESU.class;
      case 2:
        return (Class)TileEntityChargepadMFE.class;
      case 3:
        return (Class)TileEntityChargepadMFSU.class;
    } 
    return null;
  }
  
  public void randomDisplayTick(World world, int x, int y, int z, Random random) {
    if (!IC2.platform.isRendering())
      return; 
    com.Denfop.tiles.base.TileEntityChargepadBlock te = (com.Denfop.tiles.base.TileEntityChargepadBlock)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return; 
    te.spawnParticles(world, x, y, z, random);
  }
  
  public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    if (!IC2.platform.isSimulating())
      return; 
    if (entity instanceof EntityPlayer) {
    	com.Denfop.tiles.base.TileEntityChargepadBlock te = (com.Denfop.tiles.base.TileEntityChargepadBlock)getOwnTe((IBlockAccess)world, x, y, z);
      if (te == null)
        return; 
      te.playerstandsat((EntityPlayer)entity);
    } 
  }
  
  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
    if (!IC2.platform.isSimulating())
      return; 
    com.Denfop.tiles.base.TileEntityChargepadBlock te = (com.Denfop.tiles.base.TileEntityChargepadBlock)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return; 
    NBTTagCompound nbttagcompound = StackUtil.getOrCreateNbtData(stack);
    te.energy = nbttagcompound.getDouble("energy");
    te.energy2 = nbttagcompound.getDouble("energy2");
    if(entity instanceof EntityPlayer) {
        EntityPlayer entityplayer = (EntityPlayer) entity;
        ((TileEntityElectricBlock)te).UUID = entityplayer.getDisplayName();
         }
    if (entity == null) {
      te.setFacing((short)0);
    } else {
      int yaw = MathHelper.floor_double((entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
      int pitch = Math.round(entity.rotationPitch);
      if (pitch <= -65) {
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
  @Override
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
  {
	  if (entityPlayer.isSneaking()) {
		  TileEntityChargepadBlock tile = (TileEntityChargepadBlock) world.getTileEntity(x, y, z);
		  if(tile.movementcharge) {
			 
				 for(ItemStack armorcharged : entityPlayer.inventory.armorInventory) {
					 if(armorcharged != null) {
						 if(armorcharged.getItem() instanceof IElectricItem && tile.energy > 0) {
							 double  sent = ElectricItem.manager.charge(armorcharged, tile.energy, 2147483647, true, false);
							 entityPlayer.inventoryContainer.detectAndSendChanges();
							 tile.energy -= sent;
							
							 tile.needsInvUpdate = (sent > 0.0D);
							 if(sent > 0) {

								   entityPlayer.addChatMessage(new ChatComponentTranslation(StatCollector.translateToLocal("successfully.charged") +String.valueOf(armorcharged.getDisplayName())+" "+ StatCollector.translateToLocal("ssp.sendenergy")+String.valueOf(MathHelper.floor_double(sent))+" EU", new Object[0]));

							 }
						 }
						 
					 }
					 
				 }}
		  if(tile.movementchargerf) {
				 
				 for(ItemStack charged : entityPlayer.inventory.armorInventory) {
					 if(charged != null) {
						 
					        ItemStack stack = charged;
					        if (stack != null && stack.getItem() instanceof IEnergyContainerItem && tile.energy2 >0) {
					        	int sent =0;
					        	
					          IEnergyContainerItem item = (IEnergyContainerItem)stack.getItem();
					      	for(;item.getEnergyStored(charged) < item.getMaxEnergyStored(charged)&&  tile.energy2 >0;) {
					      		sent = sent + tile.extractEnergy(null, item.receiveEnergy(stack, (int) tile.energy2, false), false);
								 
					      		tile.setTransfer(tile.extractEnergy(null, item.receiveEnergy(stack, (int) tile.energy2, false), false) > 0);
					       }
					      	 entityPlayer.inventoryContainer.detectAndSendChanges();
					      	
					        } 
						 
					 
				 
		  }}}
		  if(tile.movementchargeitem) {
				 for(ItemStack charged : entityPlayer.inventory.mainInventory) {
					 if(charged != null) {
						 if(charged.getItem() instanceof IElectricItem && tile.energy > 0) {
							 double  sent = ElectricItem.manager.charge(charged, tile.energy, 2147483647, true, false);
							
							 tile.energy -= sent;
							 entityPlayer.inventoryContainer.detectAndSendChanges();
							 tile.needsInvUpdate = (sent > 0.0D);
							 if(sent > 0) {

								   entityPlayer.addChatMessage(new ChatComponentTranslation(StatCollector.translateToLocal("successfully.charged") +String.valueOf(charged.getDisplayName())+" "+ StatCollector.translateToLocal("ssp.sendenergy")+String.valueOf(MathHelper.floor_double(sent))+" EU", new Object[0]));

							 }
						 }
						 
					 }
					 
				 }
				 
		  }
		  if(tile.movementchargeitemrf) {
				 for(ItemStack charged : entityPlayer.inventory.mainInventory) {
					 if(charged != null) {
						
					        ItemStack stack = charged;
					        if (stack != null && stack.getItem() instanceof IEnergyContainerItem&& tile.energy2 >0 ) {
					        	int sent =0;
					          IEnergyContainerItem item = (IEnergyContainerItem)stack.getItem();
					      	for(;item.getEnergyStored(charged) < item.getMaxEnergyStored(charged) &&  tile.energy2 >0;) {
					      		tile.setTransfer(tile.extractEnergy(null, item.receiveEnergy(stack, (int) tile.energy2, false), false) >0);
					      		sent =+ tile.extractEnergy(null, item.receiveEnergy(stack, (int) tile.energy2, false), false);
					       }
					      	
					      	 entityPlayer.inventoryContainer.detectAndSendChanges();
					      
					        } 
						 
					 
				 
		  }}
	  }}
      if (!entityPlayer.isSneaking())
      {
    	  final TileEntity tileentity = world.getTileEntity(x, y, z);
          if (tileentity != null) {
          	
          	if(world.getTileEntity(x, y, z) instanceof TileEntityElectricBlock) {
          		TileEntityElectricBlock	tile = (TileEntityElectricBlock) world.getTileEntity(x, y, z);
          		 TileEntity te = getOwnTe((IBlockAccess)world, x, y, z);
          		if(tile.chargeSlots[0] != null&& tile.chargeSlots[0].getItem() instanceof module7&& tile.chargeSlots[0].getItemDamage() == 0 && tile.UUID == entityPlayer.getDisplayName()) {
       			 return IC2.platform.launchGui(entityPlayer, (IHasGui)te);
       				 
       			
       				
       				
          }else {
       	   if(tile.personality == false) {
         
       		   return IC2.platform.launchGui(entityPlayer, (IHasGui)te);}else {
           	
           	
           }}
          		
          		
          		}
          
          	}
    	  
      }else {
    	  
      
    			return false;
        	
        
        }
        
      return true;
      }

    
  public boolean isOpaqueCube() {
    return false;
  }
  
  public boolean isNormalCube(IBlockAccess world, int i, int j, int k) {
    return false;
  }
}
