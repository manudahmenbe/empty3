package one.empty3.library;

import one.empty3.library.core.nurbs.ParametricSurface;

/**
 * Created by Win on 28-08-18.
 */
public class Citron extends ParametricSurface {
    private Circle circle;

    public Citron(Axe axis, Point3D center, double radius) {

        circle = new Circle(axis, radius);
    }

    public Point3D calculerPoint3D(double u, double v) {
        Circle c = circle;
        return c.getCenter().plus(
                c.vectX.mult(circle.getRadius() *
                        Math.cos(2.0 * Math.PI * u) * Math.cos(2.0 * Math.PI * v)).plus(
                        c.vectY.mult(circle.getRadius() *
                                Math.sin(2.0 * Math.PI * u) * Math.cos(2.0 * Math.PI * v))
                                .
                                        plus(c.vectZ.mult((v - 0.5) / 2 * Math.sin(2 * Math.PI * v)))
                ).mult(c.radius));
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
