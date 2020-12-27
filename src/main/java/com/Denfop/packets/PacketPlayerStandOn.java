package com.Denfop.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import com.Denfop.block.expgen.IStandOn;
import com.Denfop.block.expgen.TileExpGen2;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public class PacketPlayerStandOn extends IPacketWV {
	
	public int dimID;
	public int x;
	public int y;
	public int z;
	public boolean active;
	
	
	
	@Override
	public void read(DataInputStream bytes) throws Throwable {
		this.dimID = bytes.readInt();
		this.x = bytes.readInt();
		this.y = bytes.readInt();
		this.z = bytes.readInt();
		this.active = bytes.readBoolean();
		
	}

	@Override
	public void write(DataOutputStream bytes) throws Throwable {
		bytes.writeInt(this.dimID);
		bytes.writeInt(this.x);
		bytes.writeInt(this.y);
		bytes.writeInt(this.z);
		bytes.writeBoolean(this.active);
		
	}
	
	public static void issue(TileExpGen2 te, boolean bool) {
		PacketPlayerStandOn pgpb = new PacketPlayerStandOn();
		pgpb.x = te.xCoord;
		pgpb.y = te.yCoord;
		pgpb.z = te.zCoord;
		pgpb.dimID = (te.getWorldObj()).provider.dimensionId;
		pgpb.active = bool;
		WVPacketHandler.sendToServer(pgpb);
	}

	public void execute() {
		try {
		      WorldServer ws = DimensionManager.getWorld(this.dimID);
		      if (ws != null) {
		      TileEntity te = ws.getTileEntity(this.x, this.y, this.z);
		        if (te != null && te instanceof IStandOn)
		        	
		        	
		         ((TileExpGen2)te).setActiveVoid(this.active, x, y, z, te.getWorldObj());
		      } 
		   } catch (Throwable t) {
		     t.printStackTrace();
		    } 
		   }
	
	
	
	
	
	
	

}
