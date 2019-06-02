package one.empty3.library.core.nurbs;

import one.empty3.library.*;

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
                calculerPoint3D(u + getIncrU(), v)
                        .moins(calculerPoint3D(u-getIncrU(),v))
                        .prodVect(
                                calculerPoint3D(u, v+getIncrV()).
                        moins(calculerPoint3D(u, v-getIncrV())))
                                        .norme1().mult(outerWidth).
                        plus(calculerPoint3D(
                                u, v
                        ));

    }

    public Point3D computeInt(double u, double v) {
        return
                calculerPoint3D(u + getIncrU(), v)
                        .moins(calculerPoint3D(u-getIncrU(),v))
                        .prodVect(
                                calculerPoint3D(u, v+getIncrV()).
                                        moins(calculerPoint3D(u, v-getIncrV())))
                        .norme1().mult(-innerWidth).
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
