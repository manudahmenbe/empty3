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

/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.core.testing;

import be.manudahmen.empty3.Point3D;

import java.awt.*;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class Gimbals {

    private final Gimbal[] gimballs;
    private Gimbal X;
    private Gimbal Y;
    private Gimbal Z;
    private Gimbal XYZ;
    private Point3D barycentre = new Point3D(Point3D.O0);

    public Gimbals() {
        X = new Gimbal(0);
        Y = new Gimbal(1);
        Z = new Gimbal(2);
        XYZ = new Gimbal(3);
        gimballs = new Gimbal[]{X, Y, Z, XYZ};
    }

    public void changeValue(int GimballNo, double value) {
        {
            for (int i = 0; i < 4; i++) {
                if (i == GimballNo) {
                    gimballs[i].changeValue(value);
                }
            }
        }
    }

    public void computeCamera() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    public Point3D barycentre() {
        return barycentre;
    }

    @Override
    public String toString() {
        String s = "Gimballsx4 ( X: " + X.toString() + " Y: " + Y.toString() + " Z: " + Z.toString() + " XYZ:  " + XYZ.toString() + " \n";
        return s;
    }

    public void draw(Graphics component, Rectangle zone) {
        component.setColor(Color.BLUE);
        component.drawOval((int) zone.getMinX(), (int) zone.getMinY(), (int) zone.getMaxX(), (int) zone.getMaxY());
        component.setColor(Color.RED);
        component.drawOval((int) (zone.getMinX() + zone.getMaxX()) / 2, (int) zone.getMinY(), (int) (zone.getMinX() + zone.getMaxX()) / 2, (int) zone.getMaxY());
        component.setColor(Color.GREEN);
        component.drawOval((int) zone.getMinX(), (int) (zone.getMinY() + zone.getMaxY()) / 2, (int) zone.getMaxY(), (int) (zone.getMinX() + zone.getMaxX()) / 2);

    }
}
