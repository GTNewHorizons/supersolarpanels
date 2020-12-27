
package com.Denfop.render.tile;

import java.util.HashMap;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.client.FMLClientHandler;
import org.lwjgl.opengl.GL11;

import com.Denfop.tiles.base.TileEntityMolecularTransformer;

import java.awt.Color;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.tileentity.TileEntity;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import java.util.Arrays;
import java.io.Serializable;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TileMolecularTransformerRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation transfTextloc;
    private static final ResourceLocation plazmaTextloc;
    private static final ResourceLocation particlesTextloc;
    public final ModelMolecularTransformer model;
    private static Map textureSizeCache;
    public int ticker;
    
    public TileMolecularTransformerRenderer() {
        this.model = new ModelMolecularTransformer();
    }
    
    public static int getTextureSize(final String s, final int dv) {
        if (TileMolecularTransformerRenderer.textureSizeCache.get(Arrays.asList(s, dv)) != null) {
            return (Integer) TileMolecularTransformerRenderer.textureSizeCache.get(Arrays.asList(s, dv));
        }
        try {
            final InputStream inputstream = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("supersolarpanel", s)).getInputStream();
            if (inputstream == null) {
                throw new Exception("Image not found: " + s);
            }
            final BufferedImage bi = ImageIO.read(inputstream);
            final int size = bi.getWidth() / dv;
            TileMolecularTransformerRenderer.textureSizeCache.put(Arrays.asList(s, dv), size);
            return size;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 16;
        }
    }
    
    public void renderCore(final TileEntity te, final double x, final double y, final double z, final float scale) {
        int size1 = 0;
        int size2 = 0;
        ++this.ticker;
        if (this.ticker > 161) {
            this.ticker = 1;
        }
        size1 = getTextureSize("textures/models/plazma.png", 64);
        size2 = getTextureSize("textures/models/particles.png", 32);
        final float f1 = ActiveRenderInfo.rotationX;
        final float f2 = ActiveRenderInfo.rotationXZ;
        final float f3 = ActiveRenderInfo.rotationZ;
        final float f4 = ActiveRenderInfo.rotationYZ;
        final float f5 = ActiveRenderInfo.rotationXY;
        float scaleCore = 0.35f;
        final float posX = (float)x + 0.5f;
        final float posY = (float)y + 0.5f;
        final float posZ = (float)z + 0.5f;
        final Tessellator tessellator = Tessellator.instance;
        final Color color = new Color(12648447);
        GL11.glPushMatrix();
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TileMolecularTransformerRenderer.plazmaTextloc);
        int i = this.ticker % 16;
        final float size3 = (float)(size1 * 4);
        float float_sizeMinus0_01 = size1 - 0.01f;
        float float_texNudge = 1.0f / (size1 * size1 * 2.0f);
        float float_reciprocal = 1.0f / size1;
        float x2 = (i % 4 * size1 + 0.0f) / size3;
        float x3 = (i % 4 * size1 + float_sizeMinus0_01) / size3;
        float x4 = (i / 4 * size1 + 0.0f) / size3;
        float x5 = (i / 4 * size1 + float_sizeMinus0_01) / size3;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, 1.0f);
        tessellator.addVertexWithUV((double)(posX - f1 * scaleCore - f4 * scaleCore), (double)(posY - f2 * scaleCore), (double)(posZ - f3 * scaleCore - f5 * scaleCore), (double)x3, (double)x5);
        tessellator.addVertexWithUV((double)(posX - f1 * scaleCore + f4 * scaleCore), (double)(posY + f2 * scaleCore), (double)(posZ - f3 * scaleCore + f5 * scaleCore), (double)x3, (double)x4);
        tessellator.addVertexWithUV((double)(posX + f1 * scaleCore + f4 * scaleCore), (double)(posY + f2 * scaleCore), (double)(posZ + f3 * scaleCore + f5 * scaleCore), (double)x2, (double)x4);
        tessellator.addVertexWithUV((double)(posX + f1 * scaleCore - f4 * scaleCore), (double)(posY - f2 * scaleCore), (double)(posZ + f3 * scaleCore - f5 * scaleCore), (double)x2, (double)x5);
        tessellator.draw();
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TileMolecularTransformerRenderer.particlesTextloc);
        final int qq = this.ticker % 16;
        i = 24 + qq;
        final float size4 = (float)(size2 * 8);
        float_sizeMinus0_01 = size2 - 0.01f;
        float_texNudge = 1.0f / (size2 * size2 * 2.0f);
        float_reciprocal = 1.0f / size2;
        x2 = (i % 8 * size2 + 0.0f) / size4;
        x3 = (i % 8 * size2 + float_sizeMinus0_01) / size4;
        x4 = (i / 8 * size2 + 0.0f) / size4;
        x5 = (i / 8 * size2 + float_sizeMinus0_01) / size4;
        final float var11 = MathHelper.sin(this.ticker / 10.0f) * 0.1f;
        scaleCore = 0.4f + var11;
        tessellator.startDrawingQuads();
        tessellator.setBrightness(240);
        tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, 1.0f);
        tessellator.addVertexWithUV((double)(posX - f1 * scaleCore - f4 * scaleCore), (double)(posY - f2 * scaleCore), (double)(posZ - f3 * scaleCore - f5 * scaleCore), (double)x3, (double)x5);
        tessellator.addVertexWithUV((double)(posX - f1 * scaleCore + f4 * scaleCore), (double)(posY + f2 * scaleCore), (double)(posZ - f3 * scaleCore + f5 * scaleCore), (double)x3, (double)x4);
        tessellator.addVertexWithUV((double)(posX + f1 * scaleCore + f4 * scaleCore), (double)(posY + f2 * scaleCore), (double)(posZ + f3 * scaleCore + f5 * scaleCore), (double)x2, (double)x4);
        tessellator.addVertexWithUV((double)(posX + f1 * scaleCore - f4 * scaleCore), (double)(posY - f2 * scaleCore), (double)(posZ + f3 * scaleCore - f5 * scaleCore), (double)x2, (double)x5);
        tessellator.draw();
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        GL11.glPopMatrix();
    }
    
    public void renderTileEntityAt(final TileEntity te, final double x, final double y, final double z, final float scale) {
        this.renderTileEntityAt((TileEntityMolecularTransformer)te, x, y, z, scale);
    }
    
    public void renderTileEntityAt(final TileEntityMolecularTransformer tileTransformer, final double x, final double y, final double z, final float scale) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TileMolecularTransformerRenderer.transfTextloc);
        this.model.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        if (tileTransformer.isActive()) {
            GL11.glPushMatrix();
            this.renderCore(tileTransformer, x, y, z, scale);
            GL11.glPopMatrix();
        }
    }
    
    private void rotateBlock(final World world, final int x, final int y, final int z, final Block block) {
        if (world != null) {
            final int dir = world.getBlockMetadata(x, y, z);
            GL11.glPushMatrix();
            GL11.glRotatef((float)(dir * 90), 0.0f, 1.0f, 0.0f);
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(TileMolecularTransformerRenderer.transfTextloc);
            this.model.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
            GL11.glPopMatrix();
        }
        else {
            GL11.glPushMatrix();
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(TileMolecularTransformerRenderer.transfTextloc);
            this.model.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
            GL11.glPopMatrix();
        }
    }
    
    static {
        transfTextloc = new ResourceLocation("supersolarpanel", "textures/models/textureMolecularTransformer.png");
        plazmaTextloc = new ResourceLocation("supersolarpanel", "textures/models/plazma.png");
        particlesTextloc = new ResourceLocation("supersolarpanel", "textures/models/particles.png");
        TileMolecularTransformerRenderer.textureSizeCache = new HashMap();
    }
}
