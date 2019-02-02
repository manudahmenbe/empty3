package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Representable;
import be.manudahmen.empty3.RepresentableType;
import be.manudahmen.empty3.ZBuffer;

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
        for (double t = pc.start(); t < pc.end(); pc.getIncr()) {
            Point3D p = pc.calculerPoint3D(t);
            Point3D point3D = ps.calculerPoint3D(p.get(0), p.get(1));
            point3D.texture(pc.texture());
            zBuffer.testPoint(point3D);
        }
    }

}
