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

 Vous êtes libre de :

 */
package be.manudahmen.empty3.core.tribase;

import be.manudahmen.empty3.MODObjet;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Representable;

/**
 * @author DAHMEN Manuel
 *         <p>
 *         dev
 * @date 22-mars-2012
 */
public class TRIEllipsoide extends DSurface {

    private Point3D centre = new Point3D(0, 0, 0);
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
