package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.*;

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
