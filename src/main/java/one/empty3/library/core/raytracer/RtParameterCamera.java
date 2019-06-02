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

package one.empty3.library.core.raytracer;

import one.empty3.library.*;

/**
 * Created by manuel on 02-12-16.
 */
public class RtParameterCamera extends RtTargetCamera {
    public static final int ORIENTATION_HORIZONTALE = 1;
    public static final int ORIENTATION_VERTICALE = 2;
    private double angleH, angleV;
    private int orientation;

    public RtParameterCamera(Point3D camPos, Point3D lookAtPoint, Point3D upVector) {
        super(camPos, lookAtPoint, upVector);
    }

    public double getAngleH() {
        return angleH;
    }

    public void setAngleH(double angleH) {
        this.angleH = angleH;
    }

    public double getAngleV() {
        return angleV;
    }

    public void setAngleV(double angleV) {
        this.angleV = angleV;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
