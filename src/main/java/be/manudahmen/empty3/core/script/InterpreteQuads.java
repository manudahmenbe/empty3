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
package be.manudahmen.empty3.core.script;

import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Quads;

import java.util.ArrayList;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class InterpreteQuads implements Interprete {

    private int pos;

    public InterpreteConstants constant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPosition() {
        return pos;
    }

    public Object interprete(String text, int pos) throws InterpreteException {
        Quads quads = new Quads();

        InterpretesBase ib;
        ArrayList<Integer> pattern;

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);
        pattern.add(ib.INTEGER);
        pattern.add(ib.BLANK);
        pattern.add(ib.INTEGER);
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);

        ib.compile(pattern);
        ArrayList<Object> read = ib.read(text, pos);
        pos = ib.getPosition();
        Integer m = (Integer) read.get(3);
        Integer n = (Integer) read.get(5);

        Point3D[][] points = new Point3D[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                InterpretePoint3D ipp = new InterpretePoint3D();

                points[i][j] = (Point3D) ipp.interprete(text, pos);

                pos = ipp.getPosition();
            }
        }

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();

        InterpreteTColor itc = new InterpreteTColor();
        TextureCol tc = (TextureCol) itc.interprete(text, pos);
        pos = itc.getPosition();

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();

        quads.setMatrix(points);

        quads.texture(tc);

        this.pos = pos;

        return quads;
    }

    public void setConstant(InterpreteConstants c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRepertoire(String r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
