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

/*
 * 2013 Manuel Dahmen
 */
package be.manudahmen.empty3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Manuel
 */
public class Polygon extends Representable implements TRIGenerable, IMovable, IScalable {

    /**
     *
     */
    private static final long serialVersionUID = -852637190575721116L;
    private ArrayList<Point3D> points = new ArrayList<Point3D>();

    public Polygon() {
    }

    public Polygon(Color c) {
        texture(new ColorTexture(c));
    }

    public Polygon(ITexture c) {
        texture(c);
    }

    public Polygon(Point3D[] list, Color c) {
        this(list, new ColorTexture(c));
    }

    public Polygon(Point3D[] list, ITexture c) {
        this.texture = c;
        points.addAll(Arrays.asList(list));
    }

    void add(Point3D point3D) {
        if (points == null) {
            points = new ArrayList<Point3D>();
        }
        points.add(point3D);
    }

    public TRIObject generate() {
        int size = points.size();
        TRIObject to = new TRIObject();
        Point3D centre = new Point3D();
        for (int i = 0; i < size; i++) {
            centre = centre.plus(points.get(i).mult(1.0 / size));
        }
        for (int i = 0; i < size; i++) {
            to.add(new TRI(points.get(i % size), points.get((i + 1) % size), centre, texture));
        }
        return to;
    }

    public ArrayList<Point3D> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point3D> points) {
        this.points = points;
    }

    public void setPoints(Point3D[] point3D) {
        points.addAll(Arrays.asList(point3D));
    }

    @Override
    public String toString() {
        String t = "poly (\n\t(";
        Iterator<Point3D> it = points.iterator();
        while (it.hasNext()) {
            t += "\n\t\t" + it.next().toString();
        }
        t += "\n\t)\n\t" + texture.toString() + "\n)\n\n";
        return t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Polygon polygone = (Polygon) o;

        return getPoints() != null ? getPoints().equals(polygone.getPoints()) : polygone.getPoints() == null;

    }

    @Override
    public int hashCode() {
        return getPoints() != null ? getPoints().hashCode() : 0;
    }

    @Override
    public void moveAdd(Point3D add) {
        for (int i = 0; i < points.size(); i++)
            points.get(i).moveAdd(add);
    }

    @Override
    public void moveTo(Point3D to) {
        for (int i = 0; i < points.size(); i++)
            points.get(i).moveTo(to);

    }

    @Override
    public void scale(Point3D center, double scale) {
        for (int i = 0; i < points.size(); i++) {
            Point3D newPos = points.get(i).moins(center).mult(scale);
            points.remove(i);
            points.add(i, newPos);

        }


    }

    @Override
    public void scale(double scale) {
        Point3D center = Point3D.O0;
        for (int i = 0; i < points.size(); i++) {
            center = center.plus(points.get(i));
        }
        center = center.mult(1.0 / points.size());

        scale(center, scale);
    }
}
