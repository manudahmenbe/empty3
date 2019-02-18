package tests.thicksurface;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.SurfaceParametriquePolynomialeBezier;
import be.manudahmen.empty3.core.nurbs.ThickSurface;

/**
 * Created by manue on 16-02-19.
 */
public class RanndomSerpentin2D extends ThickSurface {
    SurfaceParametriquePolynomialeBezier surfaceParametriquePolynomialeBezier;

    public RanndomSerpentin2D() {
        surfaceParametriquePolynomialeBezier = new SurfaceParametriquePolynomialeBezier
                (
                        new Point3D[][]{
                                {
                                        Point3D.random(1.0),
                                        Point3D.random(1.0),
                                        Point3D.random(1.0),
                                        Point3D.random(1.0)
                                },
                                {
                                        Point3D.random(1.0),
                                        Point3D.random(1.0),
                                        Point3D.random(1.0),
                                        Point3D.random(1.0)
                                },
                                {
                                        Point3D.random(1.0),
                                        Point3D.random(1.0),
                                        Point3D.random(1.0),
                                        Point3D.random(1.0)
                                },
                                {
                                        Point3D.random(1.0),
                                        Point3D.random(1.0),
                                        Point3D.random(1.0),
                                        Point3D.random(1.0)
                                }
                        }
                );
        surfaceParametriquePolynomialeBezier.setIncrU(0.001);
        surfaceParametriquePolynomialeBezier.setIncrV(0.001);
    }


    @Override
    public Point3D calculerPoint3D(double u, double v) {
        return surfaceParametriquePolynomialeBezier
                .calculerPoint3D(u, v);
    }

}
