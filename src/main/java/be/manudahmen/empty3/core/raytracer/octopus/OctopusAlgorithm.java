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

import be.manudahmen.empty3.core.extra.Polyhedron;
import be.manudahmen.empty3.core.nurbs.ParametrizedSurface;
import be.manudahmen.empty3.core.raytracer.RtRay;

import java.util.Map;

public class OctopusAlgorithm {
    private final RtRay ray;

    public OctopusAlgorithm(RtRay ray) {
        this.ray = ray;
    }

    public Polyhedron getBounds(ParametrizedSurface rep, Map.Entry<Double, Double> uvMin, Map.Entry<Double, Double> uvMax) {
        return null;
    }

    public Map<Double, Double> getRefinedMap(Polyhedron p, double uBase, double vBase, boolean firstTime) {
        return null;
    }

    public Map.Entry<Double, Double> getClosestUVFromMap(Map<Double, Double> cordinates) {
        return null;
    }

    public boolean isEqualOrLessThanOnePixel(Map.Entry<Double, Double> map) {
        return false;
    }

    public boolean isEqualOrLessThanOnePixel(Polyhedron polyhedron)

    {
        return false;
    }
}
