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
import be.manudahmen.empty3.core.nurbs.ParametrizedSurface;
import be.manudahmen.empty3.core.raytracer.RtRay;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class OctopusAlgorithm {
    private final RtRay ray;
    private final ParametrizedSurface rep;

    public OctopusAlgorithm(RtRay ray, ParametrizedSurface rep) {
        this.ray = ray;
        this.rep = rep;
    }

    public Polygon getBounds(Map<Double, Double> map) {
        Polygon p = new Polygon();
        for (Map.Entry<Double, Double> edd : map.entrySet()) {
            p.getPoints().add(rep.calculerPoint3D(edd.getKey(), edd.getValue()));
        }
        return p;
    }

    public SortedMap<Double, Map.Entry<Double, Double>> getRefinedMap(ParametrizedSurface rep, Polygon poly, Map<Double, Double> map, boolean firstTime) {
        SortedMap<Double, Map.Entry<Double, Double>> distances = new TreeMap<Double, Map.Entry<Double, Double>>();
        for (Map.Entry<Double, Double> doubleDoubleEntry : map.entrySet()) {
            distances.put(distancePointPolygon(rep.calculerPoint3D(doubleDoubleEntry.getKey(), doubleDoubleEntry.getValue()), poly), doubleDoubleEntry);
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
    public SortedMap<Double, Point2D> getClosestUVFromMap(SortedMap<Double, Point2D> coordinates, double value) {

        SortedMap<Double, Point2D> submap = new TreeMap<Double, Point2D>();

        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        SortedMap<Polygon, Integer> dists = new TreeMap<>();
        ArrayList<Double> us = new ArrayList<Double>();
        ArrayList<Double> vs = new ArrayList<Double>();

        int k = 0;
        for (Double distance : coordinates.keySet()) {
            Point2D coordinatesUV = coordinates.get(distance);

            if (value == -1) value = 1;

            Polygon p = new Polygon();

            double distanceMin = Double.MAX_VALUE, d;

            polygons.add(p);

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    k++;
                    us.add(coordinatesUV.getX() + i * value);
                    vs.add(coordinatesUV.getY() + j * value);
                    p.getPoints().add(rep.calculerPoint3D(
                            us.get(us.size() - 1),
                            vs.get(us.size() - 1)));
                    dists.put(p, k);
                }
            }
        }

        k = 0;
        for (Polygon p : polygons) {
            for (int i = 0; i < p.getPoints().size(); i++) {


                double distance = distancePointPolygon(ray.mVStart.plus(p.getPoints().get(i).prodScalaire(ray.mVDir)).mult(ray.mVDir.norme()), p);

                submap.put(distance, new Point2D(us.get(dists.get(p)), vs.get(dists.get(p))));
            }
        }

        return submap;

    }

    public boolean isEqualOrLessThanOnePixel(Map.Entry<Double, Double> map) {
        return false;
    }

    public boolean isEqualOrLessThanOnePixel(ZBuffer zbuffer, Polygon polyhedron)

    {
        return false;
    }
}
