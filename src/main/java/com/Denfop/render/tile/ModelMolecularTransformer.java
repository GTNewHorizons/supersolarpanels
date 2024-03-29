
package com.Denfop.render.tile;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelMolecularTransformer extends ModelBase
{
    ModelRenderer coreBottom;
    ModelRenderer coreWorkZone;
    ModelRenderer coreTopElectr;
    ModelRenderer coreTopPlate;
    ModelRenderer firstElTop;
    ModelRenderer firstElBottom;
    ModelRenderer firstElPart1;
    ModelRenderer firstElPart2;
    ModelRenderer firstElPart3;
    ModelRenderer firstElPart4;
    ModelRenderer firstElPart5;
    ModelRenderer firstElPart6;
    ModelRenderer firstElPart7;
    ModelRenderer secondElTop;
    ModelRenderer secondElBottom;
    ModelRenderer secondElPart1;
    ModelRenderer secondElPart2;
    ModelRenderer secondElPart3;
    ModelRenderer secondElPart4;
    ModelRenderer secondElPart5;
    ModelRenderer secondElPart6;
    ModelRenderer secondElPart7;
    ModelRenderer thirdElTop;
    ModelRenderer thirdElBottom;
    ModelRenderer thirdElPart1;
    ModelRenderer thirdElPart2;
    ModelRenderer thirdElPart3;
    ModelRenderer thirdElPart4;
    ModelRenderer thirdElPart5;
    ModelRenderer thirdElPart6;
    ModelRenderer thirdElPart7;
    
    public ModelMolecularTransformer() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.coreBottom = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-5.0f, 4.0f, -5.0f, 10, 3, 10);
        this.coreBottom.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.coreBottom.setTextureSize(128, 64);
        this.coreBottom.mirror = true;
        this.setRotation(this.coreBottom, 0.0f, 0.0f, 0.0f);
        (this.coreWorkZone = new ModelRenderer((ModelBase)this, 0, 44)).addBox(-3.0f, -4.0f, -3.0f, 6, 9, 6);
        this.coreWorkZone.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.coreWorkZone.setTextureSize(128, 64);
        this.coreWorkZone.mirror = true;
        this.setRotation(this.coreWorkZone, 0.0f, 0.0f, 0.0f);
        (this.coreTopElectr = new ModelRenderer((ModelBase)this, 25, 44)).addBox(-2.0f, -8.0f, -1.466667f, 3, 2, 3);
        this.coreTopElectr.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.coreTopElectr.setTextureSize(128, 64);
        this.coreTopElectr.mirror = true;
        this.setRotation(this.coreTopElectr, 0.0f, 0.0f, 0.0f);
        (this.coreTopPlate = new ModelRenderer((ModelBase)this, 0, 30)).addBox(-5.0f, -7.0f, -4.5f, 9, 3, 9);
        this.coreTopPlate.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.coreTopPlate.setTextureSize(128, 64);
        this.coreTopPlate.mirror = true;
        this.setRotation(this.coreTopPlate, 0.0f, 0.0f, 0.0f);
        (this.firstElTop = new ModelRenderer((ModelBase)this, 20, 16)).addBox(3.0f, -8.0f, -5.0f, 4, 3, 10);
        this.firstElTop.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.firstElTop.setTextureSize(128, 64);
        this.firstElTop.mirror = true;
        this.setRotation(this.firstElTop, 0.0f, 0.0f, 0.0f);
        (this.firstElBottom = new ModelRenderer((ModelBase)this, 49, 16)).addBox(4.0f, 3.0f, -3.0f, 3, 5, 6);
        this.firstElBottom.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.firstElBottom.setTextureSize(128, 64);
        this.firstElBottom.mirror = true;
        this.setRotation(this.firstElBottom, 0.0f, 0.0f, 0.0f);
        (this.firstElPart1 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.firstElPart1.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.firstElPart1.setTextureSize(128, 64);
        this.firstElPart1.mirror = true;
        this.setRotation(this.firstElPart1, 0.0f, 3.141593f, -0.6108652f);
        (this.firstElPart2 = new ModelRenderer((ModelBase)this, 13, 18)).addBox(-8.0f, -2.0f, -1.0f, 1, 4, 2);
        this.firstElPart2.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.firstElPart2.setTextureSize(128, 64);
        this.firstElPart2.mirror = true;
        this.setRotation(this.firstElPart2, 0.0f, 3.141593f, -0.3665191f);
        (this.firstElPart3 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.firstElPart3.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.firstElPart3.setTextureSize(128, 64);
        this.firstElPart3.mirror = true;
        this.setRotation(this.firstElPart3, 0.0f, 3.141593f, -0.296706f);
        (this.firstElPart4 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.firstElPart4.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.firstElPart4.setTextureSize(128, 64);
        this.firstElPart4.mirror = true;
        this.setRotation(this.firstElPart4, 0.0f, 3.141593f, 0.0f);
        (this.firstElPart5 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.firstElPart5.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.firstElPart5.setTextureSize(128, 64);
        this.firstElPart5.mirror = true;
        this.setRotation(this.firstElPart5, 0.0f, 3.141593f, 0.296706f);
        (this.firstElPart6 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.firstElPart6.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.firstElPart6.setTextureSize(128, 64);
        this.firstElPart6.mirror = true;
        this.setRotation(this.firstElPart6, 0.0f, 3.141593f, 0.6108652f);
        (this.firstElPart7 = new ModelRenderer((ModelBase)this, 13, 18)).addBox(-8.0f, -2.0f, -1.0f, 1, 4, 2);
        this.firstElPart7.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.firstElPart7.setTextureSize(128, 64);
        this.firstElPart7.mirror = true;
        this.setRotation(this.firstElPart7, 0.0f, 3.141593f, 0.3665191f);
        (this.secondElTop = new ModelRenderer((ModelBase)this, 20, 16)).addBox(3.0f, -8.0f, -5.0f, 4, 3, 10);
        this.secondElTop.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.secondElTop.setTextureSize(128, 64);
        this.secondElTop.mirror = true;
        this.setRotation(this.secondElTop, 0.0f, -2.094395f, 0.0f);
        (this.secondElBottom = new ModelRenderer((ModelBase)this, 49, 16)).addBox(4.0f, 3.0f, -3.0f, 3, 5, 6);
        this.secondElBottom.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.secondElBottom.setTextureSize(128, 64);
        this.secondElBottom.mirror = true;
        this.setRotation(this.secondElBottom, 0.0f, -2.094395f, 0.0f);
        (this.secondElPart1 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.secondElPart1.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.secondElPart1.setTextureSize(128, 64);
        this.secondElPart1.mirror = true;
        this.setRotation(this.secondElPart1, 0.0f, 1.047198f, -0.6108652f);
        (this.secondElPart2 = new ModelRenderer((ModelBase)this, 13, 18)).addBox(-8.0f, -2.0f, -1.0f, 1, 4, 2);
        this.secondElPart2.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.secondElPart2.setTextureSize(128, 64);
        this.secondElPart2.mirror = true;
        this.setRotation(this.secondElPart2, 0.0f, 1.047198f, -0.3665191f);
        (this.secondElPart3 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.secondElPart3.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.secondElPart3.setTextureSize(128, 64);
        this.secondElPart3.mirror = true;
        this.setRotation(this.secondElPart3, 0.0f, 1.047198f, -0.296706f);
        (this.secondElPart4 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.secondElPart4.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.secondElPart4.setTextureSize(128, 64);
        this.secondElPart4.mirror = true;
        this.setRotation(this.secondElPart4, 0.0f, 1.047198f, 0.0f);
        (this.secondElPart5 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.secondElPart5.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.secondElPart5.setTextureSize(128, 64);
        this.secondElPart5.mirror = true;
        this.setRotation(this.secondElPart5, 0.0f, 1.047198f, 0.296706f);
        (this.secondElPart6 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.secondElPart6.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.secondElPart6.setTextureSize(128, 64);
        this.secondElPart6.mirror = true;
        this.setRotation(this.secondElPart6, 0.0f, 1.047198f, 0.6108652f);
        (this.secondElPart7 = new ModelRenderer((ModelBase)this, 13, 18)).addBox(-8.0f, -2.0f, -1.0f, 1, 4, 2);
        this.secondElPart7.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.secondElPart7.setTextureSize(128, 64);
        this.secondElPart7.mirror = true;
        this.setRotation(this.secondElPart7, 0.0f, 1.047198f, 0.3665191f);
        (this.thirdElTop = new ModelRenderer((ModelBase)this, 20, 16)).addBox(3.0f, -8.0f, -5.0f, 4, 3, 10);
        this.thirdElTop.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.thirdElTop.setTextureSize(128, 64);
        this.thirdElTop.mirror = true;
        this.setRotation(this.thirdElTop, 0.0f, 2.094395f, 0.0f);
        (this.thirdElBottom = new ModelRenderer((ModelBase)this, 49, 16)).addBox(4.0f, 3.0f, -3.0f, 3, 5, 6);
        this.thirdElBottom.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.thirdElBottom.setTextureSize(128, 64);
        this.thirdElBottom.mirror = true;
        this.setRotation(this.thirdElBottom, 0.0f, 2.094395f, 0.0f);
        (this.thirdElPart1 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.thirdElPart1.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.thirdElPart1.setTextureSize(128, 64);
        this.thirdElPart1.mirror = true;
        this.setRotation(this.thirdElPart1, 0.0f, -1.047198f, -0.6108652f);
        (this.thirdElPart2 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.thirdElPart2.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.thirdElPart2.setTextureSize(128, 64);
        this.thirdElPart2.mirror = true;
        this.setRotation(this.thirdElPart2, 0.0f, -1.047198f, -0.296706f);
        (this.thirdElPart3 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.thirdElPart3.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.thirdElPart3.setTextureSize(128, 64);
        this.thirdElPart3.mirror = true;
        this.setRotation(this.thirdElPart3, 0.0f, -1.047198f, 0.0f);
        (this.thirdElPart4 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.thirdElPart4.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.thirdElPart4.setTextureSize(128, 64);
        this.thirdElPart4.mirror = true;
        this.setRotation(this.thirdElPart4, 0.0f, -1.047198f, 0.296706f);
        (this.thirdElPart5 = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-9.0f, -1.0f, -2.0f, 2, 2, 4);
        this.thirdElPart5.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.thirdElPart5.setTextureSize(128, 64);
        this.thirdElPart5.mirror = true;
        this.setRotation(this.thirdElPart5, 0.0f, -1.047198f, 0.6108652f);
        (this.thirdElPart6 = new ModelRenderer((ModelBase)this, 13, 18)).addBox(-8.0f, -2.0f, -1.0f, 1, 4, 2);
        this.thirdElPart6.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.thirdElPart6.setTextureSize(128, 64);
        this.thirdElPart6.mirror = true;
        this.setRotation(this.thirdElPart6, 0.0f, -1.047198f, 0.3665191f);
        (this.thirdElPart7 = new ModelRenderer((ModelBase)this, 13, 18)).addBox(-8.0f, -2.0f, -1.0f, 1, 4, 2);
        this.thirdElPart7.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.thirdElPart7.setTextureSize(128, 64);
        this.thirdElPart7.mirror = true;
        this.setRotation(this.thirdElPart7, 0.0f, -1.047198f, -0.3665191f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.coreBottom.render(f5);
        GL11.glPushMatrix();
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        this.coreWorkZone.render(f5);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        GL11.glPopMatrix();
        this.coreTopElectr.render(f5);
        this.coreTopPlate.render(f5);
        this.firstElTop.render(f5);
        this.firstElBottom.render(f5);
        this.secondElTop.render(f5);
        this.secondElBottom.render(f5);
        this.thirdElTop.render(f5);
        this.thirdElBottom.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
