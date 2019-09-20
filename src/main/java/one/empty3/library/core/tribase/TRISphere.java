/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
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

 Vous êtes libre de :

 */
package one.empty3.library.core.tribase;

import one.empty3.library.*;

/**
 * @author DAHMEN Manuel
 *         <p>
 *         dev
 * @date 22-mars-2012
 */
public class TRISphere extends Sphere {
    public TRISphere(Point3D center, double radius) {
        super(center, radius);
    }

    public Point3D getCentre() {
        return circle.getElem().getCenter();
    }

    public void setCentre(Point3D centre) {
        Axe axe2 = new Axe(getCircle().getAxis().getP1(), getCircle().getAxis().getP2());
        Point3D center2 = axe2.getCenter();
        axe2.getP1().changeTo(getCircle().getAxis().getP1().moins(center2).plus(centre));
        axe2.getP2().changeTo(getCircle().getAxis().getP2().moins(center2).plus(centre));
        circle = new StructureMatrix<>(0, Circle.class);
        circle.setElem(new Circle(axe2, circle.getElem().getRadius()));
    }

    public void setRadius(double radius) {
        circle.getElem().setRadius(radius);
    }
}/*ParametricSurface {

    private Point3D centre = new Point3D(0, 0, 0);
    private double radius = 1.0;

    public TRISphere(Point3D c, double r) {
        rotation = new Rotation(Matrix33.I, c);
        this.centre = c;
        this.radius = r;
        setCirculaireY(true);
        setCirculaireX(false);
        setIncrU(0.01);
        setIncrV(0.01);
    }

    @Override
    public Point3D calculerPoint3D(double u1, double v1) {

        Point3D centre = this.centre;


        double u = 2*Math.PI*u1;
        double v = Math.PI*v1;

        Point3D p = rotation(
                new Point3D(centre.getX() + Math.sin(u) * Math.sin(v)
                * radius, centre.getY() + Math.sin(u) * Math.cos(v) * radius,
                centre.getZ() + Math.cos(u) * radius));
        return p;
    }

    @Override
    public Point3D calculerVitesse3D(double u, double v) {
        return null;
    }

    @Override
    public Point3D coordPoint3D(int coordArr, int y) {
        double a = 1.0 * coordArr / getMaxX() * 2 * Math.PI - Math.PI;
        double b = 1.0 * y / getMaxY() * 2 * Math.PI - Math.PI;

        return calculerPoint3D(a, b);
    }

    public Point3D getCentre() {
        return centre;
    }

    public void setCentre(Point3D centre) {

        rotation = new Rotation(Matrix33.I, centre);
        this.centre = centre;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Sphere (\n\t" + centre.toString() + "\n\t" + radius + "\n\t"
                + texture.toString() + "\n)\n";
    }

}
*/