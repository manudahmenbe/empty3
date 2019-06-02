package tests2.balleclou;

/*
 * 2013 Manuel Dahmen
 */

import one.empty3.library.Point2D;
import one.empty3.library.Point3D;
import one.empty3.library.core.tribase.TRISphere;

import java.util.ArrayList;

/**
 * @author Manuel Dahmen
 */
public class BalleClous2 extends TRISphere {
    private ArrayList<Point2D> points = new ArrayList<Point2D>();
    private double d;

    public BalleClous2(Point3D c, double r) {
        super(c, r);
    }

    public void addPoint(Point2D p) {
        this.points.add(p);
    }

    public ArrayList<Point2D> points() {
        return points;
    }

    public double formula(Point2D p1, Point2D p2) {
        double d = dmindist(p1, p2);

        return 1 / (d * d + 0.01);
    }

    public void param(double d) {
        this.d = d;
    }

    public double param() {
        return d;
    }

    public double dmindist(Point2D p0, Point2D p1) {

        double[] x = new double[]{-1, 0, 1, -1, 0, 1, -1, 0, 1};
        double[] y = new double[]{-1, -1, -1, 0, 0, 0, 1, 1, 1};
        double min = 100;
        for (int i = 0; i < 9; i++) {
            double cur;
            cur = Point2D.dist(p0, Point2D.plus(p1, new Point2D(x[i], y[i])));
            if (cur < min && cur > 0)
                min = cur;
        }
        return min;
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        Point3D p = super.coordPoint3D(x, y);

        Point2D p0 = new Point2D(1.0 * x / getMaxX(), 1.0 * y / getMaxY());

        double mult = 1.0;

        for (int i = 0; i < points.size(); i++) {

            mult += formula(p0, points.get(i));

        }

        return p.mult(mult / points.size());

    }


}
