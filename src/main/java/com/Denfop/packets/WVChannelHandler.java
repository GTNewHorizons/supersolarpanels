package com.Denfop.packets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class WVChannelHandler extends FMLIndexedMessageToMessageCodec<IPacketWV> {
	
	 public WVChannelHandler() {
		
		 for(Class<? extends IPacketWV> clazz : WVPacketHandler.packetTypes) {
			 
			 addDiscriminator(WVPacketHandler.packetTypes.indexOf(clazz), clazz);
		 }
		 
	}
	
	
	

	

	@Override
	public void encodeInto(ChannelHandlerContext ctx, IPacketWV msg, ByteBuf target) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		     try {
		       msg.write(new DataOutputStream(baos));
		     } catch (Throwable e) {
		       e.printStackTrace();
		     } 
		     target.writeBytes(baos.toByteArray());
		
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, IPacketWV msg) {
		
		
		byte[] arr = new byte[source.readableBytes()];
		    source.readBytes(arr);
		    ByteArrayInputStream bais = new ByteArrayInputStream(arr);
		     try {
		       msg.read(new DataInputStream(bais));
		     } catch (Throwable e) {
		      e.printStackTrace();
		       return;
		     } 
		  msg.execute();
		
		
	}

}
