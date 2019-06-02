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

import java.util.ArrayList;

public class InterpreteIdDef implements Interprete {

    private int pos;
    private String repertoire;

    public InterpreteIdDef() {
    }

    public InterpreteConstants constant() {
        return null;
    }

    public int getPosition() {
        return pos;
    }

    public Object interprete(String text, int pos) throws InterpreteException {
        InterpretesBase ib;
        InterpreteIdentifier ii;
        ArrayList<Integer> p;

        ib = new InterpretesBase();
        p = new ArrayList<Integer>();
        p.add(ib.BLANK);
        p.add(ib.LEFTPARENTHESIS);
        p.add(ib.BLANK);
        ib.compile(p);

        ib.read(text, pos);
        pos = ib.getPosition();

        ii = new InterpreteIdentifier();

        String id = (String) ii.interprete(text, pos);
        pos = ii.getPosition();

        ib = new InterpretesBase();
        p = new ArrayList<Integer>();
        p.add(ib.BLANK);
        p.add(ib.RIGHTPARENTHESIS);
        p.add(ib.BLANK);
        ib.compile(p);

        ib.read(text, pos);
        pos = ib.getPosition();

        this.pos = pos;
        return id;
    }

    public void setConstant(InterpreteConstants c) {

    }

    public void setRepertoire(String r) {
        this.repertoire = r;

    }

}
