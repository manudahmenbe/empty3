package be.manudahmen.emptycanvas.library.empty3.library.tribase;

import be.manudahmen.emptycanvas.library.empty3.library.object.Barycentre;
import be.manudahmen.emptycanvas.library.empty3.library.object.BezierCubique2D;
import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;

@SuppressWarnings("serial")
public class TRIBezier2D extends TRIObjetGenerateurAbstract {

    private BezierCubique2D bez;
    private Barycentre position;

    public TRIBezier2D(BezierCubique2D bez) {
        this.bez = bez;
        setCirculaireX(false);
        setCirculaireY(false);
    }

    @Override
    public Point3D coordPoint3D(int a, int b) {
        return bez.calculerPoint3D(1.0 * a / getMaxX(), 1.0 * b / getMaxY());
    }

}
