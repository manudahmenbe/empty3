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
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    public OctopusAlgorithm(RtRay ray, int subDivideBase, ParametricSurface rep) {
        this.ray = ray;
        this.rep = rep;
        this.subDivideBase = subDivideBase;
    }

    public PolygonUV getBounds(ArrayList<Point2D> point2DS) {
        if (point2DS == null) {
            point2DS = new ArrayList<>();
            for (double u = 0; u <= 1.0; u += 1.0 / subDivideBase)
                for (double v = 0; v <= 1.0; v += 1.0 / subDivideBase)
                    point2DS.add(new Point2D(u, v));
        }
        PolygonUV p = new PolygonUV();
        for (Point2D edd : point2DS) {
            p.p.getPoints().add(rep.calculerPoint3D(edd.getX(), edd.getY()));
            p.uv.add(new Point2D(edd.getX(), edd.getY()));
        }
        return p;
    }

    public SortedMap<Double, Point2D> getRefinedMap(ParametricSurface rep, Polygon poly, ArrayList<Point2D> point2DS, boolean firstTime) {
        SortedMap<Double, Point2D> distances = new TreeMap<Double, Point2D>();
        for (Point2D point2D : point2DS) {
            distances.put(distancePointPolygon(rep.calculerPoint3D(point2D.getX(), point2D.getY()), poly), point2D);
        }

        // L'entrée la plus proche du polygone donne lieu à une nouvelle map.
        // par division de surface en tenant compte des (u,v) les plus proches.
        // La map est transformée en Polygone par getBounds().

        return distances;
    }

    private double distancePointPolygon(Point3D point3D, Polygon polygon) {
        double min = Double.MAX_VALUE;
        for (Point3D pointPoly : polygon.getPoints()) {
            double x;
            if ((x = Point3D.distance(pointPoly, point3D)) < min) {
                min = x;
            }
        }
        return min;
    }

    /***
     * Creates submap from map of (u,v)
     * Subdivides surfaces into smallest parts
     * @param coordinates
     * @return
     */
    // TODO NOT CORRECT
    public SortedMap<Double, Point2D> getClosestUVFromMap(SortedMap<Double, Point2D> coordinates, double value) {

        SortedMap<Double, Point2D> submap = new TreeMap<Double, Point2D>();

        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        SortedMap<Double, Point2D> dists = new TreeMap<Double, Point2D>();
        ArrayList<Double> us = new ArrayList<Double>();
        ArrayList<Double> vs = new ArrayList<Double>();

        int k = 0;
        for (Double distance : coordinates.keySet()) {
            Point2D coordinatesUV = coordinates.get(distance);

            if (value == -1) value = 1;

            double distanceMin = Double.MAX_VALUE, d;
            Point2D d1 = new Point2D();
            for (int i = 0; i < subDivideBase; i++) {
                for (int j = 0; j < subDivideBase; j++) {
                    us.add(coordinatesUV.getX() + i * value);//TODO
                    vs.add(coordinatesUV.getY() + j * value);//TODO
                    Point3D calculerPoint3D = rep.calculerPoint3D(
                            us.get(us.size() - 1),
                            vs.get(us.size() - 1));
                    k++;
                    Double dist =
                            calculerPoint3D.moins(ray.mVStart)
                                    .prodScalaire(ray.mVDir)
                                    * 1 / ray.mVDir.norme();
                    if (dist < distanceMin) {
                        distanceMin = dist;
                        d1 = new Point2D(
                                us.get(us.size() - 1),
                                vs.get(vs.size() - 1));
                    }
                }
            }
            dists.put(distanceMin, d1);
        }
        Double firstKey;
        try {
            firstKey = submap.firstKey();
            Point2D point2D = submap.get(firstKey);

            SortedMap<Double, Point2D> subsubmap = new TreeMap<Double, Point2D>();

            subsubmap.put(firstKey, point2D);
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
        throw new NotImplementedException();
    }

    public Point3D trace() {

        PolygonUV bounds = getBounds(null);
        SortedMap<Double, Point2D> closestUVFromMap;
        do {
            TreeMap<Double, Point2D> submap = new TreeMap<>();
            int i = 0;

            for (Point3D p : bounds.p.getPoints()) {
                Point2D uv = bounds.uv.get(i);
                double distance = distancePointPolygon(p, bounds.p);

                submap.put(distance, new Point2D(uv.x, uv.y));
                i++;
            }
            closestUVFromMap = getClosestUVFromMap(submap, 1.0 / subDivideBase / 1.2);

        } while (closestUVFromMap != null && !isEqualOrLessThanOnePixel(closestUVFromMap));

        if (closestUVFromMap != null) {
            Point2D uv = closestUVFromMap.get(closestUVFromMap.firstKey());
            return rep.calculerPoint3D(uv.x, uv.y);
        } else
            return null;
    }

    public class PolygonUV {
        public Polygon p = new Polygon();
        public ArrayList<Point2D> uv = new ArrayList<Point2D>();
    }
}
