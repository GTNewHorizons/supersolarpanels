package com.Denfop.packets;

import net.minecraft.nbt.NBTTagCompound;

public interface IRecieveServerEvents {

	
	void onServerEvent(int nameInt, NBTTagCompound nameNBTTagCompound);
}
