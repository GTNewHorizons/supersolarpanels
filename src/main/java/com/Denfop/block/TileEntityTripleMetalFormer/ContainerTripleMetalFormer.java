package com.Denfop.block.TileEntityTripleMetalFormer;


import java.util.List;

import com.Denfop.block.containerbase.ContainerDoubleMachine;
import com.Denfop.block.containerbase.ContainerTripleMachine;

import net.minecraft.entity.player.EntityPlayer;

public class ContainerTripleMetalFormer extends ContainerTripleMachine<TileEntityTripleMetalFormer> {
  public ContainerTripleMetalFormer(EntityPlayer entityPlayer, TileEntityTripleMetalFormer tileEntity1) {
    super(entityPlayer, tileEntity1, 166, 17, 53, 17, 17, 116, 35, 152, 8);
  }
  
  public List<String> getNetworkedFields() {
    List<String> ret = super.getNetworkedFields();
    ret.add("mode");
    return ret;
  }
}


