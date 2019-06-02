package one.empty3.library.core.nurbs;

import one.empty3.library.*;

/**
 * Created by manue on 13-02-19.
 * // TODO
 * // Epaisseur (2 surfaces "paralelles")
 * // Cisellement des bords ou pas de bords
 */
public abstract class RubanSurface extends ThickSurface {
    private double width = 0.0;

    public Point3D computeSurface(double t, double u) {
        return computeInt(t, u);
    }
}
