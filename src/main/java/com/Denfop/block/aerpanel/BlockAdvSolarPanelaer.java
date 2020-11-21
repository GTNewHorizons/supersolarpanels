package com.Denfop.block.aerpanel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import com.Denfop.SuperSolarPanels;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.aerpanel.TileEntityAdvancedAirPanel;
import com.Denfop.tiles.aerpanel.TileEntityHybridAirPanel;
import com.Denfop.tiles.aerpanel.TileEntityQuantumAirPanel;
import com.Denfop.tiles.aerpanel.TileEntityUltimateAirPanel;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.tiles.overtimepanel.TileEntityAdvancedSolarPanel;
import com.Denfop.tiles.overtimepanel.TileEntityHybridSolarPanel;
import com.Denfop.tiles.overtimepanel.TileEntityQuantumSolarPanel;
import com.Denfop.tiles.overtimepanel.TileEntityUltimateSolarPanel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAdvSolarPanelaer extends BlockContainer {
  public boolean qgActive;
  
  private IIcon[][] iconBuffer;
  
  public BlockAdvSolarPanelaer() {
    super(Material.iron);
    setHardness(3.0F);
    setCreativeTab(SuperSolarPanels.tabssp);
    this.qgActive = false;
  }
  
  public void registerBlockIcons(IIconRegister par1IconRegister) {
    this.iconBuffer = new IIcon[4][12];
    this.iconBuffer[0][0] = par1IconRegister.registerIcon("supersolarpanel:asp_bottom");
    this.iconBuffer[0][1] = par1IconRegister.registerIcon("supersolarpanel:asp_topaer");
    this.iconBuffer[0][2] = par1IconRegister.registerIcon("supersolarpanel:asp_side");
    this.iconBuffer[0][3] = par1IconRegister.registerIcon("supersolarpanel:asp_side");
    this.iconBuffer[0][4] = par1IconRegister.registerIcon("supersolarpanel:asp_side");
    this.iconBuffer[0][5] = par1IconRegister.registerIcon("supersolarpanel:asp_side");
    this.iconBuffer[0][6] = par1IconRegister.registerIcon("supersolarpanel:asp_bottom");
    this.iconBuffer[0][7] = par1IconRegister.registerIcon("supersolarpanel:asp_topaer");
    this.iconBuffer[0][8] = par1IconRegister.registerIcon("supersolarpanel:asp_side");
    this.iconBuffer[0][9] = par1IconRegister.registerIcon("supersolarpanel:asp_side");
    this.iconBuffer[0][10] = par1IconRegister.registerIcon("supersolarpanel:asp_side");
    this.iconBuffer[0][11] = par1IconRegister.registerIcon("superolarpanel:asp_side");
    this.iconBuffer[1][0] = par1IconRegister.registerIcon("supersolarpanel:hsp_bottom");
    this.iconBuffer[1][1] = par1IconRegister.registerIcon("supersolarpanel:hsp_topaer");
    this.iconBuffer[1][2] = par1IconRegister.registerIcon("supersolarpanel:hsp_side");
    this.iconBuffer[1][3] = par1IconRegister.registerIcon("supersolarpanel:hsp_side");
    this.iconBuffer[1][4] = par1IconRegister.registerIcon("supersolarpanel:hsp_side");
    this.iconBuffer[1][5] = par1IconRegister.registerIcon("supersolarpanel:hsp_side");
    this.iconBuffer[1][6] = par1IconRegister.registerIcon("supersolarpanel:hsp_bottom");
    this.iconBuffer[1][7] = par1IconRegister.registerIcon("supersolarpanel:hsp_topaer");
    this.iconBuffer[1][8] = par1IconRegister.registerIcon("supersolarpanel:hsp_side");
    this.iconBuffer[1][9] = par1IconRegister.registerIcon("supersolarpanel:hsp_side");
    this.iconBuffer[1][10] = par1IconRegister.registerIcon("supersolarpanel:hsp_side");
    this.iconBuffer[1][11] = par1IconRegister.registerIcon("supersolarpanel:hsp_side");
    this.iconBuffer[2][0] = par1IconRegister.registerIcon("supersolarpanel:usp_bottom");
    this.iconBuffer[2][1] = par1IconRegister.registerIcon("supersolarpanel:usp_topaer");
    this.iconBuffer[2][2] = par1IconRegister.registerIcon("supersolarpanel:usp_side");
    this.iconBuffer[2][3] = par1IconRegister.registerIcon("supersolarpanel:usp_side");
    this.iconBuffer[2][4] = par1IconRegister.registerIcon("supersolarpanel:usp_side");
    this.iconBuffer[2][5] = par1IconRegister.registerIcon("supersolarpanel:usp_side");
    this.iconBuffer[2][6] = par1IconRegister.registerIcon("supersolarpanel:usp_bottom");
    this.iconBuffer[2][7] = par1IconRegister.registerIcon("supersolarpanel:usp_topaer");
    this.iconBuffer[2][8] = par1IconRegister.registerIcon("supersolarpanel:usp_side");
    this.iconBuffer[2][9] = par1IconRegister.registerIcon("supersolarpanel:usp_side");
    this.iconBuffer[2][10] = par1IconRegister.registerIcon("supersolarpanel:usp_side");
    this.iconBuffer[2][11] = par1IconRegister.registerIcon("supersolarpanel:usp_side");
    this.iconBuffer[3][0] = par1IconRegister.registerIcon("supersolarpanel:qsp_bottom");
    this.iconBuffer[3][1] = par1IconRegister.registerIcon("supersolarpanel:qsp_topaer");
    this.iconBuffer[3][2] = par1IconRegister.registerIcon("supersolarpanel:qsp_side");
    this.iconBuffer[3][3] = par1IconRegister.registerIcon("supersolarpanel:qsp_side");
    this.iconBuffer[3][4] = par1IconRegister.registerIcon("supersolarpanel:qsp_side");
    this.iconBuffer[3][5] = par1IconRegister.registerIcon("supersolarpanel:qsp_side");
    this.iconBuffer[3][6] = par1IconRegister.registerIcon("supersolarpanel:qsp_bottom");
    this.iconBuffer[3][7] = par1IconRegister.registerIcon("supersolarpanel:qsp_topaer");
    this.iconBuffer[3][8] = par1IconRegister.registerIcon("supersolarpanel:qsp_side");
    this.iconBuffer[3][9] = par1IconRegister.registerIcon("supersolarpanel:qsp_side");
    this.iconBuffer[3][10] = par1IconRegister.registerIcon("supersolarpanel:qsp_side");
    this.iconBuffer[3][11] = par1IconRegister.registerIcon("supersolarpanel:qsp_side");
  }
  
  public IIcon getIcon(IBlockAccess world, int x, int y, int z, int blockSide) {
    int blockMeta = world.getBlockMetadata(x, y, z);
    TileEntity te = world.getTileEntity(x, y, z);
    int facing = (te instanceof TileEntityBase) ? ((com.Denfop.tiles.base.TileEntityBase)te).getFacing() : 0;
    if (isActive(world, x, y, z))
      return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][facing] + 6]; 
    return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][facing]];
  }
  
  public IIcon getIcon(int blockSide, int blockMeta) {
    return this.iconBuffer[blockMeta][ClientProxy.sideAndFacingToSpriteOffset[blockSide][3]];
  }
  
  public static boolean isActive(IBlockAccess var0, int var1, int var2, int var3) {
    return ((TileEntityBase)var0.getTileEntity(var1, var2, var3)).getActive();
  }
  
  public void breakBlock(World world, int i, int j, int k, Block par5, int par6) {
    TileEntity tileentity = world.getTileEntity(i, j, k);
    if (tileentity != null)
     
        dropItems((TileEntitySolarPanel)tileentity, world);  
    world.removeTileEntity(i, j, k);
    super.breakBlock(world, i, j, k, par5, par6);
  }
  
  public int quantityDropped(Random random) {
    return 1;
  }
  
  public int damageDropped(int i) {
    return i;
  }
  
  public TileEntity getBlockEntity(int i) {
    switch (i) {
      case 0:
        return (TileEntity)new TileEntityAdvancedAirPanel();
      case 1:
        return (TileEntity)new TileEntityHybridAirPanel();
      case 2:
        return (TileEntity)new TileEntityUltimateAirPanel();
      case 3:
        return (TileEntity)new TileEntityQuantumAirPanel();
      
    } 
    return (TileEntity)new TileEntityAdvancedSolarPanel();
  }
  
  public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int s, float f1, float f2, float f3) {
    if (player.isSneaking())
      return false; 
    if (world.isRemote)
      return true; 
    TileEntity tileentity = world.getTileEntity(i, j, k);
    if (tileentity != null)
      player.openGui(SuperSolarPanels.instance, 1, world, i, j, k); 
    return true;
  }
  
  private void dropItems(TileEntitySolarPanel tileentity, World world) {
    Random rand = new Random();
    if (!(tileentity instanceof net.minecraft.inventory.IInventory))
      return; 
    TileEntitySolarPanel tileEntitySolarPanel = tileentity;
    for (int i = 0; i < tileEntitySolarPanel.getSizeInventory(); i++) {
      ItemStack item = tileEntitySolarPanel.getStackInSlot(i);
      if (item != null && item.stackSize > 0) {
        float rx = rand.nextFloat() * 0.8F + 0.1F;
        float ry = rand.nextFloat() * 0.8F + 0.1F;
        float rz = rand.nextFloat() * 0.8F + 0.1F;
        EntityItem entityItem = new EntityItem(world, (tileentity.xCoord + rx), (tileentity.yCoord + ry), (tileentity.zCoord + rz), new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
        if (item.hasTagCompound())
          entityItem.getEntityItem().setTagCompound((NBTTagCompound)item.getTagCompound().copy()); 
        float factor = 0.05F;
        entityItem.motionX = rand.nextGaussian() * factor;
        entityItem.motionY = rand.nextGaussian() * factor + 0.20000000298023224D;
        entityItem.motionZ = rand.nextGaussian() * factor;
        world.spawnEntityInWorld((Entity)entityItem);
        item.stackSize = 0;
      } 
    } 
  }
  
  public TileEntity createNewTileEntity(World var1, int var2) {
    return getBlockEntity(var2);
  }
  
  @SideOnly(Side.CLIENT)
  public void getSubBlocks(final Item item, final CreativeTabs tab, final List subItems) {
      for (int ix = 0; ix < this.iconBuffer.length; ++ix) {
          subItems.add(new ItemStack((Block)this, 1, ix));
      }
  }
}
