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

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.core.move;

import be.manudahmen.empty3.Point3D;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public abstract class SimpleTrajectory implements Trajectory {

    public long nanoTime;
    private ArrayList<Point3D> liste = new ArrayList<Point3D>();

    public boolean hasMorePoints() {
        return !liste.isEmpty();
    }

    public Point3D getNextPointAndRemove() {
        Point3D p = liste.get(0);
        liste.remove(p);
        return p;
    }

    public Point3D[] getIntermediatePointsUntilNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addPoints(Collection<Point3D> points) {
        liste.addAll(points);
    }

    public void addPoints(Point3D[] points) {
        for (int i = 0; i < points.length; i++) {
            liste.add(points[i]);
        }
    }

    public abstract Point3D calculerPoint3D(double timeEllapsedNano);
}
