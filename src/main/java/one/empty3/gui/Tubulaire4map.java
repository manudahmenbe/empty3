package one.empty3.gui;

import one.empty3.library.Lumiere;
import one.empty3.library.Point3D;
import one.empty3.library.core.tribase.Tubulaire3;

import java.awt.image.BufferedImage;

public class Tubulaire4map extends Tubulaire3 {

    private BufferedImage mapVolume;

    public Tubulaire4map() {
        super();
    }
    public void updateBitmap(BufferedImage bufferedImage) {
        this.mapVolume = bufferedImage;
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D[] vectPerp = vectPerp(u, v);
        double  lum = Lumiere.getDoubles(mapVolume.getRGB(getX(u), getY(v)))[0];
        return getSoulCurve().getElem().calculerPoint3D(u).plus(
                vectPerp[1].mult(lum).mult(Math.cos(2 * Math.PI * v))).plus(
                vectPerp[2].mult(lum).mult(Math.sin(2 * Math.PI * v)));
    }

    private int getY(double v) {
        return (int)(v*(mapVolume.getHeight()));
    }
    private int getX(double u) {
        return (int)(u*(mapVolume.getWidth()));
    }
}
