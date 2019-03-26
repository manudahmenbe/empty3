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

package be.manudahmen.empty3.core.raytracer.octopus;

import be.manudahmen.empty3.Point2D;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Polygon;
import be.manudahmen.empty3.ZBuffer;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;
import be.manudahmen.empty3.core.raytracer.RtRay;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;

public class OctopusAlgorithm {
    private final RtRay ray;
    private final ParametricSurface rep;
    /***
     * Min value: 2
     */
    private final int subDivideBase;
    public double redivise = 3.0;

    public OctopusAlgorithm(RtRay ray, int subDivideBase, ParametricSurface rep) {
        this.ray = ray;
        this.rep = rep;
        this.subDivideBase = subDivideBase;
    }

    public ArrayList<Point2D> getBounds(ArrayList<Point2D> point2DS) {
        if (point2DS == null) {
            point2DS = new ArrayList<>();
            for (double u = 0; u <= 1.0; u += 1.0 / subDivideBase)
                for (double v = 0; v <= 1.0; v += 1.0 / subDivideBase)
                    point2DS.add(new Point2D(u, v));
        } else {
            ArrayList<Point2D> points = new ArrayList<Point2D>();
            double incr = 1.0 / subDivideBase / redivise;
            double ecartMax = 1 / redivise;
            for (Point2D p : point2DS) {
                for (double u = p.getX() - ecartMax; u <= p.getX() + ecartMax; u += incr
                        )
                    for (double v = p.getY() - ecartMax; v <= p.getY() + ecartMax; v += incr
                            )
                        points.add(new Point2D(u, v));

            }

        }
        return point2DS;
    }


    private double distancePointRay(Point3D point3D, Point2D point2D) {
        Double dist =
                rep.calculerPoint3D(point2D.getX(), point2D.getX()).moins(ray.mVStart)
                        .prodScalaire(ray.mVDir)
                        * 1 / ray.mVDir.norme() - 1;
        return dist;
    }

    /***
     * Creates submap from map of (u,v)
     * Subdivides surfaces into smallest parts
     * @param coordinates
     * @return
     */
    public SortedMap<Double, Point2D> getClosestUVFromMap(SortedMap<Double, Point2D> coordinates, double value) {
        try {
            Double firstKey = coordinates.firstKey();
            Point2D point2D = coordinates.get(firstKey);

            SortedMap<Double, Point2D> subsubmap = new TreeMap<Double, Point2D>();

            subsubmap.put(firstKey, point2D);
            //System.out.println("submap not empty");
            return subsubmap;
        } catch (NoSuchElementException ex) {
        }

        return null;
    }

    public boolean isEqualOrLessThanOnePixel(SortedMap<Double, Point2D> point2DS) {
        boolean cont = false;
        for (Point2D coord : point2DS.values()) {
            Point3D target = rep.calculerPoint3D(coord.x, coord.y);
            Point3D moins = target.moins(ray.mVStart);
            moins.normalize();
            if (moins.getX() < ray.mVDirX1.getX() && moins.getX() > ray.mVDirX_1.getX()
                    && moins.getY() < ray.mVDirY1.getY() && moins.getY() > ray.mVDirY_1.getY()) {
                cont = true;

            } else {
                cont = false;
                break;
            }
        }
        return cont;
    }

    public boolean isEqualOrLessThanOnePixel(ZBuffer zbuffer, Polygon polyhedron)

    {
        return false;
    }

    public Point3D trace() {

        ArrayList<Point2D> bounds = getBounds(null);
        SortedMap<Double, Point2D> closestUVFromMap;
        int count = 0;
        do {
            TreeMap<Double, Point2D> submap = new TreeMap<>();
            int i = 0;

            for (Point2D p : bounds) {
                Point3D point3D = rep.calculerPoint3D(p.getX(), p.getY());
                double distance = distancePointRay(point3D, p);
                if (distance >= 0) {
                    submap.put(distance, p);
                }
            }


            closestUVFromMap = getClosestUVFromMap(submap, 1.0 / subDivideBase / redivise);
            count++;

            bounds = getBounds(bounds);

        } while (closestUVFromMap != null && !isEqualOrLessThanOnePixel(closestUVFromMap) && count < 100);

        if (closestUVFromMap != null) {
            Point2D uv = closestUVFromMap.get(closestUVFromMap.firstKey());
            Point3D calculerPoint3D = rep.calculerPoint3D(uv.x, uv.y);

            return calculerPoint3D;
        } else
            return null;
    }


}
