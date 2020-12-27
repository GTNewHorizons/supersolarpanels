
package com.Denfop.handler;

import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.tileentity.TileEntity;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class PacketGUIPressButton extends IPacket
{
    public int dimID;
    public int x;
    public int y;
    public int z;
    public int buttonID;
    
    @Override
    public void read(final DataInputStream bytes) throws Throwable {
        this.dimID = bytes.readInt();
        this.x = bytes.readInt();
        this.y = bytes.readInt();
        this.z = bytes.readInt();
        this.buttonID = bytes.readInt();
    }
    
    @Override
    public void write(final DataOutputStream bytes) throws Throwable {
        bytes.writeInt(this.dimID);
        bytes.writeInt(this.x);
        bytes.writeInt(this.y);
        bytes.writeInt(this.z);
        bytes.writeInt(this.buttonID);
    }
    
    public static void issue(final TileEntity te, final int buttonID) {
        final PacketGUIPressButton pgpb = new PacketGUIPressButton();
        pgpb.x = te.xCoord;
        pgpb.y = te.yCoord;
        pgpb.z = te.zCoord;
        pgpb.dimID = te.getWorldObj().provider.dimensionId;
        pgpb.buttonID = buttonID;
        ASPPacketHandler.sendToServer(pgpb);
    }
    
    public static void issue(final ChunkCoordinates te, final int dimID, final int buttonID) {
        final PacketGUIPressButton pgpb = new PacketGUIPressButton();
        pgpb.x = te.posX;
        pgpb.y = te.posY;
        pgpb.z = te.posZ;
        pgpb.dimID = dimID;
        pgpb.buttonID = buttonID;
        ASPPacketHandler.sendToServer(pgpb);
    }
    
    @Override
    public void execute() {
        try {
            final WorldServer ws = DimensionManager.getWorld(this.dimID);
            if (ws != null) {
                final TileEntity te = ws.getTileEntity(this.x, this.y, this.z);
                if (te != null && te instanceof IHasButton) {
                    ((IHasButton)te).handleButtonClick(this.buttonID);
                }
            }
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
