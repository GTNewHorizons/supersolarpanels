package com.Denfop.integration.DE;
import com.Denfop.SuperSolarPanels;
import cofh.api.energy.IEnergyContainerItem;
import com.brandon3055.brandonscore.common.utills.InfoHelper;
import com.brandon3055.brandonscore.common.utills.ItemNBTHelper;
import com.brandon3055.brandonscore.common.utills.Utills;
import com.brandon3055.draconicevolution.client.render.IRenderTweak;
import com.brandon3055.draconicevolution.common.entity.EntityPersistentItem;
import com.brandon3055.draconicevolution.common.handler.BalanceConfigHandler;
import com.brandon3055.draconicevolution.common.utills.IConfigurableItem;
import com.brandon3055.draconicevolution.common.utills.IHudDisplayItem;
import com.brandon3055.draconicevolution.common.utills.IUpgradableItem;
import com.brandon3055.draconicevolution.common.utills.ItemConfigField;
import com.brandon3055.draconicevolution.common.utills.LogHelper;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import org.lwjgl.opengl.GL11;

public class ChaosHoe extends ItemHoe implements IEnergyContainerItem, IRenderTweak, IUpgradableItem, IConfigurableItem, IHudDisplayItem {
  protected int capacity = (int) (BalanceConfigHandler.draconicToolsBaseStorage * 1.5);
  
  protected int maxReceive = (int) (BalanceConfigHandler.draconicToolsMaxTransfer * 1.5);
  
  protected int maxExtract = (int) (BalanceConfigHandler.draconicToolsMaxTransfer * 1.5);
  
  public ChaosHoe() {
	  super(DraconicIntegration.CHAOS);
    setUnlocalizedName("ChaosHoe");
    setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp);
   
