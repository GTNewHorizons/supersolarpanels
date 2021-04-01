package com.Denfop.item.energy;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.proxy.CommonProxy;
import com.Denfop.utils.Helpers;
import com.Denfop.utils.ModUtils;
import com.Denfop.utils.NBTData;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
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
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.oredict.OreDictionary;

public class AdvancedMultiTool extends ItemTool implements IElectricItem {
	public static final Set<Block> mineableBlocks = Sets.newHashSet(new Block[] { Blocks.cobblestone,
			Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone,
			Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore,
			Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block,
			Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail,
			Blocks.activator_rail, Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.planks,
			Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.leaves,
			Blocks.leaves2, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand,
			Blocks.mycelium, });

	private static final Set<Material> materials = Sets.newHashSet(new Material[] { Material.iron, Material.anvil,
			Material.rock, Material.glass, Material.ice, Material.packedIce, Material.wood, Material.leaves,
			Material.coral, Material.cactus, Material.plants, Material.vine, Material.grass, Material.ground,
			Material.sand, Material.snow, Material.craftedSnow, Material.clay });

	private static final Set<String> toolType = (Set<String>) ImmutableSet.of("pickaxe", "shovel", "axe");

	private float bigHolePower = Config.bigHolePower;

	private float normalPower = Config.effPower;

	private float lowPower = Config.lowPower;

	private float ultraLowPower = Config.ultraLowPower;

	private int maxCharge = Config.ultdrillmaxCharge;

	private int tier = Config.ultdrilltier;

	private int maxWorkRange = 1;

	private int energyPerOperation = Config.energyPerOperation;

	private int energyPerLowOperation = Config.energyPerLowOperation;

	private int energyPerbigHolePowerOperation = Config.energyPerbigHolePowerOperation;
	private int energyPerultraLowPowerOperation = Config.energyPerultraLowPowerOperation;

	private int transferLimit = Config.ultdrilltransferLimit;

	public int soundTicker;

	public int damageVsEntity = 1;

	public int mode;

	public float energyPerultraLowPowerOperation1 = Config.energyPerultraLowPowerOperation1;

	private float ultraLowPower1 = Config.ultraLowPower1;

	public AdvancedMultiTool(Item.ToolMaterial toolMaterial) {
		super(0.0F, toolMaterial, new HashSet());
		setMaxDamage(27);
		this.efficiencyOnProperMaterial = this.normalPower;
		setCreativeTab(IUCore.tabssp2);
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase damagee, EntityLivingBase damager) {
		return true;
	}

