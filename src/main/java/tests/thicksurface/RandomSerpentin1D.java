package tests.thicksurface;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.CourbeParametriquePolynomialeBezier;
import be.manudahmen.empty3.core.nurbs.RubanSurface;

/**
 * Created by manue on 16-02-19.
 */
public class RandomSerpentin1D extends RubanSurface {
    CourbeParametriquePolynomialeBezier courbeParametriquePolynomialeBezier;

    public RandomSerpentin1D() {
        courbeParametriquePolynomialeBezier = new CourbeParametriquePolynomialeBezier(
                new Point3D[]
                        {
                                Point3D.random(1.0),
                                Point3D.random(1.0),
                                Point3D.random(1.0),
                                Point3D.random(1.0),
                                Point3D.random(1.0)
                        }
        );
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        return courbeParametriquePolynomialeBezier.calculerPoint3D(u);
    }
}
