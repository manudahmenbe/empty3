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

package one.empty3.library.core.nurbs;

import one.empty3.library.*;


/**
 * Created by manuel on 29-06-17.
 */
public class ParametricLine extends ParametricCurve implements CurveElem{
    private final LineSegment lineSegment;

    public ParametricLine(LineSegment sd) {
        this.lineSegment = sd;
    }

    @Override
    public Point3D calculerPoint3D(double t) {
        return lineSegment.getOrigine().plus(lineSegment.getExtremite().moins(lineSegment.getOrigine().mult(t)));
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        return lineSegment.getOrigine().plus(lineSegment.getExtremite().moins(lineSegment.getOrigine())).norme1();
    }
}
