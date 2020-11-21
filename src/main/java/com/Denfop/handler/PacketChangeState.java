// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.handler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import java.io.DataOutputStream;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTSizeTracker;
import java.io.DataInputStream;
import net.minecraft.nbt.NBTTagCompound;

public class PacketChangeState extends IPacket
{
    private int x;
    private int y;
    private int z;
    private int eventID;
    private NBTTagCompound nbtData;
    
    @Override
    public void read(final DataInputStream bytes) throws Throwable {
        this.x = bytes.readInt();
        this.y = bytes.readInt();
        this.z = bytes.readInt();
        this.eventID = bytes.readInt();
        final int length = bytes.readInt();
        if (length != -1) {
            final byte[] data = new byte[length];
            bytes.read(data, 0, length);
            this.nbtData = CompressedStreamTools.func_152457_a(data, NBTSizeTracker.field_152451_a);
        }
        else {
            this.nbtData = null;
        }
    }
    
    @Override
    public void write(final DataOutputStream bytes) throws Throwable {
        bytes.writeInt(this.x);
        bytes.writeInt(this.y);
        bytes.writeInt(this.z);
        bytes.writeInt(this.eventID);
        if (this.nbtData == null) {
            bytes.writeInt(-1);
        }
        else {
            final byte[] nbtBytes = CompressedStreamTools.compress(this.nbtData);
            bytes.writeInt(nbtBytes.length);
            bytes.write(nbtBytes);
        }
    }
    
    public static void issue(final TileEntity te, final int eventID, final NBTTagCompound nbtData) {
        final PacketChangeState changeState = new PacketChangeState();
        changeState.x = te.xCoord;
        changeState.y = te.yCoord;
        changeState.z = te.zCoord;
        changeState.eventID = eventID;
        changeState.nbtData = nbtData;
        ASPPacketHandler.sendToAllPlayers(changeState);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void execute() {
        final World w = (World)Minecraft.getMinecraft().theWorld;
        final TileEntity te = w.getTileEntity(this.x, this.y, this.z);
        if (te != null && te instanceof IReceiveServerEvents) {
            ((IReceiveServerEvents)te).onServerEvent(this.eventID, this.nbtData);
        }
    }
}
