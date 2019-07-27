package one.empty3.library.core.nurbs;

import one.empty3.library.*;

/**
 * Created by manue on 28-04-19.
 */
public class Point3DS extends ParametricCurve {
    private final Point3D point;
    {
        getParameters().setIncrU(1.0);

        getParameters().setEndU(0.1);

        setConnected(false);
    }
    public Point3DS(Point3D s)
    {
        this.point = s;
        this.texture(s.texture());

    }

    @Override
    public Point3D calculerPoint3D(double t) {
        return point;
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        return point;
    }
}
