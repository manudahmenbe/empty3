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
 * Creation time 17-sept.-2014
 * <p>
 * *
 */
package one.empty3.library.core.nurbs;

import one.empty3.library.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class SurfaceParametriquePolynomialeBezier extends ParametricSurface implements SurfaceElem{

    protected Point3D[][] coefficients;
    protected int power1, power2;

    public SurfaceParametriquePolynomialeBezier(Point3D[][] coefficients)
    {
        this();
        this.coefficients = coefficients;
        power1 = coefficients.length;
        power2 = coefficients[0].length;
    }
    public SurfaceParametriquePolynomialeBezier()
    {
        this.coefficients = new Point3D[][]
                {

                        {Point3D.P.n(2., -2d, 0d), Point3D.P.n(2, -1, 0), Point3D.P.n(2, 0, 0), Point3D.P.n(2, 1, 0), Point3D.P.n(2, 2, 0)},
                        {Point3D.P.n(1d, -2d, 0d), Point3D.P.n(1d, -1d, 0d), Point3D.P.n(1, 0, 0), Point3D.P.n(1, 1, 0), Point3D.P.n(1, 2, 0)},
                        {Point3D.P.n(0d, -2d, 0d), Point3D.P.n(0d, -1d, 0d), Point3D.P.n(0, 0, 0), Point3D.P.n(0, 1, 0), Point3D.P.n(0, 2, 0)},
                        {Point3D.P.n(-1d, -2d, 0d), Point3D.P.n(-1d, -1d, 0d), Point3D.P.n(-1, 0, 0), Point3D.P.n(-1, 1, 0), Point3D.P.n(-1, 2, 0)},
                        {Point3D.P.n(-2d, -2d, 0d), Point3D.P.n(-2d, -1d, 0d), Point3D.P.n(-2, 0, 0), Point3D.P.n(-2, 1, 0), Point3D.P.n(-2, 2, 0)}

                };
        power1 = coefficients.length;
        power2 = coefficients[0].length;
    }

    public double B(int i, int n, double t) {
        return factorielle(n) / factorielle(i) / factorielle(n - i)
                * Math.pow(t, i) * Math.pow(1 - t, n - i);
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D sum = Point3D.O0;
        for (int i = 0; i < power1; i++) {
            for (int j = 0; j < power2; j++) {
                sum = sum.plus(coefficients[i][j].mult(B(i, power1 - 1, u) * B(j, power2 - 1, v)));
            }
        }
        return sum;
    }

    @Override
    public Point3D calculerVitesse3D(double u, double v) {
        throw new UnsupportedOperationException("pas encore implanté");
    }

    protected double factorielle(int n) {
        double sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public Point3D[][] getCoefficients() {
        return coefficients;
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredArray2Points().put("coefficients/coefficients du polygone de Bezier", coefficients);
        getDeclaredInteger().put("power1/puissance par defaut #dim1", power1);
        getDeclaredInteger().put("power2/puissance par defaut #dim1", power2);

    }
}
