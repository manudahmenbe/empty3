package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.Axe;
import be.manudahmen.empty3.Point3D;

public class Circle extends ParametricCurve {
    Axe axis;
    Point3D center;
    double radius;
    Point3D vA;
    Point3D vB;
    Point3D vC;

    public Circle(Axe axis, Point3D center, double radius) {
        this.axis = axis;
        this.center = center;
        this.radius = radius;

        calculerRepere();


    }

    private void calculerRepere() {
        Point3D mult = axis.getVectAxe().norme1().prodVect(center.moins(Point3D.X));
        if (mult.norme() > 0.2 && mult.norme() < 0.8) {
            vA = mult.norme1();
            vB = mult.prodVect(axis.getVectAxe()).norme1();
            vC = vA.prodVect(vB);
        }

    }


    @Override
    public Point3D calculerPoint3D(double t) {
        return center.plus(
                vA.mult(
                        Math.cos(2.0 * Math.PI * t)).plus(
                        vB.mult(
                                Math.sin(2.0 * Math.PI * t))
                ));
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        return null;
    }
}
