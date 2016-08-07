package info.emptycanvas.library.raytracer;

import java.awt.*;

public class CColor {
    public float red, green, blue, alpha;    // Les trois composantes de la couleur
    Color c;
    // constructeurs et destructeur
    public CColor() {
        red = 0;
        green = 0;
        blue = 0;
        alpha = 0;
    }

    public CColor(float r, float g, float b) {
        red = r;
        green = g;
        blue = b;
        alpha = 0;

    }

    public CColor(float r, float g, float b, float a) {
        red = r;
        green = g;
        blue = b;
        alpha = a;

    }

    // operateurs
    public static Color mult(Color c1, Color c2) {
        return new Color(c1.getRed() * c2.getRed(), c1.getGreen() * c2.getGreen(), c1.getBlue() * c2.getBlue());
    }

    public static Color mult(Color c1, float multiple) {
        return new Color(c1.getRed() * multiple, c1.getGreen() * multiple, c1.getBlue() * multiple);
    }

    public static Color add(Color c1, Color c2) {
        return new Color(c1.getRed() + c2.getRed(),
                c1.getGreen() + c2.getGreen(),
                c1.getBlue() + c2.getBlue()
        );
    }

    public static Color plus(Color c1, Color c2) {
        return new Color(c1.getRed() + c2.getRed(), c1.getGreen() + c2.getGreen(), c1.getBlue() + c2.getBlue());
    }

    public static Color div(Color c1, float multiple) {
        return new Color(c1.getRed() / multiple, c1.getGreen() / multiple, c1.getBlue() / multiple);
    }


    public static Color normalizeColor(Color finalColor) {
        if (finalColor.getRed() > 1.0f)
            finalColor = new Color(finalColor.getRed(), finalColor.getGreen(), finalColor.getBlue(), finalColor.getAlpha());
        if (finalColor.getGreen() > 1.0f)
            finalColor = new Color(finalColor.getRed(), finalColor.getGreen(), finalColor.getBlue(), finalColor.getAlpha());
        if (finalColor.getBlue() > 1.0f)
            finalColor = new Color(finalColor.getRed(), finalColor.getGreen(), finalColor.getBlue(), finalColor.getAlpha());
        return finalColor;
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }

    public float getAlpha() {
        return alpha;
    }

}
