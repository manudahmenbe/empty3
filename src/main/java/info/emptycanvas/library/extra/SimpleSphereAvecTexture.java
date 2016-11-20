/*

 Vous êtes libre de :

 */
package info.emptycanvas.library.extra;

import info.emptycanvas.library.object.ECBufferedImage;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.TRI;
import info.emptycanvas.library.object.TRIObject;
import info.emptycanvas.library.object.Axe;
import info.emptycanvas.library.object.Matrix33;
import info.emptycanvas.library.object.PObjet;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * @author MANUEL DAHMEN
 *
 * dev
 *
 * 27 oct. 2011
 *
 */
public class SimpleSphereAvecTexture extends SimpleSphere {

    private BufferedImage img;
    private Axe axe;
    private double angle;
    private String fichier;

    /**
     * @param c
     * @param r
     * @param col
     */
    public SimpleSphereAvecTexture(Point3D c, double r, Color col) {
        super(c, r, col);
    }

    public SimpleSphereAvecTexture(Point3D c, double r, Color col,
            BufferedImage bufferedImage) {
        super(c, r, col);
        texture(bufferedImage);
    }

    public SimpleSphereAvecTexture(Point3D c, Matrix33 m3d, double angle, double r,
            Color col, ECBufferedImage img) {
        super(c, r, col);
        this.axe = axe;
        this.angle = angle;
        texture(img);
    }

    public void fichier(String f) {
        fichier = f;
    }

    @Override
    public TRIObject generate() {
        TRIObject t = new TRIObject();
        po = new PObjet();

        double a = -Math.PI / 2;
        double b;
        double incrLat;
        double incrLong;
        Point3D[] pCur = new Point3D[4];

        incrLat = 2 * Math.PI / numLatQuad;
        while (a < Math.PI / 2) {
            incrLong = 2 * Math.PI * Math.cos(a) / numLongQuad;
            b = 0;
            while (b < 2 * Math.PI && incrLong > 0.0001) {
                //System.out.println("a;b " + a +";"+b);
                pCur[0] = CoordPoint(a, b);
                pCur[1] = CoordPoint(a + incrLat, b);
                pCur[2] = CoordPoint(a, b + incrLong);
                pCur[3] = CoordPoint(a + incrLat, b + incrLong);
                try {
                    Color color = new Color(img.getRGB(
                            (int) ((a + Math.PI) / Math.PI * img.getHeight()),
                            (int) ((b) / 2 / Math.PI * img.getWidth())));
                    t.add(new TRI(pCur[0], pCur[1], pCur[3], color));
                    t.add(new TRI(pCur[0], pCur[2], pCur[3], color));
                } catch (Exception ex) {
                }
                b += incrLong;
            }
            a += incrLat;
        }
        return t;
    }

    public void texture(BufferedImage bufferedImage) {
        this.img = bufferedImage;
    }

    @Override
    public String toString() {
        return "\nsimpleSphereAvecTexture(\n\t" + centre.toString() + "\n\t" + radius + " \n\t\"" + fichier + "\"\n)\n";
    }
}
