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
package one.empty3.library;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public final class LumierePonctuellePeriodique implements Lumiere {

    private Color couleurLumiere = Color.RED;
    private Point3D position;
    private double k = 1;
    private double r0 = 11;

    public LumierePonctuellePeriodique(Point3D pos, Color couleurLumiere) {
        this.position = pos;
        this.couleurLumiere = couleurLumiere;
    }

    @Override
    public int getCouleur(int base, Point3D p, Point3D n) {
        double x = (n.norme1().prodScalaire(position.moins(p).norme1()) + 1) / 2;
        double r = x;
        Color couleurObjet = new Color(base);
        return new Color((float) ((couleurObjet.getRed() / 256.0) * r + (couleurLumiere.getRed() / 256.0) * (1 - r)), (float) ((couleurObjet.getGreen() / 256.0) * r + (couleurLumiere.getGreen() / 256.0) * (1 - r)), (float) ((couleurObjet.getBlue()
                / 256.0) * r + (couleurLumiere.getBlue() / 256.0) * (1 - r))).getRGB();
    }

    public void r0(int r0) {
        this.r0 = r0;
    }

}
