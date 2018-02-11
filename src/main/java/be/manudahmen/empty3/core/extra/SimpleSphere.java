
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
package be.manudahmen.empty3.core.extra;

import be.manudahmen.empty3.*;

import java.awt.*;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         17 oct. 2011
 */
public class SimpleSphere extends Representable implements TRIGenerable {

    public static float DMIN = 0.5f;
    public static float DMAX = 1.5f;
    protected PObjet po;
    protected double radius;
    protected Point3D centre;
    protected Color color;
    protected int numLatQuad = 150;
    protected int numLongQuad = 150;
    Color map[][];
    double[][] zmap;
    Point3D[][] pmap;
    private String id;
    private double incrLat;
    private double incrLong;

    public SimpleSphere(Point3D c, double r, Color col) {
        this.radius = r;
        this.centre = c;
        this.color = col;
    }
    /*
     * (non-Javadoc)
     *
     * @see be.ibiiztera.md.pmatrix.pushmatrix.PGenerator#generatePO()
     */

    public Point3D CoordPoint(double a, double b) {
        return new Point3D(centre.getX() + Math.cos(a) * Math.cos(b) * radius,
                centre.getY() + Math.cos(a) * Math.sin(b) * radius,
                centre.getZ() + Math.sin(a) * radius);
    }

    @Override
    public TRIObject generate() {
        TRIObject t = new TRIObject();
        po = new PObjet();

        double a = -Math.PI / 2;
        double b;
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
                t.add(new TRI(pCur[0], pCur[1], pCur[3], color));
                t.add(new TRI(pCur[0], pCur[2], pCur[3], color));

                b += incrLong;
            }
            a += incrLat;
        }
        return t;
    }

    public int getNumLatQuad() {
        return numLatQuad;
    }

    public void setNumLatQuad(int numLatQuad) {
        this.numLatQuad = numLatQuad;
    }

    public int getNumLongQuad() {
        return numLongQuad;
    }

    public void setNumLongQuad(int numLongQuad) {
        this.numLongQuad = numLongQuad;
    }

    public Barycentre position() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void position(Barycentre p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean supporteTexture() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ColorTexture texture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "\nSimpleSphere(\n\t" + centre.toString() + "\n\t" + radius + " \n\t" + "(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")\n)\n";
    }

}
