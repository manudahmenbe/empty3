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
package one.empty3.library.core.nurbs;

import one.empty3.library.Point3D;
import one.empty3.library.StructureMatrix;

import java.util.List;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class CourbeParametriquePolynomialeBezier extends CourbeParametriquePolynomiale {

    public CourbeParametriquePolynomialeBezier()
    {

        super();
    }
    public CourbeParametriquePolynomialeBezier(Point3D[] coefficients) {
        this.coefficients = new StructureMatrix<>(coefficients);
        power.setElem(coefficients.length);
    }

    public double B(int i, int n, double t) {
        return factorielle(n) / factorielle(i) / factorielle(n - i)
                * Math.pow(t, i) * Math.pow(1 - t, n - i);
    }


    @Override
    public Point3D calculerPoint3D(double t) {
        Point3D sum = Point3D.O0;
        int N = coefficients.getData1d().size();
        for (int i = 0; i < coefficients.getData1d().size(); i++) {
            sum = sum.plus(coefficients.getElem(i).mult(B(i, N - 1, t)));
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

    public List<Point3D> getCoefficients() {
        return coefficients.getData1d();
    }


    public void declareProperties()
    {
        super.declareProperties();
    }

    @Override
    public String toString() {
        String s = "bezier(";
        for(int i=0; i<coefficients.getData1d().size(); i++)
            s+="\n"+coefficients.getElem(i).toString()+"\n";
        return s+")\n";
    }
}
