
package com.Denfop.item.solarhelmet;

import net.minecraft.item.EnumRarity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.Denfop.SuperSolarPanels;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import ic2.api.item.ElectricItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import ic2.api.item.IMetalArmor;
import ic2.core.IC2;
import ic2.core.IC2Potion;
import ic2.core.util.StackUtil;
import ic2.api.item.IElectricItem;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;

public class ItemAdvancedSolarHelmet extends ItemArmor implements IElectricItem, IMetalArmor, ISpecialArmor
{
    private double maxCharge;
    private double transferLimit;
    private int tier;
    private int ticker;
    private int generating;
    private int genDay;
    private int genNight;
    private int solarType;
    private int energyPerDamage;
    private double damageAbsorptionRatio;
    private double baseAbsorptionRatio;
    private boolean initialized;
    private boolean sunIsUp;
    private boolean skyIsVisible;
    private boolean noSunWorld;
    private boolean wetBiome;
	private boolean ret = false;
    
    public ItemAdvancedSolarHelmet(final ItemArmor.ArmorMaterial par2EnumArmorMaterial, final int par3, final int par4, final int htype) {
        super(par2EnumArmorMaterial, par3, par4);
        this.solarType = htype;
        this.maxCharge = 1000000.0;
        this.transferLimit = 3000.0;
        potionRemovalCost.put(Integer.valueOf(Potion.poison.id), Integer.valueOf(100));
        potionRemovalCost.put(Integer.valueOf(IC2Potion.radiation.id), Integer.valueOf(300));
        potionRemovalCost.put(Integer.valueOf(Potion.wither.id), Integer.valueOf(100));
        potionRemovalCost.put(Integer.valueOf(Potion.hunger.id), Integer.valueOf(200));
        this.tier = 4;
        if (this.solarType == 1) {
            this.genDay = SuperSolarPanels.advGenDay;
            this.genNight = SuperSolarPanels.advGenNight;
            this.maxCharge = 1000000.0;
            this.transferLimit = 3000.0;
            this.tier = 3;
            this.energyPerDamage = 800;
            this.damageAbsorptionRatio = 0.9;
            this.baseAbsorptionRatio = 0.15;
        }
        if (this.solarType == 2) {
            this.genDay = SuperSolarPanels.hGenDay;
            this.genNight = SuperSolarPanels.hGenNight;
            this.maxCharge = 1.0E7;
            this.transferLimit = 10000.0;
            this.tier = 4;
            this.energyPerDamage = 2000;
            this.damageAbsorptionRatio = 1.0;
            this.baseAbsorptionRatio = 0.15;
        }
        if (this.solarType == 3) {
            this.genDay = SuperSolarPanels.uhGenDay;
            this.genNight = SuperSolarPanels.uhGenNight;
            this.maxCharge = 1.0E7;
            this.transferLimit = 10000.0;
            this.tier = 4;
            this.energyPerDamage = 2000;
            this.damageAbsorptionRatio = 1.0;
            this.baseAbsorptionRatio = 0.15;
        }
        this.setCreativeTab(SuperSolarPanels.tabssp);
        this.setMaxDamage(27);
    }
    
