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

package be.manudahmen.empty3.core.script;

import be.manudahmen.empty3.Barycentre;
import be.manudahmen.empty3.Matrix33;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Representable;

import java.util.ArrayList;

public class InterpreteHomothetie implements Interprete {

    private String rep;
    private Representable r;
    private int position;

    @Override
    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        Barycentre positionObject = new Barycentre();

        InterpretesBase ib;
        ArrayList<Integer> pattern;

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.AROBASE);

        ib.compile(pattern);

        ArrayList<Object> o = ib.read(text, pos);

        if (o.size() == 1) {
            InterpretePoint3D ip3 = new InterpretePoint3D();

            Point3D p = (Point3D) ip3.interprete(text, pos);

            positionObject.position = p;
        }

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.MULTIPLICATION);
        pattern.add(ib.DECIMAL);

        ib.compile(pattern);

        o = ib.read(text, pos);

        if (o.size() == 2) {
            double m = (Double) o.get(1);

            positionObject.agrandissement = m;
        }

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.PERCENT);

        ib.compile(pattern);

        o = ib.read(text, pos);

        if (o.size() == 1) {
            InterpreteMatrix33 im33 = new InterpreteMatrix33();

            Matrix33 m33 = (Matrix33) im33.interprete(text, pos);

            positionObject.rotation = m33;
        }
        this.position = pos;

        return positionObject;
    }

    @Override
    public void setConstant(InterpreteConstants c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRepertoire(String r) {
        this.rep = r;

    }

    public void setRepresentable(Representable r) {
        this.r = r;
    }

}
