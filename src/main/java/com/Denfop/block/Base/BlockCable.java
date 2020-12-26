package com.Denfop.block.Base;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.Direction;
import ic2.api.energy.EnergyNet;
import ic2.api.event.PaintEvent;
import ic2.api.event.RetextureEvent;
import ic2.core.block.BlockTextureStitched;
import ic2.core.item.tool.ItemToolCutter;
import ic2.core.util.AabbUtil;
import ic2.core.util.StackUtil;
import ic2.core.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import org.apache.commons.lang3.mutable.MutableObject;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.base.ItemBlockIC2;
import com.Denfop.proxy.ClientProxy;
import com.Denfop.tiles.base.TileEntityBase;
import com.Denfop.utils.InternalName;

public class BlockCable extends BlockMultiID {
  private static final int[] coloredMetas = new int[] { 0, 3, 4, 6, 7, 8, 9, 13 };
  
  protected int colorMultiplier;
  
  @SideOnly(Side.CLIENT)
  private IIcon[][] coloredTextures;
  
  public BlockCable(InternalName internalName1) {
    super(internalName1, Material.iron,ItemBlockIC2.class);
    this.colorMultiplier = -1;
    setHardness(0.2F);
    setStepSound(soundTypeCloth);
    setCreativeTab(null);
    SuperSolarPanels.copperCableBlock = new ItemStack((Block)this, 1, 1);
    SuperSolarPanels.insulatedCopperCableBlock = new ItemStack((Block)this, 1, 0);
    SuperSolarPanels.goldCableBlock = new ItemStack((Block)this, 1, 2);
    SuperSolarPanels.insulatedGoldCableBlock = new ItemStack((Block)this, 1, 3);
    SuperSolarPanels.doubleInsulatedGoldCableBlock = new ItemStack((Block)this, 1, 4);
    SuperSolarPanels.ironCableBlock = new ItemStack((Block)this, 1, 5);
    SuperSolarPanels.insulatedIronCableBlock = new ItemStack((Block)this, 1, 6);
    SuperSolarPanels.doubleInsulatedIronCableBlock = new ItemStack((Block)this, 1, 7);
    SuperSolarPanels.trippleInsulatedIronCableBlock = new ItemStack((Block)this, 1, 8);
    SuperSolarPanels.glassFiberCableBlock = new ItemStack((Block)this, 1, 9);
    GameRegistry.registerTileEntity(TileEntityCable.class, "Cable1");
    MinecraftForge.EVENT_BUS.register(this);
  }
  
  public String getTextureFolder(int id) {
    return null;
  }
  
