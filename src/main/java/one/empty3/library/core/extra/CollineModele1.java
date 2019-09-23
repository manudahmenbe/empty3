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
package one.empty3.library.core.extra;

import one.empty3.library.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Manuel
 */
public class CollineModele1 extends Representable implements TRIGenerable {

    Random r = new Random();
    private TRIObject tris = new TRIObject();
    private String id;
    private double deltaInterne = 100;

    public CollineModele1(int numTRIS) {

        Point3D p0 = new Point3D(0d, 0d, 0d);
        Color c0 = new Color(128, 0, 255);

        for (int i = 0; i < numTRIS; i++) {
            Point3D[] p = new Point3D[3];

            p[0] = p0.plus(new Point3D(aleatoireSigne(deltaInterne),
                    aleatoireSigne(deltaInterne), aleatoireSigne(deltaInterne)));
            p[1] = p[0].plus(new Point3D(aleatoireSigne(deltaInterne),
                    aleatoireSigne(deltaInterne), aleatoireSigne(deltaInterne)));
            p[2] = p[1].plus(new Point3D(aleatoireSigne(deltaInterne),
                    aleatoireSigne(deltaInterne), aleatoireSigne(deltaInterne)));

            p0 = p[2];

            TRI t = new TRI(p[0], p[1], p[2], c0);

            tris.add(t);
        }
    }

    private double aleatoireSigne(double maxAmpl) {

        return (r.nextDouble() - 0.5) * maxAmpl;

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
