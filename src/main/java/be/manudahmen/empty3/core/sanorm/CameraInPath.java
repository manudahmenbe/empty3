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

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Matrix33;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.math.E3MathWaw;
import be.manudahmen.empty3.core.nurbs.ParametricCurve;

/**
 * @author Se7en
 */
public class CameraInPath extends Camera {
    ParametricCurve courbe;
    private double temps01;

    public CameraInPath(ParametricCurve maCourbe) {
        courbe = maCourbe;
    }

    public double getTemps01() {
        return temps01;
    }

    public void setTemps01(double temps01) {
        this.temps01 = temps01;
    }

    public ParametricCurve getCourbe() {
        return courbe;
    }

    public void setCourbe(ParametricCurve maCourbe) {
        this.courbe = maCourbe;
    }

    @Override
    public void calculerMatrice() {
        if (!imposerMatrice) {


            E3MathWaw e3 = new E3MathWaw();

            Point3D[] calculRepere = e3.calculRepere(courbe, temps01);


            eye = calculRepere[0];
            Point3D v1;

            lookat = v1 = calculRepere[1];
            Point3D v2;

            Point3D verticale = v2 = calculRepere[2];

            Point3D v3 = calculRepere[3];

            Matrix33 m = new Matrix33();

            for (int j = 0; j < 3; j++) {
                m.set(j, 2, v1.get(j));
            }
            for (int j = 0; j < 3; j++) {
                m.set(j, 0, v2.get(j));
            }
            for (int j = 0; j < 3; j++) {
                m.set(j, 1, v3.get(j));
            }
            this.matrice = m;
        }
    }

    public double getT() {
        return temps01;
    }

    public void setT(double t) {
        temps01 = t;
    }


}
