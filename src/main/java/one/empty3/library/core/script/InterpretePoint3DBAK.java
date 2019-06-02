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

import one.empty3.library.*;

import java.util.ArrayList;

public class InterpretePoint3DBAK implements Interprete {

    private String repertoire;
    private InterpreteConstants c;
    private int pos;

    @Override
    public InterpreteConstants constant() {
        return c;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public Object interprete(String point, int pos) throws InterpreteException {
        InterpretesBase ib = new InterpretesBase();
        ArrayList<Integer> pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);
        pattern.add(ib.DECIMAL);
        pattern.add(ib.BLANK);
        pattern.add(ib.COMA);
        pattern.add(ib.BLANK);
        pattern.add(ib.DECIMAL);
        pattern.add(ib.BLANK);
        pattern.add(ib.COMA);
        pattern.add(ib.BLANK);
        pattern.add(ib.DECIMAL);
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);

        ib.compile(pattern);
        ArrayList<Object> os = ib.read(point, pos);
        this.pos = ib.getPosition();

        return new Point3D((Double) os.get(3), (Double) os.get(7),
                (Double) os.get(11));
    }

    @Override
    public void setConstant(InterpreteConstants c) {
        this.c = c;
    }

    @Override
    public void setRepertoire(String r) {
        this.repertoire = r;
    }

}
