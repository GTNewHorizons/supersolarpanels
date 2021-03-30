package com.Denfop.integration.Waila;

import cpw.mods.fml.common.Optional.Interface;
import cpw.mods.fml.common.Optional.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.Denfop.tiles.base.TileEntityElectricBlock;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.utils.ModUtils;
import com.Denfop.utils.NBTData;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

@Interface(iface = "mcp.mobius.waila.api.IWailaDataProvider", modid = "Waila")
public class WailaHandler implements IWailaDataProvider {
	public static final NumberFormat commanator = new DecimalFormat("#,###");

	@Method(modid = "Waila")
	public static void callbackRegister(IWailaRegistrar register) {
		register.registerBodyProvider(new WailaHandler(), Block.class);
		register.addConfig("IU", "eu.showEU", true);
	}

	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return null;
	}

	public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		return currenttip;
	}

	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {

		Item item = accessor.getBlock().getItem(accessor.getWorld(), (accessor.getPosition()).blockX,
				(accessor.getPosition()).blockY, (accessor.getPosition()).blockZ);
		if (item != null) {
			Block blockx = (item instanceof net.minecraft.item.ItemBlock && !accessor.getBlock().isFlowerPot())
					? Block.getBlockFromItem(item)
					: accessor.getBlock();
			Block blockEMC = accessor.getWorld().getBlock(accessor.getPosition().blockX, accessor.getPosition().blockY,
					accessor.getPosition().blockZ);

		}
		if (accessor.getWorld().getTileEntity(accessor.getPosition().blockX, accessor.getPosition().blockY,
				accessor.getPosition().blockZ) instanceof TileEntityElectricBlock) {
			TileEntityElectricBlock tile =	(TileEntityElectricBlock) accessor.getWorld().getTileEntity(accessor.getPosition().blockX, accessor.getPosition().blockY,
					accessor.getPosition().blockZ);
			NBTTagCompound NBTTagCompound = accessor.getNBTData();
			double energy = NBTTagCompound.getDouble("energy");
			currenttip.add(StatCollector.translateToLocal("supsolpans.SpecSP.Storage") + " "
					+ ModUtils.getString(energy) + "/"+ ModUtils.getString(tile.maxStorage) + EnumChatFormatting.RESET);
			if(NBTTagCompound.getBoolean("movementcharge"))
				currenttip.add(StatCollector.translateToLocal("gui.movementcharge") + ": "
						+ ModUtils.Boolean(true) + EnumChatFormatting.RESET);
			if(NBTTagCompound.getBoolean("movementchargeitem"))
				currenttip.add(StatCollector.translateToLocal("gui.movementchargeitem") + ": "
						+ ModUtils.Boolean(true) + EnumChatFormatting.RESET);
			if(NBTTagCompound.getBoolean("movementchargeitemrf"))
				currenttip.add(StatCollector.translateToLocal("gui.movementchargeitemrf") + ": "
						+ ModUtils.Boolean(true) + EnumChatFormatting.RESET);
			if(NBTTagCompound.getBoolean("movementchargerf"))
			currenttip.add(StatCollector.translateToLocal("gui.movementchargerf") + ": "
					+ ModUtils.Boolean(true) + EnumChatFormatting.RESET);
			List<Boolean> Boolean = new ArrayList<Boolean>();
			Boolean.add(NBTTagCompound.getBoolean("movementcharge"));
			Boolean.add(NBTTagCompound.getBoolean("movementchargeitem"));
			Boolean.add(NBTTagCompound.getBoolean("movementchargeitemrf"));
			Boolean.add(NBTTagCompound.getBoolean("movementchargerf"));
			if(ModUtils.Boolean(Boolean))
				currenttip.add(StatCollector.translateToLocal("gui.movement"));
		}
		if (accessor.getWorld().getTileEntity(accessor.getPosition().blockX, accessor.getPosition().blockY,
				accessor.getPosition().blockZ) instanceof TileEntitySolarPanel) {
			NBTTagCompound NBTTagCompound = accessor.getNBTData();
			double energy = NBTTagCompound.getDouble("storage");
			int solartype = accessor.getNBTInteger(accessor.getNBTData(), "solarType");
			double generating = NBTTagCompound.getDouble("generating");
			double production = NBTTagCompound.getDouble("production");
			double tier = NBTTagCompound.getDouble("tier");
			Block blockEMC = accessor.getWorld().getBlock(accessor.getPosition().blockX, accessor.getPosition().blockY,
					accessor.getPosition().blockZ);
			NBTTagCompound nbttagcompound = NBTData.getOrCreateNbtData(new ItemStack(blockEMC));
			nbttagcompound.setInteger("solarType", solartype);

			TileEntitySolarPanel tile = (TileEntitySolarPanel) accessor.getWorld().getTileEntity(
					accessor.getPosition().blockX, accessor.getPosition().blockY, accessor.getPosition().blockZ);
			currenttip.add(StatCollector.translateToLocal("gui.SuperSolarPanel.generating") + ": "
					+ ModUtils.getString(generating) + " EU/t" + EnumChatFormatting.RESET);
			currenttip.add(StatCollector.translateToLocal("gui.SuperSolarPanel.maxOutput") + ": "
					+ ModUtils.getString(production) + " EU/t" + EnumChatFormatting.RESET);
			currenttip.add(StatCollector.translateToLocal("ssp.tier") + ModUtils.getString(tier)
					+ EnumChatFormatting.RESET);
			String ModulesString6 = I18n.format("ssp.moduletype", new Object[0]);
			String ModulesString61 = I18n.format("ssp.moduletype1", new Object[0]);
			String ModulesString62 = I18n.format("ssp.moduletype2", new Object[0]);
			String ModulesString63 = I18n.format("ssp.moduletype3", new Object[0]);
			String ModulesString64 = I18n.format("ssp.moduletype4", new Object[0]);
			String ModulesString65 = I18n.format("ssp.moduletype5", new Object[0]);
			String ModulesString66 = I18n.format("ssp.moduletype6", new Object[0]);
			String ModulesString67 = I18n.format("ssp.moduletype7", new Object[0]);
			if (solartype == 0)
				currenttip.add(ModulesString6 + EnumChatFormatting.RESET);
			if (solartype == 1)
				currenttip.add(ModulesString61 + EnumChatFormatting.RESET);
			if (solartype == 2)
				currenttip.add(ModulesString62 + EnumChatFormatting.RESET);
			if (solartype == 3)
				currenttip.add(ModulesString63 + EnumChatFormatting.RESET);
			if (solartype == 4)
				currenttip.add(ModulesString64 + EnumChatFormatting.RESET);
			if (solartype == 5)
				currenttip.add(ModulesString65 + EnumChatFormatting.RESET);
			if (solartype == 6)
				currenttip.add(ModulesString66 + EnumChatFormatting.RESET);
			if (solartype == 7)
				currenttip.add(ModulesString67 + EnumChatFormatting.RESET);
			currenttip.add(ModUtils.getString(energy) + " / " + ModUtils.getString(tile.maxStorage) + " EU"
					+ EnumChatFormatting.RESET);
		}
		return currenttip;
	}

	public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		return currenttip;
	}

	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x,
			int y, int z) {
		return tag;
	}
}
