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

/**
 * @author Manuel Dahmen
 */
public class CameraInPath extends Camera {
    private double angleA = 0;
    private double angleB = 0;

    /**
     * Need to get a position of the camera since it's a Z-axis
     * Rotate, position angles around the camera.
     */
    public void rotateSphere(double angleARad, double angleBRad) {
        this.angleA = angleARad;
        this.angleB = angleBRad;
    }

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
        setLookat(courbe.calculerPoint3D(t + t * 1.001));
        Point3D dt1 = getLookat().moins(getEye()).norme1();
        Point3D dt2 = getEye().moins(courbe.calculerPoint3D(t - t * 0.001)).norme1();
        Point3D n = dt2.moins(dt1).norme1();
        super.calculerMatrice(verticale == null ? n : verticale);
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        eye = courbe.calculerPoint3D(t);
    }

    @Override
    public Point3D calculerPointDansRepere(Point3D p) {
        return Matrix33.rot(angleA, angleB).mult(super.calculerPointDansRepere(p));
    }
}
