// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.handler;

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.Iterator;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;

public class ASPChannelHandler extends FMLIndexedMessageToMessageCodec<IPacket>
{
    public ASPChannelHandler() {
        for (final Class clazz : ASPPacketHandler.packetTypes) {
            this.addDiscriminator(ASPPacketHandler.packetTypes.indexOf(clazz), clazz);
        }
    }
    
    public void encodeInto(final ChannelHandlerContext ctx, final IPacket msg, final ByteBuf target) throws Exception {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            msg.write(new DataOutputStream(baos));
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        target.writeBytes(baos.toByteArray());
    }
    
    public void decodeInto(final ChannelHandlerContext ctx, final ByteBuf source, final IPacket msg) {
        final byte[] arr = new byte[source.readableBytes()];
        source.readBytes(arr);
        final ByteArrayInputStream bais = new ByteArrayInputStream(arr);
        try {
            msg.read(new DataInputStream(bais));
        }
        catch (Throwable e) {
            e.printStackTrace();
            return;
        }
        msg.execute();
    }
}
