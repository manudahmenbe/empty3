package be.manudahmen.empty3.core;

import be.manudahmen.empty3.Axe;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;


public class Sphere extends ParametricSurface {
    private Circle circle;

    public Sphere(Axe axis, double radius) {

        circle = new Circle(axis, radius);
    }

    public Point3D calculerPoint3D(double u, double v) {
        Circle c = circle;
        return c.getCenter().plus(
                c.vectX.mult(
                        Math.cos(2.0 * Math.PI * u) * Math.cos(2.0 * Math.PI * v)).plus(
                        c.vectY.mult(
                                Math.sin(2.0 * Math.PI * u) * Math.cos(2.0 * Math.PI * v))
                                .plus(c.vectZ.mult(Math.sin(2 * Math.PI * v)))
                ).mult(c.radius));
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
