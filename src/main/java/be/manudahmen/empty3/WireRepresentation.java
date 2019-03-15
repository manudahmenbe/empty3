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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.manudahmen.empty3;

import be.manudahmen.empty3.core.nurbs.ParametricSurface;
import be.manudahmen.empty3.core.nurbs.SurfaceParametricPolygonalBezier;

/**
 * @author Se7en
 */
public class WireRepresentation extends RepresentableConteneur {

    private final ParametricSurface surface;
    private Point3D[][] pts;

    public WireRepresentation(ParametricSurface parametricSurface) {

        this.surface = parametricSurface;
        getRP();
    }
    public WireRepresentation(Point3D [][] point3DS) {

        this.surface = new SurfaceParametricPolygonalBezier(point3DS);
        getRP();
    }

    public void getRP() {
        this.clear();
        for (double i = surface.getStartU(); i < surface.getEndU()
                ; i+=surface.getIncrU()) {
            for (double j = surface.getStartV();
                 j < surface.getEndV()
                    ; j+=surface.getIncrV()) {
                    this.add(
                            new SegmentDroite(
                                    surface.calculerPoint3D(i,j),
                                    surface.calculerPoint3D(i,j +
                                    surface.getIncrV()),
                                    surface.calculerPoint3D(i,j).texture()));
                    this.add(
                            new SegmentDroite(
                                    surface.calculerPoint3D(i,j),
                                    surface.calculerPoint3D(i+surface.getIncrU(),j + 1),
                                    surface.calculerPoint3D(i,j).texture()));

            }
        }
    }

}
