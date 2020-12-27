package com.Denfop.item.reactor;

import com.Denfop.item.base.ItemSSP;
import com.Denfop.utils.InternalName;

import ic2.core.IC2Potion;
import ic2.core.item.armor.ItemArmorHazmat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemRadioactive extends ItemSSP {
  protected final int radiationLength;
  
  protected final int amplifier;
  
  public ItemRadioactive(InternalName internalName, int radiationLength1, int amplifier1) {
    super(internalName);
    this.radiationLength = radiationLength1;
    this.amplifier = amplifier1;
  }
  
  public void onUpdate(Item stack, World world, Entity entity, int slotIndex, boolean isCurrentItem) {
    if (entity instanceof EntityLivingBase) {
      EntityLivingBase entityLiving = (EntityLivingBase)entity;
      if (!ItemArmorHazmat.hasCompleteHazmat(entityLiving)) {
        PotionEffect effect = ((EntityPlayer)entity).getActivePotionEffect((Potion)IC2Potion.radiation);
        if (effect == null) {
          IC2Potion.radiation.applyTo(entityLiving, this.radiationLength * 20, this.amplifier);
        } else {
          IC2Potion.radiation.applyTo(entityLiving, ((EntityPlayer)entity).getActivePotionEffect((Potion)IC2Potion.radiation).getDuration() + this.radiationLength, this.amplifier);
        } 
      } 
    } 
  }
}
