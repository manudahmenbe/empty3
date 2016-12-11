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
package be.manudahmen.empty3;

import be.manudahmen.empty3.core.nurbs.ParametrizedCurve;
import be.manudahmen.empty3.core.nurbs.ParametrizedSurface;

import java.awt.*;

/**
 * *
 * <p>
 * Classe pour les Points à trois coordonnées de type double
 *
 * @author Manuel Dahmen
 */
public class Point3D extends Representable {

    /**
     * *
     * axe X vector
     */
    public static final Point3D X = new Point3D(1, 0, 0);
    /**
     * *
     * axe Y vector
     */
    public static final Point3D Y = new Point3D(0, 1, 0);
    /**
     * *
     * axe Z vector
     */
    public static final Point3D Z = new Point3D(0, 0, 1);
    /**
     * *
     * O0 origin
     */
    public static final Point3D O0 = new Point3D(0, 0, 0);
    /**
     * *
     * Point "Infinite" limite pour Z-Buffer
     */
    public static final Point3D INFINI = new Point3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    /**
     * *
     * Coordonnées (x,y,z) du point
     */
    public double[] x;
    /**
     * *
     * Pour le tracé de surface normale au point
     */
    protected Point3D normale;
    /**
     * *
     * id
     */
    private String id;
    private Barycentre position;

    /**
     * *
     * Constructeur Point Origine
     */
    public Point3D() {
        x = new double[3];
        x[0] = 0;
        x[1] = 0;
        x[2] = 0;
    }

    /**
     * *
     *
     * @param x0 x-coordonnée
     * @param y0 y-coordonnée
     * @param z0 z-coordonnée
     */
    public Point3D(double x0, double y0, double z0) {
        x = new double[3];
        x[0] = x0;
        x[1] = y0;
        x[2] = z0;
    }

    /**
     * *
     *
     * @param x0 x-coordonnée
     * @param y0 y-coordonnée
     * @param z0 z-coordonnée
     */
    public Point3D(double x0, double y0, double z0, ITexture t) {
        x = new double[3];
        x[0] = x0;
        x[1] = y0;
        x[2] = z0;
        texture(t);
    }

    /**
     * *
     * Initialise à partir d'un vecteur
     *
     * @param x0 coordonnées (3)
     */
    public Point3D(double[] x0, ITexture t) {
        x = x0;
        texture(t);
    }

    public Point3D(Point3D p0) {
        x = new double[3];
        x[0] = p0.getX();
        x[1] = p0.getY();
        x[2] = p0.getZ();
    }

