package com.Denfop.render.AdminPanel;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.Denfop.SuperSolarPanels;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderAdminPanel implements ISimpleBlockRenderingHandler {

    public static final IModelCustom model =
            AdvancedModelLoader.loadModel(new ResourceLocation(SuperSolarPanels.TEXTURES, "models/admin.obj"));
    public static final ResourceLocation texture = new ResourceLocation(SuperSolarPanels.TEXTURES, "textures/blocks/SP1.png");
    public static final ResourceLocation texture1 = new ResourceLocation(SuperSolarPanels.TEXTURES, "textures/blocks/SP2.png");
    public static final ResourceLocation texture2 = new ResourceLocation(SuperSolarPanels.TEXTURES, "textures/blocks/SP3.png");
    final int id;

    public RenderAdminPanel(int block_obj_alt_renderID) {
        id = block_obj_alt_renderID;
    }

    @Override

    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.5F, 0.0F, 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        renderer.renderStandardBlock(block, x, y, z);
        tessellator.draw();

        tessellator.setBrightness(world.getLightBrightnessForSkyBlocks(x, y, z, block.getLightValue(world, x, y, z)));
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        GL11.glTranslatef(0.5F, 0.0F, 0.5F);
        
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();
        tessellator.startDrawingQuads();
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return id;
    }

}