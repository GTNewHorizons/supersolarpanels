package ru.wirelesstools.fluidmachines;

import com.Denfop.SuperSolarPanels;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.wirelesstools.MainWV;
import ru.wirelesstools.packets.PacketPlayerStandOn;

public class BlockExpGen extends BlockContainer {
	
	private IIcon[][] icons;
	


	public BlockExpGen(String unlocalizedName, Material mat) {
		super(mat);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.95F, 1.0F);
		this.setBlockName(unlocalizedName); setCreativeTab(SuperSolarPanels.tabssp);
		setHardness(3.0F);
	}
	
	public void registerBlockIcons(IIconRegister reg)
	{
		this.icons = new IIcon[1][12];
		this.icons[0][0] = reg.registerIcon("wirelessvajra:blockXPgen_side_bottom");
		this.icons[0][1] = reg.registerIcon("wirelessvajra:expgen_top");
		this.icons[0][2] = reg.registerIcon("wirelessvajra:blockXPgen_side_bottom");
		this.icons[0][3] = reg.registerIcon("wirelessvajra:blockXPgen_side_bottom");
		this.icons[0][4] = reg.registerIcon("wirelessvajra:blockXPgen_side_bottom");
		this.icons[0][5] = reg.registerIcon("wirelessvajra:blockXPgen_side_bottom");
		this.icons[0][6] = reg.registerIcon("wirelessvajra:blockXPgen_side_bottom");
		this.icons[0][7] = reg.registerIcon("wirelessvajra:expgen_top_active");
		this.icons[0][8] = reg.registerIcon("wirelessvajra:blockXPgen_side_bottom");
		this.icons[0][9] = reg.registerIcon("wirelessvajra:blockXPgen_side_bottom");
		this.icons[0][10] = reg.registerIcon("wirelessvajra:blockXPgen_side_bottom");
		this.icons[0][11] = reg.registerIcon("wirelessvajra:blockXPgen_side_bottom");
	}

	public boolean isActive(IBlockAccess blockaccess, int x, int y, int z) {
		
		
		return ((TileExpGen2)blockaccess.getTileEntity(x, y, z)).getActive();
	
		
	}
	
	
	public IIcon getIcon(IBlockAccess blockaccess, int x, int y, int z, int blockSide) {
		int blockMeta = blockaccess.getBlockMetadata(x, y, z);
		TileEntity te = blockaccess.getTileEntity(x, y, z);
		if (isActive(blockaccess, x, y, z)) {
			
			return this.icons[blockMeta][blockSide + 6];
			
		}
		else if(!isActive(blockaccess, x, y, z)) {
		
	//	System.out.println("Textures change ");
		return this.icons[blockMeta][blockSide];
		
	}
		 return this.icons[blockMeta][blockSide];
	}
	
	
	public IIcon getIcon(int side, int meta) {
		
		
		return this.icons[meta][side];
	
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		
		
		
		return new TileXPGenPublic();
	}
	
	 
	
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		
		TileExpGen2 te = (TileExpGen2) world.getTileEntity(x, y, z);
		if(entity instanceof EntityPlayer & entity != null) {
			
			if (te == null) return; 
		  
			te.isPlayerStandingOnBlock((EntityPlayer) entity, x, y, z, world);
			world.markBlockForUpdate(x, y, z);
		//	System.out.println("Entity Collided " + isActive(world, x, y, z));
		
	}
		world.markBlockForUpdate(x, y, z);
		
	//	Minecraft.getMinecraft().renderGlobal.markBlockForRenderUpdate(x, y, z);
		
	
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	 {
		if(!world.isRemote){
			
			
			player.openGui(MainWV.instance, 1, world, x, y, z);
			
			
		}
		
		return true;
	 }
	
	public boolean isOpaqueCube() { return false; }
	public boolean isNormalCube(IBlockAccess world, int i, int j, int k) { return false; }
}
