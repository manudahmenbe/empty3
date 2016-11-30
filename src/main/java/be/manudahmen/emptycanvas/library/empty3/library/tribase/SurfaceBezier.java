/*

 Vous êtes libre de :

 */
package be.manudahmen.emptycanvas.library.empty3.library.tribase;

import be.manudahmen.emptycanvas.library.empty3.library.object.BezierCubique2D;
import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;

/**
 * @author DAHMEN Manuel
 *         <p>
 *         dev
 * @date 24-mars-2012
 */
@Deprecated
public class SurfaceBezier extends TRIObjetGenerateurAbstract {

    BezierCubique2D bd = null;

    public SurfaceBezier(BezierCubique2D bd) {
        this.bd = bd;
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        return bd.calculerPoint3D(1.0 * x / getMaxX(), 1.0 * y / getMaxY());
    }

}
