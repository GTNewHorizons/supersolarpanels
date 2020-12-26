

package com.Denfop.handler;

import net.minecraft.nbt.NBTTagCompound;

public interface IReceiveServerEvents
{
    void onServerEvent(final int p0, final NBTTagCompound p1);
}
