package com.Denfop.render.Cable;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

import com.Denfop.block.Base.BlockMultiID;

public abstract class RenderBlock implements ISimpleBlockRenderingHandler {
  private final int renderId = RenderingRegistry.getNextAvailableRenderId();
  
  public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderblocks) {
    if (block instanceof BlockMultiID && !fromTesr)
      ((BlockMultiID)block).onRender(blockAccess, x, y, z); 
    return false;
  }
  
  public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderblocks) {
    Tessellator tessellator = Tessellator.instance;
    block.setBlockBoundsForItemRender();
    renderblocks.setRenderBoundsFromBlock(block);
    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
    tessellator.startDrawingQuads();
    tessellator.setNormal(0.0F, -1.0F, 0.0F);
    renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 0, metadata));
    tessellator.draw();
    tessellator.startDrawingQuads();
    tessellator.setNormal(0.0F, 1.0F, 0.0F);
    renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 1, metadata));
    tessellator.draw();
    tessellator.startDrawingQuads();
    tessellator.setNormal(0.0F, 0.0F, -1.0F);
    renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 2, metadata));
    tessellator.draw();
    tessellator.startDrawingQuads();
    tessellator.setNormal(0.0F, 0.0F, 1.0F);
    renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 3, metadata));
    tessellator.draw();
    tessellator.startDrawingQuads();
    tessellator.setNormal(-1.0F, 0.0F, 0.0F);
    renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 4, metadata));
    tessellator.draw();
    tessellator.startDrawingQuads();
    tessellator.setNormal(1.0F, 0.0F, 0.0F);
    renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 5, metadata));
    tessellator.draw();
    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
  }
  
  public boolean shouldRender3DInInventory(int modelId) {
    return true;
  }
  
  public int getRenderId() {
    return this.renderId;
  }
  
  public static IIcon getMissingIcon(ResourceLocation textureSheet) {
    return (IIcon)((TextureMap)Minecraft.getMinecraft().getTextureManager().getTexture(textureSheet)).getAtlasSprite("missingno");
  }
  
  public static boolean fromTesr = false;
}
