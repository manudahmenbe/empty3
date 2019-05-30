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

package be.manudahmen.empty3.core.move;

import be.manudahmen.empty3.LineSegment;
import be.manudahmen.empty3.Point3D;

/**
 * Created by manuel on 29-06-17.
 */
public class LineTrajectory extends SimpleTrajectory {
    protected Point3D a;
    private Point3D b;
    private double speed = 0.0;

    LineTrajectory(LineSegment sd, double speed) {
        a = sd.getOrigine();
        b = sd.getExtremite();
        this.speed = speed;
    }

    public void swapAB() {
        Point3D w = a;
        a = b;
        b = w;
    }

    public Point3D calculerPoint3D(double timeEllapsedNano) {
        Point3D point3D = a.plus(b.moins(a).mult(speed * timeEllapsedNano));
        return point3D;

    }
}
