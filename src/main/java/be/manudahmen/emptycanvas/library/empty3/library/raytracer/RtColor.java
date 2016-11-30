package be.manudahmen.emptycanvas.library.empty3.library.raytracer;

public class RtColor {
    public float red, green, blue, alpha;    // Les trois composantes de la couleur
    RtColor c;

    // constructeurs et destructeur
    public RtColor() {
        red = 0;
        green = 0;
        blue = 0;
        alpha = 0;
    }

    public RtColor(float r, float g, float b) {
        red = r;
        green = g;
        blue = b;
        alpha = 0;

    }

    public RtColor(float r, float g, float b, float a) {
        red = r;
        green = g;
        blue = b;
        alpha = a;

    }

    // operateurs
    public static RtColor mult(RtColor c1, RtColor c2) {
        return new RtColor(c1.getRed() * c2.getRed(), c1.getGreen() * c2.getGreen(), c1.getBlue() * c2.getBlue());
    }

    public static RtColor mult(RtColor c1, float multiple) {
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
        float max = Math.max(finalColor.getRed(), Math.max(finalColor.getGreen(), Math.max(finalColor.getBlue(), finalColor.getAlpha())));
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
