package be.manudahmen.empty3.core;

import be.manudahmen.empty3.Axe;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricCurve;

/****
 *
 * TODO Check all the constructors.
 *
 */


public class Circle extends ParametricCurve {
    protected Axe axis;
    //public Point3D center;
    protected double radius;
    protected Point3D vectX;
    protected Point3D vectY;
    protected Point3D vectZ;
    protected final Point3D vAxis;

    public Circle(Axe axis, double radius) {
        this.axis = axis;
        this.vAxis = axis.getP2().moins(axis.getP1()).norme1();
        this.radius = radius;
        calculerRepere1();


    }

    /*
        public Circle(Point3D center, Point3D vAxis, double radius) {

            this.vAxis = vAxis.norme1();
            this.axis = new Axe(
                    center.plus(vAxis),
                    center.moins(vAxis)
            );
            this.radius = radius;
            calculerRepere2();
        }
    */
/*
    private void calculerRepere2() {

    }

    public Circle(Point3D center, Point3D[] vAxis, double radius) {

        this.vAxis = vAxis[2];
        vectY = vAxis[2];
        vectX = vAxis[0];
        vectZ = vAxis[1];
        this.radius = radius;
        calculerRepere3();
    }

    private void calculerRepere3() {

    }
*/
    private void calculerRepere1() {
        boolean success = false;
        for (int i = 0; i < 3; i++) {
            Point3D pRef = new Point3D(i == 1 ? 0 : 0, i == 1 ? 1 : 0, i == 2 ? 1 : 0);

            Point3D mult = vAxis.norme1().prodVect(axis.getCenter().moins(pRef).norme1());
            if (mult.norme() > 0.6) {
                vectX = mult.norme1();
                vectZ = vAxis.norme1();
                vectY = vectZ.prodVect(vectX).norme1();
                success = true;
                break;
            }

        }
    }


    @Override
    public Point3D calculerPoint3D(double t) {
        return getCenter().plus(
                (
                        vectX.mult(
                                Math.cos(2.0 * Math.PI * t))
                                .plus(
                                        vectY.mult(
                                                Math.sin(2.0 * Math.PI * t)))
                )
                        .mult(radius)
        );
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
        return axis.getCenter();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point3D getVectX() {
        return vectX;
    }

    public void setVectX(Point3D vectX) {
        this.vectX = vectX;
    }

    public Point3D getVectY() {
        return vectY;
    }

    public void setVectY(Point3D vectY) {
        this.vectY = vectY;
    }

    public Point3D getVectZ() {
        return vectZ;
    }

    public void setVectZ(Point3D vectZ) {
        this.vectZ = vectZ;
    }

    public Point3D getvAxis() {
        return vAxis;
    }
}
