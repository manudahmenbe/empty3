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
package one.empty3.library;

import java.awt.*;

@Deprecated
public class Morphing {

    private int noImage;
    private int nbrImages;
    private double ratioImage;
    private BezierCubiqueReseauSurface s1;
    private BezierCubiqueReseauSurface s2;

    public Morphing(BezierCubiqueReseauSurface s1,
                    BezierCubiqueReseauSurface s2, int nbr) {
        this.s1 = s1;
        this.s2 = s2;
        this.nbrImages = nbr;
        noImage = 0;
    }

    public Point3D calculer(double s, double t, int i, int j) {
        return s1.calculer(s, t, i, j).mult(1 - ratioImage)
                .plus(s2.calculer(s, t, i, j).mult(ratioImage));
    }

    public Color getColor(int i, int j) {
        return s1.getColor(i, j);
    }

    public boolean imageSuivante() {
        noImage++;
        ratioImage = 1.0 * noImage / nbrImages;
        return noImage < nbrImages;
    }

}
