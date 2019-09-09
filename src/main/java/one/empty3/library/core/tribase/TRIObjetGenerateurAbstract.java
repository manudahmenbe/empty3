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
 * 2014 Manuel Dahmen
 */
package one.empty3.library.core.tribase;


import one.empty3.library.*;

import java.awt.*;
import java.awt.Point;
import java.util.List;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         15 oct. 2011
 */
public class TRIObjetGenerateurAbstract extends Representable implements TRIObjetGenerateur {
    // Overrides from TriObjetGenerateur
    /**
     *
     */


    private static final long serialVersionUID = 1L;
    protected StructureMatrix<Integer> maxX = new StructureMatrix<>(0);
    protected StructureMatrix<Integer> maxY = new StructureMatrix<>(0);
    protected StructureMatrix<Boolean> cx = new StructureMatrix<>(0);
    protected StructureMatrix<Boolean> cy = new StructureMatrix<>(0);
    public TRIObjetGenerateurAbstract()
    {
        maxX.setElem(30);
        maxY.setElem(30);
        cx.setElem(false);
        cy.setElem(false);
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("maxX/ MaxX cordinates iterations for drawing - disable", maxX);
        getDeclaredDataStructure().put("maxY/ MaxY cordinates iterations for drawing - disable", maxY);
        getDeclaredDataStructure().put("cx/ Circulaire X last iterations for drawing - disable", cx);
        getDeclaredDataStructure().put("cy/ Circulaire X last iterations for drawing - disable", cy);
    }
    @Override
    public int getMaxX() {
        return maxX.data0d;
    }

    @Override
    public void setMaxX(int maxX) {
        this.maxX.setElem( maxX);
    }

    @Override
    public int getMaxY() {
        return maxY.data0d;
    }

    @Override
    public void setMaxY(int maxY) {
        this.maxY.setElem( maxY);
    }

    @Override
    public boolean getCirculaireX() {
        return cx.data0d;
    }

    @Override
    public void setCirculaireX(boolean cx) {
        this.cx.setElem( cx);
    }

    @Override
    public boolean getCirculaireY() {
        return cy.data0d;
    }

    @Override
    public void setCirculaireY(boolean cy) {
        this.cy.setElem(cy);
    }

    @Override
    public Point3D coordPoint3D(int x, int y)
    {
        return null;
    }

    /**
     * *
     *
     * @param numX num�ro de valeur de coordArr par rapport � maxX
     * @param numY num�ro de valeur de y par rapport � maxY
     * @param tris TRI[1] = ((coordArr,y),(coordArr+1,y),(coordArr+1,y+1)) TRI[2] =
     *             ((coordArr,y),(coordArr,y+1),(coordArr+1,y+1))
     */
    public void getTris(int numX, int numY, TRI[] tris) {
        int nextX = numX + 1;
        int nextY = numY + 1;
        if ((numX >= maxX.getElem() - 1) && cx.getElem()) {
            nextX = 0;
        }
        if ((numY >= maxY.getElem() - 1) && cy.getElem()) {
            nextY = 0;
        }

        for (int t = 0; t < 2; t++) {
            tris[t] = new TRI();
            if (t == 0) {
                tris[t].setSommet(new Point3D[]{
                        position().calculer(coordPoint3D(numX, numY)),
                        position().calculer(coordPoint3D(nextX, numY)),
                        position().calculer(coordPoint3D(nextX, nextY))});
            } else {
                tris[t].setSommet(new Point3D[]{
                        position().calculer(coordPoint3D(numX, nextY)),
                        position().calculer(coordPoint3D(numX, numY)),
                        position().calculer(coordPoint3D(nextX, nextY))});
            }

            tris[t].
                    texture(
                            texture);

            Point3D normale = tris[t].getSommet().getElem(1).moins(
                    tris[t].getSommet().getElem(0).prodVect(
                    (tris[t].getSommet().getElem(2).moins(tris[t].getSommet().getElem(0)))));
            for (int i = 0; i < 3; i++) {
                tris[t].getSommet().getElem(i).setNormale(normale);
            }

        }
    }

