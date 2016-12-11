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

import java.util.ArrayList;
import java.util.List;

/**
 * Represents polygons built on a up axis. Each point of one polygon is joint by
 * his neighbors left, right, up down '''
 *
 * @author DAHMEN Manuel
 */
public class PolyMap extends Representable {

    private List<Polygone> polys = new ArrayList<Polygone>();
    private int size;

    /**
     * *
     * Constructor
     *
     * @param size Size of polygons
     */
    public PolyMap(int size) {

        this.size = size;
        if (!(size > 2)) {
            this.size = 3;
            throw new UnsupportedOperationException("Maillage de polygones");
        }

    }

    /**
     * *
     * Add point
     *
     * @param x height
     * @param p point to add
     */
    public void addPoint(int x, Point3D p) {
        if (x >= 0) {

            if (x == polys.size()) {
            }

            polys.get(x).getPoints().add(p);

        }
    }

    /**
     * *
     *
     * @return maillage as an array
     * @throws IllegalOperationException
     */
    public Point3D[][] getMaillage() throws IllegalOperationException {
        if (polys.isEmpty()) {
            throw new IllegalOperationException("Maillage incorrect");
        }
        int dim2 = 0;
        for (int i = 0; i < polys.size(); i++) {
            if (i == 0 || dim2 == polys.get(i).getPoints().size()) {
                dim2 = polys.get(i).getPoints().size();
            } else {
                throw new IllegalOperationException("Maillage incorrect");
            }
        }
        Point3D[][] pts = new Point3D[polys.size()][dim2];
        for (int i = 0; i < polys.size(); i++) {
            for (int j = 0; j < polys.get(i).getPoints().size(); j++) {
                pts[i][j] = polys.get(i).getPoints().get(j);
            }
        }
        return pts;
    }

    /**
     * *
     * Gets points on a (x,y) matrix;
     *
     * @param x width x>=0 && x<polys.size() @para
     *          m y height y>=0 && y< each poly.size() in polys @return
     */
    public Point3D getPoint(int x, int y) {

        return x < size && y < polys.size()
                ? polys.get(x).getPoints().get(y)
                : null;

    }

    /**
     * *
     * Polygon's list Each polygon must have the same size than others
     *
     * @return polygones
     */
    public List<Polygone> getPolys() {
        return polys;
    }
}
