package one.empty3.pointset;

import one.empty3.library.Point3D;
import one.empty3.library.Representable;

/**
 * Created by manue on 16-07-19.
 */
public class Gravity extends Point3D {
    Point3D v;
    double m;
    Point3D dv1;
    public double dfs;

    public Gravity(double m, Point3D v)
    {
        this.m = m;
        this.v = v;
    }

    public void clearTemp() {
        dv1 = Point3D.O0;
    }

    public void set(Representable r) {
        for (int i = 0; i < 3; i++)
            ((Point3D) r).set(i, x[i]);
    }
}
