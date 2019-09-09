package one.empty3.library.core.tribase;

import one.empty3.library.Point3D;
import one.empty3.library.StructureMatrix;
import one.empty3.library.core.nurbs.ParametricCurve;

/**
 * Created by manue on 23-07-19.
 */
public class Point3DC extends ParametricCurve {
    private StructureMatrix<Point3D> o;

    public Point3DC()


    {
        super();
        this.o.setElem(new Point3D(Point3D.O0));
        getDeclaredDataStructure().put("o/Point::Curve", o);
    }

    public Point3DC(Point3D o0) {
        this();
        o.setElem(o0);

    }

    @Override
    public Point3D calculerPoint3D(double t) {
        return o.getElem();
    }
}
