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
package one.empty3.library.core.extra;

import one.empty3.library.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Spirale implements ISpirale {

    private ArrayList<TRI> triangles;
    private Axe axe;
    private double angle;
    private double radius;
    private TRIObject obj;

    public Spirale(Axe axe, double radius) {
        this.axe = axe;
        this.setRadius(radius);

        /*
         * Tour tour = new Tour(axe.getP1(), axe.getP2(), new
         * Tour.IColorFunction() {
         * 
         * @Override public Color getColor(double axeCoordinate, double theta) {
         * return new Color(255, 0, 0); } }, new Tour.IPoint3DFunction() {
         * 
         * @Override public double getDiameter(double axeCoordinate, double
         * theta) {
         * 
         * return 100; }
         * 
         * @Override public int getNbrPoints() { return 20; }
         * 
         * @Override public void setNbrPoints() {
         * 
         * 
         * }
         * 
         * @Override public int getNbrRotations() { return 360; }
         * 
         * @Override public void setNbrRotation() { } });
         * 
         * FObjet o = tour.generate(); this.obj = o;
         */
    }

    @Override
    public void addToScene(Scene sc) {
        Iterator<TRI> it = triangles.iterator();
        TRIObject o = new TRIObject();
        while (it.hasNext()) {
            TRI t = it.next();
            o.add(t);
        }
        sc.add(o);
    }

    public TRIObject getObj() {
        return obj;
    }

    public void setObj(TRIObject obj) {
        this.obj = obj;
    }

    @Override
    public Point3D getObjectDeviation(Point3D position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Point3D getObjectDeviation(Point3D position, Point3D speed,
                                      Point3D rotation) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Point3D getObjectRotation(Point3D position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Point3D getObjectRotation(Point3D position, Point3D speed,
                                     Point3D rotation) {
        // TODO Auto-generated method stub
        return null;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void rotate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void rotate(double deg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
