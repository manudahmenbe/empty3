/*
 *  This file is part of Empty3.
 *
 *     Empty3 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Empty3 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Empty3.  If not, see <https://www.gnu.org/licenses/>. 2
 */

/*
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
 */
package one.empty3.library;

import one.empty3.library.core.nurbs.ParametricCurve;
import one.empty3.library.core.nurbs.ParametricSurface;

import java.awt.*;
import java.util.List;

/**
 * *
 * <p>
 * Classe pour les éléments à trois coordonnées de type Double
 * Points, Vecteur 3D et calcul
 *
 * @author Manuel Dahmen
 */
public class Point3D extends Representable {
    public Point3D() {
        super();
        coordArr.setElem(0d, 0);
        coordArr.setElem(0d, 1);
        coordArr.setElem(0d, 2);
    }

    /**
     * *
     * axe X vector
     */
    public static final Point3D X = new Point3D(1d, 0d, 0d);
    /**
     * *
     * axe Y vector
     */
    public static final Point3D Y = new Point3D(0d, 1d, 0d);
    /**
     * *
     * axe Z vector
     */
    public static final Point3D Z = new Point3D(0d, 0d, 1d);
    /**
     * *
     * O0 origin
     */
    public static final Point3D O0 = new Point3D(0d, 0d, 0d);
    /**
     * *
     * Point "Infinite" limite pour Z-Buffer
     */
    public static final Point3D INFINI = new Point3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    /**
     * *
     * Coordonnées (coordArr,y,z) du point
     */
    public StructureMatrix<Double> coordArr = new StructureMatrix<>(1, Double.class);
    /**
     * *
     * Pour le tracé de surface normale au point
     */
    protected Point3D normale;
    /**
     * *
     * id
     */

    /**
     * *
     * Constructeur Point Origine
     */
    /**
     * *
     *
     * @param x0 coordArr-coordonnée
     * @param y0 y-coordonnée
     * @param z0 z-coordonnée
     */
    public Point3D(Double x0, Double y0, Double z0) {
        this();
        coordArr.setElem(x0, 0);
        coordArr.setElem(y0, 1);
        coordArr.setElem(z0, 2);
    }

    /**
     * *
     *
     * @param x0 coordArr-coordonnée
     * @param y0 y-coordonnée
     * @param z0 z-coordonnée
     */
    public Point3D(Double x0, Double y0, Double z0, ITexture t) {
        this(x0, y0, z0);
        texture(t);
    }

    /**
     * *
     * Initialise à partir d'un vecteur
     *
     * @param x0 coordonnées (3)
     */
    public Point3D(Double[] x0, ITexture t) {
        this(x0[0], x0[1], x0[2], t);
    }

    /***
     *
     *
     * @param p0 point à copier
     */
    public Point3D(Point3D p0) {
        this();
        coordArr.setElem(p0.get(0), 0);
        coordArr.setElem(p0.get(1), 1);
        coordArr.setElem(p0.get(2), 2);
        texture(p0.texture);
    }

    public Point3D(StructureMatrix<Double> coordArr) {
        Point3D p = new Point3D(coordArr.getElem(0), coordArr.getElem(1), coordArr.getElem(2));
    }

    public static Point3D n(Double a, Double b, Double c) {
        return new Point3D(a, b, c);
    }

