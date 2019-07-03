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
public class CourbeParametriquePolynomiale extends ParametricCurve {

    protected Point3D[] coefficients;
    protected int power;

    public CourbeParametriquePolynomiale(Point3D[] coefficients) {
        this.coefficients = coefficients;
        this.power = coefficients.length;
        getDeclaredArray1Points().put(("coefficients"), coefficients);
        getDeclaredDoubles().put(("power"), (double)power);
    }

    @Override
    public Point3D calculerPoint3D(double t) {
        Point3D sum = Point3D.O0;
        for (int i = 0; i < coefficients.length; i++) {
            sum = sum.plus(coefficients[i].mult(Math.pow(t, i)));
        }
        return sum;
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        Point3D sum = Point3D.O0;
        for (int i = 0; i < coefficients.length - 1; i++) {
            sum = sum.plus(coefficients[i].mult(Math.pow(t, i - 1) * i));
        }
        return sum;
    }

    public Point3D[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(Point3D[] coefficients) {
        this.coefficients = coefficients;
    }

    public int getPower() {
        return power;
    }
}
