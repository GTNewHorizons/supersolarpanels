package com.Denfop.item.energy;

import com.Denfop.SuperSolarPanels;
import com.Denfop.item.base.ItemElectricTool;
import com.Denfop.utils.InternalName;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.core.IC2;
import ic2.core.util.StackUtil;
import java.util.EnumSet;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemNanoSaber extends ItemElectricTool {
  public ItemNanoSaber(InternalName internalName) {
    this(internalName, 10, ItemElectricTool.HarvestLevel.Diamond);
  }
  
  public ItemNanoSaber(InternalName internalName, int operationEnergyCost, ItemElectricTool.HarvestLevel harvestLevel) {
    super(internalName, operationEnergyCost, harvestLevel, EnumSet.of(ItemElectricTool.ToolClass.Sword));
    this.soundTicker = 0;
    this.maxCharge = SuperSolarPanels.maxCharge;
    this.transferLimit = SuperSolarPanels.transferLimit;
    this.tier = SuperSolarPanels.tier;
  }
  public void addInformation(final ItemStack itemStack, final EntityPlayer player, final List info, final boolean b) {
  	  info.add(StatCollector.translateToLocal("ssp.spectralsaberactive") + SuperSolarPanels.spectralsaberactive);
      
      info.add(StatCollector.translateToLocal("ic2.item.tooltip.PowerTier") + " " + this.tier);
      info.add(StatCollector.translateToLocal("ssp.maxCharge") + this.maxCharge + " EU");
      info.add(StatCollector.translateToLocal("ssp.transferLimit") + this.transferLimit);
 
  }
  public void SubItems(Item item, CreativeTabs tabs, List<ItemStack> itemList) {
	    ItemStack charged = new ItemStack((Item)this, 1);
	    ElectricItem.manager.charge(charged, Double.POSITIVE_INFINITY, 2147483647, true, false);
	    itemList.add(charged);
	    itemList.add(new ItemStack((Item)this, 1, getMaxDamage()));
	  }
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister iconRegister) {
    this.textures = new IIcon[2];
    this.textures[0] = iconRegister.registerIcon(SuperSolarPanels.TEXTURES + ":" + getUnlocalizedName().substring(4) + "." + InternalName.off.name());
    this.textures[1] = iconRegister.registerIcon(SuperSolarPanels.TEXTURES + ":" + getUnlocalizedName().substring(4) + "." + InternalName.active.name());
  }
  
  @SideOnly(Side.CLIENT)
  public boolean requiresMultipleRenderPasses() {
    return true;
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon getIcon(ItemStack itemStack, int pass) {
    NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
    if (nbtData.getBoolean("active"))
      return this.textures[1]; 
    return this.textures[0];
  }
  
  public float getDigSpeed(ItemStack itemStack, Block block, int meta) {
    NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
    if (nbtData.getBoolean("active")) {
      this.soundTicker++;
      if (this.soundTicker % 4 == 0)
        IC2.platform.playSoundSp(getRandomSwingSound(), 1.0F, 1.0F); 
      return 4.0F;
    } 
    return 1.0F;
  }
  
  public Multimap getAttributeModifiers(ItemStack stack) {
    int dmg = SuperSolarPanels.spectralsabernotactive1;
    if (ElectricItem.manager.canUse(stack, 400.0D)) {
      NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(stack);
      if (nbtData.getBoolean("active"))
        dmg = SuperSolarPanels.spectralsaberactive; 
    } 
    HashMultimap hashMultimap = HashMultimap.create();
    hashMultimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Tool modifier", dmg, 0));
    return (Multimap)hashMultimap;
  }
  
  public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase source) {
    NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(stack);
    if (!nbtData.getBoolean("active"))
      return true; 
    if (IC2.platform.isSimulating()) {
      drainSaber(stack, 400.0D, source);
      if (!(source instanceof EntityPlayer) || MinecraftServer.getServer().isPVPEnabled() || !(target instanceof EntityPlayer))
        for (int i = 0; i < 4 && ElectricItem.manager.canUse(stack, 2000.0D); i++) {
          ItemStack armor = target.getEquipmentInSlot(i + 1);
          if (armor != null) {
            double amount = 0.0D;
            if (armor.getItem() instanceof ic2.core.item.armor.ItemArmorNanoSuit) {
              amount = 48000.0D;
            } else if (armor.getItem() instanceof ic2.core.item.armor.ItemArmorQuantumSuit) {
              amount = 300000.0D;
            } 
            if (amount > 0.0D) {
              ElectricItem.manager.discharge(armor, amount, this.tier, true, false, false);
              if (!ElectricItem.manager.canUse(armor, 1.0D))
                target.setCurrentItemOrArmor(i + 1, null); 
              drainSaber(stack, 2000.0D, source);
            } 
          } 
        }  
    } 
    if (IC2.platform.isRendering())
      IC2.platform.playSoundSp(getRandomSwingSound(), 1.0F, 1.0F); 
    return true;
  }
  
  public String getRandomSwingSound() {
    switch (IC2.random.nextInt(3)) {
      default:
        return "Tools/Nanosabre/NanosabreSwing1.ogg";
      case 1:
        return "Tools/Nanosabre/NanosabreSwing2.ogg";
      case 2:
        break;
    } 
    return "Tools/Nanosabre/NanosabreSwing3.ogg";
  }
  
  public boolean onBlockStartBreak(ItemStack itemStack, int i, int j, int k, EntityPlayer player) {
    NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
    if (nbtData.getBoolean("active"))
      drainSaber(itemStack, 80.0D, (EntityLivingBase)player); 
    return false;
  }
  
  public boolean isFull3D() {
    return true;
  }
  
  public static void drainSaber(ItemStack itemStack, double amount, EntityLivingBase entity) {
    if (!ElectricItem.manager.use(itemStack, amount, entity)) {
      NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
      nbtData.setBoolean("active", false);
      updateAttributes(nbtData);
    } 
  }
  
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityplayer) {
    if (!IC2.platform.isSimulating())
      return itemStack; 
    NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
    if (nbtData.getBoolean("active")) {
      nbtData.setBoolean("active", false);
      updateAttributes(nbtData);
    } else if (ElectricItem.manager.canUse(itemStack, 16.0D)) {
      nbtData.setBoolean("active", true);
      updateAttributes(nbtData);
      IC2.platform.playSoundSp("Tools/Nanosabre/NanosabrePowerup.ogg", 1.0F, 1.0F);
    } 
    return super.onItemRightClick(itemStack, world, entityplayer);
  }
  
  public static int ticker = 0;
  
  @SideOnly(Side.CLIENT)
  private IIcon[] textures;
  
  private int soundTicker;
  
  public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean par5) {
    NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
    if (!nbtData.getBoolean("active"))
      return; 
    if (ticker % 16 == 0 && entity instanceof net.minecraft.entity.player.EntityPlayerMP)
      if (slot < 9) {
        drainSaber(itemStack, 64.0D, (EntityLivingBase)entity);
      } else if (ticker % 64 == 0) {
        drainSaber(itemStack, 16.0D, (EntityLivingBase)entity);
      }  
  }
  
  @SideOnly(Side.CLIENT)
  public EnumRarity getRarity(ItemStack stack) {
    return EnumRarity.uncommon;
  }
  
  private static void updateAttributes(NBTTagCompound nbtData) {
    boolean active = nbtData.getBoolean("active");
    int damage = active ? SuperSolarPanels.spectralsaberactive : SuperSolarPanels.spectralsabernotactive;
    NBTTagCompound entry = new NBTTagCompound();
    entry.setString("AttributeName", SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
    entry.setLong("UUIDMost", field_111210_e.getMostSignificantBits());
    entry.setLong("UUIDLeast", field_111210_e.getLeastSignificantBits());
    entry.setString("Name", "Tool modifier");
    entry.setDouble("Amount", damage);
    entry.setInteger("Operation", 0);
    NBTTagList list = new NBTTagList();
    list.appendTag((NBTBase)entry);
    nbtData.setTag("AttributeModifiers", (NBTBase)list);
  }
}
