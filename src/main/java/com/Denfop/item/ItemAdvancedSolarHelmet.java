// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.item;

import net.minecraft.item.EnumRarity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

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
import ic2.core.util.StackUtil;
import ic2.api.item.IElectricItem;
import net.minecraft.item.ItemArmor;

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
    
    public ItemAdvancedSolarHelmet(final ItemArmor.ArmorMaterial par2EnumArmorMaterial, final int par3, final int par4, final int htype) {
        super(par2EnumArmorMaterial, par3, par4);
        this.solarType = htype;
        this.maxCharge = 1000000.0;
        this.transferLimit = 3000.0;
        this.tier = 3;
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
    
    public void onArmorTick(final World worldObj, final EntityPlayer player, final ItemStack itemStack) {
        if (worldObj.isRemote) {
            return;
        }
        int air;
        boolean Nightvision;
        short hubmode;
        boolean jetpack, hoverMode, jetpackUsed, enableQuantumSpeedOnSprint;
        NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
        byte toggleTimer = nbtData.getByte("toggleTimer");
        boolean ret = false;
        Nightvision = nbtData.getBoolean("Nightvision");
       
        Nightvision = nbtData.getBoolean("Nightvision");
        hubmode = nbtData.getShort("HudMode");
        if (IC2.keyboard.isAltKeyDown(player) && IC2.keyboard.isModeSwitchKeyDown(player) && toggleTimer == 0) {
          toggleTimer = 10;
          Nightvision = !Nightvision;
          if (IC2.platform.isSimulating()) {
            nbtData.setBoolean("Nightvision", Nightvision);
            if (Nightvision) {
              IC2.platform.messagePlayer(player, "Nightvision enabled.", new Object[0]);
            } else {
              IC2.platform.messagePlayer(player, "Nightvision disabled.", new Object[0]);
            } 
          } 
        } 
        if (IC2.keyboard.isAltKeyDown(player) && IC2.keyboard.isHudModeKeyDown(player) && toggleTimer == 0) {
          toggleTimer = 10;
          if (hubmode == 2) {
            hubmode = 0;
          } else {
            hubmode = (short)(hubmode + 1);
          } 
          if (IC2.platform.isSimulating()) {
            nbtData.setShort("HudMode", hubmode);
            switch (hubmode) {
              case 0:
                IC2.platform.messagePlayer(player, "HUD disabled.", new Object[0]);
                break;
              case 1:
                IC2.platform.messagePlayer(player, "HUD (basic) enabled.", new Object[0]);
                break;
              case 2:
                IC2.platform.messagePlayer(player, "HUD (extended) enabled", new Object[0]);
                break;
            } 
          } 
        } 
        if (IC2.platform.isSimulating() && toggleTimer > 0) {
          toggleTimer = (byte)(toggleTimer - 1);
          nbtData.setByte("toggleTimer", toggleTimer);
        } 
        if (Nightvision && IC2.platform.isSimulating() && 
          ElectricItem.manager.use(itemStack, 1.0D, (EntityLivingBase)player)) {
          int x = MathHelper.floor_double(player.posX);
          int z = MathHelper.floor_double(player.posZ);
          int y = MathHelper.floor_double(player.posY);
          int skylight = player.worldObj.getBlockLightValue(x, y, z);
          if (skylight > 15) {
            IC2.platform.removePotion((EntityLivingBase)player, Potion.nightVision.id);
            
          } else {
           
            player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 300, 0, true));
          } 
          ret = true;
        } 
        IC2.platform.profilerEndSection();
       
         
        this.gainFuel(player);
        if (this.solarType == 2 || this.solarType == 3) {
            final int airLevel = player.getAir();
            if (ElectricItem.manager.canUse(itemStack, 1000.0) && airLevel < 100) {
                player.setAir(airLevel + 200);
                ElectricItem.manager.use(itemStack, 1000.0, (EntityLivingBase)null);
            }
        }
        if (this.generating > 0) {
            int energyLeft = this.generating;
            for (int i = 0; i < player.inventory.armorInventory.length; ++i) {
                if (energyLeft <= 0) {
                    return;
                }
                if (player.inventory.armorInventory[i] != null && player.inventory.armorInventory[i].getItem() instanceof IElectricItem) {
                    final double sentPacket = ElectricItem.manager.charge(player.inventory.armorInventory[i], (double)energyLeft, 4, false, false);
                    energyLeft -= (int)sentPacket;
                }
            }
            for (int j = 0; j < player.inventory.mainInventory.length; ++j) {
                if (energyLeft <= 0) {
                    return;
                }
                if (player.inventory.mainInventory[j] != null && player.inventory.mainInventory[j].getItem() instanceof IElectricItem) {
                    final double sentPacket = ElectricItem.manager.charge(player.inventory.mainInventory[j], (double)energyLeft, 4, false, false);
                    energyLeft -= (int)sentPacket;
                }
            }
        }
    }
    
    public int gainFuel(final EntityPlayer player) {
        if (this.ticker++ % tickRate() == 0) {
            this.updateVisibility(player);
        }
        if (this.sunIsUp && this.skyIsVisible) {
            return this.generating = 0 + this.genDay;
        }
        if (this.skyIsVisible) {
            return this.generating = 0 + this.genNight;
        }
        return this.generating = 0;
    }
    
    public void updateVisibility(final EntityPlayer player) {
        this.wetBiome = (player.worldObj.getWorldChunkManager().getBiomeGenAt((int)player.posX, (int)player.posZ).getIntRainfall() > 0);
        this.noSunWorld = player.worldObj.provider.hasNoSky;
        final Boolean rainWeather = this.wetBiome && (player.worldObj.isRaining() || player.worldObj.isThundering());
        if (!player.worldObj.isDaytime() || rainWeather) {
            this.sunIsUp = false;
        }
        else {
            this.sunIsUp = true;
        }
        if (!player.worldObj.canBlockSeeTheSky((int)player.posX, (int)player.posY + 1, (int)player.posZ) || this.noSunWorld) {
            this.skyIsVisible = false;
        }
        else {
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
    
    public double getTransferLimit(final ItemStack itemStack) {
        return this.transferLimit;
    }
}
