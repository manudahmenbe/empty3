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

import be.manudahmen.empty3.ECBufferedImage;

import java.util.ArrayList;

public class InterpretePGM implements Interprete {

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
    public Object interprete(String text, int pos) throws InterpreteException {
        ECBufferedImage ec;

        InterpretesBase ib = new InterpretesBase();
        ArrayList<Integer> p = new ArrayList<Integer>();
        p.add(ib.BLANK);
        ib.compile(p);

        ib.read(text, pos);
        pos = ib.getPosition();

        if ("P3\n".equals(text.substring(pos, pos + 2))) {
            pos += "P3\n".length();
        } else {
            return null;
        }
        while ("#".equals(text.substring(pos, 1))) {
            pos = text.indexOf("\n", pos) + 1;

        }

        Integer x = Integer.parseInt(text.substring(pos, text.indexOf(" ", pos)));

        pos += ("" + x).length() + 1;

        while (text.charAt(pos) < 0 || text.charAt(pos) > 9) {
            pos++;
        }

        Integer y = Integer.parseInt(text.substring(pos, text.indexOf(" ", pos)));

        while (text.charAt(pos) < 0 || text.charAt(pos) > 9) {
            pos++;
        }

        pos = text.indexOf("\n", pos) + 1;

        Integer depth = Integer.parseInt(text.substring(pos, text.indexOf(" ", pos)));

        pos = text.indexOf("\n", pos) + 1;

        return new ECBufferedImage(x, y, ECBufferedImage.TYPE_INT_RGB);

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
