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

import be.manudahmen.empty3.PlaceSurMatrice;
import be.manudahmen.empty3.Representable;

import java.util.ArrayList;

public class InterpreteMatricePlan33 implements Interprete {

    @Override
    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPosition() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Representable interprete(String text, int pos) throws InterpreteException {
        InterpretesBase ib;
        InterpretePoint3D ip3;
        ArrayList<Integer> p = new ArrayList<Integer>();

        ib = new InterpretesBase();

        p.add(ib.BLANK);
        p.add(ib.LEFTPARENTHESIS);
        p.add(ib.BLANK);

        ib.compile(p);

        ib.read(text, pos);

        pos = ib.getPosition();

        // (DIMX DIMY)
        ib = new InterpretesBase();

        p.add(ib.BLANK);
        p.add(ib.INTEGER);
        p.add(ib.BLANK);
        p.add(ib.INTEGER);
        p.add(ib.BLANK);

        ib.compile(p);

        ArrayList<Object> o = ib.read(text, pos);

        int m = (Integer) o.get(1);
        int n = (Integer) o.get(3);

        pos = ib.getPosition();

        /**
         * Interprete le reste
         */
        ib = new InterpretesBase();

        p.add(ib.BLANK);
        p.add(ib.RIGHTPARENTHESIS);
        p.add(ib.BLANK);

        ib.compile(p);

        ib.read(text, pos);

        pos = ib.getPosition();

        PlaceSurMatrice psm = new PlaceSurMatrice(m, n);

        return psm;
    }

    @Override
    public void setConstant(InterpreteConstants c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRepertoire(String r) {
        // TODO Auto-generated method stub

    }
}
