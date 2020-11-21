// 
// Decompiled by Procyon v0.5.36
// 

package com.Denfop.gui;

import org.lwjgl.opengl.GL11;

import com.Denfop.container.ContainerAdvSolarPanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiAdvSolarPanel extends GuiContainer
{
    public TileEntitySolarPanel tileentity;
    private static ResourceLocation tex;
    
    public GuiAdvSolarPanel(final InventoryPlayer inventoryplayer, final TileEntitySolarPanel tileentitysolarpanel) {
        super((Container)new ContainerAdvSolarPanel(inventoryplayer, tileentitysolarpanel));
        this.tileentity = tileentitysolarpanel;
        this.allowUserInput = false;
        this.xSize = 194;
        this.ySize = 168;
    }
    
    protected void drawGuiContainerForegroundLayer(final int par1, final int par2) {
        final String formatPanelName = I18n.format(this.tileentity.panelName, new Object[0]);
        final int nmPos = (this.xSize - this.fontRendererObj.getStringWidth(formatPanelName)) / 2;
        this.fontRendererObj.drawString(formatPanelName, nmPos, 7, 7718655);
        final String storageString = I18n.format("gui.AdvancedSolarPanel.storage", new Object[0]) + ": ";
        final String maxOutputString = I18n.format("gui.AdvancedSolarPanel.maxOutput", new Object[0]) + ": ";
        final String generatingString = I18n.format("gui.AdvancedSolarPanel.generating", new Object[0]) + ": ";
        final String energyPerTickString = I18n.format("gui.AdvancedSolarPanel.energyPerTick", new Object[0]);
        this.fontRendererObj.drawString(storageString + this.tileentity.storage + "/" + this.tileentity.maxStorage, 50, 22, 13487565);
        this.fontRendererObj.drawString(maxOutputString + this.tileentity.production + (" " + energyPerTickString), 50, 32, 13487565);
        this.fontRendererObj.drawString(generatingString + this.tileentity.generating + (" " + energyPerTickString), 50, 42, 13487565);
    }
    
    protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int j) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(GuiAdvSolarPanel.tex);
        final int h = (this.width - this.xSize) / 2;
        final int k = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(h, k, 0, 0, this.xSize, this.ySize);
        if (this.tileentity.storage > 0) {
            final int l = this.tileentity.gaugeEnergyScaled(24);
            this.drawTexturedModalRect(h + 19, k + 24, 195, 0, l + 1, 14);
        }
        if (this.tileentity.skyIsVisible) {
            if (this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
            }
            else if (!this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
            }
        }
    }
    
    static {
        GuiAdvSolarPanel.tex = new ResourceLocation("supersolarpanel", "textures/gui/GUIAdvancedSolarPanel.png");
    }
}
