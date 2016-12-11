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

package be.manudahmen.empty3;

import java.awt.*;
import java.util.HashMap;

@Deprecated
public class PlaceSurMatrice extends RepresentableConteneur {

    /**
     *
     */
    private static final long serialVersionUID = -349952132364614554L;
    public HashMap<Point, Representable> map = new HashMap<Point, Representable>();
    private int m;
    private int n;
    private Point3D p0, px, py;

    public PlaceSurMatrice(int m, int n) {
        super();
        this.m = m;
        this.n = n;
    }

    public void add(int i, int j, Representable r) {
        place(new Point(i, j), r);
    }

    public HashMap<Point, Representable> getAll() {
        return map;
    }

    public Representable getIt(int m, int n) {
        return null;
    }

    public Point getMax() {
        return new Point(m, n);
    }

    public Point3D getP0() {
        return p0;
    }

    public void setP0(Point3D p0) {
        this.p0 = p0;
    }

    public Point3D getPx() {
        return px;
    }

    public void setPx(Point3D px) {
        this.px = px;
    }

    public Point3D getPy() {
        return py;
    }

    public void setPy(Point3D py) {
        this.py = py;
    }

    public void place(Point p, Representable r) {
        map.put(p, r);
    }

    public void setPlan(Point3D p0, Point3D px, Point3D py) {
        this.p0 = p0;
        this.px = px;
        this.py = py;
    }

}
