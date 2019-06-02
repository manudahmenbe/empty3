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

/**
 * @author manuel
 */
public class CouleurOutils {

    public static Color couleurFactio(Color c1, Color cFond, TRI t, Point3D lumiere, boolean plus) {
        Point3D v1 = t.normale().norme1();
        Point3D v2 = lumiere.norme1();

        double cos = v1.prodScalaire(v2);
        int signe = 1;
        if (!plus) {
            signe = -1;
        }
        int[] cFondC = new int[]{cFond.getRed(), cFond.getGreen(), cFond.getBlue()};
        int[] res = new int[]{c1.getRed(), c1.getGreen(), c1.getBlue()};

        for (int i = 0; i < 3; i++) {
            res[i] += signe * (int) (Math.abs(cFondC[i] * cos));
            if (res[i] < 0) {
                res[i] = 0;
            }
            if (res[i] > 255) {
                res[i] = 255;
            }
        }
        return new Color(res[0], res[1], res[2]);
    }

    public static String couleurID() {
        return "c";
    }

    public static Color couleurRatio(Color c1, Color c2, double r) {

        return new Color(
                (float) (c1.getRed() * r + c2.getRed() * (1 - r)),
                (float) (c1.getGreen() * r + c2.getGreen() * (1 - r)),
                (float) (c1.getBlue() * r + c2.getBlue() * (1 - r))
        );
    }

    public static String toStringColor(Color couleur) {
        return "(" + couleur.getRed() + ", " + couleur.getGreen() + ", "
                + couleur.getBlue() + ")";
    }

    public String couleurLongID() {
        return "Couleur";
    }

    public Color randomColor() {
        return new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random());
    }
}
