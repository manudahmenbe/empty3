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

/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.core.tribase;

import be.manudahmen.empty3.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Manuel DAHMEN
 */
public class ApproximationFonction1D implements Courbe {

    public static final int TYPE_DROITE = 0;
    public static final int TYPE_BEZIER = 1;
    private final ArrayList<Point3D> points;
    public double DELTA = 0.0001;
    private ArrayList<Double> longueurs;
    private Double slongueurs;
    private int type_last;
    private ArrayList<Representable> objets;
    private HashMap<Double, Representable> r;

    public ApproximationFonction1D() {
        points = new ArrayList<Point3D>();
        objets = new ArrayList<Representable>();
        longueurs = new ArrayList<Double>();
        r = new HashMap<Double, Representable>();
    }

    public void add(int type, double x, double y) {
        points.add(new Point3D(x, y, 0));
        if (type == TYPE_DROITE) {
            if (points.size() == 2) {
                LineSegment sd = new LineSegment(points.get(0), points.get(1));
                objets.add(sd);
                r.put(points.get(0).get(0), sd);
                points.clear();
            }
        } else if (type == TYPE_BEZIER) {
            if (points.size() == 4) {
                BezierCubique bc = new BezierCubique();
                objets.add(bc);
                r.put(points.get(0).get(0), bc);
                bc.add(points.get(0));
                bc.add(points.get(1));
                bc.add(points.get(2));
                bc.add(points.get(3));
                points.clear();
            }
        }
    }

    public Point3D calculerPoint3D(double t) {
        double t2 = 0;
        int i = 0;
        while (i < longueurs.size() && t2 + longueurs.get(i) / slongueurs < t) {
            t2 += longueurs.get(i++) / slongueurs;
        }
        Representable r2 = objets.get(i);
        if (r2 instanceof BezierCubique) {
            return ((BezierCubique) r2).calculerPoint3D((t - t2) * longueurs.get(i));
        } else if (r2 instanceof LineSegment) {
            return ((LineSegment) r2).calculerPoint3D((t - t2) * longueurs.get(i));
        }
        return null;
    }

    public ArrayList<Representable> getObjets() {
        return objets;
    }

    public void rectification() {
        slongueurs = 0.0;
        Iterator<Representable> it = objets.iterator();
        while (it.hasNext()) {
            Representable r = it.next();
            if (r instanceof LineSegment) {
                LineSegment sd = (LineSegment) r;
                double d = Point3D.distance(sd.getExtremite(), sd.getOrigine());
                slongueurs += d;
                longueurs.add(d);
            } else if (r instanceof BezierCubique) {
                BezierCubique bc = (BezierCubique) r;
                double d = 0;
                for (double t = 0; t < 1.0 - DELTA; t += DELTA) {
                    d += Point3D.distance(bc.calculerPoint3D(t), bc.calculerPoint3D(t + DELTA));
                }
                slongueurs += d;
                longueurs.add(d);
            }

        }
    }
}
