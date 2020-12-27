package com.Denfop.item.base;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IBoxable;
import ic2.api.item.IElectricItem;
import ic2.api.item.IItemHudInfo;
import ic2.core.IC2;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.Denfop.SuperSolarPanels;
import com.Denfop.utils.InternalName;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public abstract class ItemElectricTool extends ItemTool implements IElectricItem, IBoxable, IItemHudInfo {
  public double operationEnergyCost;
  
  public int maxCharge;
  
  public int transferLimit;
  
  public int tier;
  
  private final EnumSet<ToolClass> toolClasses;
  
  public ItemElectricTool(InternalName internalName, int operationEnergyCost) {
    this(internalName, operationEnergyCost, HarvestLevel.Iron, EnumSet.noneOf(ToolClass.class));
  }
  
  public ItemElectricTool(InternalName internalName, int operationEnergyCost, HarvestLevel harvestLevel, EnumSet<ToolClass> toolClasses) {
    this(internalName, operationEnergyCost, harvestLevel, toolClasses, new HashSet<Block>());
  }
  
  private ItemElectricTool(InternalName internalName, int operationEnergyCost, HarvestLevel harvestLevel, EnumSet<ToolClass> toolClasses, Set<Block> mineableBlocks) {
    super(0.0F, harvestLevel.toolMaterial, mineableBlocks);
    this.operationEnergyCost = operationEnergyCost;
    this.toolClasses = toolClasses;
    setMaxDamage(27);
    setMaxStackSize(1);
    setNoRepair();
    setUnlocalizedName(internalName.name());
    setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp);
    for (ToolClass toolClass : toolClasses) {
      if (toolClass.name != null)
        setHarvestLevel(toolClass.name, harvestLevel.level); 
    } 
    if (toolClasses.contains(ToolClass.Pickaxe) && harvestLevel.toolMaterial == Item.ToolMaterial.EMERALD) {
      mineableBlocks.add(Blocks.obsidian);
      mineableBlocks.add(Blocks.redstone_ore);
      mineableBlocks.add(Blocks.lit_redstone_ore);
    } 
    GameRegistry.registerItem((Item)this, internalName.name());
  }
  
  public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset) {
    ElectricItem.manager.use(stack, 0.0D, (EntityLivingBase)player);
    return super.onItemUse(stack, player, world, x, y, z, side, xOffset, yOffset, zOffset);
  }
  
  public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
    ElectricItem.manager.use(stack, 0.0D, (EntityLivingBase)player);
    return super.onItemRightClick(stack, world, player);
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister iconRegister) {
    this.itemIcon = iconRegister.registerIcon(SuperSolarPanels.TEXTURES_ITEMS + ":" + getUnlocalizedName().substring(4));
  }
  
  public String getUnlocalizedName() {
    return "ssp." + super.getUnlocalizedName().substring(5);
  }
  
  public String getUnlocalizedName(ItemStack itemStack) {
    return getUnlocalizedName();
  }
  
  public String getItemStackDisplayName(ItemStack itemStack) {
    return StatCollector.translateToLocal(getUnlocalizedName(itemStack));
  }
  
  public boolean canHarvestBlock(Block block, ItemStack stack) {
    Material material = block.getMaterial();
    for (ToolClass toolClass : this.toolClasses) {
      if (toolClass.whitelist.contains(block) || toolClass.whitelist
        .contains(material))
        return true; 
    } 
    return super.canHarvestBlock(block, stack);
  }
  
  public float getDigSpeed(ItemStack tool, Block block, int meta) {
    if (!ElectricItem.manager.canUse(tool, this.operationEnergyCost))
      return 1.0F; 
    return super.getDigSpeed(tool, block, meta);
  }
  
  public float func_150893_a(ItemStack stack, Block block) {
    if (canHarvestBlock(block, stack))
      return this.efficiencyOnProperMaterial; 
    return super.func_150893_a(stack, block);
  }
  
  public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1) {
    return true;
  }
  
  public int getItemEnchantability() {
    return 0;
  }
  
  public boolean isRepairable() {
    return false;
  }
  
  public boolean canProvideEnergy(ItemStack itemStack) {
    return false;
  }
  
  public Item getChargedItem(ItemStack itemStack) {
    return (Item)this;
  }
  
  public Item getEmptyItem(ItemStack itemStack) {
    return (Item)this;
  }
  
  public double getMaxCharge(ItemStack itemStack) {
    return this.maxCharge;
  }
  
  public int getTier(ItemStack itemStack) {
    return this.tier;
  }
  
  public double getTransferLimit(ItemStack itemStack) {
    return this.transferLimit;
  }
  
  public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block block, int par4, int par5, int par6, EntityLivingBase par7EntityLiving) {
    if (block.getBlockHardness(par2World, par4, par5, par6) != 0.0D)
      if (par7EntityLiving != null) {
        ElectricItem.manager.use(par1ItemStack, this.operationEnergyCost, par7EntityLiving);
      } else {
        ElectricItem.manager.discharge(par1ItemStack, this.operationEnergyCost, this.tier, true, false, false);
      }  
    return true;
  }
  
  public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
    return false;
  }
  
  public boolean canBeStoredInToolbox(ItemStack itemstack) {
    return true;
  }
  
  public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
    return false;
  }
  
  @SideOnly(Side.CLIENT)
  public void SubItems(Item item, CreativeTabs tabs, List<ItemStack> itemList) {
    itemList.add(getItemStack(Double.POSITIVE_INFINITY));
    itemList.add(getItemStack(0.0D));
    itemList.add(new ItemStack((Item)this, 1, getMaxDamage()));
  }
  
  public void Information(ItemStack itemStack, EntityPlayer player, List<String> info, boolean b) {
    info.add(StatCollector.translateToLocal("ic2.item.tooltip.PowerTier") + " " + this.tier);
  }
  
  public List<String> getHudInfo(ItemStack itemStack) {
    List<String> info = new LinkedList<String>();
    info.add(ElectricItem.manager.getToolTip(itemStack));
    info.add(StatCollector.translateToLocal("ic2.item.tooltip.PowerTier") + " " + this.tier);
    return info;
  }
  
  protected ItemStack getItemStack(double charge) {
    ItemStack ret = new ItemStack((Item)this);
    ElectricItem.manager.charge(ret, charge, 2147483647, true, false);
    return ret;
  }
  
  protected enum HarvestLevel {
    Wood(0, Item.ToolMaterial.WOOD),
    Stone(1, Item.ToolMaterial.STONE),
    Iron(2, Item.ToolMaterial.IRON),
    Diamond(3, Item.ToolMaterial.EMERALD),
    Iridium(100, Item.ToolMaterial.EMERALD);
    
    public final int level;
    
    public final Item.ToolMaterial toolMaterial;
    
    HarvestLevel(int level, Item.ToolMaterial toolMaterial) {
      this.level = level;
      this.toolMaterial = toolMaterial;
    }
  }
  
  protected enum ToolClass {
    Axe("axe", new Object[] { Material.wood, Material.plants, Material.vine }),
    Pickaxe("pickaxe", new Object[] { Material.iron, Material.anvil, Material.rock }),
    Shears("shears", new Object[] { Blocks.web, Blocks.wool, Blocks.redstone_wire, Blocks.tripwire, Material.leaves }),
    Shovel("shovel", new Object[] { Blocks.snow_layer, Blocks.snow }),
    Sword("sword", new Object[] { Blocks.web, Material.plants, Material.vine, Material.coral, Material.leaves, Material.gourd }),
    Hoe(null, new Object[] { Blocks.dirt, Blocks.grass, Blocks.mycelium });
    
    public final String name;
    
    public final Set<Object> whitelist;
    
    ToolClass(String name, Object... whitelist) {
      this.name = name;
      this.whitelist = new HashSet(Arrays.asList(whitelist));
    }
  }
}
