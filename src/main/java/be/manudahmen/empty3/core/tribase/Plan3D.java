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
 * 2013 Manuel Dahmen
 */
package be.manudahmen.empty3.core.tribase;

import be.manudahmen.empty3.Barycentre;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;

public class Plan3D extends ParametricSurface {

    private Point3D p0 = new Point3D(0.0, 0.0, 0.0);
    private Point3D vX = new Point3D(1.0, 0.0, 0.0);
    private Point3D vY = new Point3D(0.0, 1.0, 0.0);
    private Barycentre position;

    public Plan3D() {
        setCirculaireX(false);
        setCirculaireY(false);
        setMaxX(1);
        setMaxY(1);
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        return p0.plus(vX.moins(p0).mult(u)
                .plus(vY.moins(p0).mult(v)));
    }

    public Point3D coordPoint3D(int x, int y) {
        return calculerPoint3D(1. * x / getMaxX(), 1. * y / getMaxY());
    }

    public String id() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Point3D pointOrigine() {
        return position == null ? p0 : position.calculer(p0);
    }

    public void pointOrigine(Point3D p0) {
        this.p0 = p0;
    }

    public Point3D pointXExtremite() {
        return position == null ? vX : position.calculer(vX);
    }

    public void pointXExtremite(Point3D vX) {
        this.vX = vX;
    }

    public Point3D pointYExtremite() {
        return position == null ? vY : position.calculer(vY);
    }
//Implements TRIObjetGenerateurAbstract.coordPoint3D

    public void pointYExtremite(Point3D vY) {
        this.vY = vY;
    }

    public void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "Plan (\n\t" + p0
                + "\n\t" + vX
                + "\n\t" + vY
                + "\n\t\"" + texture
                + "\"\n)\n";
    }

}
