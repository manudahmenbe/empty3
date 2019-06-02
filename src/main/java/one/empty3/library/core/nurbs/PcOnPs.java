package one.empty3.library.core.nurbs;

import one.empty3.library.*;

/**
 * Created by manue on 02-02-19.
 */
public class PcOnPs extends ParametricCurve {
    ParametricSurface ps;
    ParametricCurve pc;

    public PcOnPs(ParametricSurface ps, ParametricCurve pc) {
        this.ps = ps;
        this.pc = pc;
        this.texture(pc.texture());
    }


    @Override
    public Point3D calculerPoint3D(double t) {
        Point3D p1 = pc.calculerPoint3D(t);
        return ps.calculerPoint3D(p1.get(0), p1.get(1));
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        return null;
    }

}
