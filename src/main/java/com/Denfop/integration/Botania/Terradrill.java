package com.Denfop.integration.Botania;


import com.Denfop.SuperSolarPanels;
import com.Denfop.proxy.CommonProxy;
import com.Denfop.utils.Helpers;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.core.IC2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class Terradrill extends ItemTool implements IElectricItem {
  public static final Set<Block> mineableBlocks = Sets.newHashSet(new Block[] { (Block)Blocks.grass, Blocks.dirt, (Block)Blocks.mycelium, (Block)Blocks.sand, Blocks.gravel, Blocks.snow, Blocks.snow_layer, Blocks.clay, Blocks.soul_sand });
  
  private static final Set<Material> materials = Sets.newHashSet(new Material[] { Material.rock, Material.grass, Material.ground, Material.sand, Material.clay });
  
  private static final Set<String> toolType = (Set<String>)ImmutableSet.of("pickaxe", "shovel");
  
  private float effPower = 35.0F;
  
  private float bigHolePower = 16.0F;
  
  private float normalPower = 35.0F;
  
  private float lowPower = 16.0F;
  
  private float ultraLowPower = 10.0F;
  
  private int maxCharge = 45000;
  
  private int tier = 2;
  
  private int maxWorkRange = 1;
  
  private int energyPerOperation = 160;
  
  private int energyPerLowOperation = 80;
  
  private int energyPerUltraLowOperation = 50;
  
  private int transferLimit = 500;
  
  public int soundTicker;
  
  public int damageVsEntity = 1;
  
  public Terradrill(Item.ToolMaterial toolMaterial) {
    super(0.0F, toolMaterial, new HashSet());
    setMaxDamage(27);
    this.efficiencyOnProperMaterial = this.normalPower;
    setCreativeTab(SuperSolarPanels.tabssp);
  }
  
  public boolean hitEntity(ItemStack stack, EntityLivingBase damagee, EntityLivingBase damager) {
    return true;
  }
  
  public void init() {}
  
  public boolean canProvideEnergy(ItemStack itemStack) {
    return false;
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
  
  public Set<String> getToolClasses(ItemStack stack) {
    return toolType;
  }
  
  public boolean canHarvestBlock(Block block, ItemStack stack) {
    return (Items.diamond_pickaxe.canHarvestBlock(block, stack) || Items.diamond_pickaxe.func_150893_a(stack, block) > 1.0F || Items.diamond_shovel.canHarvestBlock(block, stack) || Items.diamond_shovel.func_150893_a(stack, block) > 1.0F || mineableBlocks.contains(block));
  }
  
  public float getDigSpeed(ItemStack tool, Block block, int meta) {
    return !ElectricItem.manager.canUse(tool, this.energyPerOperation) ? 1.0F : (canHarvestBlock(block, tool) ? this.efficiencyOnProperMaterial : 1.0F);
  }
  
  public int getHarvestLevel(ItemStack stack, String toolType) {
    return (!toolType.equals("pickaxe") && !toolType.equals("shovel")) ? super.getHarvestLevel(stack, toolType) : this.toolMaterial.getHarvestLevel();
  }
  
  public boolean hitEntity(ItemStack stack, EntityLiving entity1, EntityLiving entity2) {
    return true;
  }
  
  public int getDamageVsEntity(Entity entity) {
    return this.damageVsEntity;
  }
  
  public boolean isRepairable() {
    return false;
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister register) {
    this.itemIcon = register.registerIcon("supersolarpanel:teradrill");
  }
  
  public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
    if (readToolMode(stack) == 1 || readToolMode(stack) == 0)
      return false; 
    if (readToolMode(stack) == 2) {
    World world = player.worldObj;
    Block block = world.getBlock(x, y, z);
    int meta = world.getBlockMetadata(x, y, z);
    if (block == null)
      return super.onBlockStartBreak(stack, x, y, z, player); 
    MovingObjectPosition mop = raytraceFromEntity(world, (Entity)player, true, 4.5D);
    if (mop != null && (materials.contains(block.getMaterial()) || block == Blocks.monster_egg)) {
      byte xRange = 1;
      byte yRange = 1;
      byte zRange = 1;
      switch (mop.sideHit) {
        case 0:
        case 1:
          yRange = 0;
          break;
        case 2:
        case 3:
          zRange = 0;
          break;
        case 4:
        case 5:
          xRange = 0;
          break;
      } 
      boolean lowPower = false;
      boolean silktouch = EnchantmentHelper.getSilkTouchModifier((EntityLivingBase)player);
      int fortune = EnchantmentHelper.getFortuneModifier((EntityLivingBase)player);
     
      for (int xPos = x - xRange; xPos <= x + xRange; xPos++) {
        for (int yPos = y - yRange; yPos <= y + yRange; yPos++) {
          for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
            if (ElectricItem.manager.canUse(stack, this.energyPerOperation)) {
              Block localBlock = world.getBlock(xPos, yPos, zPos);
              if (localBlock != null && canHarvestBlock(localBlock, stack) && 
                localBlock.getBlockHardness(world, xPos, yPos, zPos) >= 0.0F && (
                materials.contains(localBlock.getMaterial()) || block == Blocks.monster_egg))
                
                  if (!player.capabilities.isCreativeMode) {
                    int localMeta = world.getBlockMetadata(xPos, yPos, zPos);
                    if (localBlock.getBlockHardness(world, xPos, yPos, zPos) > 0.0F)
                      onBlockDestroyed(stack, world, localBlock, xPos, yPos, zPos, (EntityLivingBase)player); 
                    if (!silktouch)
                      localBlock.dropXpOnBlockBreak(world, xPos, yPos, zPos, localBlock.getExpDrop((IBlockAccess)world, localMeta, fortune)); 
                    localBlock.onBlockHarvested(world, xPos, yPos, zPos, localMeta, player);
                    if (localBlock.removedByPlayer(world, player, xPos, yPos, zPos, true)) {
                      localBlock.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, localMeta);
                      localBlock.harvestBlock(world, player, xPos, yPos, zPos, localMeta);
                    } 
                    ElectricItem.manager.use(stack, this.energyPerOperation, (EntityLivingBase)player);
                  } else {
                    world.setBlockToAir(xPos, yPos, zPos);
                  } 
                  world.func_147479_m(xPos, yPos, zPos);
                  
            } else {
              lowPower = true;
              break;
            } 
          } 
        } 
      } 
      if (lowPower) {
        CommonProxy.sendPlayerMessage(player, "Not enough energy to complete this operation !");
      } else if (!SuperSolarPanels.isSimulating()) {
        world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (meta << 12));
      } 
      return true;
    } }
    //
    if (readToolMode(stack) == 3) {
        World world = player.worldObj;
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);
        if (block == null)
          return super.onBlockStartBreak(stack, x, y, z, player); 
        MovingObjectPosition mop = raytraceFromEntity(world, (Entity)player, true, 4.5D);
        if (mop != null && (materials.contains(block.getMaterial()) || block == Blocks.monster_egg)) {
          byte xRange = 2;
          byte yRange = 2;
          byte zRange = 2;
          switch (mop.sideHit) {
            case 0:
            case 1:
              yRange = 0;
              break;
            case 2:
            case 3:
              zRange = 0;
              break;
            case 4:
            case 5:
              xRange = 0;
              break;
          } 
          boolean lowPower = false;
          boolean silktouch = EnchantmentHelper.getSilkTouchModifier((EntityLivingBase)player);
          int fortune = EnchantmentHelper.getFortuneModifier((EntityLivingBase)player);
         
          for (int xPos = x - xRange; xPos <= x + xRange; xPos++) {
            for (int yPos = y - yRange; yPos <= y + yRange; yPos++) {
              for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
                if (ElectricItem.manager.canUse(stack, this.energyPerOperation)) {
                  Block localBlock = world.getBlock(xPos, yPos, zPos);
                  if (localBlock != null && canHarvestBlock(localBlock, stack) && 
                    localBlock.getBlockHardness(world, xPos, yPos, zPos) >= 0.0F && (
                    materials.contains(localBlock.getMaterial()) || block == Blocks.monster_egg))
                    
                      if (!player.capabilities.isCreativeMode) {
                        int localMeta = world.getBlockMetadata(xPos, yPos, zPos);
                        if (localBlock.getBlockHardness(world, xPos, yPos, zPos) > 0.0F)
                          onBlockDestroyed(stack, world, localBlock, xPos, yPos, zPos, (EntityLivingBase)player); 
                        if (!silktouch)
                          localBlock.dropXpOnBlockBreak(world, xPos, yPos, zPos, localBlock.getExpDrop((IBlockAccess)world, localMeta, fortune)); 
                        localBlock.onBlockHarvested(world, xPos, yPos, zPos, localMeta, player);
                        if (localBlock.removedByPlayer(world, player, xPos, yPos, zPos, true)) {
                          localBlock.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, localMeta);
                          localBlock.harvestBlock(world, player, xPos, yPos, zPos, localMeta);
                        } 
                        ElectricItem.manager.use(stack, this.energyPerOperation, (EntityLivingBase)player);
                      } else {
                        world.setBlockToAir(xPos, yPos, zPos);
                      } 
                      world.func_147479_m(xPos, yPos, zPos);
                      
                } else {
                  lowPower = true;
                  break;
                } 
              } 
            } 
          } 
          if (lowPower) {
            CommonProxy.sendPlayerMessage(player, "Not enough energy to complete this operation !");
          } else if (!SuperSolarPanels.isSimulating()) {
            world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (meta << 12));
          } 
          return true;
        } }
    //
    return super.onBlockStartBreak(stack, x, y, z, player);
  }
  
  public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int xPos, int yPos, int zPos, EntityLivingBase entity) {
    if (!SuperSolarPanels.isSimulating())
      return true; 
    if (block == null)
      return false; 
    if (entity != null) {
      float energy;
      int toolMode = readToolMode(stack);
      switch (toolMode) {
        case 0:
          energy = this.energyPerOperation;
          break;
        case 1:
          energy = this.energyPerLowOperation;
          break;
        default:
          energy = 0.0F;
          break;
      } 
      if (energy != 0.0F && block.getBlockHardness(world, xPos, yPos, zPos) != 0.0F)
        ElectricItem.manager.use(stack, energy, entity); 
    } 
    return true;
  }
  
  public static int readToolMode(ItemStack itemstack) {
    NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(itemstack);
    int toolMode = nbt.getInteger("toolMode");
   
    if (toolMode < 0 || toolMode > 3)
      toolMode = 0; 
    return toolMode;
  }
  
  public void saveToolMode(ItemStack itemstack, int toolMode) {
    NBTTagCompound nbt = SuperSolarPanels.getOrCreateNbtData(itemstack);
    nbt.setInteger("toolMode", toolMode);
  }
  
  public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset) {
    for (int i = 0; i < player.inventory.mainInventory.length; i++) {
      ItemStack torchStack = player.inventory.mainInventory[i];
      if (torchStack != null && torchStack.getUnlocalizedName().toLowerCase().contains("torch")) {
        Item item = torchStack.getItem();
        if (item instanceof net.minecraft.item.ItemBlock) {
          int oldMeta = torchStack.getItemDamage();
          int oldSize = torchStack.stackSize;
          boolean result = torchStack.tryPlaceItemIntoWorld(player, world, x, y, z, side, xOffset, yOffset, zOffset);
          if (player.capabilities.isCreativeMode) {
            torchStack.setItemDamage(oldMeta);
            torchStack.stackSize = oldSize;
          } else if (torchStack.stackSize <= 0) {
            ForgeEventFactory.onPlayerDestroyItem(player, torchStack);
            player.inventory.mainInventory[i] = null;
          } 
          if (result)
            return true; 
        } 
      } 
    } 
    return super.onItemUse(stack, player, world, x, y, z, side, xOffset, yOffset, zOffset);
  }
  
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    if (IC2.keyboard.isModeSwitchKeyDown(player)) {
      int toolMode = readToolMode(itemStack) + 1;
      
      if (toolMode > 3)
        toolMode = 0; 
      saveToolMode(itemStack, toolMode);
      switch (toolMode) {
        case 0:
          CommonProxy.sendPlayerMessage(player, EnumChatFormatting.GREEN + Helpers.formatMessage("message.text.mode") + ": " + Helpers.formatMessage("message.ultDDrill.mode.normal"));
          this.efficiencyOnProperMaterial = this.normalPower;
         
          
                break;
          
        case 1:
        	 Map<Integer, Integer> enchantmentMap3 = new HashMap<Integer, Integer>();
      
        	CommonProxy.sendPlayerMessage(player, EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": " + Helpers.formatMessage("message.ultDDrill.mode.lowPower"));
          this.efficiencyOnProperMaterial = this.lowPower;
          break;
        case 2:
        	CommonProxy.sendPlayerMessage(player, EnumChatFormatting.AQUA + Helpers.formatMessage("message.text.mode") + ": " + Helpers.formatMessage("message.ultDDrill.mode.bigHoles"));
          this.efficiencyOnProperMaterial = this.bigHolePower;
        
          break;
        case 3:
        	CommonProxy.sendPlayerMessage(player, EnumChatFormatting.LIGHT_PURPLE + Helpers.formatMessage("message.text.mode") + ": " + Helpers.formatMessage("message.ultDDrill.mode.bigHoles1"));
          this.efficiencyOnProperMaterial = this.bigHolePower * 2;
         
          break;
      } 
    } 
    return itemStack;
  }
  
  public static MovingObjectPosition raytraceFromEntity(World world, Entity player, boolean par3, double range) {
    float pitch = player.rotationPitch;
    float yaw = player.rotationYaw;
    double x = player.posX;
    double y = player.posY;
    double z = player.posZ;
    if (!world.isRemote && player instanceof EntityPlayer)
      y++; 
    Vec3 vec3 = Vec3.createVectorHelper(x, y, z);
    float f3 = MathHelper.cos(-yaw * 0.017453292F - 3.1415927F);
    float f4 = MathHelper.sin(-yaw * 0.017453292F - 3.1415927F);
    float f5 = -MathHelper.cos(-pitch * 0.017453292F);
    float f6 = MathHelper.sin(-pitch * 0.017453292F);
    float f7 = f4 * f5;
    float f8 = f3 * f5;
    if (player instanceof EntityPlayerMP)
      range = ((EntityPlayerMP)player).theItemInWorldManager.getBlockReachDistance(); 
    Vec3 vec31 = vec3.addVector(range * f7, range * f6, range * f8);
    return world.func_147447_a(vec3, vec31, par3, !par3, par3);
  }
  
  @SideOnly(Side.CLIENT)
  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
    Integer toolMode = readToolMode(par1ItemStack);
    if (toolMode.intValue() == 0)
      par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": " + EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.normal")); 
    if (toolMode.intValue() == 1)
      par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": " + EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.lowPower")); 
    if (toolMode.intValue() == 2)
      par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": " + EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.bigHoles")); 
    if (toolMode.intValue() == 3)
      par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": " + EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.bigHoles1")); 
  }
  
  public String getRandomDrillSound() {
    switch (SuperSolarPanels.random.nextInt(4)) {
      case 1:
        return "drillOne";
      case 2:
        return "drillTwo";
      case 3:
        return "drillThree";
    } 
    return "drill";
  }
  
  @SideOnly(Side.CLIENT)
  public void getSubItems(Item item, CreativeTabs tab, List subs) {
    ItemStack stack = new ItemStack((Item)this, 1);
    ElectricItem.manager.charge(stack, 2.147483647E9D, 2147483647, true, false);
    subs.add(stack);
    subs.add(new ItemStack((Item)this, 1, getMaxDamage()));
  }
  
  @SideOnly(Side.CLIENT)
  public EnumRarity getRarity(ItemStack var1) {
    return EnumRarity.uncommon;
  }
  
  public Item getChargedItem(ItemStack itemStack) {
    return (Item)this;
  }
  
  public Item getEmptyItem(ItemStack itemStack) {
    return (Item)this;
  }
}
