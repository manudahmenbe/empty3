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

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class Quads extends RepresentableConteneur {

    public void setMatrix(Point3D[][] quads) {
        clear();

        for (int i = 0; i < quads.length - 1; i++) {
            for (int j = 0; j < quads[i].length - 1; j++) {
                Polygone poly = new Polygone();

                poly.add(quads[i][j]);
                poly.add(quads[i][j + 1]);
                poly.add(quads[i + 1][j + 1]);
                poly.add(quads[i + 1][j]);

                add(poly);
            }
        }
    }
}
