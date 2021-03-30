package com.Denfop.World;

import java.util.Random;

import com.Denfop.Config;
import com.Denfop.IUItem;
import com.Denfop.IUCore;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class GenOre implements IWorldGenerator {
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {

		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 6:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateNether(World world, Random random, int x, int y) {
		if (Config.EnableNetherOres) {
			addOreSpawn1(IUItem.nethercopperrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 20, 20, 80);
			addOreSpawn1(IUItem.netheruranrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 4, 20, 70);
			addOreSpawn1(IUItem.nethertinrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 16, 5, 70);
			addOreSpawn1(IUItem.netherleadrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 4, 10, 80);
			addOreSpawn1(IUItem.netheremeraldrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 4, 30, 60);
			addOreSpawn1(IUItem.netherdiamondrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 4, 10, 60);

			addOreSpawn1(IUItem.nethercoalrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 30, 10, 70);
			addOreSpawn1(IUItem.netherredstonerack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 15, 10, 70);
			addOreSpawn1(IUItem.netherlapisrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 12, 10, 70);
			addOreSpawn1(IUItem.netherironrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 16, 10, 70);
			addOreSpawn1(IUItem.nethergoldrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 10, 0, 128);
			
			addOreSpawn2(IUItem.netherchromiumrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 8, 0, 128);
			addOreSpawn2(IUItem.netheriridiumrack, world, random, x, y, 16, 16,  3 + random.nextInt(3), 8, 0, 128);
			addOreSpawn2(IUItem.nethermagnesiumrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 8, 0, 128);
			addOreSpawn2(IUItem.nethermikhailrack, world, random, x, y, 16, 16,  3 + random.nextInt(3), 12, 0, 128);
			addOreSpawn2(IUItem.netherplatiumrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 10, 0, 128);
			addOreSpawn2(IUItem.netherwolfram_rack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 14, 0, 128);
			addOreSpawn2(IUItem.netherspinelrack, world, random, x, y, 16, 16, 3 + random.nextInt(2), 10, 0, 128);
			
		}
	}

	private void generateSurface(World world, Random random, int x, int y) {
		if (Config.EnableMickailOre)
			this.addOreSpawn(IUItem.mikhail_ore, world, random, x, y, 16, 16, 3 + random.nextInt(3), 14, 10, 60);
		if (Config.EnableSpinelOre)
			this.addOreSpawn(IUItem.spinelore, world, random, x, y, 16, 16, 3 + random.nextInt(3), 14, 10, 60);
		if (Config.EnablePlatiumOre)
			this.addOreSpawn(IUItem.platiumore, world, random, x, y, 16, 16, 2 + random.nextInt(3), 10, 0, 60);
		if (Config.EnableWolframOre)
			this.addOreSpawn(IUItem.wolframore, world, random, x, y, 16, 16, 3 + random.nextInt(3), 15, 10, 70);
		if (Config.EnableChromiumOre)
			this.addOreSpawn(IUItem.chromiumore, world, random, x, y, 16, 16, 3 + random.nextInt(3), 14, 10, 70);
		if (Config.EnableIridiumOre)
			this.addOreSpawn(IUItem.iridiumore, world, random, x, y, 16, 16, 3 + random.nextInt(3), 10, 10, 60);
		if (Config.EnableMagnesiumOre)
			this.addOreSpawn(IUItem.magnesiumore, world, random, x, y, 16, 16, 3 + random.nextInt(3), 12, 10, 70);
		if (Config.EnableNickelOre)
			this.addOreSpawn(IUItem.nicelore, world, random, x, y, 16, 16, 3 + random.nextInt(3), 12, 10, 60);
		if (Config.EnableToriyOre)
			this.addOreSpawn(IUItem.toriyore, world, random, x, y, 16, 16, 3 + random.nextInt(2), 10, 10, 70);
		if (Config.EnableMagnetitOre)
			this.addOreSpawn(IUItem.magnetitore, world, random, x, y, 16, 16, 3 + random.nextInt(2), 10, 10, 70);
	}

	private void generateEnd(World world, Random random, int x, int y) {
		if (Config.EnableEndOres) {
			addOreSpawn2(IUItem.endcopper_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 20, 0, 128);
			addOreSpawn2(IUItem.enduran_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 4, 0, 128);
			addOreSpawn2(IUItem.endtin_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 16, 0, 128);
			addOreSpawn2(IUItem.endlead_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 4, 0, 128);
			addOreSpawn2(IUItem.endemerald_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 4, 0, 128);
			addOreSpawn2(IUItem.enddiamond_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 4, 0, 128);
			addOreSpawn2(IUItem.endcoal_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 30, 0, 128);
			addOreSpawn2(IUItem.endredstone_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 15, 0, 128);
			addOreSpawn2(IUItem.endlapis_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 12, 0, 128);
			addOreSpawn2(IUItem.endiron_stone, world, random, x, y, 16, 16, 6 + random.nextInt(2), 10, 0, 128);
			addOreSpawn2(IUItem.endgold_stone, world, random, x, y, 16, 16, 3, 10, 0, 128);
			
			addOreSpawn2(IUItem.endchromium_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 8, 0, 128);
			addOreSpawn2(IUItem.endiridium_stone, world, random, x, y, 16, 16,  3 + random.nextInt(3), 8, 0, 128);
			addOreSpawn2(IUItem.endmagnesium_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 8, 0, 128);
			addOreSpawn2(IUItem.endmikhail_stone, world, random, x, y, 16, 16,  3 + random.nextInt(3), 12, 0, 128);
			addOreSpawn2(IUItem.endplatium_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 10, 0, 128);
			addOreSpawn2(IUItem.endwolfram_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 14, 0, 128);
			addOreSpawn2(IUItem.endspinel_stone, world, random, x, y, 16, 16, 3 + random.nextInt(2), 10, 0, 128);
			
			
		}
	}

	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ,
			int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		for (int i = 0; i < chancesToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);

			(new WorldGenMinable(block, 0, maxVeinSize, Blocks.stone)).generate(world, random, posX, posY, posZ);

		}
	}

	public void addOreSpawn1(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ,
			int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		for (int i = 0; i < chancesToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);

			(new WorldGenMinable(block, 0, maxVeinSize, Blocks.netherrack)).generate(world, random, posX, posY, posZ);
		}
	}

	public void addOreSpawn2(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ,
			int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		for (int i = 0; i < chancesToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);

			(new WorldGenMinable(block, 0, maxVeinSize, Blocks.end_stone)).generate(world, random, posX, posY, posZ);
		}
	}

	public static void init() {
		GameRegistry.registerWorldGenerator(new GenOre(), 0);
	}

}
