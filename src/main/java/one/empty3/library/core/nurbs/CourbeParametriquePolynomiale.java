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
public class CourbeParametriquePolynomiale extends ParametricCurve {

    protected StructureMatrix<Point3D> coefficients;
    protected StructureMatrix<Integer> power = new StructureMatrix<>(0, Integer.class);

    public CourbeParametriquePolynomiale(Point3D[] coefficients) {
        super();
        this.coefficients = new StructureMatrix<Point3D>(1, Point3D.class);
        this.coefficients.setAll(coefficients);
        this.power.setElem(coefficients.length);
    }

    public CourbeParametriquePolynomiale() {
        super();
        coefficients =  new StructureMatrix<>(1, Point3D.class);
        coefficients.setElem(new Point3D(0d,0d,0d), 0);
        coefficients.setElem(new Point3D(10.0,0.0,0.0), 1);
        power.setElem( 2);
    }
    public void declareProperties() {
        super.declareProperties();
        power.setElem(coefficients.getData1d().size());
        getDeclaredDataStructure().put(("coefficients/points de contrôle"), coefficients);
        getDeclaredDataStructure().put(("power/puissance du polynone"), power);
    }

    @Override
    public Point3D calculerPoint3D(double t) {
        Point3D sum = Point3D.O0;
        for (int i = 0; i < coefficients.getData1d().size(); i++) {
            sum = sum.plus(coefficients.getElem(i).mult(Math.pow(t, i)));
        }
        return sum;
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        Point3D sum = Point3D.O0;
        for (int i = 0; i < coefficients.getData1d().size() - 1; i++) {
            sum = sum.plus(coefficients.getElem(i).mult(Math.pow(t, i - 1) * i));
        }
        return sum;
    }

    public StructureMatrix<Point3D> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(StructureMatrix<Point3D> coefficients) {
        this.coefficients = coefficients;
    }

    public Integer getPower() {
        return power.getElem();
    }
    public void setPower(Integer pow) {
        power.setElem(pow);
    }
}
