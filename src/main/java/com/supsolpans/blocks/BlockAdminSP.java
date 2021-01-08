package com.supsolpans.blocks;

import com.supsolpans.MainSSP;
import com.supsolpans.tiles.TileAdminSolarPanel;

import advsolar.common.AdvancedSolarPanel;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;



public class BlockAdminSP extends AbstractSSP {
	
	private IIcon[] icons;
	
	public BlockAdminSP(){
		super(Material.rock);
		this.setBlockName("BlockAdminSP");
		this.setStepSound(soundTypeMetal);
	    this.setHardness(3F);
	    this.setCreativeTab(MainSSP.tabssp);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		switch (meta)
		{
		
		case 1:
			return new TileAdminSolarPanel();
		
		
		default:
			return new TileAdminSolarPanel();
		}
		
		
	}

	public void registerBlockIcons(IIconRegister reg)
	{
		this.icons = new IIcon[3];
		this.icons[0] = reg.registerIcon("supersolarpanel:admsp_side");
		this.icons[1] = reg.registerIcon("supersolarpanel:admsp_top");
		this.icons[2] = reg.registerIcon("supersolarpanel:admsp_bottom");
	}
	
	
	public IIcon getIcon(int side, int metadata)
	   {
	       switch (side) {
	       case 0: return this.icons[2] ; 
	       case 1: return this.icons[1]; 
	       case 2: if (metadata == 2) 
	                     return this.icons[0]; 
	                   else
	                     return this.icons[0];
	       case 3: return this.icons[0]; 
	       case 4: return this.icons[0]; 
	       case 5: return this.icons[0];
	       }
	       
	       return this.icons[1];
	   }
	
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int s, float f1, float f2, float f3) {
	      if(player.isSneaking()) {
	         return false;
	      } else if(world.isRemote) {
	         return true;
	      } else {
	         TileEntity tileentity = world.getTileEntity(i, j, k);
	         if(tileentity != null) {
	            player.openGui(AdvancedSolarPanel.instance, 1, world, i, j, k);
	         }

	         return true;
	      }
	   }
	
	
}
