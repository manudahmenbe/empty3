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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package one.empty3.library.core.script;

import one.empty3.library.core.extra.AttracteurEtrange;

import java.util.ArrayList;

/**
 * @author Manuel
 */
public class InterpreteAttracteurEtrange implements Interprete {

    private int pos;
    private String repertoire;

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
        InterpretesBase ib = new InterpretesBase();
        ArrayList<Integer> pattern;

        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);

        ib.compile(pattern);

        ib.read(text, pos);
        pos = ib.getPosition();

        ArrayList<Integer> patternBL = new ArrayList<Integer>();
        patternBL.add(ib.BLANK);
        ArrayList<Integer> patternDEC = new ArrayList<Integer>();
        patternDEC.add(ib.DECIMAL);

        InterpretesBase ibBL = new InterpretesBase();
        InterpretesBase ibDE = new InterpretesBase();
        ibBL.compile(patternBL);
        ibDE.compile(patternDEC);
        ArrayList<Object> o = new ArrayList<Object>();

        o.add(ibDE.read(text, pos).get(0));
        pos = ibDE.getPosition();
        ibBL.read(text, pos);
        pos = ibBL.getPosition();
        ibBL = new InterpretesBase();
        ibDE = new InterpretesBase();
        ibBL.compile(patternBL);
        ibDE.compile(patternDEC);
        o.add(ibDE.read(text, pos).get(0));
        pos = ibDE.getPosition();
        ibBL.read(text, pos);
        pos = ibBL.getPosition();
        ibBL = new InterpretesBase();
        ibDE = new InterpretesBase();
        ibBL.compile(patternBL);
        ibDE.compile(patternDEC);
        o.add(ibDE.read(text, pos).get(0));
        pos = ibDE.getPosition();
        ibBL.read(text, pos);
        pos = ibBL.getPosition();
        ibBL = new InterpretesBase();
        ibDE = new InterpretesBase();
        ibBL.compile(patternBL);
        ibDE.compile(patternDEC);
        o.add(ibDE.read(text, pos).get(0));
        pos = ibDE.getPosition();
        ibBL.read(text, pos);
        pos = ibBL.getPosition();

        Double A = (Double) o.get(0);
        Double B = (Double) o.get(1);
        Double C = (Double) o.get(2);
        Double D = (Double) o.get(3);

        pattern = new ArrayList<Integer>();
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);

        ib.compile(pattern);

        ib.read(text, pos);

        this.pos = ib.getPosition();

        return new AttracteurEtrange(A, B, C, D);

    }

    @Override
    public void setConstant(InterpreteConstants c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRepertoire(String r) {
        this.repertoire = r;
    }

}
