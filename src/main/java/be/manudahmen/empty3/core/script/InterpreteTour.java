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
package be.manudahmen.empty3.core.script;

import be.manudahmen.empty3.ColorFunction;
import be.manudahmen.empty3.Function;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Tour;

import java.util.ArrayList;

public class InterpreteTour implements Interprete {

    private String repertoire;
    private int pos;

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
        ArrayList<Object> objects = new ArrayList<Object>();
        InterpretePoint3D pp = new InterpretePoint3D();
        InterpretesBase ib = new InterpretesBase();
        ArrayList<Integer> pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();
        objects.add(pp.interprete(text, pos));
        pos = pp.getPosition();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.COMA);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();
        objects.add(pp.interprete(text, pos));
        pos = pp.getPosition();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.COMA);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();
        InterpreteFunction ifct = new InterpreteFunction();
        ifct.addVars("x");
        ifct.addVars("a");
        objects.add(ifct.interprete(text, pos));
        pos = ifct.getPosition();
        this.pos = pos;

        return new Tour((Point3D) objects.get(0), (Point3D) objects.get(1), (Function) objects.get(2), (ColorFunction) objects.get(3));
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