	public void init() {
	}
	 public int getItemEnchantability()
	    {
		 return 0;
	    }
	 public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
			return false;
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
		return toolType;
	}

	public boolean canHarvestBlock(Block block, ItemStack stack) {
		return (Items.diamond_axe.canHarvestBlock(block, stack) || Items.diamond_axe.func_150893_a(stack, block) > 1.0F
				|| Items.diamond_pickaxe.canHarvestBlock(block, stack)
				|| Items.diamond_pickaxe.func_150893_a(stack, block) > 1.0F
				|| Items.diamond_shovel.canHarvestBlock(block, stack)
				|| Items.diamond_shovel.func_150893_a(stack, block) > 1.0F || mineableBlocks.contains(block));
	}

	public float getDigSpeed(ItemStack tool, Block block, int meta) {
		return !ElectricItem.manager.canUse(tool, this.energyPerOperation) ? 1.0F
				: (canHarvestBlock(block, tool) ? this.efficiencyOnProperMaterial : 1.0F);
	}

	public int getHarvestLevel(ItemStack stack, String toolType) {
		return (!toolType.equals("pickaxe") && !toolType.equals("shovel") && !toolType.equals("axe")&& !toolType.equals("shears"))
				? super.getHarvestLevel(stack, toolType)
				: this.toolMaterial.getHarvestLevel();
	}

	public boolean hitEntity(ItemStack stack, EntityLiving entity1, EntityLiving entity2) {
		return true;
	}

	public int getDamageVsEntity(Entity entity) {
		return this.damageVsEntity;
	}
	public List<ItemStack> list() {

		List<ItemStack> list = new ArrayList<ItemStack>();

		for (int i = 0; i < OreDictionary.getOres("oreCopper").size(); i++) {
			list.add(OreDictionary.getOres("oreCopper").get(i));
		}

		for (int i = 0; i < OreDictionary.getOres("oreGold").size(); i++) {
			list.add(OreDictionary.getOres("oreGold").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreSilver").size(); i++) {
			list.add(OreDictionary.getOres("oreSilver").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreIridium").size(); i++) {
			list.add(OreDictionary.getOres("oreIridium").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreIron").size(); i++) {
			list.add(OreDictionary.getOres("oreIron").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreBauxite").size(); i++) {
			list.add(OreDictionary.getOres("oreBauxite").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreLead").size(); i++) {
			list.add(OreDictionary.getOres("oreLead").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreRuby").size(); i++) {
			list.add(OreDictionary.getOres("oreRuby").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreCoal").size(); i++) {
			list.add(OreDictionary.getOres("oreCoal").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreDiamond").size(); i++) {
			list.add(OreDictionary.getOres("oreDiamond").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreEmerald").size(); i++) {
			list.add(OreDictionary.getOres("oreEmerald").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreLapis").size(); i++) {
			list.add(OreDictionary.getOres("oreLapis").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreQuartz").size(); i++) {
			list.add(OreDictionary.getOres("oreQuartz").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreRedstone").size(); i++) {
			list.add(OreDictionary.getOres("oreRedstone").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreNickel").size(); i++) {
			list.add(OreDictionary.getOres("oreNickel").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreChromium").size(); i++) {
			list.add(OreDictionary.getOres("oreChromium").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreSpinel").size(); i++) {
			list.add(OreDictionary.getOres("oreSpinel").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreMikhalov").size(); i++) {
			list.add(OreDictionary.getOres("oreMikhalov").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreMagnesium").size(); i++) {
			list.add(OreDictionary.getOres("oreMagnesium").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreTungsten").size(); i++) {
			list.add(OreDictionary.getOres("oreTungsten").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("orePlatinum").size(); i++) {
			list.add(OreDictionary.getOres("orePlatinum").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreAluminium").size(); i++) {
			list.add(OreDictionary.getOres("oreAluminium").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreDraconium").size(); i++) {
			list.add(OreDictionary.getOres("oreDraconium").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreEssence").size(); i++) {
			list.add(OreDictionary.getOres("oreEssence").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreSteel").size(); i++) {
			list.add(OreDictionary.getOres("oreSteel").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreCobalt").size(); i++) {
			list.add(OreDictionary.getOres("oreCobalt").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreCertusQuartz").size(); i++) {
			list.add(OreDictionary.getOres("oreCertusQuartz").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreChargedCertusQuartz").size(); i++) {
			list.add(OreDictionary.getOres("oreChargedCertusQuartz").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreSapphire").size(); i++) {
			list.add(OreDictionary.getOres("oreSapphire").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreSulfur").size(); i++) {
			list.add(OreDictionary.getOres("oreSulfur").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreTin").size(); i++) {
			list.add(OreDictionary.getOres("oreTin").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreInfusedAir").size(); i++) {
			list.add(OreDictionary.getOres("oreInfusedAir").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreInfusedEarth").size(); i++) {
			list.add(OreDictionary.getOres("oreInfusedEarth").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreInfusedEntropy").size(); i++) {
			list.add(OreDictionary.getOres("oreInfusedEntropy").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreInfusedEntropy").size(); i++) {
			list.add(OreDictionary.getOres("oreInfusedEntropy").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreInfusedOrder").size(); i++) {
			list.add(OreDictionary.getOres("oreInfusedOrder").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreInfusedWater").size(); i++) {
			list.add(OreDictionary.getOres("oreInfusedWater").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreAmber").size(); i++) {
			list.add(OreDictionary.getOres("oreAmber").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreCinnabar").size(); i++) {
			list.add(OreDictionary.getOres("oreCinnabar").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreDark").size(); i++) {
			list.add(OreDictionary.getOres("oreDark").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreApatite").size(); i++) {
			list.add(OreDictionary.getOres("oreApatite").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreYellorite").size(); i++) {
			list.add(OreDictionary.getOres("oreYellorite").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreMithril").size(); i++) {
			list.add(OreDictionary.getOres("oreMithril").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("oreMithril").size(); i++) {
			list.add(OreDictionary.getOres("oreMithril").get(i));
		}
		for (int i = 0; i < OreDictionary.getOres("orePeridot").size(); i++) {
			list.add(OreDictionary.getOres("orePeridot").get(i));
		}
		return list;

	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon("supersolarpanel:ultDDrill");
	}
	private boolean getcobblestone(World world, int x, int y, int z) {
		List<Boolean> boolean2 = new ArrayList<Boolean>();
		for(int Xx = x-1;Xx <= x +1;Xx++) {
			for(int Yy = y-1;Yy <= y +1;Yy++) {
				for(int Zz = z-1;Zz <= z +1;Zz++) {
					Block block = world.getBlock(Xx, Yy, Zz);
					if(block == Blocks.stone || block == Blocks.end_stone || block == Blocks.netherrack)
						boolean2.add(true);
				}
			}
		}
			
		
		return  ModUtils.getbooleanthree(boolean2);
	}
	private void ore_break(World world, int x, int y, int z, EntityPlayer player, boolean silktouch, int fortune, boolean lowPower, ItemStack stack) {
		for(int Xx = x -1; Xx <= x+1; Xx++) {
			for(int Yy = y -1; Yy <= y+1; Yy++) {
				for(int Zz = z -1; Zz <= z+1; Zz++) {
					if (ElectricItem.manager.canUse(stack, this.energyPerOperation)) {
						for(ItemStack itemStack : list()) {
							Block localBlock = world.getBlock(Xx, Yy, Zz);
							boolean getcobblestone = getcobblestone(world,Xx,Yy,Zz);
							if(!getcobblestone) {
								continue;
							}
							if(localBlock == Block.getBlockFromItem(itemStack.getItem())) {
								
								if (!player.capabilities.isCreativeMode) {
									int localMeta = world.getBlockMetadata(Xx, Yy, Zz);
									if (localBlock.getBlockHardness(world, Xx, Yy, Zz) > 0.0F) {
										onBlockDestroyed(stack, world, localBlock, Xx, Yy, Zz,
												(EntityLivingBase) player);
										
									}
									if (!silktouch)
										localBlock.dropXpOnBlockBreak(world, Xx, Yy, Zz,
												localBlock.getExpDrop((IBlockAccess) world, localMeta, fortune));
									localBlock.onBlockHarvested(world, Xx, Yy, Zz, localMeta, player);
									if (localBlock.removedByPlayer(world, player, Xx, Yy, Zz, true)) {
										localBlock.onBlockDestroyedByPlayer(world, Xx, Yy, Zz, localMeta);
										localBlock.harvestBlock(world, player, Xx, Yy, Zz, localMeta);
									}
									ElectricItem.manager.use(stack, this.energyPerOperation,
											(EntityLivingBase) player);
									ore_break(world, Xx, Yy, Zz,player,silktouch,fortune,lowPower,stack);
								} else {
									world.setBlockToAir(Xx, Yy, Zz);
								}
							world.func_147479_m(Xx, Yy, Zz);
							}
						}
					}else {
						lowPower = true;
						break;
					}
				}
			}
		}
		
	}
	void chopTree(int X, int Y, int Z, EntityPlayer player, World world, ItemStack stack) {
		for (int xPos = X - 1; xPos <= X + 1; xPos++) {
			for (int yPos = Y; yPos <= Y + 1; yPos++) {
				for (int zPos = Z - 1; zPos <= Z + 1; zPos++) {
					Block block = world.getBlock(xPos, yPos, zPos);
					int meta = world.getBlockMetadata(xPos, yPos, zPos);
					if (block.isWood((IBlockAccess) world, xPos, yPos, zPos)) {
						world.setBlockToAir(xPos, yPos, zPos);
						if (!player.capabilities.isCreativeMode) {
							if (block.removedByPlayer(world, player, xPos, yPos, zPos, false))
								block.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, meta);
							block.harvestBlock(world, player, xPos, yPos, zPos, meta);
							block.onBlockHarvested(world, xPos, yPos, zPos, meta, player);
							onBlockDestroyed(stack, world, block, xPos, yPos, zPos, (EntityLivingBase) player);
						}
						chopTree(xPos, yPos, zPos, player, world, stack);
					}
				}
			}
		}
	}
	private boolean isTree(World world, int X, int Y, int Z) {
		Block wood = world.getBlock(X, Y, Z);
		if (wood == null || !wood.isWood((IBlockAccess) world, X, Y, Z))
			return false;
		int top = Y;
		for (int y = Y; y <= Y + 50; y++) {
			if (!world.getBlock(X, y, Z).isWood((IBlockAccess) world, X, y, Z)
					&& !world.getBlock(X, y, Z).isLeaves((IBlockAccess) world, X, y, Z)) {
				top += y;
				break;
			}
		}
		int leaves = 0;
		for (int xPos = X - 1; xPos <= X + 1; xPos++) {
			for (int yPos = Y; yPos <= top; yPos++) {
				for (int zPos = Z - 1; zPos <= Z + 1; zPos++) {
					if (world.getBlock(xPos, yPos, zPos).isLeaves((IBlockAccess) world, xPos, yPos, zPos))
						leaves++;
				}
			}
		}
		if (leaves >= 3)
			return true;
		return false;
	}
	void trimLeavs(int X, int Y, int Z, EntityPlayer player, World world, ItemStack stack) {
		scedualUpdates(X, Y, Z, player, world, stack);
	}

	void scedualUpdates(int X, int Y, int Z, EntityPlayer player, World world, ItemStack stack) {
		for (int xPos = X - 15; xPos <= X + 15; xPos++) {
			for (int yPos = Y; yPos <= Y + 50; yPos++) {
				for (int zPos = Z - 15; zPos <= Z + 15; zPos++) {
					Block block = world.getBlock(xPos, yPos, zPos);
					if (block.isLeaves((IBlockAccess) world, xPos, yPos, zPos))
						world.scheduleBlockUpdate(xPos, yPos, zPos, block, 2 + world.rand.nextInt(10));
				}
			}
		}
	}
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		if (readToolMode(stack) == 1 || readToolMode(stack) == 0)
			return false;
		if (readToolMode(stack) == 5) {
			World world = player.worldObj;
			Block block = world.getBlock(x, y, z);
			int meta = world.getBlockMetadata(x, y, z);
			if (block == null)
				return super.onBlockStartBreak(stack, x, y, z, player);
			MovingObjectPosition mop = raytraceFromEntity(world, (Entity) player, true, 4.5D);
			boolean lowPower = false;
			
			if (mop != null && (materials.contains(block.getMaterial()) || block == Blocks.monster_egg)) {
				boolean silktouch = EnchantmentHelper.getSilkTouchModifier((EntityLivingBase) player);
				int fortune = EnchantmentHelper.getFortuneModifier((EntityLivingBase) player);
			
				
                ore_break(world,x,y,z,player,silktouch,fortune,lowPower,stack );
				
				
			}
		}
		if (readToolMode(stack) == 6) {
			if(isTree(player.worldObj, x, y, z)) {
				trimLeavs(x, y, z, player, player.worldObj, stack);
				for (int i = 0; i < 9; i++)
					player.worldObj.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(player.worldObj.getBlock(x, y, z))
							+ (player.worldObj.getBlockMetadata(x, y, z) << 12));
				chopTree(x, y, z, player, player.worldObj, stack);
			}
		}
		if (readToolMode(stack) == 2) {
			World world = player.worldObj;
			Block block = world.getBlock(x, y, z);
			int meta = world.getBlockMetadata(x, y, z);
			if (block == null)
				return super.onBlockStartBreak(stack, x, y, z, player);
			MovingObjectPosition mop = raytraceFromEntity(world, (Entity) player, true, 4.5D);
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
				boolean silktouch = EnchantmentHelper.getSilkTouchModifier((EntityLivingBase) player);
				int fortune = EnchantmentHelper.getFortuneModifier((EntityLivingBase) player);

				for (int xPos = x - xRange; xPos <= x + xRange; xPos++) {
					for (int yPos = y - yRange; yPos <= y + yRange; yPos++) {
						for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
							if (ElectricItem.manager.canUse(stack, this.energyPerOperation)) {
								Block localBlock = world.getBlock(xPos, yPos, zPos);
								if (localBlock != null && canHarvestBlock(localBlock, stack)
										&& localBlock.getBlockHardness(world, xPos, yPos, zPos) >= 0.0F
										&& (materials.contains(localBlock.getMaterial())
												|| block == Blocks.monster_egg))

									if (!player.capabilities.isCreativeMode) {
										int localMeta = world.getBlockMetadata(xPos, yPos, zPos);
										if (localBlock.getBlockHardness(world, xPos, yPos, zPos) > 0.0F)
											onBlockDestroyed(stack, world, localBlock, xPos, yPos, zPos,
													(EntityLivingBase) player);
										if (!silktouch)
											localBlock.dropXpOnBlockBreak(world, xPos, yPos, zPos,
													localBlock.getExpDrop((IBlockAccess) world, localMeta, fortune));
										localBlock.onBlockHarvested(world, xPos, yPos, zPos, localMeta, player);
										if (localBlock.removedByPlayer(world, player, xPos, yPos, zPos, true)) {
											localBlock.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, localMeta);
											localBlock.harvestBlock(world, player, xPos, yPos, zPos, localMeta);
										}
										ElectricItem.manager.use(stack, this.energyPerOperation,
												(EntityLivingBase) player);
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
				} else if (!IUCore.isSimulating()) {
					world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (meta << 12));
				}
				return true;
			}
		}
		//
		if (readToolMode(stack) == 3) {
	
			World world = player.worldObj;
			Block block = world.getBlock(x, y, z);
			int meta = world.getBlockMetadata(x, y, z);
			if (block == null)
				return super.onBlockStartBreak(stack, x, y, z, player);
			MovingObjectPosition mop = raytraceFromEntity(world, (Entity) player, true, 4.5D);
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
				boolean silktouch = EnchantmentHelper.getSilkTouchModifier((EntityLivingBase) player);
				int fortune = EnchantmentHelper.getFortuneModifier((EntityLivingBase) player);

				for (int xPos = x - xRange; xPos <= x + xRange; xPos++) {
					for (int yPos = y - yRange; yPos <= y + yRange; yPos++) {
						for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
							if (ElectricItem.manager.canUse(stack, this.energyPerOperation)) {
								Block localBlock = world.getBlock(xPos, yPos, zPos);
								if (localBlock != null && canHarvestBlock(localBlock, stack)
										&& localBlock.getBlockHardness(world, xPos, yPos, zPos) >= 0.0F
										&& (materials.contains(localBlock.getMaterial())
												|| block == Blocks.monster_egg))

									if (!player.capabilities.isCreativeMode) {
										int localMeta = world.getBlockMetadata(xPos, yPos, zPos);
										if (localBlock.getBlockHardness(world, xPos, yPos, zPos) > 0.0F)
											onBlockDestroyed(stack, world, localBlock, xPos, yPos, zPos,
													(EntityLivingBase) player);
										if (!silktouch)
											localBlock.dropXpOnBlockBreak(world, xPos, yPos, zPos,
													localBlock.getExpDrop((IBlockAccess) world, localMeta, fortune));
										localBlock.onBlockHarvested(world, xPos, yPos, zPos, localMeta, player);
										if (localBlock.removedByPlayer(world, player, xPos, yPos, zPos, true)) {
											localBlock.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, localMeta);
											localBlock.harvestBlock(world, player, xPos, yPos, zPos, localMeta);
										}
										ElectricItem.manager.use(stack, this.energyPerOperation,
												(EntityLivingBase) player);
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
				} else if (!IUCore.isSimulating()) {
					world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (meta << 12));
				}
				return true;
			}
		
		
		}
		//
		if (readToolMode(stack) == 4) {
			World world = player.worldObj;
			Block block = world.getBlock(x, y, z);
			int meta = world.getBlockMetadata(x, y, z);
			if (block == null)
				return super.onBlockStartBreak(stack, x, y, z, player);
			MovingObjectPosition mop = raytraceFromEntity(world, (Entity) player, true, 4.5D);
			if (mop != null && (materials.contains(block.getMaterial()) || block == Blocks.monster_egg)) {
				byte xRange = 3;
				byte yRange = 3;
				byte zRange = 3;
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
				boolean silktouch = EnchantmentHelper.getSilkTouchModifier((EntityLivingBase) player);
				int fortune = EnchantmentHelper.getFortuneModifier((EntityLivingBase) player);

				for (int xPos = x - xRange; xPos <= x + xRange; xPos++) {
					for (int yPos = y - yRange; yPos <= y + yRange; yPos++) {
						for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
							if (ElectricItem.manager.canUse(stack, this.energyPerOperation)) {
								Block localBlock = world.getBlock(xPos, yPos, zPos);
								if (localBlock != null && canHarvestBlock(localBlock, stack)
										&& localBlock.getBlockHardness(world, xPos, yPos, zPos) >= 0.0F
										&& (materials.contains(localBlock.getMaterial())
												|| block == Blocks.monster_egg))

									if (!player.capabilities.isCreativeMode) {
										int localMeta = world.getBlockMetadata(xPos, yPos, zPos);
										if (localBlock.getBlockHardness(world, xPos, yPos, zPos) > 0.0F)
											onBlockDestroyed(stack, world, localBlock, xPos, yPos, zPos,
													(EntityLivingBase) player);
										if (!silktouch)
											localBlock.dropXpOnBlockBreak(world, xPos, yPos, zPos,
													localBlock.getExpDrop((IBlockAccess) world, localMeta, fortune));
										localBlock.onBlockHarvested(world, xPos, yPos, zPos, localMeta, player);
										if (localBlock.removedByPlayer(world, player, xPos, yPos, zPos, true)) {
											localBlock.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, localMeta);
											localBlock.harvestBlock(world, player, xPos, yPos, zPos, localMeta);
										}
										ElectricItem.manager.use(stack, this.energyPerOperation,
												(EntityLivingBase) player);
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
				} else if (!IUCore.isSimulating()) {
					world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (meta << 12));
				}
				return true;
			}
		}
		//
		return super.onBlockStartBreak(stack, x, y, z, player);
	}

	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int xPos, int yPos, int zPos,
			EntityLivingBase entity) {
		if (!IUCore.isSimulating())
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
			case 2:
				energy = this.energyPerbigHolePowerOperation;
				break;
			case 3:
				energy = this.energyPerultraLowPowerOperation;
				break;
			case 4:
				energy = this.energyPerultraLowPowerOperation1;
				break;
			case 5:
				energy = this.energyPerOperation;
				break;
			case 6:
				energy = this.energyPerOperation;
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
		NBTTagCompound nbt = NBTData.getOrCreateNbtData(itemstack);
		int toolMode = nbt.getInteger("toolMode");

		if (toolMode < 0 || toolMode > 6)
			toolMode = 0;
		return toolMode;
	}

	public void saveToolMode(ItemStack itemstack, int toolMode) {
		NBTTagCompound nbt = NBTData.getOrCreateNbtData(itemstack);
		nbt.setInteger("toolMode", toolMode);
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
			float xOffset, float yOffset, float zOffset) {
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			ItemStack torchStack = player.inventory.mainInventory[i];
			if (torchStack != null && torchStack.getUnlocalizedName().toLowerCase().contains("torch")) {
				Item item = torchStack.getItem();
				if (item instanceof net.minecraft.item.ItemBlock) {
					int oldMeta = torchStack.getItemDamage();
					int oldSize = torchStack.stackSize;
					boolean result = torchStack.tryPlaceItemIntoWorld(player, world, x, y, z, side, xOffset, yOffset,
							zOffset);
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

			if (toolMode > 6)
				toolMode = 0;
			saveToolMode(itemStack, toolMode);
			switch (toolMode) {
			case 0:
				CommonProxy.sendPlayerMessage(player,
						EnumChatFormatting.GREEN + Helpers.formatMessage("message.text.mode") + ": "
								+ Helpers.formatMessage("message.ultDDrill.mode.normal"));
				this.efficiencyOnProperMaterial = this.normalPower;
				mode = 0;
				Map<Integer, Integer> enchantmentMap = EnchantmentHelper.getEnchantments(itemStack);
				if (Config.enableefficiency) {
					enchantmentMap.put(Integer.valueOf(Enchantment.efficiency.effectId),
							Integer.valueOf(Config.efficiencylevel));
				}
				if (Config.enablefortune) {
					enchantmentMap.remove(Integer.valueOf(Enchantment.fortune.effectId),
							Integer.valueOf(Config.fortunelevel));
				}
				if (Config.enablefortune || Config.enableefficiency)
					EnchantmentHelper.setEnchantments(enchantmentMap, itemStack);
				break;

			case 1:
				Map<Integer, Integer> enchantmentMap4 = EnchantmentHelper.getEnchantments(itemStack);
				mode = 1;
				if (Config.enableefficiency) {
					enchantmentMap4.remove(Integer.valueOf(Enchantment.efficiency.effectId),
							Integer.valueOf(Config.efficiencylevel));
				}
				if (Config.enableefficiency1) {
					enchantmentMap4.put(Integer.valueOf(Enchantment.efficiency.effectId),
							Integer.valueOf(Config.efficiencylevel1));
				}
				if (Config.enableefficiency1 || Config.enableefficiency)
					EnchantmentHelper.setEnchantments(enchantmentMap4, itemStack);
				CommonProxy.sendPlayerMessage(player,
						EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": "
								+ Helpers.formatMessage("message.ultDDrill.mode.lowPower"));
				this.efficiencyOnProperMaterial = this.lowPower;
				break;
			case 2:
				CommonProxy.sendPlayerMessage(player,
						EnumChatFormatting.AQUA + Helpers.formatMessage("message.text.mode") + ": "
								+ Helpers.formatMessage("message.ultDDrill.mode.bigHoles"));
				this.efficiencyOnProperMaterial = this.bigHolePower;
				Map<Integer, Integer> enchantmentMap2 = EnchantmentHelper.getEnchantments(itemStack);
				mode = 2;
				if (Config.enableefficiency1) {
					enchantmentMap2.remove(Integer.valueOf(Enchantment.efficiency.effectId),
							Integer.valueOf(Config.efficiencylevel1));
				}
				if (Config.enablesilkTouch) {
					enchantmentMap2.put(Integer.valueOf(Enchantment.silkTouch.effectId), Integer.valueOf(1));
				}
				if (Config.enableefficiency1 || Config.enablesilkTouch)
					EnchantmentHelper.setEnchantments(enchantmentMap2, itemStack);
				break;
			case 3:
				CommonProxy.sendPlayerMessage(player,
						EnumChatFormatting.LIGHT_PURPLE + Helpers.formatMessage("message.text.mode") + ": "
								+ Helpers.formatMessage("message.ultDDrill.mode.bigHoles1"));
				this.efficiencyOnProperMaterial = this.ultraLowPower;
				Map<Integer, Integer> enchantmentMap1 = EnchantmentHelper.getEnchantments(itemStack);
				if (Config.enablesilkTouch) {
					enchantmentMap1.remove(Integer.valueOf(Enchantment.silkTouch.effectId), Integer.valueOf(1));
				}
				mode = 3;
				if (Config.enablefortune) {
					enchantmentMap1.put(Integer.valueOf(Enchantment.fortune.effectId),
							Integer.valueOf(Config.fortunelevel));
				}
				if (Config.enablefortune || Config.enablesilkTouch)
					EnchantmentHelper.setEnchantments(enchantmentMap1, itemStack);
				break;
			case 4:
				CommonProxy.sendPlayerMessage(player,
						EnumChatFormatting.DARK_PURPLE + Helpers.formatMessage("message.text.mode") + ": "
								+ Helpers.formatMessage("message.ultDDrill.mode.bigHoles2"));
				this.efficiencyOnProperMaterial = this.ultraLowPower1;

				break;
			case 5:
				CommonProxy.sendPlayerMessage(player,
						EnumChatFormatting.GREEN + Helpers.formatMessage("message.text.mode") + ": "
								+ Helpers.formatMessage("message.ultDDrill.mode.pickaxe"));
				this.efficiencyOnProperMaterial = this.normalPower;
				mode = 5;
				Map<Integer, Integer> enchantmentMap3 = EnchantmentHelper.getEnchantments(itemStack);
				if (Config.enableefficiency) {
					enchantmentMap3.put(Integer.valueOf(Enchantment.efficiency.effectId),
							Integer.valueOf(Config.efficiencylevel));
				}
				if (Config.enablefortune) {
					enchantmentMap3.remove(Integer.valueOf(Enchantment.fortune.effectId),
							Integer.valueOf(Config.fortunelevel));
				}
				if (Config.enablefortune || Config.enableefficiency)
					EnchantmentHelper.setEnchantments(enchantmentMap3, itemStack);
				break;
			case 6:
				CommonProxy.sendPlayerMessage(player,
						EnumChatFormatting.GREEN + Helpers.formatMessage("message.text.mode") + ": "
								+ Helpers.formatMessage("message.ultDDrill.mode.treemode"));
				this.efficiencyOnProperMaterial = this.normalPower;
				mode =6;
				
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
			range = ((EntityPlayerMP) player).theItemInWorldManager.getBlockReachDistance();
		Vec3 vec31 = vec3.addVector(range * f7, range * f6, range * f8);
		return world.func_147447_a(vec3, vec31, par3, !par3, par3);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		Integer toolMode = readToolMode(par1ItemStack);
		if (toolMode.intValue() == 0)
			par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": "
					+ EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.normal"));
		if (toolMode.intValue() == 1)
			par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": "
					+ EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.lowPower"));
		if (toolMode.intValue() == 2)
			par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": "
					+ EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.bigHoles"));
		if (toolMode.intValue() == 3)
			par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": "
					+ EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.bigHoles1"));
		if (toolMode.intValue() == 4)
			par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": "
					+ EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.bigHoles2"));
		if (toolMode.intValue() == 5)
			par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": "
					+ EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.pickaxe"));
		if (toolMode.intValue() == 6)
			par3List.add(EnumChatFormatting.GOLD + Helpers.formatMessage("message.text.mode") + ": "
					+ EnumChatFormatting.WHITE + Helpers.formatMessage("message.ultDDrill.mode.treemode"));
	}

	public String getRandomDrillSound() {
		switch (IUCore.random.nextInt(4)) {
		case 1:
			return "drillOne";
		case 2:
			return "drillTwo";
		case 3:
			return "drillThree";
		case 4:
			return "drillFour";
		}
		return "drill";
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List subs) {
		ItemStack stack = new ItemStack((Item) this, 1);
		Map<Integer, Integer> enchantmentMap4 = new HashMap<Integer, Integer>();

		enchantmentMap4.put(Integer.valueOf(Enchantment.efficiency.effectId), Integer.valueOf(10));
		EnchantmentHelper.setEnchantments(enchantmentMap4, stack);
		ElectricItem.manager.charge(stack, 2.147483647E9D, 2147483647, true, false);
		subs.add(stack);
		ItemStack itemstack = new ItemStack((Item) this, 1, getMaxDamage());
		EnchantmentHelper.setEnchantments(enchantmentMap4, itemstack);

		subs.add(itemstack);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack var1) {
		return EnumRarity.uncommon;
	}

	public Item getChargedItem(ItemStack itemStack) {
		return (Item) this;
	}

	public Item getEmptyItem(ItemStack itemStack) {
		return (Item) this;
	}
}
