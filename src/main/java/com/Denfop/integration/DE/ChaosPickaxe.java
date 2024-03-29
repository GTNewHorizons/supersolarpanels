package com.Denfop.integration.DE;
import com.Denfop.SuperSolarPanels;
import com.brandon3055.draconicevolution.client.render.IRenderTweak;
import com.brandon3055.draconicevolution.common.handler.BalanceConfigHandler;
import com.brandon3055.draconicevolution.common.utills.IInventoryTool;
import com.brandon3055.draconicevolution.common.utills.IUpgradableItem;
import com.brandon3055.draconicevolution.common.utills.ItemConfigField;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ChaosPickaxe extends MiningTool implements IInventoryTool, IRenderTweak {
  public ChaosPickaxe() {
    super(DraconicIntegration.CHAOS);
    setHarvestLevel("pickaxe", 15);
    setUnlocalizedName("ChaosPickaxe");
    setCapacity((int) (BalanceConfigHandler.draconicToolsBaseStorage * 1.5));
    setMaxExtract(BalanceConfigHandler.draconicToolsMaxTransfer);
    setMaxReceive(BalanceConfigHandler.draconicToolsMaxTransfer);
    this.energyPerOperation = BalanceConfigHandler.draconicToolsEnergyPerAction;
    DraconicIntegration.register((ItemDC)this);
    setCreativeTab((CreativeTabs)SuperSolarPanels.tabssp);
  }
  
  public List<ItemConfigField> getFields(ItemStack stack, int slot) {
	    List<ItemConfigField> list = super.getFields(stack, slot);
	    list.add((new ItemConfigField(2, slot, "ToolDigAOE")).setMinMaxAndIncromente(Integer.valueOf(0), Integer.valueOf(IUpgradableItem.EnumUpgrade.DIG_AOE.getUpgradePoints(stack)), Integer.valueOf(1)).readFromItem(stack, Integer.valueOf(0)).setModifier("AOE"));
	    list.add((new ItemConfigField(2, slot, "ToolDigDepth")).setMinMaxAndIncromente(Integer.valueOf(1), Integer.valueOf(IUpgradableItem.EnumUpgrade.DIG_DEPTH.getUpgradePoints(stack)), Integer.valueOf(1)).readFromItem(stack, Integer.valueOf(1)));
	    list.add((new ItemConfigField(6, slot, "ToolVoidJunk")).readFromItem(stack, Boolean.valueOf(false)));
	    return list;
	  }
  public boolean hasEffect(ItemStack par1ItemStack, int pass) {
	    return true;
	  }
  public String getInventoryName() {
    return StatCollector.translateToLocal("info.de.toolInventoryOblit.txt");
  }
  
  public int getInventorySlots() {
    return 9;
  }
  
  public boolean isEnchantValid(Enchantment enchant) {
    return (enchant.type == EnumEnchantmentType.digger);
  }
  
  public void tweakRender(IItemRenderer.ItemRenderType type) {
    GL11.glTranslated(0.34D, 0.69D, 0.1D);
    GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(140.0F, 0.0F, -1.0F, 0.0F);
    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    GL11.glScaled(0.7D, 0.7D, 0.7D);
    if (type == IItemRenderer.ItemRenderType.INVENTORY) {
      GL11.glScalef(11.8F, 11.8F, 11.8F);
      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      GL11.glTranslated(-1.2D, 0.0D, -0.35D);
    } else if (type == IItemRenderer.ItemRenderType.ENTITY) {
      GL11.glRotatef(90.5F, 0.0F, 1.0F, 0.0F);
      GL11.glTranslated(0.0D, 0.0D, -0.9D);
    } 
  }

  
  
  public int getUpgradeCap(ItemStack itemstack) {
    return BalanceConfigHandler.draconicToolsMaxUpgrades;
  }
  
  public int getMaxTier(ItemStack itemstack) {
    return 3;
  }
  
  public List<String> getUpgradeStats(ItemStack stack) {
    return super.getUpgradeStats(stack);
  }
  
  public int getCapacity(ItemStack stack) {
    int points = IUpgradableItem.EnumUpgrade.RF_CAPACITY.getUpgradePoints(stack);
    return (int) (BalanceConfigHandler.draconicToolsBaseStorage * 1.5 + points * BalanceConfigHandler.draconicToolsStoragePerUpgrade);
  }
  
  public int getMaxUpgradePoints(int upgradeIndex) {
	    if (upgradeIndex == IUpgradableItem.EnumUpgrade.RF_CAPACITY.index)
	      return BalanceConfigHandler.draconicToolsMaxCapacityUpgradePoints; 
	    if (upgradeIndex == IUpgradableItem.EnumUpgrade.DIG_AOE.index)
	      return 7; 
	    if (upgradeIndex == IUpgradableItem.EnumUpgrade.DIG_DEPTH.index)
	      return 9; 
	    if (upgradeIndex == IUpgradableItem.EnumUpgrade.DIG_SPEED.index)
	      return 64; 
	    return BalanceConfigHandler.draconicToolsMaxUpgradePoints;
	  }
	  public List<IUpgradableItem.EnumUpgrade> getUpgrades(ItemStack itemstack) {
		  List<IUpgradableItem.EnumUpgrade> list = super.getUpgrades(itemstack);
		  list.add(IUpgradableItem.EnumUpgrade.DIG_SPEED);
		    list.add(IUpgradableItem.EnumUpgrade.DIG_DEPTH);
		    list.add(IUpgradableItem.EnumUpgrade.DIG_AOE);
		    list.add(IUpgradableItem.EnumUpgrade.RF_CAPACITY);
		    return list;
	  }
	  public int getBaseUpgradePoints(int upgradeIndex) {
	    if (upgradeIndex == IUpgradableItem.EnumUpgrade.DIG_AOE.index)
	      return 3; 
	    if (upgradeIndex == IUpgradableItem.EnumUpgrade.DIG_DEPTH.index)
	      return 5; 
	    if (upgradeIndex == IUpgradableItem.EnumUpgrade.DIG_SPEED.index)
	      return 32; 
	    return 0;
	  }
}
