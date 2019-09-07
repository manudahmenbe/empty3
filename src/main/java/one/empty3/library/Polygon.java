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
package one.empty3.library;

import one.empty3.library.core.nurbs.SurfaceElem;

import java.awt.*;

/**
 * @author Manuel
 */
public class Polygon extends Representable implements SurfaceElem {

    /**
     *
     */
    private Point3D[] points = new Point3D[4];

    public Polygon() {
        super();
        points = new Point3D[4];
        for (int i=0; i<4; i++) {
            points[i] = Point3D.random(10.0);
        }
        declareProperties();
    }

    public Polygon(Color c) {
        this();
        texture(new TextureCol(c));
    }

    public Polygon(ITexture c) {
        this();
        texture(c);
    }

    public Polygon(Point3D[] list, Color c) {
        this(list, new TextureCol(c));
    }

    public Polygon(Point3D[] list, ITexture c) {
        this();
        this.texture = c;
        points = list;
    }

    public void add(Point3D point3D) {
        int newLength;
        if (points == null)
            points = new Point3D[]{point3D};
        else {
            newLength = points.length + 1;
            Point3D[] tmp = points;
            points = new Point3D[newLength];
            for (int i = 0; i < tmp.length; i++)
                points[i] = tmp[i];
            points[newLength - 1] = point3D;
        }
        declareProperties();
    }


    public Point3D[] getPoints() {
        return points;
    }

    public void setPoints(Point3D[] points) {
        this.points = points;
        declareProperties();
    }


    @Override
    public String toString() {
        String t = "poly (\n\t(";
        for (Point3D p : points) {
            t += "\n\t\t" + (p==null?"null":p.toString());
        }
        t += "\n\t)\n\t" + (texture == null ? "" : texture.toString()) + "\n)\n\n";
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

    public Point3D getIsocentre() {
        Point3D p = Point3D.O0;

        for (Point3D p0 : points) {
            p = p.plus(p0);
        }
        return p.mult(1. / points.length);
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredArray1Points().put("points/point 0 à N du Polygone", points);

    }


}
