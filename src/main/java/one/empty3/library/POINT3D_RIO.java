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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package one.empty3.library;

/**
 * @author Atelier
 */
public class POINT3D_RIO extends Point3D {

    public static final Point3D X = new Point3D(1d, 0d, 0d);
    public static final Point3D Y = new Point3D(0d, 1d, 0d);
    public static final Point3D Z = new Point3D(0d, 0d, 1d);
    public static final Point3D O0 = new Point3D(0d, 0d, 0d);
    /**
     *
     */
    private static final long serialVersionUID = -5729435529487300122L;
    private double[] x;

    public POINT3D_RIO(double x0, double y0, double z0) {
        super(x0, y0, z0);
    }

    public POINT3D_RIO(Point3D p) {
        super();
        x[0] = p.get(0);
        x[1] = p.get(1);
        x[2] = p.get(2);
    }

    public POINT3D_RIO(POINT3D_RIO p0) {
        x = new double[3];
        x[0] = p0.getX();
        x[1] = p0.getY();
        x[2] = p0.getZ();
    }

    @Override
    public Object clone() {
        return new POINT3D_RIO(x[0], x[1], x[2]);
    }

    @Override
    public Point3D moins(Point3D p) {
        setX(getX() - p.getX());
        setY(getY() - p.getY());
        setZ(getZ() - p.getZ());
        return this;
    }

    public Point3D mult(double xFactor) {
        setX(getX() * xFactor);
        setY(getY() * xFactor);
        setZ(getZ() * xFactor);
        return this;
    }

    public Point3D plus(double i) {
        setX(getX() + i);
        setY(getY() + i);
        setZ(getZ() + i);
        return this;
    }

    @Override
    public Point3D plus(Point3D p) {
        setX(getX() + p.getX());
        setY(getY() + p.getY());
        setZ(getZ() + p.getZ());
        return this;
    }

}
