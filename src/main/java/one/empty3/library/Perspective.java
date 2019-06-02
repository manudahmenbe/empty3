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

public class Perspective {

    public static final int P_CUBIQUE_ISOMETRIQUE = 0;
    public static final int P_CUBIQUE_LINEAIRE = 1;
    public static final int P_CUBIQUE_FONCTION = 2;
    private int type = P_CUBIQUE_ISOMETRIQUE;

    private Perspective(int t) {
        this.type = t;
    }

    public static final Perspective getInstance(int type) {
        return new Perspective(type);
    }

    java.awt.Point coordonneeEcran(Point3D p) {
        if (type == P_CUBIQUE_ISOMETRIQUE) {
            return new java.awt.Point((int) p.getX(), (int) p.getY());
        } else if (type == P_CUBIQUE_LINEAIRE) {
            if (p.getZ() == 0) {
                return new java.awt.Point(0, 0);
            } else {
                return new java.awt.Point((int) (p.getX() / p.getZ()),
                        (int) (p.getY() / p.getZ()));
            }
        } else if (type == P_CUBIQUE_FONCTION) {
            return new java.awt.Point(
                    (int) (p.getX() / f(p.getZ())),
                    (int) (p.getY() / f(p.getZ())));
        }
        return null;
    }

    protected double f(double z) {
        return z;
    }
}