  public String getTextureName(int index) {
	    Item item = SuperSolarPanels.copperCableItem.getItem();
	    ItemStack itemStack = new ItemStack((Block)this, 1, index);
	    String ret = item.getUnlocalizedName(itemStack);
	    if (ret == null)
	      return null; 
	    return ret.substring(4).replace("item", "block");
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public void registerBlockIcons(IIconRegister iconRegister) {
	    super.registerBlockIcons(iconRegister);
	    this.coloredTextures = new IIcon[coloredMetas.length][90];
	    for (int index = 0; index < coloredMetas.length; index++) {
	      int meta = coloredMetas[index];
	      for (int color = 1; color < 16; color++) {
	        String name = SuperSolarPanels.TEXTURES + ":" + getTextureFolder(index) + "/" + getTextureName(meta) + "." + Util.getColorName(color).name();
	        for (int side = 0; side < 6; side++) {
	          String subName = name + ":" + side;
	          BlockTextureStitched blockTextureStitched = new BlockTextureStitched(subName, side);
	          this.coloredTextures[index][(color - 1) * 6 + side] = (IIcon)blockTextureStitched;
	          ((TextureMap)iconRegister).setTextureEntry(subName, (TextureAtlasSprite)blockTextureStitched);
	        } 
	      } 
	    } 
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
	    TileEntityCable te = (TileEntityCable)getOwnTe(blockAccess, x, y, z);
	    if (te == null)
	      return null; 
	    if (te.foamed == 0) {
	      if (te instanceof TileEntityCableDetector || te instanceof TileEntityCableSplitter || te.color == 0)
	        return super.getIcon(blockAccess, x, y, z, side); 
	      int cableType = (te.cableType == 14) ? 13 : te.cableType;
	      return this.coloredTextures[Arrays.binarySearch(coloredMetas, cableType)][(te.color - 1) * 6 + side];
	    } 
	    if (te.foamed == 1)
	      return StackUtil.getBlock(SuperSolarPanels.constructionFoam).getIcon(side, 0); 
	    Block referencedBlock = te.getReferencedBlock(side);
	    if (referencedBlock != null)
	      try {
	        return referencedBlock.getIcon(te.retextureRefSide[side], te.retextureRefMeta[side]);
	      } catch (Exception exception) {} 
	    return StackUtil.getBlock(SuperSolarPanels.constructionFoamWall).getIcon(side, te.foamColor);
	  }
	  
  public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 origin, Vec3 absDirection) {
    TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return null; 
    TileEntityCable tileEntityCable = te;
    Vec3 direction = Vec3.createVectorHelper(absDirection.xCoord - origin.xCoord, absDirection.yCoord - origin.yCoord, absDirection.zCoord - origin.zCoord);
    double maxLength = direction.lengthVector();
    double halfThickness = (tileEntityCable.foamed > 0) ? 0.5D : (tileEntityCable.getCableThickness() / 2.0D);
    boolean hit = false;
    Vec3 intersection = Vec3.createVectorHelper(0.0D, 0.0D, 0.0D);
    Direction intersectingDirection = AabbUtil.getIntersection(origin, direction, AxisAlignedBB.getBoundingBox(x + 0.5D - halfThickness, y + 0.5D - halfThickness, z + 0.5D - halfThickness, x + 0.5D + halfThickness, y + 0.5D + halfThickness, z + 0.5D + halfThickness), intersection);
    if (intersectingDirection != null && intersection.distanceTo(origin) <= maxLength) {
      hit = true;
    } else if (halfThickness < 0.5D) {
      int mask = 1;
      for (Direction dir : Direction.directions) {
        if ((tileEntityCable.connectivity & mask) == 0) {
          mask *= 2;
        } else {
          mask *= 2;
          AxisAlignedBB bbox = null;
          switch (dir) {
            case XN:
              bbox = AxisAlignedBB.getBoundingBox(x, y + 0.5D - halfThickness, z + 0.5D - halfThickness, x + 0.5D, y + 0.5D + halfThickness, z + 0.5D + halfThickness);
              break;
            case XP:
              bbox = AxisAlignedBB.getBoundingBox(x + 0.5D, y + 0.5D - halfThickness, z + 0.5D - halfThickness, x + 1.0D, y + 0.5D + halfThickness, z + 0.5D + halfThickness);
              break;
            case YN:
              bbox = AxisAlignedBB.getBoundingBox(x + 0.5D - halfThickness, y, z + 0.5D - halfThickness, x + 0.5D + halfThickness, y + 0.5D, z + 0.5D + halfThickness);
              break;
            case YP:
              bbox = AxisAlignedBB.getBoundingBox(x + 0.5D - halfThickness, y + 0.5D, z + 0.5D - halfThickness, x + 0.5D + halfThickness, y + 1.0D, z + 0.5D + halfThickness);
              break;
            case ZN:
              bbox = AxisAlignedBB.getBoundingBox(x + 0.5D - halfThickness, y + 0.5D - halfThickness, z, x + 0.5D + halfThickness, y + 0.5D, z + 0.5D);
              break;
            case ZP:
              bbox = AxisAlignedBB.getBoundingBox(x + 0.5D - halfThickness, y + 0.5D - halfThickness, z + 0.5D, x + 0.5D + halfThickness, y + 0.5D + halfThickness, z + 1.0D);
              break;
          } 
          intersectingDirection = AabbUtil.getIntersection(origin, direction, bbox, intersection);
          if (intersectingDirection != null && intersection.distanceTo(origin) <= maxLength) {
            hit = true;
            break;
          } 
        } 
      } 
    } 
    if (hit && intersectingDirection != null)
      return new MovingObjectPosition(x, y, z, intersectingDirection.toSideValue(), intersection); 
    return null;
  }
  
