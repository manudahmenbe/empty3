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

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class NurbsCurve extends ParametricCurve {
    ArrayList<Double> knots = new ArrayList<>();
    protected ArrayList<Entry<Point3D, Double>> pointsAndWeights = new ArrayList<Entry<Point3D, Double>>();


    @Override
    public Point3D calculerPoint3D(double t) {
        Point3D S = Point3D.O0;
        double s = 0;
        int m = knots.size();
        int n = pointsAndWeights.size();
        for (int i = 0; i < m - n - 1; i++) {
            S = S.plus(pointsAndWeights.get(i).getKey().mult(b(i, n, t) * pointsAndWeights.get(i).getValue()));
        }
        for (int i = 0; i < m - n - 1; i++) {
            s += b(i, n, t) * pointsAndWeights.get(i).getValue();
        }
        if (s != 0) {
            S = S.mult(1 / s);
        }
        return S;
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        return null;

    }


    protected double fOOO(double a, double b) {
        if (Double.isInfinite(a/b) || Double.isNaN(a/b)) {
            return 1;
        } else {
            return a / b;
        }
    }

    protected double b(int i, int n, double t) {
        if (n == 0) {
            return (t < knots.get(0) ? knots.get(0) : (t <= knots.get(knots.size() - 1)) ? 1 :
                    knots.get(knots.size() - 1));
        } else {
            return fOOO(t - knots.get(i), knots.get(i + n) - knots.get(i))
                    * b(i, n - 1, t)
                    + fOOO(knots.get(i + n) - t, knots.get(i + n) - knots.get(i))
                    * b(i + 1, n - 1, t);

        }

    }
    public ArrayList<Entry<Point3D, Double>> getPointsAndWeights() {
        return pointsAndWeights;
    }

    @Override
    public String toString() {
        String rep = "nurbscourbe (\n\tknots\n\t(";
        for (int i = 0; i < knots.size(); i++) {
            rep += "\n\t\t" + knots.get(i);
        }
        rep += "\n\tpointsAndWeights\n\t" + "\n\t(";
        for (int i = 0; i < pointsAndWeights.size(); i++) {
            rep += "\n\t\t" + pointsAndWeights.get(i).getKey() + " " + pointsAndWeights.get(i).getValue();
        }
        rep += "\n\t)\n\t" + texture().toString() + "\n\n)";
        return rep;
    }

    public void add(double v, Point3D point) {
        pointsAndWeights.add(new AbstractMap.SimpleImmutableEntry<Point3D, Double>(point, v));
    }

    public void setKnots(double [] knots) {
        for(int i=0; i<knots.length; i++)
            this.knots.add(knots[i]);
    }
}

