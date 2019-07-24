package one.empty3.library.core.tribase;

import one.empty3.library.Point3D;
import one.empty3.library.core.nurbs.ParametricCurve;

/**
 * Created by manue on 23-07-19.
 */
public class Point3DC extends ParametricCurve {
    private Point3D o;

    public Point3DC()


    {
        super();
        this.o = new Point3D(Point3D.O0);
        getDeclaredPoints().put("o/Point::Curve", o);
    }

    public Point3DC(Point3D o0) {
        this();
        o = o0;

    }

    @Override
    public Point3D calculerPoint3D(double t) {
        return o;
    }
}
