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
package one.empty3.library;

import java.util.ArrayList;
import java.util.Iterator;

public class PObjet extends Representable {

    protected ArrayList<Point3D> points;
    private Barycentre position;

    public PObjet() {
        points = new ArrayList<Point3D>();
    }

    public void add(int arg0, Point3D arg1) {
        points.add(arg0, position == null ? arg1 : position.calculer(arg1));
    }

    public Point3D get(int arg0) {
        return calculerPoint(points.get(arg0));
    }


    public void add(Point3D arg0) {
        points.add(position == null ? arg0 : position.calculer(arg0));
    }

    public ArrayList<Point3D> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point3D> points) {
        this.points = points;
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public Iterable<Point3D> iterable() {
        return points;
    }

    @Deprecated
    public Iterator<Point3D> iterator() {
        return points.iterator();
    }

    public Point3D remove(int arg0) {
        return points.remove(arg0);
    }

    public boolean remove(Object arg0) {
        return points.remove(arg0);
    }

    public int size() {
        return points.size();
    }


    public String toString() {
        String s = "tri \n(\n\n";
        Iterator<Point3D> tris = iterator();
        while (tris.hasNext()) {
            s += "\n" + tris.next().toString() + "\n";
        }
        return s + "\n)\n";
    }
}
