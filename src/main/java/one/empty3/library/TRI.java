/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
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
package one.empty3.library;

import one.empty3.library.core.raytracer.RtIntersectInfo;
import one.empty3.library.core.raytracer.RtRay;

import java.awt.*;

public class TRI extends Representable implements IMovable, IScalable {

    private Point3D[] sommet;
    private Barycentre position;

    public TRI() {
        super();
        sommet = new Point3D[3];
        sommet[0] = Point3D.O0;
        sommet[1] = Point3D.O0;
        sommet[2] = Point3D.O0;
        getDeclaredArray1Points().put("sommet/points sommets du triangle",sommet);
    }

    public TRI(Point3D coordPoint3D, Point3D coordPoint3D0, Point3D coordPoint3D1) {
        this(coordPoint3D, coordPoint3D0, coordPoint3D1, Color.black);
    }

    public TRI(Point3D point3d, Point3D point3d2, Point3D point3d3,
               Color red) {
        this();
        sommet = new Point3D[3];
        sommet[0] = point3d;
        sommet[1] = point3d2;
        sommet[2] = point3d3;
        this.texture(new TextureCol(red));
    }

    public TRI(Point3D point3d, Point3D point3d2, Point3D point3d3,
               ITexture red) {
        this();
        sommet = new Point3D[3];
        sommet[0] = point3d;
        sommet[1] = point3d2;
        sommet[2] = point3d3;
        this.texture = red;
    }

    public TRI(Point3D[] s, Color c) {
        this(s[0], s[1], s[2], c);
    }

    public TRI(Point3D[] s, ITexture c) {
        this(s[0], s[1], s[2], c);
    }

    public Object clone() {
        TRI tri = new TRI();
        tri.texture(texture());
        tri.setSommet(sommet.clone());
        return tri;
    }

    public Point3D[] getSommet() {
        return sommet;
    }

    public void setSommet(Point3D[] sommet) {
        this.sommet = sommet;
    }

    public Point3D normale() {
        return sommet[1].moins(sommet[0]).prodVect(sommet[2].moins(sommet[0]));
    }

    @Override
    public void position(Barycentre p) {
        this.position = p;

        sommet[0] = position == null ? sommet[0] : position.calculer(sommet[0]);
        sommet[1] = position == null ? sommet[1] : position.calculer(sommet[1]);
        sommet[2] = position == null ? sommet[2] : position.calculer(sommet[2]);
    }

    public void setCouleur(Color couleur) {
        this.texture(new TextureCol(couleur));

    }

    @Override
    public String toString() {
        String t = "tri (";
        for (int i = 0; i < 3; i++) {
            t += "\n\t\t(" + sommet[i].getX() + ", " + sommet[i].getY() + ", " + sommet[i].getZ() + "), ";
        }
        return t + "\n\t\t(" + texture.toString() + ")\n\t)\n";
    }

    @Override
    public Intersects.Intersection intersects(RtRay ray, RtIntersectInfo cii) {
        // TODO Implements
        return null;
    }

    public Point3D getCentre() {
        return getSommet()[0].plus(getSommet()[1]).plus(getSommet()[2].mult(1 / 3d));
    }

    public int intersects(TRI tri2) {


        return TRI_Collide.tr_tri_intersect3D(getCentre(), getSommet()[0], getSommet()[1],
                tri2.getCentre(), tri2.getSommet()[0], tri2.getSommet()[1]);
    }

    @Override
    public void moveAdd(Point3D add) {
        for (int i = 0; i < sommet.length; i++)
            sommet[i].moveAdd(add);
    }

    @Override
    public void moveTo(Point3D to) {
        for (int i = 0; i < sommet.length; i++)
            sommet[i].moveTo(to);

    }

    @Override
    public void scale(Point3D center, double scale) {
        for (int i = 0; i < sommet.length; i++) {
            Point3D newPos = sommet[i].moins(center).mult(scale);
            sommet[i] = newPos;

        }


    }

    @Override
    public void scale(double scale) {
        Point3D center = Point3D.O0;
        for (int i = 0; i < sommet.length; i++) {
            center = center.plus(sommet[i]);
        }
        center = center.mult(1.0 / sommet.length);

        scale(center, scale);
    }
}
