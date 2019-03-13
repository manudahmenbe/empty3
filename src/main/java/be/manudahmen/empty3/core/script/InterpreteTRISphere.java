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

import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.util.ArrayList;

/**
 * @author DAHMEN Manuel
 *         <p>
 *         dev
 * @date 23-mars-2012
 */
public class InterpreteTRISphere implements Interprete {

    private String repertoire;

    private int pos;

    public InterpreteConstants constant() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getPosition() {
        return pos;
    }

    public Object interprete(String text, int pos) throws InterpreteException {
        Point3D ps = null;

        InterpretesBase ib = new InterpretesBase();
        ArrayList<Integer> pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();

        InterpretePoint3D pp = new InterpretePoint3D();
        ps = (Point3D) pp.interprete(text, pos);
        pos = pp.getPosition();

        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        ib = new InterpretesBase();
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();

        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.DECIMAL);
        pattern.add(ib.BLANK);
        ib = new InterpretesBase();
        ib.compile(pattern);
        Double r = (Double) ib.read(text, pos).get(1);
        pos = ib.getPosition();

        TextureCol tc = null;

        InterpreteTColor tci = new InterpreteTColor();

        tci.setRepertoire(repertoire);

        tc = (TextureCol) tci.interprete(text, pos);

        pos = tci.getPosition();

        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib = new InterpretesBase();
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();

        this.pos = pos;

        TRISphere s = new TRISphere(ps, r);

        s.texture(tc);

        return s;
    }

    public void setConstant(InterpreteConstants c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRepertoire(String r) {
        this.repertoire = r;
    }

}
