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
 * Creation time 17-sept.-2014
 * <p>
 * *
 */
package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.Point3D;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class SurfaceParametriquePolynomialeBSpline extends ParametrizedSurface {

    private final Point3D[][] P;
    private final int uDegree, vDegree;
    private final double[][] intervalles;
    protected double[] U, V;

    public SurfaceParametriquePolynomialeBSpline(double[] U, double[] V, Point3D[][] P, int uDegree, int vDegree) {
        this.U = U;
        this.V = V;
        this.intervalles = new double[2][];
        intervalles[0] = U;
        intervalles[1] = U;
        this.P = P;
        this.uDegree = uDegree;
        this.vDegree = vDegree;
    }

    public Point3D calculerPoint3D(double t) {
        Point3D sum = Point3D.O0;
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < P[0].length; j++) {
                sum = sum.plus(P[i][j].mult(N(i, uDegree, t, 0) * N(j, vDegree, t, 1)));
            }
        }
        return sum;
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point3D calculerVitesse3D(double u, double v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double N(int i, int degree, double t, int dim01) {
        if (degree == 0) {

            if (t >= intervalles[dim01][0] && t <= intervalles[dim01][intervalles.length - 1]
                    && t >= intervalles[dim01][i] && t < intervalles[dim01][i + 1]) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return (t - intervalles[dim01][i]) / (intervalles[dim01][i + degree] - intervalles[dim01][i])
                    * N(i, degree - 1, t, dim01)
                    + (intervalles[dim01][i + degree + 1] - t) / (intervalles[dim01][i + degree + 1] - intervalles[dim01][i + 1])
                    * N(i + 1, degree - 1, t, dim01);
        }
    }

}
