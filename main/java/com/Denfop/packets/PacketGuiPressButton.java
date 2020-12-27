package com.Denfop.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public class PacketGuiPressButton extends IPacketWV {

	public int dimID;
	public int x;
	public int y;
	public int z;
	public int buttonID;
	
	
	@Override
	public void read(DataInputStream bytes) throws Throwable {
		this.dimID = bytes.readInt();
		this.x = bytes.readInt();
		this.y = bytes.readInt();
		this.z = bytes.readInt();
		this.buttonID = bytes.readInt();
		
	}

	@Override
	public void write(DataOutputStream bytes) throws Throwable {
		bytes.writeInt(this.dimID);
		bytes.writeInt(this.x);
		bytes.writeInt(this.y);
		bytes.writeInt(this.z);
		bytes.writeInt(this.buttonID);
		
	}
	
	public static void issue(TileEntity te, int buttonID) {
		PacketGuiPressButton pgpb = new PacketGuiPressButton();
		pgpb.x = te.xCoord;
		pgpb.y = te.yCoord;
		pgpb.z = te.zCoord;
		pgpb.dimID = (te.getWorldObj()).provider.dimensionId;
		pgpb.buttonID = buttonID;
		WVPacketHandler.sendToServer(pgpb);
	}

	public void execute() {
		try {
		      WorldServer ws = DimensionManager.getWorld(this.dimID);
		      if (ws != null) {
		      TileEntity te = ws.getTileEntity(this.x, this.y, this.z);
		        if (te != null && te instanceof IHasButton)
		         ((IHasButton)te).handleButtonClick(this.buttonID); 
		      } 
		   } catch (Throwable t) {
		     t.printStackTrace();
		    } 
		   }
	
}