    public void onArmorTick(World worldObj, EntityPlayer player, ItemStack itemStack) {
        if (worldObj.isRemote)
          return; 
        gainFuel(player);
        for (Object effect : new LinkedList(player.getActivePotionEffects())) {
            int id = ((PotionEffect) effect).getPotionID();
            Integer cost = potionRemovalCost.get(Integer.valueOf(id));
            if (cost != null) {
              cost = Integer.valueOf(cost.intValue() * (((PotionEffect) effect).getAmplifier() + 1));
              if (ElectricItem.manager.canUse(itemStack, cost.intValue())) {
                ElectricItem.manager.use(itemStack, cost.intValue(), null);
                IC2.platform.removePotion((EntityLivingBase)player, id);
              } 
            } 
          } 
        if (ElectricItem.manager.canUse(itemStack, 1000.0D) && player.getFoodStats().needFood()) {
            int slot = -1;
            for (int i = 0; i < player.inventory.mainInventory.length; i++) {
              if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i]
                .getItem() instanceof ItemFood) {
                slot = i;
                break;
              } 
            } 
            if (slot > -1) {
              ItemStack stack = player.inventory.mainInventory[slot];
              ItemFood can = (ItemFood)stack.getItem();
              stack = can.onEaten(stack, worldObj, player);
              if (stack.stackSize <= 0)
                player.inventory.mainInventory[slot] = null; 
              ElectricItem.manager.use(itemStack, 1000.0D, null);
              ret  = true;
            } 
          } else if (player.getFoodStats().getFoodLevel() <= 0) {
            IC2.achievements.issueAchievement(player, "starveWithQHelmet");
          } 
        if (this.solarType == 2 || this.solarType == 3) {
          int airLevel = player.getAir();
          if (ElectricItem.manager.canUse(itemStack, 1000.0D) && airLevel < 100) {
            player.setAir(airLevel + 200);
            ElectricItem.manager.use(itemStack, 1000.0D, (EntityLivingBase)null);
          } 
        } 
        if (this.generating > 0) {
          int energyLeft = this.generating;
          for (int i = 0; i < player.inventory.armorInventory.length; i++) {
            if (energyLeft > 0) {
              if (player.inventory.armorInventory[i] != null && player.inventory.armorInventory[i].getItem() instanceof IElectricItem) {
                double sentPacket = ElectricItem.manager.charge(player.inventory.armorInventory[i], energyLeft, 2147483647, false, false);
                energyLeft = (int)(energyLeft - sentPacket);
              } 
            } else {
              return;
            } 
          } 
          for (int j = 0; j < player.inventory.mainInventory.length; j++) {
            if (energyLeft > 0) {
              if (player.inventory.mainInventory[j] != null && player.inventory.mainInventory[j].getItem() instanceof IElectricItem) {
                double sentPacket = ElectricItem.manager.charge(player.inventory.mainInventory[j], energyLeft, 2147483647, false, false);
                energyLeft = (int)(energyLeft - sentPacket);
              } 
            } else {
              return;
            } 
          } 
        } 
        if (ret )
            player.inventoryContainer.detectAndSendChanges(); 
      }
      
      public int gainFuel(EntityPlayer player) {
        if (this.ticker++ % tickRate() == 0)
          updateVisibility(player); 
        if (this.sunIsUp && this.skyIsVisible) {
          this.generating = 0 + this.genDay;
          return this.generating;
        } 
        if (this.skyIsVisible) {
          this.generating = 0 + this.genNight;
          return this.generating;
        } 
        this.generating = 0;
        return this.generating;
      }
      
      public void updateVisibility(EntityPlayer player) {
        this.wetBiome = (player.worldObj.getWorldChunkManager().getBiomeGenAt((int)player.posX, (int)player.posZ).getIntRainfall() > 0);
        this.noSunWorld = player.worldObj.provider.hasNoSky;
        Boolean rainWeather = Boolean.valueOf((this.wetBiome && (player.worldObj.isRaining() || player.worldObj.isThundering())));
        if (!player.worldObj.isDaytime() || rainWeather.booleanValue()) {
          this.sunIsUp = false;
        } else {
          this.sunIsUp = true;
        } 
        if (!player.worldObj.canBlockSeeTheSky((int)player.posX, (int)player.posY + 1, (int)player.posZ) || this.noSunWorld) {
          this.skyIsVisible = false;
        } else {
          this.skyIsVisible = true;
        } 
      }
      
    public boolean isMetalArmor(final ItemStack itemstack, final EntityPlayer player) {
        return true;
    }
    
    public ISpecialArmor.ArmorProperties getProperties(final EntityLivingBase player, final ItemStack armor, final DamageSource source, final double damage, final int slot) {
        if (source.isUnblockable()) {
            return new ISpecialArmor.ArmorProperties(0, 0.0, 0);
        }
        final double absorptionRatio = this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio();
        final int energyPerDamage = this.getEnergyPerDamage();
        final int damageLimit = (int)((energyPerDamage > 0) ? (25.0 * ElectricItem.manager.getCharge(armor) / energyPerDamage) : 0.0);
        return new ISpecialArmor.ArmorProperties(0, absorptionRatio, damageLimit);
    }
    
    public int getArmorDisplay(final EntityPlayer player, final ItemStack armor, final int slot) {
        if (ElectricItem.manager.getCharge(armor) >= this.getEnergyPerDamage()) {
            return (int)Math.round(20.0 * this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio());
        }
        return 0;
    }
    
    public void damageArmor(final EntityLivingBase entity, final ItemStack stack, final DamageSource source, final int damage, final int slot) {
        ElectricItem.manager.discharge(stack, (double)(damage * this.getEnergyPerDamage()), Integer.MAX_VALUE, true, false, false);
    }
    
    public int getEnergyPerDamage() {
        return this.energyPerDamage;
    }
    
    public double getDamageAbsorptionRatio() {
        return this.damageAbsorptionRatio;
    }
    
    private double getBaseAbsorptionRatio() {
        return this.baseAbsorptionRatio;
    }
    
    public static int tickRate() {
        return 128;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(final Item item, final CreativeTabs var2, final List var3) {
        final ItemStack var4 = new ItemStack((Item)this, 1);
        ElectricItem.manager.charge(var4, 2.147483647E9, Integer.MAX_VALUE, true, false);
        var3.add(var4);
        var3.add(new ItemStack((Item)this, 1, this.getMaxDamage()));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister IIconRegister) {
        if (this.solarType == 1) {
            this.itemIcon = IIconRegister.registerIcon("supersolarpanel:AdvSolarHelmet");
        }
        if (this.solarType == 2) {
            this.itemIcon = IIconRegister.registerIcon("supersolarpanel:HybridSolarHelmet");
        }
        if (this.solarType == 3) {
            this.itemIcon = IIconRegister.registerIcon("supersolarpanel:UltimateSolarHelmet");
        }
    }
    
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (this.solarType == 1) {
            return "supersolarpanel:textures/armor/advancedSolarHelmet.png";
        }
        if (this.solarType == 2) {
            return "supersolarpanel:textures/armor/hybridSolarHelmet.png";
        }
        if (this.solarType == 3) {
            return "supersolarpanel:textures/armor/ultimateSolarHelmet.png";
        }
        return "";
    }
    
    @SideOnly(Side.CLIENT)
    public EnumRarity func_77613_e(final ItemStack var1) {
        if (this.solarType == 1) {
            return EnumRarity.uncommon;
        }
        if (this.solarType == 2) {
            return EnumRarity.rare;
        }
        return EnumRarity.epic;
    }
    
    public boolean canProvideEnergy(final ItemStack itemStack) {
        return false;
    }
    
    public Item getChargedItem(final ItemStack itemStack) {
        return (Item)this;
    }
    
    public Item getEmptyItem(final ItemStack itemStack) {
        return (Item)this;
    }
    
    public double getMaxCharge(final ItemStack itemStack) {
        return this.maxCharge;
    }
    
    public int getTier(final ItemStack itemStack) {
        return this.tier;
    }
    protected static final Map<Integer, Integer> potionRemovalCost = new HashMap<Integer, Integer>();
    public double getTransferLimit(final ItemStack itemStack) {
        return this.transferLimit;
    }
}
