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
 * Global license : * GNU GPL v3
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * Creation time 2015-03-25
 * <p>
 * *
 */
package one.empty3.library.core.tribase;

import one.empty3.library.Point3D;
import one.empty3.library.core.nurbs.*;

public class Tubulaire3 extends ParametricSurface {
    public  double TAN_FCT_INCR = 0.000001;
    public double NORM_FCT_INCR = 0.000001;

    private CourbeParametriquePolynomialeBezier soulCurve;
    private FctXY diameterFunction;

    public Tubulaire3()
    {
        super();
        soulCurve = new CourbeParametriquePolynomialeBezier();
        diameterFunction = new FctXY();
    }

    public Tubulaire3(CourbeParametriquePolynomialeBezier soulCurve, FctXY diameterCurve) {
        this();
        this.soulCurve = soulCurve;
        this.diameterFunction = diameterCurve;
    }

    public Point3D calculerNormale(double t) {
        return calculerTangente(t + NORM_FCT_INCR).moins(calculerTangente(t));
    }

    public Point3D calculerTangente(double t) {
        return soulCurve.calculerPoint3D(t + TAN_FCT_INCR).moins(soulCurve.calculerPoint3D(t));
    }

    public void nbrAnneaux(int n) {
        setIncrU(1.0 / n);
    }

    public void nbrRotations(int r) {
        setIncrV(1.0/r);
    }

    @Override
    public String toString() {
        String s = "tubulaireN2cc (\n\t("
                + soulCurve.toString();
        s += "\n\n)\n\t" + diameterFunction.toString() + "\n\t" + texture().toString() + "\n)\n";
        return s;
    }


    private Point3D[] vectPerp(double t) {
        Point3D[] vecteurs = new Point3D[3];

        Point3D p = soulCurve.calculerPoint3D(t);
        Point3D tangente = calculerTangente(t);

        Point3D ref1 = new Point3D(0d, 0d, 1d);
        Point3D ref2 = new Point3D(1d, 0d, 0d);
        Point3D ref3 = new Point3D(0d, 1d, 0d);

        tangente = tangente.norme1();

        if (tangente != null) {
            Point3D px = calculerNormale(t);///tangente.prodVect(ref1);

            if (px.norme() == 0) {
                px = tangente.prodVect(ref2);
            }
            if (px.norme() == 0) {
                px = tangente.prodVect(ref3);
            }

            Point3D py = px.prodVect(tangente);

            px = px.norme1();
            py = py.norme1();

            vecteurs[0] = tangente;
            vecteurs[1] = px;
            vecteurs[2] = py;

        }
        return vecteurs;
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D[] vectPerp = vectPerp(u);
        return soulCurve.calculerPoint3D(u).plus(
                vectPerp[1].mult(diameterFunction.result(u)*Math.cos(2 * Math.PI * v)).plus(
                        vectPerp[2].mult(diameterFunction.result(u)*Math.sin(2 * Math.PI * v))));
    }

    @Override
    public Point3D calculerVitesse3D(double u, double v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredRepresentables().put("soulCurve/ame de la courbe", soulCurve);
        getDeclaredRepresentables().put("diameterFunction/ fonction de la longueur du diamètre", diameterFunction);

    }

    public CourbeParametriquePolynomialeBezier getSoulCurve() {
        return soulCurve;
    }

    public void setSoulCurve(CourbeParametriquePolynomialeBezier soulCurve) {
        this.soulCurve = soulCurve;
    }

    public FctXY getDiameterFunction() {
        return diameterFunction;
    }

    public void setDiameterFunction(FctXY diameterFunction) {
        this.diameterFunction = diameterFunction;
    }
}
