package one.empty3.library;

import one.empty3.library.core.nurbs.ParametricCurve;

/**
 * Created by manue on 20-06-19.
 */
public class PolyLine extends ParametricCurve {
    Point3D[] points = null;

    public PolyLine() {
        super();
        points = new Point3D[2];
        points[0] = Point3D.random(1d);
        points[1] = Point3D.random(1d);
    }

    public Point3D[] getPoints() {
        return points;
    }

    public void setPoints(Point3D[] points) {
        this.points = points;
    }

    @Override
    public Point3D calculerPoint3D(double t) {
        int i = (int) t * points.length;
        if (i >= points.length)
            i = points.length - 1;
        int j = (i + 1) >= points.length ? i : i + 1;
        Point3D p1 = points[i];
        Point3D p2 = points[j];
        double d = t - 1.0 * i / points.length;
        Point3D plus = p1.plus(p2.moins(p1).mult(1 - d));
        return plus;
    }

    public void add(Point3D point3D) {
        int newLength;
        if (points == null)
            points = new Point3D[]{point3D};
        else {
            newLength = points.length + 1;
            Point3D[] tmp = points;
            points = new Point3D[newLength];
            for (int i = 0; i < tmp.length; i++)
                points[i] = tmp[i];
            points[newLength - 1] = point3D;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\r\nPolyLine ( \r\n");
        for (int i = 0; i < points.length; i++)
            sb.append("\t" + points[i] + "\r\n");
        sb.append(texture);
        sb.append("\r\n)\r\n");
        return sb.toString();
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredArray1Points().put("points/Points de la ligne brisée", points);
    }
}