      GameRegistry.registerItem((Item)this, "ChaosHoe"); 
  }
  
  public int getItemEnchantability() {
    return this.theToolMaterial.getEnchantability();
  }
  
  public List<ItemConfigField> getFields(ItemStack stack, int slot) {
    List<ItemConfigField> list = new ArrayList<ItemConfigField>();
    list.add((new ItemConfigField(2, slot, "ToolDigAOE")).setMinMaxAndIncromente(Integer.valueOf(0), Integer.valueOf(IUpgradableItem.EnumUpgrade.DIG_AOE.getUpgradePoints(stack)), Integer.valueOf(1)).readFromItem(stack, Integer.valueOf(0)).setModifier("AOE"));
    return list;
  }
  
  public boolean isItemTool(ItemStack p_77616_1_) {
    return true;
  }
  
  @SideOnly(Side.CLIENT)
  public void getSubItems(Item item, CreativeTabs tab, List list) {
    list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 0), "Energy", 0));
    list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 0), "Energy", this.capacity));
  }
  
  public String getUnlocalizedName() {
    return String.format("item.%s%s", new Object[] { "supersolarpanel".toLowerCase() + ":", super.getUnlocalizedName().substring(super.getUnlocalizedName().indexOf(".") + 1) });
  }
  
  public String getUnlocalizedName(ItemStack itemStack) {
    return getUnlocalizedName();
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister iconRegister) {
    this.itemIcon = iconRegister.registerIcon(SuperSolarPanels.TEXTURES + ":" + "ChaosHoe");
  }
  
  public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
    boolean successfull = false;
    Block clicked = world.getBlock(x, y, z);
    if (!player.isSneaking() && player.canPlayerEdit(x, y, z, par7, stack) && (clicked == Blocks.dirt || clicked == Blocks.grass || clicked == Blocks.farmland) && par7 == 1) {
      int size = IConfigurableItem.ProfileHelper.getInteger(stack, "ToolDigAOE", 0);
      LogHelper.info(Integer.valueOf(size));
      for (int x1 = -size; x1 <= size; x1++) {
        for (int z1 = -size; z1 <= size; z1++) {
          if ((!(stack.getItem() instanceof IEnergyContainerItem) || ((IEnergyContainerItem)stack.getItem()).getEnergyStored(stack) < BalanceConfigHandler.draconicToolsEnergyPerAction) && 
            !player.capabilities.isCreativeMode)
            return false; 
          Block topBlock = world.getBlock(x + x1, y + 1, z + z1);
          if (topBlock.isReplaceable((IBlockAccess)world, x + x1, y + 1, z + z1))
            world.setBlockToAir(x + x1, y + 1, z + z1); 
          Block topBlock2 = world.getBlock(x + x1, y + 2, z + z1);
          if (topBlock2.isReplaceable((IBlockAccess)world, x + x1, y + 2, z + z1))
            world.setBlockToAir(x + x1, y + 2, z + z1); 
          Block block = world.getBlock(x + x1, y, z + z1);
          if (block.isReplaceable((IBlockAccess)world, x + x1, y, z + z1) && !block.getMaterial().equals(Material.water))
            world.setBlockToAir(x + x1, y, z + z1); 
          if (world.getBlock(x + x1, y, z + z1) == Blocks.air && world.getBlock(x + x1, y - 1, z + z1).isBlockSolid((IBlockAccess)world, x, y, z, 1) && (
            player.inventory.hasItem(Item.getItemFromBlock(Blocks.dirt)) || player.capabilities.isCreativeMode)) {
            world.setBlock(x + x1, y, z + z1, Blocks.dirt);
            player.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.dirt));
          } 
          if ((world.getBlock(x + x1, y + 1, z + z1) == Blocks.dirt || world.getBlock(x + x1, y + 1, z + z1) == Blocks.grass || world.getBlock(x + x1, y + 1, z + z1) == Blocks.farmland) && world.getBlock(x + x1, y + 2, z + z1) == Blocks.air) {
            if (!world.isRemote)
              world.spawnEntityInWorld((Entity)new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(Item.getItemFromBlock(Blocks.dirt)))); 
            world.setBlock(x + x1, y + 1, z + z1, Blocks.air);
          } 
          if (hoe(stack, player, world, x + x1, y, z + z1, par7))
            successfull = true; 
        } 
      } 
    } else {
      successfull = hoe(stack, player, world, x, y, z, par7);
    } 
    Block block1 = Blocks.farmland;
    if (successfull)
      world.playSoundEffect((x + 0.5F), (y + 0.5F), (z + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F); 
    return successfull;
  }
  
  private boolean hoe(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7) {
    if (!(stack.getItem() instanceof IEnergyContainerItem) || ((IEnergyContainerItem)stack.getItem()).getEnergyStored(stack) < BalanceConfigHandler.draconicToolsEnergyPerAction) {
      if (!player.capabilities.isCreativeMode)
        return false; 
    } else if (!player.capabilities.isCreativeMode) {
      ((IEnergyContainerItem)stack.getItem()).extractEnergy(stack, BalanceConfigHandler.draconicToolsEnergyPerAction, false);
    } 
    if (!player.canPlayerEdit(x, y, z, par7, stack))
      return false; 
    UseHoeEvent event = new UseHoeEvent(player, stack, world, x, y, z);
    if (MinecraftForge.EVENT_BUS.post((Event)event))
      return false; 
    if (event.getResult() == Event.Result.ALLOW) {
      stack.damageItem(1, (EntityLivingBase)player);
      return true;
    } 
    Block block = world.getBlock(x, y, z);
    if (par7 != 0 && world.getBlock(x, y + 1, z).isAir((IBlockAccess)world, x, y + 1, z) && (block == Blocks.grass || block == Blocks.dirt)) {
      Block block1 = Blocks.farmland;
      if (world.isRemote)
        return true; 
      world.setBlock(x, y, z, block1);
      stack.damageItem(1, (EntityLivingBase)player);
      return true;
    } 
    return false;
  }
  
  public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean extraInformation) {
    InfoHelper.addEnergyInfo(stack, list);
    ToolBase.holdCTRLForUpgrades(list, stack);
    InfoHelper.addLore(stack, list);
  }
  
  public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
    if (container.stackTagCompound == null)
      container.stackTagCompound = new NBTTagCompound(); 
    int energy = container.stackTagCompound.getInteger("Energy");
    int energyReceived = Math.min(getMaxEnergyStored(container) - energy, Math.min(this.maxReceive, maxReceive));
    if (!simulate) {
      energy += energyReceived;
      container.stackTagCompound.setInteger("Energy", energy);
    } 
    return energyReceived;
  }
  
  public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
    if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy"))
      return 0; 
    int energy = container.stackTagCompound.getInteger("Energy");
    int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
    if (!simulate) {
      energy -= energyExtracted;
      container.stackTagCompound.setInteger("Energy", energy);
    } 
    return energyExtracted;
  }
  
  public int getEnergyStored(ItemStack container) {
    if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy"))
      return 0; 
    return container.stackTagCompound.getInteger("Energy");
  }
  
  public int getMaxEnergyStored(ItemStack container) {
    int points = IUpgradableItem.EnumUpgrade.RF_CAPACITY.getUpgradePoints(container);
    return (int) (BalanceConfigHandler.draconicToolsBaseStorage * 1.5 + points * BalanceConfigHandler.draconicToolsStoragePerUpgrade);
  }
  
  public boolean showDurabilityBar(ItemStack stack) {
    return (getEnergyStored(stack) != getMaxEnergyStored(stack));
  }
  
  public double getDurabilityForDisplay(ItemStack stack) {
    return 1.0D - getEnergyStored(stack) / getMaxEnergyStored(stack);
  }
  
  public boolean hasCustomEntity(ItemStack stack) {
    return true;
  }
  
  public Entity createEntity(World world, Entity location, ItemStack itemstack) {
    return (Entity)new EntityPersistentItem(world, location, itemstack);
  }
  public boolean hasEffect(ItemStack par1ItemStack, int pass) {
	    return true;
	  }
  public void tweakRender(IItemRenderer.ItemRenderType type) {
    GL11.glTranslated(0.4D, 1.0D, 0.0D);
    GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(140.0F, 0.0F, -1.0F, 0.0F);
    GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
    GL11.glScaled(0.6D, 0.6D, 0.6D);
    if (type == IItemRenderer.ItemRenderType.INVENTORY) {
      GL11.glScalef(12.0F, 12.0F, 12.0F);
      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslated(-1.4D, 0.0D, -0.1D);
    } else if (type == IItemRenderer.ItemRenderType.ENTITY) {
      GL11.glRotatef(90.5F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(90.0F, 0.0F, 0.0F, -1.0F);
      GL11.glTranslated(0.35D, -0.4D, -1.0D);
    } 
  }
  
  public List<IUpgradableItem.EnumUpgrade> getUpgrades(ItemStack itemstack) {
	  List<IUpgradableItem.EnumUpgrade> list = new ArrayList<IUpgradableItem.EnumUpgrade>();
	  	
      list.add(IUpgradableItem.EnumUpgrade.RF_CAPACITY);
      return list;
  }
  
  public int getUpgradeCap(ItemStack itemstack) {
    return BalanceConfigHandler.draconicToolsMaxUpgrades;
  }
  
  public int getMaxTier(ItemStack itemstack) {
    return 3;
  }
  
  public int getMaxUpgradePoints(int upgradeIndex) {
    if (upgradeIndex == IUpgradableItem.EnumUpgrade.RF_CAPACITY.index)
      return BalanceConfigHandler.draconicToolsMaxCapacityUpgradePoints; 
    if (upgradeIndex == IUpgradableItem.EnumUpgrade.DIG_AOE.index)
      return 5; 
    return BalanceConfigHandler.draconicToolsMaxUpgradePoints;
  }
  
  public int getMaxUpgradePoints(int upgradeIndex, ItemStack stack) {
    return getMaxUpgradePoints(upgradeIndex);
  }
  
  public int getBaseUpgradePoints(int upgradeIndex) {
    if (upgradeIndex == IUpgradableItem.EnumUpgrade.DIG_AOE.index)
      return 3; 
    return 0;
  }
  
  public List<String> getUpgradeStats(ItemStack itemstack) {
    List<String> strings = new ArrayList<String>();
    int digaoe = 0;
    for (ItemConfigField field : getFields(itemstack, 0)) {
      if (field.name.equals("ToolDigAOE"))
        digaoe = 1 + ((Integer)field.max).intValue() * 2; 
    } 
    strings.add(InfoHelper.ITC() + StatCollector.translateToLocal("gui.de.RFCapacity.txt") + ": " + InfoHelper.HITC() + Utills.formatNumber(getMaxEnergyStored(itemstack)));
    strings.add(InfoHelper.ITC() + StatCollector.translateToLocal("gui.de.max.txt") + " " + StatCollector.translateToLocal("gui.de.DigAOE.txt") + ": " + InfoHelper.HITC() + digaoe + "x" + digaoe);
    return strings;
  }
  
  public boolean hasProfiles() {
    return false;
  }
  
  public List<String> getDisplayData(ItemStack stack) {
    List<String> list = new ArrayList<String>();
    for (ItemConfigField field : getFields(stack, 0))
      list.add(field.getTooltipInfo()); 
    list.add(InfoHelper.ITC() + StatCollector.translateToLocal("info.de.charge.txt") + ": " + InfoHelper.HITC() + Utills.formatNumber(getEnergyStored(stack)) + " / " + Utills.formatNumber(this.capacity));
    return list;
  }
}
