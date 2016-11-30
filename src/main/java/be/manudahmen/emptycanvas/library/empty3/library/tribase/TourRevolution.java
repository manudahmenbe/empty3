/*

 Vous êtes libre de :

 */
package be.manudahmen.emptycanvas.library.empty3.library.tribase;

import be.manudahmen.emptycanvas.library.empty3.library.object.Barycentre;
import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;

/**
 * @author Manuel DAHMEN
 */
@Deprecated
public class TourRevolution extends TRIObjetGenerateurAbstract {

    private ApproximationFonction1D ame;
    private ApproximationFonction2D base;
    private Barycentre position;

    public TourRevolution(ApproximationFonction1D ame, ApproximationFonction2D base) {
        this.ame = ame;
        this.base = base;
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        // TODO Auto-generated method stub
        return null;
    }

}
