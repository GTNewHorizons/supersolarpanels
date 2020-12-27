package ru.wirelesstools.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class PacketChange extends IPacketWV {
	
	private int x;
	private int y;
	private int z;
	private int eventID;
	private NBTTagCompound nbtData;

	@Override
	public void read(DataInputStream bytes) throws Throwable {
		
		this.x = bytes.readInt();
	    this.y = bytes.readInt();
		this.z = bytes.readInt();
		   this.eventID = bytes.readInt();
		     
		int length = bytes.readInt();
		   if (length != -1) {
		       byte[] data = new byte[length];
		      bytes.read(data, 0, length);
		    
		     this.nbtData = CompressedStreamTools.func_152457_a(data, NBTSizeTracker.field_152451_a);
		     } else {
		       
		      this.nbtData = null;
		    } 
		
	}

	@Override
	public void write(DataOutputStream bytes) throws Throwable {
		bytes.writeInt(this.x);
		 bytes.writeInt(this.y);
		bytes.writeInt(this.z);
		bytes.writeInt(this.eventID);
		  
		if (this.nbtData == null) {
		 bytes.writeInt(-1);
		 } else {
		     byte[] nbtBytes = CompressedStreamTools.compress(this.nbtData);
		       bytes.writeInt(nbtBytes.length);
		     bytes.write(nbtBytes);
		 } 
		
	}
	
	
	public static void issue(TileEntity te, int eventID, NBTTagCompound nbtData) {
		PacketChange changeState = new PacketChange();
		changeState.x = te.xCoord;
		changeState.y = te.yCoord;
		changeState.z = te.zCoord;
		changeState.eventID = eventID;
		changeState.nbtData = nbtData;
		
		WVPacketHandler.sendToAllPlayers(changeState);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void execute() {
	WorldClient worldClient = (Minecraft.getMinecraft()).theWorld;
	TileEntity te = worldClient.getTileEntity(this.x, this.y, this.z);
	if (te != null &&  te instanceof IRecieveServerEvents) {
		
		((IRecieveServerEvents)te).onServerEvent(this.eventID, this.nbtData);
		
	}

}
}
