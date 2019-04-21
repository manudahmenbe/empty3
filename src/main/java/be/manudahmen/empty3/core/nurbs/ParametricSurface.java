/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.Polygon;
import be.manudahmen.empty3.core.tribase.TRIObjetGenerateurAbstract;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public abstract class ParametricSurface extends TRIObjetGenerateurAbstract {
    public class Globals
    {
        private double incrU;
        private double incrV;

        public double getIncrU() {
            return incrU;
        }

        public void setIncrU(double incrU) {
            this.incrU = incrU;
        }

        public double getIncrV() {
            return incrV;
        }

        public void setIncrV(double incrV) {
            this.incrV = incrV;
        }
    }
    private static Globals globals;
    {
        if(globals==null)

        {
            ParametricSurface.setGlobals(new Globals());
        }
    }
    public double incr1 = 0.01;
    public double incr2 = 0.01;
    public double incrVitesse = 0.0001;
    public double incrNormale = 0.000001;
    protected double start1 = 0, start2 = 0;
    protected double end1 = 1, end2 = 1;
    protected double NFAST = 100;
    protected ITexture CFAST = new TextureCol(Color.GRAY);

    public abstract Point3D calculerPoint3D(double u, double v);

    public Point3D calculerVitesse3D(double u, double v) {
        Point3D moins = calculerPoint3D(u + incrVitesse, v).moins(calculerPoint3D(u, v));
        Point3D moins1 = calculerPoint3D(u, v + incrVitesse).moins(calculerPoint3D(u, v));
        return moins.plus(moins1).mult(0.5 / incrVitesse / incrVitesse).norme1();
    }

    public Point3D calculerNormale3D(double u, double v) {
        Point3D moins = calculerPoint3D(u + incrNormale, v).plus(calculerPoint3D(u, v));
        Point3D moins1 = calculerPoint3D(u, v + incrNormale).plus(calculerPoint3D(u, v));
        return moins.prodVect(moins1).mult(0.5 / incrNormale / incrNormale).norme1();
    }
    public Point3D calculerTangenteU(double u, double v) {
        Point3D moins = calculerPoint3D(u + incrVitesse, v).moins(calculerPoint3D(u, v));
        return moins.mult(1.0 / incrVitesse / incrVitesse).norme1();
    }
    public Point3D calculerTangenteV(double u, double v) {
        Point3D moins1 = calculerPoint3D(u, v + incrVitesse).moins(calculerPoint3D(u, v));
        return moins1.mult(1.0 / incrVitesse).norme1();
    }


    public double incr1() {
        return incr1;
    }

    public double incr2() {
        return incr1;
    }

    public double getStartU() {
        return start1;
    }

    public void setStartU(double s1) {
        this.start1 = s1;
    }

    public double getStartV() {
        return start2;
    }

    public void setStartV(double s2) {
        this.start2 = s2;
    }

    public double getEndU() {
        return end1;
    }

    public void setEndU(double e1) {
        this.end1 = e1;
    }

    public double getEndV() {
        return end2;
    }

    public void setEndV(double e2) {
        this.end2 = e2;
    }

    public Point3D velocity(double u1, double v1, double u2, double v2) {
        return calculerPoint3D(u2, v2).moins(calculerPoint3D(u1, v1));
    }

    public Point3D coordPoint3D(int x, int y) {
        return calculerPoint3D(1.0 * x / getMaxX(), 1.0 * y / getMaxY());
    }

    public double getIncrU() {
        return incr1;
    }

    public void setIncrU(double incr1) {
        this.incr1 = incr1;
    }

    public double getIncrV() {
        return incr2;
    }

    public void setIncrV(double incr2) {
        this.incr2 = incr2;
    }

    @Override
    public void drawStructureDrawFast(ZBuffer z) {
        System.out.println("Drawn structure ffaast START");
        double incrU = 1.0 / NFAST;
        double incrV = 1.0 / NFAST;
        for (double u = 0; u < 1.0; u += incrU) {
            for (double v = 0; v < 1.0; v += incrV) {
                double[][] uvincr = new double[][]{
                        {u, v},
                        {u + incrU, v},
                        {u + incrU, v + incrV},
                        {u, v + incrV}
                };
                for (int i = 0; i < 3; i++) {

                    SegmentDroite sd = new SegmentDroite(
                            calculerPoint3D(uvincr[i][0], uvincr[i][1]),
                            calculerPoint3D(uvincr[(i + 1) % 3][0], uvincr[(i + 1) % 3][0]), CFAST);
                    if (sd.ISdrawStructureDrawFastIMPLEMENTED(z)) {
                        sd.drawStructureDrawFast(z);
                    }
                }
            }
        }
        System.out.println("Drawn structure ffaast END");
    }

    public Polygon getElementSurface(double u, double incrU, double v, double incrV) {
        double[][] uvincr = new double[][]{
                {u, v},
                {u + incrU, v},
                {u + incrU, v + incrV},
                {u, v + incrV}
        };
        Polygon polygon = new Polygon(new Point3D[]{
                calculerPoint3D(uvincr[0][0], uvincr[0][1]),
                calculerPoint3D(uvincr[1][0], uvincr[1][1]),
                calculerPoint3D(uvincr[2][0], uvincr[2][1]),
                calculerPoint3D(uvincr[3][0], uvincr[3][1])},
                texture());
        return polygon;
    }

    public static Globals getGlobals() {
        return globals;
    }

    public static void setGlobals(Globals globals) {
        ParametricSurface.globals = globals;
    }
}
