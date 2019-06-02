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
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package one.empty3.library.core.script;

import one.empty3.library.Point3D;
import one.empty3.library.TextureCol;
import one.empty3.library.core.nurbs.NurbsSurface;

import java.util.ArrayList;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class InterpreteNurbs implements Interprete {

    private int position;

    public InterpreteConstants constant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPosition() {
        return position;

    }

    public Object interprete(String text, int pos) throws InterpreteException {
        NurbsSurface nurbs = new NurbsSurface();

        /**
         * ( m n (
         */
        InterpretesBase ib;
        ArrayList<Integer> pattern;

        pattern = new ArrayList<Integer>();
        ib = new InterpretesBase();

        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);
        pattern.add(ib.INTEGER);
        pattern.add(ib.INTEGER);
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);

        ib.compile(pattern);

        ArrayList<Object> o = ib.read(text, pos);
        pos = ib.getPosition();

        Integer m = (Integer) o.get(3);
        Integer n = (Integer) o.get(4);

        /**
         * *
         * Tableau de points3D et poids;
         */
        Point3D[][] points = new Point3D[m][n];
        double[][] poids = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                InterpretePoint3D ip = new InterpretePoint3D();

                Point3D p = (Point3D) ip.interprete(text, pos);
                pos = ip.getPosition();

                pattern = new ArrayList<Integer>();
                ib = new InterpretesBase();

                pattern.add(ib.BLANK);
                pattern.add(ib.DECIMAL);
                pattern.add(ib.BLANK);

                ib.compile(pattern);

                Double poi = (Double) ib.read(text, pos).get(1);
                pos = ib.getPosition();

                poids[i][j] = poi;

                points[i][j] = p;
            }
        }
        InterpreteTColor itc = new InterpreteTColor();

        TextureCol tc = (TextureCol) itc.interprete(text, pos);
        pos = itc.getPosition();

        nurbs.setMaillage(points, poids);

        /**
         * )
         */
        pattern = new ArrayList<Integer>();
        ib = new InterpretesBase();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);

        ib.compile(pattern);

        ib.read(text, pos);
        pos = ib.getPosition();

        /**
         * i j (
         */
        //nurbs.texture(tc);
        pattern = new ArrayList<Integer>();
        ib = new InterpretesBase();
        pattern.add(ib.BLANK);
        pattern.add(ib.INTEGER);
        pattern.add(ib.BLANK);
        pattern.add(ib.INTEGER);
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);

        ib.compile(pattern);
        ArrayList<Object> read = ib.read(text, pos);
        pos = ib.getPosition();

        Integer k = (Integer) read.get(1);
        Integer l = (Integer) read.get(3);

        double[][] T = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {

                pattern = new ArrayList<Integer>();
                ib = new InterpretesBase();

                pattern.add(ib.BLANK);
                pattern.add(ib.DECIMAL);
                pattern.add(ib.BLANK);

                ib.compile(pattern);

                Double Tij = (Double) ib.read(text, pos).get(1);
                pos = ib.getPosition();

                T[k][l] = Tij;

            }
        }

        nurbs.setReseauFonction(T);

        /**
         * )
         */
        pattern = new ArrayList<Integer>();
        ib = new InterpretesBase();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);

        ib.compile(pattern);

        ib.read(text, pos);
        pos = ib.getPosition();

        /**
         * *
         * )
         */
        pattern = new ArrayList<Integer>();
        ib = new InterpretesBase();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);

        ib.compile(pattern);

        ib.read(text, pos);
        pos = ib.getPosition();

        nurbs.creerNurbs();

        this.position = pos;

        return nurbs;
    }

    public void setConstant(InterpreteConstants c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRepertoire(String r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
