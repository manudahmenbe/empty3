package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.Point3D;

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
