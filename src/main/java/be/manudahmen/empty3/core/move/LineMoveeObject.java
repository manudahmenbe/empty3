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

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.SegmentDroite;
import be.manudahmen.empty3.core.MoveeObject;

/**
 * Created by manuel on 29-06-17.
 */
public class LineMoveeObject extends LineTrajectory implements MoveeObject {
    LineMoveeObject(SegmentDroite sd, double speed) {
        super(sd, speed);
        this.setPositionAtTime(a, System.nanoTime());
    }

    @Override
    public void setPositionAtTime(Point3D position, long nanoTime) {
        a = position;
        this.nanoTime = nanoTime;
    }

    @Override
    public Point3D getCurrentPosition() {
        return calculerPoint3D(System.nanoTime() - this.nanoTime);
    }
}
