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

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.Point3D;

import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class NurbsCurve extends BSplineCurve {

    protected ArrayList<Entry<Point3D, Double>> pointspoids = new ArrayList<Entry<Point3D, Double>>();

    @Override
    public Point3D calculerPoint3D(double t) {
        Point3D S = Point3D.O0;
        double s = 0;
        int m = knots.size();
        int n = pointspoids.size();
        for (int i = 0; i < m - n - 1; i++) {
            S = S.plus(pointspoids.get(i).getKey().mult(b(i, n, t) * pointspoids.get(i).getValue()));
        }
        for (int i = 0; i < m - n - 1; i++) {
            s += b(i, n, t) * pointspoids.get(i).getValue();
        }
        if (s != 0) {
            S = S.mult(1 / s);
        }

        return S;
    }

    public ArrayList<Entry<Point3D, Double>> getPointsPoids() {
        return pointspoids;
    }

    @Override
    public String toString() {
        String rep = "nurbscourbe (\n\tknots\n\t(";
        for (int i = 0; i < knots.size(); i++) {
            rep += "\n\t\t" + knots.get(i);
        }
        rep += "\n\tpointspoids\n\t" + "\n\t(";
        for (int i = 0; i < pointspoids.size(); i++) {
            rep += "\n\t\t" + pointspoids.get(i).getKey() + " " + pointspoids.get(i).getValue();
        }
        rep += "\n\t)\n\t" + texture().toString() + "\n\n)";
        return rep;
    }

}
