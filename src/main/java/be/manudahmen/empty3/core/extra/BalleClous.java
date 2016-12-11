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
 * 2013 Manuel Dahmen
 */
package be.manudahmen.empty3.core.extra;

import be.manudahmen.empty3.Point2D;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.util.ArrayList;

/**
 * @author Se7en
 */
public class BalleClous extends TRISphere {

    private ArrayList<Point2D> points = new ArrayList<Point2D>();
    private double d;

    public BalleClous(Point3D c, double r) {
        super(c, r);
    }

    public void addPoint(Point2D p) {
        this.points.add(p);
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        Point3D p = super.coordPoint3D(x, y);

        Point2D p0 = new Point2D(1.0 * x / getMaxX(), 1.0 * y / getMaxY());

        double mult = 1.0;

        for (int i = 0; i < points.size(); i++) {

            mult += 1 / (d + dmindist(p0, points.get(i)));

        }

        return p.mult(mult / points.size());

    }

    public double dmindist(Point2D p0, Point2D p1) {

        double[] x = new double[]{-1, 0, 1, -1, 0, 1, -1, 0, 1};
        double[] y = new double[]{-1, -1, -1, 0, 0, 0, 1, 1, 1};
        double min = 100;
        for (int i = 0; i < 9; i++) {
            double cur;
            cur = Point2D.dist(p0, Point2D.plus(p1, new Point2D(x[i], y[i])));
            if (cur < min && cur > 0) {
                min = cur;
            }
        }
        return min;
    }

    public double param() {
        return d;
    }

    public void param(double d) {
        this.d = d;
    }

    public ArrayList<Point2D> points() {
        return points;
    }

}
