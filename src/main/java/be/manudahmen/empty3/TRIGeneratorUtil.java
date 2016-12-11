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
package be.manudahmen.empty3;

public class TRIGeneratorUtil {

    public static TRIObject P32DTriQuad(Point3D[] points, int dimx, int dimy) {
        TRIObject tri = new TRIObject();

        for (int i = 0; i < dimx - 1; i++) {
            for (int j = 0; j < dimy - 1; j++) {

                TRI t1 = new TRI(points[dimx * j + i], points[dimx * (j + 1)
                        + i], points[dimx * (j + 1) + (i + 1)], points[dimx * j
                        + i].texture());
                tri.add(t1);

                TRI t2 = new TRI(points[dimx * j + i], points[dimx * j
                        + (i + 1)], points[dimx * (j + 1) + (i + 1)],
                        points[dimx * j + i].texture());
                tri.add(t2);

            }
        }

        return tri;

    }

    public static TRIObject P32DTriQuad(Point3D[][] controle, int dimx, int dimy) {
        Point3D[] bis = new Point3D[dimx * dimy];
        for (int i = 0; i < dimx; i++) {
            for (int j = 0; j < dimy; j++) {
                bis[j * dimx + i] = controle[i][j];
            }
        }
        return P32DTriQuad(bis, dimx, dimy);
    }

}
