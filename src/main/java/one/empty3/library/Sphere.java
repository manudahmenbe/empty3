package one.empty3.library;

import one.empty3.library.core.nurbs.ParametricSurface;


public class Sphere extends ParametricSurface {
    protected Circle circle;
    private Axe axe;

    public Sphere()
    {
        super();
        this.axe = new Axe();
        circle = new Circle();


    }
    public Sphere(Axe axis, double radius) {
        this();
        this.axe = axis;
        circle = new Circle(axis, radius);
    }

    public Sphere(Point3D center, double radius) {
        this();
        axe = new Axe(center.plus(Point3D.Y.mult(radius)), center.plus(Point3D.Y.mult(-radius))
        );
        circle = new Circle(axe, radius);
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

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredRepresentables().put("axe/axe du cercle sustantif", axe);
        getDeclaredRepresentables().put("circle/circle", circle);

    }
}