    /**
     * *
     * Distance cartésienne entre 2 points
     *
     * @param p1 Point1
     * @param p2 Point2
     * @return
     */
    public static double distance(Point3D p1, Point3D p2) {
        return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX())
                + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY())
                + (p1.getZ() - p2.getZ()) * (p1.getZ() - p2.getZ()));
    }

    /**
     * *
     * Rotation dans un système d'axe positionné puis retour dans le système
     * d'axes d'origine
     *
     * @param axes    Matrice 3x3
     * @param origine Point d'origine du système d'axes
     * @param p       Point à déplacers
     * @return Point déplacé
     */
    public static Point3D rotation(Matrix33 axes, Point3D origine, Point3D p) {
        Point3D ret = axes.mult(p.moins(origine)).plus(origine);
        ret.texture(p.texture());
        return ret;
    }

    /**
     * @param pa Point origine
     * @param pb Point extrémité
     * @return Vecteur résultant pb-pa
     */
    public static Point3D vecteur(Point3D pa, Point3D pb) {

        return pb.plus(pa.mult(-1));
    }

    public static Point3D random(double d) {
        return new Point3D(Math.random(), Math.random(), Math.random()).norme(d);
    }

    public static Point3D r(double d) {
        return random(d);
    }

    public static Point3D random2(double d) {

        return new Point3D(((Math.random() - 0.5) * 2 * d), ((Math.random() - 0.5) * 2 * d), ((Math.random() - 0.5) * 2 * d));
    }

    @Override
    public Object clone() {
        return new Point3D(x[0], x[1], x[2]);
    }

    public double get(int i) {
        return x[i];
    }

    public double[] getDoubleArray() {
        return x;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = ID.GEN(this);
    }

    public Point3D getNormale() {
        return normale;
    }

    public void setNormale(Point3D normale) {
        this.normale = normale;
    }

    public double getX() {
        return x[0];
    }

    public void setX(double x0) {
        x[0] = x0;
    }

    public double getY() {
        return x[1];
    }

    public void setY(double x0) {
        x[1] = x0;
    }

    public double getZ() {
        return x[2];
    }

    public void setZ(double x0) {
        x[2] = x0;
    }

    @Deprecated
    public Point3D homothetie(Point3D c, double d) {
        return new Point3D(this).moins(c).mult(d).plus(c);
    }

    @Deprecated
    public Point3D homothetie(Point3D c, double d, Point3D p) {
        return new Point3D(p).moins(c).mult(d).plus(c);
    }

    public Point3D modificateurs(MODRotation r, MODTranslation t,
                                 MODHomothetie h) {
        return this;
        // return movePoint(rotation(r.matrice(), r.centre(),
        // homothetie(h.centre(), h.facteur(), (Point3D) clone())),
        // t.vecteur());
    }

    public Point3D moins(Point3D p) {
        Point3D p1 = new Point3D(this);
        p1.setX(p1.getX() - p.getX());
        p1.setY(p1.getY() - p.getY());
        p1.setZ(p1.getZ() - p.getZ());
        return p1;
    }

    @Deprecated
    public Point3D movePoint(Point3D translation) {
        return new Point3D(this).plus(translation);
    }

    @Deprecated
    public Point3D movePoint(Point3D translation, Point3D p) {
        return new Point3D(p).plus(translation);
    }

    /**
     * *
     * Multiplication
     *
     * @param xDIFF facteur
     * @return
     */
    public Point3D mult(double xDIFF) {
        Point3D p = new Point3D(this);
        p.setX(p.getX() * xDIFF);
        p.setY(p.getY() * xDIFF);
        p.setZ(p.getZ() * xDIFF);
        return p;
    }

    public Point3D mult(Point3D point3D) {
        return Matrix33.YZX.mult(Matrix33.ZXY.mult(Matrix33.XYZ.mult(point3D)));
    }

    /**
     * *
     * norme d'un vecteur (distance du point à l'origine)
     *
     * @return
     */
    public double norme() {
        return Math.sqrt((getX()) * (getX()) + (getY()) * (getY()) + (getZ())
                * (getZ()));
    }

    /**
     * *
     * "direction" (norme1)
     *
     * @return Vecteur normalisé à 1
     */
    public Point3D norme1() {
        return mult(1 / norme());
    }

    /**
     * *
     * Ajoute @param i à chaque coordonnée
     *
     * @param i
     * @return
     */
    public Point3D plus(double i) {
        Point3D p = new Point3D(this);
        p.setX(p.getX() + i);
        p.setY(p.getY() + i);
        p.setZ(p.getZ() + i);
        return p;
    }

    public Point3D plus(Point3D p) {
        Point3D p1 = new Point3D(this);
        p1.setX(p1.getX() + p.getX());
        p1.setY(p1.getY() + p.getY());
        p1.setZ(p1.getZ() + p.getZ());
        return p1;
    }

    /**
     * *
     * Produit scalaire
     *
     * @param p2
     * @return
     */
    public double prodScalaire(Point3D p2) {
        return x[0] * p2.getX() + x[1] * p2.getY() + x[2] * p2.getZ();
    }

    /**
     * *
     * produit vectoriel
     *
     * @param p1
     * @return
     */
    public Point3D prodVect(Point3D p1) {
        return new Point3D(p1.getY() * getZ() + -p1.getZ() * getY(), p1.getZ()
                * getX() - p1.getX() * getZ(), p1.getX() * getY() - p1.getY()
                * getX());
    }

    public void set(int i, double d) {
        x[i] = d;
    }

    public String toLongString() {
        //Color c = texture.toString();
        return "p ( \n\t(" + x[0] + " , " + x[1] + " , " + x[2] + " )\n\t("
                + texture.toString()
                + ")\n)\n";
    }

    @Override
    public String toString() {
        return "( " + x[0] + " , " + x[1] + " , " + x[2] + " ) ";
    }

    private Point3D norme(double d) {
        return this.norme1().mult(d);
    }

    @Override
    public boolean ISdrawStructureDrawFastIMPLEMENTED(ZBuffer z) {
        return super.ISdrawStructureDrawFastIMPLEMENTED(z); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void drawStructureDrawFast(ZBuffer z) {

        z.testPoint(this, new Color(CFAST.getColorAt(0.5, 0.5)));

    }

    public Point2D get2D() {
        return new Point2D(x[0], x[1]);
    }

    public void normalize() {
        double n = norme();
        for (int i = 0; i < x.length; i++)
            set(i, get(i) / n);
    }

    public Point2D to2DwoZ() {
        return get2D();
    }

    public double NormeCarree() {
        return x[0] * x[0] + x[1] * x[1] + x[2] + x[2];
    }

    @Override
    public Representable intersects(Representable r2) {
        if (r2 instanceof Point3D) {
            Point3D p2 = (Point3D) (r2);
            return ((x[0] == p2.get(0)) && (x[1] == p2.get(1)) && (x[2] == p2.get(2))) ? this : null;
        } else if (r2 instanceof SegmentDroite) {
            SegmentDroite sd = (SegmentDroite) r2;

        } else if (r2 instanceof TRI) {
            TRI tri = (TRI) r2;

        } else if (r2 instanceof ParametrizedSurface) {
        } else if (r2 instanceof ParametrizedCurve) {
        }
        throw new UnsupportedOperationException("Pas implémenté encore");
    }
}
