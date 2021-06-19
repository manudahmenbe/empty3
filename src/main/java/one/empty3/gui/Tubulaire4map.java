package one.empty3.gui;

import one.empty3.library.ECBufferedImage;
import one.empty3.library.Lumiere;
import one.empty3.library.Point3D;
import one.empty3.library.StructureMatrix;
import one.empty3.library.core.nurbs.FctXY;
import one.empty3.library.core.tribase.Tubulaire3;

import java.awt.image.BufferedImage;

public class Tubulaire4map extends Tubulaire3 {

    private StructureMatrix<ECBufferedImage> mapVolume = new StructureMatrix<>(0, ECBufferedImage.class);

    public Tubulaire4map() {
        super();
    }
    public void updateBitmap(BufferedImage bufferedImage) {
        this.mapVolume.setElem(new ECBufferedImage(bufferedImage));
    }

    /***
     * Epaisseur de pourtour renseignée par la composante ROUGE de la couleur
     * au pixel (u,v) de l'image
     * @param u Le long de la "courbe d'âme" le squelette
     * @param v Autour du squelette (choir)
     *
     * @return coordonnées du point 3D de la surface.
     */
    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D[] vectPerp = vectPerp(u, v);
        double  lum = Lumiere.getDoubles(mapVolume.getElem().getRGB(getX(u), getY(v)))[0];
        Point3D plus = getSoulCurve().getElem().calculerPoint3D(u).plus(
                vectPerp[1].mult(((FctXY) getDiameterFunction().getElem()).result(u) * lum).mult(Math.cos(2 * Math.PI * v))).plus(
                vectPerp[2].mult(((FctXY) getDiameterFunction().getElem()).result(u) * lum).mult(Math.sin(2 * Math.PI * v)));
        return plus;
    }

    private int getX(double u) {
        return (int)(u*(mapVolume.getElem().getWidth()-1));
    }
    private int getY(double v) {
        return (int)(v*(mapVolume.getElem().getHeight()-1));
    }
}
