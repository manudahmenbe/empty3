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

public class TRI extends Representable {

    private StructureMatrix<Point3D> sommet= new StructureMatrix<>(1, Point3D.class);

    public TRI() {
        super();
        sommet.add(1, Point3D.O0);
        sommet.add(1, Point3D.O0);
        sommet.add(1, Point3D.O0);
    }

    public TRI(Point3D coordPoint3D, Point3D coordPoint3D0, Point3D coordPoint3D1) {
        this(coordPoint3D, coordPoint3D0, coordPoint3D1, Color.black);
    }

    public TRI(Point3D point3d, Point3D point3d2, Point3D point3d3,
               Color red) {
        sommet.add(1,point3d);
        sommet.add(1,point3d2);
        sommet.add(1,point3d3);
        this.texture(new TextureCol(red));
    }

    public TRI(Point3D point3d, Point3D point3d2, Point3D point3d3,
               ITexture red) {
        sommet.add(1,point3d);
        sommet.add(1,point3d2);
        sommet.add(1,point3d3);
        this.texture = red;
    }

    public TRI(Point3D[] s, Color c) {
        this(s[0], s[1], s[2], c);
    }

    public TRI(Point3D[] s, ITexture c) {
        this(s[0], s[1], s[2], c);
    }


    public StructureMatrix<Point3D> getSommet() {
        return sommet;
    }

    public void setSommet(Point3D[] sommet) {
        this.sommet.setAll(sommet);
    }

    public Point3D normale() {
        return sommet.getElem(2).moins(sommet.getElem(0)).prodVect(sommet.getElem(1).moins(sommet.getElem(0)));
    }


    public void setCouleur(Color couleur) {
        this.texture(new TextureCol(couleur));

    }

    @Override
    public String toString() {
        String t = "tri (";
        for (int i = 0; i < 3; i++) {
            t += "\n\t\t(" + sommet.getElem(0).getX() + ", " + sommet.getElem(1).getY() + ", " + sommet.getElem(2).getZ() + "), ";
        }
        return t + "\n\t\t(" + texture.toString() + ")\n\t)\n";
    }

    @Override
    public Intersects.Intersection intersects(RtRay ray, RtIntersectInfo cii) {
        // TODO Implements
        return null;
    }

    public Point3D getCentre() {
        return getSommet().getElem(0).plus(getSommet().getElem(1)).plus(getSommet().getElem(2).mult(1 / 3d));
    }

    public int intersects(TRI tri2) {


        return TRI_Collide.tr_tri_intersect3D(getCentre(), getSommet().getElem(0), getSommet().getElem(1),
                tri2.getCentre(), tri2.getSommet().getElem(0), tri2.getSommet().getElem(1));
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("sommet/points sommets du triangle",sommet);

    }
}
