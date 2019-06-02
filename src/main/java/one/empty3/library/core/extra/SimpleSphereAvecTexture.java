/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

/*

 Vous êtes libre de :

 */
package one.empty3.library.core.extra;

import one.empty3.library.*;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         27 oct. 2011
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
