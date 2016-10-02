package info.emptycanvas.library.raytracer;

import java.awt.*;

public class CColor {
    public float red, green, blue, alpha=0;    // Les trois composantes de la couleur
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
    public static CColor mult(CColor c1, CColor c2) {
        return new CColor(c1.getRed() * c2.getRed(), c1.getGreen() * c2.getGreen(), c1.getBlue() * c2.getBlue());
    }

    public static CColor mult(CColor c1, float multiple) {
        return new CColor(c1.getRed() * multiple, c1.getGreen() * multiple, c1.getBlue() * multiple);
    }

    public static CColor add(CColor c1, CColor c2) {
        return new CColor(c1.getRed() + c2.getRed(),
                c1.getGreen() + c2.getGreen(),
                c1.getBlue() + c2.getBlue()
        );
    }

    public static CColor plus(Color c1, Color c2) {
        return new CColor(c1.getRed() + c2.getRed(), c1.getGreen() + c2.getGreen(), c1.getBlue() + c2.getBlue());
    }

    public static CColor div(Color c1, float multiple) {
        return new CColor(c1.getRed() / multiple, c1.getGreen() / multiple, c1.getBlue() / multiple);
    }


    public CColor normalizeColor() {
        CColor finalColor = this;
        if (finalColor.getRed() > 1.0f)
            finalColor.red = 1.0f;
        if (finalColor.getGreen() > 1.0f)
            finalColor.green = 1.0f;
        if (finalColor.getBlue() > 1.0f)
            finalColor.blue= 1.0f;
        if (finalColor.getRed() < 0f)
            finalColor.red  = 0.0f;
        if (finalColor.green < 0f)
            finalColor.green = 0.0f;
        if (finalColor.blue < 0f)
            finalColor.blue = 0.0f;
        return finalColor;
    }

    public CColor(Color c) {
        red = c.getRed();
        green = c.getGreen();
        blue = c.getBlue();
        alpha = c.getAlpha();
    }

    public Color convert()
    {
        normalizeColor();
        return new Color(getRed(), getGreen(), getBlue(), getAlpha());
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
