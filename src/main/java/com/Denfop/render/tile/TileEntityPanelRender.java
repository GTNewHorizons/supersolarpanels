package com.Denfop.render.tile;

import org.lwjgl.opengl.GL11;

import com.Denfop.SuperSolarPanels;
import com.Denfop.TileEntityAdminSolarPanel;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class TileEntityPanelRender extends TileEntitySpecialRenderer {

	  static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("supersolarpanel", "textures/models/panel.obj") ); 
	public static final ResourceLocation texture = new ResourceLocation(SuperSolarPanels.TEXTURES,
			"textures/model/panel.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityAdminSolarPanel) tile, x, y, z, f);
	}

	private void render(TileEntityAdminSolarPanel tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		bindTexture(texture);
		model.renderAll();
		GL11.glPopMatrix();
	}

}