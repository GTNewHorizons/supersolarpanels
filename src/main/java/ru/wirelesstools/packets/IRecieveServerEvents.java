package ru.wirelesstools.packets;

import net.minecraft.nbt.NBTTagCompound;

public interface IRecieveServerEvents {

	
	void onServerEvent(int nameInt, NBTTagCompound nameNBTTagCompound);
}