    /***
     * Method for interpolate cordinates
     * and textures.
     *
     * @param tris
     * @param numX
     * @param numY
     * @param ratioX
     * @param ratioY
     * @return
     */
    @Override
    public Point3D getPoint3D(TRI[] tris, int numX, int numY, double ratioX,
                              double ratioY) {
        if (ratioX > ratioY) {
            java.util.List<Point3D> sommet = tris[0].getSommet().getData1d();
            Point3D ret = sommet.get(0).plus(
                    sommet.get(1).moins(sommet.get(0)).mult(ratioX)).plus(
                    sommet.get(2).moins(sommet.get(1)).mult(ratioY));
            if (texture() == null) texture = new TextureCol(new Color(255, 128, 0));
            ret.texture(new TextureCol(texture.getMaillageTexturedColor(numX, numY,
                    ((numX + ratioX) / maxX.data0d), ((numY + ratioY) / maxY.data0d))));

            ret.setNormale((tris[0].getSommet().getElem(1).moins(tris[0].getSommet().getElem(0))).prodVect((tris[0]
                    .getSommet().getElem(2).moins(tris[0].getSommet().getElem(0)))));

            return ret;
        } else {
            List<Point3D> sommet = tris[1].getSommet().getData1d();
            if (texture() == null) texture = new TextureCol(new Color(255, 128, 0));
            Point3D ret = sommet.get(1).plus(
                    sommet.get(0).moins(sommet.get(1)).mult(ratioY)).plus(
                    sommet.get(2).moins(sommet.get(0)).mult(ratioX));
            ret.texture(new TextureCol(texture.getMaillageTexturedColor(numX, numY,
                    ((numX + ratioX) / maxX.data0d), ((numY + ratioY) / maxY.data0d))));

            ret.setNormale((tris[1].getSommet().getElem(1).moins(tris[1].getSommet().getElem(0)).prodVect((tris[1]
                    .getSommet().getElem(2).moins(tris[1].getSommet().getElem(0))))));

            return ret;
        }
    }

    /***
     * Draws in Image with ZBuffer 2D drawing class
     * <p>
     * Ce serait mieux de calculer les points avec
     * des couleurs.. Bien oui c'est encore TODO
     *
     * @param z
     */
    public void draw(ZBuffer z) {
        Point3D INFINI = new Point3D(0d, 0d, 10000d, new TextureCol(Color.BLUE));
        TRI[] tris = new TRI[2];
        tris[0] = new TRI(INFINI, INFINI, INFINI);
        tris[1] = new TRI(INFINI, INFINI, INFINI);
        int borneX = getMaxX();
        int borneY = getMaxY();
        if (getCirculaireX()) {
            borneX++;
        }
        if (getCirculaireY()) {
            borneY++;
        }
        for (int numX = 0; numX < borneX; numX++) {
            for (int numY = 0; numY < borneY; numY++) {
                try {
                    getTris(numX, numY, tris);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    //Exception may occur here'
                }
                boolean drop = false;
                double incrMax = 1;
                for (int t = 0; t < 2; t++) {
                    for (int c = 0; c < 3; c++) {
                        Point p1 = z.coordonneesPoint2D(tris[t]
                                .getSommet().getElem(c));
                        Point p2 = z.coordonneesPoint2D(tris[t]
                                .getSommet().getElem((c + 1) % 3));
                        if (p1 != null & p2 != null) {
                            double incr = 1.0 / (Math
                                    .abs(p1.getX() - p2.getX()) + Math.abs(p1
                                    .getY() - p2.getY()));
                            if (incr < incrMax) {
                                incrMax = incr;
                            }
                        } else {
                            drop = true;
                        }
                    }

                }
                for (double rx = 0; rx < 1.0; rx += incrMax) {
                    for (double ry = 0; ry < 1.0; ry += incrMax) {
                        z.testDeep(getPoint3D(tris, numX, numY, rx,
                                ry));
                    }
                }
            }

        }
    }

}
