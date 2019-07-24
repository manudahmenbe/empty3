package one.empty3.library;

import atlasgen.TextureOpSphere;

import java.awt.image.BufferedImage;

/**
 * Created by manue on 22-06-19.
 */
public class HeightMapSphere extends Sphere implements HeightMapSurface {
    private double axis;
    private ITexture heightMap;
    private double radius;

    public HeightMapSphere(Axe axe, double radius) {
        super(axe, radius);
    }

    public void setHeightMap(BufferedImage bufferedImage) {
        if (bufferedImage != null)
            this.heightMap = new TextureOpSphere(new TextureImg(new ECBufferedImage(bufferedImage)));
        else
            this.heightMap = new TextureOpSphere(new TextureImg(new ECBufferedImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB))));


    }

    public double height(double u, double v) {
        return radius + heightMap.getColorAt(u, v);
    }
}

