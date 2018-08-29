package be.manudahmen.empty3.core;

import be.manudahmen.empty3.Axe;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;

/**
 * Created by Win on 28-08-18.
 */
public class Sphere extends ParametricSurface {
    private Circle circle;

    public Sphere(Axe axis, double radius) {

        circle = new Circle(axis, axis.getCenter(), radius);
    }

    public Point3D calculerPoint3D(double u, double v) {
        Circle c = circle;
        return c.center.plus(
                c.vA.mult(
                        Math.cos(2.0 * Math.PI * u) * Math.cos(2.0 * Math.PI * v)).plus(
                        c.vB.mult(
                                Math.cos(2.0 * Math.PI * u) * Math.cos(2.0 * Math.PI * v))
                                .plus(c.vC.mult(Math.sin(2 * Math.PI * v)))
                ).mult(c.radius));
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
