package com.Denfop.item.armour;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.core.IC2;
import ic2.core.IC2Potion;
import ic2.core.Ic2Items;
import ic2.core.audio.AudioSource;
import ic2.core.audio.PositionSpec;
import ic2.core.init.MainConfig;
import ic2.core.item.ItemTinCan;
import ic2.core.item.armor.ItemArmorElectric;
import ic2.core.util.ConfigUtil;
import ic2.core.util.StackUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.base.ItemElerctirc;
import com.Denfop.utils.InternalName;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class ItemArmorQuantumSuit1 extends ItemElerctirc {
  public ItemArmorQuantumSuit1(InternalName internalName, int armorType1) {
    super(internalName, InternalName.quantum, armorType1, SuperSolarPanels.Storagequantumsuit, 12000.0D, 4);
    if (armorType1 == 3)
      MinecraftForge.EVENT_BUS.register(this); 
    potionRemovalCost.put(Integer.valueOf(Potion.poison.id), Integer.valueOf(100));
    potionRemovalCost.put(Integer.valueOf(IC2Potion.radiation.id), Integer.valueOf(1000));
    potionRemovalCost.put(Integer.valueOf(Potion.wither.id), Integer.valueOf(100));
  }
  
  @SideOnly(Side.CLIENT)
  public boolean requiresMultipleRenderPasses() {
    return true;
  }
  
  public boolean hasColor(ItemStack aStack) {
    return (getColor(aStack) != 10511680);
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
    return getIconFromDamage(par1);
  }
  
  public void removeColor(ItemStack par1ItemStack) {
    NBTTagCompound tNBT = par1ItemStack.getTagCompound();
    if (tNBT != null) {
      tNBT = tNBT.getCompoundTag("display");
      if (tNBT.hasKey("color"))
        tNBT.removeTag("color"); 
    } 
  }
  
  public int getColor(ItemStack aStack) {
    NBTTagCompound tNBT = aStack.getTagCompound();
    if (tNBT == null)
      return 10511680; 
    tNBT = tNBT.getCompoundTag("display");
    return (tNBT == null) ? 10511680 : (tNBT.hasKey("color") ? tNBT.getInteger("color") : 10511680);
  }
  
  public void colorQArmor(ItemStack aStack, int par2) {
    NBTTagCompound tNBT = aStack.getTagCompound();
    if (tNBT == null) {
      tNBT = new NBTTagCompound();
      aStack.setTagCompound(tNBT);
    } 
    if (!tNBT.hasKey("display"))
      tNBT.setTag("display", (NBTBase)tNBT); 
    tNBT = tNBT.getCompoundTag("display");
    tNBT.setInteger("color", par2);
  }
  
  public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase entity, ItemStack armor, DamageSource source, double damage, int slot) {
    if (source == DamageSource.fall && this.armorType == 3) {
      int energyPerDamage = getEnergyPerDamage();
      int damageLimit = Integer.MAX_VALUE;
      if (energyPerDamage > 0)
        damageLimit = (int)Math.min(damageLimit, 25.0D * ElectricItem.manager.getCharge(armor) / energyPerDamage); 
      return new ISpecialArmor.ArmorProperties(10, 1.0D, damageLimit);
    } 
    return super.getProperties(entity, armor, source, damage, slot);
  }
  
  @SubscribeEvent
  public void onEntityLivingFallEvent(LivingFallEvent event) {
    if (IC2.platform.isSimulating() && event.entity instanceof EntityLivingBase) {
      EntityLivingBase entity = (EntityLivingBase)event.entity;
      ItemStack armor = entity.getEquipmentInSlot(1);
      if (armor != null && armor.getItem() == this) {
        int fallDamage = Math.max((int)event.distance - 10, 0);
        double energyCost = (getEnergyPerDamage() * fallDamage);
        if (energyCost <= ElectricItem.manager.getCharge(armor)) {
          ElectricItem.manager.discharge(armor, energyCost, 2147483647, true, false, false);
          event.setCanceled(true);
        } 
      } 
    } 
  }
  
  public double getDamageAbsorptionRatio() {
    if (this.armorType == 1)
      return 1.1D; 
    return 1.0D;
  }
  
  public int getEnergyPerDamage() {
    return 20000;
  }
  
  @SideOnly(Side.CLIENT)
  public EnumRarity getRarity(ItemStack stack) {
    return EnumRarity.rare;
  }
  
  public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
    int air;
    boolean Nightvision;
    short hubmode;
    boolean jetpack, hoverMode, jetpackUsed, enableQuantumSpeedOnSprint;
    NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
    byte toggleTimer = nbtData.getByte("toggleTimer");
    boolean ret = false;
    switch (this.armorType) {
      case 0:
        IC2.platform.profilerStartSection("QuantumHelmet");
        air = player.getAir();
        if (ElectricItem.manager.canUse(itemStack, 1000.0D) && air < 100) {
          player.setAir(air + 200);
          ElectricItem.manager.use(itemStack, 1000.0D, null);
          ret = true;
        } else if (air <= 0) {
          IC2.achievements.issueAchievement(player, "starveWithQHelmet");
        } 
        if (ElectricItem.manager.canUse(itemStack, 1000.0D) && player.getFoodStats().needFood()) {
          int slot = -1;
          for (int i = 0; i < player.inventory.mainInventory.length; i++) {
            if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i]
              .getItem() == Ic2Items.filledTinCan.getItem()) {
              slot = i;
              break;
            } 
          } 
          if (slot > -1) {
            ItemStack stack = player.inventory.mainInventory[slot];
            ItemTinCan can = (ItemTinCan)stack.getItem();
            stack = can.onEaten(player, stack);
            if (stack.stackSize <= 0)
              player.inventory.mainInventory[slot] = null; 
            ElectricItem.manager.use(itemStack, 1000.0D, null);
            ret = true;
          } 
        } else if (player.getFoodStats().getFoodLevel() <= 0) {
          IC2.achievements.issueAchievement(player, "starveWithQHelmet");
        } 
       
          
          
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
        break;
      case 1:
        IC2.platform.profilerStartSection("QuantumBodyarmor");
        jetpack = nbtData.getBoolean("jetpack");
        hoverMode = nbtData.getBoolean("hoverMode");
        jetpackUsed = false;
        if (IC2.keyboard.isJumpKeyDown(player) && IC2.keyboard.isModeSwitchKeyDown(player) && toggleTimer == 0) {
          toggleTimer = 10;
          hoverMode = !hoverMode;
          if (IC2.platform.isSimulating()) {
            nbtData.setBoolean("hoverMode", hoverMode);
            if (hoverMode) {
              IC2.platform.messagePlayer(player, "Quantum Hover Mode enabled.", new Object[0]);
            } else {
              IC2.platform.messagePlayer(player, "Quantum Hover Mode disabled.", new Object[0]);
            } 
          } 
        } 
       
        if(SuperSolarPanels.disableeffect) {
        
        } else {
        	player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 300));
        }
        
        

        if (IC2.keyboard.isBoostKeyDown(player) && IC2.keyboard.isModeSwitchKeyDown(player) && toggleTimer == 0) {
          toggleTimer = 10;
          jetpack = !jetpack;
          if (IC2.platform.isSimulating()) {
            nbtData.setBoolean("jetpack", jetpack);
            if (jetpack) {
              IC2.platform.messagePlayer(player, "Quantum Jetpack enabled.", new Object[0]);
            } else {
              IC2.platform.messagePlayer(player, "Quantum Jetpack disabled.", new Object[0]);
            } 
          } 
        } 
        if (jetpack && (IC2.keyboard.isJumpKeyDown(player) || (hoverMode && player.motionY < -0.029999999329447746D)))
          jetpackUsed = useJetpack(player, hoverMode); 
        if (IC2.platform.isSimulating() && toggleTimer > 0) {
          toggleTimer = (byte)(toggleTimer - 1);
          nbtData.setByte("toggleTimer", toggleTimer);
        } 
        if (IC2.platform.isRendering() && player == IC2.platform.getPlayerInstance()) {
          if (lastJetpackUsed != jetpackUsed) {
            if (jetpackUsed) {
              if (audioSource == null)
                audioSource = IC2.audioManager.createSource(player, PositionSpec.Backpack, "Tools/Jetpack/JetpackLoop.ogg", true, false, IC2.audioManager.getDefaultVolume()); 
              if (audioSource != null)
                audioSource.play(); 
            } else if (audioSource != null) {
              audioSource.remove();
              audioSource = null;
            } 
            lastJetpackUsed = jetpackUsed;
          } 
          if (audioSource != null)
            audioSource.updatePosition(); 
        } 
        ret = jetpackUsed;
        player.extinguish();
        IC2.platform.profilerEndSection();
        break;
      case 2:
        IC2.platform.profilerStartSection("QuantumLeggings");
        if (IC2.platform.isRendering()) {
          enableQuantumSpeedOnSprint = ConfigUtil.getBool(MainConfig.get(), "misc/quantumSpeedOnSprint");
        } else {
          enableQuantumSpeedOnSprint = true;
        } 
        if (ElectricItem.manager.canUse(itemStack, 1000.0D) && (player.onGround || player
          .isInWater()) && IC2.keyboard
          .isForwardKeyDown(player) && ((enableQuantumSpeedOnSprint && player
          .isSprinting()) || (!enableQuantumSpeedOnSprint && IC2.keyboard
          .isBoostKeyDown(player)))) {
          byte speedTicker = nbtData.getByte("speedTicker");
          speedTicker = (byte)(speedTicker + 1);
          if (speedTicker >= 10) {
            speedTicker = 0;
            ElectricItem.manager.use(itemStack, 1000.0D, null);
            ret = true;
          } 
          nbtData.setByte("speedTicker", speedTicker);
          float speed = 0.22F;
          if (player.isInWater()) {
            speed = 0.1F;
            if (IC2.keyboard.isJumpKeyDown(player))
              player.motionY += 0.10000000149011612D; 
          } 
          if (speed > 0.0F)
            player.moveFlying(0.0F, 1.0F, speed); 
        } if(SuperSolarPanels.disableeffect3) {
        	
        } else {
        	 player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 300));
        	       
        }
        IC2.platform.profilerEndSection();
        break;
      case 3:
        IC2.platform.profilerStartSection("QuantumBoots");
        if (IC2.platform.isSimulating()) {
          boolean wasOnGround = nbtData.hasKey("wasOnGround") ? nbtData.getBoolean("wasOnGround") : true;
          if (wasOnGround && !player.onGround && IC2.keyboard
            
            .isJumpKeyDown(player) && IC2.keyboard
            .isBoostKeyDown(player)) {
            ElectricItem.manager.use(itemStack, 4000.0D, null);
            ret = true;
          } 
          if (player.onGround != wasOnGround)
            nbtData.setBoolean("wasOnGround", player.onGround); 
        } else {
          if (ElectricItem.manager.canUse(itemStack, 4000.0D) && player.onGround)
            this.jumpCharge = 4.5F; 
          if (player.motionY >= 0.0D && this.jumpCharge > 0.0F && !player.isInWater())
            if (IC2.keyboard.isJumpKeyDown(player) && IC2.keyboard.isBoostKeyDown(player)) {
              if (this.jumpCharge == 3.0F) {
                player.motionX *= 4.5D;
                player.motionZ *= 4.5D;
              } 
              player.motionY += (this.jumpCharge * 0.3F);
              this.jumpCharge = (float)(this.jumpCharge * 0.75D);
            } else if (this.jumpCharge < 1.0F) {
              this.jumpCharge = 0.0F;
            }  
        } 
        if (!player.capabilities.isFlying && player.moveForward > 0.0F) {
            if (player.worldObj.isRemote && !player.isSneaking()) {
               player.stepHeight = 1.0F;
            } 
            if (player.onGround) {
              float bonus = 0.055F;
              if (player.isInWater())
                bonus /= 4.0F; 
              player.moveFlying(0.0F, 1.0F, bonus);
            
              player.jumpMovementFactor = 0.25F;
            
          } 
          if (player.fallDistance > 0.0F)
            player.fallDistance -= 0.25F; 
        }
        if(SuperSolarPanels.disableeffect1) {
        
        }else {
        	player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 300));
        }
        if(SuperSolarPanels.disableeffect2) {
        
        }else {
        	player.addPotionEffect(new PotionEffect(Potion.jump.id, 300));
        }
        IC2.platform.profilerEndSection();
        break;
       
    } 
    if (ret)
      player.inventoryContainer.detectAndSendChanges(); 
  }
  
  public int getItemEnchantability() {
    return 0;
  }
  
  public boolean useJetpack(EntityPlayer player, boolean hoverMode) {
    ItemStack jetpack = player.inventory.armorInventory[2];
    if (ElectricItem.manager.getCharge(jetpack) == 0.0D)
      return false; 
    float power = 1.0F;
    float dropPercentage = 0.05F;
    if ((float)ElectricItem.manager.getCharge(jetpack) / getMaxCharge(jetpack) <= dropPercentage)
      power = (float)(power * ElectricItem.manager.getCharge(jetpack) / getMaxCharge(jetpack) * dropPercentage); 
    if (IC2.keyboard.isForwardKeyDown(player)) {
      float retruster = 3.5F;
      if (hoverMode)
        retruster = 0.5F; 
      float forwardpower = power * retruster * 2.0F;
      if (forwardpower > 0.0F)
        player.moveFlying(0.0F, 0.4F * forwardpower, 0.02F); 
    } 
    int worldHeight = IC2.getWorldHeight(player.worldObj);
    double y = player.posY;
    if (y > (worldHeight - 25)) {
      if (y > worldHeight)
        y = worldHeight; 
      power = (float)(power * (worldHeight - y) / 25.0D);
    } 
    double prevmotion = player.motionY;
    player.motionY = Math.min(player.motionY + (power * 0.2F), 0.6000000238418579D);
    if (hoverMode) {
      float maxHoverY = -0.025F;
      if (IC2.keyboard.isSneakKeyDown(player))
        maxHoverY = -0.1F; 
      if (IC2.keyboard.isJumpKeyDown(player))
        maxHoverY = 0.1F; 
      if (player.motionY > maxHoverY) {
        player.motionY = maxHoverY;
        if (prevmotion > player.motionY)
          player.motionY = prevmotion; 
      } 
    } 
    double consume = 8.0D;
    if (hoverMode)
      consume = 10.0D; 
    ElectricItem.manager.discharge(jetpack, consume, 2147483647, true, false, false);
    player.fallDistance = 0.0F;
    player.distanceWalkedModified = 0.0F;
    IC2.platform.resetPlayerInAirTime(player);
    return true;
  }
  
  protected static final Map<Integer, Integer> potionRemovalCost = new HashMap<Integer, Integer>();
  
  private float jumpCharge;
  
  public static AudioSource audioSource;
  
  private static boolean lastJetpackUsed = false;
}
