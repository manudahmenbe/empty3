package tests.thicksurface;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.SurfaceParametricPolygonalBezier;
import be.manudahmen.empty3.core.nurbs.ThickSurface;

/**
 * Created by manue on 16-02-19.
 */
public class RandomSerpentin2D extends ThickSurface {
    SurfaceParametricPolygonalBezier surfaceParametricPolygonalBezier;

    public RandomSerpentin2D() {
        surfaceParametricPolygonalBezier = new SurfaceParametricPolygonalBezier
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
        surfaceParametricPolygonalBezier.setIncrU(0.001);
        surfaceParametricPolygonalBezier.setIncrV(0.001);
    }


    @Override
    public Point3D calculerPoint3D(double u, double v) {
        return surfaceParametricPolygonalBezier
                .calculerPoint3D(u, v);
    }

}
