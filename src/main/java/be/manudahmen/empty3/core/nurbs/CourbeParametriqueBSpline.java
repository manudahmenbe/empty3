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

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * Creation time 19-sept.-2014
 * BAD UGLY COMME TA MERE
 * *
 */
package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.Point3D;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class CourbeParametriqueBSpline extends ParametrizedCurve {

    private final Point3D[] points;
    private final int p;
    protected double[] intervalles;

    public CourbeParametriqueBSpline(double[] u, Point3D[] P, int pDegree) {
        this.intervalles = u;
        this.points = P;
        this.p = pDegree;
    }

    @Override
    public Point3D calculerPoint3D(double t) {
        Point3D sum = Point3D.O0;
        for (int i = 0; i < points.length; i++) {
            sum = sum.plus(points[i].mult(N(i, p, t)));
        }
        return sum;
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double N(int i, int degree, double t) {
        if (degree == 0) {

            if (t >= intervalles[0] && t <= intervalles[intervalles.length - 1]
                    && t > intervalles[i] && t < intervalles[i + 1]) {
                return 1;
            } else {
                return 0;
            }
        } else if (i >= 0 && i + degree + 1 < intervalles.length) {
            return (t - intervalles[i]) / (intervalles[i + degree] - intervalles[i])
                    * N(i, degree - 1, t)
                    + (intervalles[i + degree + 1] - t) / (intervalles[i + degree + 1] - intervalles[i + 1])
                    * N(i + 1, degree - 1, t);
        } else if (i < 0)
            return 0;
        else if (i + degree + 1 >= intervalles.length)
            return 1;
        else
            return 0;
    }

}
