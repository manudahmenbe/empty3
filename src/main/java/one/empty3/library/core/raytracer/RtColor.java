/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package one.empty3.library.core.raytracer;

import java.awt.*;

public class RtColor {
    public double red, green, blue, alpha;    // Les trois composantes de la couleur
    RtColor c;

    // constructeurs et destructeur
    public RtColor() {
        red = 0;
        green = 0;
        blue = 0;
        alpha = 0;
    }

    public RtColor(double r, double g, double b) {
        red = r;
        green = g;
        blue = b;
        alpha = 0;

    }

    public RtColor(double r, double g, double b, double a) {
        red = r;
        green = g;
        blue = b;
        alpha = a;

    }

    public RtColor(Color color) {
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
        alpha = color.getAlpha();

    }

    // operateurs
    public static RtColor mult(RtColor c1, RtColor c2) {
        return new RtColor(c1.getRed() * c2.getRed(), c1.getGreen() * c2.getGreen(), c1.getBlue() * c2.getBlue());
    }

    public static RtColor mult(RtColor c1, double multiple) {
        return new RtColor(c1.getRed() * multiple, c1.getGreen() * multiple, c1.getBlue() * multiple);
    }

    public static RtColor add(RtColor c1, RtColor c2) {
        return new RtColor(c1.getRed() + c2.getRed(),
                c1.getGreen() + c2.getGreen(),
                c1.getBlue() + c2.getBlue()
        );
    }

    public static RtColor plus(RtColor c1, RtColor c2) {
        return new RtColor(c1.getRed() + c2.getRed(), c1.getGreen() + c2.getGreen(), c1.getBlue() + c2.getBlue());
    }

    public static RtColor div(RtColor c1, float multiple) {
        return new RtColor(c1.getRed() / multiple, c1.getGreen() / multiple, c1.getBlue() / multiple);
    }


    public static RtColor normalizeColor(RtColor finalColor) {
        double max = Math.max(finalColor.getRed(), Math.max(finalColor.getGreen(), Math.max(finalColor.getBlue(), finalColor.getAlpha())));
        if (max > 1.0f || max < 0.0f) {
            finalColor = RtColor.mult(finalColor, 1 / max);
        }/*
        if (finalColor.getRed() > 1.0f)
            finalColor.red = 1.0f;
        if (finalColor.getGreen() > 1.0f)
            finalColor.green = 1.0f;
        if (finalColor.getBlue() > 1.0f)
            finalColor.blue = 1.0f;
        if (finalColor.getRed() < .0f)
            finalColor.red = .0f;
        if (finalColor.getGreen() < .0f)
            finalColor.green = .0f;
        if (finalColor.getBlue() < .0f)
            finalColor.blue = .0f;
        */
        return finalColor;
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public double getAlpha() {
        return alpha;
    }

    public Color toColor() {
        RtColor c = normalizeColor(this);
        return new Color((float) c.getRed(), (float) c.getGreen(), (float) c.getBlue(), (float) c.getAlpha());
    }


}
