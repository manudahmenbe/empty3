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
package one.empty3.library;

/**
 * @author Se7en
 */
public class WiredRepresentation extends RepresentableConteneur {

    private Point3D[][] pts;

    public WiredRepresentation(Point3D[][] pts) {
        this.pts = pts;
    }

    public RepresentableConteneur getRP() {
        RepresentableConteneur rp = new RepresentableConteneur();

        for (int i = 0; i < pts.length; i++) {
            for (int j = 0; j < pts[0].length; j++) {
                if (j + 1 < pts[0].length) {
                    this.add(
                            new LineSegment(pts[i][j], pts[i][j + 1], pts[i][j].texture()));
                }

                if (i + 1 < pts.length) {
                    this.add(
                            new LineSegment(pts[i][j], pts[i + 1][j], pts[i][j].texture()));
                }

            }
        }
        return rp;
    }

}
