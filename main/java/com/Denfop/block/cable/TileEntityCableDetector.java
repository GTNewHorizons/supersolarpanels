package com.Denfop.block.cable;

import ic2.api.energy.EnergyNet;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCableDetector extends TileEntityCable {
  public static int tickRate = 20;
  
  public int ticker = 0;
  
  public TileEntityCableDetector(short meta) {
    super(meta);
  }
  
  public TileEntityCableDetector() {}
  
  public void readFromNBT(NBTTagCompound nbttagcompound) {
    super.readFromNBT(nbttagcompound);
  }
  
  public void writeToNBT(NBTTagCompound nbttagcompound) {
    super.writeToNBT(nbttagcompound);
    nbttagcompound.setBoolean("active", getActive());
  }
  
  protected void updateEntityServer() {
    super.updateEntityServer();
    if (this.ticker++ % tickRate == 0) {
      double energy = EnergyNet.instance.getNodeStats((TileEntity)this).getEnergyIn();
      if (energy > 0.0D) {
        if (!getActive()) {
          setActive(true);
          this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord));
        } 
      } else if (getActive()) {
        setActive(false);
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord));
      } 
    } 
  }
}
