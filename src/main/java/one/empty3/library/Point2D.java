/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

/*
 * 2016 Manuel Dahmen
 */
package one.empty3.library;

public class Point2D {

    public double x;
    public double y;

    public Point2D() {
        super();
    }

    public Point2D(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D p1) {
        x = p1.getX();
        y = p1.getY();
    }

    public static double dist(Point2D p0, Point2D plus) {
        double xx = p0.x - plus.x;
        double xy = p0.y - plus.y;
        return xx * xx + xy * xy;
    }

    public static Point2D plus(Point2D p1, Point2D p2) {
        Point2D ret = new Point2D(p1);

        ret.x += p2.x;
        ret.y += p2.y;

        return ret;
    }

    public double distance(Point2D p2a) {
        double distance = Math.sqrt((x - p2a.getX()) * (x - p2a.getX()) + (y - p2a.getY()) * (y - p2a.getY()));
        return distance;
    }

    /**
     * @param p2a
     * @param d
     * @param e
     * @return
     */
    public boolean distanceEntre(Point2D p2a, double d, double e) {
        double distance = Math.sqrt((x - p2a.getX()) * (x - p2a.getX()) + (y - p2a.getY()) * (y - p2a.getY()));
        return distance > d && distance < e;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point2D moins(Point2D p) {
        return new Point2D(x - p.x, y - p.y);
    }

    public Point2D mult(double d) {
        return new Point2D(x * d, y * d);
    }

    public double norme() {
        return Math.sqrt(x * x + y * y);
    }

    public Point2D norme1() {
        return this.mult(1 / norme());
    }

    public Point2D plus(Point2D p) {
        return new Point2D(x + p.x, y + p.y);
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point3D get3D() {
        return new Point3D(x, y, 0d);
    }

    public double get(int axe) {
        return axe == 0 ? x : (axe == 1 ? y : Double.NaN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;

        Point2D point2D = (Point2D) o;

        if (Double.compare(point2D.getX(), getX()) != 0) return false;
        return Double.compare(point2D.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getX());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
