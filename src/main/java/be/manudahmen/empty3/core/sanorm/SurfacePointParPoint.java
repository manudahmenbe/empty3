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

package be.manudahmen.empty3.core.sanorm;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.tribase.TRIObjetGenerateurAbstract;

import java.awt.*;

/**
 * @author Manuel Dahmen
 */

/**
 * @author Manuel Dahmen
 */
public class SurfacePointParPoint extends TRIObjetGenerateurAbstract {

    private Point3D[][] points;

    public SurfacePointParPoint(Point3D[][] points, Color[][] couleurs) {
        if (checkDimensions()) {
            this.points = points;

            setMaxX(points.length);
            setMaxY(points[0].length);
        }

    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        if (y < points.length && x < points[y].length && x >= 0 && y >= 0) {
            return points[y][x];
        }
        throw new ArrayIndexOutOfBoundsException("Coordonnée pas normale");
    }

    private boolean checkDimensions() {

        return true;
        // Hmmm.
    }
}
