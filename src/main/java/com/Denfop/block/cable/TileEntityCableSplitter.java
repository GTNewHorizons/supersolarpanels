package com.Denfop.block.cable;

import cpw.mods.fml.common.eventhandler.Event;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergyTile;
import net.minecraftforge.common.MinecraftForge;

public class TileEntityCableSplitter extends TileEntityCable {
  public static final int tickRate = 20;
  
  public int ticksUntilNextUpdate = 0;
  
  public TileEntityCableSplitter(short type) {
    super(type);
  }
  
  public TileEntityCableSplitter() {}
  
  protected void updateEntityServer() {
    super.updateEntityServer();
    if (this.ticksUntilNextUpdate == 0) {
      this.ticksUntilNextUpdate = 20;
      if (this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord) == this.addedToEnergyNet)
        if (this.addedToEnergyNet) {
          MinecraftForge.EVENT_BUS.post((Event)new EnergyTileUnloadEvent((IEnergyTile)this));
          this.addedToEnergyNet = false;
        } else {
          MinecraftForge.EVENT_BUS.post((Event)new EnergyTileLoadEvent((IEnergyTile)this));
          this.addedToEnergyNet = true;
        }  
      setActive(this.addedToEnergyNet);
    } 
    this.ticksUntilNextUpdate--;
  }
}
