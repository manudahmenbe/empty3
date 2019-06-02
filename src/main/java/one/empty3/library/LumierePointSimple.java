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

/**
 * @author Atelier
 */
public class LumierePointSimple implements LumierePoint {

    public static final Lumiere PARDEFAUT = new LumierePointSimple(Color.WHITE,
            Point3D.O0, 2.0);
    float[] f = new float[3];
    private Color couleur;
    private Point3D point;
    private double intensite;
    private float[] comp = new float[3];

    public LumierePointSimple(Color c, Point3D pl, double intensite) {
        this.couleur = c;
        this.point = pl;
        this.intensite = intensite;
        couleur.getColorComponents(comp);
    }

    @Override
    public int getCouleur(int base, Point3D p, Point3D n) {
        if (p != null && n != null) {
            return mult(
                    (float) (Math.abs(n.norme1().prodScalaire(
                            p.moins(point).norme1())) * intensite), base);
        } else {
            return base;
        }
    }

    public int getCouleur(Point3D p) {
        return getCouleur(p.texture.getColorAt(0.5,0.5)
                , p, p.getNormale());
    }

    private int mult(float d, int base1) {
        new Color(base1).getColorComponents(f);
        for (int i = 0; i < 3; i++) {
            f[i] = (float) (f[i] * comp[i] * intensite);
            if (f[i] > 1f) {
                f[i] = 1f;
            }
            if (f[i] < 0f) {
                f[i] = 0f;
            }
        }
        return new Color(f[0], f[1], f[2]).getRGB();
    }

}
