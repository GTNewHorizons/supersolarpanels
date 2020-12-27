
package com.Denfop.gui;

import com.Denfop.container.ContainerMolecularTransformer;
import com.Denfop.tiles.base.TileEntityMolecularTransformer;
import com.Denfop.utils.MTRecipeManager;
import com.google.common.collect.Lists;
import org.lwjgl.opengl.GL11;
import net.minecraft.item.ItemStack;
import net.minecraft.client.resources.I18n;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.client.Minecraft;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiMolecularTransformer extends GuiContainer
{
    public TileEntityMolecularTransformer tileentity;
    private int maxTextXPos;
    private static ResourceLocation tex;
    public static List<captionRecord> guiTextList;
    public Minecraft field_146297_k;
    
    public GuiMolecularTransformer(final InventoryPlayer inventoryplayer, final TileEntityMolecularTransformer tileentitymoleculartransformer) {
        super((Container)new ContainerMolecularTransformer(inventoryplayer, tileentitymoleculartransformer));
        this.field_146297_k = FMLClientHandler.instance().getClient();
        this.tileentity = tileentitymoleculartransformer;
        this.allowUserInput = false;
        this.xSize = 220;
        this.ySize = 193;
        this.setCaptionText();
    }
    
    public void setCaptionText() {
        captionRecord textToAdd = new captionRecord();
        textToAdd.textCaption = I18n.format("gui.MolecularTransformer.input", new Object[0]) + ": ";
        textToAdd.textWidth = this.field_146297_k.fontRenderer.getStringWidth(textToAdd.textCaption);
        GuiMolecularTransformer.guiTextList.add(textToAdd);
        textToAdd = new captionRecord();
        textToAdd.textCaption = I18n.format("gui.MolecularTransformer.output", new Object[0]) + ": ";
        textToAdd.textWidth = this.field_146297_k.fontRenderer.getStringWidth(textToAdd.textCaption);
        GuiMolecularTransformer.guiTextList.add(textToAdd);
        textToAdd = new captionRecord();
        textToAdd.textCaption = I18n.format("gui.MolecularTransformer.energyPerOperation", new Object[0]) + ": ";
        textToAdd.textWidth = this.field_146297_k.fontRenderer.getStringWidth(textToAdd.textCaption);
        GuiMolecularTransformer.guiTextList.add(textToAdd);
        textToAdd = new captionRecord();
        textToAdd.textCaption = I18n.format("gui.AdvancedSolarPanel.energyPerTick", new Object[0]) + ": ";
        textToAdd.textWidth = this.field_146297_k.fontRenderer.getStringWidth(textToAdd.textCaption);
        GuiMolecularTransformer.guiTextList.add(textToAdd);
        textToAdd = new captionRecord();
        textToAdd.textCaption = I18n.format("gui.MolecularTransformer.progress", new Object[0]) + ": ";
        textToAdd.textWidth = this.field_146297_k.fontRenderer.getStringWidth(textToAdd.textCaption);
        GuiMolecularTransformer.guiTextList.add(textToAdd);
        this.maxTextXPos = 0;
        for (int i = 0; i < GuiMolecularTransformer.guiTextList.size(); ++i) {
            if (GuiMolecularTransformer.guiTextList.get(i).textWidth > this.maxTextXPos) {
                this.maxTextXPos = GuiMolecularTransformer.guiTextList.get(i).textWidth;
            }
        }
    }
    
    public static String parsingNumber(final String number) {
        String tmpString = "";
        int count = 0;
        for (int i = number.length() - 1; i >= 0; --i) {
            if (count == 3) {
                tmpString = " " + tmpString;
                count = 0;
            }
            ++count;
            tmpString = number.charAt(i) + tmpString;
        }
        return tmpString;
    }
    
    protected void drawGuiContainerForegroundLayer(final int par1, final int par2) {
        final int xOffset = 56;
        final int yOffset = 26;
        final int yTextInterval = 12;
        final String formatDeviceName = I18n.format("blockMolecularTransformer.name", new Object[0]);
        final int nmPos = (this.xSize - this.fontRendererObj.getStringWidth(formatDeviceName)) / 2;
        this.fontRendererObj.drawString(formatDeviceName, nmPos, 8, 16777215);
        if (this.tileentity.lastProgress > 0 || this.tileentity.doWork) {
            final ItemStack inputStack = MTRecipeManager.transformerRecipes.get(this.tileentity.lastRecipeNumber).inputStack;
            final ItemStack outputStack = MTRecipeManager.transformerRecipes.get(this.tileentity.lastRecipeNumber).outputStack;
            final String inputEuFormated = parsingNumber(String.valueOf(this.tileentity.inputEU));
            final String energyPerOpFormated = parsingNumber(String.valueOf(MTRecipeManager.transformerRecipes.get(this.tileentity.lastRecipeNumber).energyPerOperation));
            this.fontRendererObj.drawString(GuiMolecularTransformer.guiTextList.get(0).textCaption + inputStack.getDisplayName(), xOffset + this.maxTextXPos - GuiMolecularTransformer.guiTextList.get(0).textWidth, yOffset, 16777215);
            this.fontRendererObj.drawString(GuiMolecularTransformer.guiTextList.get(1).textCaption + outputStack.getDisplayName(), xOffset + this.maxTextXPos - GuiMolecularTransformer.guiTextList.get(1).textWidth, yOffset + yTextInterval * 1, 16777215);
            this.fontRendererObj.drawString(GuiMolecularTransformer.guiTextList.get(2).textCaption + energyPerOpFormated + " EU", xOffset + this.maxTextXPos - GuiMolecularTransformer.guiTextList.get(2).textWidth, yOffset + yTextInterval * 2, 16777215);
            this.fontRendererObj.drawString(GuiMolecularTransformer.guiTextList.get(3).textCaption + inputEuFormated, xOffset + this.maxTextXPos - GuiMolecularTransformer.guiTextList.get(3).textWidth, yOffset + yTextInterval * 3, 16777215);
            this.fontRendererObj.drawString(GuiMolecularTransformer.guiTextList.get(4).textCaption + this.tileentity.lastProgress + "%", xOffset + this.maxTextXPos - GuiMolecularTransformer.guiTextList.get(4).textWidth, yOffset + yTextInterval * 4, 16777215);
        }
        else {
            this.fontRendererObj.drawString(new StringBuilder().append(GuiMolecularTransformer.guiTextList.get(0).textCaption).toString(), xOffset + this.maxTextXPos - GuiMolecularTransformer.guiTextList.get(0).textWidth, yOffset, 16777215);
            this.fontRendererObj.drawString(new StringBuilder().append(GuiMolecularTransformer.guiTextList.get(1).textCaption).toString(), xOffset + this.maxTextXPos - GuiMolecularTransformer.guiTextList.get(1).textWidth, yOffset + yTextInterval * 1, 16777215);
            this.fontRendererObj.drawString(new StringBuilder().append(GuiMolecularTransformer.guiTextList.get(2).textCaption).toString(), xOffset + this.maxTextXPos - GuiMolecularTransformer.guiTextList.get(2).textWidth, yOffset + yTextInterval * 2, 16777215);
            this.fontRendererObj.drawString(new StringBuilder().append(GuiMolecularTransformer.guiTextList.get(3).textCaption).toString(), xOffset + this.maxTextXPos - GuiMolecularTransformer.guiTextList.get(3).textWidth, yOffset + yTextInterval * 3, 16777215);
            this.fontRendererObj.drawString(new StringBuilder().append(GuiMolecularTransformer.guiTextList.get(4).textCaption).toString(), xOffset + this.maxTextXPos - GuiMolecularTransformer.guiTextList.get(4).textWidth, yOffset + yTextInterval * 4, 16777215);
        }
    }
    
    protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int j) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_146297_k.renderEngine.bindTexture(GuiMolecularTransformer.tex);
        final int h = (this.width - this.xSize) / 2;
        final int k = (this.height - this.ySize) / 2;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        this.drawTexturedModalRect(h, k, 0, 0, this.xSize, this.ySize);
        GL11.glDisable(3042);
        if (this.tileentity.lastProgress > 0) {
            final int l = this.tileentity.lastProgress * 15 / 100;
            this.drawTexturedModalRect(h + 23, k + 48, 221, 7, 10, l + 1);
        }
    }
    
    static {
        GuiMolecularTransformer.tex = new ResourceLocation("supersolarpanel", "textures/gui/guiMolecularTransformerNew.png");
        GuiMolecularTransformer.guiTextList = Lists.newArrayList();
    }
    
    public class captionRecord
    {
        public String textCaption;
        public int textWidth;
    }
}
