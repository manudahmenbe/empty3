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
package be.manudahmen.empty3.core.sanorm;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.math.E3MathWaw;
import be.manudahmen.empty3.core.nurbs.ParametricCurve;
import be.manudahmen.empty3.core.tribase.TRIObjetGenerateurAbstract;

/**
 * @author Dahmen Manuel ::
 *         2. Extrusion 3D.
 */
public class Sanorm extends TRIObjetGenerateurAbstract {
    ParametricCurve curveBase;
    ParametricCurve curveRepeat;
    double intervalleApproxTgt = 0.00001;

    public Sanorm(ParametricCurve curveBase, ParametricCurve curveRepeat) {
        this.curveBase = curveBase;
        this.curveRepeat = curveRepeat;
    }


    public Sanorm() {
    }

    public static void main(String[] args) {

    }

    public Point3D dansRepereDeCourbe(double t, Point3D p) {
        E3MathWaw w = new E3MathWaw();

        Point3D[] pts = w.calculRepere(curveBase, t);

        E3MathWaw.Repere r = w.new Repere(pts);

        return r.transform(p);
    }

    public ParametricCurve getCurveBase() {
        return curveBase;
    }

    public void setCurveBase(ParametricCurve curveBase) {
        this.curveBase = curveBase;
    }

    public ParametricCurve getCurveRepeat() {
        return curveRepeat;
    }

    public void setCurveRepeat(ParametricCurve curveRepeat) {
        this.curveRepeat = curveRepeat;
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        double u = 1.0 * x / getMaxX();
        double v = 1.0 * y / getMaxY();

        return dansRepereDeCourbe(u, curveRepeat.calculerPoint3D(v));
    }

}
