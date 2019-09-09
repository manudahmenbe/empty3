package one.empty3.library;

import one.empty3.library.core.nurbs.ParametricSurface;


public class Sphere extends ParametricSurface {
    protected StructureMatrix<Circle> circle = new StructureMatrix<>(0);
    private StructureMatrix<Axe> axe = new StructureMatrix<>(0);

    public Sphere()
    {
        super();
        this.axe.setElem(new Axe());
        circle.setElem(new Circle());


    }
    public Sphere(Axe axis, double radius) {
        this();
        this.axe .setElem(axis);
        circle .setElem(new Circle(axis, radius));
    }

    public Sphere(Point3D center, double radius) {
        this();
        axe .setElem(new Axe(center.plus(Point3D.Y.mult(radius)), center.plus(Point3D.Y.mult(-radius))
        ));
        circle .setElem(new Circle(axe.getElem(), radius));
    }

    public Point3D calculerPoint3D(double u, double v) {
        Circle c = circle.getData0d();
        return c.getCenter().plus(
                c.vectX.mult(
                        Math.cos(2.0 * Math.PI * u) * Math.cos(-Math.PI / 2 + Math.PI * v)).plus(
                        c.vectY.mult(
                                Math.sin(2.0 * Math.PI * u) * Math.cos(-Math.PI / 2 + Math.PI * v))
                                .plus(c.vectZ.mult(Math.sin(-Math.PI / 2 + Math.PI * v)))
                ).mult(c.radius.getElem()));
    }

    public Circle getCircle() {
        return circle.getData0d();
    }

    public void setCircle(Circle circle) {
        this.circle.setElem(circle);
    }

    public Axe getAxe() {
        return axe.data0d;
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("axe/axe du cercle sustantif", axe);
        getDeclaredDataStructure().put("circle/circle", circle);

    }

    @Override
    public String toString() {
        return "sphere (\n\t"+circle.toString()+"\n\t"+texture.toString()+"\n)\t";
    }
}
