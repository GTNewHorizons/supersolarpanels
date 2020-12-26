
package com.Denfop.handler;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.FMLOutboundHandler.OutboundTarget;
import io.netty.channel.ChannelHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.relauncher.Side;
import java.util.EnumMap;
import java.util.List;

public class ASPPacketHandler
{
    public static List<Class<? extends IPacket>> packetTypes;
    private static EnumMap<Side, FMLEmbeddedChannel> channels;
    
    public static void load() {
        registerPacketType(PacketGUIPressButton.class);
        registerPacketType(PacketChangeState.class);
        ASPPacketHandler.channels = (EnumMap<Side, FMLEmbeddedChannel>)NetworkRegistry.INSTANCE.newChannel("AdvSolarPanels", new ChannelHandler[] { (ChannelHandler)new ASPChannelHandler() });
    }
    
    public static void registerPacketType(final Class<? extends IPacket> ptype) {
        ASPPacketHandler.packetTypes.add(ptype);
    }
    
    public static void sendToAllPlayers(final IPacket packet) {
        ASPPacketHandler.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set((OutboundTarget)FMLOutboundHandler.OutboundTarget.ALL);
        ASPPacketHandler.channels.get(Side.SERVER).writeOutbound(new Object[] { packet });
    }
    
    public static void sendToServer(final IPacket packet) {
        ASPPacketHandler.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set((OutboundTarget)FMLOutboundHandler.OutboundTarget.TOSERVER);
        ASPPacketHandler.channels.get(Side.CLIENT).writeOutbound(new Object[] { packet });
    }
    
    public static void sendToPlayer(final EntityPlayer ep, final IPacket packet) {
        ASPPacketHandler.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set((OutboundTarget)FMLOutboundHandler.OutboundTarget.PLAYER);
        ASPPacketHandler.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set((Object)ep);
        ASPPacketHandler.channels.get(Side.SERVER).writeOutbound(new Object[] { packet });
    }
    
    static {
        ASPPacketHandler.packetTypes = Lists.newArrayList();
    }
}
