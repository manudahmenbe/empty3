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

package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Matrix33;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.math.E3MathWaw;
import be.manudahmen.empty3.core.nurbs.ParametricCurve;

/**
 * @author Manuel Dahmen
 */
public class CameraInPath extends Camera {
    private ParametricCurve courbe;
    private double t;

    public CameraInPath(ParametricCurve maCourbe) {
        courbe = maCourbe;
    }


    public ParametricCurve getCourbe() {
        return courbe;
    }

    public void setCourbe(ParametricCurve maCourbe) {
        this.courbe = maCourbe;
    }

    public void calculerMatrice(Point3D verticale) {
        setEye(courbe.calculerPoint3D(t));
        setLookat(courbe.calculerPoint3D(t * 1.001));
        super.calculerMatrice(getEye().moins(getLookat()).prodVect(getEye().moins(courbe.calculerPoint3D(t*0.009))).norme1());
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }


}
