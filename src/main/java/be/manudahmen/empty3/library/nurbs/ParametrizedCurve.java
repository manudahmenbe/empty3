/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.library.nurbs;

import be.manudahmen.empty3.library.object.Point3D;
import be.manudahmen.empty3.library.object.Representable;
import be.manudahmen.empty3.library.object.ZBuffer;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public abstract class ParametrizedCurve extends Representable {

    public double incr = 0;
    protected double start;
    protected double end;

    public abstract Point3D calculerPoint3D(double t);

    public abstract Point3D calculerVitesse3D(double t);

    public double end() {
        return end;
    }

    public void end(double e) {
        end = e;
    }

    public double getIncr() {
        return incr == 0 ? 0.01 : incr;
    }

    public double start() {
        return start;
    }

    public void start(double s) {
        start = s;
    }

    @Override
    public boolean ISdrawStructureDrawFastIMPLEMENTED(ZBuffer z) {
        return true;
    }

    @Override
    public void drawStructureDrawFast(ZBuffer z) {
        for (int i = 0; i < 100; i++) {
            Point3D d = calculerPoint3D(0.0 + 1.0 * i / NFAST);
            d.texture(CFAST);
            if (d.ISdrawStructureDrawFastIMPLEMENTED(z)) {
                d.drawStructureDrawFast(z);

            } else
                ;
        }
    }


}
