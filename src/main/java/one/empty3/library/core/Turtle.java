package one.empty3.library.core;

import one.empty3.library.Matrix33;
import one.empty3.library.Point3D;
import one.empty3.library.Representable;
import one.empty3.library.core.nurbs.ParametricCurve;

import java.util.ArrayList;

/**
 * Created by manue on 07-09-19.
 */
public class Turtle extends ParametricCurve {
    private ArrayList matrixAndPoint = new ArrayList();
    private Matrix33 actualOrientation = new Matrix33();
    private Point3D actualPosition = new Point3D(Point3D.O0);

    private Matrix33 rX(double angle)
    {
        return new Matrix33(
                new Double[]
                        {
                              1d, 0d, 0d,
                               0d, Math.cos(angle), Math.sin(angle),
                               0d, -Math.sin(angle), Math.cos(angle),
                        }
        );
    }
    private Matrix33 rY(double angle)
    {
        return new Matrix33(
                new Double[]
                        {
                                 Math.cos(angle),0d, Math.sin(angle),
                                 0d, 1d, 0d,
                                 -Math.sin(angle),0d, Math.cos(angle),
                        }
        );
    }
    private Matrix33 rZ(double angle)
    {
        return new Matrix33(
                new Double[]
                        {
                                Math.cos(angle), Math.sin(angle),0d,
                                -Math.sin(angle), Math.cos(angle), 0d,
                                0d, 0d, 1d,
                        }
        );
    }

    private Matrix33 matriceAngulaire(int axe, double angle)
    {
        if(axe==0)
        {
            return actualOrientation.mult(rX(angle));
        }
        if(axe==1)
        {
            return actualOrientation.mult(rY(angle));
        }
        if(axe==2)
        {
            return actualOrientation.mult(rZ(angle));
        }
        return null;
    }


    public Turtle()
    {
        matrixAndPoint.add(actualPosition);
        matrixAndPoint.add(actualOrientation);
    }

    public void left(double angle, double distance)
    {

        Matrix33 matrix33 = matriceAngulaire(2, angle);
        matrixAndPoint.add(matrix33);
    }
    public void right(double angle, double distance)
    {
        Matrix33 matrix33 = matriceAngulaire(2, angle);
        matrixAndPoint.add(matrix33);
    }
    public void up(double angle, double distance)
    {
        Matrix33 matrix33 = matriceAngulaire(0, angle);
        matrixAndPoint.add(matrix33);
    }
    public void down(double angle, double distance)
    {
        Matrix33 matrix33 = matriceAngulaire(0, angle);
        matrixAndPoint.add(matrix33);
    }
    public void rear(double angle, double distance)
    {
        Point3D plus = actualOrientation.mult(Point3D.Z.mult(distance));
        matrixAndPoint.add(plus);
        actualPosition = actualPosition.plus(plus);

    }
    public void forwards(double angle, double distance)
    {
        Point3D plus = actualOrientation.mult(Point3D.Z.mult(distance));
        matrixAndPoint.add(plus);
        actualPosition = actualPosition.plus(plus);

    }
    public void rotate(double angleHorizLR, double angleVertDU, double angleForwardsSquiv)
    {

    }
    public Point3D getPosition()
    {
        return actualPosition;
    }
    public Point3D getDirection()
    {
        return actualOrientation.mult(Point3D.Z).norme1();
    }
    public void clearPointsBefore()
    {

    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredRepresentables().put("actualPosition", actualPosition);
        getDeclaredRepresentables().put("actualOrientation", actualOrientation);
        getDeclaredLists().put("matrixAndPoint", matrixAndPoint);
    }

    public ArrayList<Representable> getMatrixAndPoint() {
        return matrixAndPoint;
    }

    public void setMatrixAndPoint(ArrayList<Representable> matrixAndPoint) {
        this.matrixAndPoint = matrixAndPoint;
    }

    public Matrix33 getActualOrientation() {
        return actualOrientation;
    }

    public void setActualOrientation(Matrix33 actualOrientation) {
        this.actualOrientation = actualOrientation;
    }

    public Point3D getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(Point3D actualPosition) {
        this.actualPosition = actualPosition;
    }

    public void computeAll()
    {
        Point3D pos = Point3D.O0;
        Matrix33 orient= Matrix33.I;
        for(int i=0; i<matrixAndPoint.size(); i++)
        {
            Object mp = matrixAndPoint.get(i);
            if(mp instanceof Double)
            {
                pos = pos.plus(orient.mult((Point3D.Z.mult((Double)mp))));
            }
            else if(mp instanceof Matrix33)
            {
                orient = orient.mult((Matrix33)mp);
            }
            else if(mp instanceof Point3D)
            {
                pos = pos.plus(orient.mult((Point3D)mp));
            }
        }
    }
}
