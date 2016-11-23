package be.manudahmen.empty3.library.tribase;

import be.manudahmen.empty3.library.nurbs.ParametrizedCurve;
import be.manudahmen.empty3.library.object.Point3D;

public abstract class Surface extends ParametrizedCurve {

    protected int max = 100;

    /**
     * Point d'index i sur Max
     *
     * @param i index
     * @return Point3D point du chemin discret C
     */
    public Point3D getPoint(int i) {
        Point3D p = calculerPoint3D(1.0 * i / getMax());
        return new Point3D(p.get(0), p.get(1), p.get(2));
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
