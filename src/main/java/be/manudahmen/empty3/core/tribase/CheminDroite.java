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

package be.manudahmen.empty3.core.tribase;

import be.manudahmen.empty3.LineSegment;
import be.manudahmen.empty3.Point3D;

public class CheminDroite extends Chemin {

    private LineSegment sd;

    public CheminDroite(LineSegment sd) {
        this.sd = sd;
    }

    @Override
    public double getLength() {
        return sd.mesure();
    }

    public Point3D calculerPoint3D(double t) {
        return sd.getOrigine().plus(
                sd.getExtremite().moins(sd.getOrigine()).mult(t));

    }

    @Override
    public Point3D tangent(int i) {
        return sd.getExtremite().moins(sd.getOrigine()).norme1();

    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
