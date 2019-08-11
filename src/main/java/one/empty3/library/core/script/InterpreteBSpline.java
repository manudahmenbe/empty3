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
import one.empty3.library.core.nurbs.BSpline;

import java.util.ArrayList;

public class InterpreteBSpline implements Interprete {

    private String repertoire;
    private int pos = 0;
    private int numPoints = 0;

    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }

    public int getPosition() {
        return pos;
    }

    public Object interprete(String text, int pos) throws InterpreteException {
        BSpline b = new BSpline();

        InterpretesBase ib = new InterpretesBase();
        ArrayList<Integer> pattern;
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();


        ArrayList<Double> T = new ArrayList<>();
        boolean ok = true;
        while (ok) {
            InterpretePoint3D ifa = new InterpretePoint3D();
            try {
                Point3D p = (Point3D) ifa.interprete(text, pos);
                pos = ifa.getPosition();

               b.add(p);
                if(ifa.getPosition() > pos) {
                    pos = ifa.getPosition();
                    numPoints++;
                }
            } catch (Exception ex) {
                ok = false;
            }
        }
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();


        ok = true;
        while (ok) {
            try {
            InterpreteDouble ida = new InterpreteDouble();
            Double d = (Double) ida.interprete(text, pos);
            pos = ida.getPosition();
            b.getT().add(d);
        } catch (Exception ex) {
            ok = false;
        }
        }


        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        this.pos = ib.getPosition();
        return b;
    }

    public void setConstant(InterpreteConstants c) {
        // TODO Auto-generated method stub

    }

    public void setRepertoire(String r) {
        this.repertoire = r;
    }
}
