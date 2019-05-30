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
import be.manudahmen.empty3.core.MoveeObject;
import be.manudahmen.empty3.core.nurbs.ParametricCurve;

/**
 * Created by manuel on 29-06-17.
 */
public abstract class TrajectoryMoveeObject extends SimpleTrajectory implements MoveeObject {
    private final ParametricCurve parametricCurve;
    private Point3D origin;
    private double timeScale;

    public TrajectoryMoveeObject(ParametricCurve parametricCurve) {
        this.parametricCurve = parametricCurve;
        this.origin = parametricCurve.calculerPoint3D(0.0);
    }

    @Override
    public void setPositionAtTime(Point3D position, long nanoTime) {
        this.nanoTime = nanoTime;
    }

    public void setTimeScale(double timeScale) {
        this.timeScale = timeScale;
    }

    @Override
    public Point3D getCurrentPosition() {
        return calculerPoint3D(System.nanoTime() - nanoTime);
    }

    @Override
    public Point3D calculerPoint3D(double timeEllapsedNano) {
        return parametricCurve.calculerPoint3D(timeScale * timeEllapsedNano);
    }

}
