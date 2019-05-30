package be.manudahmen.empty3.core.tribase;

import be.manudahmen.empty3.MODObjet;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Representable;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;

/**
 * @author DAHMEN Manuel
 *         <p>
 *         dev
 * @date 22-mars-2012
 */
public class TRIEllipsoide extends ParametricSurface {

    private Point3D centre = Point3D.O0;
    private double radiusx = 1.0;
    private double radiusy = 1.0;
    private double radiusz = 1.0;

    public TRIEllipsoide(Point3D c, double rx, double ry, double rz) {
        this.centre = c;
        this.radiusx = rx;
        this.radiusy = ry;
        this.radiusz = rz;
        setCirculaireY(true);
        setCirculaireX(false);
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        double b = 1.0 * u * Math.PI - Math.PI / 2;
        double a = 1.0 * v * 2 * Math.PI;

        Point3D centre = this.centre;

        Point3D p
                = rotation(
                new Point3D(centre.getX() + radiusx * Math.sin(a) * Math.sin(b), centre.getY() + radiusy * Math.sin(a) * Math.cos(b),
                        centre.getZ() + radiusz * Math.cos(a))
        );
        return p;
    }

    @Override
    public Point3D calculerVitesse3D(double u, double v) {
        return new Point3D();
    }


    public Point3D getCentre() {
        return centre;
    }

    public void setCentre(Point3D centre) {
        this.centre = centre;
    }

    public String id() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Representable place(MODObjet aThis) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "Ellipsoide(\n\t" + centre.toString()
                + "\n\t" + radiusx
                + "\n\t" + radiusy
                + "\n\t" + radiusz
                + "\n\t"
                + texture.toString() + "\n)\n";
    }

}
