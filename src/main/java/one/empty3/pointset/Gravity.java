package one.empty3.pointset;

import one.empty3.library.Point3D;

/**
 * Created by manue on 16-07-19.
 */
public class Gravity extends Point3D {
    Point3D v;
    double m;
    Point3D dv1;
    double dv = 1.0;
    public double dfs;

    public Gravity(Point3D random, double m, Point3D v)
    {
        super(random);
        this.m = m;
        this.v = v;
    }

    public void clearTemp() {
        dv1 = Point3D.O0;
    }

}
