package com.Denfop.item.energy;

import com.Denfop.Helpers;
import com.Denfop.SuperSolarPanels;
import com.Denfop.blockCoord;
import com.Denfop.proxy.CommonProxy;
import com.google.common.collect.ImmutableSet;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.core.IC2;

import java.util.ArrayList;
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
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class ultDDrill extends ItemTool implements IElectricItem {
  private int maxCharge;
  
  private int tier;
  
  private float effPower;
  
  private float bigHolePower;
  
  private float normalPower;
  
  private float lowPower;
  
  private float ultraLowPower;
  
  private int maxWorkRange;
  
  private int energyPerOperation;
  
  private int energyPerLowOperation;
  
  private int energyPerUltraLowOperation;
  
  private int transferLimit;
  
  public Set mineableBlocks = new HashSet();
  
  public int soundTicker;
  
  public int damageVsEntity;

private Object charge;
  
  private static Material[] materials = new Material[] { Material.rock, Material.grass, Material.ground, Material.sand, Material.clay };
  
  public static List<blockCoord> workMatrix = new ArrayList<blockCoord>();
  
  public ultDDrill(Item.ToolMaterial toolMaterial) {
    super(0.0F, toolMaterial, new HashSet());
    setMaxDamage(27);
    this.maxCharge = 45000;
    this.transferLimit = 500;
    this.tier = 2;
    this.normalPower = 35.0F;
    this.efficiencyOnProperMaterial = this.normalPower;
    this.effPower = 35.0F;
    this.bigHolePower = 16.0F;
    this.lowPower = 16.0F;
    this.ultraLowPower = 10.0F;
    this.energyPerOperation = 160;
    this.energyPerLowOperation = 80;
    this.energyPerUltraLowOperation = 50;
    this.damageVsEntity = 1;
    this.maxWorkRange = 2;
    setCreativeTab(SuperSolarPanels.tabssp);
    init();
    
  }
  
  public boolean createWorkMatrix(World world, EntityPlayer player, int startXPos, int startYPos, int startZPos) {
    int xPos, yPos, zPos;
    MovingObjectPosition clickPos = raytraceFromEntity(world, (Entity)player, true, 4.5D);
    if (clickPos == null)
      return false; 
    int xRange = 2;
    int yRange = 2;
    int zRange = 2;
    switch (clickPos.sideHit) {
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
    workMatrix.clear();
    if (xRange == 1) {
      xPos = startXPos - this.maxWorkRange;
    } else {
      xPos = startXPos;
    } 
    if (yRange == 1) {
      yPos = startYPos - this.maxWorkRange;
    } else {
      yPos = startYPos;
    } 
    if (zRange == 1) {
      zPos = startZPos - this.maxWorkRange;
    } else {
      zPos = startZPos;
    } 
    int blocksCount = this.maxWorkRange * 2 + 1;
    for (int i = 1; i <= blocksCount; i++) {
      for (int j = 1; j <= blocksCount; j++) {
        blockCoord newBlockCoord = new blockCoord();
        if (xRange == 0) {
          newBlockCoord.X = xPos;
          newBlockCoord.Y = yPos + i + 1;
          newBlockCoord.Z = zPos + j + 1;
        } 
        if (yRange == 0) {
          newBlockCoord.X = xPos + i + 1 ;
          newBlockCoord.Y = yPos;
          newBlockCoord.Z = zPos + j + 1;
        } 
        if (zRange == 0) {
          newBlockCoord.X = xPos + i + 1;
          newBlockCoord.Y = yPos + j + 1;
          newBlockCoord.Z = zPos;
        } 
        System.out.println("X: " + newBlockCoord.X + " Y: " + newBlockCoord.Y + " Z: " + newBlockCoord.Z);
        workMatrix.add(newBlockCoord);
      } 
    } 
    return true;
  }
  
  public void init() {
    this.mineableBlocks.add(Blocks.grass);
    this.mineableBlocks.add(Blocks.dirt);
    this.mineableBlocks.add(Blocks.mycelium);
    this.mineableBlocks.add(Blocks.sand);
    this.mineableBlocks.add(Blocks.gravel);
    this.mineableBlocks.add(Blocks.snow);
    this.mineableBlocks.add(Blocks.snow_layer);
    this.mineableBlocks.add(Blocks.clay);
    this.mineableBlocks.add(Blocks.soul_sand);
  }
  
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
    return (Set<String>)ImmutableSet.of("pickaxe", "shovel");
  }
  
  public boolean canHarvestBlock(Block block, ItemStack stack) {
    return (Items.diamond_pickaxe.canHarvestBlock(block, stack) || Items.diamond_pickaxe.func_150893_a(stack, block) > 1.0F || Items.diamond_shovel.canHarvestBlock(block, stack) || Items.diamond_shovel.func_150893_a(stack, block) > 1.0F || this.mineableBlocks.contains(block));
  }
  
  public float getDigSpeed(ItemStack tool, Block block, int meta) {
    if (!ElectricItem.manager.canUse(tool, this.energyPerOperation))
      return 1.0F; 
    if (canHarvestBlock(block, tool))
      return this.efficiencyOnProperMaterial; 
    return 1.0F;
  }
  
  public int getHarvestLevel(ItemStack stack, String toolClass) {
    if (toolClass.equals("pickaxe") || toolClass.equals("shovel"))
      return this.toolMaterial.getHarvestLevel(); 
    return super.getHarvestLevel(stack, toolClass);
  }
  
  public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3) {
    return true;
  }
  
  public int getDamageVsEntity(Entity par1Entity) {
    return this.damageVsEntity;
  }
  
  public boolean isRepairable() {
    return false;
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister par1IconRegister) {
    this.itemIcon = par1IconRegister.registerIcon("supersolarpanel:drill");
  }
  
  public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
    Integer toolMode = readToolMode(stack);
    if (toolMode.intValue() == 3) {
      World world = player.worldObj;
      Block block = world.getBlock(x, y, z);
      int meta = world.getBlockMetadata(x, y, z);
      Boolean lowPower = Boolean.valueOf(false);
      if (block == null)
        return super.onBlockStartBreak(stack, x, y, z, player); 
      float blockHardness = block.getBlockHardness(world, x, y, z);
      boolean validStart = false;
      for (int iter = 0; iter < materials.length; iter++) {
        if (materials[iter] == block.getMaterial()) {
          validStart = true;
          break;
        } 
      } 
      if (block == Blocks.monster_egg)
        validStart = true; 
      MovingObjectPosition mop = raytraceFromEntity(world, (Entity)player, true, 4.5D);
      if (mop == null || !validStart)
        return super.onBlockStartBreak(stack, x, y, z, player); 
      int xRange = 2;
      int yRange = 2;
      int zRange = 2;
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
      int fortune = EnchantmentHelper.getFortuneModifier((EntityLivingBase)player);
      for (int xPos = x - xRange; xPos <= x + xRange; xPos++) {
        for (int yPos = y - yRange; yPos <= y + yRange; yPos++) {
          for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
            if (ElectricItem.manager.canUse(stack, this.energyPerOperation)) {
              Block localBlock = world.getBlock(xPos, yPos, zPos);
              int localMeta = world.getBlockMetadata(xPos, yPos, zPos);
              boolean canHarvest = canHarvestBlock(block, stack);
              float localHardness = (localBlock == null) ? Float.MAX_VALUE : localBlock.getBlockHardness(world, xPos, yPos, zPos);
              if (canHarvest) {
                boolean cancelHarvest = false;
                if (!cancelHarvest)
                  if (localBlock != null && localHardness >= 0.0F)
                    for (int i = 0; i < materials.length; i++) {
                      if (materials[i] == localBlock.getMaterial() || localBlock == Blocks.monster_egg)
                        if (!player.capabilities.isCreativeMode) {
                          if (localBlock.removedByPlayer(world, player, xPos, yPos, zPos))
                            localBlock.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, localMeta); 
                          int exp = localBlock.getExpDrop((IBlockAccess)world, localMeta, fortune);
                          localBlock.dropXpOnBlockBreak(world, xPos, yPos, zPos, exp);
                          localBlock.harvestBlock(world, player, xPos, yPos, zPos, localMeta);
                          localBlock.onBlockHarvested(world, xPos, yPos, zPos, localMeta, player);
                          if (blockHardness > 0.0F)
                            onBlockDestroyed(stack, world, localBlock, xPos, yPos, zPos, (EntityLivingBase)player); 
                          world.func_147479_m(x, y, z);
                          ElectricItem.manager.use(stack, this.energyPerOperation, (EntityLivingBase)player);
                        } else {
                          Helpers.setBlockToAir(world, xPos, yPos, zPos);
                          world.func_147479_m(x, y, z);
                        }  
                    }   
              } 
            } else {
              lowPower = Boolean.valueOf(true);
            } 
          } 
        } 
      } 
      if (!SuperSolarPanels.isSimulating())
        world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (meta << 12)); 
      if (lowPower.booleanValue())
        CommonProxy.sendPlayerMessage(player, "Not enough energy to complete this operation !"); 
      return true;
    } 
    
    if (toolMode.intValue() == 2) {
        World world = player.worldObj;
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);
     
        Boolean lowPower = Boolean.valueOf(false);
        if (block == null)
          return super.onBlockStartBreak(stack, x, y, z, player); 
        float blockHardness = block.getBlockHardness(world, x, y, z);
        boolean validStart = false;
        for (int iter = 0; iter < materials.length; iter++) {
          if (materials[iter] == block.getMaterial()) {
            validStart = true;
            break;
          } 
        } 
        if (block == Blocks.monster_egg)
          validStart = true; 
        MovingObjectPosition mop = raytraceFromEntity(world, (Entity)player, true, 4.5D);
        if (mop == null || !validStart)
          return super.onBlockStartBreak(stack, x, y, z, player); 
        int xRange = 1;
        int yRange = 1;
        int zRange = 1;
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
        int fortune = EnchantmentHelper.getFortuneModifier((EntityLivingBase)player);
        for (int xPos = x - xRange; xPos <= x + xRange; xPos++) {
          for (int yPos = y - yRange; yPos <= y + yRange; yPos++) {
            for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
              if (ElectricItem.manager.canUse(stack, this.energyPerOperation)) {
                Block localBlock = world.getBlock(xPos, yPos, zPos);
                int localMeta = world.getBlockMetadata(xPos, yPos, zPos);
                boolean canHarvest = canHarvestBlock(block, stack);
                float localHardness = (localBlock == null) ? Float.MAX_VALUE : localBlock.getBlockHardness(world, xPos, yPos, zPos);
                if (canHarvest) {
                  boolean cancelHarvest = false;
                  if (!cancelHarvest)
                    if (localBlock != null && localHardness >= 0.0F)
                      for (int i = 0; i < materials.length; i++) {
                        if (materials[i] == localBlock.getMaterial() || localBlock == Blocks.monster_egg)
                          if (!player.capabilities.isCreativeMode) {
                            if (localBlock.removedByPlayer(world, player, xPos, yPos, zPos))
                              localBlock.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, localMeta); 
                            int exp = localBlock.getExpDrop((IBlockAccess)world, localMeta, fortune);
                            localBlock.dropXpOnBlockBreak(world, xPos, yPos, zPos, exp);
                            localBlock.harvestBlock(world, player, xPos, yPos, zPos, localMeta);
                            localBlock.onBlockHarvested(world, xPos, yPos, zPos, localMeta, player);
                            if (blockHardness > 0.0F)
                              onBlockDestroyed(stack, world, localBlock, xPos, yPos, zPos, (EntityLivingBase)player); 
                            world.func_147479_m(x, y, z);
                            ElectricItem.manager.use(stack, this.energyPerOperation, (EntityLivingBase)player);
                          } else {
                            Helpers.setBlockToAir(world, xPos, yPos, zPos);
                            world.func_147479_m(x, y, z);
                          }  
                      }   
                } 
              } else {
                lowPower = Boolean.valueOf(true);
              } 
            } 
          } 
        } 
        if (!SuperSolarPanels.isSimulating())
          world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (meta << 12)); 
        if (lowPower.booleanValue())
          CommonProxy.sendPlayerMessage(player, "Not enough energy to complete this operation !"); 
        return true;
      } 
    return false;
  }
  
  public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int xPos, int yPos, int zPos, EntityLivingBase entityliving) {
    if (!SuperSolarPanels.isSimulating())
      return true; 
    if (block == null)
      return false; 
    Integer toolMode = readToolMode(itemstack);
    if (toolMode.intValue() == 0) {
      if (block.getBlockHardness(world, xPos, yPos, zPos) != 0.0D && 
        entityliving != null)
        ElectricItem.manager.use(itemstack, this.energyPerOperation, entityliving); 
      return true;
    } 
    if (toolMode.intValue() == 1) {
      if (block.getBlockHardness(world, xPos, yPos, zPos) != 0.0D && 
        entityliving != null)
        ElectricItem.manager.use(itemstack, this.energyPerLowOperation, entityliving); 
      return true;
    } 
    if (toolMode.intValue() == 2) {
    	 return true;
    } 
    if (toolMode.intValue() == 3);
    return true;
  }
  
  public static Integer readToolMode(ItemStack itemstack) {
    NBTTagCompound nbttagcompound = SuperSolarPanels.getOrCreateNbtData(itemstack);
    Integer toolMode = Integer.valueOf(nbttagcompound.getInteger("toolMode"));
    if (toolMode.intValue() < 0 || toolMode.intValue() > 3)
      toolMode = Integer.valueOf(0); 
    return toolMode;
  }
  
  public void saveToolMode(ItemStack itemstack, Integer toolMode) {
    NBTTagCompound nbttagcompound = SuperSolarPanels.getOrCreateNbtData(itemstack);
    nbttagcompound.setInteger("toolMode", toolMode.intValue());
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
      Integer toolMode = readToolMode(itemStack);
      toolMode = Integer.valueOf(toolMode.intValue() + 1);
      if (toolMode.intValue() > 3)
        toolMode = Integer.valueOf(0); 
      saveToolMode(itemStack, toolMode);
      if (toolMode.intValue() == 0) {
        CommonProxy.sendPlayerMessage(player, EnumChatFormatting.GREEN + Helpers.formatMessage("message.text.mode") + ": " + Helpers.formatMessage("message.ultDDrill.mode.normal"));
        this.efficiencyOnProperMaterial = this.normalPower;
        Map<Integer, Integer> enchantmentMap = new HashMap<Integer, Integer>();
        enchantmentMap.put(Integer.valueOf(Enchantment.efficiency.effectId), Integer.valueOf(10));
        EnchantmentHelper.setEnchantments(enchantmentMap, itemStack);
      } 
      if (toolMode.intValue() == 1) {
    	  CommonProxy.sendPlayerMessage(player, EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": " + Helpers.formatMessage("message.ultDDrill.mode.lowPower"));
        this.efficiencyOnProperMaterial = this.lowPower;
       
      } 
      if (toolMode.intValue() == 2) {
    	  CommonProxy.sendPlayerMessage(player, EnumChatFormatting.AQUA + Helpers.formatMessage("message.text.mode") + ": " + Helpers.formatMessage("message.ultDDrill.mode.bigHoles"));
        this.efficiencyOnProperMaterial = this.bigHolePower;
        Map<Integer, Integer> enchantmentMap = new HashMap<Integer, Integer>();
        enchantmentMap.put(Integer.valueOf(Enchantment.silkTouch.effectId), Integer.valueOf(1));
        EnchantmentHelper.setEnchantments(enchantmentMap, itemStack);
      } 
      if (toolMode.intValue() == 3) {
        this.efficiencyOnProperMaterial = this.bigHolePower;
        CommonProxy.sendPlayerMessage(player, EnumChatFormatting.LIGHT_PURPLE + Helpers.formatMessage("message.text.mode") + ": " + Helpers.formatMessage("message.ultDDrill.mode.bigHoles1"));
        Map<Integer, Integer> enchantmentMap = new HashMap<Integer, Integer>();
        enchantmentMap.put(Integer.valueOf(Enchantment.fortune.effectId), Integer.valueOf(5));
        EnchantmentHelper.setEnchantments(enchantmentMap, itemStack);
      } 
    } 
    return itemStack;
  }
  
  public static MovingObjectPosition raytraceFromEntity(World world, Entity player, boolean par3, double range) {
    float f = 1.0F;
    float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
    float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
    double d0 = player.prevPosX + (player.posX - player.prevPosX) * f;
    double d1 = player.prevPosY + (player.posY - player.prevPosY) * f;
    if (!world.isRemote && player instanceof EntityPlayer)
      d1 += 1.62D; 
    double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * f;
    Vec3 vec3 = Vec3.createVectorHelper(d0, d1, d2);
    float f3 = MathHelper.cos(-f2 * 0.017453292F - 3.1415927F);
    float f4 = MathHelper.sin(-f2 * 0.017453292F - 3.1415927F);
    float f5 = -MathHelper.cos(-f1 * 0.017453292F);
    float f6 = MathHelper.sin(-f1 * 0.017453292F);
    float f7 = f4 * f5;
    float f8 = f3 * f5;
    double d3 = range;
    if (player instanceof EntityPlayerMP)
      d3 = ((EntityPlayerMP)player).theItemInWorldManager.getBlockReachDistance(); 
    Vec3 vec31 = vec3.addVector(f7 * d3, f6 * d3, f8 * d3);
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
  public void getSubItems(Item item, CreativeTabs var2, List var3) {
    ItemStack var4 = new ItemStack((Item)this, 1);
    
    ElectricItem.manager.charge(var4, 2.147483647E9D, 2147483647, true, false);
    var3.add(var4);
    var3.add(new ItemStack((Item)this, 1, getMaxDamage()));
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
