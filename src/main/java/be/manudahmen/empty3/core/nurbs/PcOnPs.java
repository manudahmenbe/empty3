package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.*;

/**
 * Created by manue on 02-02-19.
 */
public class PcOnPs extends Representable implements RepresentableType {
    ParametricSurface ps;
    ParametricCurve pc;

    public PcOnPs(ParametricSurface ps, ParametricCurve pc) {
        this.ps = ps;
        this.pc = pc;
    }

    public void draw(ZBuffer zBuffer) {
        for (double t = pc.start(); t < pc.end(); t+=pc.getIncr()) {
            Point3D p1 = pc.calculerPoint3D(t);
            Point3D p2 = pc.calculerPoint3D(t);
            Point3D pos1 = ps.calculerPoint3D(p1.get(0), p1.get(1));
            Point3D pos2 = ps.calculerPoint3D(p2.get(0), p2.get(1));
            pos1.texture(pc.texture());
            pos2.texture(pc.texture());
            zBuffer.line(pos1, pos2, pc.texture());
        }
    }

}
