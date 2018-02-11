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
/**
 *
 */
package be.manudahmen.empty3.core.script;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.extra.SimpleSphere;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         21 oct. 2011
 */
public class InterpreteSimpleSphere implements Interprete {

    private String repertoire;
    private int pos;
    /* (non-Javadoc)
     * @see be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#constant()
     */

    @Override
    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }
    /* (non-Javadoc)
     * @see be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#getPosition()
     */

    @Override
    public int getPosition() {
        // TODO Auto-generated method stub
        return pos;
    }

    /* (non-Javadoc)
     * @see be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#interprete(java.lang.String, int)
     */
    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        Point3D c = null;
        double r = 1;
        Color col = Color.black;

        InterpretesBase ib;
        InterpretePoint3DBAK ip;
        InterpreteCouleur pc;
        ArrayList<Integer> patt = null;

        ib = new InterpretesBase();
        patt = new ArrayList<Integer>();
        patt.add(ib.BLANK);
        patt.add(ib.LEFTPARENTHESIS);
        patt.add(ib.BLANK);
        ib.compile(patt);

        ib.read(text, pos);
        pos = ib.getPosition();

        ip = new InterpretePoint3DBAK();
        c = (Point3D) ip.interprete(text, pos);
        pos = ip.getPosition();

        ib = new InterpretesBase();
        patt = new ArrayList<Integer>();
        patt.add(ib.BLANK);
        patt.add(ib.DECIMAL);
        patt.add(ib.BLANK);
        ib.compile(patt);

        ib.read(text, pos);
        pos = ib.getPosition();
        r = (Double) ib.get().get(1);

        pc = new InterpreteCouleur();
        col = (Color) pc.interprete(text, pos);
        pos = pc.getPosition();

        ib = new InterpretesBase();
        patt = new ArrayList<Integer>();
        patt.add(ib.BLANK);
        patt.add(ib.RIGHTPARENTHESIS);
        patt.add(ib.BLANK);
        ib.compile(patt);

        ib.read(text, pos);
        pos = ib.getPosition();

        this.pos = pos;
        return new SimpleSphere(c, r, col);
    }

    /* (non-Javadoc)
     * @see be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#setConstant(be.ibiiztera.md.pmatrix.pushmatrix.scripts.InterpreteConstants)
     */
    @Override
    public void setConstant(InterpreteConstants c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRepertoire(String r) {
        this.repertoire = r;
    }

}
