package com.Denfop.block.TileEntityDoubleMetalFormer;


import java.util.List;

import com.Denfop.block.containerbase.ContainerDoubleMachine;

import net.minecraft.entity.player.EntityPlayer;

public class ContainerDoubleMetalFormer extends ContainerDoubleMachine<TileEntityDoubleMetalFormer> {
  public ContainerDoubleMetalFormer(EntityPlayer entityPlayer, TileEntityDoubleMetalFormer tileEntity1) {
    super(entityPlayer, tileEntity1, 166, 17, 53, 17, 17, 116, 35, 152, 8);
  }
  
  public List<String> getNetworkedFields() {
    List<String> ret = super.getNetworkedFields();
    ret.add("mode");
    return ret;
  }
}
