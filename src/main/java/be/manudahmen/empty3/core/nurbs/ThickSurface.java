package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.Point3D;

/**
 * Created by manue on 13-02-19.
 */
public abstract class ThickSurface extends ParametricSurface {
    private boolean isThick;
    private double innerWidth = 0.0;
    private double outerWidth = 0.0;
    private boolean isInnerWidth;
    private boolean isOuterWidth;
    private double sign = 1;

    public Point3D computeExt(double u, double v) {
        return
                calculerVitesse3D(u - getIncrU(), v - getIncrV()).
                        prodVect(
                                calculerVitesse3D(u + getIncrU(), v + getIncrV())
                        )
                        .norme1().mult(outerWidth).
                        plus(calculerPoint3D(
                                u, v
                        ));

    }

    public Point3D computeInt(double u, double v) {
        return
                calculerVitesse3D(u - getIncrU(), v - getIncrV()).
                        prodVect(
                                calculerVitesse3D(u + getIncrU(), v + getIncrV())
                        )
                        .norme1().mult(-outerWidth).
                        plus(calculerPoint3D(
                                u, v
                        ));

    }

    public void setOuterWidth(double outerWidth) {
        this.outerWidth = outerWidth;
    }

    public void setInnerWidth(double innerWidth) {
        this.innerWidth = innerWidth;
    }
}
