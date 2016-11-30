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
package be.manudahmen.emptycanvas.library.empty3.library.nurbs;

import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class CourbeParametriquePolynomialeBezier extends CourbeParametriquePolynomiale {

    public CourbeParametriquePolynomialeBezier(Point3D[] coefficients) {
        super(coefficients);
    }

    public double B(int i, int n, double t) {
        return factorielle(n) / factorielle(i) / factorielle(n - i)
                * Math.pow(t, i) * Math.pow(1 - t, n - i);
    }

    @Override
    public Point3D calculerPoint3D(double t) {
        Point3D sum = Point3D.O0;
        int N = coefficients.length;
        for (int i = 0; i < coefficients.length; i++) {
            sum = sum.plus(coefficients[i].mult(B(i, N - 1, t)));
        }
        return sum;
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        throw new UnsupportedOperationException("pas encore implanté");
    }

    protected double factorielle(int n) {
        double sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

}
