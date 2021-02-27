
package com.Denfop.api.utils.textures;

import java.awt.image.BufferedImage;

import net.minecraft.client.renderer.texture.AbstractTexture;

/**
 * 
 * @author MozG
 *
 */
public abstract class Texture extends AbstractTexture {

    protected BufferedImage imageData;

    public BufferedImage getImage() {
        return imageData;
    }

}
