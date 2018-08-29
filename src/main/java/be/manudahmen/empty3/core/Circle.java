package be.manudahmen.empty3.core;

import be.manudahmen.empty3.Axe;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricCurve;

public class Circle extends ParametricCurve {
    public Axe axis;
    public Point3D center;
    public double radius;
    public Point3D vA;
    public Point3D vB;
    public Point3D vC;

    public Circle(Axe axis, Point3D center, double radius) {
        this.axis = axis;
        this.center = center;
        this.radius = radius;

        calculerRepere();


    }

    private void calculerRepere() {
        boolean success = false;
        for (int i = 0; i < 3; i++) {
            Point3D pRef = new Point3D(i == 0 ? 1 : 0, i == 1 ? 1 : 0, i == 2 ? 1 : 0);

            Point3D mult = axis.getVectAxe().norme1().prodVect(center.moins(pRef));
            if (mult.norme() > 0.8) {
                vA = mult.norme1();
                vC = axis.getVectAxe().norme1();
                vB = vA.prodVect(vC);
                success = true;
            }

        }
        if (!success) {
            try {
                throw new NumberRangeException();
            } catch (NumberRangeException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public Point3D calculerPoint3D(double t) {
        return center.plus(
                vA.mult(
                        Math.cos(2.0 * Math.PI * t)).plus(
                        vB.mult(
                                Math.sin(2.0 * Math.PI * t))

                ).mult(radius));
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        return null;
    }

    public Axe getAxis() {
        return axis;
    }

    public void setAxis(Axe axis) {
        this.axis = axis;
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point3D getvA() {
        return vA;
    }

    public void setvA(Point3D vA) {
        this.vA = vA;
    }

    public Point3D getvB() {
        return vB;
    }

    public void setvB(Point3D vB) {
        this.vB = vB;
    }

    public Point3D getvC() {
        return vC;
    }

    public void setvC(Point3D vC) {
        this.vC = vC;
    }
}
