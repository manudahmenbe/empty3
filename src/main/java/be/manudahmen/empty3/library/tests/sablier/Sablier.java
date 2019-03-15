package be.manudahmen.empty3.library.tests.sablier;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;

/**
 * Created by manue on 01-11-15.
 */

public class Sablier extends ParametricSurface {

    protected double NFAST = 100;

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D p = new Point3D(
                Math.cos(Math.PI * 2 * u) * Math.sin(Math.PI / 2 + Math.PI * v),
                v,
                Math.sin(Math.PI * 2 * u) * Math.sin(Math.PI / 2 + Math.PI * v));
        p.texture(this.texture());
        return p;
    }

    @Override
    public Point3D calculerVitesse3D(double v, double v1) {
        return null;
    }


}
