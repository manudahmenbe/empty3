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
package one.empty3.library;

import java.awt.*;

public class Lighter implements IBasicLighter {

    Point3D pointLumiere;
    double intensite;
    double rayonEnglobant;

    public Lighter() {
    }

    public Color calculerLumierePoint(Point3D point, Color couleur, Point3D normale) {
        double facteurAngulaire = point.moins(pointLumiere).norme1().prodScalaire(normale.norme1());

        double distance = Point3D.distance(point, pointLumiere);

        double formule = facteurAngulaire * intensite * Math.exp(-distance * distance / rayonEnglobant / rayonEnglobant);

        float[] colorsComp = new float[3];

        couleur.getColorComponents(colorsComp);

        for (int i = 0; i < 3; i++) {
            colorsComp[i] = (float) (colorsComp[i] * formule);
            if (colorsComp[i] > 1f) {
                colorsComp[i] = 1f;
            } else if (colorsComp[i] < 0f) {
                colorsComp[i] = 0f;
            }
        }

        return new Color(colorsComp[0], colorsComp[1], colorsComp[2]);
    }

    public void config(Point3D pointLumiere, double intensite, double rayonEnglobant) {
        this.pointLumiere = pointLumiere;
        this.intensite = intensite;
        this.rayonEnglobant = rayonEnglobant;
    }
}
