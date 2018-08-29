package be.manudahmen.empty3.core;

import be.manudahmen.empty3.Axe;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;

/**
 * Created by Win on 28-08-18.
 */
public class Citron extends ParametricSurface {
    private Circle circle;

    public Citron(Axe axis, Point3D center, double radius) {

        circle = new Circle(axis, center, radius);
    }

    public Point3D calculerPoint3D(double u, double v) {
        Circle c = circle;
        return c.center.plus(
                c.vA.mult(
                        Math.cos(2.0 * Math.PI * u)).plus(
                        c.vB.mult(
                                Math.sin(2.0 * Math.PI * u)).
                                mult(Math.cos(2.0 * Math.PI * v))
                                .plus(c.vC.mult(Math.sin(2 * Math.PI * v)))
                ).mult(c.radius));
    }

}
