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

package be.manudahmen.empty3.core.suvoxel;

import be.manudahmen.empty3.Point2D;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Representable;
import be.manudahmen.empty3.ZBuffer;

import java.util.Set;

/**
 * Created by manuel on 07-01-17.
 */
public class Voxel implements Xel {

    @Override
    public Point2D reduce(ZBuffer z, int nPixels) {
        return null;
    }

    @Override
    public Set<Point2D> reduceToSurface2d(ZBuffer z, Representable t) {
        return null;
    }

    @Override
    public ZCell zcell(ZBuffer z, Point3D p) {
        return null;
    }

    @Override
    public Set<Cell> cells() {
        return null;
    }

    @Override
    public Set<ZCell> zCells() {
        return null;
    }
}
