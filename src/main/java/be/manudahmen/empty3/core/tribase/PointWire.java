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

import be.manudahmen.empty3.*;

import java.util.ArrayList;

public class PointWire extends Representable implements IFct1D3D {

    private String id;

    private ArrayList<BezierCubique> beziers;

    public PointWire(ArrayList<Point3D> base) {
        beziers = new ArrayList<BezierCubique>();

        base.add(0, base.get(0));
        base.add(base.get(base.size() - 1));

        for (int i = 0; i < base.size() - 1; i++) {

            BezierCubique bc = new BezierCubique();

            bc.add(base.get(i).plus(base.get(i + 1)).mult(0.5));
            bc.add(base.get(i + 1));
            bc.add(base.get(i + 1));
            bc.add(base.get(i + 1).plus(base.get(i + 2)).mult(0.5));

            beziers.add(bc);

        }
    }

    @Override
    public int iteres() {
        return 1000;
    }

    public double maxValue() {
        return beziers.size();
    }

    public Point3D normale(double t) {
        return tangente(t + 0.00001).plus(tangente(t).mult(-1));
    }

    public Representable place(MODObjet aThis) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Barycentre position() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void position(Barycentre p) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean supporteTexture() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Point3D tangente(double t) {
        return beziers
                .get((int) (0.0001 + t))
                .calculerPoint3D((0.0000001 + t) - (int) (0.0001 + t))
                .plus(beziers.get((int) t).calculerPoint3D(t - (int) t)
                        .mult(-1));
    }

    public TextureCol texture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point3D value(double t) {
        return beziers.get((int) t).calculerPoint3D(t - (int) t);
    }

}
