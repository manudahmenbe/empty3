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
package one.empty3.library.core.script;

import one.empty3.library.Point3D;
import one.empty3.library.core.tribase.Tubulaire;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class InterpreteTubulaire implements Interprete {

    private String repertoire;
    private int pos = 0;

    @Override
    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPosition() {
        // TODO Auto-generated method stub
        return pos;
    }

    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        try {
            ArrayList<Point3D> points = new ArrayList<Point3D>();

            InterpretesBase ib = null;
            ArrayList<Integer> pattern = null;
            InterpreteListePoints ilp = null;
            InterpreteCouleur pc = null;

            ib = new InterpretesBase();
            pattern = new ArrayList<Integer>();
            pattern.add(ib.BLANK);
            pattern.add(ib.LEFTPARENTHESIS);
            pattern.add(ib.BLANK);
            ib.compile(pattern);
            ib.read(text, pos);
            pos = ib.getPosition();

            ilp = new InterpreteListePoints();
            points = (ArrayList<Point3D>) ilp.interprete(text, pos);
            pos = ilp.getPosition();

            ib = new InterpretesBase();
            pattern = new ArrayList<Integer>();
            pattern.add(ib.BLANK);
            pattern.add(ib.DECIMAL);
            pattern.add(ib.BLANK);
            ib.compile(pattern);
            ArrayList<Object> os = ib.read(text, pos);
            pos = ib.getPosition();

            double radius = (Double) os.get(1);

            pc = new InterpreteCouleur();
            Color c = (Color) pc.interprete(text, pos);
            pos = pc.getPosition();

            ib = new InterpretesBase();
            pattern = new ArrayList<Integer>();
            pattern.add(ib.BLANK);
            pattern.add(ib.RIGHTPARENTHESIS);
            pattern.add(ib.BLANK);
            ib.compile(pattern);
            ib.read(text, pos);
            pos = ib.getPosition();

            this.pos = pos;

            Tubulaire t = new Tubulaire();
            t.couleur(c);
            t.radius(radius);
            Iterator<Point3D> it = points.iterator();
            while (it.hasNext()) {
                t.add(it.next());
            }

            return t;
        } catch (NullPointerException ex) {
            throw new InterpreteException(ex);
        }
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