  public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z, int meta) {
    double halfThickness = TileEntityCable.getCableThickness(meta);
    if (meta == 13)
      halfThickness = TileEntityCable.getCableThickness(14); 
    return AxisAlignedBB.getBoundingBox(x + 0.5D - halfThickness, y + 0.5D - halfThickness, z + 0.5D - halfThickness, x + 0.5D + halfThickness, y + 0.5D + halfThickness, z + 0.5D + halfThickness);
  }
  
  public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
    return getCommonBoundingBoxFromPool(world, x, y, z, false);
  }
  
  public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
    return getCommonBoundingBoxFromPool(world, x, y, z, true);
  }
  
  public AxisAlignedBB getCommonBoundingBoxFromPool(World world, int x, int y, int z, boolean selectionBoundingBox) {
    TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return getCollisionBoundingBoxFromPool(world, x, y, z, 3); 
    double halfThickness = (te.foamed == 1 && selectionBoundingBox) ? 0.5D : (te.getCableThickness() / 2.0D);
    double minX1 = x + 0.5D - halfThickness;
    double minY1 = y + 0.5D - halfThickness;
    double minZ1 = z + 0.5D - halfThickness;
    double maxX1 = x + 0.5D + halfThickness;
    double maxY1 = y + 0.5D + halfThickness;
    double maxZ1 = z + 0.5D + halfThickness;
    if ((te.connectivity & 0x1) != 0)
      minX1 = x; 
    if ((te.connectivity & 0x4) != 0)
      minY1 = y; 
    if ((te.connectivity & 0x10) != 0)
      minZ1 = z; 
    if ((te.connectivity & 0x2) != 0)
      maxX1 = (x + 1); 
    if ((te.connectivity & 0x8) != 0)
      maxY1 = (y + 1); 
    if ((te.connectivity & 0x20) != 0)
      maxZ1 = (z + 1); 
    return AxisAlignedBB.getBoundingBox(minX1, minY1, minZ1, maxX1, maxY1, maxZ1);
  }
  
  public boolean isNormalCube(IBlockAccess world, int x, int y, int z) {
    TileEntityCable te = (TileEntityCable)getOwnTe(world, x, y, z);
    if (te == null)
      return false; 
    return (te.foamed > 0);
  }
  
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xOffset, float yOffset, float zOffset) {
    ItemStack cur = player.getCurrentEquippedItem();
    if (cur != null && (StackUtil.equals((Block)Blocks.sand, cur))) {
      TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)world, x, y, z);
      if (te == null)
        return false; 
      if ((StackUtil.equals((Block)Blocks.sand, cur) && te.foamed == 1 && te.changeFoam((byte)2)) || (cur.getItem() == SuperSolarPanels.constructionFoam.getItem() && te.foamed == 0 && te.changeFoam((byte)1))) {
        if (SuperSolarPanels.proxy.isSimulating() && !player.capabilities.isCreativeMode) {
          cur.stackSize--;
          if (cur.stackSize <= 0)
            player.inventory.mainInventory[player.inventory.currentItem] = null; 
        } 
        return true;
      } 
    } 
    return false;
  }
  
  public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
    super.onNeighborBlockChange(world, x, y, z, neighbor);
    if (SuperSolarPanels.proxy.isSimulating()) {
      TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)world, x, y, z);
      if (te == null)
        return; 
      te.onNeighborBlockChange();
    } 
  }
  
  public boolean removedByPlayer(World world, EntityPlayer entityPlayer, int x, int y, int z) {
    TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      world.setBlockToAir(x, y, z); 
    if (te.foamed > 0) {
      te.changeFoam((byte)0);
      world.notifyBlocksOfNeighborChange(x, y, z, (Block)this);
      return false;
    } 
    return world.setBlockToAir(x, y, z);
  }
  
  public int getCableColor(IBlockAccess blockAccess, int x, int y, int z) {
    TileEntityCable te = (TileEntityCable)getOwnTe(blockAccess, x, y, z);
    if (te == null)
      return 0; 
    return te.color;
  }
  
  public boolean recolourBlock(World world, int x, int y, int z, ForgeDirection side, int color) {
    TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return false; 
    color = BlockColored.func_150031_c(color);
    return te.changeColor(color);
  }
  
  @SubscribeEvent
  public void colorBlock(PaintEvent event) {
    if (event.world.getBlock(event.x, event.y, event.z) != this)
      return; 
    TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)event.world, event.x, event.y, event.z);
    if (te == null)
      return; 
    event.painted = te.changeColor(event.color);
  }
  
  public boolean canHarvestBlock(EntityPlayer player, int md) {
    return true;
  }
  
  public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
    ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
    TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)world, x, y, z);
    if (te != null) {
      if (te.cableType == 14) {
        ret.add(new ItemStack(SuperSolarPanels.insulatedCopperCableItem.getItem(), 1, 13));
        return ret;
      } 
      ret.add(new ItemStack(SuperSolarPanels.insulatedCopperCableItem.getItem(), 1, te.cableType));
    } else {
      ret.add(new ItemStack(SuperSolarPanels.insulatedCopperCableItem.getItem(), 1, metadata));
    } 
    return ret;
  }
  
  public Class<? extends TileEntity> getTeClass(int meta, MutableObject<Class<?>[]> ctorArgTypes, MutableObject<Object[]> ctorArgs) {
    if (meta >= 13)
      meta++; 
    if (ctorArgTypes != null)
      ctorArgTypes.setValue(new Class[] { short.class }); 
    if (ctorArgs != null)
      ctorArgs.setValue(new Object[] { Short.valueOf((short)meta) }); 
    switch (meta) {
      case 11:
        return (Class)TileEntityCableDetector.class;
      case 12:
        return (Class)TileEntityCableSplitter.class;
    } 
    return (Class)TileEntityCable.class;
  }
  
  public boolean renderAsNormalBlock() {
    return false;
  }
  
  public int getRenderType() {
    return SuperSolarPanels.proxy.getRenderId("cable");
  }
  
  public boolean isOpaqueCube() {
    return false;
  }
  
  public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer) {
    if (entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().getItem() instanceof ItemToolCutter)
      ItemToolCutter.cutInsulationFrom(entityplayer.getCurrentEquippedItem(), world, i, j, k); 
  }
  
  public int isProvidingWeakPower(IBlockAccess blockAccess, int x, int y, int z, int side) {
    TileEntityCable te = (TileEntityCable)getOwnTe(blockAccess, x, y, z);
    if (te == null)
      return 0; 
    if (te instanceof TileEntityCableDetector)
      return te.getActive() ? 15 : 0; 
    return 0;
  }
  
  public void getSubBlocks(Item item, CreativeTabs tabs, List itemList) {}
  
  public float getBlockHardness(World world, int x, int y, int z) {
    TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return 0.0F; 
    if (te.foamed == 1)
      return 0.01F; 
    if (te.foamed == 2)
      return 3.0F; 
    return 0.2F;
  }
  
  public float getExplosionResistance(Entity exploder, World world, int x, int y, int z, double src_x, double src_y, double src_z) {
    TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)world, x, y, z);
    if (te == null)
      return 0.0F; 
    if (te.foamed == 2)
      return 90.0F; 
    return 6.0F;
  }
  
  public int getLightOpacity(IBlockAccess world, int x, int y, int z) {
    TileEntityCable te = (TileEntityCable)getOwnTe(world, x, y, z);
    if (te == null)
      return 0; 
    if (te.foamed == 2)
      return 255; 
    return 0;
  }
  
  public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int direction) {
    int meta = world.getBlockMetadata(x, y, z);
    return (meta == 11 || meta == 12);
  }
  
  public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
    List<ItemStack> ret = getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
    if (ret.isEmpty())
      return null; 
    return ret.get(0);
  }
  
  public boolean hasComparatorInputOverride() {
    return true;
  }
  
  public int getComparatorInputOverride(World world, int x, int y, int z, int side) {
    if (SuperSolarPanels.proxy.isSimulating()) {
      TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)world, x, y, z);
      if (te == null)
        return 0; 
      if (te instanceof TileEntityCableDetector) {
        TileEntityCableDetector tec = (TileEntityCableDetector)te;
        return (int)Util.map(EnergyNet.instance.getNodeStats((TileEntity)te).getEnergyIn() / (tec.getConductorBreakdownEnergy() - 1.0D), 1.0D, 15.0D);
      } 
    } 
    return 0;
  }
  
  @SubscribeEvent
  public void onRetexture(RetextureEvent event) {
    if (event.world.getBlock(event.x, event.y, event.z) != this)
      return; 
    TileEntityCable te = (TileEntityCable)getOwnTe((IBlockAccess)event.world, event.x, event.y, event.z);
    if (te == null)
      return; 
    if (te.retexture(event.side, event.referencedBlock, event.referencedMeta, event.referencedSide))
      event.applied = true; 
  }
  
  public int colorMultiplier(IBlockAccess par1iBlockAccess, int x, int y, int z) {
    if (this.colorMultiplier != -1)
      return this.colorMultiplier; 
    return super.colorMultiplier(par1iBlockAccess, x, y, z);
  }
}
