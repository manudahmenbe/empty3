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

import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.tribase.Plan3D;

import java.util.ArrayList;

/**
 * @author DAHMEN Manuel
 *         <p>
 *         dev
 * @date 22-mars-2012
 */
public class InterpretePlan3D implements Interprete {

    private int position;
    private String repertoire;

    public InterpreteConstants constant() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getPosition() {
        return position;
    }

    public Object interprete(String text, int pos) throws InterpreteException {
        Plan3D plan = new Plan3D();
        InterpretesBase ib = null;
        ArrayList<Integer> pattern;
        InterpretePoint3D pp;
        InterpreteTColor is;
        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();
        pp = new InterpretePoint3D();
        plan.pointOrigine((Point3D) pp.interprete(text, pos));
        pos = pp.getPosition();
        pp = new InterpretePoint3D();
        plan.pointXExtremite((Point3D) pp.interprete(text, pos));
        pos = pp.getPosition();
        pp = new InterpretePoint3D();
        plan.pointYExtremite((Point3D) pp.interprete(text, pos));
        pos = pp.getPosition();
        is = new InterpreteTColor();
        is.setRepertoire(repertoire);

        ColorTexture tc = (ColorTexture) is.interprete(text, pos);
        plan.texture(tc);
        pos = is.getPosition();

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();

        this.position = pos;
        return plan;
    }

    public void setConstant(InterpreteConstants c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRepertoire(String r) {
        this.repertoire = r;
    }
}
