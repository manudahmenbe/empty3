package info.emptycanvas.library.raytracer;

class CColor {
    public float mR, mG, mB, mA;    // Les trois composantes de la couleur

    // constructeurs et destructeur
    public CColor() {
        mR = 0;
        mG = 0;
        mB = 0;
        mA = 0;
    }

    public CColor(float r, float g, float b) {
        mR = r;
        mG = g;
        mB = b;
        mA = 0;

    }

    public CColor(float r, float g, float b, float a) {
        mR = r;
        mG = g;
        mB = b;
        mA = a;

    }

    // operateurs
    public static CColor mult(CColor c1, CColor c2) {
        return new CColor(c1.mR * c2.mR, c1.mG * c2.mG, c1.mB * c2.mB);
    }

    public static CColor mult(CColor c1, float multiple) {
        return new CColor(c1.mR * multiple, c1.mG * multiple, c1.mB * multiple);
    }

    public static CColor add(CColor c1, CColor c2) {
        return new CColor(c1.mR + c2.mR,
                c1.mG + c2.mG,
                c1.mB + c2.mB
        );
    }

    public CColor plus(CColor c1, CColor c2) {
        return new CColor(c1.mR + c2.mR, c1.mG + c2.mG, c1.mB + c2.mB);
    }

    public CColor div(CColor c1, float multiple) {
        return new CColor(c1.mR / multiple, c1.mG / multiple, c1.mB / multiple);
    }


    public void normalizeColor() {
        if (mR > 1.0f) mR = 1.0f;
        if (mG > 1.0f) mG = 1.0f;
        if (mB > 1.0f) mB = 1.0f;
    }
}
