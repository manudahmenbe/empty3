package be.manudahmen.empty3.library.tests.cubes.ensemble;

/**
 * @author Se7en
 */
public class Resolution {
    private int x;
    private int y;

    public Resolution(int xv, int yv) {
        this.x = xv;
        this.y = yv;

    }

    public void x(int v) {
        this.x = v;
    }

    public void y(int v) {
        this.y = v;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
