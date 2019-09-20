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

import one.empty3.library.Point3D;
import one.empty3.library.StructureMatrix;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class SurfaceParametriquePolynomialeBezier extends ParametricSurface implements SurfaceElem{

    protected StructureMatrix<Point3D> coefficients = new StructureMatrix<>(2, Point3D.class);;
    protected StructureMatrix<Integer> power1 =new StructureMatrix<>(0, Integer.class);
    protected StructureMatrix<Integer> power2=new StructureMatrix<>(0, Integer.class);;


    public SurfaceParametriquePolynomialeBezier(Point3D[][] coefficients)
    {
        this();
        this.coefficients.setAll(coefficients);
        power1.setElem(coefficients.length);
        power2.setElem(coefficients[0].length);
    }
    public SurfaceParametriquePolynomialeBezier()
    {
        this.coefficients = new StructureMatrix<>(2, Point3D.class);
        this.coefficients.setAll(
        new Point3D[][]
                {

                        {Point3D.P.n(2., -2d, 0d), Point3D.P.n(2, -1, 0), Point3D.P.n(2, 0, 0), Point3D.P.n(2, 1, 0), Point3D.P.n(2, 2, 0)},
                        {Point3D.P.n(1d, -2d, 0d), Point3D.P.n(1d, -1d, 0d), Point3D.P.n(1, 0, 0), Point3D.P.n(1, 1, 0), Point3D.P.n(1, 2, 0)},
                        {Point3D.P.n(0d, -2d, 0d), Point3D.P.n(0d, -1d, 0d), Point3D.P.n(0, 0, 0), Point3D.P.n(0, 1, 0), Point3D.P.n(0, 2, 0)},
                        {Point3D.P.n(-1d, -2d, 0d), Point3D.P.n(-1d, -1d, 0d), Point3D.P.n(-1, 0, 0), Point3D.P.n(-1, 1, 0), Point3D.P.n(-1, 2, 0)},
                        {Point3D.P.n(-2d, -2d, 0d), Point3D.P.n(-2d, -1d, 0d), Point3D.P.n(-2, 0, 0), Point3D.P.n(-2, 1, 0), Point3D.P.n(-2, 2, 0)}

                });
        power1.setElem(coefficients.getData2d().size());
        power2.setElem(coefficients.getData2d().get(0).size());
    }

    public double B(int i, int n, double t) {
        return factorielle(n) / factorielle(i) / factorielle(n - i)
                * Math.pow(t, i) * Math.pow(1 - t, n - i);
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D sum = Point3D.O0;
        for (int i = 0; i < power1.getElem(); i++) {
            for (int j = 0; j < power2.getElem(); j++) {
                sum = sum.plus(coefficients.getElem(i,j).mult(B(i, power1.getElem() - 1, u) * B(j, power2.getElem() - 1, v)));
            }
        }
        return sum;
    }


    protected double factorielle(int n) {
        double sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public StructureMatrix<Point3D> getCoefficients() {
        return coefficients;
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("coefficients/points de contrôle", coefficients);
        getDeclaredDataStructure().put("power1/puissance par defaut #dim1", power1);
        getDeclaredDataStructure().put("power2/puissance par defaut #dim2", power2);

    }

    public void setCoefficients(StructureMatrix<Point3D> coefficients) {
        this.coefficients = coefficients;
    }

    public Integer getPower1() {
        return power1.getElem();
    }

    public void setPower1(Integer power1) {
        this.power1 = new StructureMatrix<>(power1, Integer.class);
    }

    public Integer getPower2() {
        return power2.getElem();
    }

    public void setPower2(Integer power2) {
        this.power2 = new StructureMatrix<>(power2, Integer.class);
    }

    @Override
    public String toString() {
        String s = "bezier2(";

        for(int i=0; i<coefficients.getData2d().size(); i++) {
            s+="\n(\n";
            for (int j = 0; j < coefficients.getData2d().get(i).size(); j++) {
                s += coefficients.getElem(i,j).toString();
            }
            s+="\n)\n";
        }
        s+=")";
        return s;
    }
}
