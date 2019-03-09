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
package be.manudahmen.empty3.core.extra;

import be.manudahmen.empty3.*;

import java.awt.*;
import java.util.Random;

/**
 * @author Manuel
 */
public class CollineModele2 extends Representable implements TRIGenerable {

    Random r = new Random();
    private TRIObject tris = new TRIObject();
    private String id;
    private Barycentre position;

    public CollineModele2(double altitudeMax) {
        int altMax = 10;
        int pMax = 100;

        Point3D p0 = position == null ? new Point3D(0, 0, 0) : position.calculer(new Point3D(0, 0, 0));
        Color c0 = new Color(128, 0, 255);

        Point3D[][] pA = new Point3D[altMax][pMax];

        Point3D[][] pAB = null;

        for (int alt = 1; alt < altMax; alt++) {
            for (int i = 0; i < pMax; i++) {
                Point3D[] p = new Point3D[3];

                p[0] = p0.plus(new Point3D(aleatoireSigne(alt),
                        aleatoireSigne(alt), 0));
                p[1] = p[0].plus(new Point3D(aleatoireSigne(alt),
                        aleatoireSigne(alt), 0));
                p[2] = p[1].plus(new Point3D(aleatoireSigne(alt),
                        aleatoireSigne(alt), 0));

                p0 = p[2];

                pA[alt][i] = p0;

                TRI t = new TRI(p[0], p[1], p[2], c0);

                tris.add(t);

                if (alt > 1 & i > 0) {
                    tris.add(new TRI(pA[alt - 1][i - 1], pA[alt][i - 1],
                            pA[alt][i], c0));
                    tris.add(new TRI(pA[alt][i - 1], pA[alt - 1][i - 1],
                            pA[alt - 1][i], c0));
                }

            }

            c0 = new Color(128, 0, 255 - 10 * alt);

            // TRI t = new TRI(pA[alt][0].plus(new Point3D(0,-1,0)),
            // pA[alt][pMax/2].plus(new Point3D(0,-1,0)),
            // pA[alt][pMax-1].plus(new Point3D(0,-1,0)), c0);
            // tris.add(t);
            p0 = p0.plus(new Point3D(0, 0, -10));
        }
    }

    private double aleatoireSigne(double alt) {
        return (r.nextInt(1000) - 499.5) / 1000.0 * 100.0 / alt / alt;
    }

    @Override
    public TRIObject generate() {
        return tris;
    }

    public Representable place(MODObjet aThis) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Barycentre position() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void position(Barycentre p) {
        this.position = p;

    }

    @Override
    public boolean supporteTexture() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TextureCol texture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "colline()\n";
    }

}
