/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.library.nurbs;

import be.manudahmen.empty3.library.object.*;
import be.manudahmen.empty3.library.tribase.TRIObjetGenerateurAbstract;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public abstract class ParametrizedSurface extends TRIObjetGenerateurAbstract {

    public double incr1 = 0.01;
    public double incr2 = 0.01;
    protected double start1 = 0, start2 = 0;
    protected double end1 = 1, end2 = 1;
    protected double NFAST = 100;
    protected ITexture CFAST = new ColorTexture(Color.GRAY);

    public abstract Point3D calculerPoint3D(double u, double v);

    public abstract Point3D calculerVitesse3D(double u, double v);

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
}
