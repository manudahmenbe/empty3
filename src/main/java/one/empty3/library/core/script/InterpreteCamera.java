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
package one.empty3.library.core.script;

import one.empty3.library.*;
import one.empty3.library.*;

import java.util.ArrayList;

/**
 * @author Manuel DAHMEN @date
 */
public class InterpreteCamera implements Interprete {

    private int pos;

    @Override
    public InterpreteConstants constant() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        Camera camera = new Camera();

        InterpretesBase ib = null;
        ArrayList<Integer> pattern = null;

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();

        InterpretePoint3D pp = new InterpretePoint3D();
        Point3D cpos = (Point3D) pp.interprete(text, pos);
        pos = pp.getPosition();

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();

        pp = new InterpretePoint3D();
        Point3D lookat = (Point3D) pp.interprete(text, pos);
        pos = pp.getPosition();

        double ax;
        double ay;

        try {
            ib = new InterpretesBase();
            pattern = new ArrayList<Integer>();
            pattern.add(ib.BLANK);
            pattern.add(ib.DECIMAL);
            pattern.add(ib.BLANK);
            pattern.add(ib.DECIMAL);
            pattern.add(ib.BLANK);
            ib.compile(pattern);
            ArrayList<Object> a = ib.read(text, pos);

            ax = (Double) a.get(1);
            ay = (Double) a.get(3);

            camera = new Camera(cpos, lookat);
            camera.angleXY(ax, ay);
            pos = ib.getPosition();
        } catch (InterpreteException ex) {
            camera = new Camera(cpos, lookat);
        }

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();

        this.pos = pos;
        return camera;
    }

    @Override
    public void setConstant(InterpreteConstants c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRepertoire(String r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
