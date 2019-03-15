/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package com.javafx.experiments.importers.maya.values.impl;

import java.util.Iterator;
import com.javafx.experiments.importers.maya.types.MBoolType;
import com.javafx.experiments.importers.maya.values.MBool;

public class MBoolImpl extends MDataImpl implements MBool {

    private boolean value;

    public MBoolImpl(MBoolType type) {
        super(type);
    }

    public void set(boolean value) {
        this.value = value;
    }

    public boolean get() {
        return value;
    }

    public void parse(Iterator<String> values) {
        String val = values.next();
        if (val.equals("yes") ||
                val.equals("true")) {
            value = true;
        } else {
            value = false;
        }
    }

    public String toString() {
        String result = getType().getName();
        result += " " + value;
        return result;
    }
}
