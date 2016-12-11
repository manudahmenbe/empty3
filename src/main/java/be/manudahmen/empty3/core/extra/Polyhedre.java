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
package be.manudahmen.empty3.core.extra;

import be.manudahmen.empty3.*;

import java.util.ArrayList;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         27 déc. 2011
 */
public class Polyhedre extends Representable implements TRIConteneur {

    private TRIObject tris = new TRIObject();
    private ArrayList<Point3D> points;
    private Object co;

    public Polyhedre() {
        this.points = new ArrayList<Point3D>();
    }

    public Polyhedre(ArrayList<Point3D> points) {
        this.points = points;
        for (int a = 0; a < points.size(); a++) {
            Point3D pa = points.get(a);
            for (int b = 0; b < points.size(); b++) {
                Point3D pb = points.get(b);
                for (int c = 0; c < points.size(); c++) {
                    Point3D pc = points.get(c);
                    if (pa != pb && pb != pc && pc != pa) {
                        TRI t = new TRI(pa, pb, pc, texture);
                        tris.add(t);
                    }
                }
            }
        }
    }

    public Polyhedre(ArrayList<Point3D> list, ColorTexture tColor) {
        this.points = list;
        this.texture = tColor;
        for (int a = 0; a < points.size(); a++) {
            Point3D pa = points.get(a);
            for (int b = 0; b < points.size(); b++) {
                Point3D pb = points.get(b);
                for (int c = 0; c < points.size(); c++) {
                    Point3D pc = points.get(c);
                    if (pa != pb && pb != pc && pc != pa) {
                        TRI t = new TRI(pa, pb, pc, texture);
                        tris.add(t);
                    }
                }
            }
        }
    }

    /**
     * @param tri
     */
    public void add(Point3D p) {
        tris.clear();
        points.add(p);
        for (int a = 0; a < points.size(); a++) {
            Point3D pa = points.get(a);
            for (int b = 0; b < points.size(); b++) {
                Point3D pb = points.get(b);
                for (int c = 0; c < points.size(); c++) {
                    Point3D pc = points.get(c);
                    if (pa != pb && pb != pc && pc != pa) {
                        TRI t = new TRI(pa, pb, pc, texture);
                        tris.add(t);
                    }
                }
            }
        }

    }

    public void delete(Point3D p) {
        points.remove(p);
    }

    /**
     *
     */
    public void deleteAll() {
        points.clear();

    }

    /* (non-Javadoc)
     * @see be.ibiiztera.md.pmatrix.pushmatrix.TRIConteneur#getObj()
     */
    @Override
    public Representable getObj() {
        return tris;
    }
    /* (non-Javadoc)
     * @see be.ibiiztera.md.pmatrix.pushmatrix.TRIConteneur#iterable()
     */

    @Override
    public Iterable<TRI> iterable() {
        return tris.getTriangles();
    }

}
