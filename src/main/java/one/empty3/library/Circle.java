package one.empty3.library;

import one.empty3.library.core.nurbs.ParametricCurve;

/****
 *
 * TODO Check all the constructors.
 *
 */


public class Circle extends ParametricCurve {
    protected StructureMatrix<Axe> axis =new StructureMatrix(0);
    //public Point3D center;
    protected StructureMatrix<Double>radius = new StructureMatrix<>(0);
    protected Point3D vectX;
    protected Point3D vectY;
    protected Point3D vectZ;

    public Circle()
    {
        axis.setElem(new Axe());
        radius.setElem(10.0);
        calculerRepere1();
    }

    public Circle(Axe axis, double radius) {
        this.axis.setElem( axis);
        this.radius.setElem(radius);
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

            Point3D mult = axis.getElem().getVector().norme1().prodVect(axis.getElem().getVector().norme1().prodVect(pRef).norme1());
            double d = mult.prodScalaire(pRef);
            vectY = axis.getElem().getVector().norme1();
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
                        .mult(radius.getElem())
        );
    }

    public Axe getAxis() {
        return axis.getElem();
    }

    public void setAxis(Axe axis) {
        this.axis.setElem(axis);
    }

    public Point3D getCenter() {
        return axis.getElem().getCenter();
    }

    public Double getRadius() {
        return radius.getElem();
    }

    public void setRadius(Double radius) {
        this.radius.setElem(radius);
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
        return axis.getElem().getVector();
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        calculerRepere1();
        getDeclaredDataStructure().put("axis/axe du cercle (perpendiculaire au plan)", axis);
        getDeclaredDataStructure().put("radius/rayon", radius);
    }

    @Override
    public String toString() {
        return "circle (\n"+axis.toString()+"\n";
    }
}
