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
package be.manudahmen.empty3.core.extra;

import be.manudahmen.empty3.*;

/**
 * @author manuel
 */
public final class AttracteurEtrange extends Representable implements POConteneur {

    public static int NOMBRE_POINTS = 100000;
    private final double A;
    private final double B;
    private final double C;
    private final double D;
    private PObjet po;
    private String id;
    private Barycentre position;

    public AttracteurEtrange(double A, double B, double C, double D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;

        po = new PObjet();
        Point3D actuel = new Point3D(1, 2, 3);
        Point3D precedent;
        int i = 0;
        while (i < NOMBRE_POINTS) {
            precedent = actuel;
            actuel = formule(precedent);
            po.add(actuel);
            i++;
        }
    }

    public Point3D formule(Point3D precedent) {

        Point3D ref = new Point3D(Math.sin(A * precedent.getY()) - precedent.getZ()
                * Math.cos(B * precedent.getX()), precedent.getZ()
                * (Math.sin(C * precedent.getX()) - Math.cos(D
                * precedent.getY())), Math.sin(precedent.getX()));
        return position == null ? ref : position.calculer(ref);
    }

    @Override
    public Iterable<Point3D> iterable() {
        return po.iterable();
    }

    @Override
    public void position(Barycentre p) {
        this.position = p;
    }

    @Override
    public String toString() {
        return "attracteurEtrange ( " + A + " " + B + " " + " " + C + " " + D
                + ")\n";
    }

}
