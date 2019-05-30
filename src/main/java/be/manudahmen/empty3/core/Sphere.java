package be.manudahmen.empty3.core;

import be.manudahmen.empty3.Axe;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;


public class Sphere extends ParametricSurface {
    protected Circle circle;
    private Axe axe;

    public Sphere(Axe axis, double radius) {
        this.axe = axis;
        circle = new Circle(axis, radius);
    }

    public Sphere(Point3D center, double radius) {

        circle = new Circle(new Axe(center.plus(Point3D.Y.mult(radius)), center.plus(Point3D.Y.mult(-radius))
        ), radius);
    }

    public Point3D calculerPoint3D(double u, double v) {
        Circle c = circle;
        return c.getCenter().plus(
                c.vectX.mult(
                        Math.cos(2.0 * Math.PI * u) * Math.cos(-Math.PI / 2 + Math.PI * v)).plus(
                        c.vectY.mult(
                                Math.sin(2.0 * Math.PI * u) * Math.cos(-Math.PI / 2 + Math.PI * v))
                                .plus(c.vectZ.mult(Math.sin(-Math.PI / 2 + Math.PI * v)))
                ).mult(c.radius));
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Axe getAxe() {
        return axe;
    }
}
