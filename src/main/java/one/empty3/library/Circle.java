package one.empty3.library;

import one.empty3.library.core.nurbs.ParametricCurve;

/****
 *
 * TODO Check all the constructors.
 *
 */


public class Circle extends ParametricCurve {
    protected Axe axis;
    //public Point3D center;
    protected Double radius;
    protected Point3D vectX;
    protected Point3D vectY;
    protected Point3D vectZ;

    public Circle()
    {
        axis = new Axe();
        radius = 10.0;
        calculerRepere1();
    }

    public Circle(Axe axis, double radius) {
        this.axis = axis;
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
        int i=0;
        while (!success && i<3) {
            Point3D pRef = new Point3D(i == 0 ? 1d : 0d, i == 1 ? 1d : 0d, i == 2 ? 1d : 0d);

            Point3D mult = axis.getVector().norme1().prodVect(axis.getVector().norme1().prodVect(pRef).norme1());
            double d = mult.prodScalaire(pRef);
            vectY = axis.getVector().norme1();
            vectX = mult.norme1();
            vectZ = vectX.prodVect(vectY);
            if (mult.norme() > 0.8 || d >0.8) {
                success = true;
                break;
            }
            i++;
        }
        if(!success)
        {
            throw new NullPointerException("Cannot compute axis");
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

    public Axe getAxis() {
        return axis;
    }

    public void setAxis(Axe axis) {
        this.axis = axis;
    }

    public Point3D getCenter() {
        return axis.getCenter();
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
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
        return axis.getVector();
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        calculerRepere1();
        getDeclaredRepresentables().put("axis/axe du cercle (perpendiculaire au plan)", axis);
        getDeclaredDoubles().put("radius/rayon", radius);
    }
}
