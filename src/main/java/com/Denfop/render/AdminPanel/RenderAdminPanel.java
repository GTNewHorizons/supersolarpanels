package com.Denfop.render.AdminPanel;


import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.common.util.ForgeDirection;


public class RenderAdminPanel extends TileEntitySpecialRenderer
{
    
    private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("supersolarpanel", "textures/models/panel.obj") ); 
    private ResourceLocation CubeTest; 

    public RenderAdminPanel()
    {
        CubeTest = new ResourceLocation("supersolarpanel", "textures/model/panel.png"); 
    }

    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f)
    {
        
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        
        bindTexture(CubeTest); 
        model.renderAll(); 
        
        GL11.glPopMatrix();
    }
    
 
    
}