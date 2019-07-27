package one.empty3.library.core.tribase;

import one.empty3.library.MODObjet;
import one.empty3.library.Point3D;
import one.empty3.library.Representable;
import one.empty3.library.core.nurbs.ParametricSurface;

/**
 * @author DAHMEN Manuel
 *         <p>
 *         dev
 * @date 22-mars-2012
 */
public class TRIEllipsoide extends ParametricSurface {

    private Point3D centre = Point3D.O0;
    private Double radiusx = 1.0;
    private Double radiusy = 1.0;
    private Double radiusz = 1.0;

    public TRIEllipsoide() {
        setCirculaireY(true);
        setCirculaireX(false);
    }

    public TRIEllipsoide(Point3D c, Double rx, Double ry, Double rz) {
        this();
        this.centre = c;
        this.radiusx = rx;
        this.radiusy = ry;
        this.radiusz = rz;
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Double b = 1.0 * u * Math.PI - Math.PI / 2;
        Double a = 1.0 * v * 2 * Math.PI;

        Point3D centre = this.centre;

        Point3D p
                = rotation(
                new Point3D(centre.getX() + radiusx * Math.sin(a) * Math.sin(b), centre.getY() + radiusy * Math.sin(a) * Math.cos(b),
                        centre.getZ() + radiusz * Math.cos(a))
        );
        return p;
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

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredPoints().put("centre/centre", centre);
        getDeclaredDoubles().put("radiusx/radiusx", radiusx);
        getDeclaredDoubles().put("radiusy/radiusy", radiusy);
        getDeclaredDoubles().put("radiusz/radiusz", radiusz);

    }

    public Double getRadiusx() {
        return radiusx;
    }

    public void setRadiusx(Double radiusx) {
        this.radiusx = radiusx;
    }

    public Double getRadiusy() {
        return radiusy;
    }

    public void setRadiusy(Double radiusy) {
        this.radiusy = radiusy;
    }

    public Double getRadiusz() {
        return radiusz;
    }

    public void setRadiusz(Double radiusz) {
        this.radiusz = radiusz;
    }
}
