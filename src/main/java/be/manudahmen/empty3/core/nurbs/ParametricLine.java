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

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.SegmentDroite;

/**
 * Created by manuel on 29-06-17.
 */
public class ParametricLine extends ParametricCurve {
    private final SegmentDroite segmentDroite;

    public ParametricLine(SegmentDroite sd) {
        this.segmentDroite = sd;
    }

    @Override
    public Point3D calculerPoint3D(double t) {
        return segmentDroite.getOrigine().plus(segmentDroite.getExtremite().moins(segmentDroite.getOrigine().mult(t)));
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        return segmentDroite.getOrigine().plus(segmentDroite.getExtremite().moins(segmentDroite.getOrigine())).norme1();
    }
}
