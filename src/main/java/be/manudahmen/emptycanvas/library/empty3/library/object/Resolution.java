package be.manudahmen.emptycanvas.library.empty3.library.object;

/**
 * @author Se7en
 */
public class Resolution {
    public static final Resolution K4RESOLUTION = new Resolution(1920 * 2, 1080 * 2).makeFinal();
    public static final Resolution HD720RESOLUTION = new Resolution(1600, 720).makeFinal();
    public static final Resolution HD1080RESOLUTION = new Resolution(1920, 1080).makeFinal();
    public static final Resolution XVGARESOLUTION = new Resolution(640, 480).makeFinal();
    private int x;
    private int y;
    private int nbits = 32;
    private boolean aFinal = false;

    public Resolution(int xv, int yv) {
        this.x = xv;
        this.y = yv;

    }

    public void x(int v) {
        if (!isFinal())
            this.x = v;
    }

    public void y(int v) {
        if (!isFinal())
            this.y = v;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public boolean isFinal() {
        return aFinal;
    }

    protected Resolution makeFinal() {
        aFinal = true;
        return this;
    }
}
