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

import java.util.ArrayList;

public class InterpretePosition implements Interprete {

    private String repertoire;
    private int pos;

    public InterpretePosition() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        InterpretesBase bo;
        ArrayList<Integer> pattern;
        InterpretePoint3D bp;
        InterpreteMatrix33 bm;

        bo = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(bo.BLANK);
        pattern.add(bo.LEFTPARENTHESIS);
        pattern.add(bo.BLANK);
        pattern.add(bo.AROBASE);
        pattern.add(bo.BLANK);
        bo.compile(pattern);

        ArrayList<Object> os = bo.read(text, pos);

        pos = bo.getPosition();

        InterpreteIdentifier bi;
        bi = new InterpreteIdentifier();
        try {
            bi.interprete(text, pos);
            pos = bi.getPosition();
        } catch (InterpreteException ex) {

        }

        bp = new InterpretePoint3D();
        Point3D p = (Point3D) bp.interprete(text, pos);

        pos = bp.getPosition();

        bo = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(bo.BLANK);
        pattern.add(bo.MULTIPLICATION);
        pattern.add(bo.BLANK);
        bo.compile(pattern);

        os = bo.read(text, pos);
        pos = bo.getPosition();

        bi = new InterpreteIdentifier();
        try {
            bi.interprete(text, pos);
            pos = bi.getPosition();
        } catch (InterpreteException ex) {

        }
        bm = new InterpreteMatrix33();
        Matrix33 m = (Matrix33) bm.interprete(text, pos);
        pos = bm.getPosition();

        bo = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(bo.BLANK);
        pattern.add(bo.MULTIPLICATION);
        pattern.add(bo.BLANK);
        pattern.add(bo.DECIMAL);
        pattern.add(bo.BLANK);
        pattern.add(bo.RIGHTPARENTHESIS);
        pattern.add(bo.BLANK);
        bo.compile(pattern);

        os = bo.read(text, pos);

        Double d = (Double) os.get(3);

        pos = bo.getPosition();

        this.pos = pos;

        Barycentre po = new Barycentre();

        po.position = p;
        po.rotation = m;
        po.agrandissement = d;
        return po;
    }

    @Override
    public void setConstant(InterpreteConstants c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRepertoire(String r) {
        this.repertoire = r;
    }

}