    /**
     * *
     * Distance cartésienne entre 2 points
     *
     * @param p1 Point1
     * @param p2 Point2
     * @return
     */
    public static Double distance(Point3D p1, Point3D p2) {
        return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX())
                + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY())
                + (p1.getZ() - p2.getZ()) * (p1.getZ() - p2.getZ()));
    }



    public static Point3D random(Double d) {
        return new Point3D(Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5).mult(d * 2);
    }

    public static Point3D r(Double d) {
        return random(d);
    }

    public static Point3D random2(Double d) {

        return new Point3D(((Math.random() - 0.5) * 2 * d), ((Math.random() - 0.5) * 2 * d), ((Math.random() - 0.5) * 2 * d));
    }

    @Override
    public Object clone() {
        return new Point3D(coordArr);
    }

    public Double get(int i) {
        if(i>=0 && i<3)
            return coordArr.getElem(i);
        return Double.NaN;
    }
    public Point3D scale() {
        if(scale==null)
        {
            return Point3D.n(1.,1.,1.);
        }
         return new Point3D (get(0)*scale.get(1),get(1)*scale.get(1),get(2)*scale.get(2));
    }

    public List<Double> getDoubleArray() {
        return coordArr.getData1d();
    }


    public Point3D getNormale() {
        return normale;
    }

    public void setNormale(Point3D normale) {
        this.normale = normale;
    }

    public Double getY() {
        return coordArr.getElem(1);
    }

    public void setY(Double x0) {
        coordArr.setElem(x0, 1);

    }
    public Double getZ() {
        return coordArr.getElem(2);
    }

    public void setZ(Double x0) {
        coordArr.setElem(x0, 2);

    }
    public Double getX() {
        return coordArr.getElem(0);
    }

    public void setX(Double x0) {
        coordArr.setElem(x0, 0);

    }




    public Point3D moins(Point3D p) {
        Point3D p1 = new Point3D(this);
        p1.setX(p1.getX() - p.getX());
        p1.setY(p1.getY() - p.getY());
        p1.setZ(p1.getZ() - p.getZ());
        return p1;
    }

    /**
     * *
     * Multiplication
     *
     * @param xFactor facteur
     * @return
     */
    public Point3D mult(Double xFactor) {
        Point3D p = new Point3D(this);
        p.setX(p.getX() * xFactor);
        p.setY(p.getY() * xFactor);
        p.setZ(p.getZ() * xFactor);
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
    public Double norme() {
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
    public Point3D plus(Double i) {
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
    public Double prodScalaire(Point3D p2) {
        if(p2!=null) {
            return coordArr.getElem(0) * p2.getX() + coordArr.getElem(1) * p2.getY() + coordArr.getElem(2) * p2.getZ();
        }
        else
            throw new NullPointerException("Exception prodScalre p2==null");
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

    public void set(int i, Double d) {
        coordArr.setElem(d, i);

    }

    public String toLongString() {
        //Color c = texture.toString();
        return "p ( \n\t(" + coordArr.getElem(0) + " , " + coordArr.getElem(1)+ " , " + coordArr.getElem(2)+ " )\n\t("
                + texture.toString()
                + ")\n)\n";
    }

    @Override
    public String toString() {
        return "\n\tp3( " + (Double) (coordArr.getElem(0)) + " , " + (Double) (coordArr.getElem(1)) + " , " + (Double) (coordArr.getElem(2)) + " ) ";
    }

    private Point3D norme(Double d) {
        return this.norme1().mult(d);
    }

    @Override
    public boolean ISdrawStructureDrawFastIMPLEMENTED(ZBuffer z) {
        return super.ISdrawStructureDrawFastIMPLEMENTED(z); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void drawStructureDrawFast(ZBuffer z) {

        z.testDeep(this, new Color(CFAST.getColorAt(0.5, 0.5)));

    }

    public Point2D get2D() {
        return new Point2D(coordArr.getElem(0), coordArr.getElem(1));
    }

    public void normalize() {
        Double n = norme();
        for (int i = 0; i < coordArr.getData1d().size(); i++)
            set(i, get(i) / n);
    }

    public Point2D to2DwoZ() {
        return get2D();
    }

    public Double NormeCarree() {
        return coordArr.getElem(0)* coordArr.getElem(0)+ coordArr.getElem(1)* coordArr.getElem(1)+ coordArr.getElem(2)* coordArr.getElem(2);
    }

    @Override
    public Representable intersects(Representable r2) {
        if (r2 instanceof Point3D) {
            Point3D p2 = (Point3D) (r2);
            return ((coordArr.getElem(0) == p2.get(0)) && (coordArr.getElem(1) == p2.get(1)) && (coordArr.getElem(2) == p2.get(2))) ? this : null;
        } else if (r2 instanceof LineSegment) {
            LineSegment sd = (LineSegment) r2;

        } else if (r2 instanceof TRI) {
            TRI tri = (TRI) r2;

        } else if (r2 instanceof ParametricSurface) {
        } else if (r2 instanceof ParametricCurve) {
        }
        throw new UnsupportedOperationException("Pas implémenté encore");
    }


    public Point3D changeTo(Point3D dst) {
        this.coordArr.reset();
        for (int i = 0; i < 3; i++)
            this.coordArr.add(1, dst.coordArr.getElem(i));
        texture(dst.texture());
        return this;
    }

    public static Point3D n(double i, double i1, double i2) {
        return new Point3D(i, i1, i2);
    }

    public double getLength() {
        return norme();
    }


    public class P extends Point3D {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D)) return false;

        Point3D point3D = (Point3D) o;

        if(point3D.coordArr.data1d.size()!=3)
            return false;
        if(this.coordArr.data1d.size()!=3)
            return false;
        for(int i=0; i<3; i++)
            if(!coordArr.getElem(i).equals(point3D.get(i)))
                return false;

        return true;
    }


    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("coordArr/coordonnées", coordArr);
    }


    public StructureMatrix<Double> getCoordArr() {
        return coordArr;
    }

    public void setCoordArr(StructureMatrix<Double> coordArr) {
        this.coordArr = coordArr;
    }

    public Point3D calculerPoint0dT(double t) {
        return this;
    }

}
