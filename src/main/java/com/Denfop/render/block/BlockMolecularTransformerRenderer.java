// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.render.block;

import com.Denfop.SuperSolarPanels;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;

import net.minecraft.world.IBlockAccess;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BlockMolecularTransformerRenderer implements ISimpleBlockRenderingHandler
{
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        TileEntityRendererDispatcher.instance.renderTileEntityAt((TileEntity)new TileEntityMolecularTransformer(), 0.0, 0.0, 0.0, 0.0f);
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        return false;
    }
    
    public int getRenderId() {
        return SuperSolarPanels.blockMolecularTransformerRenderID;
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
}
